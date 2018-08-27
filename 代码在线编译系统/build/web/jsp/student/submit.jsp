<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>提交代码</title>
        <link href="top.css" rel="stylesheet" type="text/css" />       
        <style type="text/css">
            .maindiv{margin: 70px auto 0px; width: 50%; text-align: left;}
            .text{margin:10px 0 0 40px; width: 800px;}
            .sub{margin:10px 0 0 100%; font-size: 20px;}
        </style>
        <script language="javascript">
            function sub() {
                var id = document.getElementsByName("language");
                var val;
                for (var i = 0; i < id.length; i++) {
                    if (id[i].checked) {
                        val = id[i].value;
                    }
                }
                window.location.href = "/code/compile?id=" + <%= request.getParameter("id")%> + "&type=" + val;
            }
        </script>
    </head>
    <body>        
        <ul id="nav"> 
            <li><a href="studentMain.jsp">首页</a></li> 
            <li><a href="questions.jsp">试题库</a></li> 
            <li><a href="submitLog.jsp">提交记录</a></li> 
            <li><a href="help.jsp">使用帮助</a></li> 
            <li><a href="/code/exit">退出系统</a></li> 
        </ul>
        <div class="maindiv">
            <form action="/code/compile" method="POST">
                <div>待提交试题：<a href="question.jsp?id= <%= request.getParameter("id")%>"><%= request.getParameter("qname")%></a></div>
                <br>
                <div>
                    <input type="text" name="id" value="<%= request.getParameter("id")%>" style="display:none;"/>
                    编程语言：
                    <input type="radio" name="language" value="java">java
                    <input type="radio" name="language" value="c">c
                    <input type="radio" name="language" value="c++">c++
                    <script>document.getElementsByName("language")[0].checked = "checked";</script>
                </div>
                <div>
                    代码：<br>
                    <textarea class="text" name="code" rows="25"></textarea>
                </div>
                <div><input class="sub" type="submit" name="提交" value="提交代码"/></div>
            </form>
        </div>
    </body>
</html>
