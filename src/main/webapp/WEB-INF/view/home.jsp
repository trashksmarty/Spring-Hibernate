<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
        <div class="body">
            <h1>Home page !</h1>

            <p>The time on the server is ${serverTime}.</p>
            <p>Any text, for this application.</P>
        </div>
    </tiles:putAttribute>
    <tiles:putAttribute name="footer">
        <div class="footer">
            This is Home page, and I'm the footer!
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>