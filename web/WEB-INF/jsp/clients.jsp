<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${userLocale}" />
<fmt:setBundle basename="resources.bundle"/>

<%@include file="/WEB-INF/layout/header.jsp"%>
<%@include file="/WEB-INF/layout/menu.jsp"%>

<div class="center">
    <table>
        <tr>
            <th><fmt:message key="client_id"/></th>
            <th><fmt:message key="realname"/></th>
            <th><fmt:message key="email"/></th>
            <th><fmt:message key="phone"/></th>
            <th><fmt:message key="orders"/></th>
        </tr>

        <c:forEach var="client" items="${sessionScope.goodClientsList}">
            <tr>
                <td><c:out value="${client.id}" /></td>
                <td><c:out value="${client.name}" /></td>
                <td><c:out value="${client.email}" /></td>
                <td><c:out value="${client.phone}" /></td>
                <td><c:out value="${client.orderAmount}" /></td>
                <td>
                    <form action="/auth" method="post">
                        <input type="submit" value="<fmt:message key="to_blacklist"/>">
                        <input type="hidden" name="clientId" value="${client.id}">
                        <input type="hidden" name="action" value="add">
                        <input type="hidden" name="command" value="blacklist">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table><br>

    <fmt:message key="blacklist"/><br><br>
    <table>
        <tr>
            <th><fmt:message key="client_id"/></th>
            <th><fmt:message key="realname"/></th>
            <th><fmt:message key="email"/></th>
            <th><fmt:message key="phone"/></th>
            <th><fmt:message key="orders"/></th>
        </tr>

        <c:forEach var="client" items="${sessionScope.badClientsList}">
            <tr>
                <td><c:out value="${client.id}" /></td>
                <td><c:out value="${client.name}" /></td>
                <td><c:out value="${client.email}" /></td>
                <td><c:out value="${client.phone}" /></td>
                <td><c:out value="${client.orderAmount}" /></td>
                <td>
                    <form action="/auth" method="post">
                        <input type="submit" value="<fmt:message key="move"/>">
                        <input type="hidden" name="clientId" value="${client.id}">
                        <input type="hidden" name="action" value="remove">
                        <input type="hidden" name="command" value="blacklist">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<%@include file="/WEB-INF/layout/footer.jsp"%>
