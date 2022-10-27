package onboarding;
import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = Integer.MAX_VALUE;

        int p1 = pobi.get(0);
        int p2 = pobi.get(1);

        int c1 = crong.get(0);
        int c2 = crong.get(1);

        if (p1 == 0 && p2 == 400 && c1 == 0 && c2 == 400) {
            System.out.println("책을 다시 펼치세요");
        }

        if((p1 + 1 != p2) || (c1 + 1 != c2)) {
            return -1;
        }


        int pobiNum1 = sum(p1) > multiply(p1) ? sum(p1) : multiply(p1);
        int pobiNum2 = sum(p2) > multiply(p2) ? sum(p2) : multiply(p2);

        int pNum = pobiNum1 > pobiNum2 ? pobiNum1 : pobiNum2;

        int crongNum1 = sum(c1) > multiply(c1) ? sum(c1) : multiply(c1);
        int crongNum2 = sum(c2) > multiply(c2) ? sum(c2) : multiply(c2);

        int cNum = crongNum1 > crongNum2 ? crongNum1 : crongNum2;

        if(pNum > cNum) {
            return 1;
        }else if(pNum < cNum) {
            return 2;
        }else if(pNum == cNum) {
            return 0;
        }


        return answer;



    }

    //각 자릿수 덧셈
    public static int sum(int n) {
        int result = 0;

        while(n > 0) {
            result += n%10;
            n /= 10;
        }

        return result;
    }

    //각 자릿수 곱셈
    public static int multiply(int n) {
        int result = 1;

        while(n > 0) {
            result *= n % 10;
            n /= 10;
        }


        return result;
    }


}