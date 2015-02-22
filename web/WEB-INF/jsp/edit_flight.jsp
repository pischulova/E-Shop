<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${userLocale}" />
<fmt:setBundle basename="resources.bundle"/>

<%@include file="/WEB-INF/layout/header.jsp"%>
<%@include file="/WEB-INF/layout/menu.jsp"%>
<div class="center">

    <form action="/auth" method="post">
        <fmt:message key="product_id"/>
        <input type="text" name="productId" value="${sessionScope.product.id}" readonly></br>
        <fmt:message key="product_name_en"/>
        <input type="text" name="nameEn" value="${sessionScope.product.nameEn}"></br>
        <fmt:message key="product_name_ru"/>
        <input type="text" name="nameRu" value="${sessionScope.product.nameRu}"></br>
        <fmt:message key="country_code"/>
        <input type="text" name="countryId" value="${sessionScope.product.country.id}"></br>
        <fmt:message key="price"/>
        <input type="text" name="price" value="${sessionScope.product.price}"><br><br>
        <input type="submit" value="<fmt:message key="save"/>">
        <input type="hidden" name="command" value="edit_flight">
    </form>

    <table>
        <tr>
            <th><fmt:message key="country_code"/></th>
            <th><fmt:message key="country_name_en"/></th>
            <th><fmt:message key="country_name_ru"/></th>
        </tr>

        <c:forEach var="country" items="${sessionScope.countriesList}">
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