import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        MyHashTable<Book, String> hashTable = new MyHashTable<>();
        Generator gen = new Generator();
        for (int i = 0; i < 10000; i ++){
            if (i == 1){
                hashTable.put(new Book("Lord of The Rings", 3573, 5790.00f), "Value to check");
            }
            hashTable.put(new Book(gen.NameGen(), gen.IDGen(), gen.CostGen()), gen.NameGen());
        }
        System.out.println("Number of elements in each bucket " + Arrays.toString(hashTable.sizeOfBuckets()));
        Book harry = new Book("Harry Potter",6284,3699.9f);
        hashTable.put(harry,"Harry Potter");
        System.out.println("Book " + hashTable.get(harry) + " successfully added into HashTable");
        System.out.println("Book with name Harry Potter exists? " + hashTable.contains("Harry Potter"));
        System.out.println("Book " + hashTable.remove(harry) + " successfully removed from HashTable");
        System.out.println("Book with name Harry Potter exists? " + hashTable.contains("Harry Potter") + '\n');

        System.out.println("Lord Of The Rings has the value to check " + hashTable.contains("Value to check"));
        System.out.println("Lord Of The Rings is the best book " + hashTable.contains("The best book"));
        System.out.println("Lord Of The Rings is the " + hashTable.replace_key("Value to check","The best book"));
        System.out.println("Lord Of The Rings is the best book " + hashTable.contains("The best book"));
    }
}