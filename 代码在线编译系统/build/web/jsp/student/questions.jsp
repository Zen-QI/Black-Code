<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="SQL.MySQLLink"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>试题库</title>        
        <link href="top.css" rel="stylesheet" type="text/css" />
        <style type="text/css">
            .tablediv{margin:0px 0px 0px 0px; padding: 0px 0px 0px 0px;}
            .b { margin:0 auto; width:800px;border-collapse:collapse; margin-top: 80px;}
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
        <div class="tablediv">
            <table class="b">
                <tr>
                    <th scope="col">试题编号</th>
                    <th scope="col">试题名称</th>
                    <th scope="col">进入试题</th>
                    <th scope="col">本题记录</th>
                </tr>
                <%!
                    String qTable = "questions";
                %>
                <%
                    MySQLLink sqllink = MySQLLink.getMySQLLink();
                    String sql = "select * from " + qTable + ";";
                    Connection conn = sqllink.getConnection();
                    PreparedStatement ps = conn.prepareStatement(sql);

                    ResultSet rs = ps.executeQuery();
                    for (int i = 0; rs.next(); i++) {
                        String questionId = rs.getString(1);
                        out.print("<tr>");
                        out.print("<td>" + questionId + "</td>");
                        out.print("<td>" + rs.getString(2) + "</td>");
                        out.print("<td><a href='question.jsp?id=" + questionId + "'>进入</a></td>");
                        out.print("<td><a href='submitLog.jsp?q_id=" + questionId + "'>查看记录</a></td>");
                        out.print("</tr>");
                    }
                %>
            </table>
        </div>
    </body>
</html>
