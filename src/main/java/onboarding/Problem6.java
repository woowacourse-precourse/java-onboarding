package onboarding;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
    /**
     * result : 같은 글자가 연속으로 있다고 판단되는 유저의 이메일을 담은 Set
     * root : Trie 자료구조의 시작 Pointer
     */
    Set<String> result = new HashSet<>();
    Trie root = new Trie();

    /**
     * 같은 글자가 연속으로 있는 이메일을 출력하는 메서드
     *
     * @param forms
     * @return
     */
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
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

    }

    /**
     * Trie의 Root 부터 모든 노드를 순환하며 키워드가 겹치는 이메일을 result HashSet에 넣어주는 메서드
     *
     * @param result
     * @param root
     */
    public static void find(Set<String> result, Trie root) {

    }

    /**
     * Trie 자료구조를 사용하기 위한 class 선언
     */
    public static class Trie {

    }
}
