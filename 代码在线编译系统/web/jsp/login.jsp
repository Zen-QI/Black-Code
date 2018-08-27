<%@page import="SQL.MySQLLink"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>系统登录</title>
        <style type="text/css">
            .maindiv{ margin:auto; margin-top:200px;text-align:center;border:1px solid black; width:600px; height:220px;}
            .yzmdiv{padding-left: 35px;}
        </style>
    </head>

    <body background="./image/bgimage.jpg">
        
        <%
            if (request.getParameter("sub") != null) {

                String dlid = request.getParameter("user");
                String dlpass = request.getParameter("pass");
                String dlyzm = request.getParameter("dlyzm");
                dlyzm.toLowerCase();
                String yzm = (String) session.getAttribute("yzm");
//                out.print("输入yzm=" + dlyzm + "   yzm=" + yzm + "   结果=" + (dlyzm.equals(yzm)));
//                System.out.println("输入yzm=" + dlyzm + "   yzm=" + yzm + "   结果=" + (dlyzm.equals(yzm)));

                if (yzm.equals(dlyzm)) {

                    MySQLLink sqlLink = MySQLLink.getMySQLLink();//调用数据库链接类
                    Connection conn = sqlLink.getConnection();//获取链接

                    String sql = "select * from user where id = ?;";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setString(1, dlid);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        if (dlpass.equals(rs.getString(2))) {
                            String furl;
                            if (rs.getInt(4) == 0) {
                                furl = "http://localhost:8080/code/jsp/student/studentMain.jsp";
                            } else {
                                furl = "http://localhost:8080/code/jsp/teacher/teacherMain.jsp";
                            }
                            request.getSession().setAttribute("userid", dlid);
                            request.getSession().setAttribute("username", rs.getString(3));
                            response.sendRedirect(furl);
                        } else {
                            pageContext.setAttribute("usererr", "帐号或密码错误!");
                        }
                    } else {
                        pageContext.setAttribute("usererr", "帐号或密码错误!");
                    }
                    rs.close();
                    ps.close();
                    conn.close();
                } else {
                    pageContext.setAttribute("yzmerr", "验证码错误!");
                }
            }
        %>
        
        <div class="maindiv">
            <h2>在线网络考试系统登录<br/></h2>
            <form action="" method="post">
                <img src="./image/user.gif" />  用户名：<input type="text" name="user" style="background-color:#FFFFCC"/>
                <%
                    if (request.getParameter("sub") != null && pageContext.getAttribute("usererr") != null) {
                        out.print(pageContext.getAttribute("usererr"));
                    }
                %><br/>
                <img src="./image/pass.gif" />密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="pass" style=" background-color:#FFFFCC"/><br/>
                <div class="yzmdiv"
                     <table>
                        <tr>
                            <td><img src="./image/yzm.gif"/></td>
                            <td>验证码：</td>
                            <td><input type="text" name="dlyzm" style=" width:60px; height:18px;" /></td>
                            <td><img src="./yzm" onclick="this.src = './yzm?' + Math.random()" id="yzm"/></td>
                            <%
                                if (request.getParameter("sub") != null && pageContext.getAttribute("yzmerr") != null) {
                                    out.print("<td>" + pageContext.getAttribute("yzmerr") + "</td>");
                                }
                            %>
                        </tr>
                    </table>
                </div>
                <br>
                    <input type="submit" name="sub" value="登录" style="width:80px; height:40px; font-size:20px;"/>
            </form>
        </div>       
    </body>
</html>
