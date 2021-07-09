<meta http-equiv="Content-Type" content="text.html; charset=utf-8"/>
<%@ page contentType="text/html; charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ page import="java.sql.*, javax.sql.*,java.io.*"%>
<%@ page import="board.domain.*" %>
<%@ page import="board.dao.*" %>
<%@ page import="board.service.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>삭제</title>
  <script language="JavaScript"></script>
  <link rel="stylesheet" href="resources/css/blue.css" />

  <!--
    function submitForm(mode){
      if(mode == "write"){
        fm.action = "notice_write.jsp";
      } else if(mode == "delete"){
        fm.action = "notice_delete.jsp";
      }
      fm.submit();
    }
    //-->
  </script>
</head>
<body>
  <%
  BoardItemService boardItemService = new BoardItemServiceImpl();

    int _id = Integer.parseInt(request.getParameter("id"));
    String _title = request.getParameter("title");
    String _date = request.getParameter("date");
    String _content = request.getParameter("content");
    
    boardItemService.delete(_id);
  %>
  <table class="maintable">
    <tr><th colspan="2">!</th></tr>
    <tr>
      <td style="border: none; padding: 20px;" align="center" colspan="2"><b><br>삭제가 완료되었습니다</b></td>
    </tr>
    <tr style="border: none;">
      <td width=120 height=70 align=center style="border: none; border-collapse: collapse;">
        <a href="list.jsp?page=1" class="bluebutton">Got it</a></td>
    </tr>
    
  </table>
</body>
</html>