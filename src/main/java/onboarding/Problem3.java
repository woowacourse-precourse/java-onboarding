package onboarding;

import java.util.Scanner;

public class Problem3 {
    Scanner scan = new Scanner(System.in);
    int number;
    int temp=0;
    void run()
    {
        do{
            number = scan.nextInt();
        }while(number<1 || number>10000);

        int result=solution(number);
        System.out.println(result);
    }

    public static int solution(int number) {
        int answer = 0;
        int temp;
        String num;
        int length;

        for (int i = 1; i <= number; i++) {
            num = Integer.toString(i);
            length=num.length();

            while (length > 0)
            {
                if(length == 1) {
                    temp = i % 10;
                    if (temp == 3 || temp == 6 || temp == 9) {
                        answer++;
                    }
                    length--;
                } else {
                    temp = (int) (i / (Math.pow(10, length - 1)));
                    if (temp == 3 || temp == 6 || temp == 9) {
                        answer++;
                    }
                    length--;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args)
    {
        Problem3 player = new Problem3();
        player.run();
    }
}
