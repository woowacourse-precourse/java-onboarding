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
        List<String> answer = List.of("answer");
        return answer;
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

    public static void main(String[] args) {
        List<List<String>> forms = List.of(
            List.of("jm@email.com", "제이엠"),
            List.of("jason@email.com", "제이슨"),
            List.of("woniee@email.com", "워니"),
            List.of("mj@email.com", "엠제이"),
            List.of("nowm@email.com", "이제엠")
        );
        PriorityQueue<String> result = getOverlapNames(forms);
        Stream.generate(result::poll)
            .limit(result.size())
            .forEach(value -> System.out.println(value + " "));

    }
}
