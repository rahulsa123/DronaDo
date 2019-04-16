package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dronado.daos.UserDaos;
import com.dronado.pojos.User;



/**
 * Servlet Filter implementation class Authentication
 */
@WebFilter("/*")
public class Authentication implements Filter {

    /**
     * Default constructor. 
     */
	private javax.servlet.ServletContext context;
	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("AuthenticationFilter initialized");
	}
	
    public Authentication() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req =(HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		String uri = req.getRequestURI();
		String url=req.getHeader("Referer");
		System.out.println("url "+url+"\n uri"+uri);
		this.context.log("Requested Resource::" + uri);
		if(uri.endsWith("signin.jsp")||uri.endsWith("completeRegistration.jsp")||uri.endsWith("signup.jsp")||uri.endsWith("index.jsp")||uri.endsWith("LoginServlet")||uri.endsWith("SignupServlet")||uri.endsWith("js")
				|| uri.endsWith("css")  || uri.endsWith("jpg")|| uri.endsWith("png")|| uri.endsWith("SignUpServlet.jsp")|| uri.endsWith("html")) {
			this.context.log("Home Page Access");
			chain.doFilter(request, response);
		}else {
			UserDaos ud = new UserDaos();
			Cookie [] cookie = req.getCookies();
			String username =null;
			String password = null;
			if(cookie!=null) {
				for(Cookie c: cookie) {
					if(c.getName()!=null && c.getName().equals("username"))
						username = c.getValue();
					else if(c.getName()!=null && c.getName().equals("password"))
						password = c.getValue();
				}
			}
		System.out.println(username+"  "+password);
		if(username!=null && password!=null &&ud.validUser(username, password)!=-1) {
			int uid = ud.getUidByUsername(username);
			String userType = ud.getUserTypeByUId(uid);
			if(userType.equalsIgnoreCase("student")){
				session.setAttribute("uid", uid);
				session.setAttribute("userType", "student");
				chain.doFilter(request, response);
			}
			else  if(userType.equalsIgnoreCase("tutor")){
				session.setAttribute("uid", uid);
				session.setAttribute("userType", "tutor");
				chain.doFilter(request, response);
			}
		}	
		else if(session.getAttribute("userType")!=null && session.getAttribute("uid")!=null) {
			String userType = (String)session.getAttribute("userType");
			Integer uid =(Integer)session.getAttribute("uid");
			if(uid!=null && userType!=null && ud.getUserTypeByUId(uid).equalsIgnoreCase(userType)) {
				if(userType.equalsIgnoreCase("student")){
					session.setAttribute("uid", uid);
					session.setAttribute("userType", "student");
					chain.doFilter(request, response);
				}
				else  if(userType.equalsIgnoreCase("tutor")){
					session.setAttribute("uid", uid);
					session.setAttribute("userType", "tutor");
					chain.doFilter(request, response);
				}
			}
		}
		else {
			res.sendRedirect("/DronaDo/pages/index.jsp");
		}
		}
		
		
		
	}

	

}
