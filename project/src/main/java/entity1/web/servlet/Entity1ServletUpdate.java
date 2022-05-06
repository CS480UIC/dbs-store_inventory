package entity1.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity1.dao.Entity1Dao;
import entity1.domain.Entity1;
//import entity1.service.Entity1Service;
import entity1.service.Entity1Exception;
import entity1.service.Entity1Service;

/**
 * Servlet implementation class UserServlet
 */

public class Entity1ServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Entity1ServletUpdate() {
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
		Entity1Dao entity1dao = new Entity1Dao();
		Entity1 entity1 = null;
		
		if(method.equals("search"))
		{
			try {
				entity1 = Entity1Dao.findByID(request.getParameter("username"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
//			Entity1Service entity1service = new Entity1Service();		
			if(entity1.getInventory_ID()!=null){
				System.out.println("11");
						System.out.println(entity1);
						request.setAttribute("entity1", entity1);
						request.getRequestDispatcher("/jsps/entity1/entity1_update_output.jsp").forward(request, response);
					
				}
				else{
					
				request.setAttribute("msg", "Entity not found");
				request.getRequestDispatcher("/jsps/entity1/entity1_update_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			System.out.println("Updating!");
			Map<String,String[]> paramMap = request.getParameterMap();
			Entity1 form = new Entity1();
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
			form.setInventory_ID(info.get(1));
			form.setItem_SKU(info.get(2));
			form.setItem_Expiration_Date(info.get(3));		
			form.setItem_Aisle(info.get(4));	
			form.setItem_Amount(info.get(5));
			System.out.println("form:" + form);

			try {
				entity1dao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Entity Updated");
			request.getRequestDispatcher("/jsps/entity1/entity1_update_output.jsp").forward(request, response);
		}
	}
}
