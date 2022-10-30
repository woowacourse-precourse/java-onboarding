package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int temp;
        for(int i = 1; i <= number; i++) {
            if (i < 10) {
                if (i == 9 || i == 6 || i == 3)
                    answer++;
            }
            else if (i >= 10 && i < 100) {
                if (i / 10 == 9 || i / 10 == 6 || i / 10 == 3)
                    answer++;
                temp = i % 10;
                if (temp == 9 || temp == 6 || temp == 3)
                    answer++;
            }
            else if (i >= 100 && i < 1000) {
                if (i / 100 == 9 || i / 100 == 6 || i / 100 == 3)
                    answer++;
                temp = i % 100;
                if (temp / 10 == 9 || temp / 10 == 6 || temp / 10 == 3)
                    answer++;
                temp = temp % 10;
                if (temp % 10 == 9 || temp % 10 == 6 || temp % 10 == 3)
                    answer++;
            }
            else {
                if (i / 1000 == 9 || i / 1000 == 6 || i / 1000 == 3)
                    answer++;
                temp = i % 1000;
                if (temp / 100 == 9 || temp / 100 == 6 || temp / 100 == 3)
                    answer++;
                temp = temp % 100;
                if (temp / 10 == 9 || temp / 10 == 6 || temp / 10 == 3)
                    answer++;
                temp = i % 10;
                if (temp == 9 || temp == 6 || temp == 3)
                    answer++;
            }
        }
        return answer;
    }
}
