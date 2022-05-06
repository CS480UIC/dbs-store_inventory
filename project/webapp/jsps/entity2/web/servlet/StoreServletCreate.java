package entity2.web.servlet;

import java.io.IOException;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity2.domain.Store;
import entity2.service.StoreException;
import entity2.service.StoreService;


public class StoreServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public StoreServletCreate() {
        super();
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
		StoreService entity2service = new StoreService();
		Map<String,String[]> paramMap = request.getParameterMap();
		Store form = new Store();
		List<String> info = new ArrayList<String>();
		System.out.println(form);
		for(String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			System.out.println(name + ":e " + Arrays.toString(values));
			System.out.println(info.add(values[0]));

		}

		form.setStoreID(info.get(0));

		form.setStore_inventory(info.get(1));
		
		form.setItem_Expiration_Date(info.get(2));		

		form.setStore_location(info.get(3));	

		
		try {
			entity2service.create(form);
			response.sendRedirect( request.getContextPath() + "/jsps/main.jsp");
			
		} catch (ClassNotFoundException | StoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
