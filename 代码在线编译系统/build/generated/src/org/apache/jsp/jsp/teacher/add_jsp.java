package org.apache.jsp.jsp.teacher;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class add_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>帮助</title>\n");
      out.write("        <link href=\"top.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            .b {margin:40px auto 0px; padding: 0px 0px 0px 0px;text-align: center; width: 100%;border-collapse:collapse;}\n");
      out.write("            .tabl{margin:0px auto; padding: 0px 0px 0px 0px;text-align: center; width: 100%;border-collapse:collapse;}\n");
      out.write("            .c{ margin: 0 auto;width: 50%;text-align: left;}\n");
      out.write("            .h{text-align: center;padding: 20px 0;}\n");
      out.write("            .text{margin-left: 60px;padding: 20px 0;}\n");
      out.write("            .title{ font-size: 20px;padding: 20px 0;}\n");
      out.write("            .button{ margin: 0 auto; width: 15%}\n");
      out.write("            .subtext{font-size: 20px;}            \n");
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
      out.write("        <div class=\"b\">\n");
      out.write("            <div class=\"c\">\n");
      out.write("                <div class=\"title\">系统介绍</div>\n");
      out.write("                <div class=\"text\">本系统将帮助同学熟悉试题的形式和解题方式。通过使用本系统，同学可以学习到一些重要的编程方法，\n");
      out.write("                    提高自己的编程水平，提升自己的竞争力。</div>\n");
      out.write("                <div class=\"title\">编译环境</div>\n");
      out.write("                <div class=\"text\">\n");
      out.write("                    <table class=\"tabl\">\n");
      out.write("                        <tr>\n");
      out.write("                            <th scope=\"col\">语言</th>\n");
      out.write("                            <th scope=\"col\">编译环境</th>\n");
      out.write("                            <th scope=\"col\">编译选项</th>\n");
      out.write("                        </tr>                \n");
      out.write("                        <tr>\n");
      out.write("                            <td>java</td>\n");
      out.write("                            <td>jdk1.8</td>\n");
      out.write("                            <td>javac java</td>                    \n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>c</td>\n");
      out.write("                            <td>gcc</td>\n");
      out.write("                            <td>gcc c.c -op c</td>                    \n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>c++</td>\n");
      out.write("                            <td>g++</td>\n");
      out.write("                            <td>g++ cpp.cpp -o cpp</td>                    \n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"title\">java主类名称</div>\n");
      out.write("                <div class=\"text\">java主类名称必须为java，否则程序将无法编译会报错！</div>\n");
      out.write("                <div class=\"title\">打分详情</div>\n");
      out.write("                <div class=\"text\">在试题中，样例只是满足问题描述的一组可能的输入和与其对应的输出。\n");
      out.write("                    程序对于样例运行正确只表示在这一种情况下是正确的，可能在更复杂的情况下是错误的。\n");
      out.write("                    在评测的时候，评测系统会使用多种不同的输入对程序进行评测，只有通过了所有的数据才会认为程序是正确的。\n");
      out.write("                    <br><br><br><br><br><br><br>\n");
      out.write("                </div>\n");
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
