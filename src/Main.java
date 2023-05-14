import java.util.Arrays;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        MyHashTable<Book, String> hashTable = new MyHashTable<>();
        Generator gen = new Generator();
        for (int i = 0; i < 10000; i ++){
            if (i == 1){
                hashTable.put(new Book("Harry Potter", 6284, 3699.9f), "Value to check");
            }
            hashTable.put(new Book(gen.NameGen(), gen.IDGen(), gen.CostGen()),
                    gen.NameGen());
        }



    }
}