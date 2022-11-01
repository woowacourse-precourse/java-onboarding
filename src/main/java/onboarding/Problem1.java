package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pLeft = pobi.get(0);
        int pRight = pobi.get(1);
        int cLeft = crong.get(0);
        int cRight = crong.get(1);

        if(pLeft == 1 || cLeft == 1) return -1;
        if(pRight == 400 || cRight == 400) return -1;
        if(pLeft %2 != 1 || cLeft %2 != 1) return -1;
        if(pRight %2 != 0 || cRight %2 != 0) return -1;
        if((pLeft <= 0 || pLeft >= 400 ) || (pRight <= 0 || pRight >= 400)) return -1;
        if((cLeft <= 0 || cLeft >= 400) || (pRight <= 0 || pRight >= 400)) return -1;
        if(pRight - pLeft != 1) return -1;
        if(cRight - cLeft != 1) return -1;

        int pMax = Integer.max(compare(multiPage(pLeft), addPage(pLeft)), compare(multiPage(pRight), addPage(pRight)));
        int cMax = Integer.max(compare(multiPage(cLeft), addPage(cLeft)), compare(multiPage(cRight), addPage(cRight)));

        if(pMax > cMax) answer = 1;
        if(cMax > pMax) answer = 2;
        if(pMax == cMax) answer = 0;

        return answer;
    }

    public static int multiPage(int num) {
        int multiply = 1;

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