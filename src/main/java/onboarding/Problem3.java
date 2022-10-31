package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (Integer i = 1; i < number + 1; i++) {
            String stringNum = i.toString();
            answer += countClap(stringNum);
        }
        return answer;
    }

    //숫자로부터 쳐야될 박수 구하기
  private static int countClap(String number) {
        int count = 0;
        for (int i = 0; i < number.length(); i++) {
            if (isClap(number.charAt(i))) {
                count += 1;
            }
        }
        return count;
    }

    private static boolean isClap(char c) {
        return c == '3' | c == '6' | c == '9';
    }
}
