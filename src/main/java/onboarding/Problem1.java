package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong)
    {
        if(!checkNum(pobi))
            return -1;

        if(!checkNum(crong))
            return -1;

        //calculate pobi max_value
        int pobi_sum = compare(sum(pobi.get(0)), sum(pobi.get(1)));
        int pobi_mul = compare(mul(pobi.get(0)), mul(pobi.get(1)));

        int pobi_result = compare(pobi_sum, pobi_mul);

        //calculate crong max_value
        int crong_sum = compare(sum(crong.get(0)), sum(crong.get(1)));
        int crong_mul = compare(mul(crong.get(0)), mul(crong.get(1)));

        int crong_result = compare(crong_sum, crong_mul);

        //calculate max_value (pobi vs crong)
        return getAnswer(pobi_result, crong_result);
    }

    private static boolean checkNum(List<Integer> list)
    {
        if(list.size() != 2)
            return false;

        for(int i=0; i<list.size(); i++)
        {
            if(list.get(i) < 1 || list.get(i) > 400)
                return false;
        }

        if(list.get(1) - list.get(0) != 1)
            return false;

        return true;
    }

    private static int sum(int num)
    {
        int result = 0;

        while(0 < num)
        {
            result += num % 10;
            num /= 10;
        }

        return result;
    }

    private static int mul(int num)
    {
        int result = 1;

        while(0 < num)
        {
            result *= num % 10;
            num /= 10;
        }

        return result;
    }

    private static int compare(int num1, int num2)
    {
        if(num1 > num2)
        {
            return num1;
        }
        else if(num1 < num2)
        {
            return num2;
        }
        else if(num1 == num2)
        {
            return num1;
        }

        return -1;
    }

    private static int getAnswer(int pobi_num, int crong_num)
    {
        if(pobi_num > crong_num)
        {
            return 1;
        }
        else if(pobi_num < crong_num)
        {
            return 2;
        }
        else if(pobi_num == crong_num)
        {
            return 0;
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> pobi = new ArrayList<>();
        System.out.println("pobi의 왼쪽 페이지 번호를 입력하십시오.");
        pobi.add(scanner.nextInt());
        System.out.println("pobi의 오른쪽 페이지 번호를 입력하십시오.");
        pobi.add(scanner.nextInt());

        List<Integer> crong = new ArrayList<>();
        System.out.println("crong의 왼쪽 페이지 번호를 입력하십시오.");
        crong.add(scanner.nextInt());
        System.out.println("crong의 오른쪽 페이지 번호를 입력하십시오.");
        crong.add(scanner.nextInt());

        int answer = solution(pobi, crong);
        System.out.println("answer is " + answer);
    }
}