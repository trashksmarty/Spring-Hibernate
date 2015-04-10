<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<tiles:insertDefinition name="spitterTemplate">
    <tiles:putAttribute name="body">
        
        <div class="body">
        <h1>Заполните форму.</h1>
        <form action="registration">
            <p>Регистрация</p>
            <p><input placeholder="Ваш NickName" name="myParam[]" autofocus/></p>
            <p><input placeholder="Ваше Имя" name="myParam[]"></p>
            <p><input placeholder="Ваша Фамилия" name="myParam[]"></p>
            <p><input placeholder="Ваш e-mail" name="myParam[]"></p>
            <input type="submit" value="Отправить">
        </form>
        <form action="/Spitter/hello"><input type="submit" value="Назад"></form>
        </div>

    </tiles:putAttribute>
    
    <tiles:putAttribute name="menu">
        <div class="menu" style="visibility: hidden"></div>
    </tiles:putAttribute>
    
</tiles:insertDefinition>
        
