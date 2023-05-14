import java.util.Arrays;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        MyHashTable<Book, String> hashTable = new MyHashTable<>();
        private static class Generator{
            String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
            Random random = new Random();

            public String NameGen() {
                String text = "";
                int length = random.nextInt(5) + 10;
                for (int i = 0; i < length; i++) {
                    text+=letters.charAt(random.nextInt(letters.length()));
                }
                return text.toString();
            }

        }
    }
}