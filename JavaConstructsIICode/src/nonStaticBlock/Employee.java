package nonStaticBlock;

public class Employee {
	private String name;
	private int age;
	private double salary = 100;

	public Employee(String name, int age) {
		
		this.name = name;
		this.age = age;
	}

	public Employee() {
		
		this.name = "NONAME";
		this.age = 0;
	}

	{
		System.out.println("salaryInit1: " + salary);
		salary = 200;
		System.out.println("end processing1");
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}

	{
		System.out.println("salaryInit2: " + salary);
		salary = 400;
		System.out.println("end processing2");
	}

	public static void main(String[] args) {
		Employee employee1 = new Employee("John", 40);
		System.out.println(employee1);

		Employee employee2 = new Employee("Peter", 17);
		System.out.println(employee2);

		System.out.println(new Employee());
	}
}
