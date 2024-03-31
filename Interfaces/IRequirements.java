package src.Interfaces;

import javafx.scene.control.TextArea;

public interface IRequirements {
    /*
     * List of members in the group
     * Requirement: Implemented the method to provide the names of group members.
     */
    String[] groepsleden();

    /*
     * Convert char to morse code
     * Requirement: Implemented the method to convert a character to Morse code.
     */
    String abs2morse(String text);

    /*
     * Convert morse code to char
     * Requirement: Implemented the method to convert Morse code to a character.
     */
    String morse2abc(String inputString);

    /*
     * Convert from input field
     * Requirement: Implemented the method to perform the conversion based on user input.
     */
    void convert(TextArea input, TextArea output);

    /*
     * Swap input and output fields data
     * Requirement: Implemented the method to swap data between input and output fields.
     */
    void swap(TextArea input, TextArea output);

    /*
     * Clear input and output data
     * Requirement: Implemented the method to clear input and output data.
     */
    void clear(TextArea input, TextArea output);

    /*
     * Example input for morse code to abc
     * Requirement: Provided an example input for Morse code.
     */
    String exampleMorseCode();

    /*
     * Example input for morse code to abc
     * Requirement: Provided an example input for conversion.
     */
    String exampleString();

    /*
     * Help
     * Requirement: Implemented the help/explanation method to guide users.
     */
    String explain();
}
