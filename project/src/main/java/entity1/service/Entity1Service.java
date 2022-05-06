package entity1.service;


import java.util.List;

import entity1.dao.Entity1Dao;
import entity1.domain.Entity1;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class Entity1Service {
	private Entity1Dao entity1Dao = new Entity1Dao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Entity1 form) throws Entity1Exception, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		// check the primary key of Entity1
		Entity1 entity1 = Entity1Dao.findByID(form.getInventory_ID());
		if(entity1.getInventory_ID() == form.getInventory_ID()) throw new Entity1Exception("This user name has been registered!");
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
