<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertDefinition name="spitterTemplate">
    <tiles:putAttribute name="body">
        <div class="body">

            <h1>Find ${name}</h1>
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
                            <input type="hidden" name="myParam[]" value="findallusers"/>
                            <input type="submit" value="Edit">
                        </form>
                    </td>
                    <td>
                        <form action="delete" method="post" accept-charset="UTF-8">
                            <input type="hidden" name="myParam[]" value="${element.getId()}"/>
                            <input type="hidden" name="myParam[]" value="findallusers"/>
                            <input type="submit" value="Delete">
                        </form>
                    </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <form action="/Spitter/hello"><input type="submit" value="Назад"></form>

        </div>
    </tiles:putAttribute>

    <tiles:putAttribute name="menu">
        <div class="menu" style="visibility: hidden"></div>
    </tiles:putAttribute>
</tiles:insertDefinition>