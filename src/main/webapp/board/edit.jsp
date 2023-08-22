<%@page import="org.sp.mybatisapp.repository.OracleBoardDAO"%>
<%@page import="org.sp.mybatisapp.domain.Board"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%! 
	OracleBoardDAO oracleBoardDAO=new OracleBoardDAO();

%>
<%
	//파라미터를 넘겨받기
	request.setCharacterEncoding("utf-8"); //파라미터 받기 전 인코딩 처리
	String title=request.getParameter("title");
	String writer=request.getParameter("writer");
	String content=request.getParameter("content");
	int board_idx=Integer.parseInt(request.getParameter("board_idx"));
	
	//DTO에 담기
	//Board board=new Board();
	//board.setTitle(title);
	//board.setWriter(writer);
	//board.setContent(content);
	//board.setBoard_idx(board_idx);
	
%>
<jsp:useBean id="board" class="org.sp.mybatisapp.domain.Board"/>
<jsp:setProperty property="*" name="board"/>
<%
	//out.print("제목은 "+board.getTitle());

	//오라클에 수정
	int result=oracleBoardDAO.update(board);
	
	out.print("<script>");
	if(result>0){
		out.print("alert('수정 성공');");
		out.print("location.href='/board/content.jsp?board_idx="+board_idx+"';");
		
	}else{
		out.print("alert('수정 실패');");
		out.print("history.back();");
	}
	out.print("</script>");
%>