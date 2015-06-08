<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<tiles:insertDefinition name="spitterTemplate">
    <tiles:putAttribute name="body">

        <div class="body">
            <h1>Поиск</h1>
            <div align=justify><big><font color="red">${exception}</font></big></div><br>
                    <sf:form action="found" method="post" modelAttribute="user">
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nick</th>
                            <th>Имя</th>
                            <th>Фамилия</th>
                            <th>e-mail</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <sf:input placeholder="ID" path="id" size="25" id="id"/>
                            </td>
                            <td>
                                <sf:input placeholder="NickName" path="nickName" size="25" id="nickName"/>
                            </td>
                            <td>
                                <sf:input placeholder="Имя" path="firstName" size="25" id="firstName"/>
                            </td>
                            <td>
                                <sf:input placeholder="Фамилия" path="lastName" size="25" id="lastName"/>
                            </td>
                            <td>
                                <sf:input placeholder="e-mail" path="email" size="25" id="email"/>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <input type="hidden" name="myParam" value="finduser"/>
                <input type="submit" value="Отправить">
            </sf:form>
            <form action="/Spitter/hello"><input type="submit" value="Назад"></form>
        </div>

    </tiles:putAttribute>

    <tiles:putAttribute name="menu">
        <div class="menu" style="visibility: hidden"></div>
    </tiles:putAttribute>
</tiles:insertDefinition>