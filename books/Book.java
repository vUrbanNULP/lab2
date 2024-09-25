package books;

public class Book {
    private static int[] usedIds = new int[100];
    private static String[] usedTitles = new String[100];
    private static int idCount = 0;
    private static int titleCount = 0;

    private int id;
    private String title;
    private String author;
    private String publisher;
    private int publicationYear;
    private int pages;
    private double price;

    public Book(int id, String title, String author, String publisher, int publicationYear, int pages, double price) {
        setId(id);
        setTitle(title);
        setAuthor(author);
        setPublisher(publisher);
        setPublicationYear(publicationYear);
        setPages(pages);
        setPrice(price);
    }

    public void setId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("ID не може бути від'ємним!");
        }
        for (int i = 0; i < idCount; i++) {
            if (usedIds[i] == id) {
                throw new IllegalArgumentException("ID повинен бути унікальним!");
            }
        }
        this.id = id;
        usedIds[idCount++] = id;
    }

    public void setTitle(String title) {
        String normalizedTitle = title.toLowerCase();
        for (int i = 0; i < titleCount; i++) {
            if (usedTitles[i].equals(normalizedTitle)) {
                if (usedIds[idCount--] == id) {usedIds[idCount--] = 0;}
                throw new IllegalArgumentException("Назва книги повинна бути унікальною!");
            }
        }
        this.title = title;
        usedTitles[titleCount++] = normalizedTitle;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getPublisher() { return publisher; }
    public int getPublicationYear() { return publicationYear; }
    public int getPages() { return pages; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return id +
                ", Назва: \"" + title + "\"" +
                ", Автор: " + author +
                ", Видавець: " + publisher +
                ", Рік видання: " + publicationYear +
                ", Кількість сторінок: " + pages +
                ", Ціна: " + price + " грн";
    }
}
