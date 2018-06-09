package com.wisely;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.net.UnknownHostException;
import java.util.Objects;

@SpringBootApplication
public class Ch862Application {

	public static void main(String[] args) {
		SpringApplication.run(Ch862Application.class, args);
	}

	@Bean
	@SuppressWarnings({"rawtypes","unchecked"})
	public RedisTemplate<Object,Object>  redisTemplate(RedisConnectionFactory redisConnectionFactory)
			throws UnknownHostException{
		RedisTemplate<Object,Object> template= new RedisTemplate<Object, Object>();
		template.setConnectionFactory(redisConnectionFactory);

		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);

		//1 设置value的序列化方式采用(Jackson2JsonRedisSerializer)
		template.setValueSerializer(jackson2JsonRedisSerializer);
		//2 设置key的序列化方式采用StringRedisSerializer
		template.setKeySerializer(new StringRedisSerializer());

		template.afterPropertiesSet();
		return template;
	}


}
