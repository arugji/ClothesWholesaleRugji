<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>

table{

background-color: beige;
}



</style>
</head>
<body>
<br/>
<br/>


<form method = "post" action = "navigationServlet">
<table>
<tr>
	<td> ID</td>
    <td>Brand</td>
    <td>Item</td>
</tr>
<c:forEach items="${requestScope.allClothes}" var="currentitem">
<tr>
 <td><input type="radio" name="id" value="${currentitem.id}"></td>
 <td>${currentitem.brand}</td>
 <td>${currentitem.item}</td>
 </tr>
</c:forEach>
 
</table>

  <input type = "submit" value = "edit" name="doThis">
  <input type = "submit" value = "delete" name="doThis">
  <input type="submit" value = "add" name = "doThis">
</form>

</body>
</html>