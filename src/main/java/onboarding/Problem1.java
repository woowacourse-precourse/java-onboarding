package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
# 예외상황 판단
1. 홀, 짝 으로 이루어져있는지 확인
2. 1, 400페이지 가 없는지 확인
3. 1차이가 나는지 확인
 */
/*
# 기능 구현
1. 예외상황 판단
2. pobi, crong 리스트에[왼쪽더한것, 왼쪽곱한것, 오른쪽더한것, 오른쪽곱한것] / 리스트 생성
3. 각각의 점수(max) 생성
4. 점수 비교
 */
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobi_score = 0;
        int crong_score = 0;
        int answer = Integer.MAX_VALUE;
        if (!checkData(pobi) || !checkData(crong)) {
            return -1;
        }
        List<Integer> pobi_scores = makeScoreList(pobi);
        List<Integer> crong_scores = makeScoreList(crong);

        pobi_score = Collections.max(pobi_scores);
        crong_score = Collections.max(crong_scores);

        if (pobi_score > crong_score) {
            answer = 1;
        }
        else if (pobi_score < crong_score) {
            answer = 2;
        }
        else {
            answer = 0;
        }

        return answer;
    }
    public static boolean checkData(List<Integer> list) { // 예외상황인지 확인하는 메서드
        int left = list.get(0);
        int right = list.get(1);
        if ((left % 2 == 0) || (right % 2 == 1)) { // 왼쪽에는 홀수가, 오른쪽에는 짝수가 와야한다.
            return false;
        }
        if (right - left != 1) { // 페이지의 차이는 1이어야만 한다
            return false;
        }
        if (left < 1 || left > 400 || right < 1 || right > 400) { // 페이지의 범위는 1~400이어야 한다
            return false;
        }
        return true;
    }
    public static List<Integer> makeScoreList(List<Integer> list) {
        int sum = 0;
        int mul = 1;
        List<Integer> result = new ArrayList<Integer>();
        for (Integer num : list) {
            sum = 0;
            mul = 1;
            while(true) {
                sum += num % 10;
                mul *= num % 10;
                if (num < 10)
                        break;
                num = num / 10;
            }
            result.add(sum);
            result.add(mul);
        }
        return result;
    }
}