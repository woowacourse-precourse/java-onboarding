package onboarding.problem3;

public class GameOf369 {

    private final char[] TARGET_NUMBERS = {'3', '6', '9'};

    public GameOf369() {
    }

    public int countTargetCharacterInNumber(char targetCharacter, int number) {
        String stringNumber = Integer.toString(number);
        String targetString = Character.toString(targetCharacter);
        if (stringNumber.contains(Character.toString(targetCharacter))) {
            return (int) stringNumber.chars().filter(x -> x == targetCharacter).count();
        }
        return 0;
    }

    public int countTargetNumbers(int number) {
        int count = 0;
        for (char targetNumber : TARGET_NUMBERS) {
            count += countTargetCharacterInNumber(targetNumber, number);
        }
        return count;
    }

    public int countAllClapsTo(int endNumber) {
        int count = 0;
        for (int i = 1; i <= endNumber; i++) {
            count += countTargetNumbers(i);
        }
        return count;
    }
}
