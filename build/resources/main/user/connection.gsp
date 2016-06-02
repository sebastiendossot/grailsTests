<%--
  Created by IntelliJ IDEA.
  User: sdossot
  Date: 02/06/2016
  Time: 09:32
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <meta name="layout" content="main" />
        <title>Connection</title>
    </head>

    <body>
    <g:form action="authentification">
        <fieldset class="form">
            <f:field bean="user" property="username"/>
            <f:field bean="user" property="password"/>
        </fieldset>
        <fieldset class="buttons">
            <g:submitButton name="authentification" class="authentification" value="Connect" />
        </fieldset>
    </g:form>
    <g:if test="${flash.message}">
        <g:message code="${flash.message}" />
    </g:if>
    </body>
</html>