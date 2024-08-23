<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<%--@elvariable id="request" type="la.ch.bedag.rest.CalculatorRequest"--%>
<form:form method="post" modelAttribute="request">
    <h1>Calculator</h1>
    <hr>
    <form:label style='width: 50px' path="x">x: </form:label> <form:input path="x"/>
    <form:label style='width: 50px' path="y">y: </form:label> <form:input path="y"/>
    <br/>
    <br/>
    <form:select path="type">
        <form:option value="ADDITION" label="ADDITION"/>
        <form:option value="SUBTRACTION" label="SUBTRACTION"/>
        <form:option value="MULTIPLICATION" label="MULTIPLICATION"/>
        <form:option value="DIVIDE" label="DIVIDE"/>
    </form:select>
    <input type="submit" value="Calculate">
</form:form>
<button><a href="calc">Clear</a></button>
<br/>
<c:if test="${resultSuccess}">
    <label>Result: ${result}</label>
</c:if>
</body>
</html>