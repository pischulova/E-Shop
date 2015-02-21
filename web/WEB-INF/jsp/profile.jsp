<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${userLocale}" />
<fmt:setBundle basename="resources.bundle"/>

<%@include file="/WEB-INF/layout/header.jsp"%>
<%@include file="/WEB-INF/layout/menu.jsp"%>

<div class="center">
    <fmt:message key="user_info"/><br/><br/>
    <c:choose>
        <c:when test="${sessionScope.isAdmin=='true'}">
            <table>
                <tr>
                    <td><fmt:message key="name"/></td>
                    <td>${user.login}</td>
                </tr>
                <tr>
                    <td><fmt:message key="pass"/></td>
                    <td>${user.password}</td>
                </tr>
            </table>
        </c:when>
        <c:otherwise>
            <table>
                <tr>
                    <td><fmt:message key="name"/></td>
                    <td>${user.login}</td>
                </tr>
                <tr>
                    <td><fmt:message key="pass"/></td>
                    <td>${user.password}</td>
                </tr>
                <tr>
                    <td><fmt:message key="realname"/></td>
                    <td>${user.name}</td>
                </tr>
                <tr>
                    <td><fmt:message key="email"/></td>
                    <td>${user.email}</td>
                </tr>
                <tr>
                    <td><fmt:message key="phone"/></td>
                    <td>${user.phone}</td>
                </tr>
            </table>
        </c:otherwise>
    </c:choose>
</div>
<%@include file="/WEB-INF/layout/footer.jsp"%>