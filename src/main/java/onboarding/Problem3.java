package onboarding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem3 {

    public static int solution(int number) {

        int answer = 0;

        for(int i = 1; i < 10000; i++) {

            int num4, num3, num2, num1; // 자릿수

            num1 = i % 10;
            num2 = i / 10 % 10;
            num3 = i / 100 % 10;
            num4 = i / 1000 % 10;

            if (num1 == 3 || num1 == 6 || num1 == 9) {
                answer++;
            } if (num2 == 3 || num2 == 6 || num2 == 9) {
                answer++;
            } if (num3 == 3 || num3 == 6 || num3 == 9) {
                answer++;
            } if (num4 == 3 || num4 == 6 || num4 == 9) {
                answer++;
            }

            if (i == number) {
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(solution(N));

    }
}
