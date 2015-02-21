<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${userLocale}" />
<fmt:setBundle basename="resources.bundle"/>

<%@include file="/WEB-INF/layout/header.jsp"%>
<%@include file="/WEB-INF/layout/menu.jsp"%>
<div class="center">
    <c:if test="${requestScope.flightChanged == 'true'}">
        <fmt:message key="flight_updated"/><br><br>
    </c:if>

    <form action="/auth" method="post">
        <fmt:message key="choose"/><br>
        <select name="country">
            <option value="">-----</option>
            <option value="<fmt:message key="Sweden"/>"><fmt:message key="Sweden"/></option>
            <option value="<fmt:message key="Great_Britain"/>"><fmt:message key="Great_Britain"/></option>
            <option value="<fmt:message key="Sri_Lanka"/>"><fmt:message key="Sri_Lanka"/></option>
            <option value="<fmt:message key="Greece"/>"><fmt:message key="Greece"/></option>
        </select>
        <select name="city">
            <option value="">-----</option>
            <option value="<fmt:message key="Stockholm"/>"><fmt:message key="Stockholm"/></option>
            <option value="<fmt:message key="Malmo"/>"><fmt:message key="Malmo"/></option>
            <option value="<fmt:message key="London"/>"><fmt:message key="London"/></option>
            <option value="<fmt:message key="Liverpool"/>"><fmt:message key="Liverpool"/></option>
            <option value="<fmt:message key="Glasgow"/>"><fmt:message key="Glasgow"/></option>
            <option value="<fmt:message key="Colombo"/>"><fmt:message key="Colombo"/></option>
            <option value="<fmt:message key="Athens"/>"><fmt:message key="Athens"/></option>
            <option value="<fmt:message key="Heraklion"/>"><fmt:message key="Heraklion"/></option>
            <option value="<fmt:message key="Thessaloniki"/>"><fmt:message key="Thessaloniki"/></option>
        </select>
        <input type="hidden" name="command" value="show_flights">
        <input type="submit" value="ok">
    </form>

    <table>
        <c:if test="${not empty requestScope.flightsList}">
            <tr>
                <th><fmt:message key="country"/></th>
                <th><fmt:message key="destination"/></th>
                <th><fmt:message key="price"/></th>
            </tr>
        </c:if>

        <c:forEach var="flight" items="${requestScope.flightsList}">
            <tr>
                <td><c:out value="${flight.country.name}"/></td>
                <td><c:out value="${flight.name}"/></td>
                <td><c:out value="${flight.price}"/></td>
                <td>
                    <c:if test="${sessionScope.isAdmin=='true'}">
                        <form action="/auth" method="post">
                            <input type="submit" value="<fmt:message key="edit"/>">
                            <input type="hidden" name="flight" value="${flight.id}">
                            <input type="hidden" name="command" value="find_flight">
                        </form>
                    </c:if>
                    <c:if test="${sessionScope.isAdmin=='false'}">
                        <form action="/auth" method="post">
                            <input type="submit" value="<fmt:message key="add_to_cart"/>">
                            <input type="hidden" name="flightId" value="${flight.id}">
                            <input type="hidden" name="action" value="add">
                            <input type="hidden" name="command" value="change_cart">
                        </form>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>
<%@include file="/WEB-INF/layout/footer.jsp"%>