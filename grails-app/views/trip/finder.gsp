<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'trip.label', default: 'Trip')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>

    <div class="header-finder">
        <g:form action="finder">
            <g:textField name="finder" class="finder-field" value="finder"/>
            <button type="submit" class="search-submit"><i class="fa fa-search fa-lg" ></i></button>
        </g:form>
    </div>

        <a href="#list-trip" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="list-trip" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <table>
                <thead>
                    <tr>
                        <g:sortableColumn property="destino" title="${message(code: 'Trip.destino.label')}"></g:sortableColumn>
                        <g:sortableColumn property="espectativas" title="${message(code: 'Trip.espectativas.label')}"></g:sortableColumn>
                        <g:sortableColumn property="actividades" title="${message(code: 'Trip.actividades.label')}"></g:sortableColumn>
                    </tr>
                </thead>
                <tbody>
                    <g:each in="${somelist}" status="i" var="destinoInstance">
                        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                            <td><g:link action="show" id="destinoInstance.id"> ${fieldValue(bean : destinoInstance, field: "destino")}</g:link></td>
                            <td>${fieldValue(bean: destinoInstance, field: "espectativas")}</td>
                            <td>${fieldValue(bean: destinoInstance, field: "destino")}</td>
                        </tr>

                    </g:each>
                </tbody>
            </table>

            <div class="pagination">
                <g:paginate total="${tripCount ?: 0}" />
            </div>
        </div>
    </body>
</html>