<%@include file="/Header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%
response.setHeader("Pragma","no-cache"); // HTTP 1.0
response.setHeader("Cache-Control","no-store"); // HTTP 1.1
response.setDateHeader("Expires", 0);
%> 
<head>
  <title>Sign Up</title>
  <meta name="description" content="">
  <meta name="keywords" content="">
  <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
  <link href="css/style.css" rel="stylesheet" type="text/css">
  <script type="text/javascript">
	
	 	
	function checkb(cb){
  		var t=cb.checked;
		var sbmt=document.getElementById("s1");
  		if(t==true){
  		
  			sbmt.disabled=false;
  		}
  		else{
  			
  			sbmt.disabled=true;
  		}
  	}
  </script>
</head>
<%
RequestDispatcher rd = null;
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

String s=(String)request.getAttribute("message");
if(s==null){
	s="";
	
}

%>
<body>
<div class="page-out">
<div class="page">
<div class="content">
<div class="left-out">
<div class="left-in">
<div class="left-panel">
<h1 class="title">Create <span>Account</span></h1>
<br />
<p align="left">
Signing up for <b>SSHShute.com</b> is quick and easy. Simply provide your basic account information below.<br />  
It's safe and secure. We will <b>never</b> store usernames and
passwords of your remeote linux machine in our system.
</p>
<p align="left">If you already have an account, go to the <a href="Login.jsp">login page</a>.</p>

<link href="css/cssform.css" rel="stylesheet" type="text/css"/>
<div id="container">
<form id="reg" method="post" name="reg" action="RegServlet" onsubmit="return check();">
<fieldset>
<legend>Personal information</legend>
<div align="center" ><h3 style="color:red"><%=s%></h3></div>
<div class="fm-req">
<label for="email">Email (User Name):</label>
<input id="email" name="email" type="text"/>
</div><br />
<div class="fm-req">
<label for="fname">First Name:</label>
<input name="fname" id="fname" type="text"/>
</div>
<div class="fm-req">
<label for="lname">Last Name:</label>
<input name="lname" id="lname" type="text"/>
</div>

<div class="fm-req">
<label for="pwd1">Password:</label>
<input name="pwd1" id="pwd1" type="password"/>
</div>
<div class="fm-req">
<label for="pwd2">Confirm Password:</label>
<input name="pwd2" id="pwd2" type="password"/><br/>
</div>
<br/>

<div class="fm-multi">
<input type="checkbox" id="c1" onchange="checkb(this)" name="agree"/>I Agree To<a href="#" target="_blank"> Terms of Service and Acceptable Use Policy </a>
</div>
</fieldset>
<div id="fm-submit" class="fm-req">
<input name="Submit" value="Register" type="submit" id="s1"/>
<input type="reset" value="Reset"/>
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
		
		var fname=document.forms["reg"]["fname"].value;
		var lname=document.forms["reg"]["lname"].value;
		var email=document.forms["reg"]["email"].value;
		var pwd1=document.forms["reg"]["pwd1"].value;
		var pwd2=document.forms["reg"]["pwd2"].value;
		
		if((fname==null || fname=="")){ 

		alert("fill first name");
	
		return false;
			
		}
		
		else if((lname==null || lname=="")){ 

			alert("fill last name");
			
			return false;
				
		}
		
		else if((email==null || email=="")){ 

			alert("fill email");
			
			return false;
				
		}
		else if((pwd1==null || pwd1=="")){ 

			alert("fill password");
			
			return false;
				
		}

		else if((pwd2==null || pwd2=="")){ 

			alert("fill confirm password");
			
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