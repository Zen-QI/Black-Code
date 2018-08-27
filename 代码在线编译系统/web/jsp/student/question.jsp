<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="SQL.MySQLLink"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>试题</title>
        <link href="top.css" rel="stylesheet" type="text/css" />
        <style type="text/css">
            .b {margin:40px auto 0px; padding: 0px 0px 0px 0px;text-align: center; width: 100%}
            .c{ margin: 0 auto;width: 50%;text-align: left;}
            .h{text-align: center;padding: 20px 0;}
            .text{margin-left: 60px;padding: 20px 0;}
            .title{ font-size: 20px;padding: 20px 0;}
            .button{ margin: 0 auto; width: 15%}
            .subtext{font-size: 20px;}
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
        <%! String qTable = "questions";%>
        <div class="b">
            <div class="c">
                <%
                    String questionId = request.getParameter("id");
                    if (!(questionId == null || questionId.equals(""))) {
                        MySQLLink sqllink = MySQLLink.getMySQLLink();
                        String sql = "select * from " + qTable + " where id=?;";
                        Connection conn = sqllink.getConnection();
                        PreparedStatement ps = conn.prepareStatement(sql);
                        ps.setString(1, questionId);

                        ResultSet rs = ps.executeQuery();
                        rs.next();
                        String qname = rs.getString(2);
                        String qdesc = rs.getString(3);
                        String qdata = rs.getString(4);
                        String qanswer = rs.getString(5);

                        out.write("            <div class=\"h\"><h1>");
                        out.print(qname);
                        out.write("</h1></div>\n");
                        out.write("            <div class=\"title\">问题描述</div>\n");
                        out.write("            <div class=\"text\">");
                        out.print(qdesc);
                        out.write("</div>\n");
                        out.write("            <div class=\"title\">样例输入</div>\n");
                        out.write("            <div class=\"text\">");
                        out.print(qdata);
                        out.write("</div>\n");
                        out.write("            <div class=\"title\">样例输出</div>\n");
                        out.write("            <div class=\"text\">");
                        out.print(qanswer);
                        out.write("</div>\n");
                        out.write("            <div class=\"button\"><button class=\"subtext\" onclick=\"window.location.href='submit.jsp?id="
                                +questionId+"&qname="+qname+"'\">提交代码</button></div>            \n");
                    }
                %>
            </div>
        </div>
    </body>
</html>
