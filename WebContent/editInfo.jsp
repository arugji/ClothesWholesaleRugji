<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>

form{
background-color: beige;
border:2px;
}

h2{
color: blue;
}


</style>
</head>
<body>
<br />
<br />
<br />
<form action = "editClothServlet" method="post">


<h2>Update Cloth Information</h2>


<label>Brand: </label>
<input type ="text" name = "val1" value="${clothToEdit.brand}">

<label >Item: </label>
<input type = "text" name = "val2" value= "${clothToEdit.item}">


<input type = "hidden" name = "id" value="${clothToEdit.id}">
<input type = "submit" value="Save Edited Item">

</form>

</body>
</html>