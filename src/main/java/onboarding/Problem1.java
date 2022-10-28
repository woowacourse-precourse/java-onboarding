package onboarding;

import java.util.List;
/*
기능목록
1. 페이지별 최대 점수 구하는 기능
    1-1. 모두 더한 경우와 모두 곱한 경우 구해서 최대 찾기
2. 오른쪽, 왼쪽 중 최대 기능 구하는 기능
2. 승자 구하는 기능
 */
class Problem1 {
    //페이지를 전달인자로 최대 점수 구하는 기능
    public static Integer calcScore(Integer page){
        int plus=0; //모두 더하는 경우
        int multi=1; //모두 곱하는 경우
        while(page>0){
            int num=page%10;
            plus+=num;
            multi*=num;
            page/=10;
        }
        return plus>multi ? plus : multi;
    }
    //오른쪽, 왼쪽 페이지 중에 최대 구하는 기능
    public static Integer MaxPage(List<Integer> pages){
        int left=calcScore(pages.get(0));
        int right=calcScore(pages.get(1));
        return left>right? left : right;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        System.out.printf("pobi left : %d right: %d\n", calcScore(pobi.get(0)), calcScore(pobi.get(1)));
        System.out.printf("crong left : %d right: %d\n", calcScore(crong.get(0)), calcScore(crong.get(1)));
        System.out.printf("pobi max : %d", MaxPage(pobi));
        System.out.printf("crong max : %d", MaxPage(crong));
        return answer;
    }
}