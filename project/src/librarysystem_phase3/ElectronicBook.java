package librarysystem_phase3;

/**
 * This class represents electronic books that can be downloaded by members of the library.
 * @author  */
public class ElectronicBook extends Book
{
    // instance variables
    private String fileType;


    /**
     * This constructor initializes the fields to the passed values.
     * @param id Electronic book's id.
     * @param title Electronic book's title.
     * @param genre Electronic book's genre.
     * @param audience Electronic book's target audience.
     * @param available Electronic book's availability.
     * @param author Electronic book's author.
     * @param isbn Electronic book's isbn.
     * @param type Electronic book's file type.
     */
    public ElectronicBook(int id, String title, String genre, String audience, boolean available, String author, String isbn, String type)
    {
        super(id, title, genre, audience, available, author, isbn);
        fileType = type;
    }
    
    
    /**
     * This is a copy constructor. It initializes the fields of the object being created to the same
     * values as the fields in the object passed as an argument.
     * @param bookObject The object being copied.
     */
    public ElectronicBook(ElectronicBook bookObject)
    {
        super(bookObject);
        
        if( bookObject != null )
            fileType = bookObject.fileType;
    }

    
    /**
     * The getFileType method returns an ElectronicBook object's file type.
     * @return The value in the fileType field.
     */
    public String getFileType()
    {
        return fileType;
    }

    
    /**
     * The setFileType method stores a value in the fileType field.
     * @param type The value to store in fileType.
     */
    public void setFileType(String type)
    {
        fileType = type;
    }
    
    
    /**
     * The toString method returns a string representing the state of an ElectronicBook object.
     * @return A string containing the book information: ID, title, genre, target audience, 
     * availability, author, isbn, and file type.
     */
    @Override
    public String toString()
    {
        return super.toString() + String.format(    "\n%-20s %s ", 
                                                    "File Type:", fileType);
        
    }

    
    /**
     * The equals method compares two ElectronicBook objects. The result is true if the argument 
     * is not null and is an ElectronicBook object with the same values for all fields as this object.
     * @param obj The object to compare this ElectronicBook with.
     * @return true if the given object has the same value for the title, genre, targetAudience, 
     * author, isbn, and fileType fields.
     */
    @Override
    public boolean equals(Object obj)
    {
        if( !(obj instanceof ElectronicBook))
            return false;
        
        // we already know that obj is of type ElectronicBook, so it's safe to cast
        ElectronicBook book = (ElectronicBook) obj;
        
        // return true or false depending on whether title, genre, targetAudience, author, isbn,
        // and fileType have the same value.
        return  super.equals(obj) 
                && fileType.equals(book.fileType);

    }
    
}
