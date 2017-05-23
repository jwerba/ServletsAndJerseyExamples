package jwerba.web.servlets;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/")
public class Example1Servlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Request common objects
		try {
			String name = request.getParameter("name"); // ?name=Pablito
			Cookie[] cookies = request.getCookies();
			String accept = request.getHeader("Accept");
			String browser = request.getHeader("User-Agent");
			String verb = request.getMethod();

			response.setContentType("text/html");
			response.getWriter().println("<HTML><HEAD></HEAD><BODY>");
			response.getWriter().println(String.format("Hello  %s <BR>", name));
			response.getWriter().println(String.format("%s <BR>", cookies == null ? "0 cookies" : cookies.length));
			response.getWriter().println(String.format("%s <BR>", accept));
			response.getWriter().println(String.format("%s <BR>", verb));
			response.getWriter().println(String.format("%s <BR>", browser));
			response.getWriter().println(String.format("%s <BR>", request.getLocale().getDisplayName()));
			response.getWriter().println("</BODY></HTML>");
			response.setStatus(HttpServletResponse.SC_OK);

		} catch (Exception ex) {
			response.sendError(505);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * AsyncContext context = request.getAsyncContext(); context.start(()->{
		 * try { Thread.sleep(5000); } catch (InterruptedException e) {}
		 * 
		 * context.complete();
		 * 
		 * });
		 */
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
