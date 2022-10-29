package onboarding;

import java.util.Scanner;

public class Problem3 {
    public static int solution(int number) {



        int count = 0;



        for(int i = 1; i <= number; i++) {

            int current = i;
            int temp = count;
            while (current != 0) {
                if(current % 10 == 3 || current % 10 == 6 || current % 10 == 9) {

                    count++;



                }

                current /= 10;

            }

        }
        return count;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        System.out.println(solution(number));
    }
}
