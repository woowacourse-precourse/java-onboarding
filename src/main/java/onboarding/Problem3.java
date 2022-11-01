package onboarding;

import java.util.ArrayList;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i = 1;i<=number;i++){
            ArrayList<Integer> digits = getDigits(i);
            answer += countClap(digits);
        }

        return answer;
    }

    public static ArrayList<Integer> getDigits(int number){
        ArrayList<Integer> digits = new ArrayList<>();
        while(number>0){
            digits.add(number%10);
            number /= 10;
        }
        return digits;
    }

    public static int countClap(ArrayList<Integer> digits){
        int count = 0;

        for(int digit : digits){
            if(digit==3 || digit==6 || digit==9){
                count++;
            }
        }

        return count;
    }

}
