package javacore;
class Singleton 
{ 
	
	private static Singleton single_instance = null; 

	
	public String s; 

	
	private Singleton() 
	{ 
		s = "Hello World"; 
	} 

	
	public static Singleton getInstance() 
	{ 
		if (single_instance == null) 
			single_instance = new Singleton(); 

		return single_instance; 
	} 
} 

class Main 
{ 
	public static void main(String args[]) 
	{ 
		
		Singleton x = Singleton.getInstance(); 



	
		x.s = (x.s).toUpperCase(); 

		System.out.println("String from x is " + x.s); 
		System.out.println("\n"); 


	
	} 
} 

