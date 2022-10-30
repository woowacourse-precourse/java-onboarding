package onboarding.problem2;

import java.util.ArrayList;
import java.util.LinkedList;

public class Decoder {
    public ArrayList<int[]> duplicates = new ArrayList<>();

    public static Decoder findDuplicates(LinkedList<Character> list) {
        Decoder decoder = new Decoder();

        int idx = 0;
        int listSize = list.size();

        while (idx < listSize) {
            int currentIdx = idx;
            int numberOfDuplicate = 1;

            Character ch = list.get(idx);
            while (idx + 1 < listSize && ch.equals(list.get(idx + 1))) {
                idx++;
                numberOfDuplicate++;
            }
            if (numberOfDuplicate > 1) {
                decoder.duplicates
                        .add(new int[]{currentIdx, numberOfDuplicate});
            }
            idx++;
        }
        return decoder;
    }
}
