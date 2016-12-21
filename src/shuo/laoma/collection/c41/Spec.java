package shuo.laoma.collection.c41;

import java.util.HashSet;
import java.util.Set;

public class Spec {
	
    String size;
    String color;
    
    public Spec(String size, String color) {
        this.size = size;
        this.color = color;
    }

    @Override
    public String toString() {
        return "[size=" + size + ", color=" + color + "]";
    }
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Spec other = (Spec) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		return true;
	}

	public static void main(String[] args){
    	Set<Spec> set = new HashSet<Spec>();
    	set.add(new Spec("M","red"));
    	set.add(new Spec("M","red"));

    	System.out.println(set);
    }
}
