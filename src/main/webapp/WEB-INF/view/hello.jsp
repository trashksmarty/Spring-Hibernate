<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello ${name}!</h1>
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
        <p><a href="newuser">New User</a></p>
        <p><a href="finduser">All Users</a></p>
        <p><a href="finduser">Find Users</a></p>
    </body>
</html>
