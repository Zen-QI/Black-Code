/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import SQL.MySQLLink;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
@WebServlet(name = "add", urlPatterns = {"/add"})
public class add extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String q_name = request.getParameter("q_name");
            String q_desc = request.getParameter("q_desc");
            String lz_data = request.getParameter("lz_data");
            String lz_answer = request.getParameter("lz_answer");
            String t_id = (String) request.getSession().getAttribute("userid");

            String test_data1 = request.getParameter("test_data1");
            String test_answer1 = request.getParameter("test_answer1");
            String test_data2 = request.getParameter("test_data2");
            String test_answer2 = request.getParameter("test_answer2");
            String test_data3 = request.getParameter("test_data3");
            String test_answer3 = request.getParameter("test_answer3");
            String test_data4 = request.getParameter("test_data4");
            String test_answer4 = request.getParameter("test_answer4");
            String test_data5 = request.getParameter("test_data5");
            String test_answer5 = request.getParameter("test_answer5");

            MySQLLink sqllink = MySQLLink.getMySQLLink();
            Connection conn = sqllink.getConnection();
            String sql = "INSERT INTO `questions` VALUES (?,?,?,?,?,?);";
            PreparedStatement ps;
            try {
                ps = conn.prepareStatement(sql);
                ps.setString(1, null);
                ps.setString(2, q_name);
                ps.setString(3, q_desc);
                ps.setString(4, lz_data);
                ps.setString(5, lz_answer);
                ps.setString(6, t_id);
                ps.executeUpdate();
                
                sql = "select id from questions where name=? and test_data=? and test_answer=?;";
                ps = conn.prepareStatement(sql);
                ps.setString(1, q_name);
                ps.setString(2, lz_data);
                ps.setString(3, lz_answer);
                ResultSet rs = ps.executeQuery();
                rs.next();
                
                sql = "INSERT INTO `answer` VALUES (?,?,?,?,?,?,?,?,?,?,?);";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, rs.getInt(1));
                System.out.println(rs.getInt(1));
                ps.setString(2, test_data1);
                ps.setString(3, test_data2);
                System.out.println("data1="+test_data1+"\tanswer1="+test_answer1);
                ps.setString(4, test_data3);
                ps.setString(5, test_data4);
                System.out.println("data2="+test_data2+"\tanswer2="+test_answer2);
                ps.setString(6, test_data5);
                ps.setString(7, test_answer1);
                System.out.println("data3="+test_data3+"\tanswer3="+test_answer3);
                ps.setString(8, test_answer2);
                ps.setString(9, test_answer3);
                System.out.println("data4="+test_data4+"\tanswer4="+test_answer4);
                ps.setString(10, test_answer4);
                ps.setString(11, test_answer5);
                System.out.println("data5="+test_data5+"\tanswer5="+test_answer5);
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(add.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            response.sendRedirect("http://localhost:8080/code/jsp/teacher/teacherMain.jsp");
        }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
