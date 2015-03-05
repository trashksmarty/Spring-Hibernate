<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Поиск пользователя</title>
    </head>
    <body>
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
    <form action="hello"><input type="submit" value="Назад"></form>
</body>
</html>
