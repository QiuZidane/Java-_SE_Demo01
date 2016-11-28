package abstractClasses;

public abstract class Person {

	public abstract String getDescription();
	
	void getPersonName_default(){
		System.out.println("Ĭ��");;
	};
	
	protected void getPersonName_protect(){
		System.out.println("����");
	};

	private String name;
	
	public Person() {
		this.name = "������";
	}

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}
