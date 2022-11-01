/*
기능 목록
i) returnMax(List<Integer> pages) -> page를 입력 받은 뒤 각 자리수를 곱했을 때와 더했을 때 비교 후 가장 큰 값을 출력한다.
ii) checkMatch(int pobi, int crong) -> pobi > crong : 1, pobi == crong : 0, pobi < crong : -1
iii) solution -> 입력 받은 값을 i), ii) 기능을 이용하여 적절한 값을 return 한다.
 */

package onboarding;

import java.util.List;

class Problem1 {

    int returnMax(List<Integer> pages){
        String page1 = Integer.toString(pages.get(0));
        String page2 = Integer.toString(pages.get(1));

        int temp_sum1 = 0;
        int temp_sum2 = 0;
        int temp_multiple1 = 1;
        int temp_multiple2 = 1;
        int result = 0;

        for (int i=0; i<page1.length(); i++){
            temp_sum1 += Integer.parseInt(page1.substring(i,i+1));
            temp_sum2 += Integer.parseInt(page2.substring(i,i+1));
            temp_multiple1 *= Integer.parseInt(page1.substring(i,i+1));
            temp_multiple2 *= Integer.parseInt(page2.substring(i,i+1));
        }

        if (temp_sum1 > result) result = temp_sum1;
        if (temp_sum2 > result) result = temp_sum2;
        if (temp_multiple1 > result) result = temp_multiple1;
        if (temp_multiple2 > result) result = temp_multiple2;

        return result;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}