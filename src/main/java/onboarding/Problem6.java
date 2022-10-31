package onboarding;

import onboarding.problem6.Problem6Validation;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {

    private static final int MIN_EMAIL_INPUT = 11;
    private static final int MAX_EMAIL_INPUT = 20;

    private static final int MIN_NICKNAME_INPUT = 1;
    private static final int MAX_NICKNAME_INPUT = 20;

    private static final int EMAIL = 0;
    private static final int NICKNAME = 1;

    private static Map<String, Map<String, String>> trie;

    private static Set<String> resultEmailSet;

    public static List<String> solution(List<List<String>> forms) {

        trie = new HashMap<>();
        resultEmailSet = new HashSet<>();

        for (List<String> form: forms) {
            if (Problem6Validation.problem6Validation(form.get(EMAIL), form.get(NICKNAME), MIN_EMAIL_INPUT, MAX_EMAIL_INPUT, MIN_NICKNAME_INPUT, MAX_NICKNAME_INPUT)) {
                addTrieOrAddResultEmailSet(form.get(EMAIL), form.get(NICKNAME));
            }
        }
        return resultEmailSet.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private static void addTrieOrAddResultEmailSet(String email, String nickname) {
        if (nicknameIsBiggerThanOne(nickname)) {
            for (int i = 0; i < nickname.length() - 1; i++) {
                String subString = nickname.substring(i, i + 2);
                addTrieOrIfSubStringExistsInLeafNodeThenAddIntoResultEmailSet(getFirstLayerTrie(subString), subString, email);
            }
        }
    }

    private static boolean nicknameIsBiggerThanOne(String nickname) {
        return nickname.length() >= 2;
    }

    private static Map<String, String> getFirstLayerTrie(String subString) {
        return findSubMap(trie, String.valueOf(subString.charAt(0)));
    }

    private static Map<String, String> findSubMap(Map<String, Map<String, String>> trie, String subString) {
        Map<String, String> firstLayerTrieMap = null;
        if (trie.containsKey(subString)) {
            firstLayerTrieMap = trie.get(subString);
        } else if (!trie.containsKey(subString)) {
            firstLayerTrieMap = new HashMap<>();
            trie.put(subString, firstLayerTrieMap);
        }
        return firstLayerTrieMap;


    }

    private static void addTrieOrIfSubStringExistsInLeafNodeThenAddIntoResultEmailSet(Map<String, String> firstLayerTrie, String subString, String email) {
        if (firstLayerTrie.containsKey(subString)) {
            resultEmailSet.add(firstLayerTrie.get(subString));
            resultEmailSet.add(email);
        } else if (!firstLayerTrie.containsKey(subString)) {
            firstLayerTrie.put(subString, email);
        }
    }






}
