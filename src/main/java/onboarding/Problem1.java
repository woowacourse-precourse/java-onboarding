package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiCount = 0;
        int crongCount = 0;
        int tieCount = 0;   // 무승부 카운트

        for (int i = 0; i < 2; i++) {
            if (maxNum(String.valueOf(pobi.get(i))) > maxNum(String.valueOf(crong.get(i)))) {
                pobiCount++;
            } else if (maxNum(String.valueOf(pobi.get(i))) < maxNum(String.valueOf(crong.get(i)))) {
                crongCount++;
            } else if (maxNum(String.valueOf(pobi.get(i))) == maxNum(String.valueOf(crong.get(i)))) {
                tieCount++;
            }
        }

        if(pobiCount == 2) answer = 1;
        else if (crongCount == 2) answer = 2;
        else if (tieCount == 2) answer = 0;   // 무승부
        else answer = -1;

        return answer;
    }
    // 가장 큰 수 반환 메서드
    public static int maxNum(String numStr) {
        int sumAdd = 0;
        int sumProduct = 1;

        for (String num : numStr.split("")) {
            sumAdd += Integer.parseInt(num);
        }

        for (String num : numStr.split("")) {
            sumProduct *= Integer.parseInt(num);
        }
        return Math.max(sumAdd, sumProduct);
    }
}
