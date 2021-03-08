package javacore;
import java.util.List;  

import javax.xml.bind.annotation.*;  
@XmlRootElement  
public class Students {  
private List<Student> student;  

public Students() {}  
public Students(List<Student> student) {  
    super(); 
    this.student = student;  
}  
  
@XmlElement  
public List<Student> getStudent() {  
    return student;  
}  
public void setStudent(List<Student> student) {  
    this.student = student;  
}  
}  
