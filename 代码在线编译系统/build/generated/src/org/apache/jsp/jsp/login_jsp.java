package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import SQL.MySQLLink;
import java.sql.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("        <title>系统登录</title>\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            .maindiv{ margin:auto; margin-top:200px;text-align:center;border:1px solid black; width:600px; height:220px;}\n");
      out.write("            .yzmdiv{padding-left: 35px;}\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body background=\"./image/bgimage.jpg\">\n");
      out.write("        \n");
      out.write("        ");

            if (request.getParameter("sub") != null) {

                String dlid = request.getParameter("user");
                String dlpass = request.getParameter("pass");
                String dlyzm = request.getParameter("dlyzm");
                dlyzm.toLowerCase();
                String yzm = (String) session.getAttribute("yzm");
                out.print("输入yzm=" + dlyzm + "   yzm=" + yzm + "   结果=" + (dlyzm.equals(yzm)));
                System.out.println("输入yzm=" + dlyzm + "   yzm=" + yzm + "   结果=" + (dlyzm.equals(yzm)));

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
        
      out.write("\n");
      out.write("        \n");
      out.write("        <div class=\"maindiv\">\n");
      out.write("            <h2>在线网络考试系统登录<br/></h2>\n");
      out.write("            <form action=\"\" method=\"post\">\n");
      out.write("                <img src=\"./image/user.gif\" />  用户名：<input type=\"text\" name=\"user\" style=\"background-color:#FFFFCC\"/>\n");
      out.write("                ");

                    if (request.getParameter("sub") != null && pageContext.getAttribute("usererr") != null) {
                        out.print(pageContext.getAttribute("usererr"));
                    }
                
      out.write("<br/>\n");
      out.write("                <img src=\"./image/pass.gif\" />密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type=\"password\" name=\"pass\" style=\" background-color:#FFFFCC\"/><br/>\n");
      out.write("                <div class=\"yzmdiv\"\n");
      out.write("                     <table>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><img src=\"./image/yzm.gif\"/></td>\n");
      out.write("                            <td>验证码：</td>\n");
      out.write("                            <td><input type=\"text\" name=\"dlyzm\" style=\" width:60px; height:18px;\" /></td>\n");
      out.write("                            <td><img src=\"./yzm\" onclick=\"this.src = './yzm?' + Math.random()\" id=\"yzm\"/></td>\n");
      out.write("                            ");
out.print("yzm=" + (String) session.getAttribute("yzm"));
                                if (request.getParameter("sub") != null && pageContext.getAttribute("yzmerr") != null) {
                                    out.print("<td>" + pageContext.getAttribute("yzmerr") + "</td>");
                                }
                            
      out.write("\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("                <br>\n");
      out.write("                    <input type=\"submit\" name=\"sub\" value=\"登录\" style=\"width:80px; height:40px; font-size:20px;\"/>\n");
      out.write("            </form>\n");
      out.write("        </div>       \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
