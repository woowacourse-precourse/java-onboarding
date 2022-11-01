package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {



        int MaxPobi = Max(pobi);
        int MaxCrong = Max(crong);
        int result = 0;

        if (MaxPobi > MaxCrong) {
            result =1;
        } else if (MaxPobi == -1 || MaxCrong == -1) {
            result = -1;
        } else if (MaxPobi == MaxCrong ) {
            result = 0;
        }else if(MaxPobi<MaxCrong) {
            result = 2;
        }

        return result;
    }

    public static int Max (List<Integer> n){
        int [] maxCompare = new int[4];
        maxCompare[1]=1;
        maxCompare[3]=1;
        int leftCase = n.get(0);
        while(leftCase!=0){
            maxCompare[0]+= leftCase%10;
            maxCompare[1]*= leftCase%10;
            leftCase /= 10;
        }
        int rightCase = n.get(1);
        while(rightCase!=0){
            maxCompare[2]+= rightCase%10;
            maxCompare[3]*= rightCase%10;
            rightCase /= 10;
        }
        int max = 0;
        for(int i=0; i<4;i++){
            if(maxCompare[i]>max){
                max = maxCompare[i];
            }
        }
        if(n.get(0)+1 != n.get(1)){
            max = -1;
        }
        return max;
    }





}