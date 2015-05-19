/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lm2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;

/**
 *
 * @author student
 */
public class LM2{

    /**
     * @param args the command line arguments
     */
    // -2 TO KONIEC PROGAMU
    // -1 TO NIE AKCEPTOWALNY
    // A - AKCEPTOWALNY
    public static final String[][] stateTable =
    {{"A","1","2","3","4","5","6","7","8","9"},
     {"0","A","2","3","4","5","6","7","8","9"},
    {"0","1","A","3","4","5","6","7","8","9"},
    {"0","1","2","A","4","5","6","7","8","9"},
    {"0","1","2","3","A","5","6","7","8","9"},
    {"0","1","2","3","4","A","6","7","8","9"},
    {"0","1","2","3","4","5","A","7","8","9"},
    {"0","1","2","3","4","5","6","A","8","9"},
    {"0","1","2","3","4","5","6","7","A","9"},
    {"0","1","2","3","4","5","6","7","8","A"},
    {"0","1","2","3","4","5","6","7","8","9"},
    {"-2","-2","-2","-2","-2","-2","-2","-2","-2","-2"},
    {"0","1","2","3","4","5","6","7","8","9"}};

    public static String currentState = "-1";
    public static String content="";
    static GUI gui;
    public static void main(String[] args) {
        gui = new GUI();
        gui.setVisible(true);
    }

    public static void launch() throws NumberFormatException {

        Map<String, Integer> mapping = new HashMap<String, Integer>();
        mapping.put("-1", 10);
        mapping.put("-2", 11);
        mapping.put("A", 12);
        ArrayList<Integer> acceptableStates = new ArrayList<>();
        String[] numbers = content.split("#");
        for(String number : numbers){
            
            gui.addText("Dla ciągu: "+number);
            for(int i=0;i<number.length();i++){

                int letter = Integer.parseInt(number.charAt(i)+"");
//                gui.addText("Wejscie: "+letter);

                if(currentState.equals("-2")){
                    gui.addText("Koniec");
                    break;
                }
                int index;
                if(mapping.containsKey(currentState)){
                    index = mapping.get(currentState);
                } else {
                    index = Integer.parseInt(currentState);
                }
//                gui.addText("Aktualny stan: "+currentState);
                currentState = stateTable[index][letter];
//                gui.addText("Nastepny stan: "+currentState);
//                gui.addText("------------------------");
                if(currentState.equals("A")){
                    acceptableStates.add(i);
                } 
            }
            gui.addText(acceptableStates.toString());
            acceptableStates.clear();
        }
        
        
    }

}
