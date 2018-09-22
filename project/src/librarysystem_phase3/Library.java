package librarysystem_phase3;

import java.util.*;
import java.io.Serializable;

/**
 * This class represents a library. It has a list of library members and a list
 * of items that members can checkout/download.
 */
public class Library implements Serializable 

{

    // instance variables
    private String libraryName;
    private ArrayList<Member> listOfMembers = new ArrayList<>();
    private ItemLinkedList listOfItems = new ItemLinkedList();

    /**
     * This constructor initialises the fields to the passed values.
     *
     * @param name Library's name.
     * @param members Library's initial list of members.
     * @param items Library's initial list of items.
     */
    public Library(String name, ArrayList<Member> members, ItemLinkedList items) {
        libraryName = name;

        // before trying to iterate through the members array list, make sure it isn't null
        if (members != null) {
            // create a copy of each Member element and add it to the listOfMembers instance variable
            for (Member memberElement : members) {
                listOfMembers.add(new Member(memberElement));
            }
        }

        this.listOfItems = items.copy();
    }

    /**
     * The getLibraryName method returns a Library's name.
     *
     * @return The value in the name field.
     */
    public String getLibraryName() {
        return libraryName;
    }

    /**
     * The getListOfMembers method returns a copy of the Library's list of
     * members.
     *
     * @return A copy of the listOfMembers field.
     */
    public ArrayList<Member> getListOfMembers() {
        // return a copy of listOfMembers, as opposed to a reference to it. 
        ArrayList<Member> newList = new ArrayList<>();

        for (Member memberElement : listOfMembers) {
            newList.add(new Member(memberElement));
        }

        return newList;
    }

    /**
     * The getListOfItems method returns a copy of the Library's list of items.
     *
     * @return A copy of the listOfItems field.
     */
    public ItemLinkedList getListOfItems() {
        return this.listOfItems.copy();
    }

    /**
     * The setLibraryName method changes the value in the name field.
     *
     * @param name the value to store in name.
     */
    public void setLibraryName(String name) {
        libraryName = name;
    }

    /**
     * The setListOfMembers method changes the value in the listOfMembers field
     * to be a copy of the list passed as an argument.
     *
     * @param members the list that will be copied into listOfMembers.
     */
    public void setListOfMembers(ArrayList<Member> members) {
        listOfMembers.clear();

        if (members != null) {
            for (Member memberElement : members) {
                listOfMembers.add(new Member(memberElement));
            }
        }
    }

    /**
     * The setListOfItems method changes the value in the listOfItems field to
     * be a copy of the list passed as an argument.
     *
     * @param items the list that will be copied into listOfItems.
     */
    public void setListOfItems(ItemLinkedList items) {
        this.listOfItems = items.copy();
    }

    /**
     * The addMember method adds to the listOfMembers instance variable a copy
     * of the Member object passed as an argument.
     *
     * @param member the object to be copied and added to the listOfMembers
     * instance variable.
     */
    public void addMember(Member member) {
        listOfMembers.add(new Member(member));
    }

    /**
     * The addItem method adds to the listOfItems instance variable a copy of
     * the Item object passed as an argument.
     *
     * @param item the object to be copied and added to the listOfItems instance
     * variable.
     */
    public void addItem(Item item) {
        // since the data type of the item parameter may be any sub-types, we need to 
        // cast into the specific subclass to call the appropriate copy constructor.
        if (item instanceof PrintedBook) {
            listOfItems.add(new PrintedBook((PrintedBook) item));
        } else if (item instanceof ElectronicBook) {
            listOfItems.add(new ElectronicBook((ElectronicBook) item));
        } else if (item instanceof AudioBook) {
            listOfItems.add(new AudioBook((AudioBook) item));
        } else if (item instanceof DVD) {
            listOfItems.add(new DVD((DVD) item));
        }
    }

    /**
     * The toString method returns a string representing the state of a Library
     * object.
     *
     * @return A string containing the library information: name, list of
     * members, and list of items.
     */
    @Override
    public String toString() {
        return this.listOfItems.toString();
    }

    /**
     * The findItem method uses the find method of the ItemLinkedList class to
     * look for the element in the listOfItems field that is equal to the Item
     * object passed as the argument. If no element is found in the list to be
     * equal to the argument, it returns null.
     *
     * @param item the Item object to search for in the list.
     * @return The element in the list that is equals to the argument. Null, if
     * none if found.
     */
    public Item findItem(Item item)
    {
        return listOfItems.find(item);
    
    }

    /**
     * The addRequestToMember method iterates through the listOfMembers
     * ArrayList looking for a Member whose memberID is equal to the int value
     * passed as the first argument. If it finds it, it adds to it the Request
     * object passed as the second argument.
     *
     * @param id the memberID to search for in the list.
     * @param reqObject the Request object to be added to the member.
     */
    public void addRequestToMember(int id, Request reqObject) {
        for (Member memberElem : listOfMembers) {
            if (memberElem.getMemberID() == id) {
                memberElem.addRequest(reqObject);
                return;
            }
        }
    }

}
