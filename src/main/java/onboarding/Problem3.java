package onboarding;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Utility{
    final int startNumber=1;
    int[] makeArray(int endNumber){
        return IntStream.range(startNumber,endNumber+1).toArray();
    }
    int[] divideEachDigit(int number) {
        int[] digitNum;
        digitNum = Stream.of(String.valueOf(number).split("")).mapToInt(Integer::parseInt).toArray();
        return digitNum;
    }
}
class Game{
    final int[] clapCondition = {3,6,9};
    boolean isClap(int digit){
        return IntStream.of(clapCondition).anyMatch(condition->condition==digit);
    }
    int countClap(int[] digitArray){
        int numberOfClap=0;

        for(int digit: digitArray){
            if(isClap(digit)){
                numberOfClap++;
            }
        }
        return numberOfClap;
    }
    int play(int[] numbers){
        int totalClapCount=0;
        int[] digitArray;
        Utility utility = new Utility();
        for (int number: numbers){
            digitArray = utility.divideEachDigit(number);
            totalClapCount+=countClap(digitArray);
        }
        return totalClapCount;
    }

}

public class Problem3 {
    public static int solution(int number) {
        int answer=0;
        int[] numbers;

        Utility utility = new Utility();
        Game game = new Game();

        numbers = utility.makeArray(number);
        answer=game.play(numbers);
        System.out.println(answer);
        return answer;
    }
}
