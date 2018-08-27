package org.apache.jsp.jsp.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import SQL.MySQLLink;

public final class questions_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


                    String qTable = "questions";
                
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>试题库</title>        \n");
      out.write("        <link href=\"top.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            .tablediv{margin:0px 0px 0px 0px; padding: 0px 0px 0px 0px;}\n");
      out.write("            .b { margin:0 auto; width:800px;border-collapse:collapse; margin-top: 80px;}\n");
      out.write("            th,td{ border-bottom-style:solid; height: 40px;}\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <ul id=\"nav\"> \n");
      out.write("            <li><a href=\"studentMain.jsp\">首页</a></li> \n");
      out.write("            <li><a href=\"questions.jsp\">试题库</a></li> \n");
      out.write("            <li><a href=\"submitLog.jsp\">提交记录</a></li> \n");
      out.write("            <li><a href=\"help.jsp\">使用帮助</a></li> \n");
      out.write("            <li><a href=\"/code/exit\">退出系统</a></li> \n");
      out.write("        </ul> \n");
      out.write("        <div class=\"tablediv\">\n");
      out.write("            <table class=\"b\">\n");
      out.write("                <tr>\n");
      out.write("                    <th scope=\"col\">试题编号</th>\n");
      out.write("                    <th scope=\"col\">试题名称</th>\n");
      out.write("                    <th scope=\"col\">进入试题</th>\n");
      out.write("                    <th scope=\"col\">本题记录</th>\n");
      out.write("                </tr>\n");
      out.write("                ");
      out.write("\n");
      out.write("                ");

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
                        out.print("<td><a href='submitLog.jsp?id=" + questionId + "'>查看记录</a></td>");
                        out.print("</tr>");
                    }
                
      out.write("\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
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
