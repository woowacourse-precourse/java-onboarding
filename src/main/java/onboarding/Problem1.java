package onboarding;

import java.util.*;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobi_score = max_score(pobi);
        int crong_score = max_score(crong);

        q
        if(pobi_score>crong_score) return 1;
        else if(pobi_score<crong_score) return 2;
        else if (pobi_score==crong_score) return 0;

        return answer;
    }

    public static int Sum(int page){
        String page_str = String.valueOf(page);
        int sum = 0;
        for(char c : page_str.toCharArray()){
            sum+=(c-'0');
        }
        return sum;
    }

    public static int Multi(int page){
        String page_str = String.valueOf(page);
        int multi = 1;
        for(char c : page_str.toCharArray()){
            multi*=(c-'0');
        }
        return multi;
    }

    public static int max_score(List<Integer> user){
        int max = Integer.MIN_VALUE;
        for(Integer x: user){
            max = Math.max(max,Sum(x));
            max = Math.max(max,Multi(x));
        }
        return max;
    }

}