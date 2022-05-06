package entity2.service;


import java.util.List;


import entity2.dao.StoreDao;
import entity2.domain.Store;

public class StoreService {
	private StoreDao entity1Dao = new StoreDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Store form) throws StoreException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		// check the primary key of Entity1
		Store entity1 = StoreDao.findByID(form.getStoreID());
		if(entity1.getStoreID() == form.getStoreID()) throw new StoreException("This user name has been registered!");
		entity1Dao.add(form);
	}
	
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return entity1Dao.findall();
		
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
