package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RunAction {
    public String perform(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("actionName", "RUN");

        String name = request.getParameter("name") == null ? "John Doe" : request.getParameter("name");
        request.setAttribute("name", name);

        return "run";
    }

    public String hello(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("newName", "Jane Roe");

        return "hello";
    }


    // these methods are here for demo purposes :)
    @POST
    public String create() {
        return "";
    }

    @GET
    public String read() {
        return "";
    }

    @PUT
    public String update() {
        return "";
    }

    @DELETE
    public String delete() {
        return "";
    }
}
