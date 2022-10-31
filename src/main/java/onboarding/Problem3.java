package onboarding;

public class Problem3 {


    /**
     * @param number : 0-9 사이 문자 숫자
     * @return boolean : 박수를 쳐야 하는지
     */
    public static boolean isClapNumber(char number) {
        if (number == '3' || number == '6' || number == '9')
            return true;
        return false;
    }

    /**
     * @param number : 자연수
     * @return int : number 까지 박수치는 횟수
     */
    public static int getClapsByNumber(int number) {
        String str = Integer.toString(number);
        int strSize = str.length();
        int claps = 0;
        for (int i = 0; i < strSize; i++) {
            if (str.charAt(i) == '3' || str.charAt(i) == '6' || str.charAt(i) == '9') {
                claps++;
            }
        }
        return claps;
    }

    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += getClapsByNumber(i);
        }
        return answer;
    }
}
