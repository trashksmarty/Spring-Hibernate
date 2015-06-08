<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<tiles:insertDefinition name="spitterTemplate">
    <tiles:putAttribute name="body">

        <style>
            .error {
                padding: 15px;
                margin-bottom: 20px;
                border: 1px solid transparent;
                border-radius: 4px;
                color: #a94442;
                background-color: #f2dede;
                border-color: #ebccd1;
            }

            .msg {
                padding: 15px;
                margin-bottom: 20px;
                border: 1px solid transparent;
                border-radius: 4px;
                color: #31708f;
                background-color: #d9edf7;
                border-color: #bce8f1;
            }

            #login-box {
                width: 300px;
                padding: 20px;
                margin: 100px auto;
                background: #fff;
                -webkit-border-radius: 2px;
                -moz-border-radius: 2px;
                border: 1px solid #000;
            }
        </style>

        <div class="body">
            <div id="login-box">
                <h3>Login with Username and Password</h3>

                <c:if test="${not empty error}">
                    <div class="error">${error}</div>
                </c:if>
                <c:if test="${not empty msg}">
                    <div class="msg">${msg}</div>
                </c:if>

                <form method="post" name='loginForm' action="<c:url value='/login' />">
                    <fieldset>
                        <table>
                            <tr>
                                <td>User:</td>
                                <td><input type='text' name='username' value=''></td>
                            </tr>
                            <tr>
                                <td>Password:</td>
                                <td><input type='password' name='password' /></td>
                            </tr>
                            <tr>
                                <td colspan='2'><input name="submit" type="submit"
                                                       value="submit" /></td>
                            </tr>
                        </table>

                        <input type="hidden" name="${_csrf.parameterName}"
                               value="${_csrf.token}" />
                        <input id="remember_me" name="_spring_security_remember_me"
                               type="checkbox"/>
                        <label for="remember_me" class="inline">Remember me</label>

                    </fieldset>
                </form>
            </div>
        </div>

    </tiles:putAttribute>
</tiles:insertDefinition>