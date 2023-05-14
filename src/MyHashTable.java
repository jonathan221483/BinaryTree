public class MyHashTable<K,V> {
    public class HashNode<K,V> {
        private K key;
        private V value;
        private HashNode<K,V> next;
        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString(){
            return "{" + key + " " + value + "}";
        }
    }

    public HashNode<K,V>[] chainArray;
    private int chain_number = 11;
    private int size = 0;
    public MyHashTable(){
        this.chainArray = new HashNode[this.chain_number];
    }
    public MyHashTable(int chain_number){
        this.chainArray = new HashNode[chain_number];
        this.chain_number = chain_number;
    }
    public int hash(K key){
        return Math.abs(key.hashCode() % this.chain_number);
    }

    public void put(K key, V value){

    }

    public V get(K key){}

    public V remove(K key){}

    public boolean contains(V value){}

    public K getKey(V value){}
}
