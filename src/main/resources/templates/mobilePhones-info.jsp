<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>MobilePhones Info</h2>
<br>
<form:form action="saveMobilePhones" modelAttribute="mobilePhone">

  <form:hidden path="id"/>

  Brand<form:input path="brand"/>
  <br><br>
  Model<form:input path="model"/>
  <br><br>
  Performance<form:input path="performance"/>
  <br><br>
  Price<form:input path="price"/>
  <br><br>
  <input type="submit" value="OK">

</form:form>
</body>
</html>