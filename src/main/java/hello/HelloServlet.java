/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.util.Date;
import java.io.IOException;
import java.text.ParseException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author viter
 */
@WebServlet("/alomundo")
public class HelloServlet extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        
        String msg = "";
        String aprSemData="Não faço idéia qual é a sua idade.";
        String aprIdade="";
        String lang = request.getParameter("lang");
        if(lang==null)
            lang = "pt";
        switch(lang){
            case "pt":
                msg = "Alô, ";
                aprSemData=" Não faço idéia qual é a sua idade.";
                aprIdade=" Sua idade é ";
                break;
            case "en":
                msg = "Hello, ";
                aprSemData=" I have no idea how old you are.";
                aprIdade=" Your age is ";
                break;
            case "fr":
                msg = "Bonjour, ";
                aprSemData=" Je n'ai aucune idée de votre âge.";
                aprIdade=" Votre âge est ";
                break;
            case "de":
                msg = "Hallo, ";
                aprSemData=" Ich habe keine Ahnung.";
                aprIdade=" Dein Alter ist ";
                break;
        }
        
        String nome = request.getParameter("nome");
        String dataStr=request.getParameter("dataNas");
        Date dataNas=null;
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd"); 
        if(dataStr!=null){
           try {
               dataNas=format.parse(dataStr); 
           } catch (ParseException ex) {
            System.err.println(ex);
           }
        }
        Date dataHj=new Date();
        int idade=0;
        if(nome==null){
            nome = "Fulano";
        }
        
        msg = msg+nome+"!";
        if(dataStr==null){
         msg=msg+aprSemData;
        }
        else if(dataNas.compareTo(dataHj)<=0){
            idade=dataHj.getYear()-dataNas.getYear()-1;
               if (dataHj.getMonth()>dataNas.getMonth()){
                        idade+=1;
            }
            else if(dataHj.getMonth()==dataNas.getMonth()){
                       if(dataHj.getDate()>=dataNas.getDate()){
                              idade+=1;
                       }
            }
            msg=msg+aprIdade+idade+".";
        }
        else{
            msg=msg+aprSemData;
        }

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet</h1>");
            out.println("<p>" + msg + "</p>");
            out.println("</body>");
            out.println("</html>");
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

                String msg = "";
                String aprSemData="";
                String aprIdade="";
                String lang = request.getParameter("lang");
                if(lang==null)
                    lang = "pt";
                switch(lang){
                    case "pt":
                        msg = "Alô, ";
                        aprSemData=" Não faço idéia qual é a sua idade.";
                        aprIdade=" Sua idade é ";
                        break;
                    case "en":
                        msg = "Hello, ";
                        aprSemData=" I have no idea how old you are.";
                        aprIdade=" Your age is ";
                        break;
                    case "fr":
                        msg = "Bonjour, ";
                        aprSemData=" Je n'ai aucune idée de votre âge.";
                        aprIdade=" Votre âge est ";
                        break;
                    case "de":
                        msg = "Hallo, ";
                        aprSemData=" Ich habe keine Ahnung.";
                        aprIdade=" Dein Alter ist ";
                        break;
                }
                
                String nome = request.getParameter("nome");
                String dataStr=request.getParameter("dataNas");
                Date dataNas=null;
                SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd"); 
                if(dataStr!=null){
                    try {
                        dataNas=format.parse(dataStr); 
                    } catch (ParseException ex) {
                        System.err.println(ex);
                    }
                }
                Date dataHj=new Date();
                int idade=0;
                if(nome==null){
                    nome = "Fulano";
                }
                
                msg = msg+nome+"!";
                if(dataStr==null){
                 msg=msg+aprSemData;
                }
                else if(dataNas.compareTo(dataHj)<=0){
                    idade=dataHj.getYear()-dataNas.getYear()-1;
                       if (dataHj.getMonth()>dataNas.getMonth()){
                                idade+=1;
                    }
                    else if(dataHj.getMonth()==dataNas.getMonth()){
                               if(dataHj.getDate()>=dataNas.getDate()){
                                      idade+=1;
                               }
                    }
                    msg=msg+aprIdade+idade+".";
                }
                else{
                    msg=msg+aprSemData;
                }

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServle</h1>");
            out.println("<p>" + msg + "</p>");
            out.println("</body>");
            out.println("</html>");
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
