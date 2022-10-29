package onboarding;

import java.util.*;
import java.util.stream.Collectors;

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
        System.out.println(Arrays.toString(returnedNickNames));

        for (int index = 0; index < returnedNickNames.length; index++) {
            int finalIndex = index;
            emailList.add(formsMap.entrySet().stream()
                .filter(entry -> Objects.equals(entry.getValue(), returnedNickNames[finalIndex]))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList()).toString());
        }

        System.out.println(emailList);
//        Iterator iterator = duplicateNickName.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());

//
//        }

//        Collection<String> nicknames = formsMap.values();
//
//        Iterator iterator = nicknames.iterator();
//        while (iterator.hasNext()) {
//            String nickname = (String) iterator.next();
//            System.out.println(nickname);
//
//            checkNickName(nickname, nicknames);
//        }


        return emailList;
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
