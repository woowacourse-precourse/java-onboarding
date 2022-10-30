package onboarding;

import java.util.List;

class Problem1 {
    /* 숫자를 문자열로 변환하는 메서드 */
    public static String integerToString(int num) {
        return Integer.toString(num);
    }

    /* 10의 자리수 이상의 숫자를 나눠 배열로 만드는 메서드 */
    public static int[] seperateInteger(int num) {
        int[] result = new int[3];
        if (num < 10) {
            result[0] = num;
            return result;
        }
        String stringNum = integerToString(num);
        for (int i = 0; i < stringNum.length(); i++) {
            int tmp = stringNum.charAt(i) - '0';
            result[i] = tmp;
        }
        return result;
    }

    public static int add(int score) {
        int[] individualNums = seperateInteger(score);
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += individualNums[i];
        }
        return sum;
    }

    public static int getHighestScore(List<Integer> arr) {
        int max = 0;
        int tmp;
        for(Integer score : arr) {
            System.out.println(score);
            tmp = add(score);
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