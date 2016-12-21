package shuo.laoma.file.c62;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class CircularReferenceDemo {

	static class Parent implements Serializable {
		private static final long serialVersionUID = 1L;
		String name;
	    Child child;
	    
	    public Parent(String name) {
	        this.name = name;
	    }
	    public Child getChild() {
	        return child;
	    }
	    public void setChild(Child child) {
	        this.child = child;
	    }
	}

	static class Child implements Serializable {
		private static final long serialVersionUID = 1L;
		String name;
	    Parent parent;
	    
	    public Child(String name) {
	        this.name = name;
	    }
	    public Parent getParent() {
	        return parent;
	    }
	    public void setParent(Parent parent) {
	        this.parent = parent;
	    }    
	}
	
	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Parent parent = new Parent("老马");
		Child child = new Child("小马");
		parent.setChild(child);
		child.setParent(parent);
		
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(bout);
		out.writeObject(parent);
		out.writeObject(child);
		out.close();

		ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(
		        bout.toByteArray()));
		parent = (Parent) in.readObject();
		child = (Child) in.readObject();

		if (parent.getChild() == child && child.getParent() == parent
		        && parent.getChild().getParent() == parent
		        && child.getParent().getChild() == child) {
		    System.out.println("reference OK");
		} else {
		    System.out.println("wrong reference");
		}

	}

}
