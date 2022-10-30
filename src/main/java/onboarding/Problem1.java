package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        String temp1,temp2;
        temp1 = Integer.toString(pobi.get(0));
        temp2 = Integer.toString(pobi.get(1));

        int tempAdd = 0;
        int tempMul =1;
        int tempLeft,tempRight;
        for (int i=0; i<temp1.length(); i++){
            tempAdd += temp1.codePointAt(i);
            tempMul *= temp1.codePointAt(i);
        }

        if(tempAdd>=tempMul)
            tempLeft = tempAdd;
        else
            tempLeft = tempMul;



        return answer;
    }
}