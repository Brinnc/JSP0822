package org.sp.mybatisapp.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.sp.mybatisapp.domain.Board;
import org.sp.mybatisapp.mybatis.MybatisConfig;

//오직 Board테이블에 대한 CRUD만을 담당하기 위한 객체
public class MySQLBoardDAO {
	MybatisConfig config=MybatisConfig.getInstance(); //싱클턴으로 생성
	
	//글 등록
	public int insert(Board board) {
		SqlSession sqlSession=config.getSqlSession();
		int result=sqlSession.insert("Board.insert", board);
		System.out.println("쿼리문 수행 결과는 "+result);
		
		//트랜잭션: 하나의 업무를 이루는 DML모두 성공해야 전체를 성공으로 확정짓는 논리적 업무 단위
		sqlSession.commit(); //트랜잭션 완료, 확정 
		
		return result;
	}
	
	//글 목록 조회
	public List selectAll() {
		SqlSession sqlSession=config.getSqlSession();
		List list=sqlSession.selectList("Board.selectAll");
		
		return list;
	}
	
	//글 1건 보기
	public Board select(int board_idx) {
		SqlSession sqlSession=config.getSqlSession();
		return sqlSession.selectOne("Board.select", board_idx);
		
	}
	
	//글 1건 수정
	public int update(Board board) {
		
		return 0;
	}
	
	//글 1건 삭제
	public int delete(int board_idx) {
		
		return 0;
	}
}
