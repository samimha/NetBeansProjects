/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sami
 */
@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

    private String farm, server, id, secret, title;

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
        URL url = new URL("https://api.flickr.com/services/rest/?method=flickr.photos.getRecent&api_key=fa2b06a18bed0a9132427315f65bc586&per_page=10&page=1&format=json&nojsoncallback=1&api_sig=a480dcf2187f15f20e03a219f331b09c");
        PrintWriter out = response.getWriter();
        InputStream is = url.openStream();
        JsonParser parser = Json.createParser(is);
        while (parser.hasNext()) {
            JsonParser.Event e = parser.next();
            if (e == Event.KEY_NAME) {
                switch (parser.getString()) {
                    case "farm":
                        parser.next();
                        farm = parser.getString();
                        break;
                    case "server":
                        parser.next();
                        server = parser.getString();
                        break;
                    case "id":
                        parser.next();
                        id = parser.getString();
                        break;
                    case "secret":
                        parser.next();
                        secret = parser.getString();
                        break;
                    case "title":
                        parser.next();
                        title = parser.getString();
                        out.println("<figure> <img src=\"https://farm" + farm + ".staticflickr.com/" + server + "/" + id + "_" + secret + ".jpg\"><figcaption>" + title + "</figcaption> </figure><br>");
                        break;
                    default:
                        break;
                }
            }
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

/*try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Servlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Servlet Servlet at " + request.getContextPath() + "</h1>");
                out.println("</body>");
                out.println("</html>");
                }*/
