package onboarding.problem3.controller;

import onboarding.problem3.service.SamYukGuGameUtilsService;
import onboarding.problem3.utils.validator.Exception.NumberRangeException;
import onboarding.problem3.utils.validator.NumberRangeValidator;

public class SamYukGuGame {
    private int number;
    private int totalHandClapCount;

    public SamYukGuGame setNumber(int number){
        try{
            new NumberRangeValidator(number);
            this.number = number;
        }catch (NumberRangeException e){
            e.printStackTrace();
        }
        return this;
    }

    public SamYukGuGame startGame(){
        for(int currentNumber = 1; currentNumber<=number; currentNumber++){
            totalHandClapCount += SamYukGuGameUtilsService.getHandClapCount(currentNumber);
        }
        return this;
    }

    public int getTotalHandClapCount(){
        return this.totalHandClapCount;
    }

}
