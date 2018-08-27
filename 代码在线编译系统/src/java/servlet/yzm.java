package servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author black
 */
import java.io.IOException;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;
import util.ImageUtils;
 
@WebServlet(name = "yzmServler",urlPatterns = {"/yzm"})

public class yzm extends HttpServlet {  
  
    public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
          
        //千万注意，像此类图片一定禁止浏览器缓存    
        response.setIntHeader("expires", 0);  
        response.setHeader("Cache-Control", "no-cache");  
        response.setHeader("Pragma", "no-cache");  
          
        response.setHeader("content-type", "image/jpeg");  
        ImageUtils.outputImage(response.getOutputStream(),request);
        HttpSession session=request.getSession();//返回与当前request相关联的session，如果没有则在服务器端创建一个;        
        String yzm = (String)request.getAttribute("yzm");
        session.setAttribute("yzm",yzm.toLowerCase());
    }  
  
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {    
        doGet(request, response);  
    }  
  
}  