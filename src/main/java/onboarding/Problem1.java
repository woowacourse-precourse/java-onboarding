package onboarding;

import java.util.List;

// <기능 목록>
// 1. 예외상황인지 각각 판별 (해당되면 return -1)
// 결과 예외상황: 왼쪽페이지!=홀수, 오른쪽페이지!=짝수, 오른쪽페이지-왼쪽페이지!=1, 페이지<1 or 페이지>400
// 2. 각각의 max num 구함 (각자의 점수)
// 3. 점수 비교

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // 1. 예외상황인지 각각 판별
        if (isExcption(pobi.get(0), pobi.get(1))) {
            return -1;
        }
        if (isExcption(crong.get(0), crong.get(1))) {
            return -1;
        }

        // 2. 각각의 max num 구함 (각자의 점수)
        int pobiNum = 0;
        int crongNum = 0;
        pobiNum = findMaxNum(pobi.get(0), pobi.get(1));
        crongNum = findMaxNum(crong.get(0), crong.get(1));

        // 3. 점수 비교
        if (pobiNum > crongNum) {
            // 포비 승
            answer = 1;
        } else if (pobiNum < crongNum) {
            // 크롱 승
            answer = 2;
        } else {
            // 무승부
            answer = 0;
        }
        return answer;
    }

    // 예외상황 판별
    public static boolean isExcption(int left, int right) {
        if (left % 2 != 1) {
            return true;
        }
        if (right % 2 != 0) {
            return true;
        }
        if (right - left != 1) {
            return true;
        }
        return false;
    }

    // max num 구함
    public static int findMaxNum(int left, int right) {
        int maxL = 0;   //left max
        int maxR = 0;   //right max

        // 왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
        int sumL = 0;
        int multiL = 1;
        String strL = Integer.toString(left);
        for (int i = 0; i < strL.length(); i++) {
            sumL += (strL.charAt(i) - '0');
            multiL *= (strL.charAt(i) - '0');
        }
        maxL = Math.max(sumL, multiL);

        // 오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다
        int sumR = 0;
        int multiR = 1;
        String strR = Integer.toString(right);
        for (int i = 0; i < strR.length(); i++) {
            sumR += (strR.charAt(i) - '0');
            multiR *= (strR.charAt(i) - '0');
        }
        maxR = Math.max(sumR, multiR);

        return Math.max(maxL, maxR);
    }
}

