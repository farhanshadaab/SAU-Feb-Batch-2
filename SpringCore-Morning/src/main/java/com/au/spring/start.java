package com.au.spring;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import com.au.spring.teacher;
public class start {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		 AbstractApplicationContext context = new AnnotationConfigApplicationContext(Configurate.class);
	       teacher t = context.getBean(teacher.class);
	       
	       t.getName();
	       
	       System.out.println(t.getId());
	       
	       t.getCourse("CS");

	}
}
