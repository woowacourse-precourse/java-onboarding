package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
            int answer = Integer.MAX_VALUE;

try {
    int leftnumP;
    int rightnumP;
    int leftnumC;
    int rightnumC;
    int pobiNum;
    int crongNum;

    leftnumP = pobi.get(0);
    rightnumP = pobi.get(1);
    leftnumC = crong.get(0);
    rightnumC = crong.get(1);

    if (leftnumC + 1 != rightnumC || leftnumP + 1 != rightnumP || leftnumC % 2 != 1 || rightnumC % 2 != 0
            || leftnumP % 2 != 1 || rightnumP % 2 != 0) {
        //페이지가 홀/짝이 다르거나, 페이지수가 +1 해서 잘못 넘어간 경우 예외처리.
        Exception Exception = new Exception();
        throw Exception;
    }
    int sumPobi = sum(leftnumP, rightnumP);
    int multiplePobi = multiply(leftnumP, rightnumP);

    int sumCrong = sum(leftnumC, rightnumC);
    int multipleCrong = multiply(leftnumC, rightnumC);

    pobiNum = sumPobi > multiplePobi ? sumPobi : multiplePobi;
    crongNum = sumCrong > multipleCrong ? sumCrong : multipleCrong;
    if (pobiNum > crongNum) {
        answer = 1;
    } else if (pobiNum < crongNum) {
        answer = 2;
    } else {
        answer = 0;
    }
}catch (Exception e){
    answer=-1;
}








        return answer;
    }
    static int sum(int x,int y){
        int sumx=0;
        int sumy=0;
        while(x!=0){
            sumx+=x%10;
            x=x/10;
        }
        while(y!=0){
            sumy+=y%10;
            y=y/10;
        }

        return sumx>sumy?sumx:sumy;
    }
    static int multiply(int x,int y){
        int multix=1;//초기값으로 0을 주면 안됨
        //0에다 어떤 수를 곱해도 다 0이 되기 때문임.
        int multiy=1;
        while(x!=0){
            multix*=x%10;
            x=x/10;
        }
        while(y!=0){
            multiy*=y%10;
            y=y/10;
        }

        return multix>multiy?multix:multiy;

    }

}