<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${userLocale}" />
<fmt:setBundle basename="resources.bundle"/>

<%@include file="/WEB-INF/layout/header.jsp"%>
<%@include file="/WEB-INF/layout/menu.jsp"%>
<div class="center">

    <fmt:message key="order_details"/><br><br>

    <c:if test="${sessionScope.isAdmin=='true'}">
        <fmt:message key="client"/>: <c:out value="${order.client.name}"/><br><br>
    </c:if>

    <table>
        <tr>
            <th><fmt:message key="order_id"/></th>
            <th><fmt:message key="date"/></th>
            <th><fmt:message key="amount"/></th>
            <th><fmt:message key="status"/></th>
        </tr>
        <tr>
            <td><c:out value="${order.id}"/></td>
            <td><c:out value="${order.date}"/></td>
            <td><c:out value="${order.amount}"/></td>
            <td><c:out value="${order.isApproved}"/></td>
        </tr>
    </table><br><br>

    <table>
        <tr>
            <th><fmt:message key="destination"/></th>
            <th><fmt:message key="country"/></th>
            <th><fmt:message key="price"/></th>
        </tr>
        <c:forEach var="product" items="${requestScope.orderContents}">
            <tr>
                <td><c:out value="${product.name}"/></td>
                <td><c:out value="${product.country.name}"/></td>
                <td><c:out value="${product.price}"/></td>
            </tr>
        </c:forEach>
    </table><br>

    <c:if test="${sessionScope.isAdmin=='true'}">
        <c:if test="${order.isApproved==0}">
            <form action="/auth" method="post">
                <input type="submit" value="<fmt:message key="approve"/>">
                <input type="hidden" name="orderId" value="${order.id}">
                <input type="hidden" name="command" value="approve_order">
            </form>
        </c:if>
    </c:if>


</div>
<%@include file="/WEB-INF/layout/footer.jsp"%>