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
    //window.navigate("Login.jsp");
</SCRIPT>
</head>
<%
	RequestDispatcher rd=null;	
String message=(String)request.getAttribute("message");
	if(message == null)
		message="";
	Boolean reg = (Boolean)request.getAttribute("reg");
	Boolean L = (Boolean)request.getAttribute("LOGGED");
	if(reg ==null || L==null)
	{
		reg=false;L=false;
	}
	else if(L && reg)
	{
		rd=request.getRequestDispatcher("/Connection.jsp");
		rd.forward(request,response);
	}
	else if(L && !reg)
	{
		rd=request.getRequestDispatcher("/Code.jsp");
		rd.forward(request,response);
	}
	

%>
<body onload="noBack();" onpageshow="if (event.persisted) noBack();" onunload="">
<div class="page-out">
<div class="page">
<div class="content">
<div class="left-out">
<div class="left-in">
<div class="left-panel">

<p align="center" style="font-size:15px">
If you have a SshShoot.com accout, login now.<br />
If you don't have an account, you can <a href="Signup.jsp">sign up</a> now.
</p> 	
<link href="css/cssform.css" rel="stylesheet" type="text/css"/>
<div id="container">
<form id="reg" name="reg" method="post" action="LoginServlet" onsubmit="return check();">
<fieldset>
<legend>Login</legend>
<%=message %>
<div class="fm-req">
<label for="uname">Email (User Name):</label>
<input name="uname" id="uname" type="text"/>
</div><br />
<div class="fm-req">
<label for="pwd">Password:</label>
<input name="pwd" id="pwd" type="password"/>
</div>
</fieldset>
<div id="fm-submit" class="fm-req">
<input name="Submit" value="Submit" type="submit"/><br/>
<a href="Forgot.jsp">Forgot Password???</a>
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
<script type="text/javascript">
	
	function check(){
		
		var fname=document.forms["reg"]["uname"].value;
		var pwd1=document.forms["reg"]["pwd"].value;
		

		
		
		
	 if((fname==null || fname=="")){ 

			alert("Fill email-id ");
			
			return false;
				
		}
		else if((pwd1==null || pwd1=="")){ 

			alert("Fill Password");
			
			return false;
				
		}

	
	
		if(pwd1!=pwd2){
			
			alert("passwords not matching");
			
			return false;
			
		}
	
		else{
			
			return true;
			
		}
	}
	

	
</script>
<%@include file="/Footer.jsp" %>
</html>