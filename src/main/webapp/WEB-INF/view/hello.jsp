<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="false"%>

<tiles:insertDefinition name="spitterTemplate">
    <tiles:putAttribute name="body">

        <div class="body">
            <h1>${name}!</h1>

            <form action="hello">
                <table border="0">
                    <thead>
                        <tr>
                            <th>Имя</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <p><input placeholder="Ваш NickName" name="name" autofocus/></p>
                            </td>
                            <td>
                                <p><input type="submit" value="Переименоваться"></p>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>

    </tiles:putAttribute>
</tiles:insertDefinition>