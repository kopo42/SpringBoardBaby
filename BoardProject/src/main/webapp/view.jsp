<meta http-equiv="Content-Type" content="text.html; charset=utf-8"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ page import="java.sql.*, javax.sql.*,java.io.*"%>
<%@ page import="java.util.*" %>
<%@ page import="board.domain.*" %>
<%@ page import="board.dao.*" %>
<%@ page import="board.service.*" %>

<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="resources/css/blue.css"/>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script language="JavaScript">
    function submitForm(mode){
      var var_id = $('input[name=id]').val();
      if(mode == "write"){
        fm.action = "write.jsp";
      } else if(mode == "delete"){
        fm.action = "delete.jsp?id=" + var_id;
      }
      fm.submit();
    }
  </script>
  <script type = "text.javasctipt">
	function desplaySet(exe, idx, name, content, cmd){
		obj = document.frm;
		obj.idx.value = idx;
		obj.exe.value = exe;
		obj.name.value = name;
		while(content.indexOf("<br>" != -1){
			content = content.replace("<br>", "\n");
		}
		obj.content.value = content;
		obj.cmd.value = cmd;
	}
	</script>

  <title>공지사항 보기</title>
</head>
<body>
  <%
  int _id = Integer.parseInt(request.getParameter("id"));
  int ref = _id;
  int _page = Integer.parseInt(request.getParameter("page"));
  
  BoardItemService boardItemService = new BoardItemServiceImpl();
  BoardItem boarditem = boardItemService.selectOne(_id);
  
  CommentItemService comItemService = new CommentItemServiceImpl();
  CommentItem comList = comItemService.getOne(ref);
  
  request.setAttribute("boardItem", boarditem);

    String _title = boarditem.getTitle();
    String _date = boarditem.getDate();
    String _content = boarditem.getContent();
    
    out.println(comList.getContent());

    String link_update = "update.jsp?id=" + _id;
  %>
  <div class="maindiv" style="margin-top:15%;">
  <form method="POST" name="fm">
    <table width=650 border=1 cellsapcing=0 cellpadding=5 class="maintable">
      <tr>
        <th align = left colspan="3">Contents</th>
      </tr>
      <tr>
        <td colspan="3"><h3><%= _title%></h3></td>
      </tr>
      <tr>
        <td align="left" colspan="3"><b>ID: </b><%= _id %>
        <input type="hidden" value='<%= _id %>' id="name" name="id"></td>
      </tr>
      <tr>
        <td align="left" colspan="3"><%= _date %></td>
      </tr>
      <tr>
        <td colspan="3" height=auto>
          <div style="height: auto;">
            <%= _content %>
          </div>
        </td>
      </tr>
      <tr style="border: none;">
        <td width=500 height=70 align=left style="border: none; border-collapse: collapse;">
        	<a href="list.jsp?page=1" class="bluebutton">Home</a></td>
        <td width=75 height=70 align=right style="border: none; border-collapse: collapse;">
        	<a href="#" onclick="location.href='<%= link_update %>'" class="bluebutton">Edit</a></td>
        <td width=75 height=70 align=right style="border: none; border-collapse: collapse;">
        	<a href="delete.jsp?id=<%= _id%>" class="bluebutton">Delete</a></td>
      </tr>
    </table>
  </form>
  
  <form action = "commentAction.jsp" method="post" name = "frm">
	  <input type="hidden" name="idx" value="1">
	  <input type="hidden" name="exe" value="1">
	  
	  <input type="hidden" name="page" value='<%= _page%>'>
	  <input type="hidden" name="ref" value='<%= _id%>'>
	  
	  <table style="border-collapse: collpase;">
		  <tr><th>comments</th></tr>
		  <tr>
			  <td>name</td>
			  <td><input type="text" name="name"></td>
			  <td>password</td>
			  <td><input type="password" name="passwd"></td>
		  </tr>
		  <tr>
			  <td colspan="4">
			  <textarea cols="60" rows="5" name="content"></textarea></td>
		  </tr>
		  <tr>
			  <td colspan="4">
			  <input type="submit" value="Done" name="cmd">
			  <input type="reset" value="re">
			  </td>
		  </tr>
	  </table>
  </form>
  
  <c:forEach var="com" items="${comList}">
  <div class="commentList">
  <span class="name">${co.name }</span>
  <span class="wdate">${co.rdate }</span>
  <c:set var="content" value="${co.content }"/>
  <c:set var="content" value="${fn:replace(content, rn, '<br>') }"/>
  <span class="update" >
  <a href = "javascript:displaySet(2, '${co.idx }', '${co.name }', '${content }', 'Edit')">
  Edit</a>
    <a href = "javascript:displaySet(3, '${co.idx }', '${co.name }', '${content }', 'Delete')">
  Delete</a>
  </span>
  <div style="padding-top: 10px">${content }</div>
  </div>
  </c:forEach>
  </div>
</body>
</html>















































