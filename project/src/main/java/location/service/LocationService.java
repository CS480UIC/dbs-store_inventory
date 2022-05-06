package location.service;


import java.util.List;

import location.dao.LocationDao;
import location.domain.Location;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class LocationService {
	private LocationDao locationDao = new LocationDao();
	
	/**
	 * register a Location
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Location form) throws LocationException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		// check the primary key of Location
		Location location = LocationDao.findByID(form.getlocation_id());
		if(location.getlocation_id() == form.getlocation_id()) throw new LocationException("This user name has been registered!");
		locationDao.add(form);
	}
	
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return locationDao.findall();
		
	}
	
	public List<Object> querySimple() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return locationDao.querySimple();
		
	}
	/**
	 * Login function
	 * @param form
	 * @return
	 * @throws UserException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */

}
