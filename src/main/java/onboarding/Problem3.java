package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    /**
     * 369 게임에서 1 부터 주어진 숫자까지 손뼉을 몇 번 쳐아하는지 횟수를 계산하는 메소드
     * @param number : 369 게임의 마지막 숫자
     * @return : 마지막 숫자까지 손뼉을 친 횟수
     */
    private static int getClapCount(int number){
        //손뼉을 친 횟수 초기화
        int clapCount = 0;

        //1의 자리 3,6,9에 의해 손뼉을 친 횟수를 더함
        clapCount += digitBaseCount(number, 1);
        //10의 자리 3,6,9에 의해 손뼉을 친 횟수를 더함
        if(number >= 10){
            clapCount += digitBaseCount(number, 10);
        }
        //100의 자리 3,6,9에 의해 손뼉을 친 횟수를 더함
        if(number >= 100){
            clapCount += digitBaseCount(number, 100);
        }
        //1000의 자리 3,6,9에 의해 손뼉을 친 횟수를 더함
        if(number >= 1000){
            clapCount += digitBaseCount(number, 1000);
        }

        return clapCount;
    }

    /**
     * n의 자리숫자에 의해 손뼉을 친 횟수를 반환하는 함수
     * @param number : 손뼉을 친 횟수를 계산할 숫자
     * @param digitBase : 손뼉을 친 횟수를 계산할 자리
     * @return : n의 자리 숫자에서 손뼉을 친 횟수
     */
    private static int digitBaseCount(int number, int digitBase){

    }

}
