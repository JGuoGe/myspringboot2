package com.guo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
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
	DataSource dataSource;
	@Test
	public void contextLoads() {
		//org.apache.tomcat.jdbc.pool.DataSource
//		System.out.println(dataSource.getClass());
//
//		Connection connection = dataSource.getConnection();
//		System.out.println(connection);
//		connection.close();
	}

}
