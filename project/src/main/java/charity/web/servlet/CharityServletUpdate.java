package charity.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import charity.dao.CharityDao;
import charity.domain.Charity;
//import charity.service.CharityService;
import charity.service.CharityException;
import charity.service.CharityService;

/**
 * Servlet implementation class UserServlet
 */

public class CharityServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CharityServletUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Posting");
		String method = request.getParameter("method");
		CharityDao charitydao = new CharityDao();
		Charity charity = null;
		
		if(method.equals("search"))
		{
			try {
				charity = CharityDao.findByID(request.getParameter("charity_id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
//			CharityService charityservice = new CharityService();		
			if(charity.getcharity_id()!=null){
				System.out.println("11");
						System.out.println(charity);
						request.setAttribute("charity", charity);
						request.setAttribute("charity_id", charity.getcharity_id());
						request.setAttribute("charity_name", charity.getcharity_name());
						request.setAttribute("charity_location", charity.getcharity_location());
						request.getRequestDispatcher("/jsps/charity/charity_update_output.jsp").forward(request, response);
					
				}
				else{
					
				request.setAttribute("msg", "Entity not found");
				request.getRequestDispatcher("/jsps/charity/charity_update_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			System.out.println("Updating!");
			Map<String,String[]> paramMap = request.getParameterMap();
			Charity form = new Charity();
			List<String> info = new ArrayList<String>();
			for(String name : paramMap.keySet()) {
				
				String[] values = paramMap.get(name);
				for (String e : values) {
					System.out.println(name + ": " + e);
					if (e== "update") {
						continue;
					}else {
						info.add(e);
					}
				}
			}
			form.setcharity_id(info.get(1));
			form.setcharity_name(info.get(2));
			form.setcharity_location(info.get(3));		
			System.out.println("form:" + form);

			try {
				charitydao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Entity Updated");
			request.getRequestDispatcher("/jsps/charity/charity_update_output.jsp").forward(request, response);
		}
	}
}
