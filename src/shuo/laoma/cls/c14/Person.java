package shuo.laoma.cls.c14;

public class Person {
	//姓名
	private String name;
	
	//父亲
	private Person father;
	
	//母亲
	private Person mother;
	
	//孩子数组
	private Person[] children;

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person getFather() {
		return father;
	}

	public void setFather(Person father) {
		this.father = father;
	}

	public Person getMother() {
		return mother;
	}

	public void setMother(Person mother) {
		this.mother = mother;
	}

	public Person[] getChildren() {
		return children;
	}

	public void setChildren(Person[] children) {
		this.children = children;
	}
	
	public static void main(String[] args){
		Person laoma = new Person("老马");
		Person xiaoma = new Person("小马");
		
		xiaoma.setFather(laoma);
		laoma.setChildren(new Person[]{xiaoma});
		
		System.out.println(xiaoma.getFather().getName());
	}
}
