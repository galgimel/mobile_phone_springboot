<!DOCTYPE html>
<html>
<body>

<h2>All Employees</h2>
<br>
<table>
    <tr>
        <th>Brand</th>
        <th>Model</th>
        <th>Performance</th>
        <th>Price</th>
        <th>Options</th>

    </tr>
    <c:forEach var="mp" items="${allMPs}">

        <c:url var="deleteButton" value="/deleteMobilePhone">
            <c:param name="empId" value="${mp.id}"/>
        </c:url>

        <tr>
            <td>${mp.brand}</td>
            <td>${mp.model}</td>
            <td>${mp.performance}</td>
            <td>${mp.price}</td>
            <td>
                <input type="button" value="Delete"
                       onclick="window.location.href = '${deleteButton}'"/>
            </td>
        </tr>
    </c:forEach>

</table>
<br>
<input type="button" value="Main View"
onclick="window.location.href = 'backToFirstView'"/>
<br>
<input type="button" value="Add"
       onclick="window.location.href = 'addNewMobilePhone'"/>
</body>
</html>

<a th:href="@{getMobilePhones/{id}(id=${mobilePhone.getId()})}"
   th:text="${mobilePhone.getBrand()} ${mobilePhone.getModel()}">phone</a>

<input type="button" value="More"
       onclick="window.location.href =
               '/getMobilePhones/{id}(id=${mobilePhone.getId()})'"/>

<form th:method="DELETE" th:action="@{/deleteEmployee/{id}(id=${mobilePhone.getId()})}">
    <input type="submit" value="Delete"/>
</form>


<form th:method="GET" th:action="@{getMobilePhones/{id}(id=${mobilePhone.getId()})}" th:object="${mobilePhone}">

</form>

