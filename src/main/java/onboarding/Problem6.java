package onboarding;

import java.util.*;

public class Problem6 {
    static Collection<String> duplicatedNickNames = new HashSet<>();

    public static List<String> solution(List<List<String>> forms) {
        Map<String, String> formsMap = new HashMap<>();
        for (int i = 0; i < forms.size(); i++) {
            List form = forms.get(i);
            formsMap.put((String) form.get(0), (String) form.get(1));
        }

        Collection<String> nickNames = formsMap.values();
        String[] nickNameArray = nickNames.toArray(new String[0]);

        for (int i = 0; i < nickNameArray.length; i++) {
            getDuplicationStr(nickNameArray[i], nickNameArray);
        }
        List<String> emailList = new ArrayList<>();
        String[] returnedNickNames = duplicatedNickNames.toArray(new String[0]);

        for (int i = 0; i < returnedNickNames.length; i++) {
            emailList.add(getKey(formsMap, returnedNickNames[i]));
        }

        Collections.sort(emailList);

        return emailList;
    }

    private static String getKey(Map<String, String> formsMap, String returnedNickName) {
        for (String email : formsMap.keySet()) {
            if (returnedNickName.equals(formsMap.get(email))) {
                return email;
            }
        }
        return null;
    }

    private static void getDuplicationStr(String nickName, String[] nickNameArray) {
        for (int i = 0; i < nickName.length() - 1; i++) {
            String currChar = String.valueOf(nickName.charAt(i));
            String nextChar = String.valueOf(nickName.charAt(i + 1));
            String duplicationWord = currChar + nextChar;
            checkDuplication(duplicationWord, nickName, nickNameArray);

        }
    }

    private static void checkDuplication(String duplicationWord, String nickName, String[] nickNameArray) {
        for (int i = 0; i < nickNameArray.length; i++) {
            nickNameArray[i].contains(duplicationWord);
            if (nickNameArray[i].contains(duplicationWord) && nickNameArray[i].indexOf(nickName) != 0) {
                duplicatedNickNames.add(nickNameArray[i]);
            }
        }
    }
}
