package org.sp.mybatisapp.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.sp.mybatisapp.domain.Board;
import org.sp.mybatisapp.mybatis.MybatisConfig;

public class OracleBoardDAO implements BoardDAO{
	MybatisConfig config=MybatisConfig.getInstance();
	
	
	@Override
	public List selectAll() {
		SqlSession sqlSession=config.getSqlSession();
		List list=sqlSession.selectList("Board.selectAll");
		config.release(sqlSession); //반납
		
		return list;
	}

	@Override
	public Board select(int board_idx) {
		SqlSession sqlSession=config.getSqlSession();
		Board board= sqlSession.selectOne("Board.select", board_idx);
		config.release(sqlSession); //반납
		
		return board;
	}

	@Override
	public int insert(Board board) {
		SqlSession sqlSession=config.getSqlSession();
		int result=sqlSession.insert("Board.insert", board);
		sqlSession.commit();
		config.release(sqlSession); //반납
		
		return result;
	}

	@Override
	public int update(Board board) {
		SqlSession sqlSession=config.getSqlSession();
		int result=sqlSession.update("Board.update", board);
		sqlSession.commit();
		config.release(sqlSession); //반납
		
		return result;
	}

	@Override
	public int delete(int board_idx) {
		SqlSession sqlSession=config.getSqlSession();
		int result=sqlSession.delete("Board.delete", board_idx);
		sqlSession.commit();
		config.release(sqlSession); //반납
		
		return result;
	}
	

	
	
}
