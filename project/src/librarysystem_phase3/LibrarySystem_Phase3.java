package librarysystem_phase3;

import java.io.*;
import java.util.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Mayelin Felipe
 */
public class LibrarySystem_Phase3 {

    // this is the Library object to be populated as the data file is processed
    private static Library theLibrary;

    public static void main(String[] args) {
        // initialize the Library object
        theLibrary = new Library("Hypothetical Library", null, null);

        // Get the serialization file name from the program argument list; else use a default value.
        String serializationFileName;
        if (args.length > 0) {
            serializationFileName = args[0];
        } else {
            serializationFileName = "library_data.ser";
        }

        // Ask the user what they want to do.
        String options = "\t [1] to load serialized data\n"
                + "\t [2] to load a new data file\n"
                + "\t [3] to add a new member\n"
                + "\t [4] to add a new printed book\n"
                + "\t [5] to add a new electronic book\n"
                + "\t [6] to add a new audio book\n"
                + "\t [7] to add a new dvd\n"
                + "\t [8] to display library information\n"
                + "\t [9] to search for a member\n"
                + "\t [q] to quit the application";

        String menuMessage = "Please enter one of the following options:\n" + options;
        String userInput = JOptionPane.showInputDialog(null, menuMessage, "Library System", JOptionPane.QUESTION_MESSAGE);

        String message;
        while (userInput != null && !userInput.equalsIgnoreCase("q")) {
            switch (userInput) {
                case "1":
                    System.out.println("Deserializing Library object");

                    // Set the library object to the value read from the serialization file.
                    Object libraryObject = LibraryUtility.deSerializeObject(serializationFileName);

                    if (libraryObject != null && libraryObject instanceof Library) {
                        theLibrary = (Library) libraryObject;
                    }

                    break;

                case "2":
                    System.out.println("Loading new data file");

                    // Prompt the user to select an input data file
                    File selectedFile;
                    JFileChooser fileChooser = new JFileChooser(".");

                    if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                        selectedFile = fileChooser.getSelectedFile();
                        try (Scanner inputFile = new Scanner(selectedFile)) {
                            // read all lines of data from the file and process them
                            String line;
                            int lineNumber = 1;
                            while (inputFile.hasNext()) {
                                line = inputFile.nextLine();
                                try {
                                    processLineOfData(line);
                                } catch (Exception ex) {
                                    message = "The following error occurred while processing line number "
                                            + lineNumber + ": " + ex.getMessage()
                                            + "\nLine of data skipped: " + line;

                                    System.out.println(message);
                                }
                                lineNumber++;
                            }
                        } catch (FileNotFoundException e) {
                            System.out.println(e.toString());
                        }
                    }
                    break;

                case "3":
                    promptUserForData("M");
                    break;

                case "4":
                    promptUserForData("P");
                    break;

                case "5":
                    promptUserForData("E");
                    break;

                case "6":
                    promptUserForData("A");
                    break;

                case "7":
                    promptUserForData("D");
                    break;

                case "8":
                    System.out.println(theLibrary);
                    break;

                case "9":
                    message = "Enter last name of member to search for";
                    String lastName = JOptionPane.showInputDialog(null, message, "Member Last Name", JOptionPane.INFORMATION_MESSAGE);

                    ArrayList<Member> memberList = theLibrary.getListOfMembers();
                    LibraryUtility.sortArrayList(memberList);

                    int index = LibraryUtility.search(memberList, lastName);
                    if (index != -1) {
                        System.out.println("Member found: " + memberList.get(index));
                    } else {
                        System.out.println("No member found with that last name.");
                    }

                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid entry. Please try again.",
                            "Invalid entry", JOptionPane.INFORMATION_MESSAGE);
                    break;
            }
            userInput = JOptionPane.showInputDialog(menuMessage);
        }

        JOptionPane.showMessageDialog(null, "Quitting application.");
        LibraryUtility.serializeObject(theLibrary, serializationFileName);
        System.exit(0);

    }

    private static void promptUserForData(String dataType) {
        String dialogMessage, dialogTitle;

        switch (dataType) {
            case "M":

                dialogMessage = "Enter member information in this format: id,first name,last name,phone,list of requests";
                dialogTitle = "Member Information";
                break;

            case "P":

                dialogMessage = "Enter printed book information in this format: title,genre,\n"
                        + "audience,available,author,isbn,cover";
                dialogTitle = "Printed Book Information";
                break;

            case "E":

                dialogMessage = "Enter electronic book information in this format: title,genre,\n"
                        + "audience,available,author,isbn,type";
                dialogTitle = "Electronic Book Information";
                break;

            case "A":

                dialogMessage = "Enter audio book information in this format: title,genre,\n"
                        + "audience,available,author,isbn,duration,extra charge";
                dialogTitle = "Audio Book Information";
                break;

            case "D":

                dialogMessage = "Enter dvd information in this format: title,genre,audience,\n"
                        + "available,video number,duration,closed captions";
                dialogTitle = "DVD Information";
                break;

            default:
                return;
        }

        String userInput = JOptionPane.showInputDialog(null, dialogMessage, dialogTitle, JOptionPane.INFORMATION_MESSAGE);
        try {
            processLineOfData(dataType + "," + userInput);
        } catch (Exception ex) {
            String errorMessage = "The following error occurred while processing the ";
            errorMessage += dialogTitle.toLowerCase() + " you entered: ";

            System.out.println(errorMessage + ex.getMessage());
        }
    }

    public static void processLineOfData(String line) throws Exception {
        String[] dataFields = line.split(",");

        // Get the first field to determine the record type:
        // M -> Member
        // P -> PrintedBook
        // E -> ElectronicBook
        // A -> AudioBook
        // D -> DVD
        String recordType = dataFields[0].toUpperCase();

        switch (recordType) {
            case "M":
                Member newMember = new Member(Integer.parseInt(dataFields[1]),
                        dataFields[2],
                        dataFields[3],
                        dataFields[4],
                        null);
                theLibrary.addMember(newMember);
                processMemberRequests(Integer.parseInt(dataFields[1]), dataFields[5]);
                break;

            case "P":
                PrintedBook newPrintedBook = new PrintedBook(Integer.parseInt(dataFields[1]),
                        dataFields[2],
                        dataFields[3],
                        dataFields[4],
                        Boolean.parseBoolean(dataFields[5]),
                        dataFields[6],
                        dataFields[7],
                        dataFields[8]);
                // only add newPrintedBook if it doesn’t already exist in the Library. 
                if (theLibrary.findItem(newPrintedBook) == null) {
                    theLibrary.addItem(newPrintedBook);
                }

                break;

            case "E":
                ElectronicBook newElectronicBook = new ElectronicBook(Integer.parseInt(dataFields[1]),
                        dataFields[2],
                        dataFields[3],
                        dataFields[4],
                        Boolean.parseBoolean(dataFields[5]),
                        dataFields[6],
                        dataFields[7],
                        dataFields[8]);
                // only add newElectronicBook if it doesn’t already exist in the Library.
                if (theLibrary.findItem(newElectronicBook) == null) {
                    theLibrary.addItem(newElectronicBook);
                }

                break;
            case "A":
                AudioBook newAudioBook = new AudioBook(Integer.parseInt(dataFields[1]),
                        dataFields[2],
                        dataFields[3],
                        dataFields[4],
                        Boolean.parseBoolean(dataFields[5]),
                        dataFields[6],
                        dataFields[7],
                        Double.parseDouble(dataFields[8]));
                // only add newAudioBook if it doesn’t already exist in the Library.                                        
                if (theLibrary.findItem(newAudioBook) == null) {
                    theLibrary.addItem(newAudioBook);
                }

                break;

            case "D":
                DVD newDVD = new DVD(Integer.parseInt(dataFields[1]),
                        dataFields[2],
                        dataFields[3],
                        dataFields[4],
                        Boolean.parseBoolean(dataFields[5]),
                        dataFields[6],
                        Double.parseDouble(dataFields[7]),
                        Boolean.parseBoolean(dataFields[8]));
                // only add newDVD if it doesn’t already exist in the Library.                     
                if (theLibrary.findItem(newDVD) == null) {
                    theLibrary.addItem(newDVD);
                }
                break;

            default:
                throw new Exception("Bad record");
        }
    }

    /**
     * The processMemberRequests method parses the String passed as the second
     * argument to create Request objects, which are added to the Member whose
     * id is equal to the int value passed as the first argument.
     *
     * @param memberID The id of member that has made the requests passed as the
     * second argument.
     * @param data A String value that represents the list of requests the
     * member has made. The requests are separated by the # sign; request fields
     * are separated by the : character. The following is the format for each
     * request: requestID:requestDate:dueDate:status
     */
    public static void processMemberRequests(int memberID, String data) {

        String[] strRequests = data.split("#");

        for (String strRequest : strRequests) {
            String[] fields = strRequest.split(":");

            Request request = new Request(Integer.parseInt(fields[0]), fields[1], fields[2], fields[3]);
            theLibrary.addRequestToMember(memberID, request);
        }
    }
}
