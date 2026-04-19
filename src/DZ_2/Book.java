package DZ_2;

public class Book {
    private String name;
    private int pages;
    private int year;

    public Book(String name, int pages, int year){
        this.name = name;
        this.pages = pages;
        this.year = year;
    }

    public int getPages(){
        return pages;
    }

    public int getYear(){
        return year;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + pages + year + name.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        Book book = (Book) obj;
        return this.name.equals(book.name) && this.pages == book.pages && this.year == book.year;
    }
}
