package bag;

import java.util.Date;

public class TestingBase {
	
	int numTests;
	int numPass;
	String title="Untitled";
	String testerName="Unknown";
	String startTime = "Test not begun yet";
	String endTime = "Test not ended yet";

	
	private TestingBase(){
		
	}
	
	public TestingBase(String t, String tn){
		
		title=t;
		testerName =tn;
	
	}
	
	public String startTest(){
		startTime = new Date().toString();
		return "Tester "+testerName+" begining "+title+" at "+startTime;
	}
	
	public String endTest(){
		endTime = new Date().toString();
		return "Tester "+testerName+" ending "+title+" at "+endTime+"; "
				+numPass+" of "+numTests+" passed.";
	}
	
	public String test(String testName, String exp, String act){
		numTests++;
		
		String s = "----------";
		s+="Test Name: " +testName;
		s+="\nExpected Result:\n"+exp;
		s+="\nActual Result:\n"+act;
		s+="\n"+testName;
		if (exp.equals(act)){
			s+=" Passed.";
			numPass++;
		}
		else{
			s+=" Failed.";
		}
		s+= "\n----------";
		return s;
		
	}
	
	public String toString(){
		return "Class: Testing Base\nObject Data: {(title, "+title+"),"
			+"(testerName, "+testerName+")," 
			+"(numTests, "+numTests+")," 
			+"(numPass, "+numPass+")" 
			+ "}\n";
	}
	


}