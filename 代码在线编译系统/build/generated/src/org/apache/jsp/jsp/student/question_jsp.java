package org.apache.jsp.jsp.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import SQL.MySQLLink;

public final class question_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>试题</title>\n");
      out.write("        <link href=\"top.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            .b {margin:40px auto 0px; padding: 0px 0px 0px 0px;text-align: center; width: 100%}\n");
      out.write("            .c{ margin: 0 auto;width: 50%;text-align: left;}\n");
      out.write("            .h{text-align: center;padding: 20px 0;}\n");
      out.write("            .text{margin-left: 60px;padding: 20px 0;}\n");
      out.write("            .title{ font-size: 20px;padding: 20px 0;}\n");
      out.write("            .button{ margin: 0 auto; width: 15%}\n");
      out.write("            .subtext{font-size: 20px;}\n");
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
      out.write("        ");
      out.write("\n");
      out.write("        <div class=\"b\">\n");
      out.write("            <div class=\"c\">\n");
      out.write("                ");

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
                                +questionId+"'\">提交代码</button></div>            \n");
                    }
                
      out.write("\n");
      out.write("            </div>\n");
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
