<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<tiles:insertDefinition name="spitterTemplate">
    <tiles:putAttribute name="body">

        <div class="body">
            <h1>Поиск</h1>
            <div align=justify><big><font color="red">${exception}</font></big></div><br>
            <form action="found">
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
                                <input placeholder="ID" name="myParam[]" autofocus/>
                            </td>
                            <td>
                                <input placeholder="NickName" name="myParam[]"/>
                            </td>
                            <td>
                                <input placeholder="Имя" name="myParam[]">
                            </td>
                            <td>
                                <input placeholder="Фамилия" name="myParam[]">
                            </td>
                            <td>
                                <input placeholder="e-mail" name="myParam[]">
                            </td>
                        </tr>
                    </tbody>
                </table>
                <input type="submit" value="Отправить">
            </form>
            <form action="/Spitter/hello"><input type="submit" value="Назад"></form>
        </div>

    </tiles:putAttribute>

    <tiles:putAttribute name="menu">
        <div class="menu" style="visibility: hidden"></div>
    </tiles:putAttribute>
</tiles:insertDefinition>