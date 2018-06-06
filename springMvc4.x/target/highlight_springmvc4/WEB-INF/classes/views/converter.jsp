<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/14
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html" charset="UTF-8">
    <title>HttpConverter Demo</title>
</head>
<body>
    <div id="resp"></div><input type="button" onclick="req();" value="请求"/>

    <script  language="javascript"   src="<%=basePath%>/assets/js/jquery.js" type="text/javascript"></script>
    <script>
        function req() {
            $.ajax({
                url : "convert",
                data : "1-qilin.liu", //1
                type : "POST",
                contentType : "application/x-wisely",//2
                success : function (data) {
                    $("#resp").html(data)
                }
            })
        }
    </script>
</body>
</html>
