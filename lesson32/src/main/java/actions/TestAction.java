package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestAction {
    public String perform(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("actionName", "RUN");

        String name = request.getParameter("name") == null ? "Jane Roe" : request.getParameter("name");
        request.setAttribute("name", name);

        return "test";
    }
}
