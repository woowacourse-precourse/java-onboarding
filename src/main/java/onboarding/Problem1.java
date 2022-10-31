package onboarding;

import java.util.*;

class Problem1 {
    static int calculateMax(int page){
        int sum = 0;
        int mul = 1;
        while(page > 1){
            sum += page % 10;
            mul *= page % 10;
            page /= 10;
        }
        if(sum >= mul){
            return sum;
        } else {
            return mul;
        }
    }

    static int myMax(List<Integer> pageList){
        int left = calculateMax(pageList.get(0));
        int right = calculateMax(pageList.get(1));
        if (left >= right){
            return left;
        } else {
            return right;
        }
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiValue = myMax(pobi);
        int crongValue = myMax(crong);
        int answer;
        if (pobiValue > crongValue) {
            answer = 1;
        } else if (pobiValue < crongValue) {
            answer = 2;
        } else if (pobiValue == crongValue) {
            answer = 0;
        } else {
            answer = -1;
        }
        return answer;
    }
}