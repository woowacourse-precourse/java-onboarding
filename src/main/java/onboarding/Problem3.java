package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        //  For-Loop : 1부터 입력된 숫자까지 차례대로 확인하는 반복문
        for (int i = 1; i <= number; i++) {
            answer += checkNumber(i, 0);
        }
        return answer;
    }

    //  입력된 숫자에 박수를 몇번 치는지 계산하는 메소드
    private static int checkNumber(int number, int countClap){
        //  Edge-Case
        if(number == 0) return countClap;

        //  Base-Case
        if(countDigit(number) == 0) return countClap + checkClap(number);

        //  Recursive-Case
        int targetNum = number / tenPowDigit(number);

        countClap += checkClap(targetNum);
        number %= tenPowDigit(number);

        return checkNumber(number, countClap);
    }

    //  입력된 한자리 숫자가 3,6,9에 해당하는 확인하는 메소드
    private static int checkClap(int number){
        if(number % 3 == 0) return 1;
        return 0;
    }

    //  입력된 자리수의 10의 거듭제곱을 구하는 메소드
    private static int tenPowDigit(int number){
        return (int) Math.pow(10, countDigit(number));
    }

    //  입력된 숫자의 자리수를 계산하는 메소드
    private static int countDigit(int number){
        return (int) Math.log10(number);
    }
}
