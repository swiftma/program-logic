package shuo.laoma.collection.c49;

import java.util.LinkedHashMap;
import java.util.Map.Entry;


public class LRUCache<K, V> extends LinkedHashMap<K, V> {

	private static final long serialVersionUID = 4582221464546420890L;
	private int maxEntries;
    
    public LRUCache(int maxEntries){
        super(16, 0.75f, true);
        this.maxEntries = maxEntries;
    }
    
    @Override
    protected boolean removeEldestEntry(Entry<K, V> eldest) {
        return size() > maxEntries;
    }
    
    public static void main(String[] args){
    	LRUCache<String,Object> cache = new LRUCache<>(3);
    	cache.put("a", "abstract");
    	cache.put("b", "basic");
    	cache.put("c", "call");
    	cache.get("a");

    	cache.put("d", "call");
    	System.out.println(cache);
    }
}    