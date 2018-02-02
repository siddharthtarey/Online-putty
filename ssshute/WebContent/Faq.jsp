<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
response.setHeader("Pragma","no-cache"); // HTTP 1.0
response.setHeader("Cache-Control","no-store"); // HTTP 1.1
response.setDateHeader("Expires", 0);
%> 


<%@include file="/Header.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>Frequently Asked Questions</title>
  <meta name="description" content="">
  <meta name="keywords" content="">
  <meta http-equiv="Content-Type"
 content="text/html; charset=iso-8859-1">
  <link href="css/style.css" rel="stylesheet" type="text/css">
</head>

<body>
<div class="page-out">
<div class="page">
<div class="content">
<div class="left-out">
<div class="left-in">
<div class="left-panel">
<h1 class="title">SshShoot.com Web SSH Client <span>FAQ</span></h1>
<p><i><b>"Is the system secure?"</b></i></p><br />
<p>
All communication between your browser and our webserver is through 128-bit SSL encryption.  Communication
from our server to your server is via a standard SSH client.  See our <a href="#">security</a>
page for more details.
</p><br />


<p><i><b>"Do you store my server passwords?"</b></i></p><br />
<p>
	We don't store your server passwords.  You still need to type your username and password every time you
	login to your server, just like you	would if using a desktop SSH client.
</p><br />

<p><i> <b>"Is my traffic logged?"</b> </i></p><br />
<p>
	We only store standard HTTP request logs.  Our logs do not contain any of your sensitive data.
</p><br />

<p><i> <b>"What information do you store?"</b> </i></p><br />
<p>
  When you create an account, we store your GotoSSH username and email 
address in our system.  We don't store usernames and passwords to your 
servers.
</p><br />
  
<p>
  In order to establish an SSH connection to your computer, we also need
 your externally available IP address (or domain name) and a port.  We
  cannot access servers on your internal network with IP addresses such 
as 192.168.0.1.
  For convenience, we store a list of servers that you access with your 
account.  We do not store login credentials for your servers.
</p><br />

<p><i> <b>"How much does it cost?"</b> </i></p><br />
<p>
It's Free of Cost.</li>
	</p><br />

</div>
</div>
</div>
</div>
</div>
</div>
</body>

<%@include file="/Footer.jsp" %>