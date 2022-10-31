package onboarding;

import java.util.List;

class Problem1 {
    public static boolean wrongPageNumber(List<Integer> pobi, List<Integer> crong) {
        // 오른쪽 페이지의 번호는 언제나 왼쪽 페이지의 번호보다 1만큼 크다.
        // 따라서 그런 경우가 아니라면 true를 반환한다.
        if (pobi.get(0) + 1 != pobi.get(1)) return true;
        if (crong.get(0) + 1 != crong.get(1)) return true;

        // 왼쪽 페이지는 홀수고 오른쪽 페이지는 짝수여야 한다.
        // 그런 경우가 아니라면 true를 반환한다.
        if (pobi.get(0) % 2 == 0 || pobi.get(1) % 2 == 1) return true;
        if (crong.get(0) % 2 == 0 || crong.get(1) % 2 == 1) return true;

        return false;
    }

    // 페이지 번호가 string형으로 주어질 때 점수의 최댓값을 int형으로 반환하는 함수.
    public static int getScore(String num) {
       int sum = 0, mul = 1;
        for (int i = 0; i < num.length(); i++) {
            int x = num.charAt(i) - '0';
            sum += x;
            mul *= x;
        }
        return Math.max(sum, mul);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (wrongPageNumber(pobi, crong)) return -1;

        int answer = Integer.MAX_VALUE;

        // pobi와 crong의 각 페이지를 String형으로 변환한다.
        String pobiLeftNum = String.valueOf(pobi.get(0));
        String pobiRightNum = String.valueOf(pobi.get(1));
        String crongLeftNum = String.valueOf(crong.get(0));
        String crongRightNum = String.valueOf(crong.get(1));

        // pobi와 crong의 각 점수들을 계산한다.
        int pobiScore = getScore(pobiLeftNum);
        pobiScore = Math.max(pobiScore, getScore(pobiRightNum));
        int crongScore = getScore(crongLeftNum);
        crongScore = Math.max(crongScore, getScore(crongRightNum));

        // 승부를 판정한다.
        if (pobiScore > crongScore) answer = 1;
        else if (pobiScore < crongScore) answer = 2;
        else answer = 0;

        return answer;
    }
}