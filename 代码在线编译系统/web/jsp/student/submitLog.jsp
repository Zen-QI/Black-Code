<%@page import="java.sql.*"%>
<%@page import="SQL.MySQLLink"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>提交记录</title>
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
        <%!
            String qTable = "submitlog";
        %>
        <%
            MySQLLink sqllink = MySQLLink.getMySQLLink();
            Connection conn = sqllink.getConnection();
            String sql;
            String q_id = request.getParameter("q_id");
            String s_id = (String) request.getSession().getAttribute("userid");
            if (q_id == null) {
                sql = "select * from " + qTable + " where s_id='" + s_id + "';";
            } else {
                sql = "select * from " + qTable + " where s_id='" + s_id + "' and q_id='" + q_id + "';";
            }
//            System.out.println(sql);
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet logrs = ps.executeQuery();

            if (logrs.next()) {
                out.write("        <div class=\"tablediv\">\n");
                out.write("            <table class=\"b\">\n");
                out.write("                <tr>\n");
                out.write("                    <th scope=\"col\">试题编号</th>\n");
                out.write("                    <th scope=\"col\">试题名称</th>\n");
                out.write("                    <th scope=\"col\">提交人</th>                    \n");
                out.write("                    <th scope=\"col\">提交时间</th>\n");
                out.write("                    <th scope=\"col\">语言</th>\n");
                out.write("                    <th scope=\"col\">得分</th>\n");
                out.write("                </tr>\n");
                do {
                    out.print("<tr>");
                    out.print("<td>" + logrs.getString(1) + "</td>");

                    sql = "select name from questions where id=?;";
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, logrs.getString(5));
                    ResultSet namers = ps.executeQuery();
                    namers.next();

                    out.print("<td>" + namers.getString(1) + "</td>");
                    out.print("<td>" + (String) request.getSession().getAttribute("username") + "</td>");
                    out.print("<td>" + logrs.getTimestamp(3) + "</td>");
                    out.print("<td>" + logrs.getString(6) + "</td>");
                    int num = 0;
                    for (int i = 1; i < 6; i++) {
                        if (logrs.getString(i + 6).equals("true")) {
                            num += 20;
                        }
                    }
                    out.print("<td>" + num + "</td>");
                    out.print("</tr>");
                } while (logrs.next());

                out.write("            </table>\n");
                out.write("        </div>\n");
            } else {
                out.print("无数据！");
            }
        %>
    </body>
</html>
