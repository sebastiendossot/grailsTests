<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <title></title>
    </head>
    <body>
    	<g:form action="save">
            <fieldset class="form">
                <f:all bean="participant"/>
            </fieldset>
            <fieldset class="buttons">
                <g:submitButton name="save" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
            </fieldset>
        </g:form>
    </body>
</html>

