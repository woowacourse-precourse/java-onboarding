package onboarding;

/*
* 요구사항
* 1부터 주어지는 숫자까지 모든 숫자에 대해 손뼉을 몇 번 쳐야 하는지 횟수
* 손뼉은 각 숫자의 각 자리에 3/6/9가 나온 모든 경우에 쳐야 한다.
* */
public class Problem3 {
    /*
    * 역할: 기능2(1부터 주어진 숫자까지 기능#1을 반복하여 손뼉 횟수의 총합 계산)
    * 입력: int(1부터 입력된 숫자까지 손뼉친 횟수를 계산해야 한다.)
    * 결과: int (1부터 입력 숫자까지 3/6/9가 들어간 횟수)
    * */
    public static int solution(int number) {
        int allClapCount = 0;
        // 1부터 입력 숫자까지 메소드#1을 실행
        for(int i = 1; i <= number; ++i)
            allClapCount += countClapByNumber(i);
        return allClapCount;
    }

    /*
    * 역할: 기능1(어느 숫자를 주면 그 숫자에 3/6/9가 몇 번 들어있는지 셈)
    * 입력: int (3/6/9 손뼉 횟수를 확인해야 하는 숫자)
    * 결과: int(입력 숫자에 3/6/9가 들어간 횟수)
    * */
    static int countClapByNumber(int num) {
        int count = 0;
        int digit;
        // 동작: 입력된 숫자를 각 자리로 나누어서 일의 자리부터 3/6/9가 몇 번 들어있는지 센다.
        while(num != 0) {
            digit = num % 10;
            System.out.println(digit);
            if(digit == 3 || digit == 6 || digit == 9) {
                ++count;
            }
            num /= 10;
        }
        return count;
    }

}
