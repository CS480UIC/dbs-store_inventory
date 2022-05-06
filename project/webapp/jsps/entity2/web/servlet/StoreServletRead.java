package entity2.web.servlet;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity2.dao.StoreDao;
import entity2.domain.Store;
//import entity1.service.Entity1Service;


/**
 * Servlet implementation class UserServlet
 */

public class StoreServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreServletRead() {
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
		Store entity1 = null;
		try {
			entity1 = StoreDao.findByID(request.getParameter("Store_Number"));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		System.out.println(entity1);
		if(entity1.getStoreID()!=null){
					System.out.println(entity1);
					request.setAttribute("store", entity1);
					request.getRequestDispatcher("/jsps/entity2/store_read_output.jsp").forward(request, response);
				
			}
			else{
			request.setAttribute("msg", "Entity not found");
			request.getRequestDispatcher("/jsps/entity2/store_read_output.jsp").forward(request, response);
		}
	}
}



