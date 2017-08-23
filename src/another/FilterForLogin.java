package another;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.restMember.model.RestMember;

public class FilterForLogin implements Filter{

	private FilterConfig filterConfig;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		
	}
	
	@Override
	public void destroy() {
		filterConfig = null;
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		HttpSession session = req.getSession();
		System.out.println("come to filterForLoing");
		Object restMemId = session.getAttribute("restMemId");
		System.out.println("restMemId : "+restMemId);
		if(restMemId!=null){
			System.out.println("session裡存了一個location For f:"+req.getRequestURI());
			session.setAttribute("location", req.getRequestURI());
			res.sendRedirect(req.getContextPath()+"/front_end/activity/activityManagent.jsp");
			return;
		}else{
			System.out.println("success f");
			chain.doFilter(request, response);
		}
	}


}
