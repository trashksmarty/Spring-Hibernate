<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertDefinition name="spitterTemplate">
    <tiles:putAttribute name="body">
        
        <div class="body">
            <h1>Edit user ID: ${id}!</h1>
            <sf:form action="saveedit" method="POST" modelAttribute="user" >
                <fieldset>
                    <table cellspacing="0">
                        <tr>
                            <th><label for="id">ID</label></th>
                            <td><sf:input path="id" size="25" id="id" readonly="true" value="${id}"/></td>
                        </tr>
                        <tr>
                            <th><label for="nickName">NickName</label></th>
                            <td><sf:input path="nickName" size="25" id="nickName" value="${nickname}"/></td>
                        </tr>
                        <tr>
                            <th><label for="firstName">FirstName</label></th>
                            <td><sf:input path="firstName" size="25" id="firstName" value="${firstname}"/></td>
                        </tr>
                        <tr>
                            <th><label for="lastName">LastName</label></th>
                            <td><sf:input path="lastName" size="25" id="lastName" value="${lastname}"/></td>
                        </tr>
                        <tr>
                            <th><label for="email">E-mail</label></th>
                            <td><sf:input path="email" size="25" id="email" value="${email}"/></td>
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
