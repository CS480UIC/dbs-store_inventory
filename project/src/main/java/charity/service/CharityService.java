package charity.service;


import java.util.List;

import charity.dao.CharityDao;
import charity.domain.Charity;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class CharityService {
	private CharityDao charityDao = new CharityDao();
	
	/**
	 * register a Charity
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Charity form) throws CharityException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		// check the primary key of Charity
		Charity charity = CharityDao.findByID(form.getcharity_id());
		if(charity.getcharity_id() == form.getcharity_id()) throw new CharityException("This user name has been registered!");
		charityDao.add(form);
	}
	
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return charityDao.findall();
		
	}
	
	public List<Object> queryAggregate() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return charityDao.queryAggregate();
		
	}
	
	public List<Object> queryComplex() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return charityDao.queryComplex();
		
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
