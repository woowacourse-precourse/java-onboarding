package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class Problem6 {
    static PriorityQueue<String> overlapNamesQueue;
    static boolean[] check;

    public static List<String> solution(List<List<String>> forms) {
        PriorityQueue<String> overlapNamesQueue = getOverlapNamesQueue(forms);

        return priorityQueueToList(overlapNamesQueue);
    }

    static PriorityQueue<String> getOverlapNamesQueue(List<List<String>> forms) {
        int size = forms.size();
        overlapNamesQueue = new PriorityQueue<>();
        check = new boolean[size];

        for (int i = 0; i < size; i++) {
            if (!check[i]) {
                setOverlapNamesQueue(forms, i);
            }
        }

        return overlapNamesQueue;
    }

    static void setOverlapNamesQueue(List<List<String>> forms, int i) {
        String formName = forms.get(i).get(1);

        for (int j = 0; j < formName.length() -1; j++) {
            String subStr = formName.substring(j, j+2);
            findOverlapNames(subStr, forms, i);
        }
    }

    static void findOverlapNames(String subStr, List<List<String>> forms, int i) {
        for (int k = 0; k < forms.size(); k++) {
            findOverlapName(forms, subStr, i, k);
        }
    }

    static void findOverlapName(List<List<String>> forms, String subStr, int i, int k) {
        String currentEmail = forms.get(i).get(0);
        String targetName = forms.get(k).get(1);
        String targetEmail = forms.get(k).get(0);

        if(!isException(forms, i, k) && targetName.contains(subStr)) {
            inputOverlapName(currentEmail, targetEmail, k);
        }
    }

    static void inputOverlapName(String currentEmail, String targetEmail, int k) {
        check[k] = true;

        inputOverlapNameEmail(currentEmail, targetEmail);
    }

    static void inputOverlapNameEmail(String currentEmail, String targetEmail) {
        if (validateOverlapEmail(currentEmail)) {
            overlapNamesQueue.add(currentEmail);
        }
        if (validateOverlapEmail(targetEmail)) {
            overlapNamesQueue.add(targetEmail);
        }
    }

    static boolean validateOverlapEmail(String email) {
        if (!overlapNamesQueue.contains(email)) {
            return true;
        }

        return false;
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

    static List<String> priorityQueueToList(PriorityQueue<String> queue) {
        List<String> result = new ArrayList<>();

        Stream.generate(queue::poll)
                .limit(queue.size())
                .forEach(value -> result.add(value));

        return result;
    }
}
