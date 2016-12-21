package shuo.laoma.collection.c50;

public class Clothes {
	
    String id;
    Size size;
    
    public Clothes(String id, Size size) {
        this.id = id;
        this.size = size;
    }

    public String getId() {
        return id;
    }

    public Size getSize() {
        return size;
    }
}
