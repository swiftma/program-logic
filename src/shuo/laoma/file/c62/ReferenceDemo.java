package shuo.laoma.file.c62;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ReferenceDemo {

	static class Common implements Serializable {
		private static final long serialVersionUID = 1L;
		String c;

	    public Common(String c) {
	        this.c = c;
	    }
	}
	static class A implements Serializable {
		private static final long serialVersionUID = 1L;
		String a;
	    Common common;
	    
	    public A(String a, Common common) {
	        this.a = a;
	        this.common = common;
	    }

	    public Common getCommon() {
	        return common;
	    }
	} 
	
	static class B implements Serializable {
		private static final long serialVersionUID = 1L;
		String b;
	    Common common;
	    
	    public B(String b, Common common) {
	        this.b = b;
	        this.common = common;
	    }

	    public Common getCommon() {
	        return common;
	    }
	}
	
	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Common c = new Common("common");
		A a = new A("a", c);
		B b = new B("b", c);
		
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(bout);
		out.writeObject(a);
		out.writeObject(b);
		out.close();

		ObjectInputStream in = new ObjectInputStream(
		        new ByteArrayInputStream(bout.toByteArray()));
		A a2 = (A) in.readObject();
		B b2 = (B) in.readObject();

		if (a2.getCommon() == b2.getCommon()) {
		    System.out.println("reference the same object");
		} else {
		    System.out.println("reference different objects");
		}

	}

}
