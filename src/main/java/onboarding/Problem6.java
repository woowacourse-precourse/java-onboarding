package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Stream;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        PriorityQueue<String> overlapNames = getOverlapNames(forms);
        return toList(overlapNames);
    }

    static List<String> toList(PriorityQueue<String> queue) {
        List<String> result = new ArrayList<>();

        Stream.generate(queue::poll)
            .limit(queue.size())
            .forEach(value -> result.add(value));

        return result;
    }

    static PriorityQueue<String> getOverlapNames(List<List<String>> forms) {
        int size = forms.size();
        PriorityQueue<String> emailQueue = new PriorityQueue<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i != j && !validateOverlapName(emailQueue, forms.get(i), forms.get(j))) {
                    break;
                }
            }
        }

        return emailQueue;
    }

    static boolean validateOverlapName(PriorityQueue<String> emailQueue, List<String> form1, List<String> form2) {
        String name1 = form1.get(1);
        String name2 = form2.get(1);

        if(name1.length() == 1 || name2.length() == 1) {
            return true;
        }

        if (!isOverlapName(name1, name2)) {
            emailQueue.add(form1.get(0));
            return false;
        }

        return true;
    }

    static boolean isOverlapName(String name1, String name2) {
        for (int i = 0; i < name1.length() -1; i++) {
            String target = name1.substring(i, i+2);
            if (name2.contains(target)) {
                return false;
            }
        }

        return true;
    }
}
