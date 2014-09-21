/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package src;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Properties;
import javax.mail.AuthenticationFailedException;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Richa
 */
@WebServlet(name = "mail", urlPatterns = {"/mail"})
public class mail extends HttpServlet {
    protected void processRequest(HttpServletRequest request,
HttpServletResponse response) throws IOException, ServletException {

response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
            final String to = "scoutsbrooklyn@gmail.com";
            String name = request.getParameter("name");
            String from= request.getParameter("email");
            String subject=request.getParameter("subject");
            String message = request.getParameter("comments");
            final String pass= "brooklynscouts123";

try {
Properties props = new Properties();
props.setProperty("mail.smtp.host", "smtp.gmail.com");
props.setProperty("mail.smtp.port", "587");
props.setProperty("mail.smtp.auth", "true");
props.setProperty("mail.smtp.starttls.enable", "true");
props.setProperty("mail.debug.auth", "true");
Authenticator auth = new SMTPAuthenticator(to, pass);

Session session= Session.getInstance(props, new javax.mail.Authenticator() {
protected PasswordAuthentication getPasswordAuthentication() {
    return new PasswordAuthentication(to, pass);
}});
MimeMessage msg= new MimeMessage(session);
        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        msg.setSubject(subject);
        msg.setSentDate(new Date());
        msg.setText("Message From:"+name+"\nSender Email-Address:"+from+"\nMessage:"+message);
        Transport.send(msg);

} catch (AuthenticationFailedException ex) {
request.setAttribute("ErrorMessage", "Authentication failed");

RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
dispatcher.forward(request, response);
return;

} catch (AddressException ex) {
request.setAttribute("ErrorMessage", "Wrong email address");

RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
dispatcher.forward(request, response);
return;
} catch (MessagingException ex) {
request.setAttribute("ErrorMessage", ex.getMessage());

RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
dispatcher.forward(request, response);
return;
}
RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
dispatcher.forward(request, response);
return;
}

private class SMTPAuthenticator extends Authenticator {

private PasswordAuthentication authentication;

public SMTPAuthenticator(String login, String password) {
authentication = new PasswordAuthentication(login, password);
}

protected PasswordAuthentication getPasswordAuthentication() {
return authentication;
}
}

protected void doPost(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException {
processRequest(request, response);
}


    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

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
