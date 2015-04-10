<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertDefinition name="spitterTemplate">
    <tiles:putAttribute name="body">
        
        <div class="body">
            <h1>Edit user ID: ${id}!</h1>
            <form action="saveedit" method="post">
                <hr>
                <p><input value="${id}" name="myParam[]" readonly="readonly"></p>
                <p><input placeholder="Ваш NickName" value="${nickname}" name="myParam[]" autofocus/></p>
                <p><input placeholder="Ваше Имя" value="${firstname}" name="myParam[]"></p>
                <p><input placeholder="Ваша Фамилия" value="${lastname}" name="myParam[]"></p>
                <p><input placeholder="Ваш e-mail" value="${email}" name="myParam[]"></p>
                <input type="hidden" name="myParam[]" value="${urladdress}"/>
                <input type="submit" value="Отправить">
            </form>
            <form action="hello"><input type="submit" value="Назад"></form>
        </div>
                
    </tiles:putAttribute>
    <tiles:putAttribute name="menu">
        <div class="menu" style="visibility: hidden"></div>
    </tiles:putAttribute>  
</tiles:insertDefinition>
