package onboarding;

import java.util.*;

class Problem1 {
    public static int sum(int a, int b, int c){
        return a+b+c;
    }
    public static int mul(int a, int b, int c){
        if(a != 0){
            return a*b*c;
        }
        else{
            if(b!=0)
                return b*c;
            else return c;
        }
    }
    public static boolean pageCheck(int num){
        if(num%2==1)
            return true;
        return false;
    }

    public static int getScore(int a,int b,int c, int aR, int bR, int cR){
        int leftMax, rightMax;
        if(sum(a,b,c)>mul(a,b,c)){
            leftMax = sum(a,b,c);
        }
        else{
            leftMax = mul(a,b,c);
        }

        if(sum(aR,bR,cR)>mul(aR,bR,cR)){
            rightMax = sum(aR,bR,cR);
        }
        else rightMax = mul(aR,bR,cR);

        if(leftMax>rightMax)
            return leftMax;
        return rightMax;
    }

    public static int getResult(int a,int b){
        if(a>b)
            return 1;
        else if(a<b)
            return 2;
        else return 0;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiScore, crongScore, result;
        result = Integer.MAX_VALUE;
        if(pobi.get(0)+1!=pobi.get(1) || crong.get(0)+1!=crong.get(1) || !(pobi.get(0)>1 && pobi.get(1)<400) || !(crong.get(0)>1 && crong.get(1)<400) || !(pageCheck(pobi.get(0))) || !(pageCheck(crong.get(0)))){
            return -1;
        }
        else {
            pobiScore = getScore(pobi.get(0) / 100, (pobi.get(0) % 100) / 10, (pobi.get(0) % 100) % 10, pobi.get(1) / 100, (pobi.get(1) % 100) / 10, (pobi.get(1) % 100) % 10);
            crongScore = getScore(crong.get(0) / 100, (crong.get(0) % 100) / 10, (crong.get(0) % 100) % 10, crong.get(1) / 100, (crong.get(1) % 100) / 10, (crong.get(1) % 100) % 10);

            result = getResult(pobiScore,crongScore);
        }

        return result;
    }
}