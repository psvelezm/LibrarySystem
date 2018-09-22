package librarysystem_phase3;

/**
 * This class represents DVD items that can be checked out by the members of the library.
 * @author */
public class DVD extends Item
{
    // instance variables
    private String videoNumber;
    private double duration;    
    private boolean closedCaptions;
    

    /**
     * This constructor initializes the fields to the passed values.
     * @param id DVD's id.
     * @param title DVD's title.
     * @param genre DVD's genre.
     * @param audience DVD's target audience.
     * @param available DVD's availability.
     * @param number DVD's video number.
     * @param dvdDuration DVD's duration in minutes.
     * @param closedCptns Whether DVD has closed captions or not.
     * @exception IllegalArgumentException When dvdDuration is negative.
     */
    public DVD(int id, String title, String genre, String audience, boolean available, String number, double dvdDuration, boolean closedCptns) throws IllegalArgumentException
    {
        super(id, title, genre, audience, available);
        videoNumber = number;
        closedCaptions = closedCptns;
        
        if( dvdDuration > 0 )
            duration = dvdDuration;
        else
            throw new IllegalArgumentException("The DVD duration cannot be negative.");
    }
    
    
    /**
     * This is a copy constructor. It initializes the fields of the object being created to the same
     * values as the fields in the object passed as an argument.
     * @param dvdObject The object being copied.
     */
    public DVD(DVD dvdObject)
    {
        super(dvdObject);
        
        if( dvdObject != null )
        {
            videoNumber = dvdObject.videoNumber;
            duration = dvdObject.duration;
            closedCaptions = dvdObject.closedCaptions;
        }
    }

    
    /**
     * The getVideoNumber method returns a DVD's video number.
     * @return The value in the videoNumber field.
     */
    public String getVideoNumber()
    {
        return videoNumber;
    }

    
    /**
     * The getDuration method returns a DVD's duration in minutes.
     * @return The value in the duration field.
     */
    public double getDuration()
    {
        return duration;
    }

    
    /**
     * The getClosedCaptions method returns whether a DVD has closed captions or not.
     * @return The value in the closedCaptions field.
     */
    public boolean getClosedCaptions()
    {
        return closedCaptions;
    }

    
    /**
     * The setVideoNumber method stores a value in the videoNumber field.
     * @param number The value to store in videoNumber.
     */
    public void setVideoNumber(String number)
    {
        videoNumber = number;
    }

    
    /**
     * The setDuration method stores a value in the duration field.
     * @param dvdDuration The value to store in duration.
     * @exception IllegalArgumentException When dvdDuration is negative.
     */
    public void setDuration(double dvdDuration) throws IllegalArgumentException
    {
        if( dvdDuration > 0 )
            duration = dvdDuration;
        else
            throw new IllegalArgumentException("The DVD duration cannot be negative.");
    }

    
    /**
     * The setClosedCaptions method stores a value in the closedCaptions field.
     * @param closedCptns The value to store in closedCaptions.
     */
    public void setClosedCaptions(boolean closedCptns)
    {
        closedCaptions = closedCptns;
    }

    
    /**
     * The toString method returns a string representing the state of a DVD object.
     * @return A string containing the DVD information: ID, title, genre, target audience, 
     * availability, video number, duration, and whether or not it has closed captions.
     */
    @Override
    public String toString()
    {
        return super.toString() + String.format(    "\n%-20s %s \n%-20s %s \n%-20s %s", 
                                                    "Video Number:", videoNumber,
                                                    "Duration:", duration,
                                                    "Closed Captions:", closedCaptions);
    }

    
    /**
     * The equals method compares two DVD objects. The result is true if the argument 
     * is not null and is a DVD object with the same values for all fields as this object.
     * @param obj The object to compare this DVD with.
     * @return true if the given object has the same value for all fields.
     */
    @Override
    public boolean equals(Object obj)
    {
        if( !(obj instanceof DVD))
            return false;
        
        // we already know that obj is of type DVD, so it's safe to cast
        DVD dvd = (DVD) obj;
        
        // return true or false depending on whether title, genre, target audience, video number,
        // duration, and closedCaptions have the same value.
        return  super.equals(obj) 
                && videoNumber.equals(dvd.videoNumber) 
                && duration == dvd.duration 
                && closedCaptions == dvd.closedCaptions;

    }
    
}
