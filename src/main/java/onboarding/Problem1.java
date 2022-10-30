package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int checkPobiExeptionResult = checkExceptions(pobi);
        int checkCrongExeptionResult = checkExceptions(pobi);
        if(!((checkCrongExeptionResult == 1) || (checkPobiExeptionResult == 1))) return -1;

        int pobiMaxValue = getMaxValue(pobi);
        int crongMaxValue = getMaxValue(crong);

        return getResult(pobiMaxValue, crongMaxValue);
    }

    private static int getResult(int pobi, int crong) {
        if (pobi < crong){
            return 2;
        } else if (pobi > crong){
            return 1;
        } else {
            return 0;
        }
    }

    public static  int getMaxValue(List<Integer> list){
        List<Integer> maxValue = new ArrayList<>();
        for (Integer el: list){
        maxValue.add(Math.max(getSumValue(el), getMultiplyValue(el)));
        }

        return (Math.max(maxValue.get(0), maxValue.get(1)));
    }

    public static int getSumValue(Integer number){
        return Stream.of(number.toString().split("")).mapToInt(Integer::parseInt).sum();
    }
    public static int getMultiplyValue(Integer number) {
        return Stream.of(number.toString().split("")).mapToInt(Integer::parseInt).reduce(1, (a,b) -> a * b);
    }

    public static int checkExceptions(List<Integer> list){
        int leftPage = list.get(0);
        int rightPage = list.get(1);
        int insub = rightPage - leftPage;

        if ((insub == 1) && (leftPage%2 == 1) && (rightPage % 2 == 0)) return 1;

        return -1;
    }
}