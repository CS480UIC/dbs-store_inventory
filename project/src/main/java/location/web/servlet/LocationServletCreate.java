package location.web.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import location.domain.Location;
import location.service.LocationException;
import location.service.LocationService;


/**
 * Servlet implementation class UserServlet
 */

public class LocationServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocationServletCreate() {
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
		LocationService locationservice = new LocationService();
		Map<String,String[]> paramMap = request.getParameterMap();
		Location form = new Location();
		List<String> info = new ArrayList<String>();
		System.out.println(form);
		for(String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			System.out.println(name + ":e " + Arrays.toString(values));
			System.out.println(info.add(values[0]));

		}
//		System.out.println("1");
		System.out.println(info);

		form.setlocation_id(info.get(0));
//		System.out.println("1");

		form.setlocation_city(info.get(1));
//		System.out.println("2");
		
		form.setlocation_state(info.get(2));		
//		System.out.println("3e");


		try {
			System.out.println("3");
			locationservice.create(form);
			response.sendRedirect( request.getContextPath() + "/jsps/main.jsp");
			
		} catch (ClassNotFoundException | LocationException e) {
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
