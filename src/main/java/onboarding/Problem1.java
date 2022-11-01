package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!(checkCondition(pobi) && checkCondition(crong))) {     // 둘 중 하나라도 참이 아닌 경우
            return -1;
        } else {
            int repPobi = -1;                                     // 포비의 점수
            repPobi = calculateScore(pobi, repPobi);
            int repCrong = -1;
            repCrong = calculateScore(crong, repCrong);           // 크롱의 점수

            if (repPobi > repCrong) {
                return 1;
            } else if (repPobi < repCrong) {
                return 2;
            } else return 0;                                     // 점수가 같은 경우
        }
    }

    /**
     * 숫자 리스트를 입력으로 받아 그 합을 반환
     **/
    private static int sum(List<Integer> nums) {
        return (int) nums.stream().reduce((x, y) -> x + y).stream().toArray()[0];
    }

    /**
     * 숫자 리스트를 입력으로 받아 그 곱을 반환
     **/
    private static int multi(List<Integer> nums) {
        return (int) nums.stream().reduce((x, y) -> x * y).stream().toArray()[0];
    }

    /**
     * 한 쪽 페이지의 숫자의 자릿수를 하나씩 리스트에 집어넣어 리턴
     **/
    private static List<Integer> dividePage(Integer pages) {
        String s = Integer.toString(pages);
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            result.add(Integer.parseInt(s.substring(i, i + 1))); // 자릿수를 하나씩 리스트에 추가
        }
        return result;
    }

    /**
     * 점수 계산
     **/
    private static int calculateScore(List<Integer> user, int rep) {
        for (int i = 0; i < 2; i++) { // 포비
            List<Integer> tmp = dividePage(user.get(i));
            int a = sum(tmp);
            int b = multi(tmp);
            if (a >= b) { // 합한 것이 더 클 경우
                if (rep < a) rep = a;
            } else { // 곱한 것이 더 클경우
                if (rep < b) rep = b;
            }
        }
        return rep;
    }

    /**
     * 입력 페이지값의 무결성 검사
     **/
    private static boolean checkCondition(List<Integer> lst) {
        if (lst.get(0) != lst.get(1) - 1) { // 하나 차이가 아니라면
            return false;
        } else if (lst.get(0) % 2 == 0 || lst.get(1) % 2 == 1) { // 홀짝이 맞지 않으면 (0이나오거나;짝수 || 1이 나온다면;홀수)
            return false;
        } else return true;
    }
}