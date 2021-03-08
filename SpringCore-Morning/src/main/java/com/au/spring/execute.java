package com.au.spring;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class execute {
	public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(configure.class);
        rectangle rect = (rectangle) context.getBean("rectangle");
        System.out.println("Coordinates of the Point p1 are :" + rect.getP1().getX() + ", " + rect.getP1().getY());
        System.out.println("Coordinates of the Point p2 are :" + rect.getP2().getX() + ", " + rect.getP2().getY());
        System.out.println("Coordinates of the Point p3 are :" + rect.getP3().getX() + ", " + rect.getP3().getY());
        System.out.println("Coordinates of the Point p4 are :" + rect.getP4().getX() + ", " + rect.getP4().getY());


        System.out.println("Height of the rectangle is :" + rect.getHeight());
        System.out.println("Width of the rectangle is :" + rect.getWidth());
        List<String> alpha = rect.getAlpha();
        System.out.println("List of alphabets : "+alpha.size());
        for (int i = 0; i<alpha.size(); i++) {
                System.out.println(alpha.get(i) + " ");
        }


}
}