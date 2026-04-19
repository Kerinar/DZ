package DZ_2;

import java.util.ArrayList;

public class Student {
    private String name;
    private ArrayList<Book> books = new ArrayList<Book>();

    public Student(String name, ArrayList<Book> books){
        this.name = name;
        this.books.addAll(books);
    }

    public String getName(){
        return name;
    }

    public ArrayList<Book> getBooks(){
        return books;
    }

    @Override
    public String toString() {
        return name;
    }
}
