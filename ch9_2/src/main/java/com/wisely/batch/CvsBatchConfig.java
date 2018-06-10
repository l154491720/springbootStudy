package com.wisely.batch;

import javax.sql.DataSource;
import com.wisely.domain.Person;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.validator.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;



/**
 * 配置类
 * Created by qilin.liu on 2018/6/10.
 */
@Configuration
@EnableBatchProcessing
public class CvsBatchConfig {


    @Bean
    public ItemReader<Person> reader()throws Exception{
        //1 使用FlatFileItemReader读取文件
        FlatFileItemReader<Person> reader = new FlatFileItemReader<Person>();
        //2 使用FlatFileItemReader的setResource方法设置csv文件的路径
        reader.setResource(new ClassPathResource("people.csv"));
        //3 在此对csv文件的数据和实体类做对应的映射
        reader.setLineMapper(new DefaultLineMapper<Person>(){{
            setLineTokenizer(new DelimitedLineTokenizer(){{
                setNames(new String[] {"name","age","nation","address"});
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<Person>(){{
                setTargetType(Person.class);
            }});
        }});
        return reader;
    }

    @Bean
    public ItemProcessor<Person,Person> processor(){
        //1 使用我们自己定义的CsvItemProcessor实现ItemProcessor
        CsvItemProcessor processor = new CsvItemProcessor();
        //2 为processor指定校验器CsvBeanValidator
        processor.setValidator(csvBeanValidator());
        return processor;
    }


    //1 Spring能让容器中已有的Bean已参数形式注入,Spring Boot已为我们定义了dataSource
    @Bean
    public ItemWriter<Person> writer(DataSource dataSource1){
        //2 我们使用JDBC批处理的jdbcBatchItemWriter来写到数据库
        JdbcBatchItemWriter<Person> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Person>());
        String sql = "insert to person "+" (id,name,age,nation,adress)" +
                " values(hibernate_sequence.nextval, :name, :age, :nation, :address)";
        //3 在此设置要批量处理的SQL语句
        writer.setSql(sql);
        writer.setDataSource(dataSource1);
        return writer;
    }

    /**
     * jobRepository的定义需要dataSource和transactionManager,Spring boot已为我们自动配置了这两个类，
     * Spring可通过方法注入已有的Bean
     */
    @Bean
    public JobRepository jobRepository(DataSource dataSource1, PlatformTransactionManager transactionManager)
            throws Exception{

        JobRepositoryFactoryBean jobRepositoryFactoryBean = new JobRepositoryFactoryBean();
        jobRepositoryFactoryBean.setDataSource(dataSource1);
        jobRepositoryFactoryBean.setTransactionManager(transactionManager);
        jobRepositoryFactoryBean.setDatabaseType("oracle");
        return jobRepositoryFactoryBean.getObject();
    }

    @Bean
    public SimpleJobLauncher jobLauncher(DataSource dataSource1,PlatformTransactionManager transactionManager)
            throws Exception{
        SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
        jobLauncher.setJobRepository(jobRepository(dataSource1,transactionManager));
        return jobLauncher;
    }

    @Bean
    public Job importJob(JobBuilderFactory job, Step s1){
        return job.get("importJob").incrementer(new RunIdIncrementer())
                .flow(s1) //1 为Job指定Step
                .end()
                .listener(csvJobListener()) //2 绑定监听器
                .build();
    }

    @Bean
    public Step step1(StepBuilderFactory stepBuilderFactory,
                      ItemReader<Person> reader, ItemWriter<Person> writer,
                      ItemProcessor<Person,Person> processor){
        return stepBuilderFactory.get("step1")
                .<Person,Person>chunk(65000)//1 批量处理每次提交65000条数据
                .reader(reader)//2 给step绑定reader
                .processor(processor)//3 给step绑定processor
                .writer(writer)//4 给stop绑定writer
                .build();
    }

    @Bean
    public CvsJobListener csvJobListener() {
        return new CvsJobListener();
    }


    private Validator<? super Person> csvBeanValidator() {
        return new CvsBeanValidator<Person>();
    }

}
