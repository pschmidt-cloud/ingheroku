<html>
<head>
      <title>Ingenuity Heroku Skeleton Webapp</title>
      <script type="text/javascript">
      </script>
</head>

<body>

<div id="content">
    <br/><br/>

    <div class="hero-unit">
        <h2>Hello, Ingenuity! :)</h2>

        <p>A skeleton heroku webapp for quick prototyping. Includes the following</p>
        <ul>
            <li>Maven Project</li>
            <li>Spring Webmvc configuration</li>
            <li>Twitter bootstrap</li>
            <li>Sitemesh configuration for easy reuse of html headers/footers</li>
            <li>jquery, jqueryui</li>
            <li>Basic postgres connection that can be commented out. Not used for vital things</li>
            <li>Basic upload page to upload a file into a Elasticsearch server using the searchbox heroku plugin</li>
            <li>Combine it all for a basic demo of uploading, indexing and autocomplete to search a large document database</li>
            <li>A more complicated example using real world datasets to do the same upload, index and search and using memcache</li>
            <li>REST APIs example</li>
            <li>Small and easy to customize.</li>
            <li>Work in progress :)</li>
        </ul>
        <a class="btn btn-primary" data-toggle="modal" href="#myModal">Launch Modal</a>
    </div>

    <!-- Example row of columns -->
    <div class="row">
        <div class="span4">
            <h2>Heading</h2>

            <p>Donec id elit non mi porta gravida at eget metus. Fusce
                dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut
                fermentum massa justo sit amet risus. Etiam porta sem malesuada magna
                mollis euismod. Donec sed odio dui. </p>

            <p><a class="btn" href="#">View details »</a></p>
        </div>
        <div class="span4">
            <h2>Heading</h2>

            <p>Donec id elit non mi porta gravida at eget metus. Fusce
                dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut
                fermentum massa justo sit amet risus. Etiam porta sem malesuada magna
                mollis euismod. Donec sed odio dui. </p>

            <p><a class="btn" href="#">View details »</a></p>
        </div>
        <div class="span4">
            <h2>Heading</h2>

            <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis
                in, egestas eget quam. Vestibulum id ligula porta felis euismod semper.
                Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
                ut fermentum massa justo sit amet risus.</p>

            <p><a class="btn" href="#">View details »</a></p>
        </div>
    </div>

    <hr>

    <div class="modal hide" id="myModal">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">×</button>
            <h3>Modal header</h3>
        </div>
        <div class="modal-body">
            <p>One fine body</p>
        </div>
        <div class="modal-footer">
            <a href="#" class="btn" data-dismiss="modal">Close</a>
            <a href="#" class="btn btn-primary">Save changes</a>
        </div>
    </div>
</div>

</body>
</html>

