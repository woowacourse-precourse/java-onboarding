package onboarding;

import java.util.*;

public class Problem6 {
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

//        Collection<String> nicknames = formsMap.values();
//
//        Iterator iterator = nicknames.iterator();
//        while (iterator.hasNext()) {
//            String nickname = (String) iterator.next();
//            System.out.println(nickname);
//
//            checkNickName(nickname, nicknames);
//        }

        List<String> answer = List.of("answer");
        return answer;
    }

    private static void getDuplicationStr(String nickName, String[] nickNameArray) {
        for (int i = 0; i < nickName.length() - 1; i++) {
            String currChar = String.valueOf(nickName.charAt(i));
            String nextChar = String.valueOf(nickName.charAt(i + 1));
            String duplicationWord = currChar + nextChar;
            System.out.println(duplicationWord);
            checkDuplication(duplicationWord, nickNameArray);

        }
    }


//    private static void checkNickName(String nickname, Collection<String> nicknames) {
//        for (int i = 0; i < nickname.length() - 1; i++) {
//            String currChar = String.valueOf(nickname.charAt(i));
//            String nextChar = String.valueOf(nickname.charAt(i + 1));
//            String duplicationWord = currChar + nextChar;
//            System.out.println(duplicationWord);
//            nicknames.remove(nickname);
//            System.out.println(nicknames);
//
//        }
//    }

}
