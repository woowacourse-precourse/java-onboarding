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
    public static int compareInt(int pobi, int crong) {
        return pobi - crong;
    }

    /*  */
    public static int getHighestScore(List<Integer> arr) {
        int comparison;
        int bigger = 0;
        int tmpAdd;
        int tmpMult;
        for(Integer score : arr) {
            String seperatedNum = integerToString(score);
            tmpAdd = add(seperatedNum);
            tmpMult = multiply(seperatedNum);
            comparison = compareInt(tmpAdd, tmpMult);
            bigger = (comparison > 0) ? tmpAdd : tmpMult;
        }
        return bigger;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong){
        int pobiScore = getHighestScore(pobi);
        int crongScore = getHighestScore(crong);
        int comparison = compareInt(pobiScore, crongScore);
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static void main(String[] args) {
        solution(List.of(97, 98), List.of(197, 198));
    }
}