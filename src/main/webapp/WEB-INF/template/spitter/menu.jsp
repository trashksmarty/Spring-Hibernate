<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="menu">
    Menu
    <ul>
        <sec:authorize access="isAuthenticated()">
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
        </sec:authorize>
        <li>
            <spring:url value="/home" var="homeUrl" htmlEscape="true"/>
            <a href="${homeUrl}">Home</a>
        </li>
        <sec:authorize access="!isAuthenticated()">
        <li>
            <spring:url value="/registration" var="registrationUrl" htmlEscape="true"/>
            <a href="${registrationUrl}">Registration</a>
        </li>
        </sec:authorize>
    </ul> 
    <sec:authorize access="isAuthenticated()">
        <hr>
        <ul>
            <li>
                <a href="step" title="Go!">Step!</a>
            </li>
        </ul>
    </sec:authorize>
</div>