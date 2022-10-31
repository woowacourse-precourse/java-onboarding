package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(pobi.get(0) == 1 || pobi.get(1) == 400 ||
                crong.get(0) == 1 || crong.get(1) == 400) return -1;

        if(pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != crong.get(1)) return -1;

        int temp = 1;
        int first = pobi.get(0);
        ArrayList<Integer> firstNum = new ArrayList<>();
        int firstMax = 0;
        int second = pobi.get(1);
        ArrayList<Integer> secondNum = new ArrayList<>();
        int secondMax = 0;
        int pobiSol;

        while(first > 0) {
            firstNum.add(first % 10);
            first /= 10;
        }
        
        for (int i = 0; i < firstNum.size(); i++) {
            firstMax += firstNum.get(i);
            temp = temp * firstNum.get(i);
        }

        if(firstMax < temp) firstMax = temp;

        while(second > 0) {
            secondNum.add(second % 10);
            second /= 10;
        }

        temp = 1;

        for (int i = 0; i < secondNum.size(); i++) {
            secondMax += secondNum.get(i);
            temp = temp * secondNum.get(i);
        }

        if(secondMax < temp) secondMax = temp;

        pobiSol = secondMax;
        if(firstMax > secondMax) pobiSol = firstMax;

        // crong
        temp = 1;
        first = crong.get(0);
        firstNum.clear();
        firstMax = 0;
        second = crong.get(1);
        secondNum.clear();
        secondMax = 0;
        int crongSol;

        while(first > 0) {
            firstNum.add(first % 10);
            first /= 10;
        }

        for (int i = 0; i < firstNum.size(); i++) {
            firstMax += firstNum.get(i);
            temp = temp * firstNum.get(i);
        }

        if(firstMax < temp) firstMax = temp;

        while(second > 0) {
            secondNum.add(second % 10);
            second /= 10;
        }

        temp = 1;

        for (int i = 0; i < secondNum.size(); i++) {
            secondMax += secondNum.get(i);
            temp = temp * secondNum.get(i);
        }

        if(secondMax < temp) secondMax = temp;

        crongSol = secondMax;
        if(firstMax > secondMax) crongSol = firstMax;

        answer = 0;
        if (pobiSol > crongSol) answer = 1;
        if (crongSol > pobiSol) answer = 2;

        return answer;
    }
}