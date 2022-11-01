package onboarding;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Problem3 {
    public static int solution(int number)
    {
        int answer = 0;

        for(int i = 1; i < number + 1; i++)
        {
            char[] numberArray = String.valueOf(i).toCharArray();
            answer += calNumber(numberArray);
        }

        return answer;
    }

    private static int calNumber(char[] numberArray)
    {
        int count = 0;
        char[] standard = {'3', '6', '9'};

        for(int i = 0; i < numberArray.length; i++)
        {
            for(int k = 0; k < standard.length; k++)
            {
                if(numberArray[i] == standard[k])
                    count++;
            }
        }

        return count;
    }

    private static boolean checkNum(int number)
    {
        String str = Integer.toString(number);
        if(!str.matches("[1-9]\\d{1000}")){
            System.out.println("wrong");
            return false;
        }
//        if(number < 1 || number > 10000)
//            return false;

        return true;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input number");
        System.out.println("answer is " + solution(scanner.nextInt()));
    }
}
