<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Dataset Search</title>
    <script type="text/javascript">
        $(function() {
            $("#searchTerm").focus();
            $("#helpAccordian").accordion({
                collapsible: true,
                active : -1
            });

            $('#searchDatasetForm').submit(function(event) {
                event.preventDefault();

                var params = $('#searchDatasetForm').serializeArray();

                $.ajax({url:"/dataset_search/doSearch",
                    data:params,
                    type: 'POST',
                    contentType: 'application/x-www-form-urlencoded',
                    success:function(data) {
                        if (data.status == "SUCCESS") {
                            $("#searchResults").html("");
                            $("#searchResults").append(data.results);

                            /*
                             $.each(data.results.coupons, function(key, val) {
                             $('#couponInvoice').append(val.couponId).append("\n");
                             });
                             */
                        } else {
                            errorInfo = "";
                            for (i = 0; i < data.results.length; i++) {
                                errorInfo += " " + (i + 1) + ". " + data.results[i].code + "<br/>";
                            }
                        }
                    },
                    error:function(data) {
                        alert('Server error was detected. Please contact customer support ' + data.responseText);
                    }
                });

                return true;
            });
        });
    </script>
</head>

<body>

<div id="content">
    <br/>
    <!-- Main hero unit for a primary marketing message or call to action -->
    <div class="hero-unit">
        <h3>Search an experiment dataset file</h3>

        <div id="helpAccordian">
            <h3><a href="#">Instructions</a></h3>

            <div>
                Search on any key/value pair, i.e
                <ul>
                    <li>tissue_type:Liver</li>
                    <li>Liver</li>
                    <li>folderType:dataset</li>
                </ul>
            </div>
        </div>

        <form:form modelAttribute="searchItem" id="searchDatasetForm" method="post">
            <fieldset>
                <legend>Search Fields</legend>
                <form:label for="searchTerm" path="desc">Query Term</form:label>
                <form:textarea path="searchTerm" cols="100" rows="10" placeholder="search query using ElasticSearch format"/>
                <br/><br/>
                <input type="submit"/>
                </p>

            </fieldset>
        </form:form>

        <br /><br/>
        <p>Query Results</p>
        <textarea id="searchResults" cols="40" rows="20" readonly="readonly"></textarea>

        <br/><b>${status}</b>
    </div>
</div>


</body>
</html>

