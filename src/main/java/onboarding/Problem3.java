package onboarding;

public class Problem3 {
    /**
     * number을 input으로 넘기면, number까지 몇 번의 박수를 쳐야하는지 리턴하는 메서드이다.
     *
     * @param : int, 게임이 진행되는 마지막 숫자
     * @return : int, 몇 번의 박수를 쳐야 하는지
     */
    public static int solution(int number) {
        int answer = playGame(number);
        return answer;
    }

    /**
     * 게임을 number까지 진행하면 몇 번의 박수를 쳐야하는지 리턴하는 메서드이다.
     *
     * @param : int, 게임이 진행되는 마지막 숫자
     * @return : int, 몇 번의 박수를 쳐야 하는지
     */
    public static int playGame(int number) {
        int[] clapCount = new int[Math.max(10, number + 1)];
        clapCount[3] = 1;
        clapCount[6] = 1;
        clapCount[9] = 1;

        int[] howManyClap = new int[number + 1];
        for (int currentNumber = 1; currentNumber <= number; currentNumber++) {
            int lastDigit = currentNumber % 10;
            int numberWithoutLastDigit = currentNumber / 10;
            clapCount[currentNumber] = clapCount[lastDigit] + clapCount[numberWithoutLastDigit];
            howManyClap[currentNumber] = clapCount[currentNumber] + howManyClap[currentNumber - 1];
        }

        return howManyClap[number];
    }
}
