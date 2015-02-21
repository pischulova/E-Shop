<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${userLocale}" />
<fmt:setBundle basename="resources.bundle"/>

<%@include file="/WEB-INF/layout/header.jsp"%>
<%@include file="/WEB-INF/layout/menu.jsp"%>
<div class="center">

    <c:choose>
        <c:when test="${sessionScope.isAdmin=='true'}">

            <table>
                <tr>
                    <th><fmt:message key="order_id"/></th>
                    <th><fmt:message key="date"/></th>
                    <th><fmt:message key="client"/></th>
                    <th><fmt:message key="amount"/></th>
                    <th><fmt:message key="status"/></th>
                </tr>

                <c:forEach var="order" items="${requestScope.ordersList}">
                    <tr>
                        <td><c:out value="${order.id}"/></td>
                        <td><c:out value="${order.date}"/></td>
                        <td><c:out value="${order.client.name}"/></td>
                        <td><c:out value="${order.amount}"/></td>
                        <td><c:out value="${order.isApproved}"/></td>
                        <td>
                            <form action="/auth" method="post">
                                <input type="submit" value="<fmt:message key="view"/>">
                                <input type="hidden" name="orderId" value="${order.id}">
                                <input type="hidden" name="command" value="show_orders">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>

        <c:when test="${sessionScope.isAdmin=='false'}">
            <c:choose>
                <c:when test="${empty requestScope.ordersList}">
                    <fmt:message key="no_orders"/>
                </c:when>

                <c:otherwise>
                    <table>
                        <tr>
                            <th><fmt:message key="order_id"/></th>
                            <th><fmt:message key="date"/></th>
                            <th><fmt:message key="amount"/></th>
                            <th><fmt:message key="status"/></th>
                        </tr>

                        <c:forEach var="order" items="${requestScope.ordersList}">
                            <tr>
                                <td><c:out value="${order.id}"/></td>
                                <td><c:out value="${order.date}"/></td>
                                <td><c:out value="${order.amount}"/></td>
                                <td><c:out value="${order.isApproved}"/></td>
                                <td>
                                    <form action="/auth" method="post">
                                        <input type="submit" value="<fmt:message key="view"/>">
                                        <input type="hidden" name="orderId" value="${order.id}">
                                        <input type="hidden" name="command" value="show_orders">
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:otherwise>
            </c:choose>

        </c:when>

        <c:otherwise>
            <fmt:message key="login_needed"/>
        </c:otherwise>
    </c:choose>

</div>
<%@include file="/WEB-INF/layout/footer.jsp"%>
