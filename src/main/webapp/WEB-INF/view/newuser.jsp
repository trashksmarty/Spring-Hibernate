<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Статус: ${name}!</h1>
        <form action="registration">
            <p>Регистрация</p>
            <p><input placeholder="Ваш NickName" name="myParam[]" autofocus/></p>
            <p><input placeholder="Ваше Имя" name="myParam[]"></p>
            <p><input placeholder="Ваша Фамилия" name="myParam[]"></p>
            <p><input placeholder="Ваш e-mail" name="myParam[]"></p>
            <input type="submit" value="Отправить">
        </form>
        <form action="hello"><input type="submit" value="Назад"></form>
    </body>
</html>
