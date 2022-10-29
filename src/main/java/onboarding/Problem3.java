package onboarding;

import java.util.ArrayList;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0, count = 1, currentNum =0;
        ArrayList<Integer> countDigits = new ArrayList<Integer>();
        while (count < number +1){
            currentNum = count;
            while(currentNum > 0){
                countDigits.add(currentNum%10);
                currentNum /= 10;
            }
            for(int n : countDigits){
                if( n == 3 || n == 6 || n == 9){
                    answer +=1;
                }
            }
            countDigits.clear();
            count++;
        }
        return answer;
    }
}
