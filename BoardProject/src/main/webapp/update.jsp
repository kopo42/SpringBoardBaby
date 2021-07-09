<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.sql.*, javax.sql.*,java.io.*"%>
<%@ page import="java.util.*" %>
<%@ page import="board.domain.*" %>
<%@ page import="board.dao.*" %>
<%@ page import="board.service.*" %>
<html lang="en">
<head>
  <link rel="stylesheet" href="resources/css/blue.css" />
  <script language="JavaScript">
    function submitForm(mode){
      if(mode == "write"){
        fm.action = "create.jsp";
      } else if(mode=="delete"){
        fm.action = "delete.jsp";
      }
      fm.submit();
    }
  </script>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>글 수정</title>
</head>
<body>
	<%
	    int _id = 0;
	    _id = Integer.parseInt(request.getParameter("id"));
	    String _title = "데이터 없음";
	    String _date = "데이터 없음";
	    String _content = "데이터 없음";
	    
	    BoardItemService boardItemService = new BoardItemServiceImpl();
	    BoardItem boardItem = boardItemService.selectOne(_id);
	    
	    _title = boardItem.getTitle();
	    _date = boardItem.getDate();
	    _content = boardItem.getContent();
	    
  	%>
  	<div class="maindiv" style="margin-top:15%;">
  <form method="POST" name="fm">
    <table width=650 border=1 cellspacing=0 cellpadding=5 class="maintable">
      <tr>
        <th width = 50><b>ID</b></th>
        <td colspan = "2"><input type="text" name="id" size=50 maxlength="1000"
          value='<%= _id%>' readonly></td>
      </tr>
      <tr>
        <th width = 50><b>제목</b></th>
        <td colspan = "2"><input type="text" name="title" size=50 maxlength="50"
          value="<%= _title %>"></td>
      </tr>
      <tr>
        <th width = 50><b>작성일</b></th>
        <td colspan = "2"><%= _date %>
        <input type="hidden" name="date" size=50 maxlength="70"
          value='<%= _date %>' readonly></td>
      </tr>
      <tr>
        <td colspan="3" height=auto>
          <div style="height: auto; background: #efefef;">
            <textarea cols="86" rows="20" name="content" value='<%= _content %>'><%= _content %>
            </textarea>
          </div>
          </td>
      </tr>
      <tr>
        <td width=500 style="border: none;">
        <a href="list.jsp?page=1" align=center class="bluebutton" style="margin-left:100;
  	margin-top:100">Home</a></td>
        <td width=140 height=50 align=right style="border: none; border-collapse: collapse;">
        <a href="#" onclick="submitForm('write')" class="bluebutton">Done</a></td>
        <td width=10 height=50 align=right style="border: none; border-collapse: collapse;">
        <a href="javascript:history.back();" class="bluebutton">Back</a></td>
      </tr>
    </table>
  </form>
  </div>
</body>
</html>