package onboarding.problem1.utils.validator;

import onboarding.problem1.utils.validator.exception.OddEvenPageException;

import java.util.List;

public class OddEvenPageValidator {
    private List<Integer> list;
    public OddEvenPageValidator(List<Integer> list) throws OddEvenPageException {
        this.list = list;
        validateOddEvenPageNumber();
    }

    private void validateOddEvenPageNumber() throws OddEvenPageException{
        if(!(checkOdd(list.get(0)) && checkEven(list.get(1)))){
            throw new OddEvenPageException("페이지 홀수 짝수가 맞지 않음");
        }
    }

    //홀수 체크
    private boolean checkOdd(int value){
        if((value % 2) != 0){
            return true;
        }
        return false;
    }
    //짝수 체크
    private boolean checkEven(int value){
        if((value % 2) == 0){
            return true;
        }
        return false;
    }
}
