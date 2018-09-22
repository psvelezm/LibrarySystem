package librarysystem_phase3;

import java.io.Serializable;

/**
 * This class represents a request a member makes to checkout or download an
 * item from the library.
 *
 * @author
 */
public class Request implements Comparable<Request>, Serializable {

    // instance variables
    private int itemID;
    private String requestDate;
    private String dueDate;
    private String status;

    /**
     * This constructor initializes the fields to the passed values.
     *
     * @param id The id of the item being checked out or downloaded.
     * @param requestDt Request date.
     * @param dueDt Due date.
     * @param requestStatus Request status.
     */
    public Request(int id, String requestDt, String dueDt, String requestStatus) {
        itemID = id;
        requestDate = requestDt;
        dueDate = dueDt;
        status = requestStatus;
    }

    /**
     * This is a copy constructor. It initializes the fields of the object being
     * created to the same values as the fields in the object passed as an
     * argument.
     *
     * @param requestObject The object being copied.
     */
    public Request(Request requestObject) {
        if (requestObject != null) {
            itemID = requestObject.itemID;
            requestDate = requestObject.requestDate;
            dueDate = requestObject.dueDate;
            status = requestObject.status;
        }
    }

    /**
     * The getItemID method returns the id of the item being requested.
     *
     * @return The value in the itemID field.
     */
    public int getItemID() {
        return itemID;
    }

    /**
     * The getRequestDate method returns the request date.
     *
     * @return The value in the requestDate field.
     */
    public String getRequestDate() {
        return requestDate;
    }

    /**
     * The getRequestDate method returns the due date.
     *
     * @return The value in the dueDate field.
     */
    public String getDueDate() {
        return dueDate;
    }

    /**
     * The getStatus method returns the request status.
     *
     * @return The value in the status field.
     */
    public String getStatus() {
        return status;
    }

    /**
     * The setItemID method stores a value in the itemID field.
     *
     * @param id the value to store in itemID.
     */
    public void setItemID(int id) {
        itemID = id;
    }

    /**
     * The setRequestDate method stores a value in the requestDate field.
     *
     * @param requestDt the value to store in requestDate.
     */
    public void setRequestDate(String requestDt) {
        requestDate = requestDt;
    }

    /**
     * The setDueDate method stores a value in the dueDate field.
     *
     * @param dueDt the value to store in dueDate.
     */
    public void setDueDate(String dueDt) {
        dueDate = dueDt;
    }

    /**
     * The setStatus method stores a value in the status field.
     *
     * @param requestStatus the value to store in status.
     */
    public void setStatus(String requestStatus) {
        status = requestStatus;
    }

    /**
     * The toString method returns a string representing the state of a Request
     * object.
     *
     * @return A string containing the request information: item ID, request
     * date, due date, and status.
     */
    @Override
    public String toString() {
        return String.format("\n%12s %-12s %s \n%12s %-12s %s \n%12s %-12s %s \n%12s %-12s %s \n",
                "", "Item ID:", itemID,
                "", "Request Date:", requestDate,
                "", "Due Date:", dueDate,
                "", "Status:", status);
    }

    /**
     * The equals method compares two Request objects. The result is true if the
     * argument is not null and is a Request object with the same values for all
     * fields as the object calling the method.
     *
     * @param obj The object to compare this Request with.
     * @return true if the given object has the same value for all fields.
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Request)) {
            return false;
        }

        // we already know that obj is of type Request, so it's safe to cast
        Request request = (Request) obj;

        // return true or false depending on whether all the fields have the same value
        return this.itemID == request.itemID
                && this.requestDate.equals(request.requestDate)
                && this.dueDate.equals(request.dueDate)
                && this.status.equals(request.status);

    }

    /**
     * The compareTo method compares the Request object calling this method with
     * the Request object passed as an argument to see which one has a greater
     * value.
     *
     * @param request The Request object to compare with.
     * @return 0 if both objects have the same value for the requestDate
     * instance variable. A positive number if the calling object has a greater
     * value for the requestDate instance variable. A negative number if the
     * calling object has a lesser value for the requestDate instance variable.
     */
    @Override
    public int compareTo(Request request) {
        return this.requestDate.compareTo(request.requestDate);
    }
}
