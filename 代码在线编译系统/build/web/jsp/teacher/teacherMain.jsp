<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>欢迎您!<%=request.getSession().getAttribute("username")%>老师</title>
        <link href="top.css" rel="stylesheet" type="text/css" />       
        <style type="text/css">
            .divone{ width:50%;text-align:left; padding-top:150px; margin:auto}
        </style>
    </head>
    <body>
        <ul id="nav"> 
            <li><a href="teacherMain.jsp">首页</a></li> 
            <li><a href="questions.jsp">试题库</a></li> 
            <li><a href="add.jsp">添加试题</a></li> 
            <li><a href="submitLog.jsp">提交记录</a></li> 
            <li><a href="/code/exit">退出系统</a></li> 
        </ul> 

        <div>
            <div class="divone">
                <p>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎<%=request.getSession().getAttribute("username")%>老师使用本系统，
                    试题库可查看所以试题，并能查看某一道题的全部提交记录；添加试题则能往试题库中添加试题；提交记录则是所有题目的提交记录。
                </p>
            </div>
        </div>
    </body>
</html>
