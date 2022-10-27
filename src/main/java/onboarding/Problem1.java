package onboarding;

import java.io.PrintStream;
import java.util.List;
import java.util.ArrayList;
/*
1. 각 페이지 번호를 받아서 각 자리 숫자를 더하고, 곱한 숫자중 최댓값을 리턴 하는 함수 선언
2. 예외처리 사항 return -1
3. 1번 단계에서 얻은 값을 비교해 result 출
 */
class Problem1 {
    public static int find_max(int s) {
        int temp_max = 0;
        int temp_multi = 1;
        String str = String.valueOf(s);
        char[] s_new = str.toCharArray();
        int l = s_new.length;
        List<Integer> temp = new ArrayList<>(l);
        for (int i = 0; i < l; i++) {
            int c = Character.getNumericValue(s_new[i]);
            temp.add(c);
        }
        for(int i = 0; i < l; i++){
            temp_max = temp_max + temp.get(i);
            temp_multi = temp_multi * temp.get(i);
        }
        if (temp_multi > temp_max) {
            temp_max = temp_multi;
        }
        return temp_max;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}