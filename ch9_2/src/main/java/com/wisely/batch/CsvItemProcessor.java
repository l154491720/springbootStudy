package com.wisely.batch;

import com.wisely.domain.Person;
import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidationException;

/**
 * 处理
 * Created by qilin.liu on 2018/6/10.
 */
public class CsvItemProcessor extends ValidatingItemProcessor<Person> {

    @Override
    public Person process(Person item)throws ValidationException{
        //1 需执行super.process(item)才会调用自定义校验器
        super.process(item);

        //2 对数据做简单处理，若名族为汉族，则数据转换成01，其余转换成02
        if(item.getNation().equals("汉族")){
            item.setNation("01");
        }else{
            item.setNation("02");
        }
        return item;
    }
}
