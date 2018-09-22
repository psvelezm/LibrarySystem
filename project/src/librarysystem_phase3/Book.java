package librarysystem_phase3;

/**
 * This is an abstract class that represents books in general. Objects of the subclasses can be 
 * checked out or downloaded.
 * @author  */
public abstract class Book extends Item
{
    // instance variables
    private String author;
    private String isbn;

    /**
     * This constructor initializes the fields to the passed values.
     * @param id Book's id.
     * @param bookTitle Book's title.
     * @param bookGenre Book's genre.
     * @param audience Book's target audience.
     * @param bookAvailable Book's availability.
     * @param bookAuthor Book's author.
     * @param bookIsbn Book's isbn.
     */
    public Book(int id, String bookTitle, String bookGenre, String audience, boolean bookAvailable, String bookAuthor, String bookIsbn)
    {
        super(id, bookTitle, bookGenre, audience, bookAvailable);
        author = bookAuthor;
        isbn = bookIsbn;
    }
    
    
    /**
     * This is a copy constructor. It initializes the fields of the object being created to the same
     * values as the fields in the object passed as an argument.
     * @param bookObject The object being copied.
     */
    public Book(Book bookObject)
    {
        super(bookObject);
        if( bookObject != null )
        {
            author = bookObject.author;
            isbn = bookObject.isbn;
        }
    }

    
    /**
     * The getAuthor method returns a Book's author.
     * @return The value in the author field.
     */
    public String getAuthor()
    {
        return author;
    }

    
    /**
     * The getIsbn method returns a Book's isbn.
     * @return The value in the isbn field.
     */
    public String getIsbn()
    {
        return isbn;
    }

    
    /**
     * The setAuthor method stores a value in the author field.
     * @param bookAuthor the value to store in the author field.
     */
    public void setAuthor(String bookAuthor)
    {
        author = bookAuthor;
    }

    
    /**
     * The setIsbn method stores a value in the isbn field.
     * @param bookIsbn the value to store in the isbn field.
     */
    public void setIsbn(String bookIsbn)
    {
        isbn = bookIsbn;
    }
    
    
    /**
     * The toString method returns a string representing the state of a Book object.
     * @return A string containing the book information: ID, title, genre, target audience, 
     * availability, author, and isbn.
     */
    @Override
    public String toString()
    {
        return super.toString() + String.format(    "\n%-20s %s \n%-20s %s ", 
                                                    "Author:", author,
                                                    "ISBN:", isbn);
    }

    
    /**
     * The equals method compares two Book objects. The result is true if the argument 
     * is not null and is a Book object with the same values for all fields as this object.
     * @param obj The object to compare this Book with.
     * @return true if the given object has the same value for the title, genre, targetAudience,
     * author, and isbn fields.
     */
    @Override
    public boolean equals(Object obj)
    {
        if( !(obj instanceof Book))
            return false;
        
        // we already know that obj is of type Book, so it's safe to cast
        Book book = (Book) obj;
        
        // return true or false depending on whether title, genre, targetAudience, author, and
        // isbn have the same value.
        return  super.equals(obj) 
                && author.equals(book.author)
                && isbn.equals(book.isbn);

    }

}
