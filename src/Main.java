import java.util.Arrays;
import java.util.Random;
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

        System.out.println("Book with name Lord Of The Rings exists? " + hashTable.contains("Value to check"));
        System.out.println("Book " + hashTable.remove(hashTable.getKey("Value to check")) + " successfully removed from HashTable");
        System.out.println("Book with name Lord Of The Rings exists? " + hashTable.contains("Value to check"));

    }
}