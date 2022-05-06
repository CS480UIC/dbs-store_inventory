package location.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import location.dao.LocationDao;
import location.domain.Location;
//import location.service.LocationService;
import location.service.LocationException;
import location.service.LocationService;

/**
 * Servlet implementation class UserServlet
 */

public class LocationServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocationServletUpdate() {
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
		LocationDao locationdao = new LocationDao();
		Location location = null;
		
		if(method.equals("search"))
		{
			try {
				location = LocationDao.findByID(request.getParameter("location_id"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
//			LocationService locationservice = new LocationService();		
			if(location.getlocation_id()!=null){
				System.out.println("11");
						System.out.println(location);
						request.setAttribute("location", location);
						request.setAttribute("location_id", location.getlocation_id());
						request.setAttribute("location_city", location.getlocation_city());
						request.setAttribute("location_state", location.getlocation_state());
						request.getRequestDispatcher("/jsps/location/location_update_output.jsp").forward(request, response);
					
				}
				else{
					
				request.setAttribute("msg", "Entity not found");
				request.getRequestDispatcher("/jsps/location/location_update_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			System.out.println("Updating!");
			Map<String,String[]> paramMap = request.getParameterMap();
			Location form = new Location();
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
			form.setlocation_id(info.get(1));
			form.setlocation_city(info.get(2));
			form.setlocation_state(info.get(3));		
			System.out.println("form:" + form);

			try {
				locationdao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Entity Updated");
			request.getRequestDispatcher("/jsps/location/location_update_output.jsp").forward(request, response);
		}
	}
}
