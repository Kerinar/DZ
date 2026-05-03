import DZ_2.Book;
import DZ_2.Student;


void main() throws FileNotFoundException {
    List<Student> students = new ArrayList<Student>();
    ArrayList<Book> booksArray = new ArrayList<Book>();

    String student;

    String books;
    String[] booksMassive;

    String pages;
    String[] pagesMassive;

    String years;
    String[] yearsMassive;


    File file = new File("src/file");
    Scanner scanner = new Scanner(file);

    //Заполнение массива студентов
    while (scanner.hasNextLine()){
        student = scanner.nextLine();
        //IO.println(student);
        books = scanner.nextLine();
        //IO.println(books);
        pages = scanner.nextLine();
        //IO.println(pages);
        years = scanner.nextLine();
        //IO.println(years);

        booksMassive = books.split(" ");
        pagesMassive = pages.split(" ");
        yearsMassive = years.split(" ");

        for(int i = 0; i < booksMassive.length; i++){
            booksArray.add(new Book(booksMassive[i], Integer.parseInt(pagesMassive[i]), Integer.parseInt(yearsMassive[i])));
        }

        students.add(new Student(student, booksArray));
        booksArray.clear();
    }

    scanner.close();

    //Стрим
    IO.println(students.stream()
                .peek(n -> IO.println(n.toString()))
                .peek(n -> IO.println(n.getBooks()))
                .flatMap(n -> n.getBooks().stream())
                .sorted((b1, b2) -> Integer.compare(b1.getPages(), b2.getPages()))
                .distinct()
                .filter(n -> n.getYear() > 2000)
                .limit(3)
                .map(n -> Integer.toString(n.getYear()))
                .findFirst()
                .orElse("No such book"));

}
