package map;

public interface MyMap<K, V> {

	//增
	public void put(K key, V value);
		
	//删
	public void remove(K key);
		
	//查
	public V get(K key);
	
	interface Entry<K, V> {
		public V getValue();
		public K getKey();
		public void setValue(V value);
		public void setKey(K key);
	}
}
