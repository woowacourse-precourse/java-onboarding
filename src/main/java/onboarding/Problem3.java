package onboarding;

import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(solution(N));
    }
    public static int solution(int number) {
        int answer = 0;
        for(int i = 2; i <= number; i++) {
        String str = Integer.toString(i);
        for(int j = 0; j < str.length(); j++){
            if (str.charAt(j) == '3' || str.charAt(j) == '6' || str.charAt(j) == '9') {
                answer++;
            }
            else{
                continue;
            }
                }
            }
        return answer;
    }
}
