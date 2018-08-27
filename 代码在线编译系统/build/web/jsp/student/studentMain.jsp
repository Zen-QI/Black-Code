<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>欢迎您!<%=request.getSession().getAttribute("username")%>同学 </title>
        <link href="top.css" rel="stylesheet" type="text/css" />       
        <style type="text/css">
            .divone{ width:50%;text-align:left; padding-top:150px; margin:auto}
        </style>
    </head>
    <body>
        <ul id="nav"> 
            <li><a href="studentMain.jsp">首页</a></li> 
            <li><a href="questions.jsp">试题库</a></li> 
            <li><a href="submitLog.jsp">提交记录</a></li> 
            <li><a href="help.jsp">使用帮助</a></li> 
            <li><a href="/code/exit">退出系统</a></li> 
        </ul> 
        <div>
            <div class="divone">
                <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎使用本系统，本系统能在您提交代码后自动编译执行，
                    然后对照答案，给出相应分数！我们支持<br/>
                    java、c及c++代码，如果您是第一次使用本系统，强烈建议您先观看使用帮助，否则可能会出现无法编<br/>
                    译等等问题。祝您代码越写越好~~</p>
            </div>
        </div>
    </body>
</html>
