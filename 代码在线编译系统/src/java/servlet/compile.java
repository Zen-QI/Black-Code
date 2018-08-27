/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import SQL.MySQLLink;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.SequenceInputStream;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author black
 */
@WebServlet(name = "compile", urlPatterns = {"/compile"})
public class compile extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private String url = "D:\\test\\";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        if (request.getParameter("id") != null && request.getParameter("language") != null) {

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                String language = request.getParameter("language");
                out.print("<form align='center'>");
                out.print(language+"<br>");
                if (language.equals("java")) {
                    dojava(request, response);
                } else if (language.equals("c")) {
                    doc(request, response);
                } else if (language.equals("c++")) {
                    docpp(request, response);
                }
                out.print("<a href='http://localhost:8080/code/jsp/student/studentMain.jsp'>返回首页</a>");
                out.print("</form>");
            }
        }
    }

    private void dojava(HttpServletRequest request, HttpServletResponse response) throws Exception {
        File f = new File(url + "java.java");
        f.createNewFile();
        OutputStream fout = new FileOutputStream(f);
        String id = request.getParameter("id");
        String code = request.getParameter("code");
        System.out.println(code);
        fout.write(code.getBytes());
        fout.close();

        MySQLLink sqllink = MySQLLink.getMySQLLink();
        String sql = "select * from answer where id = " + id + ";";
        Connection conn = sqllink.getConnection();
        PreparedStatement qps = conn.prepareStatement(sql);
        ResultSet rs = qps.executeQuery();
        rs.next();

        sql = "INSERT INTO `submitlog` VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, null);
        ps.setString(2, (String) request.getSession().getAttribute("userid"));
        ps.setTimestamp(3, new java.sql.Timestamp(System.currentTimeMillis()));
        ps.setString(4, code);
        ps.setInt(5, Integer.valueOf(id));
        ps.setString(6, "java");

        Runtime rt = Runtime.getRuntime();

        rt.exec("cmd /c javac " + url + "java.java", null, new File(url));
        Thread.sleep(1000);
        int num = 0;

        for (int i = 1; i < 6; i++) {
            Process pr = rt.exec("cmd /c test.bat", null, new File(url));
            BufferedWriter bout = new BufferedWriter(new OutputStreamWriter(pr.getOutputStream()));

            System.out.println("测试" + i + "----->" + rs.getString(i + 1));
            response.getWriter().println("测试" + i + "----->" + rs.getString(i + 1) + "</br>");
            bout.write(rs.getString(i + 1));
            bout.close();

            SequenceInputStream sis = new SequenceInputStream(pr.getInputStream(), pr.getErrorStream());
            InputStreamReader inst = new InputStreamReader(sis, "UTF8");
            BufferedReader br = new BufferedReader(inst);

            String res = null;
            StringBuilder sb = new StringBuilder();
            while ((res = br.readLine()) != null) {
                sb.append(res);
            }
            String old = "D:\\test>set CLASSPATH=D:\\test D:\\test>java java ";
            String newres = sb.toString().replace(old, "");
            System.out.println("结果" + i + "----->" + newres);
            response.getWriter().println("结果" + i + "----->" + newres + "<br>");
            System.out.println("对比答案为：" + newres.equals(rs.getString(i + 6)));
            response.getWriter().println("对比答案为：" + newres.equals(rs.getString(i + 6))+"<br>");
            
            if (newres.equals(rs.getString(i + 6))) {
                ps.setString(i + 6, "true");
                num += 20;
            } else {
                ps.setString(i + 6, "false");
            }
            ps.setString(i + 11, newres);
            inst.close();
            br.close();
        }
        System.out.println("分数为："+num);
        response.getWriter().println("分数为："+num+"<br>");
        ps.executeUpdate();
    }

    private void doc(HttpServletRequest request, HttpServletResponse response) throws Exception {
        File f = new File(url + "c.c");
        f.createNewFile();
        OutputStream fout = new FileOutputStream(f);
        String id = request.getParameter("id");
        String code = request.getParameter("code");
        System.out.println(code);
        fout.write(code.getBytes());
        fout.close();

        MySQLLink sqllink = MySQLLink.getMySQLLink();
        String sql = "select * from answer where id = " + id + ";";
        Connection conn = sqllink.getConnection();
        PreparedStatement qps = conn.prepareStatement(sql);
        ResultSet rs = qps.executeQuery();
        rs.next();

        sql = "INSERT INTO `submitlog` VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, null);
        ps.setString(2, (String) request.getSession().getAttribute("userid"));
        ps.setTimestamp(3, new java.sql.Timestamp(System.currentTimeMillis()));
        ps.setString(4, code);
        ps.setInt(5, Integer.valueOf(id));
        ps.setString(6, "c");

        Runtime rt = Runtime.getRuntime();
        File fc = new File(url + "c.exe");
        if (fc.exists()) {
            fc.delete();
        }
        rt.exec("cmd /c gcc c.c -o c", null, new File(url));
        Thread.sleep(1000);
        int num = 0;

        for (int i = 1; i < 6; i++) {
            Process pr = rt.exec("cmd /c " + url + "c.exe", null, new File(url));
            BufferedWriter bout = new BufferedWriter(new OutputStreamWriter(pr.getOutputStream()));

            System.out.println("测试" + i + "----->" + rs.getString(i + 1));
            response.getWriter().println("测试" + i + "----->" + rs.getString(i + 1) + "</br>");
            bout.write(rs.getString(i + 1));
            bout.close();

            SequenceInputStream sis = new SequenceInputStream(pr.getInputStream(), pr.getErrorStream());
            InputStreamReader inst = new InputStreamReader(sis, "UTF8");
            BufferedReader br = new BufferedReader(inst);

            String res = null;
            StringBuilder sb = new StringBuilder();
            while ((res = br.readLine()) != null) {
                sb.append(res);
            }
            System.out.println("结果" + i + "----->" + sb);
            response.getWriter().println("结果" + i + "----->" + sb + "<br>");
            System.out.println("对比答案为：" + sb.toString().equals(rs.getString(i + 6)));
            response.getWriter().println("对比答案为：" + sb.toString().equals(rs.getString(i + 6)));
            if (sb.toString().equals(rs.getString(i + 6))) {
                ps.setString(i + 6, "true");
                num += 20;
            } else {
                ps.setString(i + 6, "false");
            }
            ps.setString(i + 11, sb.toString());
            inst.close();
            br.close();
        }        
        System.out.println("分数为："+num);
        response.getWriter().println("分数为："+num+"<br>");
        ps.executeUpdate();
    }

    private void docpp(HttpServletRequest request, HttpServletResponse response) throws Exception {
        File f = new File(url + "cpp.cpp");
        f.createNewFile();
        OutputStream fout = new FileOutputStream(f);
        String id = request.getParameter("id");
        String code = request.getParameter("code");
        System.out.println(code);
        fout.write(code.getBytes());
        fout.close();

        MySQLLink sqllink = MySQLLink.getMySQLLink();
        String sql = "select * from answer where id = " + id + ";";
        Connection conn = sqllink.getConnection();
        PreparedStatement qps = conn.prepareStatement(sql);
        ResultSet rs = qps.executeQuery();
        rs.next();

        sql = "INSERT INTO `submitlog` VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, null);
        ps.setString(2, (String) request.getSession().getAttribute("userid"));
        ps.setTimestamp(3, new java.sql.Timestamp(System.currentTimeMillis()));
        ps.setString(4, code);
        ps.setInt(5, Integer.valueOf(id));
        ps.setString(6, "c++");

        Runtime rt = Runtime.getRuntime();
        File fc = new File(url + "cpp.exe");
        if (fc.exists()) {
            fc.delete();
        }
        rt.exec("cmd /c g++ cpp.cpp -o cpp", null, new File(url));
        Thread.sleep(1000);
        int  num = 0;

        for (int i = 1; i < 6; i++) {
            Process pr = rt.exec("cmd /c " + url + "cpp.exe", null, new File(url));
            BufferedWriter bout = new BufferedWriter(new OutputStreamWriter(pr.getOutputStream()));

            System.out.println("测试" + i + "----->" + rs.getString(i + 1));
            response.getWriter().println("测试" + i + "----->" + rs.getString(i + 1) + "</br>");
            bout.write(rs.getString(i + 1));
            bout.close();

            SequenceInputStream sis = new SequenceInputStream(pr.getInputStream(), pr.getErrorStream());
            InputStreamReader inst = new InputStreamReader(sis, "UTF8");
            BufferedReader br = new BufferedReader(inst);

            String res = null;
            StringBuilder sb = new StringBuilder();
            while ((res = br.readLine()) != null) {
                sb.append(res);
            }
            System.out.println("结果" + i + "----->" + sb);
            response.getWriter().println("结果" + i + "----->" + sb + "<br>");
            System.out.println("对比答案为：" + sb.toString().equals(rs.getString(i + 6)));
            response.getWriter().println("对比答案为：" + sb.toString().equals(rs.getString(i + 6)));
            if (sb.toString().equals(rs.getString(i + 6))) {
                ps.setString(i + 6, "true");
                num += 20;
            } else {
                ps.setString(i + 6, "false");
            }
            ps.setString(i + 11, sb.toString());
            inst.close();
            br.close();
        }
        System.out.println("分数为："+num);
        response.getWriter().println("分数为："+num+"<br>");
        ps.executeUpdate();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(compile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(compile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
