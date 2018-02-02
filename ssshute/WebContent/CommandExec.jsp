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
<script type="text/javascript">
		function func()
		{
			var a=document.getElementById('cmd');
			document.getElementById('topmost').innerHtml=a.value;
		}
		
		
</script>
<%
	String answer=(String)request.getAttribute("answer");
	if(answer == null)
		answer="";
	HttpSession ses=request.getSession(true);
	Boolean attribute = (Boolean)ses.getAttribute("LOG");
	if(attribute == null || !attribute)
	{
		request.setAttribute("message","You are not Logged-IN");
		RequestDispatcher rd1=request.getRequestDispatcher("/Login.jsp");
		rd1.forward(request, response);
	}
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
<form id="fm-form" method="post" action="ComServlet">
<fieldset>
<legend>Terminal</legend>
<div class="fm-req">
<label for="cmd">Command:</label>
<textarea style="overflow:auto;resize:none" cols="15" rows="8" name="cmd" id="cmd" ></textarea>
</div>
<div id="fm-submit" class="fm-req">
<input style="width:100px" type="submit" value="execute" onclick="return func();"></input>
</div>
</fieldset>

<div class="fm-req">
<label for="output">Output:</label>
<textarea readonly="readonly" name="output" style="overflow:auto;resize:none" cols="25" rows="8" id="output"><%=answer %></textarea>
</div>
</form>
</div>

<link href="css/style.css" rel="stylesheet" type="text/css"/>

</div>
</div>
</div>

</div>
</div>
</div>
</body>

<%@include file="/Footer.jsp" %>
</html>