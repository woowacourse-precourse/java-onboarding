package problem2;

import java.util.ArrayList;
import java.util.List;

public class ContinuousDuplicationDeleter {
    public static String deleteDuplication(String target) {
        List<Character> deleted = deleteDuplication(target.toCharArray());
        return asString(deleted);
    }

    private static List<Character> deleteDuplication(char[] target) {
        List<Character> charactersWithoutDuplication = new ArrayList<>();
        List<Integer> numberOfDuplication = new ArrayList<>();

        for (int ind = 0; ind < target.length; ) {
            int lastIndex = charactersWithoutDuplication.size() - 1;

            if (charactersWithoutDuplication.isEmpty()) {
                add(charactersWithoutDuplication, numberOfDuplication, target[ind]);
                ind += 1;
                continue;
            }

            if (isSame(charactersWithoutDuplication.get(lastIndex), target[ind])) {
                increaseByOne(numberOfDuplication, lastIndex);
                ind += 1;
                continue;
            }

            if (isDuplicate(numberOfDuplication, lastIndex)) {
                remove(charactersWithoutDuplication, numberOfDuplication, lastIndex);
                continue;
            }

            add(charactersWithoutDuplication, numberOfDuplication, target[ind]);
            ind++;
        }

        if (isDuplicate(numberOfDuplication, numberOfDuplication.size() -1)) {
            remove(charactersWithoutDuplication, numberOfDuplication, numberOfDuplication.size() -1);
        }

        return charactersWithoutDuplication;
    }

    private static void add(List<Character> charactersInOrder, List<Integer> numberOfDuplication, char toAdd) {
        charactersInOrder.add(toAdd);
        numberOfDuplication.add(1);
    }

    private static boolean isSame(int lhs, char rhs) {
        return lhs == rhs;
    }

    private static void increaseByOne(List<Integer> numberOfDuplication, int index) {
        numberOfDuplication.set(index, numberOfDuplication.get(index) + 1);
    }

    private static boolean isDuplicate(List<Integer> numberOfDuplication, int index) {
        return numberOfDuplication.get(index) > 1;
    }

    private static void remove(List<Character> charactersInOrder, List<Integer> numberOfDuplication, int index) {
        charactersInOrder.remove(index);
        numberOfDuplication.remove(index);
    }

    private static String asString(List<Character> characters) {
        StringBuilder sb = new StringBuilder();

        for (Character character : characters) {
            sb.append(character);
        }

        return sb.toString();
    }
}
