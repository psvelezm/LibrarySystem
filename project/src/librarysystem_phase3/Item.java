package librarysystem_phase3;

import java.io.Serializable;


/**
 * This is an abstract class that represents items in general that members can checkout or download.
 * @author 
 */
public abstract class Item implements Serializable
{
    // instance variables
    private int itemID;
    private String title;
    private String genre;
    private String targetAudience;
    private boolean available;

    
    /**
     * This constructor initializes the fields to the passed values.
     * @param id Item's id.
     * @param itemTitle Item's title.
     * @param itemGenre Item's genre.
     * @param audience Item's target audience.
     * @param itemAvailable Item's availability.
     */
    public Item(int id, String itemTitle, String itemGenre, String audience, boolean itemAvailable)
    {
        itemID = id;
        title = itemTitle;
        genre = itemGenre;
        targetAudience = audience;
        available = itemAvailable;
    }
    
    
    /**
     * This is a copy constructor. It initializes the fields of the object being created to the same
     * values as the fields in the object passed as an argument.
     * @param itemObject The object being copied.
     */
    public Item(Item itemObject)
    {
        if( itemObject != null )
        {
            itemID = itemObject.itemID;
            title = itemObject.title;
            genre = itemObject.genre;
            targetAudience = itemObject.targetAudience;
            available = itemObject.available;
        }
    }

    
    /**
     * The getItemID method returns an Item's id.
     * @return The value in the itemID field.
     */
    public int getItemID()
    {
        return itemID;
    }

    
    /**
     * The getTitle method returns an Item's title.
     * @return The value in the title field.
     */
    public String getTitle()
    {
        return title;
    }

    
    /**
     * The getGenre method returns an Item's genre.
     * @return The value in the genre field.
     */
    public String getGenre()
    {
        return genre;
    }

    
    /**
     * The getTargetAudience method returns an Item's targetAudience.
     * @return The value in the targetAudience field.
     */
    public String getTargetAudience()
    {
        return targetAudience;
    }

    
    /**
     * The getAvailable method returns an Item's availability.
     * @return The value in the available field.
     */
    public boolean getAvailable()
    {
        return available;
    }

    
    /**
     * The setItemID method stores a value in the itemID field.
     * @param id the value to store in itemID.
     */
    public void setItemID(int id)
    {
        itemID = id;
    }

    
    /**
     * The setTitle method stores a value in the title field.
     * @param itemTitle the value to store in title.
     */
    public void setTitle(String itemTitle)
    {
        title = itemTitle;
    }

    
    /**
     * The setGenre method stores a value in the genre field.
     * @param itemGenre the value to store in genre.
     */
    public void setGenre(String itemGenre)
    {
        genre = itemGenre;
    }

    
    /**
     * The setTargetAudience method stores a value in the targetAudience field.
     * @param audience the value to store in targetAudience.
     */
    public void setTargetAudience(String audience)
    {
        targetAudience = audience;
    }

    
    /**
     * The setAvailable method stores a value in the available field.
     * @param itemAvailable the value to store in available.
     */
    public void setAvailable(boolean itemAvailable)
    {
        available = itemAvailable;
    }
    
    
    /**
     * The toString method returns a string representing the state of an Item object.
     * @return A string containing the item information: ID, title, genre, target audience, 
     * and availability.
     */
    @Override
    public String toString()
    {
        return String.format(   "\n%-20s %s \n%-20s %s \n%-20s %s \n%-20s %s \n%-20s %s", 
                                "Item ID:", itemID,
                                "Title:", title,
                                "Genre:", genre,
                                "Target Audience:", targetAudience,
                                "Available:", available );
        
    }

    
    /**
     * The equals method compares two Item objects. The result is true if the argument 
     * is not null and is an Item object with the same values for the title, genre, and 
     * targetAudience fields as this object.
     * @param obj The object to compare this Item with.
     * @return true if the given object has the same value for the title, genre, and 
     * targetAudience fields.
     */
    @Override
    public boolean equals(Object obj)
    {
        if( !(obj instanceof Item))
            return false;
        
        // we already know that obj is of type Item, so it's safe to cast
        Item item = (Item) obj;
        
        // return true or false depending on whether title, genre, and targetAudience have the same value
        return  title.equals(item.title) 
                && genre.equals(item.genre) 
                && targetAudience.equals(item.targetAudience);

    }
    
}

