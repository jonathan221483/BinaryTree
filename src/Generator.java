import java.util.Random;

public class Generator {
    String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Random random = new Random();

    public String NameGen() {
        String text = "";
        int length = random.nextInt(5) + 10;
        for (int i = 0; i < length; i++) {
            text += letters.charAt(random.nextInt(letters.length()));
        }
        return text.toString();
    }
    public int IDGen() {
        return random.nextInt(1000, 9999);
    }
    public float CostGen() {
        return random.nextFloat() * 4;
    }
}
