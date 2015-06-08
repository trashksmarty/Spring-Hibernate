<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spitter tiles template</title>
        <style type="text/css">
            body {
                margin:0px;
                padding:0px;
                height:100%;
                overflow:hidden;
            }
            .page {
                min-height:100%;
                position:relative;
            }

            .header {
                padding:10px;
                width:100%;
                text-align:center;
            }

            .content {
                padding:10px;
                padding-bottom:20px; /* Height of the footer element */
                overflow:hidden;
            }

            .menu {
                padding:40px 10px 0px 15px;
                width:200px;
                float:left;
                visibility: visible;
            }
            .body {
                margin:50px 10px 0px 250px;
            }

            .footer {
                clear:both;
                position:absolute;
                bottom:4px;
                right:5px;
                text-align:right;
                width:100%;
                height:20px;
            }
            .aboutuser {
                padding:0px;
                clear:both;
                position:absolute;
                right:8px;
                top:4px;
            }

        </style>
    </head>
    <body>
        <div class="page">
            <div class="content">
            <tiles:insertAttribute name="header" />
            <tiles:insertAttribute name="aboutuser" />
            </div>
            <div class="content">
                <tiles:insertAttribute name="menu" />
                <tiles:insertAttribute name="body" />
            </div>
            <tiles:insertAttribute name="footer" />
        </div>
    </body>
</html>