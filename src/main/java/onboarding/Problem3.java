package onboarding;

import java.util.ArrayList;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i = 1;i<=number;i++){
            ArrayList<Integer> digits = getDigits(number);
            answer += countClap(digits);
        }

        return answer;
    }

    public static ArrayList<Integer> getDigits(int number){
        ArrayList<Integer> digits = new ArrayList<>();

        return digits;
    }

    public static int countClap(ArrayList<Integer> digits){
        int count = 0;

        return count;
    }

}
