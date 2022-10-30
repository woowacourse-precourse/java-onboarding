package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += check(i);
        }
        return answer;
    }

    static int check(int number) {
        char[] numArr = String.valueOf(number).toCharArray();
        int count = 0;
        for (char ch : numArr) {
            switch (ch) {
                case '3':
                    count++;
                    break;
                case '6':
                    count++;
                    break;
                case '9':
                    count++;
                    break;
            }
        }
        return count;
    }

}
