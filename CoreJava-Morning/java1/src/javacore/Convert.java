package javacore;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import javax.xml.bind.JAXBContext;  
import javax.xml.bind.JAXBException;  
import javax.xml.bind.Unmarshaller;
import com.opencsv.CSVWriter;

   
public class Convert {  
    public static void main(String[] args) throws IOException {  
    		Map<Integer, Integer> Total = new HashMap();
    		Map<Integer, Integer> map = new HashMap();
    		
   
     try {  
   
        File file = new File("src/javacore/students.xml");  
        JAXBContext jaxbContext = JAXBContext.newInstance(Students.class);  
   
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
        Students que= (Students) jaxbUnmarshaller.unmarshal(file);  
        List<Student> list=que.getStudent();  
        
        for(Student s:list) {
			Total.put(s.getRoll(), Total.getOrDefault(s.getRoll(), 0)+s.getMarks());
		}
        for(Map.Entry m : Total.entrySet()){    
            System.out.println(m.getKey()+" "+m.getValue());    
           }
        File file1 = new File("C:\\Users\\nooka\\OneDrive\\Desktop\\student.txt"); 
        BufferedWriter bf = null; 
        
        try { 
  
            // create new BufferedWriter for the output file 
            bf = new BufferedWriter(new FileWriter(file1));
            bf.write("ROLL  MARKS");
            bf.newLine();
            for (Entry<Integer, Integer> entry : 
                Total.entrySet()) { 
 
               // put key and value separated by a colon 
               bf.write(entry.getKey() + "    "
                        + entry.getValue()); 
 
               // new line 
               bf.newLine(); 
           } 
 
           bf.flush(); 
        }
        catch (IOException e) { 
            e.printStackTrace(); 
        } 
        finally { 
  
            try { 
  
                // always close the writer 
                bf.close(); 
            } 
            catch (Exception e) { 
            } 
        } 
        File file3 = new File("C:\\Users\\nooka\\OneDrive\\Desktop\\student.txt"); 
        
        BufferedReader br = new BufferedReader(new FileReader(file3)); 
        String st; 
        st=br.readLine();
        while ((st = br.readLine()) != null) 
          {String[] arr=st.split("    ");
          int x=Integer.parseInt(arr[0]);
          int y=Integer.parseInt(arr[1]);
          map.put(x, y);
          }
        int j=1;
        CSVWriter writer = new CSVWriter(new FileWriter("C:\\Users\\nooka\\OneDrive\\Desktop\\ranks.csv"));
        String l[]= {"RANK","ROLL","MARKS"};
        writer.writeNext(l);
        for (Entry<Integer, Integer> entry : 
            map.entrySet()) {
        	String l1[]= {Integer.toString(j),Integer.toString(entry.getKey()),Integer.toString(entry.getValue())};
        	writer.writeNext(l1);
        	j=j+1;
        }
      }
     
     catch (JAXBException e) {  
        e.printStackTrace();  
      }  
   
    }  
}  