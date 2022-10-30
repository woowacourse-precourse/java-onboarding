package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class Problem1 {

    static List<Integer> pobiList = new ArrayList<>();
    static List<Integer> crongList = new ArrayList<>();
    static int pobiMaxValue;
    static int crongMaxValue;
    static int answer;


    public static int solution(List<Integer> pobi, List<Integer> crong) {

        pobiList = countList(pobi);
        crongList = countList(crong);

        pobiMaxValue = getMaxValue(pobiList);
        crongMaxValue = getMaxValue(crongList);

        answer = findWinner();
        return answer;
    }

    public static List<Integer> countList(List<Integer> pageList) {
        List<Integer> returnList = new ArrayList<>();

        for (int index = 0; index < 2; index++) {
            int pageIndexValue = pageList.get(index);
            returnList.add(getElementSum(pageIndexValue));
            returnList.add(getElementMul(pageIndexValue));
        }

        return returnList;
    }

    public static int getElementSum(int pageElement){
        int elementSum = 0;
        String pageStringNumber = Integer.toString(pageElement);

        for (int index = 0; index < pageStringNumber.length(); index++) {
            elementSum += pageStringNumber.charAt(index) - '0';
        }

        return elementSum;

    }

    public static int getElementMul(int pageElement){
        int elementMul = 1;
        String pageStringNumber = Integer.toString(pageElement);

        for (int index = 0; index < pageStringNumber.length(); index++) {
            elementMul *= pageStringNumber.charAt(index) - '0';
        }

        return elementMul;

    }

    public static int getMaxValue(List<Integer> userList){
       int maxUserValue;
       maxUserValue = Collections.max(userList);
       return maxUserValue;
    }

    public static int findWinner(){
        int answerValue;

        if (pobiMaxValue > crongMaxValue){
            answerValue = 1;
        }else if(pobiMaxValue < crongMaxValue){
            answerValue = 2;
        }else if(pobiMaxValue == crongMaxValue) {
            answerValue = 0;
        }

        return answerValue;
    }
}
