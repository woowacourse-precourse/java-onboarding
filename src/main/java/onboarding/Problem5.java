package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int arr[] = {50000,10000,5000,1000,500,100,50,10,1};
        List<Integer> answer = Collections.emptyList();
        int i=0;
        while(money!=0){
            answer.add(money/arr[i]);
            money%=arr[i];
            i++;
        }

        if(answer.size()!=arr.length){
            for(int j=answer.size();j<arr.length;j++){
                answer.add(0);
            }
        }



        return answer;
    }
}
