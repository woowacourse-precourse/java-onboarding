package onboarding;

import java.util.List;
import java.util.ArrayList;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiNum = maxNumber(pobi.get(0), pobi.get(1));
        int crongNum = maxNumber(crong.get(0), crong.get(1));


        if (checkNumber(pobi, crong) == 1) {
            answer = -1;
        } else if (pobiNum > crongNum) {
            answer = 1;
        } else if (pobiNum < crongNum) {
            answer = 2;
        } else {
            answer = 0;
        }

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

    public static int addNumber(int left, int right) {
        List<Integer> leftNumList = separateNumber(left);
        List<Integer> rightNumList = separateNumber(right);

        int resultLeft = 0, resultRight = 0;

        for (int i = 0; i < leftNumList.size(); i++) {
            resultLeft += leftNumList.get(i);
        }

        for (int i = 0; i < rightNumList.size(); i++) {
            resultRight += rightNumList.get(i);
        }

        if (resultLeft > resultRight) {
            return resultLeft;
        } else {
            return resultRight;
        }
    }

    public static int mulNumber(int left, int right) {
        List<Integer> leftNumList = separateNumber(left);
        List<Integer> rightNumList = separateNumber(right);

        int resultLeft = 1, resultRight = 1;

        for (int i = 0; i < leftNumList.size(); i++) {
            resultLeft *= leftNumList.get(i);
        }

        for (int i = 0; i < rightNumList.size(); i++) {
            resultRight *= rightNumList.get(i);
        }

        if (resultLeft > resultRight) {
            return resultLeft;
        } else {
            return resultRight;
        }
    }

    public static int maxNumber(int left, int right) {
        int addNum = 0, mulNum = 0;

        addNum = addNumber(left, right);

        mulNum = mulNumber(left, right);

        if (addNum > mulNum) {
            return addNum;
        } else {
            return mulNum;
        }
    }
}