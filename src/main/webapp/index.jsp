<html>
<body>
	<h2>Hello World!</h2>
<head>
<script type="text/javascript" src="jquery-2.0.3.js"></script>
<script type="text/javascript">
	$(function() {
		$("#clickBtn").click(function() {
			var data = {};
			data.userName = 'jerrik';
			data.addressInfo = {};
			data.addressInfo.provinceName = '湖南省';
			/* $.ajax({
				'url' : 'http://localhost:8081/maven-spring-data/home/index.action',
				'type' : 'post',
				'dataType' : 'json',
				'data' : data,
				'success' : function(data) {
					alert(data);
				}
			}); */
			console.log(data);
			$.post('http://localhost:8081/maven-spring-data/home/index.action',data,function(d){
				alert(d);
			});
		});

	});
</script>
</head>
<body>
	<button id="clickBtn">click</button>
</body>
</html>
