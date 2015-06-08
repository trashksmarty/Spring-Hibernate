<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<tiles:insertDefinition name="spitterTemplate">
    <tiles:putAttribute name="body">

        <div class="body">
            <h2>Create new User</h2>

            <sf:form>
                <fieldset>
                    <table cellspacing="0">
                        <tr>
                            <th><label for="name">NickName: </label></th>
                            <td><input size="25" name="name"/></td>
                            <td><small>You nickname (2-20 words, a-Z, а-Я).</small>
                                
                                </td>
                            </tr>
                            
                    </table>
                </fieldset>
                <input type="submit" value="Отправить" name="_eventId_submit">
            </sf:form>
        </div>

    </tiles:putAttribute>
</tiles:insertDefinition>