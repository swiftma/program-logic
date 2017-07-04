package shuo.laoma.java8.c93;

public class Student {
	String name;
	String id;
	double score;
	String grade;

	public Student(String name, String grade, double score) {
		this.name = name;
		this.id = name;
		this.score = score;
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
