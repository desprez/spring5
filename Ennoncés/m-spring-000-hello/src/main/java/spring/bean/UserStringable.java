package spring.bean;

public class UserStringable implements ToStringable {

	private String name;
	private int age;
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
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

	public UserStringable(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public UserStringable() {
		super();
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}

}
