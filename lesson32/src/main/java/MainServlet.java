import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.*;
import javax.servlet.http.*;

import actions.RunAction;
import actions.TestAction;

public class MainServlet extends HttpServlet {
    private static Map<String, Class> map = new HashMap<>();
    static {
        map.put("run", RunAction.class);
        map.put("test", TestAction.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String actionName = request.getParameter("action");
        String methodName = request.getParameter("method");

        String jspName = "/jsps/default.jsp";

        //request.getContextPath();
        //request.getMethod();
        // using reflection we can get all declared methods by @GET annotation
        /*String[] requestData = request.getRequestURI().split("/");
        actionName = requestData[1];
        methodName = requestData[2];*/

        //"run/hello" - action class RunAction, method name - hello

        if (actionName == null || !map.containsKey(actionName)) {
            jspName = "/jsps/404.jsp";
            response.setStatus(404);
        } else {
            try {
                Class aClass = map.get(actionName);

                Method method = aClass.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
                jspName =  "/jsps/" + (String) method.invoke(aClass.newInstance(), request, response) + ".jsp";
            } catch (Exception e) {
                throw new ServletException(e);
            }

            //jspName = "/jsps/" + jspName + ".jsp";
        }

        request.getRequestDispatcher(jspName).forward(request, response);

    }
}