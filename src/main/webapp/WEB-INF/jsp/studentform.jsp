<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student form</title>
</head>
<body>

<h3>Welcome, Enter The Student Details:</h3>
<%--@elvariable id="student" type="com.barone.springmvc.Student"--%>
<form:form method="POST"
           action="/addChosenStudents" modelAttribute="student">
    <table>
        <tr>
            <td>
                <form:select path="name" multiple="true" >
                    <form:option value="NONE" label="------ Choose one or many -------" title="Tooltip" />
                    <form:options items="${students}" itemValue="id" itemLabel="name" title="TOOOOOLS" />
                </form:select>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>

<%-- FORM 2 --%>
<form:form method="POST"
           action="/addChosenStudent" modelAttribute="student">
    <table>
        <tr>
            <td>
                <form:select path="name" multiple="true">
                    <form:option value="NONE" label="------ Choose one or many -------" />
                    <form:options items="${chosenStudents}" itemValue="id" itemLabel="name" />
                </form:select>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>

<%--<div>Our new student is: ${chosenStudents.name}!</div>--%>

<%--<div>Our new chosen student is: ${chosenStudent.name}!</div>--%>

</body>
</html>
