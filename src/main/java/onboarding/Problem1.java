package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        //입력받은 값이 올바른지 확인
        if(checknum(pobi, crong) == -1)
            return -1;

        return answer;
    }
    //올바른 값인지 확인
    public static int checknum(List<Integer> pobi, List<Integer> crong) {
        int checknum = 0;
        //pobi와 crong의 왼쪽 페이지가 홀수가 아니면 예외처리
        if(pobi.get(0)%2 != 1 || crong.get(0)%2 != 1)
            checknum = -1;
        //pobi와 crong의 오른쪽 페이지가 이상하면 예외처리
        if(pobi.get(1)-pobi.get(0)!=1 || crong.get(1)-crong.get(0)!=1)
            checknum = -1;
        //pobi와 crong이 첫페이지나 마지막 페이지이면 예외처리
        if(pobi.get(0) == 1 || pobi.get(0) == 400 || pobi.get(1) == 1 || pobi.get(1) == 400)
            checknum = -1;
        if(crong.get(0) == 1 || crong.get(0) == 400 || crong.get(1) == 1 || crong.get(1) == 400)
            checknum = -1;
        return checknum;
    }
    //곱한값
    public static int mul(int num){
        int temp = num;
        int result = 1;
        while(temp>0){
            result *= temp%10;
            temp /= 10;
        }
        return result;
    }
    //더한값
    public static int sum(int num){
        int temp = num;
        int result = 0;
        while(temp>0){
            result += temp%10;
            temp /= 10;
        }
        return result;
    }
}