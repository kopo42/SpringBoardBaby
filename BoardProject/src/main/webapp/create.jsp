<meta http-equiv="Content-Type" content="text.html; charset=utf-8"/>
<%@ page contentType="text/html; charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ page import="java.sql.*, javax.sql.*,java.io.*"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.*" %>
<%@ page import="java.util.Date" %>
<%@ page import="board.domain.*" %>
<%@ page import="board.dao.*" %>
<%@ page import="board.service.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>새 글 작성</title>
  <link rel="stylesheet" href="resources/css/blue.css" />
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script language="JavaScript">
    
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
  <div class="maindiv">
  <%
  BoardItemService boardItemService = new BoardItemServiceImpl();
  BoardItem itemToInsert = new BoardItem();
  
    int _id = Integer.parseInt(request.getParameter("id")); 
    String _title = request.getParameter("title");
    String _date = request.getParameter("date");
    String _content = request.getParameter("content");

    String date_now = "";

    Date nowTime = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    date_now = sdf.format(nowTime);

    if (_date == null || _date.equals("null")){
      _date = date_now;
    }
    
    itemToInsert.setId(_id);
    itemToInsert.setTitle(_title);
    itemToInsert.setContent(_content);
    itemToInsert.setDate(_date);
    
    boardItemService.create(itemToInsert);
    
    String link_update = "update.jsp?id=" + _id;
  %>
</body>
<form method="POST" name="fm">
    <table width=650 border=1 cellsapcing=0 cellpadding=5 class="maintable">
      <tr>
        <th align = left colspan="2">Contents</th>
      </tr>
      <tr>
        <td colspan="2"><h3><%= _title%></h3></td>
      </tr>
      <tr>
        <td align="left"><b>ID: </b><%= _id %>
        <input type="hidden" value='<%= _id %>' id="name" name="id"></td>
      </tr>
      <tr>
        <td align="left" colspan="2"><%= _date %></td>
      </tr>
      <tr>
        <td colspan="2" height=auto>
          <div style="height: auto;">
            <%= _content %>
          </div>
        </td>
      </tr>
    </table>
    <table width=650 style="margin-left: auto; margin-right: auto;">
      <tr>
        <td width=600 style="border: none;"></td>
        <td height=70 align=center style="border: none; border-collapse: collapse; text-align: right;">
        <a href="list.jsp?page=1" class="bluebutton">List</a></td>
        <td height=70 align=center style="border: none; border-collapse: collapse;">
        <a href="#" onclick="location.href='<%= link_update %>'" class="bluebutton">Edit</a></td>
        <td height=70 align=center style="border: none; border-collapse: collapse; text-align: left;">
        <a href="delete.jsp" class="bluebutton">Delete</a></td>
      </tr>
    </table>
  </form>
  </div>
</html>