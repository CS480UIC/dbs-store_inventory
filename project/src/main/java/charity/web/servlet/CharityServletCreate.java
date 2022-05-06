package charity.web.servlet;

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

import charity.domain.Charity;
import charity.service.CharityException;
import charity.service.CharityService;


/**
 * Servlet implementation class UserServlet
 */

public class CharityServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CharityServletCreate() {
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
		CharityService charityservice = new CharityService();
		Map<String,String[]> paramMap = request.getParameterMap();
		Charity form = new Charity();
		List<String> info = new ArrayList<String>();
		System.out.println(form);
		for(String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			System.out.println(name + ":e " + Arrays.toString(values));
			System.out.println(info.add(values[0]));

		}
//		System.out.println("1");
		System.out.println(info);

		form.setcharity_id(info.get(0));
//		System.out.println("1");

		form.setcharity_name(info.get(1));
//		System.out.println("2");
		
		form.setcharity_location(info.get(2));		
//		System.out.println("3e");


		try {
			System.out.println("3");
			charityservice.create(form);
			response.sendRedirect( request.getContextPath() + "/jsps/main.jsp");
			
		} catch (ClassNotFoundException | CharityException e) {
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
