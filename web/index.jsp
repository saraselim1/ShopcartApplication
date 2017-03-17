
<html>
    <head>
        <script src="http://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
        <script>
            function drawHome() {
                console.log("start loading");
                $.get('${pageContext.request.contextPath}/Home');
            }
        </script>
    </head>
    <body onload="drawHome()">
    </body>
</html>
