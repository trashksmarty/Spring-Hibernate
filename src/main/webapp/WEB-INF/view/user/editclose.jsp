<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertDefinition name="spitterTemplate">
    <tiles:putAttribute name="body">
        
        <div class="body">
            <?PHP?>
            <META HTTP-EQUIV="Refresh" CONTENT="1; URL=${urladdress}">
            <h2>Изменение завершино</h2>
        </div>
            
    </tiles:putAttribute>
    <tiles:putAttribute name="menu">
        <div class="menu" style="visibility: hidden"></div>
    </tiles:putAttribute>
</tiles:insertDefinition>