
//import org.apache.commons.lang3.StringUtils;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloServlet extends HttpServlet {

   @Override
   protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      super.service(req, resp);
   }

   @Override
   public void init() throws ServletException {
      super.init();
   }

   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

      response.setContentType("text/html");

      request.setAttribute("str", new String("My Attribute"));
      request.getRequestDispatcher("/test.jsp").forward(request, response);

  }
}
