
/**
 * Q2a.A Class that holds a collection of words and their anagrams.
 *
 * @author (Warren Pullen )
 * @version (23/02/24)
 */
import java.util.*;
public class Anagram {
    public TreeMap<String, TreeSet<String>> anagrams;
    /**
     * q2b.Zero argument constructor which initalises empty treemap to store anagrams
     */
    public Anagram()
    {
    anagrams = new TreeMap<>();
    }
    /**
     * q2c.Public method that populates map with samples, returns no value
     */
    public void populate() {
    // Create a TreeSet of Strings for the anagrams of "list"
    TreeSet<String> listAnagrams = new TreeSet<>();
    listAnagrams.add("silt");
    listAnagrams.add("slit");
    
    // Create a TreeSet for the anagrams of "saps"
    TreeSet<String> sapsAnagrams = new TreeSet<>();
    sapsAnagrams.add("asps");
    sapsAnagrams.add("pass");
    sapsAnagrams.add("spas");

    // Add the key-value pairs to the anagrams TreeMap
    anagrams.put("list", listAnagrams);
    anagrams.put("saps", sapsAnagrams);
    }
    /**
     * Q2f. Public method which takes two parameters, if the parameters are anagrams and aword already exists 
     * as a key an anagram is added. if aword does not exist a new map is created, if the parameters are not an anagram 
     * nothing happens.
     */
    public void addAnagram(String aWord, String anAnagram) {
    // Check if the words are anagrams
    if (areAnagrams(aWord, anAnagram)) {
        // Check if aWord already exists as a key in the anagrams map
        TreeSet<String> anagramSet = anagrams.get(aWord);

        // If anagramSet is null, create a new TreeSet
        if (anagramSet == null) {
            anagramSet = new TreeSet<>();
        }

        // Add anAnagram to the anagramSet
        anagramSet.add(anAnagram);

        // Update the anagrams map with the modified anagramSet
        anagrams.put(aWord, anagramSet);
    }
    }
    /**
     * q2d. iterates through map printing contents followed by a new line for next entry
     */
    public void print() {
    for (String key : anagrams.keySet()) {
        // Print the key followed by a space, a dash, and another space
        System.out.print(key + " - ");

        // Get the TreeSet of anagrams for the current key
        TreeSet<String> values = anagrams.get(key);

        // Loop through the anagrams and print each one followed by a space
        for (String anagram : values) {
            System.out.print(anagram + " ");
        }

        // Print a new line for the next entry
        System.out.println();
    }
    }
    /**
     * Q2e. Public method to check if two words are anagrams of each other if they are the method return true else returns false 
     */
    public boolean areAnagrams(String aWord, String anotherWord) {
        // Check if the lengths of the words are equal
        if (aWord.length() != anotherWord.length()) {
            return false;
        }

        // Convert strings to char arrays and sort them
        char[] aWordChars = aWord.toCharArray();
        char[] anotherWordChars = anotherWord.toCharArray();
        Arrays.sort(aWordChars);
        Arrays.sort(anotherWordChars);

        // Compare the sorted char arrays for equality
        return Arrays.equals(aWordChars, anotherWordChars);
    }
    /**
     * q2g.Public method tthat cross references anagrams in map
     */
    public void crossReference() {
    // Declare and initialize the updatedAnagrams map
    TreeMap<String, TreeSet<String>> updatedAnagrams = new TreeMap<>(anagrams);

    // Iterate through the entries in the original map
    for (Map.Entry<String, TreeSet<String>> entry : anagrams.entrySet()) {
        String key = entry.getKey();
        TreeSet<String> values = entry.getValue();

        // Iterate through the anagrams of the current entry
        for (String anagram : values) {
            // Skip the entry itself
            if (!anagram.equals(key)) {
                // Check if the current anagram already exists in the updatedAnagrams map
                TreeSet<String> crossReferencedSet = updatedAnagrams.get(anagram);

                // If the set doesn't exist, create a new TreeSet
                if (crossReferencedSet == null) {
                    crossReferencedSet = new TreeSet<>();
                }

                // Iterate through the elements of the values set of the current entry
                for (String value : entry.getValue()) {
                    crossReferencedSet.add(value);
                }

                // Add the cross-referenced set back to the updatedAnagrams map
                updatedAnagrams.put(anagram, crossReferencedSet);
            }
        }
        anagrams = updatedAnagrams;
    }
   }
}

    



 



