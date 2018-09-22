
package librarysystem_phase3;

/**
 * This class represents printed books that can be checked out by members of the library.
 * @author  */
public class PrintedBook extends Book
{
    // instance variables
    private String coverType;
    
            
    /**
     * This constructor initializes the fields to the passed values.
     * @param id Printed book's id.
     * @param title Printed book's title.
     * @param genre Printed book's genre.
     * @param audience Printed book's target audience.
     * @param available Printed book's availability.
     * @param author Printed book's author.
     * @param isbn Printed book's isbn.
     * @param cover Printed book's cover type.
     */
    public PrintedBook(int id, String title, String genre, String audience, boolean available, String author, String isbn, String cover)
    {
        super(id, title, genre, audience, available, author, isbn);
        coverType = cover;
    }
    
    
    /**
     * This is a copy constructor. It initializes the fields of the object being created to the same
     * values as the fields in the object passed as an argument.
     * @param bookObject The object being copied.
     */
    public PrintedBook(PrintedBook bookObject)
    {
        super(bookObject);
        
        if( bookObject != null )
            coverType = bookObject.coverType;
    }

    
    /**
     * The getCoverType method returns a PrintedBook object's cover type.
     * @return The value in the coverType field.
     */
    public String getCoverType()
    {
        return coverType;
    }
    

    /**
     * The setCoverType method stores a value in the coverType field.
     * @param cover The value to store in coverType.
     */
    public void setCoverType(String cover)
    {
        coverType = cover;
    }
    
    
    /**
     * The toString method returns a string representing the state of a PrintedBook object.
     * @return A string containing the book information: ID, title, genre, target audience, 
     * availability, author, isbn, and cover type.
     */
    @Override
    public String toString()
    {
        return super.toString() + String.format(    "\n%-20s %s ", 
                                                    "Cover Type:", coverType);
    }

    
    /**
     * The equals method compares two PrintedBook objects. The result is true if the argument 
     * is not null and is a PrintedBook object with the same values for all fields as this object.
     * @param obj The object to compare this PrintedBook with.
     * @return true if the given object has the same value for the title, genre, targetAudience, 
     * author, isbn, and coverType fields.
     */
    @Override
    public boolean equals(Object obj)
    {
        if( !(obj instanceof PrintedBook))
            return false;
        
        // we already know that obj is of type PrintedBook, so it's safe to cast
        PrintedBook book = (PrintedBook) obj;
        
        // return true or false depending on whether title, genre, targetAudience, author, isbn,
        // and coverType have the same value.
        return  super.equals(obj) 
                && coverType.equals(book.coverType);
    }

}
