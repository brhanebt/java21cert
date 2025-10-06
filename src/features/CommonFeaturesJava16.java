package features;

import java.util.List;

record Student(String id, String name, String department, int age) {
	public boolean validAge() {
		return this.age()>=18;
	}
	@Override
	public String toString() {
		return "Student: Id -> "+this.id()+
				", name-> "+this.name()+
				", department-> "+this.department()+
				", age-> "+this.age();
		
	}
}
public class CommonFeaturesJava16 {
	
	public static void main(String[] args) {
		//Records
		
		var student1 = new Student("01","Steve","Accounting",26);
		System.out.println("Student - 1: "+student1);
		
		//pattern matching instance of
		System.out.println("processValue(10): "+ processValue(10));
		System.out.println("processValue(25.80): "+ processValue(25.80));
		System.out.println("processValue(value): "+ processValue("value"));
		System.out.println("processValue(List.of(+,-)): "+ processValue(List.of("+","-")));
		
	}
	
	private static int processValue(Object v) {
		if(v instanceof String str) {
			return str.length();
		} else if (v instanceof Double d) {
			return d.intValue();
		} else if (v instanceof Integer i) {
			return i;
		} else if(v instanceof List<?> list && !list.isEmpty()){
			return list.size();
		} else {
			return 0;
		}
	}

}
