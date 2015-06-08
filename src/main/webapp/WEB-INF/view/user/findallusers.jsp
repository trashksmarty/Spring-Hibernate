<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<tiles:insertDefinition name="spitterTemplate">
    <tiles:putAttribute name="body">

        <div class="body">

            <h1>Find ${name}</h1>
            <table cellspacing="0" cellpadding="4" border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th width="220">Nick</th>
                        <th width="220">Имя</th>
                        <th width="220">Фамилия</th>
                        <th width="220">e-mail</th>
                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <th></th>
                        <th></th>
                        </sec:authorize>
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
                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                                <td>
                                    <sf:form action="edit" method="POST" modelAttribute="user" >
                                        <sf:hidden path="id" value="${element.getId()}" id="id"/>
                                        <sf:hidden path="nickName" value="${element.getNickName()}" id="nickName"/>
                                        <sf:hidden path="firstName" value="${element.getFirstName()}" id="firstName"/>
                                        <sf:hidden path="lastName" value="${element.getLastName()}" id="lastName"/>
                                        <sf:hidden path="email" value="${element.getEmail()}" id="email"/>
                                        <input type="hidden" name="myParam" value="findallusers"/>
                                        <input type="submit" value="Edit">
                                    </sf:form>
                                </td>
                                <td>
                                    <sf:form action="delete" method="POST" modelAttribute="user" >
                                        <sf:hidden path="id" value="${element.getId()}" id="id"/>
                                        <input type="hidden" name="myParam" value="findallusers"/>
                                        <input type="submit" value="Delete">
                                    </sf:form>
                                </td>
                            </sec:authorize>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <form action="/Spitter/hello"><input type="submit" value="Назад"></form>
            <form action="downloadExcel" method="POST">
                <input type="hidden" name="myParam" value="findallusers"/>
                <input type="submit" value="Сохранить Excel">
            </form>
            <form action="downloadPDF" method="POST">
                <input type="hidden" name="myParam" value="findallusers"/>
                <input type="submit" value="Сохранить PDF">
            </form>
        </div>

    </tiles:putAttribute>

    <tiles:putAttribute name="menu">
        <div class="menu" style="visibility: hidden"></div>
    </tiles:putAttribute>
</tiles:insertDefinition>