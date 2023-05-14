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
        size ++;
        int index = hash(key);
        HashNode<K, V> data = new HashNode<>(key, value);
        if(chainArray[index] == null){
            chainArray[index] = data;
            return;
        }
        HashNode<K, V> pointer = chainArray[index];
        while (pointer.next != null){
            pointer = pointer.next;
        }
        pointer.next = data;
    }

    public V get(K key){
        int index = hash(key);
        HashNode<K, V> pointer = chainArray[index];
        while (pointer != null && !pointer.key.equals(key)){
            pointer = pointer.next;
        }
        if (pointer == null)
            return null;
        return pointer.value;
    }

    public V remove(K key){
        size--;
        int index = hash(key);
        HashNode<K, V> pointer = chainArray[index];
        HashNode<K, V> previous = null;
        while (pointer != null && !pointer.key.equals(key)){
            previous = pointer;
            pointer = pointer.next;
        }
        if (pointer == null)
            return null;
        if (previous == null) {
            chainArray[index] = pointer.next;
        }
        else{
            previous.next = pointer.next;
        }
        return pointer.value;
    }

    public boolean contains(V value){
        for (int index = 0; index < chain_number; index ++){
            HashNode<K, V> pointer = chainArray[index];
            while (pointer != null){
                if (pointer.value.equals(value)) return true;
                pointer = pointer.next;
            }
        }
        return false;
    }

    public K getKey(V value){
        for (int index = 0; index < chain_number; index ++){
            HashNode<K, V> pointer = chainArray[index];
            while (pointer != null){
                if (pointer.value.equals(value)) return pointer.key;
                pointer = pointer.next;
            }
        }
        return null;
    }
    public int[] sizeOfBuckets(){
        int[] result = new int[chain_number];
        for (int i = 0; i < chain_number; i ++){
            int length = 0;
            HashNode<K, V> pointer = chainArray[i];
            while (pointer != null){
                pointer = pointer.next;
                length ++;
            }
            result[i] = length;
        }
        return result;
    }

}
