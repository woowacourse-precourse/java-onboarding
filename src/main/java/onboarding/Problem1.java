package onboarding;

import java.util.List;
import java.util.ArrayList;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static int checkNumber(List<Integer> pobiList, List<Integer> crongList) {
        int checkNum = 0;

        if (pobiList.get(1) - pobiList.get(0) != 1) {
            checkNum = 1;
        } else if (crongList.get(1) - crongList.get(0) != 1) {
            checkNum = 1;
        }

        return checkNum;
    }

    public static List<Integer> separateNumber(int inputNumber) {
        List<Integer> separateList = new ArrayList<Integer>();

        int lengthNumber = (Integer.toString(inputNumber)).length();

        for (int i = lengthNumber - 1; i >= 0; i--) {
            int separateNumberTemp = (int) (inputNumber / Math.pow(10, i));
            separateList.add(separateNumberTemp);
            inputNumber -= separateNumberTemp * Math.pow(10, i);
        }

        return separateList;
    }
}