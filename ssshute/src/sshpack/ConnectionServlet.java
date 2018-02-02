package sshpack;


import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.neoremind.sshxcute.core.ConnBean;
import net.neoremind.sshxcute.core.SSHExec;

/**
 * Servlet implementation class CommandServlet
 */
@WebServlet("/ConnectionServlet")
public class ConnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnectionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		HttpSession ses=request.getSession(true);
		Boolean attribute = (Boolean)ses.getAttribute("LOG");
		if(attribute == null || !attribute)
		{
			request.setAttribute("message","You are not Logged-IN");
			RequestDispatcher rd1=request.getRequestDispatcher("/Login.jsp");
			rd1.forward(request, response);
		}else{
		RequestDispatcher rd=null;
		HttpSession session = request.getSession(true);
		ServletContext context=getServletContext();
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String ip=request.getParameter("ip");
		String user_remote=request.getParameter("user_remote");
		String pass_remote=request.getParameter("pass_remote");
			
		if(ip == null || user_remote == null || pass_remote == null)
		{
			request.setAttribute("ip",ip);
			request.setAttribute("user_remote",user_remote);
			request.setAttribute("pass_remote",pass_remote);
			rd=request.getRequestDispatcher("/Connection.jsp");
			rd.forward(request, response);
		}
		else
		{
			ConnBean conn=new ConnBean(ip, user_remote, pass_remote);
			SSHExec instance = SSHExec.getInstance(conn);
			if(instance.connect())
			{
				PrintWriter out=response.getWriter();
				out.println("successfully connected");
				session.setAttribute("instance",instance);
				request.setAttribute("instance",instance);
				rd=context.getRequestDispatcher("/CommandExec.jsp");
				rd.include(request, response);
				
			}
			else
			{
				request.setAttribute("message_error","credentials not correct/server not found");
				rd=request.getRequestDispatcher("/Connection.jsp");
				rd.forward(request, response);
			}
			
			
		}
		}
	
	}

}
