package onboarding;

public class Problem3 {
    static int result;

    public static int solution(int number) {
        result = 0;
        return game(number);
    }

    private static int game(int number) {
        for (int i = 1; i <= number; i++) {
            rule(i);
        }
//        System.out.println("result : " + result);

        return result;
    }

    private static void rule(int number){
        int quotient = number / 10; // 몫
        int remainder = number % 10; // 나머지

        if(remainder == 3 || remainder == 6 || remainder == 9){
            result += 1;
        }

        // 한 자리 숫자가 아닐 때 다른 자리에서도 찾기 위해서 재귀 함수 실행
        if(quotient != 0)
            rule(quotient);
    }
}
