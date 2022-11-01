package onboarding;

import java.util.*;

import static java.sql.Types.NULL;

class Problem1 {
    //Page가 주어졌을 때, 각 자리 숫자를 모두 더하거나 곱하여 가장 큰 수를 구하기
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
    //왼쪽 페이지와 오른쪽 페이지에서 구한 최댓값 중 더 큰 값을 본인의 값으로 정하기
    static int myMax(List<Integer> pageList){
        int left = calculateMax(pageList.get(0));
        int right = calculateMax(pageList.get(1));
        if (left >= right){
            return left;
        } else {
            return right;
        }
    }
    //예외 케이스
    static boolean isError(List<Integer> pobi, List<Integer> crong){
        boolean status = false;
        //시작 면이 나온 경우
        if(pobi.get(0) == 1 || crong.get(0) == 1){
            status = true;
        }
        //마지막 면이 나온 경우
        if(pobi.get(1) == 400 || crong.get(0) == 400){
            status = true;
        }
        //왼쪽 페이지가 홀수가 아닌 경우
        if(pobi.get(0)%2 == 0 || crong.get(0)%2 == 0){
            status = true;
        }
        //오른쪽 페이지가 짝수가 아닌 경우
        if(pobi.get(1)%2 == 1 || crong.get(1)%2 == 1){
            status = true;
        }
        //페이지 간격이 1이 아닌 경우
        if(pobi.get(1)-pobi.get(0) != 1 || crong.get(1)-crong.get(0) != 1){
            status = true;
        }
        return status;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 포비의 최댓값
        int pobiValue = myMax(pobi);
        // 크롱의 최댓값
        int crongValue = myMax(crong);
        int answer = NULL;
        // 포비 승
        if (pobiValue > crongValue) {
            answer = 1;
        }
        // 크롱 승
        if (pobiValue < crongValue) {
            answer = 2;
        }
        // 무승부
        if (pobiValue == crongValue) {
            answer = 0;
        }
        // 예외사항
        if(isError(pobi, crong)){
            answer = -1;
        }

        return answer;
    }
}