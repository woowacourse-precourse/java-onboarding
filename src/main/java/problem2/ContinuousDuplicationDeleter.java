package problem2;

import java.util.ArrayList;
import java.util.List;

public class ContinuousDuplicationDeleter {
    public static String delete(String target) {
        List<Character> deleted = delete(target.toCharArray());
        return asString(deleted);
    }

    private static List<Character> delete(char[] target) {
        List<Character> charactersInOrder = new ArrayList<>();
        List<Integer> numberOfDuplication = new ArrayList<>();

        for (int ind = 0; ind < target.length; ) {
            int lastIndex = charactersInOrder.size() - 1;

            if (charactersInOrder.isEmpty()) {
                add(charactersInOrder, numberOfDuplication, target[ind]);
                ind += 1;
                continue;
            }

            if (isSame(charactersInOrder, lastIndex, target[ind])) {
                increaseByOne(numberOfDuplication, lastIndex);
                ind += 1;
                continue;
            }

            if (isDuplicate(numberOfDuplication, lastIndex)) {
                remove(charactersInOrder, numberOfDuplication, lastIndex);
                continue;
            }

            add(charactersInOrder, numberOfDuplication, target[ind]);
            ind++;
        }

        if (isDuplicate(numberOfDuplication, numberOfDuplication.size() -1)) {
            remove(charactersInOrder, numberOfDuplication, numberOfDuplication.size() -1);
        }

        return charactersInOrder;
    }

    private static void add(List<Character> charactersInOrder, List<Integer> numberOfDuplication, char target) {
        charactersInOrder.add(target);
        numberOfDuplication.add(1);
    }

    private static boolean isSame(List<Character> charactersInOrder, int lastIndex, char target) {
        return charactersInOrder.get(lastIndex) == target;
    }

    private static void increaseByOne(List<Integer> numberOfDuplication, int lastIndex) {
        numberOfDuplication.set(lastIndex
                , numberOfDuplication.get(lastIndex) + 1);
    }

    private static boolean isDuplicate(List<Integer> numberOfDuplication, int lastIndex) {
        return numberOfDuplication.get(lastIndex) > 1;
    }

    private static void remove(List<Character> charactersInOrder, List<Integer> numberOfDuplication, int lastIndex) {
        charactersInOrder.remove(lastIndex);
        numberOfDuplication.remove(lastIndex);
    }

    private static String asString(List<Character> characters) {
        StringBuilder sb = new StringBuilder();

        for (Character character : characters) {
            sb.append(character);
        }

        return sb.toString();
    }
}
