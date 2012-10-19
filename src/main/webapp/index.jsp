<!DOCTYPE html>

<html>
	<head>
        <meta charset="utf-8">
		<title>Index redirect page</title>
		<script type="text/javascript">
		      function doRedirect() {
		          window.location.replace('/home');
		      }
		      window.onload=doRedirect;
		</script>
	</head>

	<body onload="doRedirect()">
	</body>
</html>