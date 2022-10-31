package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        PriorityQueue<String> overlapNamesQueue = getOverlapNamesQueue(forms);

        return priorityQueueToList(overlapNamesQueue);
    }

    static PriorityQueue<String> getOverlapNamesQueue(List<List<String>> forms) {
        int size = forms.size();
        PriorityQueue<String> overlapNamesQueue = new PriorityQueue<>();

        for (int i = 0; i < size; i++) {
            setOverlapNamesQueue(forms, overlapNamesQueue, i);
        }

        return overlapNamesQueue;
    }

    static void setOverlapNamesQueue(List<List<String>> forms, PriorityQueue<String> overlapNamesQueue, int i) {
        for (int j = 0; j < forms.size(); j++) {
            String currentEmail = forms.get(i).get(0);
            String currentName = forms.get(i).get(1);
            String targetName = forms.get(j).get(1);

            if (!isException(forms, i, j) && isOverlapName(currentName, targetName)) {
                removeOverlapEmail(overlapNamesQueue, currentEmail);
                break;
            }
        }
    }

    static boolean isException(List<List<String>> forms, int i, int j) {
        if (isSameIdx(i, j) || !isOverOneLetter(forms, i, j)) {
            return true;
        }

        return false;
    }


    static boolean isSameIdx(int i, int j) {
        if (i == j) {
            return true;
        }

        return false;
    }

    static boolean isOverOneLetter(List<List<String>> forms, int i, int j) {
        String currentName = forms.get(i).get(1);
        String targetName = forms.get(j).get(1);

        if(currentName.length() <= 1 || targetName.length() <= 1) {
            return false;
        }

        return true;
    }

    static boolean isOverlapName(String currentName, String targetName) {
        for (int i = 0; i < currentName.length() -1; i++) {
            String substrCurName = currentName.substring(i, i+2);

            if (targetName.contains(substrCurName)) {
                return true;
            }
        }
        return false;
    }

    static void removeOverlapEmail(PriorityQueue<String> overlapNamesQueue, String currentEmail) {
        if (!overlapNamesQueue.contains(currentEmail)) {
            overlapNamesQueue.add(currentEmail);
        }
    }

    static List<String> priorityQueueToList(PriorityQueue<String> queue) {
        List<String> result = new ArrayList<>();

        Stream.generate(queue::poll)
            .limit(queue.size())
            .forEach(value -> result.add(value));

        return result;
    }
}
