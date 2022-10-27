package onboarding;

import java.util.List;


class Problem1 {
    /**
     * pobi와 crong을 Verification 클래스에서 조건을 검사한다.
     * try/catch문으로 감싸 IllegalArgumentException을 받으면 -1을 리턴
     */
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;

        try {
            Vericication verifyPobi = new Vericication(pobi);
            Vericication verifyCrong = new Vericication(crong);



        } catch (IllegalArgumentException e) {
            answer = -1;
        }

        return answer;
    }
}

class Vericication {
    private static final int LEFT_PAGE = 0;
    private static final int RIGHT_PAGE = 1;
    /**
     *Verification클래스는 다음과 같은 조건들을 검사하는 메서드를 가질 것이다.
     * 1. pobi와 crong의 길이가 각각 2인지.
     * 2. 왼쪽페이지는 홀수, 오른쪽페이지는 짝수인지.
     * 3. 왼쪽페이지와 오른쪽페이지가 순서대로 주어져있는지 ex) pobi.get(0) + 1 == pobi.get(1)
     * 위 조건들 중 하나라도 만족하지 않을 시 IllegalArgumentException을 던져줄것이다.
     */

    public Vericication(List<Integer> book) throws IllegalArgumentException {

    }
}