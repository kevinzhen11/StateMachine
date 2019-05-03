package com.company;

class Rule {
    String stateNumber;
    String inputCharacter;
    String transitionsToState;

    Rule (String stateNumber, String inputCharacter, String transitionsToState) {
        this.stateNumber = stateNumber;
        this.inputCharacter = inputCharacter;
        this.transitionsToState = transitionsToState;
    }
}
