package onboarding;

import java.io.PrintStream;
import java.util.List;
import java.util.ArrayList;

import static java.util.Collections.max;

/*
- 기능 구현사항 목록-
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
        if(pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1 || pobi.get(0) % 2 != 1 || crong.get(0) %2 != 1) {
            return -1;
        }

        List<Integer> pobi_new = new ArrayList<>(2);
        List<Integer> crong_new = new ArrayList<>(2);
        for (int i = 0; i < 2; i++){
            pobi_new.add(find_max(pobi.get(i)));
            crong_new.add(find_max(crong.get(i)));
        }
        int pobi_max = max(pobi_new);
        int crong_max = max(crong_new);

        if(pobi_max == crong_max){
            return 0;
        }
        else if(pobi_max > crong_max){
            return 1;
        }
        else if(pobi_max < crong_max){
            return 2;
        }
        return 0;
    }
}