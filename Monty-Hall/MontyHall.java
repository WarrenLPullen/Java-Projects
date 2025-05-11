/**
 * Q1a.This class represents "The Monty Hall Problem", the class simulates the gameshow "Lets make a deal" and records if 
 * switch won or if sitck won.
 * 
 * 
 *
 * @author (Warren Pullen)
 * @version (23/02/2024)
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MontyHall {
    public ArrayList<String> doors;
    public Random ran;

    // Q1b. Public zero parameter constructor initalise doors to an empty Array list and ran to a instance of Random
    public MontyHall() {
        doors = new ArrayList<>();
        ran = new Random();
    }
    /**
     * Q1C.Public method which clears doors then populates doors with strings "Goat","Goat" and "Car"
     * The Method then shuffles Array list doors and iterates through the list until it finds the postion 
     * of the String "Car" the method then returns the postion of car in the list + 1
     */
    public int setUp() {
        // clear doors
        doors.clear();
        //populate doors with Strings
        doors.add("Goat");
        doors.add("Goat");
        doors.add("Car");
        // Shuffle order of Strings in list
        Collections.shuffle(doors);
        // For loop to find postion of String Car and return postion +1
        int carDoorNumber = 0;
        for (int i = 0; i < doors.size(); i++) {
            if (doors.get(i).equals("Car")) {
                carDoorNumber = i + 1;
                break;
            }
        }
        return carDoorNumber;
    }
    //Q1d. Method which returns a random int between 1-3 to represent contestant's choice
    public int getContestantChoice() {
        return ran.nextInt(3) + 1;
    }
    /**
     * Q1e.Public method which takes a int which represents the number of the door the contestant has selected
     * if the selected door has a value of String goat the method will return the door number which has a value of String car
     * If the selected door has a value of String car the method will return a random door number of the two remaining doors
     */ 
    public int findAlternativeDoor(int contestantDoorNum) {
    // Check if the contestant's door number has a goat behind it
    if (doors.get(contestantDoorNum - 1).equals("Goat")) {
        // For Loop which returns the door number that holds the car
        for (int i = 0; i < doors.size(); i++) {
            if (i + 1 != contestantDoorNum && doors.get(i).equals("Car")) {
                return i + 1; 
            }
        }
    } else {
        // Shuffle the doors again not including the contestant's door number
        ArrayList<Integer> alternativeDoors = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            if (i != contestantDoorNum) {
                alternativeDoors.add(i);
            }
        }
        Collections.shuffle(alternativeDoors);

        // Return the first postion of the shuffled alternative door list
        return alternativeDoors.get(0);
    }
    return 0; //Should not hit this however I need to include this for it to compile correctly, error on my part, please can you include in feedback how I can amend this
    }
    /**
     * Q1f. Public method boolean parameter to indicate if the contestant has choosen to stick or switch 
     * Uses setUp method to assign a carDoorNumber,uses ContestantChoice to assign contestantchoice and uses
     * findAlterantiveDoor on contestant choice to assign alterantiveDoor
     * if isStick equals true the contestant sticks else they switch to the alternative door
     * The method returns true if the contestant wins otherwise it returns false
     */
    public boolean playGame(boolean isStick) {
        // Set up the doors using setUp method
        int carDoorNumber = setUp();

        // Contestant makes an initial choice using getContestantChoice method
        int contestantChoice = getContestantChoice();

        // Find the alternative door using findAlternativeDoor on contestantChoice
        int alternativeDoor = findAlternativeDoor(contestantChoice);

        // Determine the final door based on the contestant's strategy
        int finalChoice;
        if (isStick) {
            finalChoice = contestantChoice;
        } else {
            finalChoice = alternativeDoor;
        }

        // Check if the final choice is the door with the car
        if (finalChoice == carDoorNumber) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Q1G.Public Method which takes an int parameter which represents how many times to run the game with a stick 
     * and switch stratergy, this method counts how many times each stratergy wins then prints the results
     */
    public void simulate(int numRuns) {
    //set both tallys to zero
    int stickWins = 0;
    int switchWins = 0;

    for (int i = 0; i < numRuns; i++) {
        // Play the game with a stick strategy
        if (playGame(true)) {
            stickWins++;
        }

        // Play the game with a switch strategy
        if (playGame(false)) {
            switchWins++;
        }
    }

    // Print the results
    System.out.println("Wins by sticking: " + stickWins);
    System.out.println("Wins by switching: " + switchWins);
    }

}