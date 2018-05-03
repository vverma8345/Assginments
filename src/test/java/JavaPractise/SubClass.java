package JavaPractise;

public class SubClass extends MethodFinalConcept{

	public void method( )
	{
		
		System.out.println("final method called");
		
	}
	public static void main(String[] args) {
	
		SubClass sb = new SubClass();
		sb.method("vimal");
		
		MethodFinalConcept md = new MethodFinalConcept();
		md.method("vimal");
	}

}
