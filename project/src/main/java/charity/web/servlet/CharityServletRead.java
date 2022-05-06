package charity.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import charity.dao.CharityDao;
import charity.domain.Charity;
//import charity.service.CharityService;


/**
 * Servlet implementation class UserServlet
 */

public class CharityServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CharityServletRead() {
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
		Charity charity = null;
		try {
			charity = CharityDao.findByID(request.getParameter("charity_id"));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(charity.getcharity_id()!=null){
					System.out.println(charity);
					request.setAttribute("charity", charity);
					request.setAttribute("charity_id", charity.getcharity_id());
					request.setAttribute("charity_name", charity.getcharity_name());
					request.setAttribute("charity_location", charity.getcharity_location());

					request.getRequestDispatcher("/jsps/charity/charity_read_output.jsp").forward(request, response);
				
			}
			else{
			request.setAttribute("msg", "Entity not found");
			request.getRequestDispatcher("/jsps/charity/charity_read_output.jsp").forward(request, response);
		}
	}
}



