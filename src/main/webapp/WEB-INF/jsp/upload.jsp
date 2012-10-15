<html>
<head>
    <title>Upload</title>
    <script type="text/javascript">
    </script>
</head>

<body>

<div id="content">
    <br /><br />
    <!-- Main hero unit for a primary marketing message or call to action -->
    <div class="hero-unit">
        <h2>Please upload a file</h2>

        <form:form modelAttribute="uploadItem" method="post" enctype="multipart/form-data">
            <fieldset>
                <legend>Upload Fields</legend>
                    <form:label for="desc" path="desc">Description</form:label><br/>
                    <form:input path="desc"/>
                <br />
                    <form:label for="fileData" path="fileData">File</form:label><br/>
                    <form:input path="fileData" type="file"/>
                <p>
                    <input type="submit" />
                </p>

            </fieldset>
        </form:form>
    </div>
</div>


</body>
</html>

