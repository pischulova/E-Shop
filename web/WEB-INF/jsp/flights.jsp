<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${userLocale}" />
<fmt:setBundle basename="resources.bundle"/>

<%@include file="/WEB-INF/layout/header.jsp"%>
<%@include file="/WEB-INF/layout/menu.jsp"%>
<div class="center">
    <form action="/auth" method="post">
        <select name="country">
            <option value="">empty</option>
            <option value="<fmt:message key="Sweden"/>"><fmt:message key="Sweden"/></option>
            <option value="<fmt:message key="Great_Britain"/>"><fmt:message key="Great_Britain"/></option>
            <option value="<fmt:message key="Sri_Lanka"/>"><fmt:message key="Sri_Lanka"/></option>
            <option value="<fmt:message key="Greece"/>"><fmt:message key="Greece"/></option>
        </select>
        <select name="city">
            <option value="">empty</option>
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
        <input type="hidden" name="command" value="flights">
        <input type="submit" value="submit">
    </form>

    <table>
        <tr>
            <th><fmt:message key="country"/></th>
            <th><fmt:message key="destination"/></th>
            <th><fmt:message key="price"/></th>
        </tr>

        <c:forEach var="flight" items="${flightsList}">
            <tr>
                <td>
                    <c:out value="${flight.country.name}" />
                </td>
                <td>
                    <c:out value="${flight.name}" />
                </td>
                <td>
                    <c:out value="${flight.price}" />
                </td>
            </tr>
        </c:forEach>

    </table>
</div>
<%@include file="/WEB-INF/layout/footer.jsp"%>