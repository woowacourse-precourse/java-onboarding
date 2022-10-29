package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {

    static List<Integer> pobiList = new ArrayList<>();
    static List<Integer> crongList = new ArrayList<>();

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        pobiList = countList(pobi);
        crongList = countList(crong);
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
}
