package onboarding;

import java.util.List;


/**
 * 기능 구현 목록
 * 1) 페이지 번호를 자릿수 별로 곱해서 수를 만드는 기능 구현
 * 2) 예외 상황처리 구현
 */
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!FindException(pobi.get(0), pobi.get(1)) || !FindException(crong.get(0), crong.get(1))) {
            answer = -1;
        }else {
            int pobiscore = Math.max(Score(pobi.get(0)), Score(pobi.get(1)));
            int crongscore = Math.max(Score(crong.get(0)), Score(crong.get(1)));
            if (pobiscore > crongscore) {
                answer = 1;
            } else if (pobiscore == crongscore){
                answer = 0;
            } else{
                answer = 2;
            }
        }
        return answer;
    }

    private static boolean FindException(int page1, int page2){
        boolean b = (page1<=1 || page1>=399 || page1!=page2-1) ? false : true;
        return b;
    }
    private static int Score(int idx){
        int sum = 0;
        int mul = 1;

        while(idx!=0){
            sum += idx%10;
            mul *= idx%10;
            idx /= 10;
        }
        return Math.max(sum, mul);
    }
}