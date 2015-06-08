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
            .error1 {
                padding: 2px;
                margin-bottom: 5px;
                border: 1px solid transparent;
                border-radius: 4px;
                color: #a94442;
            }
        </style>

        <div class="body">

            <h2>Registration new user!</h2>

            <sf:form method="POST" modelAttribute="user" >
                <fieldset>
                    <a class="error1">${error}</a>
                    <table cellspacing="0">
                        <tr>
                            <th><label for="username">User Name: </label></th>
                            <td><sf:input path="username" size="60" id="username"/></td>
                            <td>
                                <sf:errors path="username" class="error"/>
                            </td>
                        </tr>
                        <tr>
                            <th><label for="password">Password</label></th>
                            <td><sf:password path="password" size="60" id="password"/></td>
                            <td>
                                <sf:errors path="password" class="error"/>
                            </td>
                        </tr>
                    </table>
                </fieldset>
                <input type="submit" value="Отправить">
            </sf:form>

        </div>

    </tiles:putAttribute>
</tiles:insertDefinition>