package onboarding;

public class Problem3 {
    static boolean isCheck(int number) {
        return number<1 || number>10000;
    }

    public static int solution(int number) {
        int answer = 0;

        if (isCheck(number)) {
            System.out.print("number가 잘못되었습니다.");
        } else {
            for (int i = 1; i <= number; i++) {
                String str = String.valueOf(i);
                for (int j = 0; j < str.length(); j++) {
                    char c = str.charAt(j);
                    if (c == '3' || c == '6' || c == '9')
                        answer++;
                }
            }
        }
        return answer;
    }
}