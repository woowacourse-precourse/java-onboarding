package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            answer += countClap(i);
        }

        return answer;
    }

    // 정규표현식을 이용한 숫자(3, 6, 9) 세기
    private static int countClap(int number) {
        String str = String.valueOf(number);

        // 3, 6, 9를 제외한 숫자를 모두 제거
        int count =  str.replaceAll("[^3|6|9]", "").length();

        return count;
    }
}