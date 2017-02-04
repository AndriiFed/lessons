import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloServlet extends HttpServlet {

   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

      response.setContentType("text/html");

      try (PrintWriter out = response.getWriter()) {
         out.println("<html>");
         out.println("<head><title>Hello worm demo</title></head>");
         out.println("<body>");
         out.println("<h1>Hello, Worm!</h1>");
         out.println("<p>Request URI: " + request.getRequestURI() + "</p>");
         out.println("<p>Remote Address: " + request.getRemoteAddr() + "</p>");
         out.println("</body></html>");
      }
  }
}
