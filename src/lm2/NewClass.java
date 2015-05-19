/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lm2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Matt
 */
public class NewClass {
    public static State acceptable = new State("Stan Akceptowalny");
    public static State nonAcceptable = new State("Stan nieakceptowalny");
    public static State currentStates;
    public static void main(String[] args) {
        currentStates = nonAcceptable;
        
        initialize();
        
        State s1, s2;
        String test = "1455652263";
        for(char letter : test.toCharArray()){
            
            List<State> nextStates = currentStates.getStateByLetter(String.valueOf(letter));
            if (nextStates.get(0) == acceptable) {
                currentStates = nextStates.get(1).getStateByLetter(String.valueOf(letter)).get(0);
            } else {
                currentStates = nextStates.get(0);
            }
            if(currentStates == acceptable){
                System.out.println(letter);
            }
        }
    }

    private static void initialize() {
        for(int i=0;i<10;i++){
            nonAcceptable.addState(String.valueOf(i), Arrays.asList(nonAcceptable,acceptable));
            acceptable.addState(String.valueOf(i), Arrays.asList(nonAcceptable,acceptable));
        }
    }
}
