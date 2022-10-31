package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Queue<Character> queue = new LinkedList<>();
        Set<String> emailList = new HashSet<>();
        for (List<String> form : forms) {
            char[] chars = form.get(1).toCharArray();
            compareNicknameAndGetEmailList(forms, queue, emailList, form, chars);
            queue.clear();
        }

        return new ArrayList<>(emailList);
    }

    private static void compareNicknameAndGetEmailList(List<List<String>> forms, Queue<Character> queue, Set<String> emailList, List<String> form, char[] chars) {
        for (Character aChar : chars) {
            setQueue(forms, queue, emailList, form, aChar);
        }
    }

    private static void setQueue(List<List<String>> forms, Queue<Character> queue, Set<String> emailList, List<String> form, Character aChar) {
        if (queue.size() < 2) {
            queue.add(aChar);
        }
        if (queue.size() == 2) {
            addEmail(forms, queue, emailList, form);
            queue.poll();
        }
    }

    private static void addEmail(List<List<String>> forms, Queue<Character> queue, Set<String> emailList, List<String> form) {
        String nickName = queue.stream().map(String::valueOf).collect(Collectors.joining());
        forms.forEach(formsList -> {
            if (formsList.get(1).contains(nickName) && !formsList.equals(form)) {
                emailList.add(form.get(0));
            }
        });
    }
}
