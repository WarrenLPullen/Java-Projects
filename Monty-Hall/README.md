### Description
This is a Java program that simulates the Monty Hall Problem. The program simulates the game show "Let's Make a Deal" and tracks the outcomes of sticking with the initial door choice versus switching to another door.

### How it Works
1.  The program initializes an ArrayList to represent the doors in the Monty Hall game.
2.  The `setUp()` method places "Goat", "Goat", and "Car" behind the doors, shuffles them, and determines the position of the "Car".
3.  The `getContestantChoice()` method simulates the contestant's initial door selection by randomly choosing a door.
4.  The `findAlternativeDoor()` method determines which door is revealed by the host (Monty Hall) and returns the other unchosen door.
5.  The `playGame()` method simulates a single game, allowing the contestant to either stick with their initial choice or switch to the alternative door. It then returns `true` if the contestant wins (chooses the door with the "Car") and `false` otherwise.
6.  The `simulate()` method runs the game a specified number of times for both the "stick" and "switch" strategies and prints the number of wins for each strategy.

### Files
* `MontyHall.java`: This file contains the Java code for the Monty Hall Problem simulation.

### How to Use
1.  Compile the `MontyHall.java` file using a Java compiler (like javac).
2.  Run the compiled class file (e.g., `java MontyHall`).
3.  You can then create an instance of the `MontyHall` class and call its methods to simulate games or run simulations.  The `simulate()` method is likely the most useful for observing the Monty Hall problem in action.

### Code Details
* `MontyHall.java`:
    * **Classes**:
        * `MontyHall`:
            * `doors`: An `ArrayList<String>` to represent the doors.
            * `ran`: A `Random` object for generating random numbers.
            * `MontyHall()`: Constructor to initialize `doors` and `ran`.
            * `setUp()`:  Clears the doors, adds "Goat", "Goat", and "Car", shuffles them, and returns the position of the "Car".
            * `getContestantChoice()`: Returns a random door choice (1, 2, or 3).
            * `findAlternativeDoor(int contestantDoorNum)`:  Determines the alternative door to offer the contestant.
            * `playGame(boolean isStick)`: Simulates a single game and returns `true` if the contestant wins.
            * `simulate(int numRuns)`:  Runs multiple simulations and prints the win counts for "sticking" and "switchin"
