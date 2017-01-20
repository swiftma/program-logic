package shuo.laoma.concurrent.c66;

import java.util.Collections;
import java.util.Map;

public class EnhancedMap <K, V>{
    Map<K, V> map;
    
    public EnhancedMap(Map<K,V> map){
        this.map = Collections.synchronizedMap(map);
    }
    
    public V putIfAbsent(K key, V value){
    	synchronized(map){
    		V old = map.get(key);
            if(old!=null){
                return old;
            }
            map.put(key, value);
            return null;	
    	}
     }
    
    public void put(K key, V value){
        map.put(key, value);
    }
    
    //... 其他代码

}
