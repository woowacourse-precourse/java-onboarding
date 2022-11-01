package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = Integer.MAX_VALUE;

       if(pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1){
           return answer = -1;
       }

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

        if(pobiNum > crongNum) answer = 1;
        else if(pobiNum < crongNum) answer = 2;
        else if(pobiNum == crongNum) answer = 0;
        else answer = -1;

        return answer;
    }

    public static int compare(int pororo){

        int temp1 = pororo;
        int pororoNum1 = 0;

        while(temp1 != 0){
            pororoNum1 = pororoNum1 + temp1 % 10;
            temp1 = temp1/10;
        }

        int temp2 = pororo;
        int pororoNum2 = 1;

        while(temp2 != 0){
            pororoNum2 *= temp2 % 10;
            temp2 = temp2/10;
        }

        if(pororoNum1 >= pororoNum2) return pororoNum1;
        else return pororoNum2;

    }
}