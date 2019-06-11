package com.guo;

import com.guo.bean.Employee;
import com.guo.mapper.EmployeeMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import javax.sql.DataSource;

import java.io.File;
import java.sql.Connection;

/**
 * SpringBoot单元测试;
 *
 * 可以在测试期间很方便的类似编码一样进行自动注入等容器的功能
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyspringbootApplicationTests {
	@Autowired
	ApplicationContext ioc;
	@Autowired
	JavaMailSenderImpl mailSender;
//	@Autowired
//	DataSource dataSource;
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	StringRedisTemplate stringRedisTemplate;  //操作k-v都是字符串的
	@Autowired
	RedisTemplate redisTemplate;  //k-v都是对象的
	@Autowired
	RedisTemplate<Object, Employee> empRedisTemplate;
	/**
	 * Redis常见的五大数据类型
	 *  String（字符串）、List（列表）、Set（集合）、Hash（散列）、ZSet（有序集合）
	 *  stringRedisTemplate.opsForValue()[String（字符串）]
	 *  stringRedisTemplate.opsForList()[List（列表）]
	 *  stringRedisTemplate.opsForSet()[Set（集合）]
	 *  stringRedisTemplate.opsForHash()[Hash（散列）]
	 *  stringRedisTemplate.opsForZSet()[ZSet（有序集合）]
	 */
	@Test
	public void test01(){
		//给redis中保存数据
		stringRedisTemplate.opsForValue().append("msg","hello");
		String msg = stringRedisTemplate.opsForValue().get("msg");
		System.out.println(msg);

		stringRedisTemplate.opsForList().leftPush("mylist","1");
		stringRedisTemplate.opsForList().leftPush("mylist","2");

		stringRedisTemplate.opsForValue().append("wjg","你好啊");
		String wjg = stringRedisTemplate.opsForValue().get("wjg");
		System.out.println(wjg);

	}

	//redis测试保存对象
	@Test
	public void test02(){
		Employee empById = employeeMapper.getEmpById(1);
//		默认如果保存对象，使用jdk序列化机制，序列化后的数据保存到redis中
//		redisTemplate.opsForValue().set("emp-01",empById);
//		1、将数据以json的方式保存
			//(1)自己将对象转为json
//			(2)redisTemplate默认的序列化规则；改变默认的序列化规则，使用自定义的redisTemplate
		empRedisTemplate.opsForValue().set("emp-01",empById);
	}

	@Test
	public void testSimpleMail() {
		SimpleMailMessage message = new SimpleMailMessage();
		//邮件设置
		message.setSubject("通知-今晚开会");
		message.setText("今晚7:30开会");

		message.setTo("1752@163.com");
		message.setFrom("6094@qq.com");

		mailSender.send(message);
	}

	@Test
	public void testMail() throws  Exception{
		//1、创建一个复杂的消息邮件
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		//邮件设置
		helper.setSubject("通知-今晚开会");
		helper.setText("<b style='color:red'>今天 7:30 开会</b>",true);

		helper.setTo("1712@163.com");
		helper.setFrom("534094@qq.com");

		//上传文件
		helper.addAttachment("1.jpg",new File("C:\\Users\\lfy\\Pictures\\Saved Pictures\\1.jpg"));
		helper.addAttachment("2.jpg",new File("C:\\Users\\lfy\\Pictures\\Saved Pictures\\2.jpg"));

		mailSender.send(mimeMessage);

	}
	
	@Test
	public void contextLoads() {
		//org.apache.tomcat.jdbc.pool.DataSource
//		System.out.println(dataSource.getClass());
//		Connection connection = dataSource.getConnection();
//		System.out.println(connection);
//		connection.close();
	}

}
