/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lm2;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Matt
 */
class State {
    private String label;
    private HashMap<String, List<State>> nextStates = new HashMap<>();

    public State(String label) {
        this.label = label;
    }

    public void addState(String key, List<State> state){
        this.nextStates.put(key, state);
    }
    
    public List<State> getStateByLetter(String key){
        return this.nextStates.get(key);
    }
    
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
}
