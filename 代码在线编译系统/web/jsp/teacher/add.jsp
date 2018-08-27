<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>添加试题</title>
        <link href="top.css" rel="stylesheet" type="text/css" />
        <style type="text/css">
            .b {margin:40px auto 0px; padding: 0px 0px 0px 0px;text-align: center; width: 100%;border-collapse:collapse;}
            .tabl{margin:0px auto; padding: 0px 0px 0px 0px;text-align: center; width: 100%;border-collapse:collapse;}
            .c{ margin: 0 auto;width: 30%;text-align: left;}
            .h{text-align: center;padding: 20px 0;}
            .text{margin-left: 60px;padding: 20px 0;}
            .title{ font-size: 20px;padding: 20px 0;}
            .button{ margin: 0 auto; width: 15%}
            .subtext{font-size: 20px;}            
            th,td{ border-bottom-style:solid; height: 40px;}
            .textarea{ width: 500px;}
            .inputtext{height: 25px;width: 250px; margin-bottom: 5px;}
            .inputsub{font-size: 30px; margin-right: 50px;}
            .inputsubdiv{text-align: right;}
        </style>
        <script language="javascript">
            function sub() {
                var q_name = document.getElementsByName("q_name").value;
                var q_desc = document.getElementsByName("q_desc").value;
                var lz_data = document.getElementsByName("lz_data").value;
                var lz_answer = document.getElementsByName("lz_answer").value;
                if (q_name == "" || q_desc == "" || lz_data == "" || lz_answer == "") {
                    alert("某个数据为空！");
                    return false;
                }
                var test_data, test_answer;
                for (var i = 1; i < 6; i++) {
                    test_data = document.getElementsByName("test_data" + i).value;
                    test_answer = document.getElementsByName("test_answer" + i).value;
                    if (test_data == "" || test_answer == "") {
                        alert("某个数据为空！");
                        return false;
                    }
                }
                return true;
            }
        </script>
    </head>
    <body>
        <ul id="nav"> 
            <li><a href="teacherMain.jsp">首页</a></li> 
            <li><a href="questions.jsp">试题库</a></li> 
            <li><a href="add.jsp">添加试题</a></li> 
            <li><a href="submitLog.jsp">提交记录</a></li> 
            <li><a href="/code/exit">退出系统</a></li> 
        </ul> 
        <div class="b">
            <div class="c">
                <form action="/code/add" method="post">
                    <div>
                        提示：样例数据是让学生观看的，测试数据则是对学生提交的代码进行测试的。有多行输入或输出时
                        请输入“\n”表示换行，否则会出现编译错误！
                    </div>
                    <div class="title">题目名称</div>
                    <div class="text"><input class="inputtext" type="text" name="q_name" /></div>
                    <div class="title">题目描述</div>
                    <div class="text"><textarea class="textarea" name="q_desc" rows="5"></textarea></div>
                    <div class="title">样例数据</div>
                    <div class="text">
                        样例数据：<input class="inputtext" type="text" name="lz_data"/><br>
                        样例答案：<input class="inputtext" type="text" name="lz_answer"/>                    
                    </div>
                    <div class="title">测试数据1</div>
                    <div class="text">
                        测试数据：<input class="inputtext" type="text" name="test_data1"/><br>
                        测试答案：<input class="inputtext" type="text" name="test_answer1"/>                    
                    </div>
                    <div class="title">测试数据2</div>
                    <div class="text">
                        测试数据：<input class="inputtext" type="text" name="test_data2"/><br>
                        测试答案：<input class="inputtext" type="text" name="test_answer2"/>                    
                    </div>
                    <div class="title">测试数据3</div>
                    <div class="text">
                        测试数据：<input class="inputtext" type="text" name="test_data3"/><br>
                        测试答案：<input class="inputtext" type="text" name="test_answer3"/>                    
                    </div>
                    <div class="title">测试数据4</div>
                    <div class="text">
                        测试数据：<input class="inputtext" type="text" name="test_data4"/><br>
                        测试答案：<input class="inputtext" type="text" name="test_answer4"/>                    
                    </div>
                    <div class="title">测试数据5</div>
                    <div class="text">
                        测试数据：<input class="inputtext" type="text" name="test_data5"/><br>
                        测试答案：<input class="inputtext" type="text" name="test_answer5"/>                    
                    </div>
                    <div class="inputsubdiv"><input class="inputsub" type="submit" name="sub" onsubmit="sub()"/></div>
                    <br><br><br><br><br><br><br>
                </form>
            </div>
        </div>
    </body>
</html>
