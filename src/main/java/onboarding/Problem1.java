package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {
    public static List<Integer> convertDigitNum(int num) {
        List<Integer> digitNums = new ArrayList<>();
        while(num > 0) {
            digitNums.add(num % 10);
            num /= 10;
        }
        Collections.reverse(digitNums);

        return digitNums;
    }

    public static int sumNumber(List<Integer> digitNumbers) {
        return digitNumbers.stream().mapToInt(Integer::intValue).sum();
    }

    public static int mulNumber(List<Integer> digitNumbers) {
        int mulVal = 1; // 왼쪽 페이지 각자리수 곱
        for(int element : digitNumbers) {
            mulVal *= element;
        }

        return mulVal;
    }

    public static List<Integer> getOpMax(List<Integer> player) {
        List<Integer> playerMax = new ArrayList<>();

        for(int i = 0; i < 2; i++) {
            int page = player.get(i);
            List<Integer> digitNum = convertDigitNum(page);
            int sum = sumNumber(digitNum);
            int mul = mulNumber(digitNum);

            int opMax = 0;
            if(sum >= mul) {
                opMax = sum;
            } else {
                opMax = mul;
            }
            playerMax.add(opMax);
        }

        return playerMax;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = Integer.MAX_VALUE;

        if(Math.abs(pobi.get(0) - pobi.get(1)) > 1) {
            return -1;
        } else if(Math.abs(crong.get(0) - crong.get(1)) > 1) {
            return -1;
        }

        if(pobi.get(0) >= pobi.get(1) || crong.get(0) >= crong.get(1)) {
            return -1;
        }

        List<Integer> pobiMax = getOpMax(pobi);
        List<Integer> crongMax = getOpMax(crong);

        int pobiMaxVal = Collections.max(pobiMax);
        int crongMaxVal = Collections.max(crongMax);

        if(pobiMaxVal > crongMaxVal) {
            answer = 1;
        } else if(pobiMaxVal < crongMaxVal) {
            answer = 2;
        } else if(pobiMaxVal == crongMaxVal) {
            answer = 0;
        }

        return answer;
    }
}