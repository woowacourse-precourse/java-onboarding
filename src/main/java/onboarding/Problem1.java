package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
    public static int score(List<Integer> list){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            char[] chars = list.get(i).toString().toCharArray();

            int a = 0;
            int b = 1;
            for (char cha:chars) {
                a += cha - '0';
                b *= cha - '0';
            }
            max = Integer.max(max, a);
            max = Integer.max(max, b);
        }
        return max;
    }
}