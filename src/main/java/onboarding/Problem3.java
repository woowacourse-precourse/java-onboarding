package onboarding;

public class Problem3 {

    /**
     *
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
        return answer;
    }
}
