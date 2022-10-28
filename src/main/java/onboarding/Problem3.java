package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = getClapCount(number);
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
     * @param digitBase : 손뼉을 친 횟수를 계산할 n의 자리
     * @return : n의 자리 숫자에서 손뼉을 친 횟수
     */
    private static int digitBaseCount(int number, int digitBase){
        // digitBase 보다 높은 자리에서 박수를 친 횟수
        // n의 자리의 3,6,9에 의해 digitBase 이상의 값 * 3 만큼 박수를 침
        int clapOverDigitBaseCount = number / (digitBase*10) * digitBase * 3;

        // digitBase 이하의 자리에서 박수를 친 횟수
        int clapBelowDigitBaseCount = 0;
        // 3,6,9가 아닐 때 digitBase 의 크기에 따라 값이 정해짐
        // digitBase 자리의 값
        int digitBaseValue = number / digitBase % 10;
        // digitBase 이하의 3,6,9에서 발생한 횟수를 더함
        int below369Count = digitBaseValue/3;
        if(digitBaseValue % 3  == 0){
            // digitBase 자리의 값의 3,6,9일 경우 해당 값 미만의 3,6,9에서 발생한 횟수와, 해당 값에서의 횟수를 더함
            // 해당 값 미만의 3,6,9 에서 발생한 횟수 (미만이기 때문에 해당 3,6,9를 제외한 -1)
            clapBelowDigitBaseCount += (below369Count - 1) * digitBase;
            // 해당 값에서 발생한 횟수 (0을 포함하기 때문에 +1)
            clapBelowDigitBaseCount += number % digitBase + 1;
        } else {
            // digitBase 자리의 값이 3,6,9가 아닐경우 해당 값 미만의 3,6,9에서 발생한 횟수만 더해주면 됨.
            clapBelowDigitBaseCount += (below369Count) * digitBase;
        }

        // 모든 자리에서 발생한 횟수를 더해서 반환
        return clapOverDigitBaseCount + clapBelowDigitBaseCount;
    }

}
