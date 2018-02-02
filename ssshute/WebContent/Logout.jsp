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
  <meta name="description" content="">
  <meta name="keywords" content="">
  <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
  <link href="css/style.css" rel="stylesheet" type="text/css">
  <SCRIPT type="text/javascript">
    window.history.forward();
    function noBack() { window.history.forward(); }
    window.navigate("Login.jsp");
</SCRIPT>
</head>

<BODY onload="noBack();" onpageshow="if (event.persisted) noBack();" >


<div class="page-out">
<div class="page">
<div class="content">
<div class="left-out">
<div class="left-in">
<div class="left-panel">

<p align="center" style="font-size:15px">
<br/><br/><br/><br/>
<h1>TO LOG OUT COMPLETELY CLICK THE LINK BELOW</h1><a href="Login.jsp" >Logout Completely</a><br />

</p> 	
<link href="css/cssform.css" rel="stylesheet" type="text/css"/>
<div id="container">

</div>

<link href="css/style.css" rel="stylesheet" type="text/css">

</div>
</div>
</div>

</div>
</div>
</div>
</body>