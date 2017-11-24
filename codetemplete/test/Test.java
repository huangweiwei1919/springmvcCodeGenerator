package ##{srcPack}##;




import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.test.base.JUnitBase;
import ##{srcPack}##.dao.##{domainObjectName}##Dao;
import ##{srcPack}##.model.##{domainObjectName}##Entity;



/**
 * create by genarator
 * @author MYP
 *
 * 2014-3-15
 */
public class ##{domainObjectName}##Test extends JUnitBase  {
	
	@Autowired
	##{domainObjectName}##Dao dao;
	
	@Test
	public void insert(){
		
		System.out.println();
		System.out.println("start test ---insert ");
		System.out.println();
		
		
		##{domainObjectName}##Entity entity=new ##{domainObjectName}##Entity();
		entity=dao.findProtoTypeById(1891);
//		entity.setId(1234567);
		System.out.println(dao.insert(entity));
		System.out.println("id is =="+entity.getId());
		
		
		
		
		
		System.out.println();
		System.out.println("start test ---end ");
		System.out.println();
	}
	
	@Test
	public void insertBatch(){
		
		##{domainObjectName}##Entity entity=new ##{domainObjectName}##Entity();
		entity=dao.findProtoTypeById(1891);
		##{domainObjectName}##Entity[] entitys=new ##{domainObjectName}##Entity[]{entity,entity,entity,entity};
		Map<String,Object> mapSql=new HashMap<String,Object>();
		
		
		mapSql.put("entitys", entitys);
		System.out.println(dao.insertBatch(mapSql));
		
	}
	
	
	@Test
	public void deleteByIds(){
		
		System.out.println(dao.deleteByIds(new String[]{99,88}));
		
	}
	
	
	@Test
	public void deleteById(){
		
		System.out.println(dao.deleteById(100));
		
	}
	
	
	@Test
	public void deleteBatch(){
		
		System.out.println(dao.deleteByIds(new String[]{99,88}));
		
	}
	
	
	@Test
	public void update(){
		
		##{domainObjectName}##Entity entity=new ##{domainObjectName}##Entity();
		entity=dao.findById(9999);
		System.out.println(dao.update(entity));
		
	}
	
	@Test
	public void updateWhitIf(){
		
		##{domainObjectName}##Entity entity=new ##{domainObjectName}##Entity();
		entity=dao.findById(9999);
		System.out.println(dao.updateWhitIf(entity));
		
	}
	
	@Test
	public void updateBatch(){
		
		##{domainObjectName}##Entity entity=new ##{domainObjectName}##Entity();
		entity=dao.findById(9999);
		System.out.println(dao.update(entity));
		
	}
	
	@Test
	public void findProtoTypeById(){
		Map<String,Object> mapSql=new HashMap<String,Object>();
		System.out.println(dao.findProtoTypeById(123));
		
	}
	
	
	
	
	@Test
	public void findById(){
		
		System.out.println(dao.findById(100));
		
	}
	
	@Test
	public void findByProperty(){
		
		Map<String,Object> mapSql=new HashMap<String,Object>();
		
		System.out.println(dao.findByProperty(mapSql));
		
	}	
	
	@Test
	public void list(){
		Map<String,Object> mapSql=new HashMap<String,Object>();
		System.out.println(dao.list(mapSql));
		
	}
	
	@Test
	public void findCountByMap(){
		Map<String,Object> mapSql=new HashMap<String,Object>();
		
		System.out.println(dao.findCountByMap(mapSql));
		
	}
	
}
