package DZ_2;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Book> books = new ArrayList<Book>();

    public Student(String name, ArrayList<Book> books){
        this.name = name;
        this.books.addAll(books);
    }

    public String getName(){
        return name;
    }

    public List<Book> getBooks(){
        return books;
    }

    @Override
    public String toString() {
        return name;
    }
}
