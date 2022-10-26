package onboarding;

/*
    요구사항 분석
    제한사항
    number 는 1 ~ 10000 이하인 자연수

    3, 6, 9 라는 숫자가 들어가면 박수를 치게된다
    number까지 값을 증가시키며 3,6,9가 들어갈때마다 answer값을 증가시킨다

    다만, 33과 같은경우 3이 두번들어감으로 2번 손뼉을 쳐야한다
    때문에 값을 %10 해가며 분석해야할 필요가 있다

    프로그램 구현
    Step1. 반복문을 통해 분석해야할 값을 number까지 증가시키며 분석시키는 프로그램 만들기
    Step2. 해당 값에 몇번의 손벽을 쳐야하는지에 대한 분석 메서드 만들기
 */

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        //Step1. 반복문을 통해 분석해야할 값을 number까지 증가시키며 분석시키는 프로그램 만들기
        for (int i = 0; i < number; i++) {
            answer += countClap(i);
        }

        return answer;
    }

}
