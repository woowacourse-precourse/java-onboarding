package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        HashMap<String, ArrayList<Integer>> arrayListHashMap;
        arrayListHashMap = makeNicknameHashMap(forms);

        for (Map.Entry<String, ArrayList<Integer>> entry : arrayListHashMap.entrySet()) {
            hasDuplicateNickname(forms, answer, entry);
        }

        answer = sortAnswer(answer);

        return answer;
    }


    private static HashMap<String, ArrayList<Integer>> makeNicknameHashMap(List<List<String>> forms) {
        HashMap<String, ArrayList<Integer>> hashMap = new HashMap<>();

        for (int i = 0; i < forms.size(); i++) {
            groupByTwoLetter(forms, hashMap, i);
        }

        return hashMap;
    }


    private static void groupByTwoLetter(List<List<String>> forms, HashMap<String, ArrayList<Integer>> hashMap, int i) {
        String email = forms.get(i).get(0);
        String name = forms.get(i).get(1);

        validationCheck(email, name);

        for (int j = 0; j < name.length() - 1; j++) {
            String word = name.substring(j, j + 2);
            ArrayList<Integer> list = new ArrayList<>();
            if (hashMap.containsKey(word)) {
                list = hashMap.get(word);
            }
            list.add(i);
            hashMap.put(word, list);
        }
    }


    private static void validationCheck(String email, String name) {
        if (!validateEmailCheck(email)) {
            throw new IllegalStateException("이메일 형식에 부합하지 않음");
        }

        if (!validateNicknameCheck(name)) {
            throw new IllegalStateException("닉네임 형식에 부합하지 않음");
        }
    }


    private static boolean validateEmailCheck(String email) {
        if (email.endsWith("email.com") &&
                11 <= email.length() && email.length() < 20) {
            return true;
        }

        return false;
    }


    private static boolean validateNicknameCheck(String nickname) {
        if (nickname.matches("^[가-힣]*$") &&
                0 < nickname.length() && nickname.length() < 20) {
            return true;
        }

        return false;
    }


    private static void hasDuplicateNickname(List<List<String>> forms, List<String> answer, Map.Entry<String, ArrayList<Integer>> entry) {
        if (entry.getValue().size() > 1) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                answer.add(forms.get(entry.getValue().get(i))
                        .get(0));
            }
        }
    }


    private static List<String> sortAnswer(List<String> answer) {
        Set<String> set = new HashSet<>(answer);
        List<String> sortedList = new ArrayList<>(set);

        Collections.sort(sortedList);

        return sortedList;
    }
}
