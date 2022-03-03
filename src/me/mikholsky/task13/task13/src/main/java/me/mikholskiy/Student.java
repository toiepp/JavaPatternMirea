public class Student {
	private String name;
	private String lastName;
	private String group;

	public Student(String name, String lastName, String group) {
		this.name = name;
		this.lastName = lastName;
		this.group = group;
	}

	@Override
	public String toString() {
		return "Student{" +
				"name='" + name + '\'' +
				", lastName='" + lastName + '\'' +
				", group='" + group + '\'' +
				'}';
	}
}
