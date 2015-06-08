<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<style>
    .frame {
        padding: 15px;
        margin-bottom: 20px;
        border: 1px solid transparent;
        border-radius: 4px;
        color: #a94442;
        background-color: #ADD8E6;
        border-color: #AFEEEE;
    }
</style>
<div class="aboutuser">
    <sec:authorize access="isAuthenticated()">
        <sec:authentication property="principal.username" var="loginId"/>
        
        <div class="frame">
        <h1>User: ${loginId}</h1>


        <!--Logout-->
        <c:url value="/logout" var="logoutUrl" />
        <form action="${logoutUrl}" method="post" id="logoutForm">
            <input type="hidden" name="${_csrf.parameterName}"
                   value="${_csrf.token}" />
        </form>

        <script>
            function formSubmit() {
                document.getElementById("logoutForm").submit();
            }
        </script>

        <a href="javascript:formSubmit()"> Logout</a>
        </div>
    </sec:authorize>
        
    
    <sec:authorize access="!isAuthenticated()">
        <!--Login-->
        <a href="login" title="Login!">Login!</a>
    </sec:authorize>
</div>