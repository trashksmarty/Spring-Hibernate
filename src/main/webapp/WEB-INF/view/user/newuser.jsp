<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<tiles:insertDefinition name="spitterTemplate">
    <tiles:putAttribute name="body">

        <div class="body">
            <h2>Create new User</h2>

            <sf:form action="registration" method="POST" modelAttribute="user" >
                <fieldset>
                    <table cellspacing="0">
                        <tr>
                            <th><label for="nickName">NickName</label></th>
                            <td><sf:input path="nickName" size="25" id="nickName"/></td>
                        </tr>
                        <tr>
                            <th><label for="firstName">FirstName</label></th>
                            <td><sf:input path="firstName" size="25" id="firstName"/></td>
                        </tr>
                        <tr>
                            <th><label for="lastName">LastName</label></th>
                            <td><sf:input path="lastName" size="25" id="lastName"/></td>
                        </tr>
                        <tr>
                            <th><label for="email">E-mail</label></th>
                            <td><sf:input path="email" size="25" id="email"/></td>
                        </tr>
                    </table>
                </fieldset>
                <input type="submit" value="Отправить">
            </sf:form>
            <form action="/Spitter/hello"><input type="submit" value="Назад"></form>
        </div>

    </tiles:putAttribute>

    <tiles:putAttribute name="menu">
        <div class="menu" style="visibility: hidden"></div>
    </tiles:putAttribute>

</tiles:insertDefinition>