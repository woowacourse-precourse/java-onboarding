package onboarding;

import java.util.Scanner;

public class Problem3 {
    public static int solution(int number) {
        int hap = 0;
        for (int i = 1; i <= number; i++) {
            hap +=clap(i);
        }
        return hap;
    }
    public static int clap(int num) {
        int sum =0;
        while( num != 0){
            int n =  num % 10;
            if (n>=3 && n % 3 == 0) {
                sum += 1;
            }
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        System.out.println(solution(num));

    }
}
