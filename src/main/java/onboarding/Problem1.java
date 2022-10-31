package onboarding;

import java.util.List;
import java.lang.Math;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        

        if (pobi.get(1)-pobi.get(0) != 1 || crong.get(1)-crong.get(0) != 1){
            return -1;
        }

        int piboRet = calculateDigit(pobi);
        int crongRet = calculateDigit(crong);

        if(crongRet > piboRet){
            answer = 2;
        }
        else if(crongRet < piboRet){
            answer = 1;
        }
        else if(crongRet == piboRet){
            answer = 0;
        }

        return answer;
    }

    public static int calculateDigit(List<Integer> pages){
        int sum = 0;
        int mul = 0;
        for(Integer tmpPage : pages){
            
            int n = 0;
            int tmpSum = 0;
            int tmpMul = 1;

            while(tmpPage != 0){
                n = tmpPage % 10;
                tmpSum += n;
                tmpMul *= n;

                tmpPage /= 10;
            }
            if(sum < tmpSum){
                sum = tmpSum;
            }
            if(mul < tmpMul){
                mul = tmpMul;
            }

        }

        int ret = (sum > mul) ? sum : mul;

        return ret;
    }
}