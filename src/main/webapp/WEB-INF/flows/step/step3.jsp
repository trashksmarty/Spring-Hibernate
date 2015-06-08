<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<tiles:insertDefinition name="spitterTemplate">
    <tiles:putAttribute name="body">
        <div class="body">
            <h1>Hello Step by step flow transition</h1>

            <div />
            <h2>Welcome Step 3 !</h2>

            <sf:form>
                <input type="submit" name="_eventId_cencel" 
                       value="Cencel" /> 
                <input type="submit" name="_eventId_previous" 
                       value="Previous" />  
                <input type="submit" name="_eventId_success" 
                       value="Success" /> 
            </sf:form>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>