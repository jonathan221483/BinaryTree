# Algorithms and Data Structures | Khaimuldin Nursultan
## Assignment 4 | Hash Table implementation
### Methods needed to be implemented:

## MyHashTable

  put() - adds an element to the hash table
  
  get() - returns value of with the entered key

  remove() - removes data from hash table and returns it's value

  contains() - returns true if entred value is in hash table

  getKey() - returns key with entered value

  sizeOfBuckets() - returns size of each bucket
  
```
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
    }k.size();
    } 
```



## Book class

  hashCode() - my implemented hashing code

  equals() - override method to compare objects 

  toString() - override method to convert data from hash table to string


```
   @Override
    public int hashCode() {
        int hash = 3;
        hash = hash * 5 + id;
        hash = hash * 7 + (int) cost;

        char[] letters = name.toCharArray();
        int a = 0;
        for (char i: letters) a = i + (31 * a);

        hash = hash * 13 + a;
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && Float.compare(book.cost, cost) == 0 && Objects.equals(name, book.name);
    }

    @Override
    public String toString(){
        return this.name + ' ' + this.id;
    }
```

## Generator class

  IDgen() - generates random id

  CostGen() - generates random price  

  NameGen() - generates random names
  
  ```
  public String NameGen() {
      String text = "";
        int length = random.nextInt(5) + 10;
        for (int i = 0; i < length; i++) {
            text += letters.charAt(random.nextInt(letters.length()));
        }
        return text.toString();
    }
    public int IDGen() {
        return random.nextInt(1, 9999);
    }
    public float CostGen() {
        return (random.nextFloat() * 3) + random.nextInt(1000, 5000);
    }
  ```
  
