<%@page import="org.sp.mybatisapp.repository.OracleBoardDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%! 
	OracleBoardDAO oracleBoardDAO=new OracleBoardDAO();
%>
<%
	//파라미터 받기
	int board_idx=Integer.parseInt(request.getParameter("board_idx"));
	
	//오라클에서 삭제
	int result=oracleBoardDAO.delete(board_idx);
	
	out.print("<script>");
	if(result>0){
		out.print("alert('삭제 성공');");
		out.print("location.href='/board/list.jsp';");
		
	}else{
		out.print("alert('삭제 실패');");
		out.print("history.back();");
	}
	out.print("</script>");
%>