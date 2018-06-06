<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/14
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div id="msgFromPush"></div>
<script type="text/javascript" src="<c:url value="/assets/js/jquery.js"/>"/>
<script type="text/javascript">
    if(!!window.EventSource){
        var source = new EventSource('push');
        s='';
        source.addEventListener('message', function (e) { //2
            s+= e.data+"<br/>";
            $("#msgFromPush").html(s);
        });

        source.addEventListener('open', function (e) {
            if(e.readyState == EventSource.CLOSED){
                console.log("连接关闭");
            }else{
                console.log(e.readyState);
            }
        }, false);
    }else {
        console.log("你的浏览器不支持SSE");
    }
</script>
</body>
</html>
