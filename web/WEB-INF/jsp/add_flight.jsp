<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${userLocale}" />
<fmt:setBundle basename="resources.bundle"/>

<%@include file="/WEB-INF/layout/header.jsp"%>
<%@include file="/WEB-INF/layout/menu.jsp"%>

<div class="center">
    <form action="/auth" method="post">
        <fmt:message key="product_name_en"/>
        <input type="text"></br>
        <fmt:message key="product_name_ru"/>
        <input type="text"></br>
        <fmt:message key="country_code"/>
        <input type="text"></br>
        <fmt:message key="price"/>
        <input type="text">
    </form>

    <form action="/edit_flight">
        <input type="submit" value="<fmt:message key="save"/>">
        <input type="hidden" name="command" value="edit_flight">
    </form>

    <table>
        <tr>
            <th><fmt:message key="country_code"/></th>
            <th><fmt:message key="country_name_en"/></th>
            <th><fmt:message key="country_name_ru"/></th>
        </tr>

        <c:forEach var="country" items="${requestScope.countriesList}">
            <tr>
                <td>
                    <c:out value="${country.id}" />
                </td>
                <td>
                    <c:out value="${country.nameEn}" />
                </td>
                <td>
                    <c:out value="${country.nameRu}" />
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<%@include file="/WEB-INF/layout/footer.jsp"%>