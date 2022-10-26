package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        /*
        * 설명 : 입력값이 올바르지 않는 경우 -1를 반환한다.
        * */
        if(!isPageRight(pobi) || !isPageRight(crong)) return -1;

        /*
         * 설명 : 좌, 우 페이지 중 최댓값을 구해 저장한다.
         * */
        int pobiMaxNumber = maxNum(pobi);
        int crongMaxNumber = maxNum(crong);

        return answer;
    }

    private static boolean isPageRight(List<Integer> human){
        int leftPage = human.get(0);
        int rightPage = human.get(1);

        return ((rightPage - leftPage) == 1);
    }

    private static int maxNum(List<Integer> person){
        int leftPage = person.get(0);
        int rightPage = person.get(1);

        int sum = Math.max(sum(leftPage), multiply(leftPage));
        int mul = Math.max(sum(rightPage), multiply(rightPage));

        return Math.max(sum, mul);
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