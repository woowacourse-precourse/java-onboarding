package onboarding;

public class Problem3 {
    /* 숫자 3/6/9이 몇 개 포함되어 있는지 세는 메서드 */
    public static int countNum(String number) {
        int count = 0;
        for(int i = 0; i < number.length(); i++) {
            if(number.charAt(i) == '3' || number.charAt(i) == '6' || number.charAt(i) == '9') {
                count++;
            }
        }
        return count;
    }

    public static int solution(int number) {
        int answer = 0;
        for(int i = 1; i < number + 1; i++) {
            String strNumber = Integer.toString(i);
            if(strNumber.contains("3") || strNumber.contains("6") || strNumber.contains("9")) {
                answer += countNum(strNumber);
            }
        }
        return answer;
    }
}