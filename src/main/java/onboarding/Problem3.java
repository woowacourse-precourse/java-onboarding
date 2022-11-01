package onboarding;

// int -> String 으로 변경
// 3, 6, 9 가 있는지 find

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        String num;
        for (int i = 0; i < number; i++) {
            num = Integer.toString(i + 1);
            answer += countGameNumber(num);
        }
        return answer;
    }

    private static int countGameNumber(String num) {
        int size = num.length();
        int count = 0;

        for (int i = 0; i < size; i++) {
            if (num.charAt(i) == '3' || num.charAt(i) == '6' || num.charAt(i) == '9')
                count++;
        }
        return count;
    }
}