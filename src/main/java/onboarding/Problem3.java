package onboarding;

public class Problem3 {
    public static int threesixnine(int num) {
        int answer = 0;
        int length = Integer.toString(num).length(); // 자리수
        int temp;

        while (length > 0) {
            if (length == 1) // 일의 자리수
            {
                temp = num % 10;
                if (temp == 3 || temp == 6 || temp == 9) {
                    answer += 1;
                }
                length--;
            }
            else
            {
                temp = (int) (num / (Math.pow(10, length-1)));
                if (temp == 3 || temp == 6 || temp == 9) {
                    answer += 1;
                }
                num = (int) (num - (temp * (Math.pow(10, length-1))));
                length--;
            }
        }
        return answer;
    }
    public static int solution(int number) {
        int answer = 0;

        for (int i=0;i<=number;i++) {
            answer += threesixnine(i);
        }

        return answer;
    }
}
