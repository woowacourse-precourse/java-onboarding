package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;





        return answer;
    }

    // 각 자리수를 구한다.
    public static List<Integer> getEachDigit(int page) {
        List<Integer> pageDigitList = new ArrayList<>();
        while(page > 0){
            pageDigitList.add(page % 10);
            page /= 10;
        }
        return pageDigitList;
    }

    // 각 자리수의 합을 구한다.
    public static int getTotal(List<Integer> pageDigitList) {
        int answer = 0;
        for (int i = 0; i < pageDigitList.size(); i++) {
            answer += pageDigitList.get(i);
        }
        return answer;
    }



    // 구한 값 중 최댓값을 구한다.
}