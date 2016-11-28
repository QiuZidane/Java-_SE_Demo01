package abstractClasses;

public abstract class Person {

	public abstract String getDescription();
	
	void getPersonName_default(){
		System.out.println("默认");;
	};
	
	protected void getPersonName_protect(){
		System.out.println("保护");
	};

	private String name;
	
	public Person() {
		this.name = "无名氏";
	}

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}
