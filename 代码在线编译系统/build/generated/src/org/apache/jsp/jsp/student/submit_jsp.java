package org.apache.jsp.jsp.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class submit_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>提交代码</title>\n");
      out.write("        <link href=\"top.css\" rel=\"stylesheet\" type=\"text/css\" />       \n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            .maindiv{margin: 70px auto 0px; width: 50%; text-align: left;}\n");
      out.write("            .text{margin:10px 0 0 40px; width: 800px;}\n");
      out.write("            .sub{margin:10px 0 0 100%; font-size: 20px;}\n");
      out.write("        </style>\n");
      out.write("        <script language=\"javascript\">\n");
      out.write("            function sub() {\n");
      out.write("                var id = document.getElementsByName(\"language\");\n");
      out.write("                var val;\n");
      out.write("                for (var i = 0; i < id.length; i++) {\n");
      out.write("                    if (id[i].checked) {\n");
      out.write("                        val = id[i].value;\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("                window.location.href = \"/code/compile?id=\" + ");
      out.print( request.getParameter("id"));
      out.write(" + \"&type=\" + val;\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>        \n");
      out.write("        <ul id=\"nav\"> \n");
      out.write("            <li><a href=\"studentMain.jsp\">首页</a></li> \n");
      out.write("            <li><a href=\"questions.jsp\">试题库</a></li> \n");
      out.write("            <li><a href=\"submitLog.jsp\">提交记录</a></li> \n");
      out.write("            <li><a href=\"help.jsp\">使用帮助</a></li> \n");
      out.write("            <li><a href=\"/code/exit\">退出系统</a></li> \n");
      out.write("        </ul>\n");
      out.write("        <div class=\"maindiv\">\n");
      out.write("            <form action=\"/code/compile\" method=\"POST\">\n");
      out.write("                <div>待提交试题：<a href=\"question.jsp?id= ");
      out.print( request.getParameter("id"));
      out.write('"');
      out.write('>');
      out.print( request.getParameter("qname"));
      out.write("</a></div>\n");
      out.write("                <br>\n");
      out.write("                <div>\n");
      out.write("                    <input type=\"text\" name=\"id\" value=\"");
      out.print( request.getParameter("id"));
      out.write("\" style=\"display:none;\"/>\n");
      out.write("                    编程语言：\n");
      out.write("                    <input type=\"radio\" name=\"language\" value=\"java\">java\n");
      out.write("                    <input type=\"radio\" name=\"language\" value=\"c\">c\n");
      out.write("                    <input type=\"radio\" name=\"language\" value=\"c++\">c++\n");
      out.write("                    <script>document.getElementsByName(\"language\")[0].checked = \"checked\";</script>\n");
      out.write("                </div>\n");
      out.write("                <div>\n");
      out.write("                    代码：<br>\n");
      out.write("                    <textarea class=\"text\" name=\"code\" rows=\"25\"></textarea>\n");
      out.write("                </div>\n");
      out.write("                <div><input class=\"sub\" type=\"submit\" name=\"提交\" value=\"提交代码\"/></div>\n");
      out.write("            </form>\n");
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
