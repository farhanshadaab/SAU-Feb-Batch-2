package com.au.spring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class rectangle {
	@Autowired
    @Qualifier("p1")
    private point p1;

    public point getP1() {
		return p1;
	}

	public void setP1(point p1) {
		this.p1 = p1;
	}

	public point getP2() {
		return p2;
	}

	public void setP2(point p2) {
		this.p2 = p2;
	}

	public point getP3() {
		return p3;
	}

	public void setP3(point p3) {
		this.p3 = p3;
	}

	public point getP4() {
		return p4;
	}

	public void setP4(point p4) {
		this.p4 = p4;
	}

	@Autowired
    @Qualifier("p2")
    private point p2;

    @Autowired
    @Qualifier("p3")
    private point p3;
    
    @Autowired
    @Qualifier("p4")
    private point p4;
    
    private List<String> alphabets;
    
    int height, width;

    public List<String> getAlpha() {
        return alphabets;
    }

    public rectangle(point p1, point p2, point p3, point p4, List<String> alphabets) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.alphabets = alphabets;
    }
    
    
    public int getHeight() {
        this.height = p4.getY() - p1.getY();
        return this.height;
    }

    public int getWidth() {
        this.width = p3.getX() - p4.getX();
        return this.width;
    }
	
}
