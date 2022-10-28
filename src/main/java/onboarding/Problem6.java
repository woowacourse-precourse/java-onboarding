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

    static List<String> priorityQueueToList(PriorityQueue<String> queue) {
        List<String> result = new ArrayList<>();

        Stream.generate(queue::poll)
            .limit(queue.size())
            .forEach(value -> result.add(value));

        return result;
    }

    static PriorityQueue<String> getOverlapNamesQueue(List<List<String>> forms) {
        int size = forms.size();
        PriorityQueue<String> overlapNamesQueue = new PriorityQueue<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i != j && !validateOverlapName(overlapNamesQueue, forms.get(i), forms.get(j))) {
                    break;
                }
            }
        }

        return overlapNamesQueue;
    }

    static void setOverlapNamesQueue(List<List<String>> forms, PriorityQueue<String> overlapNamesQueue, int i, int j) {
        if (isException(forms, i, j)) {
            return;
        }

    }

    static boolean isException(List<List<String>> forms, int i, int j) {
        if (!isSameIdx(i, j) || isOverOneLetter(forms, i, j))
            return false;
        return true;
    }


    static boolean isSameIdx(int i, int j) {
        if (i == j) {
            return true;
        }

        return false;
    }

    static boolean isOverOneLetter(List<List<String>> forms, int i, int j) {
        String currentName = forms.get(i).get(1);
        String targetName = forms.get(i).get(1);

        if(currentName.length() <= 1 || targetName.length() <= 1) {
            return false;
        }

        return true;
    }

    static boolean validateOverlapName(PriorityQueue<String> overlapNamesQueue, List<String> form1, List<String> form2) {
        String name1 = form1.get(1);
        String name2 = form2.get(1);

        if (!isOverlapName(name1, name2)) {
            overlapNamesQueue.add(form1.get(0));
            return false;
        }

        return true;
    }

    static boolean isOverlapName(String currentName, String targetName) {
        for (int i = 0; i < currentName.length() -1; i++) {
            String target = currentName.substring(i, i+2);

            if (targetName.contains(target)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> forms = List.of(
            List.of("jm@email.com", "제이가가위들자보자기를낸다"),
            List.of("jason@email.com", "가휘들이춤을춘다"),
            List.of("woniee@email.com", "아메바골짜기가지잉위잉"),
            List.of("mj@email.com", "우째쓰까요맘때"),
            List.of("nowm@email.com", "골로가다골룸이되었다")
        );

        System.out.println(solution(forms));
    }
}
