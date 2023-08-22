package org.sp.mybatisapp.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test {
	
	public Test() {
		//클래스가 아닌 한 패키지가 아닌 디렉토리 /로 표기
		String resource = "org/sp/mybatisapp/mybatis/config.xml";
	
		//xml의 내용을 해석하기위해 아래의 코드가 동작
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			
			//xml 해석 결과로 SqlSessionFactory가 반환
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
			
			//팩토리로부터 쿼리문 수행 객체인 sqlSession 하나 얻기
			SqlSession session=factory.openSession();
			
			System.out.println(session);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Test();
	}
}
