package junittesting;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import beans.Product;
import dao.AdminDBOperation;
import services.AdminService;

public class AdminServiceTestCase {

	@Test
	public void getNextArticleIDTest() {
		AdminService as=new AdminService();
		int result=as.getNextArticleID();
		assertEquals(251, result);
	}
	
	@Test
	public void insertArticleTest()
	{  int x=0;   
	Product p=new Product();
	p.setAid(251);
	p.setName("Java Article");
	p.setDescription("A new java programming article");
		Session session=new AdminDBOperation().getHibernateSession();
        Transaction tt=session.beginTransaction();
		  if(session.save(p)!=null)
			  x=1;
        tt.commit();
        session.close();
		assertEquals(1, x);
		
	}

}
