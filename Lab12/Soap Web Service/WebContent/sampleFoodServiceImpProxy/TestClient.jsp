<%@page contentType="text/html;charset=UTF-8"%><HTML>
<HEAD>
<TITLE>Web Services Test Client</TITLE>
<LINK href="pre-loader.css" rel="stylesheet" />
    <link href="bootstrap3/css/bootstrap.css" rel="stylesheet" />
    <link href="assets/css/ct-paper.css" rel="stylesheet"/>
    <link href="assets/css/demo.css" rel="stylesheet" /> 
    <link href="assets/css/examples.css" rel="stylesheet" /> 
    <script src="assets/js/jquery-1.10.2.js" type="text/javascript"></script>
    <script src="assets/js/jquery-ui-1.10.4.custom.min.js" type="text/javascript"></script>
    
    <script src="bootstrap3/js/bootstrap.js" type="text/javascript"></script>
    <script src="pre-loader.js" type="text/javascript"></script>
    
    <!--  Plugins -->
    <script src="assets/js/ct-paper-checkbox.js"></script>
    <script src="assets/js/ct-paper-radio.js"></script>
    <script src="assets/js/bootstrap-select.js"></script>
    <script src="assets/js/bootstrap-datepicker.js"></script>
    
    <script src="assets/js/ct-paper.js"></script>
</HEAD>
<FRAMESET  COLS="220,*">
<FRAME SRC="Method.jsp" NAME="methods" MARGINWIDTH="1" MARGINHEIGHT="1" SCROLLING="yes" FRAMEBORDER="1">
<FRAMESET  ROWS="80%,20%">
<FRAME SRC="Input.jsp" NAME="inputs"  MARGINWIDTH="1" MARGINHEIGHT="1" SCROLLING="yes" FRAMEBORDER="1">
<%
StringBuffer resultJSP = new StringBuffer("Result.jsp");
resultJSP.append("?");
java.util.Enumeration resultEnum = request.getParameterNames();while (resultEnum.hasMoreElements()) {
Object resultObj = resultEnum.nextElement();
resultJSP.append(resultObj.toString()).append("=").append(request.getParameter(resultObj.toString())).append("&");
}
%>
<FRAME SRC="<%=org.eclipse.jst.ws.util.JspUtils.markup(resultJSP.toString())%>" NAME="result"  MARGINWIDTH="1" MARGINHEIGHT="1" SCROLLING="yes" FRAMEBORDER="1">
</FRAMESET>
<NOFRAMES>
<BODY>
The Web Services Test Client requires a browser that supports frames.
</BODY>
</NOFRAMES>
</FRAMESET>
</HTML>