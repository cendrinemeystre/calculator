<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form action='' method='get'>
    <h1>Calculator</h1>
    <hr>
    <label>x: <input id='x' value="${x}" name="x" style='width: 50px'/></label>
    <label>y: <input id='y' value="${y}" name="y" style='width: 50px'/></label>
    <br>
    <br>
    <button type='submit' name='type' value='addition'>Addition</button>
    <button type='submit' name='type' value='subtraction'>Subtraction</button>
    <br>
    <button type='submit' name='type' value='multiplication'>Multiplication</button>
    <button type='submit' name='type' value='divide'>Divide</button>
</form>
<br>
<label>Result: ${result}</label>
</body>
</html>