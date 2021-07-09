<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.sql.*, javax.sql.*,java.io.*"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.*" %>
<%@ page import="kr.ac.kopo.kopo42.board.domain.*" %>
<%@ page import="kr.ac.kopo.kopo42.board.dao.*" %>
<%@ page import="kr.ac.kopo.kopo42.board.service.*" %>

<html lang="en">
<head>
  <link rel="stylesheet" href="resources/css/blue.css" />
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script language="JavaScript">
  
    function submitForm(mode){
        fm.action = "create.jsp?key=INSERT";
        fm.submit();
    }
    
    $(document).ready(function() {
    	$('#content').on('keyup', function() {
        	$('#content_cnt').html("("+$(this).val().length+" / 1000)");
 
        if($(this).val().length > 1000) {
            $(this).val($(this).val().substring(0, 1000));
            $('#content_cnt').html("(100 / 100)");
        }
    	});
	});

  </script>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>글쓰기</title>
</head>
<body>
	<%
	  BoardItemService boardItemService = new BoardItemServiceImpl();
	  int newID = boardItemService.newID();
	  
		String date = "";
		Date nowTime = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		date = sdf.format(nowTime);
	%>
  <div class="maindiv" style="margin-top:15%;">
  <form action = "create.jsp" method="POST" name="fm">
    <table width=650 border=1 cellspacing=0 cellpadding=5 class="maintable">
      <tr>
        <th width = 50><b>ID</b></th>
        <td colspan = "2"><input type="text" name="id" size=50 maxlength="1000"
          value='<%= newID %>' readonly></td>
      </tr>
      <tr>
        <th width = 50><b>Title</b></th>
        <td colspan = "2"><input type="text" name="title" size="70" maxlength="70"></td>
      </tr>
      <tr>
        <th width = 50><b>Date</b></th>
        <td colspan = "2"><%= date %>
        <input type="hidden" name="date" size=50 maxlength="70"
          value='<%= date %>' readonly></td>
      </tr>
      <tr>
        <td colspan="3" height=auto>
          <div style="height: auto; background: #efefef;">
            <textarea cols="86" rows="20" name="content"></textarea>
          </div>
          </td>
      </tr>
    </table>
    <table width=650 style="margin-right: auto; margin-left: auto;">
      <tr>
        <td width=500 style="border: none;"><a href="list.jsp?page=1" class="bluebutton" style="margin-left:100;
  	margin-top:100">Home</a></td>
        <td height=140 style="border: none; border-collapse: collapse; text-align: right;">
        <a href="#" onclick="submitForm('write')" class="bluebutton">Done</a></td>
        <td height=10 style="border: none; border-collapse: collapse; text-align: right;">
        <a href="javascript:history.back();" class="bluebutton">Back</a></td>
      </tr>
    </table>
  </form>
  
  <form method="post">

  <label>제목</label>
  <input type="text" name="title" /><br />
  
  <label>작성자</label>
  <input type="text" name="id" /><br />
  
  <label>내용</label>
  <textarea cols="50" rows="5" name="content"></textarea><br />
  
  <button type="submit">작성</button>
</form>


  </div>
</body>
</html>