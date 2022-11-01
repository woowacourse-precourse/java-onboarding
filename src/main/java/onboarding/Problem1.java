package onboarding;

import java.util.*;

import static java.sql.Types.NULL;

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
    static boolean isError(List<Integer> pobi, List<Integer> crong){
        boolean status = false;
        if(pobi.get(0) == 1 || crong.get(0) == 1){
            status = true;
        }
        if(pobi.get(1) == 400 || crong.get(0) == 400){
            status = true;
        }
        if(pobi.get(0)%2 == 0 || crong.get(0)%2 == 0){
            status = true;
        }
        if(pobi.get(1)%2 == 1 || crong.get(1)%2 == 1){
            status = true;
        }
        if(pobi.get(1)-pobi.get(0) != 1 || crong.get(1)-crong.get(0) != 1){
            status = true;
        }
        return status;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiValue = myMax(pobi);
        int crongValue = myMax(crong);
        int answer = NULL;

        if (pobiValue > crongValue) {
            answer = 1;
        }
        if (pobiValue < crongValue) {
            answer = 2;
        }
        if (pobiValue == crongValue) {
            answer = 0;
        }
        if(isError(pobi, crong)){
            answer = -1;
        }

        return answer;
    }
}