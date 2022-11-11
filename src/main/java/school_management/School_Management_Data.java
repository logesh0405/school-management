package school_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
public class School_Management_Data { 

	private static Scanner sc;

	public static void main(String args[])
	{
	try
	{
	sc = new Scanner(System.in);
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ school_management","root","root");
	PreparedStatement stmt;
	int choice;
	ch:while(true)
	{
	System.out.println("======================================================================");
	System.out.println("\n");
	System.out.println("========================= Management Record ==========================");
	System.out.println("\n");
	System.out.println("======================================================================");
	System.out.println("1.Add Teacher: ");
	System.out.println("2.Add Student: ");
	System.out.println("3.Add Parents: ");
	System.out.println("4.View Teacher: ");
	System.out.println("5.View Student: ");
	System.out.println("6.View Patents: ");
	System.out.println("7.Update Teacher: ");
	System.out.println("8.Update Student: ");
	System.out.println("9.Delete Teacher: ");
	System.out.println("10.Delete Student: ");
	System.out.println("11.Exit ");
	System.out.println("Enter your choice: ");
	choice=sc.nextInt();
	switch(choice)
	{
	case 1://Inserting into Teacher
	System.out.println("Enter Teacher Id: ");
	int teacher_Id=sc.nextInt();
	System.out.println("Enter Teacher Name: ");
	String teacheName=sc.next();
	System.out.println("Enter Teacher Qualification: ");
	String teacherQualification=sc.next();
	System.out.println("Enter Teacher Address: ");
	String teacherAddress=sc.next();
	System.out.println("Enter Teacher Salary: ");
	int teacherSalary=sc.nextInt();
	stmt=con.prepareStatement("insert into Teacher values(?,?,?,?,?)");
	stmt.setInt(1,teacher_Id);
	stmt.setString(2,teacheName);
	stmt.setString(3,teacherQualification);
	stmt.setString(4,teacherAddress);
	stmt.setInt(5,teacherSalary);
	int i=stmt.executeUpdate();
	if(i==1)
	{
	System.out.println("Record Inserted");
	}
	else
	{
	System.out.println("Record Not Inserted");
	}
	break;
	case 2://Inserting into Student
	System.out.println("Enter Student Id: ");
	int student_ID=sc.nextInt();
	System.out.println("Enter Student Name: ");
	String student_Name=sc.next();
	System.out.println("Enter Student Course: ");
	String student_Course=sc.next();
	System.out.println("Enter Student Fee: ");
	int student_fee=sc.nextInt();
	stmt=con.prepareStatement("insert into Student values(?,?,?,?)");
	stmt.setInt(1,student_ID);
	stmt.setString(2,student_Name);
	stmt.setString(3,student_Course);
	stmt.setInt(4,student_fee);
	int j=stmt.executeUpdate();
	if(j==1)
	{
	System.out.println("Record Inserted");
	}
	else
	{
	System.out.println("Record Not Inserted");
	}
	break;
	case 3://Inserting into Parents
		System.out.println("Enter Parents Id: ");
		int parents_Id=sc.nextInt();
		System.out.println("Enter Parents Name: ");
		String parents_Name=sc.next();
		System.out.println("Enter parents Address: ");
		String parents_Address=sc.next();
		System.out.println("Enter Student FeePaid: "); 
		int parents_FeePaid=sc.nextInt();
		stmt=con.prepareStatement("insert into parents values(?,?,?,?)");
		stmt.setInt(1,parents_Id);
		stmt.setString(2,parents_Name);
		stmt.setString(3,parents_Address);
		stmt.setInt(4,parents_FeePaid);
		int l=stmt.executeUpdate();
		if(l==1)
		{
		System.out.println("Record Inserted");
		}
		else
		{
		System.out.println("Record Not Inserted");
		}
		break;
	case 4://View Teacher
	stmt=con.prepareStatement("select * from Teacher");
	ResultSet rs=stmt.executeQuery();
	while(rs.next())
	{
	System.out.println("Teacher Id: "+rs.getInt(1));
	System.out.println("Teacher Name: "+rs.getString(2));
	System.out.println("Teacher Qualification: "+rs.getString(3));
	System.out.println("Teacher Address: "+rs.getString(4));
	System.out.println("Teacher Salary: "+rs.getInt(5));
	System.out.println("\n");
	}
	break;
	case 5://View Student
	stmt=con.prepareStatement("select * from Student");
	ResultSet rs1=stmt.executeQuery();
	while(rs1.next())
	{
	System.out.println("Student Id: "+rs1.getInt(1));
	System.out.println("Student Name: "+rs1.getString(2));
	System.out.println("Student Course: "+rs1.getString(3));
	System.out.println("Student Fee: "+rs1.getInt(4));
	System.out.println("\n");
	}
	break;
	case 6://View parents
		stmt=con.prepareStatement("select * from parents");
		ResultSet rs2=stmt.executeQuery();
		while(rs2.next())
		{
		System.out.println("parents Id: "+rs2.getInt(1));
		System.out.println("parents Name: "+rs2.getString(2));
		System.out.println("parents Address: "+rs2.getString(3));
		System.out.println("parents FeePaid: "+rs2.getInt(4));
		System.out.println("\n");
		}
		break;
	case 7://Update Teacher
	System.out.println("Enter Teacher Id: ");
	int teacher_Id1=sc.nextInt();
	System.out.println("Enter Teacher Salary: ");
	int teacherSalary1=sc.nextInt();
	stmt=con.prepareStatement("update Teacher set teacherSalary=? where teacher_Id=?");
	stmt.setInt(1,teacherSalary1);
	stmt.setInt(2,teacher_Id1);
	int k=stmt.executeUpdate();
	if(k==1)
	{
	System.out.println("Record Updated");
	}
	else
	{
	System.out.println("Record Not Updated");
	}
	break;
	case 8://Update Student
	System.out.println("Enter Student Id: ");
	int student_Id1=sc.nextInt();
	System.out.println("Enter Student Fee: ");
	int student_fee1=sc.nextInt();
	stmt=con.prepareStatement("update Student set student_fee=? where student_Id=?");
	stmt.setInt(1,student_fee1);
	stmt.setInt(2,student_Id1);
	int m=stmt.executeUpdate();
	if(m==1)
	{
	System.out.println("Record Updated");
	}
	else
	{
	System.out.println("Record Not Updated");
	}
	break;
	
	case 10://Delete Teacher
	System.out.println("Enter Teacher Id: ");
	int teacher_Id2=sc.nextInt();
	stmt=con.prepareStatement("delete from Teacher where teacher_Id=?");
	stmt.setInt(1,teacher_Id2);
	int o=stmt.executeUpdate();
	if(o==1)
	{
	System.out.println("Record Deleted");
	}
	else
	{
	System.out.println("Record Not Deleted");
	}
	break;
	case 11://Delete Student
	System.out.println("Enter Student Id: ");
	int student_Id2=sc.nextInt();
	stmt=con.prepareStatement("delete from Student where student_Id2=?");
	stmt.setInt(1,student_Id2);
	int n=stmt.executeUpdate();
	if(n==1)
	{
	System.out.println("Record Deleted");
	}
	else
	{
	System.out.println("Record Not Deleted");
	}
	break;
	case 12://Exit
	System.out.println("Exit");
	break ch;//break label
	default:
	System.out.println("Invalid Choice");
	}
	}
	}
	catch(Exception e)
	{
	System.out.println(e);
	}
	}

	public void setUp() {
		// TODO Auto-generated method stub
		
	}

	public void testAddStudent() {
		// TODO Auto-generated method stub
		
	}


		
	}

	
	
	

