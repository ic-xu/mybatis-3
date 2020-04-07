package com.test;

import com.test.mapper.TestMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class TestMain {

  public static void main(String[] args) throws IOException {
    String resource = "classpath:mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);

    /**
     * 通过配置文件初始化一个DefaultSqlSessionFactory的SqlSessionFactory实列
     */
    SqlSessionFactory sqlSessionFactory =
      new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession sqlSession = sqlSessionFactory.openSession();

    //获取mapper对象
    sqlSession.getMapper(TestMapper.class);


  }
}
