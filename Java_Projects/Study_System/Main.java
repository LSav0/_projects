package homeWork3_v1;

import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		
		Employee emp = new Employee("Name1", "Name2");
		emp.setBirthDate("230498-045T");
		emp.setSalary(756.85);
	
		
		Employee emp2 = new Employee("Name1", "Name2");
		emp2.setBirthDate("141200A2315"); //invalid birthday
		emp2.setSalary(150);
		


		System.out.println(emp.toString());
		
		System.out.println(emp2.toString());
		
	
		Student student = new Student("Name2", "Name1");
		
		Student student1 = new Student("Name2", "Name2");
	
		Course c1 = new Course("Programming 1", 811104, 'P', 1, 1, 5.0, true);
		Course c2 = new Course("All kinds of basic studies", 112233, 'P', 1, 2, 45.0, true);
		Course c3 = new Course ("More basic studies", 223344, 'a', 1, 1, 50.5,  true);
		Course c4 = new Course ("Even more basic studies", 556677,  'a',  0,  3,  50.0, true);
		Course c5 = new Course("Final basic studies",  123123,  'A',  1,  4, 50.5,  true);
		Course c6 = new Course("Programming 2",  616161,  'A',  1,  3, 25.0,  true);
		Course c7 = new Course("All kinds of master studies",   717171,  'P',  0,  2, 45.0,  true);
		Course c8 = new Course("More more studies",  818181,  'A',  1,  1, 25.0,  true);
		Course c9 = new Course("Even more master studies",  919191,  'S',  1,  3, 20.0,  true);
	    Course c10 = new Course("Extra master studies",  666666,  'S',  0,  5, 8.0,  false);
		Course c11 = new Course("Final master studies",  888888,  'S',  1,  5, 18.0,  false);
		
	
		StudentCourse sc1 = new StudentCourse();
		  sc1.setCourse(c1);
		  sc1.setGrade(1);
		  sc1.setYear(2013);
		
		  StudentCourse sc2 = new StudentCourse();
		  sc2.setCourse(c2);
		  sc2.setGrade(1);
		  sc2.setYear(2014);
		
		  StudentCourse sc3 = new StudentCourse();
		  sc3.setCourse(c3);
		  sc3.setGrade(1);
		  sc3.setYear(2015);
		
		  StudentCourse sc4 = new StudentCourse();
		  sc4.setCourse(c4);
		  sc4.setGrade(4);
		  sc4.setYear(2016);
		
		  
		  StudentCourse sc5 = new StudentCourse();
		  sc5.setCourse(c5);
		  sc5.setGrade(5);
		  sc5.setYear(2017);
		 
		  StudentCourse sc6 = new StudentCourse();
		  sc6.setCourse(c6);
		  sc6.setGrade(1);
		  sc6.setYear(2018);
		  
		  
		  StudentCourse sc7 = new StudentCourse();
		  sc7.setCourse(c7);
		  sc7.setGrade(1);
		  sc7.setYear(2019);
		  
		  StudentCourse sc8 = new StudentCourse();
		  sc8.setCourse(c8);
		  sc8.setGrade(2);
		  sc8.setYear(2020);
		  
		  StudentCourse sc9 = new StudentCourse();
		  sc9.setCourse(c9);
		  sc9.setGrade(0);
		  sc9.setYear(2021);
		    
		  
		   StudentCourse sc10 = new StudentCourse();
		  sc10.setCourse(c10);
		  sc10.setGrade('A');
		  sc10.setYear(2021);
		  
		  StudentCourse sc11 = new StudentCourse();
		  sc11.setCourse(c11);
		  sc11.setGrade('f');
		  sc11.setYear(2022);
		 
		  
		  
		  ArrayList <StudentCourse> bachelor = new ArrayList<>();
		 
		  bachelor.add(sc1);
		  
		  bachelor.add(sc2);
		  
		  bachelor.add(sc3);
		  
		  bachelor.add(sc4);
		  
		  bachelor.add(sc5);
		 
	
		  
		  ArrayList <StudentCourse> masters = new ArrayList<>();
		  
          masters.add(sc6);
		  
		  masters.add(sc7);
		  
		  masters.add(sc8);
		  
          masters.add(sc9);
		  
		  masters.add(sc10);
		  
		  masters.add(sc11);
		 
		  
	    student.setDegreeTitle(0,  "Bachelor of Science");
	
   
	    
	    student.setDegreeTitle(1,  "Master of Science");
	
  
	    
		student.setTitleOfThesis(0, "Bachelor thesis title");
		
 
		
		student.setTitleOfThesis(1, "Masters thesis title");
			
		
		student.addCourses(0, bachelor);
				
		student.addCourses(1, masters);
		
		student.setStartYear(2001);
		
		System.out.print(student.toString());
		
		student.setBirthDate("230498-045T");
		
		student.setGraduationYear(2020);
		
		student.setTitleOfThesis(0, "title");

		student.setTitleOfThesis(1, "title");
		student.setGraduationYear(2020);
		
		sc9.setGrade(3);
		
		
	
	   System.out.print(student.toString());
	   System.out.print(student1.toString());
	  
	   
	   student.printDegrees();
	 
	     
	   student.printCourses();
	}

}
