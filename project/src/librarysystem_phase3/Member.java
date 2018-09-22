package librarysystem_phase3;

import java.io.Serializable;
import java.util.*;

/**
 * This class represents a member of the library. Members can make requests to
 * checkout/download items.
 *
 * @author
 */
public class Member implements Comparable<Member>, Serializable {

    // instance variables
    private int memberID;
    private String firstName;
    private String lastName;
    private String phone;
    private ArrayList<Request> listOfRequests;

    public Member() {
        listOfRequests = new ArrayList<>();
    }

    /**
     * This constructor initializes the fields to the passed values.
     *
     * @param id Member's id.
     * @param first Member's first name.
     * @param last Member's last name.
     * @param phoneNbr Member's phone number.
     * @param requests Member's initial list of requests.
     */
    public Member(int id, String first, String last, String phoneNbr, ArrayList<Request> requests) {
        this();
        memberID = id;
        firstName = first;
        lastName = last;
        phone = phoneNbr;

        if (requests != null) {
            for (Request requestElement : requests) {
                listOfRequests.add(new Request(requestElement));
            }
        }
    }

    /**
     * This is a copy constructor. It initializes the fields of the object being
     * created to the same values as the fields in the object passed as an
     * argument.
     *
     * @param memberObject The object being copied.
     */
    public Member(Member memberObject) {
        if (memberObject != null) {
            memberID = memberObject.memberID;
            firstName = memberObject.firstName;
            lastName = memberObject.lastName;
            phone = memberObject.phone;

            // you may assume that memberObject.listOfRequests is never null
            for (Request requestElement : memberObject.listOfRequests) {
                listOfRequests.add(new Request(requestElement));
            }
        }
    }

    /**
     * The getMemberID method returns the member's id.
     *
     * @return The value in the memberID field.
     */
    public int getMemberID() {
        return memberID;
    }

    /**
     * The getFirstName method returns the member's first name.
     *
     * @return The value in the firstName field.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * The getLastName method returns the member's last name.
     *
     * @return The value in the lastName field.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * The getPhone method returns the member's phone number.
     *
     * @return The value in the phone field.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * The getListOfRequests method returns a Member's list of requests.
     *
     * @return A reference to a copy of this member's ArrayList of Requests.
     */
    public ArrayList<Request> getListOfRequests() {
        ArrayList<Request> newList = new ArrayList<>();
        for (Request requestElement : listOfRequests) {
            newList.add(new Request(requestElement));
        }

        return newList;
    }

    /**
     * The setMemberID method stores a value in the memberID field.
     *
     * @param id the value to store in memberID.
     */
    public void setMemberID(int id) {
        memberID = id;
    }

    /**
     * The setFirstName method stores a value in the firstName field.
     *
     * @param first the value to store in firstName.
     */
    public void setFirstName(String first) {
        this.firstName = first;
    }

    /**
     * The setLastName method stores a value in the lastName field.
     *
     * @param last the value to store in lastName.
     */
    public void setLastName(String last) {
        lastName = last;
    }

    /**
     * The setPhone method stores a value in the phone field.
     *
     * @param phoneNbr the value to store in phone.
     */
    public void setPhone(String phoneNbr) {
        phone = phoneNbr;
    }

    /**
     * The setListOfRequests method stores a value in the listOfRequests field.
     *
     * @param requests the list of requests to store in the listOfRequests
     * field.
     */
    public void setListOfRequests(ArrayList<Request> requests) {
        listOfRequests.clear();

        if (requests != null) {
            for (Request requestElement : requests) {
                listOfRequests.add(new Request(requestElement));
            }
        }
    }

    /**
     * The toString method returns a string representing the state of a Member
     * object.
     *
     * @return A string containing the member information: ID, first name, last
     * name, phone, and list of requests made.
     */
    @Override
    public String toString() {
        // Create a string representing the object.
        String output = String.format("\n%-12s %s \n%-12s %s \n%-12s %s \n%-12s %s \n%-12s ",
                "Member ID:", memberID,
                "First Name:", firstName,
                "Last Name:", lastName,
                "Phone:", phone,
                "Requests:");

        if (listOfRequests.isEmpty()) {
            output += "No requests.";
        } else {
            LibraryUtility.sortArrayList(listOfRequests);
            for (Request requestElement : listOfRequests) {
                output += requestElement.toString();
            }
        }

        // Return the string.
        return output;
    }

    /**
     * The equals method compares the Member object calling this method with the
     * Member object passed as an argument.
     *
     * @param obj The Member object to compare with.
     * @return true if both objects have the same value for the firstName,
     * lastName, and phone instance variables. False otherwise.
     */
    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Member)) {
            return false;
        }

        // we already know that obj is of type Member, so it's safe to cast
        Member member = (Member) obj;

        // return true or false depending on whether firstName, lastName, and phone have the same value
        return firstName.equals(member.firstName)
                && lastName.equals(member.lastName)
                && phone.equals(member.phone);
    }

    /**
     * The addRequest method adds the Request object passed as an argument to
     * the list of requests.
     *
     * @param request the request object to be added.
     */
    public void addRequest(Request request) {
        listOfRequests.add(new Request(request));
    }

    /**
     * The compareTo method compares the Member object calling this method with
     * the Member object passed as an argument to see which one has a greater
     * value.
     *
     * @param member The Member object to compare with.
     * @return 0 if both objects have the same value for the firstName and
     * lastName instance variables. A positive number if the calling object has
     * a greater last name or both objects have the same last name but the
     * calling object has a greater first name. A negative number if the calling
     * object has a lesser last name or both objects have the same last name but
     * the calling object has a lesser first name.
     */
    @Override
    public int compareTo(Member member) {
        // compare the last names
        int result = this.lastName.compareTo(member.lastName);

        if (result == 0) {
            // if the last names are the same, compare the first names
            result = this.firstName.compareTo(member.firstName);
        }

        return result;
    }
}
