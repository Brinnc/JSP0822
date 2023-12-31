package org.sp.mybatisapp.repository;

import java.util.List;

import org.sp.mybatisapp.domain.Board;

//Board 테이블에 대한 모든 DAO의 최상위 객체
public interface BoardDAO {
	public List selectAll(); //모든 레코드 가져오기
	
	public Board select(int board_idx); //1건의 레코드 가져오기
	
	public int insert(Board board); //1건넣기
	
	public int update(Board board); //1건수정
	
	public int delete(int board_idx); //1건삭제
}
