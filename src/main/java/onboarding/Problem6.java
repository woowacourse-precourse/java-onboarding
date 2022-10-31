package onboarding;

import java.util.*;

public class Problem6 {
    /**
     * 같은 글자가 연속으로 있는 이메일을 출력하는 메서드
     *
     * @param forms
     * @return
     */
    public static List<String> solution(List<List<String>> forms) {
        Set<String> result = new HashSet<>();
        Trie root = new Trie();

        for (List<String> form : forms) {
            String email = form.get(0);
            String nickName = form.get(1);

            System.out.println(email);

            String[] emailToken = email.split("@");

            if (emailToken[1].equals("email.com")) {
                System.out.println(nickName);
                insert(nickName, 0, email, root);
            }
        }

        find(result, root);

        List<String> answer = new LinkedList<>(result);
        Collections.sort(answer);

        return answer;
    }

    /**
     * 각 닉네임을 순회하면서 2개 이상의 subString을 Trie에 등록하는 메서드
     *
     * @param word
     * @param startIdx
     * @param email
     * @param root
     */
    public static void insert(String word, int startIdx, String email, Trie root) {
        int size = word.length();
        Trie current = root;

        int idx = startIdx;
        char target = word.charAt(idx);

        if (!current.children.containsKey(target)) {
            current.children.put(target, new Trie());
        }

        current = current.children.get(target);

        for (int i = startIdx + 1; i < size; i++) {
            target = word.charAt(i);

            if (!current.children.containsKey(target)) {
                current.children.put(target, new Trie());
            }

            insert(word, i, email, root);
            current = current.children.get(target);

            current.userEmail.add(email);
        }
    }

    /**
     * Trie의 Root 부터 모든 노드를 순환하며 키워드가 겹치는 이메일을 result HashSet에 넣어주는 메서드
     *
     * @param result
     * @param root
     */
    public static void find(Set<String> result, Trie root) {
        if (root.userEmail.size() > 1) result.addAll(root.userEmail);

        for (Character key : root.children.keySet()) {
            find(result, root.children.get(key));
        }
    }

    /**
     * Trie 자료구조를 사용하기 위한 class 선언
     */
    public static class Trie {
        Map<Character, Trie> children;
        Set<String> userEmail;

        public Trie() {
            this.children = new HashMap<>();
            this.userEmail = new HashSet<>();
        }
    }
}
