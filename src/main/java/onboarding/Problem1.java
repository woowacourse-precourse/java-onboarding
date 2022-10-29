package onboarding;

import java.io.PrintStream;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;

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
        int[] arrNum = Stream.of(String.valueOf(s).split("")).mapToInt(Integer::parseInt).toArray();
        for(int i = 0; i < arrNum.length; i++){
            temp_max = temp_max + arrNum[i];
            temp_multi = temp_multi * arrNum[i];
        }
        if (temp_multi > temp_max) {
            return temp_multi;
        }
        return temp_max;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 예외처리
        if(pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1 || pobi.get(0) % 2 != 1 || crong.get(0) %2 != 1) {
            return -1;
        }
        // 각자 점수 산출
        List<Integer> pobi_new = new ArrayList<>(2);
        List<Integer> crong_new = new ArrayList<>(2);
        for (int i = 0; i < 2; i++){
            pobi_new.add(find_max(pobi.get(i)));
            crong_new.add(find_max(crong.get(i)));
        }
        int pobi_max = max(pobi_new);
        int crong_max = max(crong_new);
        // 비교
        if(pobi_max == crong_max){
            return 0;
        }
        else if(pobi_max > crong_max){
            return 1;
        }
        return 2;
    }
}