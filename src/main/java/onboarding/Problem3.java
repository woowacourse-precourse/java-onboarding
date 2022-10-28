package onboarding;

public class Problem3 {

    public int countTargetCharacterInNumber(char targetCharacter, int number) {
        String stringOfNumber = Integer.toString(number);
        if (stringOfNumber.contains(Character.toString(targetCharacter))) {
            return (int)stringOfNumber.chars().filter(x -> x == targetCharacter).count();
        }
        return 0;
    }

    public int play369Game(int endNumber) {
        int count = 0;
        for (int i = 1; i <= endNumber; i++) {
            count += countTargetCharacterInNumber('3', i);
            count += countTargetCharacterInNumber('6', i);
            count += countTargetCharacterInNumber('9', i);
        }
        return count;
    }

    public static int solution(int number) {
        int numberOfClaps = 0;
        Problem3 problem3 = new Problem3();

        numberOfClaps = problem3.play369Game(number);
        return numberOfClaps;
    }
}
