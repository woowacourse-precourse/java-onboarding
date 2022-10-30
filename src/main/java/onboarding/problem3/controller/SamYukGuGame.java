package onboarding.problem3.controller;

import onboarding.problem3.service.SamYukGuGameUtilsService;

public class SamYukGuGame {
    private int number;
    private int totalHandClapCount;

    public SamYukGuGame setNumber(int number){
        this.number = number;
        return this;
    }

    public SamYukGuGame startGame(){
        for(int currentNumber = 1; currentNumber<=number; currentNumber++){
            totalHandClapCount += SamYukGuGameUtilsService.getHandClapCount(currentNumber);
        }
        return this;
    }

}
