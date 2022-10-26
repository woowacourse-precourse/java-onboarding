package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        /*
        * 설명 : 입력값이 올바르지 않는 경우 -1를 반환한다.
        * */
        if(!isPageRight(pobi) || !isPageRight(crong)) return -1;


        return answer;
    }

    private static boolean isPageRight(List<Integer> human){
        int leftPage = human.get(0);
        int rightPage = human.get(1);

        return ((rightPage - leftPage) == 1);
    }

    private static int sum(int num){
        int value = 0;
        char[] chars = String.valueOf(num).toCharArray();
        for(int i=0; i<chars.length; i++){
            value += (chars[i]-'0');
        }
        return value;
    }

    private static int multiply(int num){
        int value = 1;
        char[] chars = String.valueOf(num).toCharArray();
        for(int i=0; i<chars.length; i++){
            value *= (chars[i]-'0');
        }
        return value;
    }
}