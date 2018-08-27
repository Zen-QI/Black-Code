<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>帮助</title>
        <link href="top.css" rel="stylesheet" type="text/css" />
        <style type="text/css">
            .b {margin:40px auto 0px; padding: 0px 0px 0px 0px;text-align: center; width: 100%;border-collapse:collapse;}
            .tabl{margin:0px auto; padding: 0px 0px 0px 0px;text-align: center; width: 100%;border-collapse:collapse;}
            .c{ margin: 0 auto;width: 50%;text-align: left;}
            .h{text-align: center;padding: 20px 0;}
            .text{margin-left: 60px;padding: 20px 0;}
            .title{ font-size: 20px;padding: 20px 0;}
            .button{ margin: 0 auto; width: 15%}
            .subtext{font-size: 20px;}            
            th,td{ border-bottom-style:solid; height: 40px;}
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
        <div class="b">
            <div class="c">
                <div class="title">系统介绍</div>
                <div class="text">本系统将帮助同学熟悉试题的形式和解题方式。通过使用本系统，同学可以学习到一些重要的编程方法，
                    提高自己的编程水平，提升自己的竞争力。</div>
                <div class="title">编译环境</div>
                <div class="text">
                    <table class="tabl">
                        <tr>
                            <th scope="col">语言</th>
                            <th scope="col">编译环境</th>
                            <th scope="col">编译选项</th>
                        </tr>                
                        <tr>
                            <td>java</td>
                            <td>jdk1.8</td>
                            <td>javac java</td>                    
                        </tr>
                        <tr>
                            <td>c</td>
                            <td>gcc</td>
                            <td>gcc c.c -op c</td>                    
                        </tr>
                        <tr>
                            <td>c++</td>
                            <td>g++</td>
                            <td>g++ cpp.cpp -o cpp</td>                    
                        </tr>
                    </table>
                </div>
                <div class="title">java主类名称</div>
                <div class="text">java主类名称必须为java，否则程序将无法编译会报错！</div>
                <div class="title">打分详情</div>
                <div class="text">在试题中，样例只是满足问题描述的一组可能的输入和与其对应的输出。
                    程序对于样例运行正确只表示在这一种情况下是正确的，可能在更复杂的情况下是错误的。
                    在评测的时候，评测系统会使用多种不同的输入对程序进行评测，只有通过了所有的数据才会认为程序是正确的。
                    <br><br><br><br><br><br><br>
                </div>
            </div>
        </div>
    </body>
</html>
