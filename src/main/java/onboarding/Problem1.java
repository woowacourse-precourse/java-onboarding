package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static int findMaxNum(String page){
        int add = page.charAt(0)-'0';
        int multiple = page.charAt(0)-'0';

        for(int i=1;i<page.length();i++){
            add += page.charAt(i)-'0';
            multiple *= page.charAt(i)-'0';
        }

        return Math.max(add, multiple);
    }
}