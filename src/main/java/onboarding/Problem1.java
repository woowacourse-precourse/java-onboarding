package onboarding;

import java.util.List;

// <기능 목록>
// 1. 예외상황인지 각각 판별 (해당되면 return -1)
//  예외상황
//  a. 왼쪽페이지!=홀수
//  b. 오른쪽페이지!=짝수
//  c. 오른쪽페이지-왼쪽페이지!=1
//  d. 페이지<1 (위의 조건때문에 해당될 수 없음)
//  e. 페이지>400 (위의 조건때문에 left>400에만 해당돼도 예외)
// 2. 각각의 max num 구함 (각자의 점수)
// 3. 점수 비교 (승자 판별)

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
        pobiNum = Math.max(findMaxNum(pobi.get(0)), findMaxNum(pobi.get(1)));
        crongNum = Math.max(findMaxNum(crong.get(0)), findMaxNum(crong.get(1)));

        // 3. 점수 비교 (승자 판별)
        answer = whoWin(pobiNum, crongNum);

        return answer;
    }

    // 1. 예외상황 판별
    public static boolean isExcption(int left, int right) {
        // 1-a. 왼쪽페이지!=홀수
        if (left % 2 != 1) {
            return true;
        }
        // 1-b. 오른쪽페이지!=짝수
        else if (right % 2 != 0) {
            return true;
        }
        // 1-c. 오른쪽페이지-왼쪽페이지!=1
        else if (right - left != 1) {
            return true;
        }
        // 1-d. 페이지<1 (위의 조건때문에 해당될 수 없음)
        // 1-e. 페이지>400 (위의 조건때문에 left>400에만 해당돼도 예외)
        else if (left > 400) {
            return true;
        } else {
            return false;
        }
    }

    // 2. max num 구함 (각자의 점수)
    public static int findMaxNum(int num) {
        int max = 0;

        // 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
        int sum = 0;
        int multi = 1;
        String strNum = Integer.toString(num);
        for (int i = 0; i < strNum.length(); i++) {
            sum += (strNum.charAt(i) - '0');
            multi *= (strNum.charAt(i) - '0');
        }
        max = Math.max(sum, multi);

        return max;
    }

    // 3. 점수 비교 (승자 판별)
    public static int whoWin(int pobi, int crong) {
        if (pobi > crong) {
            // 포비 승
            return 1;
        } else if (pobi < crong) {
            // 크롱 승
            return 2;
        } else {
            // 무승부
            return 0;
        }
    }
}

