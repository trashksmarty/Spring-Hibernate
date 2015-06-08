<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<tiles:insertDefinition name="spitterTemplate">
    <tiles:putAttribute name="body">

        <style>
            .error {
                padding: 2px;
                margin-bottom: 5px;
                border: 1px solid transparent;
                border-radius: 4px;
                color: #a94442;
                background-color: #f2dede;
                border-color: #ebccd1;
            }
        </style>

        <div class="body">
            <h1>Edit user ID: ${id}!</h1>
            <sf:form action="saveedit" method="POST" modelAttribute="user" >
                <fieldset>
                    <table cellspacing="0">
                        <tr>
                            <th><label for="id">ID</label></th>
                            <td><sf:input path="id" size="25" id="id" readonly="true"  /></td>
                        </tr>
                        <tr>
                            <th><label for="nick">NickName: </label></th>
                            <td><sf:input path="nickName" size="25" id="nick"/></td>
                            <td>
                                <sf:errors path="nickName" class="error"/>
                            </td>
                        </tr>
                        <tr>
                            <th><label for="firstName">FirstName</label></th>
                            <td><sf:input path="firstName" size="25" id="firstName"/></td>
                            <td>
                                <sf:errors path="firstName" class="error"/>
                            </td>
                        </tr>
                        <tr>
                            <th><label for="lastName">LastName</label></th>
                            <td><sf:input path="lastName" size="25" id="lastName"/></td>
                            <td>
                                <sf:errors path="lastName" class="error"/>
                            </td>
                        </tr>
                        <tr>
                            <th><label for="email">E-mail</label></th>
                            <td><sf:input path="email" size="25" id="email"/></td>
                            <td>
                                <sf:errors path="email" class="error"/>
                            </td>
                        </tr>
                    </table>
                </fieldset>
                <input type="hidden" name="myParam" value="${urladdress}"/>
                <input type="submit" value="Отправить">
            </sf:form>
            <form action="/Spitter/hello"><input type="submit" value="Назад"></form>
        </div>

    </tiles:putAttribute>
    <tiles:putAttribute name="menu">
        <div class="menu" style="visibility: hidden"></div>
    </tiles:putAttribute>  
</tiles:insertDefinition>
