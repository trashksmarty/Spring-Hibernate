<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Found ${name}</h1>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nick</th>
                    <th>Имя</th>
                    <th>Фамилия</th>
                    <th>e-mail</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="element" items="${myList}">
                <tr>
                    <td><c:out value = "${element.getId()}"/></td>
                <td><c:out value = "${element.getNickName()}"/></td>
                <td><c:out value = "${element.getFirstName()}"/></td>
                <td><c:out value = "${element.getLastName()}"/></td>
                <td><c:out value = "${element.getEmail()}"/></td>
                <td>
                    <form action="edit" method="post" accept-charset="UTF-8">
                        <input type="hidden" name="myParam[]" value="${element.getId()}"/>
                        <input type="hidden" name="myParam[]" value="${element.getNickName()}"/>
                        <input type="hidden" name="myParam[]" value="${element.getFirstName()}"/>
                        <input type="hidden" name="myParam[]" value="${element.getLastName()}"/>
                        <input type="hidden" name="myParam[]" value="${element.getEmail()}"/>
                        <input type="hidden" name="myParam[]" value="finduser"/>
                        <input type="submit" value="Edit">
                    </form>
                </td>
                <td>
                    <form action="delete" method="post" accept-charset="UTF-8">
                        <input type="hidden" name="myParam[]" value="${element.getId()}"/>
                        <input type="hidden" name="myParam[]" value="finduser"/>
                        <input type="submit" value="Delete">
                    </form>
                </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <form action="finduser"><input type="submit" value="Назад"></form>
</body>
</html>
