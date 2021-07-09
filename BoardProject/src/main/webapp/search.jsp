<meta http-equiv="Content-Type" content="text.html; charset=utf-8" />
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.sql.*, javax.sql.*,java.io.*"%>
<%@ page import="java.sql.*,java.text.SimpleDateFormat,java.util.Date"%>
<%@ page import="java.util.*" %>
<%@ page import="board.domain.*" %>
<%@ page import="board.dao.*" %>
<%@ page import="board.service.*" %>

<html lang="en">
<head>
  <!-- bootstrap link for pagination -->
  <!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> -->

  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="resources/css/blue.css" />
  <title>공지사항 목록</title>

</head>
<body>
  <div class="maindiv" style="margin-top: 10%;">
    <table width=600 class="maintable">
      <tr>
        <th width=50><p align=center>No.</p></th>
        <th width=500><p align=center>Title</p></th>
        <th width=100><p align=center>Date</p></th>
      </tr>
      <%

      String _key = request.getParameter("key");
      
      BoardItemService boardItemService = new BoardItemServiceImpl();
      List<BoardItem> searchItems = boardItemService.search(_key);
      request.setAttribute("boardItems", searchItems);
      int totalCnt = boardItemService.getSearchCnt(_key);
      
      %>
      <h4 style="text-align: center;">"<%= _key%>" 검색 결과: <%= totalCnt%>건</h4>
      <%
        Date nowTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date_now = "";
        date_now = sdf.format(nowTime);
        
        int _id = 0;
        
        for(BoardItem boardItem: searchItems) {
	      	_id = boardItem.getId();
	        String _title = boardItem.getTitle();
	        String _date = boardItem.getDate();
	        
	        String _inputTag = "<input type='hidden' name='id' value='" + _id + "'>";
	        
	        out.println("<tr>");
	        out.println("<td width=50><p align=center>" + _id + "</p>" + _inputTag + "</td>");
	        
		        if(_date.equals(date_now)){
		          out.println("<td width=500><p align=center><a href='view.jsp?id=" + _id + "'>"
		                    + _title + " (new)</a></p></td>");
		                    } else {
		                      out.println("<td width=500><p align=center><a href='view.jsp?id=" + _id + "'>"
		                    + _title + "</a></p></td>");
		        }
	        out.println("<td width=100><p align=center>" + _date +"</p></td>");
	
	        out.println("</tr>");
        }

        
      %>
    </table>
     <form action = "search.jsp" 
          onsubmit = 'this.action = this.action + "?key=" + this.key.value; this.submit();'
          method="post" style="margin-top: 40; margin-left: 270">
            <input type="text" name="key" placeholder="Search">
            <input type="submit" value="Go">
          </form>
          <div style="margin-left: 330; margin-top: 40;">
          <a href="list.jsp?page=1" class="bluebutton">Home</a>
          </div>

</div>
</body>
</html>