<%@include file="/Header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%
response.setHeader("Pragma","no-cache"); // HTTP 1.0
response.setHeader("Cache-Control","no-store"); // HTTP 1.1
response.setDateHeader("Expires", 0);
%> 
<head>
  <title>Welcome to our site</title>
 

  <link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<%
	String message=(String)request.getAttribute("message");
	if(message == null){
	    message = "";
	}
	String name=(String) request.getAttribute("name");
%>
<body>
<div class="page-out">
<div class="page">
<div class="content">
<div class="left-out">
<div class="left-in">
<div class="left-panel">

	
<link href="css/cssform.css" rel="stylesheet" type="text/css"/>
<div id="container">
<form  method="post" action="VerServlet">
<fieldset>
<legend>Verify</legend>
<%=message %>
<br />
<div class="fm-req">
<label for="uname">Email id:</label>
<input name="email" id="email" type="text" value="<%= name%>"/>
</div><br />

<div class="fm-req">
<label for="code">Verification Code:</label>
<input name="code" id="code" type="text"/>
</div><br />
<div id="fm-submit" class="fm-req">
<input name="Submit" value="Submit" type="submit"/><br/>
<!--  <a href="Login.jsp"></a>-->
</div>
</fieldset>
</form>
</div>

<link href="css/style.css" rel="stylesheet" type="text/css" />

</div>
</div>
</div>

</div>
</div>
</div>
</body>
<%@include file="/Footer.jsp" %>
</html>