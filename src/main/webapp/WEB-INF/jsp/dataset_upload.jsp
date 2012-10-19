<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Dataset Upload</title>
      <script type="text/javascript">
      		$(function() {
                $("#desc").focus();
      			$("#helpAccordian").accordion({
        			collapsible: true,
        			active : -1
        		});
      		});
        </script>
</head>

<body>

<div id="content">
    <br />
    <!-- Main hero unit for a primary marketing message or call to action -->
    <div class="hero-unit">
        <h3>Please upload an experiment dataset file</h3>

        <div id="helpAccordian">
				<h3><a href="#">Instructions</a></h3>
				<div>
					To upload a dataset you can use Excel 2003(.xls) or 2007(.xlsx) format or a plain tab delimited text file. Column names
					must be spelled correctly, however case doesn't matter.  The experiment meta data must come first and the
                    first row must be key followed by value. After the metadata you need one blank row before the actual dataset data.
					<p /><br />
					<table>
						<tr>
                            <td>key</td>
                            <td>value</td>
						</tr>
						<tr>
							<td>dose_unit</td>
							<td>mg/kg</td>
						</tr>
						<tr>
							<td>tissue_type</td>
							<td>Liver</td>
						</tr>
                        <tr>
							<td>&nbsp;</td>
						</tr>
                         <tr>
							<td>Affy ID</td>
							<td>p-value</td>
						</tr>
                          <tr>
							<td>97430_at</td>
							<td>0.0071505</td>
						</tr>
					</table>
					<p/>
				</div>
			</div>

        <form:form modelAttribute="uploadItem" method="post" enctype="multipart/form-data">
            <fieldset>
                <legend>Upload Fields</legend>
                    <form:label for="desc" path="desc" >Description</form:label>
                    <form:input path="desc" placeholder="Description of the dataset" />
                <br />
                    <form:label for="fileData" path="fileData">File</form:label>
                    <form:input path="fileData" type="file"/>
                <p><br/>
                    <input type="submit" />
                </p>

            </fieldset>
        </form:form>
        <br /><b>${status}</b>
    </div>
</div>


</body>
</html>

