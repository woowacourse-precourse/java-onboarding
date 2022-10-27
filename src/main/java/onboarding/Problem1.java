package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static int plusnumber(String numbers){
        int number = 0;
        for(int i=0;i<numbers.length();i++){
            number += Integer.parseInt(String.valueOf(numbers.charAt(i)));
        }
        return number;
    }

    public static int mulnumber(String numbers){
        int number = 1;
        for(int i=0;i<numbers.length();i++){
            number*=Integer.parseInt(String.valueOf(numbers.charAt(i)));
        }
        return number;
    }
}