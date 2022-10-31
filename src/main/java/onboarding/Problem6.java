package onboarding;

import java.util.*;

public class Problem6 {
    static List<String> nicknameList = new ArrayList<>();
    static List<String> nicknameSubset = new ArrayList<>();
    static HashMap<String, Integer> nicknameSubsetNumber = new HashMap<>();
    static Set<String> sendEmailID = new TreeSet<>();

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        List<String> emailList = new ArrayList<>();

        executeAll(forms);
        answer = needToSendEmail(emailList);
        return answer;
    }

    public static void executeAll(List<List<String>> forms) {
        setNicknameList(forms);
        removeOneLetterNickname();
        addNicknameSubset();
        resetSubsetNumber();
        countDuplicateSubset();

        nicknameSubset.clear(); // 부분집합 list 초기화
        isDuplicatedSubset();
        checkDuplicateNickname(forms);
    }

    public static void setNicknameList(List<List<String>> forms) {
        for (Iterator<List<String>> iter = forms.iterator(); iter.hasNext(); ) {
            nicknameList.add(iter.next().get(1));
        }
    }

    public static void removeOneLetterNickname() {
        for (String nickname : nicknameList) {
            if (nickname.length() == 1) {
                nicknameList.remove(nickname);
            }
        }
    }

    public static void addNicknameSubset() {
        for (String nickname : nicknameList) {
            cutNickname(nickname);
        }
    }

    public static void cutNickname(String nickname) {
        for (int i = 0; i <= nickname.length() - 2; i++) {
            nicknameSubset.add(nickname.substring(i, i + 2));
        }
    }

    public static void resetSubsetNumber() {
        for (String subset : nicknameSubset) {
            nicknameSubsetNumber.put(subset, 0);
        }
    }

    public static void countDuplicateSubset() {
        for (String subset : nicknameSubset) {
            nicknameSubsetNumber.put(subset, nicknameSubsetNumber.get(subset) + 1);
        }
    }

    public static void isDuplicatedSubset() {
        for (Map.Entry<String, Integer> entry : nicknameSubsetNumber.entrySet()) {
            String subset = entry.getKey();
            int duplicatedNum = entry.getValue();

            if (duplicatedNum >= 2) {
                nicknameSubset.add(subset);
            }
        }
    }

    public static void checkDuplicateNickname(List<List<String>> forms) {
        for (String nickname : nicknameList) {
            isContainSubset(forms, nickname);
        }
    }

    public static void isContainSubset(List<List<String>> forms, String nickname) {
        for (Iterator<String> subset = nicknameSubset.iterator(); subset.hasNext(); ) {
            if (nickname.contains(subset.next())) {
                addEmailList(forms, nickname);
            }
        }
    }

    public static void addEmailList(List<List<String>> forms, String duplicatedNickname) {
        for (List<String> readOneList : forms) {
            String email = readOneList.get(0);
            String nickname = readOneList.get(1);
            if (nickname.equals(duplicatedNickname)) {
                sendEmailID.add(email);
            }
        }
    }

    public static List<String> needToSendEmail(List<String> emailList) {
        Iterator<String> email = sendEmailID.iterator();
        while (email.hasNext()) {
            emailList.add(email.next());
        }
        return emailList;
    }
}