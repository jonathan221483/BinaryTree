public class MyHashTable<K,V> {
    private HashNode<K,V>[] chainArray;
    private int chain_number = 11;
    private int size = 0;
    public MyHashTable(){
        this.chainArray = new HashNode[this.chain_number];
    }


}
