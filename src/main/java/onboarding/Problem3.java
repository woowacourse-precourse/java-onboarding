package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    public int countTargetCharacterInNumber(char targetCharacter, int number) {
        String stringOfNumber = Integer.toString(number);
        if (stringOfNumber.contains(Character.toString(targetCharacter))) {
            return (int)stringOfNumber.chars().filter(x -> x == targetCharacter).count();
        }
        return 0;
    }
}
