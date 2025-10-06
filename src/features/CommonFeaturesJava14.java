package features;
class User{
	String id;
	String name;
	int age;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public User(String id, String name, int age) {
		this.id=id;
		this.name=name;
		this.age=age;
	}
}

public class CommonFeaturesJava14 {
	
	public static void main(String[] args) {
		//Switch Expressions
		int day = 2;
		String dayName = switch(day) {
			case 0-> "Sunday"; case 1-> "Monday"; 
			case 2-> "Tuesday"; case 3-> "Wednesday"; 
			case 4-> "Thursday"; case 5-> "Firday"; 
			case 6-> "Saturday"; default -> "Unknown";
		};
		
		System.out.println("Day: "+ day +" : "+ dayName);
		System.out.println("10+19: "+ calculate(10,19,'+'));
		System.out.println("10-19: "+ calculate(10,19,'-'));
		System.out.println("10*19: "+ calculate(10,19,'*'));
		System.out.println("19*10: "+ calculate(10,19,'/'));
		//System.out.println("19/0: "+ calculate(19,0,'/'));
		
		//Text block
		
		String json = 	"""
						{
							"id":"01",
							"name":"Bob",
							"age":26
						}
						""";
		
		System.out.println(json);
		
		
		User u = new User("01","Bob",26);
		String html = """
						<div class="user-card">
							<h2>ID: %s</h2>
							<p>Name: %s</p>
							<p>Age: %d</p>
						</div>
					  """.formatted(u.getId(),u.getName(),u.getAge());
		System.out.println("HTML: "+html);
		
	}
	
	public static double calculate(double a, double b, char operator) {
		return switch(operator) {
			case '+'-> a+b;
			case '-'-> a-b;
			case '*'->a*b;
			case '/'->{
				if(b!=0)
					yield a/b;
				else
					throw new IllegalArgumentException("Division by zero");
			}
			default -> throw new IllegalArgumentException("Unknown operator");
		};
		
	}

}
