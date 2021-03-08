package com.au.spring;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class configure {
	@Bean(name="rectangle")
    public rectangle createReactangleobject() {
		List<String> alphabets = new ArrayList<String>(); 
        alphabets.add("a");
        alphabets.add("b");
        alphabets.add("c");
        return new rectangle(getpointP1(),getpointP2(),getpointP3(),getpointP4(),alphabets);
    }

    @Bean(name="p1")
    public point getpointP1() {
        return new point(0,0);
    }

    @Bean(name="p2")
    public point getpointP2() {
        return new point(5,0);
    }

    @Bean(name="p3")
    public point getpointP3() {
        return new point(5,5);
    }

    @Bean(name="p4")
    public point getpointP4() {
        return new point(0,5);
    }

}
