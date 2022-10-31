package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
//
        int pLeft = pobi.get(0);
        int pRight = pobi.get(1);

        int cLeft = crong.get(0);
        int cRight = crong.get(1);

        if(pLeft %2 != 1 || cLeft %2 != 1) answer = -1;


        int pMax = Math.max(compare(multiPage(pLeft), addPage(pLeft)), compare(multiPage(pRight), addPage(pRight)));
        int cMax = Math.max(compare(multiPage(cLeft), addPage(cLeft)), compare(multiPage(cRight), addPage(cRight)));

        if(pMax > cMax) answer = 1;
        else if(cMax > pMax) answer = 2;
        else answer = 0;



        return answer;
    }

    public static int multiPage(int num) {
        int multiply = 0;

        while(num != 0) {
            multiply *= num%10;
            num /= 10;
        }
        return multiply;
    }

    public static int addPage(int num) {
        int sum = 0;

        while(num != 0) {
            sum += num%10;
            num /= 10;
        }
        return sum;
    }

    public static int compare(int num1, int num2) {
        return (num1 >= num2) ? num1 : num2;
    }
}