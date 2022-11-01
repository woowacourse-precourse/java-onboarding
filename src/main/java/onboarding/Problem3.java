package onboarding;

public class Problem3 {

    public static int solution(int number) {

        int answer = 0;

        for (int i = 1; i <= number; i++) {
            answer += calculateClap(i);
        }
        return answer;
    }

    /**
     * 현재 숫자의 박수치는지 여부와 박수횟수를 계산하는 메서드
     *
     * @param currentNumber 현재 숫자
     * @return 쳐야하는 박수 횟수
     */
    public static int calculateClap(int currentNumber) {

        int clap = 0;
        String str = String.valueOf(currentNumber);

        if (!str.contains("3") && !str.contains("6") && !str.contains("9")) {
            return clap;
        } else {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '3' || str.charAt(i) == '6' || str.charAt(i) == '9') {
                    clap++;
                }
            }
        }
        return clap;
    }
}
