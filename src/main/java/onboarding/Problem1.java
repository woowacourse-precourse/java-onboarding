package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int pobiLeftNum = compare(pobi.get(0));

        int pobiRigthNum = compare(pobi.get(1));

        int pobiNum = 0;

        if(pobiLeftNum >= pobiRigthNum) pobiNum = pobiLeftNum;
        else if(pobiLeftNum < pobiRigthNum) pobiNum = pobiRigthNum;


        int crongLeftNum = compare(crong.get(0));

        int crongRightNum = compare(crong.get(1));

        int crongNum = 0;
        if(crongLeftNum >= crongRightNum) crongNum = crongLeftNum;
        else if(crongLeftNum < crongRightNum) crongNum = crongRightNum;



        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static int compare(int pororo){

        int temp = pororo;

        int pororoNum1 = 0;
        pororoNum1 = pororoNum1 + pororo % 10;
        pororo = pororo/10;

        pororo = temp;

        int pororoNum2 = 1;
        pororoNum2 = pororoNum2 * pororo % 10;
        pororo = pororo/10;

        if(pororoNum1 >= pororoNum2) return pororoNum1;
        else return pororoNum2;

    }

}