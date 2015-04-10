<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="menu">
    Menu
    <ul>
        <li>
            <spring:url value="user/newuser" var="newuserUrl" htmlEscape="true"/>
            <a href="${newuserUrl}">New User</a>
        </li>
        <li>
            <spring:url value="user/findallusers" var="findallusersUrl" htmlEscape="true"/>
            <a href="${findallusersUrl}">All Users</a>
        </li>
        <li>
            <spring:url value="user/finduser" var="finduserUrl" htmlEscape="true"/>
            <a href="${finduserUrl}">Find Users</a>
        </li>
        
        <li>
            <spring:url value="/home" var="homeUrl" htmlEscape="true"/>
            <a href="${homeUrl}">Home</a>
        </li>
    </ul>
</div>