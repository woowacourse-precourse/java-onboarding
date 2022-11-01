package onboarding;

import java.util.Scanner;

public class Problem3 {
    public static int solution() { //ex)33
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt(); //33
        int answer = 0;
        int temp = 0;

        for (int i = number; i > 0; i--) {
            String numStr = Integer.toString(i);
            int numLen = numStr.length();

            while (numLen > 0) {
                if (numLen == 1) { //한 자리 숫자
                    temp = i % 10;
                    if (temp == 3 || temp == 6 || temp == 9) {
                        answer++;
                    }
                }
                else { //두 자리 이상
                    temp = (int) (i / Math.pow(10, numLen - 1)); //10^2
                    if (temp == 3 || temp == 6 || temp == 9)
                        answer++;
                    i = (int) (i - (temp * (Math.pow(10, numLen - 1))));
                } //10 - 1*10
                numLen--;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem3 p3 = new Problem3();
        System.out.println(p3.solution());
    }
}
