package onboarding;
import java.util.*;
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if(Except(pobi)) return -1;
        if(Except(crong)) return -1;

        int pobi_score = max_score(pobi);
        int crong_score = max_score(crong);

        if(pobi_score>crong_score) return 1;
        else if(pobi_score<crong_score) return 2;
        else return 0;
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

    public static boolean Except(List<Integer> user){

        int pg_left = user.get(0);
        int pg_right = user.get(1);

        if(pg_left<1 || pg_right<1 || pg_left > 400 || pg_right > 400) return true;
        if(pg_right-pg_left!=1) return true;
        if(pg_left>=pg_right) return true;

        return false;
    }

}