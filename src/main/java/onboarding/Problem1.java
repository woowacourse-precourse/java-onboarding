package onboarding;

import java.util.List;

class Problem1 {
    /* 숫자를 문자열로 변환하는 메서드 */
    public static String integerToString(int num) {
        return Integer.toString(num);
    }

    /* 페이지 각 자리수 더하기 메서드 */
    public static int add(String individualNums) {
        int sum = 0;
        for (int i = 0; i < individualNums.length(); i++) {
            sum += (individualNums.charAt(i) - '0');
        }
        return sum;
    }

    /* 각 자리수 곱하기 메서드 */
    public static int multiply(String individualNums) {
        int result = 1;
        for (int i = 0; i < individualNums.length(); i++) {
            result *= (individualNums.charAt(i) - '0');
        }
        return result;
    }

    /* 두 수 비교 메서드 */
    public static int compareInt(int firstNum, int secondNum) {
        return firstNum - secondNum;
    }

    /* 예외 처리 */
    public static boolean handleException(List<Integer> arr) {
        int firstPage = arr.get(0);
        int secondPage = arr.get(1);
        /* 왼쪽 홀수, 오른쪽 짝수가 아닌 경우 */
        if(firstPage % 2 != 1 || secondPage % 2 != 0) {
            return true;
        }

        /* 연속된 페이지가 아닌 경우 */
        if(firstPage + 1 != secondPage) {
            return true;
        }

        /* 1 부터 400 사이의 수가 아닌 경우 */
        if(firstPage < 1 || firstPage > 400 || secondPage < 1 || secondPage > 400) {
            return true;
        }

        return false;
    }

    /* 왼쪽, 오른쪽 페이지 중 더 큰 페이지 반환하는 메서드 */
    public static int getHighestScore(List<Integer> arr) {
        /* 예외 검사 */
        if(handleException(arr)) {
            return -1;
        }

        /* 두 페이지 중 큰 값 비교 */
        int bigger = 0;
        int tmpAdd;
        int tmpMult;
        for(Integer score : arr) {
            String seperatedNum = integerToString(score);
            tmpAdd = add(seperatedNum);
            tmpMult = multiply(seperatedNum);
            int tmpBigger = (compareInt(tmpAdd, tmpMult) > 0) ? tmpAdd : tmpMult;
            if(tmpBigger > bigger) {
                bigger  = tmpBigger;
            }
        }
        return bigger;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiScore = getHighestScore(pobi);
        int crongScore = getHighestScore(crong);
        if(pobiScore == -1 || crongScore == -1) {
            answer = -1;
            return answer;
        }
        int comparison = compareInt(pobiScore, crongScore);
        if(comparison > 0) {
            answer = 1;
        } else if(comparison < 0) {
            answer = 2;
        } else {
            answer = 0;
        }
        return answer;
    }
}