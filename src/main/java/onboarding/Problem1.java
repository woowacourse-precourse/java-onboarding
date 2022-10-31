package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        //입력받은 값이 올바른지 확인
        if(checknum(pobi, crong) == -1)
            return -1;

        //승자 결정
        answer = comparenum(pobi, crong);

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
    //두 리스트를 비교해 승자 결정
    public static int comparenum(List<Integer> pobi, List<Integer> crong){
        int pobiscore = 0, crongscore = 0;
        int winner;
        for(int i=0; i<2; i++){
            int bigP, bigC;
            //pobi 더한값과 곱한값 비교
            if(mul(pobi.get(i)) >= sum(pobi.get(i)))
                bigP = mul(pobi.get(i));
            else
                bigP = sum(pobi.get(i));
            //crong 더한값과 곱한값 비교
            if(mul(crong.get(i)) >= sum(crong.get(i)))
                bigC = mul(crong.get(i));
            else
                bigC = sum(crong.get(i));
            //pobi값과 crong값 비교
            if(bigP > bigC)
                pobiscore++;
            else if(bigP < bigC)
                crongscore++;
        }
        //승자 정하기
        if(pobiscore > crongscore)
            winner = 1;
        else if(pobiscore < crongscore)
            winner = 2;
        else if(pobiscore == crongscore)
            winner = 0;
        else
            winner = -1;
        return winner;
    }
}