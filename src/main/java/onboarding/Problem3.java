package onboarding;
import java.util.Scanner;
public class Problem3 {
    public static int solution(int number) {
        int[] num = new int[number];
        for (int i=0; i<number; i++) {
            num[i] = i+1;
        }
        int tmp = 0;
        int answer = 0;

        for(int i=0; i<number; i++) {
            int length = Integer.toString(i).length();
            while (length > 0) {
                if (length == 1) {
                    if (num[i] == 3 || num[i] == 6 || num[i] == 9) {
                        answer += 1;
                    }
                    length--;
                } else {
                    tmp = (int) (num[i] / (Math.pow(10, length-1)));
                    if (tmp == 3 || tmp == 6 || tmp == 9) {
                        answer += 1;
                    }
                    num[i] = (int) (num[i] - (tmp * (Math.pow(10, length-1))));
                    length--;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        System.out.println(solution(number));
    }
}
