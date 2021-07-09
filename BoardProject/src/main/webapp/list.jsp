<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.sql.*,java.text.SimpleDateFormat,java.util.Date"%>
<%@ page import="java.util.*" %>
<%@ page import="board.domain.*" %>
<%@ page import="board.dao.*" %>
<%@ page import="board.service.*" %>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="resources/css/blue.css" />
  <title>공지사항</title>

</head>
<body>
  <%
  int board_id = 1;
  //int board_id = request.getAttribute("board_id");
  %>
  
  <%-- <c:forEach var="boardItem" items="${boardItems}">

    <p><c:out value="${boardItem.title}" /></p>

  </c:forEach> --%>
  
  <div class="maindiv" style="margin-top: 10%;">
    <img src="resources/images/classics-statue2.png" style="position:relative; left: 50%; width: 200px;">
    <table width=600 class="maintable">
      <tr>
        <th width=50><p align=center>No.</p></th>
        <th width=500><p align=center>Title</p></th>
        <th width=100><p align=center>Date</p></th>
      </tr>
      
      <%
      
      String pagestr = request.getParameter("page");
      if(pagestr == null){
    	  pagestr = "1";
      }
      int _page = Integer.parseInt(pagestr);
      
      BoardItemService boardItemService = new BoardItemServiceImpl();
      List<BoardItem> boardItems = null;
      List<Integer> pageData = boardItemService.getPage(_page);
      request.setAttribute("boardItems", boardItems);
      
		int pageSize = pageData.get(0); int count = pageData.get(1);
		//int totalPage = pageData.get(2); int startPage = pageData.get(3);
		//int endPage = pageData.get(4); int row_end = pageData.get(5);
		//int row_start = pageData.get(6);

      	int rowSize = 10;
      	
      	int startRow = count - ((_page - 1) * pageSize);
      	int endRow = startRow - (pageSize - 1);
      	
      	if(count > 0){
      		boardItems = boardItemService.selectAll(startRow, endRow);
      	}

        Date nowTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date_now = "";
        date_now = sdf.format(nowTime);
        int _id = 0;
        
        if(count > 0){
        	int number = count - (_page - 1) * pageSize; //글 번호 순번
        	
        	//BoardItem boardItem: boardItems
        	for(BoardItem boardItem: boardItems) {
    	      	_id = boardItem.getId();
    	        String _title = boardItem.getTitle();
    	        String _date = boardItem.getDate();
    	        
    	        String _inputTag = "<input type='hidden' name='id' value='" + _id + "'>";
    	        
    	        out.println("<tr>");
    	        out.println("<td width=50><p align=center>" + _id + "</p>" + _inputTag + "</td>");
    	        
    		        if(_date.equals(date_now)){
    		          out.println("<td width=500><p align=center><a href='view.jsp?page=" + _page + "&id=" + _id + "'>"
    		                    + _title + " (new)</a></p></td>");
    		                    } else {
    		                      out.println("<td width=500><p align=center><a href='view.jsp?page=" + _page + "&id=" + _id + "'>"
    		                    + _title + "</a></p></td>");
    		        }
    	        out.println("<td width=100><p align=center>" + _date +"</p></td>");
    	
    	        out.println("</tr>");
            }
        }
      %>
      
    </table>
    
  <table width=650 style="border: none; border-collapse: collapse; margin-left: auto; margin-right: auto;">
    <tr>
      <td width=550 style="border: none; border-collapse: collapse;">
      <ul style="padding-left:220; margin-left: auto;">
          <%
          if(count > 0){
        	  int pageCnt = count / pageSize + (count % pageSize == 0 ? 0 : 1);
        	  //한 페이지에 보여줄 개수
        	  int pageBlock = 10; //번호 부분
        	  //1~10, 11~20...
        	  int startPage = ((_page - 1) / pageBlock) * pageBlock + 1;
        	  int endPage = startPage + pageBlock - 1;
        	  
        	  if(endPage > pageCnt){
        		  endPage = pageCnt;
        	  }
        	 
        	  if(startPage > pageBlock){
                  %>

                  <a href = "list.jsp?page=1">&laquo</a>
                  <a href = "list.jsp?page=<%= startPage - pageBlock%>">previous</a>

                  <%
        	  }
          
          		for(int i = startPage; i <= endPage; i++){
            	if(i == _page){
          %>
          
          <u><b><%= i %></b></u>
          
          <%
            } else{
          %>
          
          <a href="list.jsp?page=<%= i%>"><%= i%></a>
          
          <%
            }
          }
          if(endPage < pageCnt){
          %>
          
          <a href="list.jsp?page=<%= startPage + pageBlock%>">next</a>
          <a href="list.jsp?page=<%= pageCnt%>">&raquo</a>
          
          <%
          	}
          }
          %>
          </ul>
      </td>
      <td height=70 align=center style="border: none; border-collapse: collapse;">
        <a href="insert.jsp" class="bluebutton">Write</a></td>
    </tr>
  </table>
  <form action = "search.jsp?page=1" 
          onsubmit = 'this.action = this.action + "&key=" + this.key.value; this.submit();'
          method="post" style="text-align: center;">
            <input type="text" name="key" placeholder="Search">
            <input type="submit" value="Go">
  </form>
</body>
</html>