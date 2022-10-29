package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        return answer;
    }

    public static int Sum(int page){
        String page_str = String.valueOf(page);
        int sum = 0;
        for(char c : page_str.toCharArray()){
            sum+=(c-48);
        }
        return sum;
    }

}