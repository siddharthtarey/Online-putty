<%@include file="/Header1.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%
response.setHeader("Pragma","no-cache"); // HTTP 1.0
response.setHeader("Cache-Control","no-store"); // HTTP 1.1
response.setDateHeader("Expires", 0);
%> 
<head>
  <title>Welcome to our site</title>
  <meta name="description" content="">
  <meta name="keywords" content="">
  <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
  <link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<%
String message=(String)request.getAttribute("message_error");
if(message==null)
	message="Enter ip and credentials for remote server";
Boolean reg = (Boolean)request.getAttribute("reg");
Boolean L = (Boolean)request.getAttribute("LOGGED");
if(reg == null || !reg && L == null || !L){
	request.setAttribute("message","You are not Logged-IN");
	RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
	rd.forward(request,response);		
}
	%>
<div class="page-out">
<div class="page">
<div class="content">
<div class="left-out">
<div class="left-in">
<div class="left-panel">

	
<link href="css/cssform.css" rel="stylesheet" type="text/css"/>
<div id="container">
<form id="fm-form" method="post" action="ConnectionServlet">
<fieldset>
<legend>Establish Connection With Your Remote Linux Machine</legend>
<%=message %>
<div class="fm-req">
<label for="ip">Connection IP:</label>
<input name="ip" id="ip" type="text"/>
</div>
<div class="fm-req">
<label for="user_remote">Remote User Name:</label>
<input name="user_remote" id="user_remote" type="text"/>
</div><br />
<div class="fm-req">
<label for="pass_remote">Password:</label>
<input name="pass_remote" id="pass_remote" type="password"/>
</div>
</fieldset>
<div id="fm-submit" class="fm-req">
<input name="Submit" value="Connect" type="submit"/><br/>
</div>
</form>
</div>

<link href="css/style.css" rel="stylesheet" type="text/css">

</div>
</div>
</div>

</div>
</div>
</div>
</body>

<%@include file="/Footer.jsp" %>
</html>