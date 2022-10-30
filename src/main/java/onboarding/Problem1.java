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

    public static int multiply(String individualNums) {
        int sum = 1;
        for (int i = 0; i < individualNums.length(); i++) {
            sum *= (individualNums.charAt(i) - '0');
        }
        System.out.println(sum);
        return sum;
    }

    public static int getHighestScore(List<Integer> arr) {
        int max = 0;
        int tmpAdd;
        int tmpMult;
        int tmp;
        for(Integer score : arr) {
            System.out.println(score);
            String seperatedNum = integerToString(score);
            tmpAdd = add(seperatedNum);
            tmpMult = multiply(seperatedNum);
            tmp = (tmpAdd > tmpMult) ? tmpAdd : tmpMult;
            if(tmp > max) {
                max = tmp;
            }
        }
        return max;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong){
        int pobiScore = getHighestScore(pobi);
        int crongScore = getHighestScore(crong);
        System.out.println(pobiScore);
        System.out.println(crongScore);
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static void main(String[] args) {
        solution(List.of(97, 98), List.of(197, 198));
    }
}