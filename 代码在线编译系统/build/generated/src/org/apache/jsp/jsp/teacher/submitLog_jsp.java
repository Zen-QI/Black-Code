package org.apache.jsp.jsp.teacher;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import SQL.MySQLLink;

public final class submitLog_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


            String qTable = "submitlog";
        
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>查看提交记录</title>\n");
      out.write("        <link href=\"top.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            .tablediv{margin:0px 0px 0px 0px; padding: 0px 0px 0px 0px;}\n");
      out.write("            .b { margin:0 auto 100px; width:800px;border-collapse:collapse; margin-top: 80px;}\n");
      out.write("            th,td{ border-bottom-style:solid; height: 40px;}\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <ul id=\"nav\"> \n");
      out.write("            <li><a href=\"teacherMain.jsp\">首页</a></li> \n");
      out.write("            <li><a href=\"questions.jsp\">试题库</a></li> \n");
      out.write("            <li><a href=\"add.jsp\">添加试题</a></li> \n");
      out.write("            <li><a href=\"submitLog.jsp\">提交记录</a></li> \n");
      out.write("            <li><a href=\"/code/exit\">退出系统</a></li> \n");
      out.write("        </ul> \n");
      out.write("        ");
      out.write("\n");
      out.write("        ");

            MySQLLink sqllink = MySQLLink.getMySQLLink();
            Connection conn = sqllink.getConnection();
            String sql;
            String q_id = request.getParameter("q_id");
            String s_id = (String) request.getSession().getAttribute("userid");
            if (q_id == null) {
                sql = "select * from " + qTable + ";";
            } else {
                sql = "select * from " + qTable + " where  q_id='" + q_id + "';";
            }
            System.out.println(sql);
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
                    ResultSet qnamers = ps.executeQuery();
                    qnamers.next();

                    out.print("<td>" + qnamers.getString(1) + "</td>");

                    sql = "select name from user where id=?;";
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, logrs.getString(2));
                    ResultSet snamers = ps.executeQuery();
                    snamers.next();

                    out.print("<td>" + snamers.getString(1) + "</td>");
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
        
      out.write("\n");
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
