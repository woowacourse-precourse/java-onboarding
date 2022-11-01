package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {

        int result = 0;

        for(int i = 1; i <= number; i++) {
            List<Integer> numberOfPosition = getNumberOfPosition(i);
            result += checkNumberList(numberOfPosition);
        }

        return result;
    }

    /**
     * 1 ~ 10,000 사이의 number을 인자로 받아 각자리 수가 들어있는 리스트를 반환하는 메서드
     */
    private static List<Integer> getNumberOfPosition(int number) {
        List<Integer> result = new ArrayList<>();

        while(number != 0) {
            result.add(number % 10);
            number = number / 10;
        }

        return result;
    }

    /**
     * 각자리 수가 들어있는 리스트를 확인해서 3, 6, 9에 해당하는 갯수만큼 반환하는 메서드
     */
    private static int checkNumberList(List<Integer> numberList) {
        int result = 0;

        for(int value : numberList) {
            result += isClap(value);
        }

        return result;
    }

    /**
     * 한자리 수인 number을 인자로 받고 3, 6, 9 중 해당하면 1 반환, 아니면 0 반환하는 메서드
     */
    private static int isClap(int number) {
        if(number == 3 || number == 6 || number == 9) {
            return 1;
        }
        return 0;
    }
}
