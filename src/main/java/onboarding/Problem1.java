package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(!exception(pobi,crong)){
            return -1;
        }
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    // 페이지 번호 각자리 숫자 더하기, 곱한 후 가장 큰 수 구하기
    // 두개를 비교해서 큰 숫자 구하기
    // 점수 비교 승자 나타내기
    // 예외사항

    public static Boolean exception(List<Integer> pobi, List<Integer> crong){
        if(pobi.get(1)- pobi.get(0)==1 && crong.get(1)- crong.get(0)==1){
            return true;
        }
        return false;
    }

}