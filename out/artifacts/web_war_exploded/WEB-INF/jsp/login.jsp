<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@include file="/WEB-INF/jsp/header_client.jsp"%>

<html>
<body>
<div class="center">
    <form action="/auth?command=${"login"}" method="post">
    <fmt:message key="name"/>
    <input type="text" name="name" required>
    <fmt:message key="pass"/>
    <input type="text" name="pass" required>
    <input type="submit" value="ok">
    </form>
</div>
</body>
</html>
