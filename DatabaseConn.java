import java.util.Scanner;
import javax.swing.JOptionPane;
import com.mysql.jdbc.Connection;
import java.sql.*;

public class DatabaseConn {
		

	static Connection conn=null;
	
	static boolean connection (){
		
		try{
		//Get connection
		 conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hw2","root","");
		 if(conn!=null){
			JOptionPane.showMessageDialog(null, "connection created");
			return true;
			}		
		
		}catch(Exception e)
		{
			System.out.println("not conn");
			JOptionPane.showMessageDialog(null, "error connection");
			return false;
		}
		return false;
	}

	public  int update (String sql)
		{
			try{
				return conn.createStatement().executeUpdate(sql);
				
			}catch(SQLException e){
				e.printStackTrace();
			}
			return 0;
		}
		
	public static boolean addStudent(String id,String name, String birth, String adress) {
		//SQL STATEMENT
		String sql = "INSERT INTO student(idstudent,name,birthdate,address) VALUES('" + id + "','" + name + "','" + birth + "','" + adress + "')";
		try {
		    Statement s = conn.prepareStatement(sql);
		    s.execute(sql);
		    JOptionPane.showMessageDialog(null, "student added with succes");
		    return true;
		    
		} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "error adding student");
		        ex.printStackTrace();
		        return false;
		    }
		 
		}
	public static boolean addCourse(String id,String name, String teacher, String studyyear) {
		//SQL STATEMENT
		String sql = "INSERT INTO course(idcourse,name,teacher,studyyear) VALUES('" + id + "','" + name + "','" + teacher + "','" + studyyear + "')";
		try {
		    Statement s = conn.prepareStatement(sql);
		    s.execute(sql);
		    JOptionPane.showMessageDialog(null, "course added with succes");
		    return true;
		    
		} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "error adding course");
		        ex.printStackTrace();
		        return false;
		    }
		 
		}
	public static boolean enroll(String id,String id_s, String id_c, String date) {
		//SQL STATEMENT
		String sql = "INSERT INTO enrolment(idenrolment,idstudent,idcourse,enrolmentdate) VALUES('" + id + "','" + id_s + "','" + id_c + "','" + date + "')";
		try {
		    Statement s = conn.prepareStatement(sql);
		    s.execute(sql);
		    JOptionPane.showMessageDialog(null, "enrolment with succes");
		    return true;
		    
		} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "error enrolment");
		        ex.printStackTrace();
		        return false;
		    }
		 
		}
	public static Boolean updateStudent(String name,String newname,String newaddress){
		String sql="UPDATE student SET name='"+newname+"', address='"+newaddress+"'WHERE student.name='"+name+"'";
	try
		{	
		Statement s=conn.prepareStatement(sql);
		s.execute(sql);
		JOptionPane.showMessageDialog(null, "student updated with succes");
		return true;
	}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null, "error updating student");
		e.printStackTrace();
		return false;
		}
	}
	public static Boolean showInfoStudent(String name){
	try
		{	
		//create statement
		Statement Stmt = conn.createStatement();
		//execute sql query
		 ResultSet myRs=Stmt.executeQuery("SELECT * FROM student WHERE student.name='"+name+"'");
		 //process results
		 while(myRs.next()){
			 System.out.println(myRs.getString("idstudent")+" "+myRs.getString("name")+" "+myRs.getString("birthdate")+" "+myRs.getString("address"));
		 }
		JOptionPane.showMessageDialog(null, "student info succes");
		return true;
	}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null, "error showing student info");
		e.printStackTrace();
		return false;
		}
	}
	public static Boolean showInfoCourse(String name){
		try
			{	
			//create statement
			Statement Stmt = conn.createStatement();
			//execute sql query
			 ResultSet myRs=Stmt.executeQuery("SELECT * FROM course WHERE course.name='"+name+"'");
			 //process results
			 while(myRs.next()){
				 System.out.println(myRs.getString("idcourse")+" "+myRs.getString("name")+" "+myRs.getString("teacher")+" "+myRs.getString("studyyear"));
			 }
			JOptionPane.showMessageDialog(null, "course info succes");
			return true;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "error showing course info");
			e.printStackTrace();
			return false;
			}
		}
	public static Boolean showStudentsEnrolled(String name){
		try
			{	
			//create statement
			Statement Stmt = conn.createStatement();
			//execute sql query
			 ResultSet myRs=Stmt.executeQuery("SELECT * FROM student s, course c,enrolment e WHERE c.idcourse=e.idcourse and s.idstudent=e.idstudent and c.name='"+name+"'");
			 //process results
			 while(myRs.next()){
				 System.out.println(myRs.getString("name"));
			 }
			JOptionPane.showMessageDialog(null, "students enrolled info succes");
			return true;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "error showing students enrolled info");
			e.printStackTrace();
			return false;
			}
		}
	public static Boolean updateCourse(String name,String newteacher,String newyear){
		String sql="UPDATE course SET teacher='"+newteacher+"', studyyear='"+newyear+"'WHERE course.name='"+name+"'";
	try
		{	
		Statement s=conn.prepareStatement(sql);
		s.execute(sql);
		JOptionPane.showMessageDialog(null, "course updated with succes");
		return true;
	}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null, "error updating course");
		e.printStackTrace();
		return false;
		}
	}
	public static Boolean deleteStudent(String name){
		String sql1="DELETE FROM enrolment WHERE enrolment.idstudent in(SELECT idstudent FROM student WHERE name ='"+name+"')";
		String sql="DELETE FROM student WHERE student.name ='"+name+"'";
	try
		{	
		Statement s1=conn.prepareStatement(sql1);
		s1.execute(sql1);
		Statement s=conn.prepareStatement(sql);
		s.execute(sql);
		JOptionPane.showMessageDialog(null, "student deleted with succes");
		return true;
	}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null, "error deleting student");
		e.printStackTrace();
		return false;
		}
	}
	public static Boolean deleteCourse(String name){
		String sql1="DELETE FROM enrolment WHERE enrolment.idcourse in(SELECT idcourse FROM course WHERE name ='"+name+"')";
		String sql="DELETE FROM course WHERE course.name ='"+name+"'";
	try
		{	
		Statement s1=conn.prepareStatement(sql1);
		s1.execute(sql1);
		Statement s=conn.prepareStatement(sql);
		s.execute(sql);
		JOptionPane.showMessageDialog(null, "course deleted with succes");
		return true;
	}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null, "error deleting course");
		e.printStackTrace();
		return false;
		}
	}
		
	public static void main (String[] args){
		
		Scanner scanner = new Scanner(System.in);
		connection();
		int input;
		do{
		System.out.println("Choose option:");
		System.out.println("0.Exit:");
		System.out.println("1.Add student:");
		System.out.println("2.Update student:");
		System.out.println("3.Delete student:");
		System.out.println("4.Add course:");
		System.out.println("5.Update course:");
		System.out.println("6.Delete course:");
		System.out.println("7.View info about a student:");
		System.out.println("8.View info about a course:");
		System.out.println("9.List of students enrolled on a given course:");
		System.out.println("10.Enroll student:");
		input=scanner.nextInt();
		scanner.nextLine();
		switch(input)
		{
		case 1 :
			String id_s,name_s,birth_s,address_s = null;
			System.out.println("Give student id:");
			id_s=scanner.nextLine();
			System.out.println("Give student name:");
			name_s=scanner.nextLine();
			System.out.println("Give student birth date:");
			birth_s=scanner.nextLine();
			System.out.println("Give student address:");
			address_s=scanner.nextLine();
			addStudent(id_s,name_s,birth_s,address_s);
			break;
		case 2 :
			String studentName,name_st,address_st=null;
			System.out.println("Give student name to update:");
			studentName=scanner.nextLine();
			System.out.println("Give student new name:");
			name_st=scanner.nextLine();
			System.out.println("Give student new address:");
			address_st=scanner.nextLine();
			updateStudent(studentName,name_st,address_st);
			break;
		case 3 :
			String studentName1;
			System.out.println("Give student name to delete:");
			studentName1=scanner.nextLine();
			deleteStudent(studentName1);
			break;
		case 4 :
			String id_c,name_c,teacher_c,studyyear_c = null;
			System.out.println("Give course id:");
			id_c=scanner.nextLine();
			System.out.println("Give course name:");
			name_c=scanner.nextLine();
			System.out.println("Give course teacher:");
			teacher_c=scanner.nextLine();
			System.out.println("Give course studyyear:");
			studyyear_c=scanner.nextLine();
			addCourse(id_c,name_c,teacher_c,studyyear_c);
			break;
		case 5 :
			String courseName1,teacher,year=null;
			System.out.println("Give course name to update:");
			courseName1=scanner.nextLine();
			System.out.println("Give course new teacher:");
			teacher=scanner.nextLine();
			System.out.println("Give course new study year:");
			year=scanner.nextLine();
			updateCourse(courseName1,teacher,year);
			break;
		case 6 :
			String courseName;
			System.out.println("Give course name to delete:");
			courseName=scanner.nextLine();
			deleteCourse(courseName);
			break;
		case 7 :
			String studentName2;
			System.out.println("Give student name for info:");
			studentName2=scanner.nextLine();
			showInfoStudent(studentName2);
			break;
		case 8 :
			String courseName2;
			System.out.println("Give course name for info:");
			courseName2=scanner.nextLine();
			showInfoCourse(courseName2);
			break;
		case 9 :
			String courseName3;
			System.out.println("Give course name for displaying students enrolled:");
			courseName3=scanner.nextLine();
			showStudentsEnrolled(courseName3);
			break;
		case 10 :
			String courseId4,studentId4,date,id_e;
			System.out.println("Give enrolment id:");
			id_e=scanner.nextLine();
			System.out.println("Give student id for enrolment:");
			studentId4=scanner.nextLine();
			System.out.println("Give course id for enrolment:");
			courseId4=scanner.nextLine();
			System.out.println("Give enrolment date:");
			date=scanner.nextLine();
			enroll(id_e,studentId4,courseId4,date);
			break;
		default:break;
		}
		}while (input!=0);
		scanner.close();
		}
	
}
