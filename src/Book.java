import java.util.Objects;
public class Book {
    private String name;
    private int id;
    private float cost;

    public Book(String name, int group, float gpa){
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

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
}