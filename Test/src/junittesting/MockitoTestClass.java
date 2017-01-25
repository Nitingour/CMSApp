package junittesting;

import static org.mockito.Mockito.*;
import static org.testng.Assert.*;
import org.junit.Before;
import services.AdminService;
import org.testng.annotations.Test;

import beans.CommentBean;
import beans.Product;
import dao.AdminDBOperation;
public class MockitoTestClass {
	AdminService adminservice;
	@Before
	public void setUp()
	{
		adminservice=mock(AdminService.class);
		
	}
	@Test
	public void getNextArticleIDTest() {
		when(adminservice.getNextArticleID()).thenReturn(253);
		System.out.println("Next ArticleID Mockito Test:" + adminservice.getNextArticleID());
		assertEquals(adminservice.getNextArticleID(), 253);
	}
	
	@Test
	public void insertArticle() 
	{  Product p=new Product();
	p.setAid(252);
	p.setName("Java Article");
	p.setDescription("A new java programming article");
		when(adminservice.insertArticle(p)).thenReturn(1);
		System.out.println("Insert Article Mockito Test:" + adminservice.insertArticle(p));
		assertEquals(adminservice.insertArticle(p), 1);
	}
	
	@Test
	public void loginCheck() 
	{  
		AdminDBOperation admindb=mock(AdminDBOperation.class);
		when(admindb.loginCheck("nitin","nitin")).thenReturn(1);
		System.out.println("Login Check Mockito Test:" + admindb.loginCheck("nitin","nitin"));
		assertEquals(admindb.loginCheck("nitin","nitin"), 1);
	}
	
	
	@Test
	public void getAllArticles() 
	{  when(adminservice.getAllArticles()).thenReturn(new java.util.ArrayList());
		System.out.println("Get All Articles Mockito Test:" + adminservice.getAllArticles());
		assertEquals(adminservice.getAllArticles(), new java.util.ArrayList());
	}
	
	@Test
	public void deleteArticle() 
	{  when(adminservice.deleteArticle(250)).thenReturn(1);
		System.out.println("Delete Articles Mockito Test:" + adminservice.deleteArticle(250));
		assertEquals(adminservice.deleteArticle(250), 1);
	}
	
	@Test
	public void updateArticle() 
	{  when(adminservice.updateArticle(249,"WP","Wordpress")).thenReturn(1);
		System.out.println("Update Articles Mockito Test:" + adminservice.updateArticle(249,"WP","Wordpress"));
		assertEquals(adminservice.updateArticle(249,"WP","Wordpress"), 1);
	}
	
	@Test
	public void insertComment() 
	{ CommentBean cb=new CommentBean();
	   cb.setAid(250);
	   cb.setDescrip("Nice Article"); 
		when(adminservice.insertComment(cb)).thenReturn(1);
		System.out.println("Update Articles Mockito Test:" + adminservice.insertComment(cb));
		assertEquals(adminservice.insertComment(cb), 1);
	}
	
}