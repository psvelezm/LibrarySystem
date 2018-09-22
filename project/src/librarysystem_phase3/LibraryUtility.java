package librarysystem_phase3;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author
 */
public class LibraryUtility 
{

    /**
     * The sortArrayList method sorts in ascending order the elements in the
     * ArrayList passed as an argument using the Bubble Sort algorithm.
     *
     * @param <E> The elements in the ArrayList need to be of a class that
     * implements the Comparable interface.
     * @param list The ArrayList to be sorted.
     */
    public static <E extends Comparable> void sortArrayList(ArrayList<E> list) {
        int lastPos;
        int index;
        E temp;

        if (list != null) {
            for (lastPos = list.size() - 1; lastPos >= 0; lastPos--) {
                for (index = 0; index <= lastPos - 1; index++) {
                    if (list.get(index).compareTo(list.get(index + 1)) > 0) {
                        //swap elements
                        temp = list.get(index);
                        list.set(index, list.get(index + 1));
                        list.set(index + 1, temp);
                    }
                }
            }

        }
    }
//look for elements that have the same value for the last name field as the value passed in the searchLastName method parameter.
    //Compares two strings lexicographically. The comparison is based on the Unicode value of each character in the strings.
    //The character sequence represented by this String object is compared lexicographically to the character sequence 
    //represented by the argument string. The result is a negative integer if this String object lexicographically precedes the argument string.
    //The result is a positive integer if this String object lexicographically follows the argument string.
    //The result is zero if the strings are equal; compareTo returns 0 exactly when the equals(Object) method would return true.

    public static int binarySearch(ArrayList<Member> list, int firstElem, int lastElem, String searchLastName)
    {
        int mid;

        while (firstElem <= lastElem)
        
        {
            mid = (firstElem + lastElem) / 2;

            if (list.get(mid).getLastName().compareTo(searchLastName) < 0) 
            
            {
                firstElem = mid + 1;
            }
            else if (list.get(mid).getLastName().compareTo(searchLastName) > 0)
            {
                lastElem = mid - 1;
            } 
            else 
            {
                return mid;
            }
        }
        return -1;
    }

    public static void serializeObject(Object objectToSerialize, String serializationFileName)
    
    {
        try 
        
        {
            FileOutputStream fout = new FileOutputStream(serializationFileName);

            try (ObjectOutputStream out = new ObjectOutputStream(fout)) 
            {
                out.writeObject(objectToSerialize);
                System.out.println("Object successfully serialized.");
            } 
            
            catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        } catch (Exception ex)
        
        {
            System.err.println(ex.getMessage());
        }
    }

    public static Object deSerializeObject(String serializationFileName)
    
    {
         if (string.IsNullOrEmpty(fileName)) { return default(T); 
         
         }
      try
          
      {
      catch
          System.out.println( "No serialization file was found.");
               }
        
        if (deSerializedObj != null && deSerializedObj instanceof ArrayList)
            accountList = (ArrayList) deSerializedObj;
              
          }
      
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
