package librarysystem_phase3;

/**
 * This class represents audio books that can be downloaded by members of the library.
 * @author  */
public class AudioBook extends Book
{
    // instance variables
    private double duration;


    /**
     * This constructor initializes the fields to the passed values.
     * @param id Audio book's id.
     * @param title Audio book's title.
     * @param genre Audio book's genre.
     * @param audience Audio book's target audience.
     * @param available Audio book's availability.
     * @param author Audio book's author.
     * @param isbn Audio book's isbn.
     * @param bookDuration Audio book's duration in minutes.
     * @exception IllegalArgumentException When bookDuration is negative.
     */
    public AudioBook(int id, String title, String genre, String audience, boolean available, String author, String isbn, double bookDuration) throws IllegalArgumentException
    {
        super(id, title, genre, audience, available, author, isbn);

        if( bookDuration > 0 )
            duration = bookDuration;
        else
            throw new IllegalArgumentException("The audio book duration cannot be negative.");
    }
    
    
    /**
     * This is a copy constructor. It initializes the fields of the object being created to the same
     * values as the fields in the object passed as an argument.
     * @param bookObject The object being copied.
     */
    public AudioBook(AudioBook bookObject)
    {
        super(bookObject);
        
        if( bookObject != null )
            duration = bookObject.duration;
    }

    
    /**
     * The getDuration method returns an AudioBook object's duration in minutes.
     * @return The value in the duration field.
     */
    public double getDuration()
    {
        return duration;
    }

    
    /**
     * The setDuration method stores a value in the duration field.
     * @param bookDuration The value to store in duration.
     * @exception IllegalArgumentException When bookDuration is negative.
     */
    public void setDuration(double bookDuration) throws IllegalArgumentException
    {
        if( bookDuration > 0 )
            duration = bookDuration;
        else
            throw new IllegalArgumentException("The audio book duration cannot be negative.");
    }

       
    /**
     * The toString method returns a string representing the state of an AudioBook object.
     * @return A string containing the book information: ID, title, genre, target audience, 
     * availability, author, isbn, and duration.
     */
    @Override
    public String toString()
    {
        return super.toString() + String.format(    "\n%-20s %s ", 
                                                    "Duration:", duration);
    }

    
    /**
     * The equals method compares two AudioBook objects. The result is true if the argument 
     * is not null and is an AudioBook object with the same values for all fields as this object.
     * @param obj The object to compare this AudioBook with.
     * @return true if the given object has the same value for the title, genre, targetAudience, 
     * author, isbn, and duration fields.
     */
    @Override
    public boolean equals(Object obj)
    {
        if( !(obj instanceof AudioBook))
            return false;
        
        // we already know that obj is of type AudioBook, so it's safe to cast
        AudioBook book = (AudioBook) obj;
        
        // return true or false depending on whether title, genre, targetAudience, author, isbn,
        // and duration have the same value.
        return  super.equals(obj) 
                && duration == book.duration;
    }
    
}
