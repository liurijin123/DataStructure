package map;

public class MyHashMap<K, V> implements MyMap<K, V> {

	private Entry[] table ;
	private int tableSize ;
	private float tableFactor ;
	private int tableUseSize;
	private int size;
	
	public MyHashMap(){
		this(16,0.75f);
	}
	public MyHashMap(int tableSize, float tableFactor) {
		this.tableSize = tableSize;
		this.tableFactor = tableFactor;
		table = new Entry[this.tableSize];
	}
	//增加一对映射
	@Override
	public void put(K key, V value) {
		//判断是否需要扩容
		if(tableUseSize >= tableSize*tableFactor){
			addTableSize();
		}
		int hash = hash(key);
		//判断是否使用了表中新的空间
		if(table[hash] == null){
			tableUseSize++;
			table[hash] = new Entry<K, V>();
		}
		Entry<K, V> temp = table[hash];
		while(temp.next != null){
			if(temp.next.getKey() == key || temp.next.getKey().equals(key)){
				temp.next.setValue(value);
				size++;
				return;
			}
			temp = temp.next;
		}
		temp.next = new Entry(key, value, null);
		size++;
	}

	//得到hash值
	private int hash(K key) {
		if(key == null){
			return 0;
		};
		return key.hashCode()%tableSize;
	}
	//扩容
	private void addTableSize() {
		// 把所有映射对存入一个数组
		Entry[] tempTable = new Entry[this.size];
		for(int i=0,j=0;i<tableSize;i++){
			if(table[i] != null){
				Entry<K, V> temp = table[i];
				while(temp.next != null){
					tempTable[j++] = temp.next; 
					temp = temp.next;
				}
			}
		}
		tableSize *= 2;
		tableUseSize = 0;
		size = 0;
		Entry[] newTable = new Entry[this.tableSize];
		table = newTable;
		//重新散列
		for(Entry<K, V> e : tempTable){
			put(e.getKey(), e.getValue());
		}
	}
	@Override
	public void remove(K key) {
		Entry<K, V> e= getEntry(key);
		Entry<K, V> temp = e.next;
		e.next = temp.next;
		temp.next = null;
	}

	@Override
	public V get(K key) {
		Entry<K, V> e = getEntry(key);
		if(e.next == null){
			throw new NullPointerException("不存在");
		}
		return e.next.getValue();
	}
	
	private Entry<K, V> getEntry(K key) {
		int hash = hash(key);
		Entry<K, V> temp = table[hash];
		if(temp != null){
			while(temp.next != null){
				if(temp.next.getKey() == key || temp.next.getKey().equals(key)){
					break;
				}
				temp = temp.next;
			}
			//返回需要得到元素的上一个元素，方便删除
			return temp;
		}else{
			return null;
		}

	}

	class Entry<K, V> implements MyMap.Entry<K, V>{

		private V value;
		private K key;
		public Entry<K, V> next;
		
		public Entry(){
			this(null, null, null);
		}
		
		public Entry(K key, V value, Entry<K, V> next){
			this.key = key;
			this.value = value;
			this.next = next;
		}
		
		@Override
		public V getValue() {
			return value;
		}

		@Override
		public K getKey() {
			return key;
		}

		@Override
		public void setValue(V value) {
			this.value = value;
		}

		@Override
		public void setKey(K key) {
			this.key = key;
		}
		
	}

}
