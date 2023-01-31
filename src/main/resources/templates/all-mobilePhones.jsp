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