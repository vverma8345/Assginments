package TestNGConcept;

import org.testng.annotations.Test;
public class Parameters {
	
  @org.testng.annotations.Parameters({"browser"})
  @Test
  public void TestOne(String browser) {
	  
	  System.out.println("Lunch Browser Name : "+browser);
  }
  
  @org.testng.annotations.Parameters({"username","password"})
  @Test
  public void TestTwo(String username,String password) {
	  System.out.println("UserName : "+username);
	  System.out.println("Password : "+password);
  }
}
