package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        List<String> emails = new ArrayList<>();
        List<String> nicknames = new ArrayList<>();
        for (List<String> form : forms) {
            emails.add(form.get(0));
            nicknames.add(form.get(1));
        }

        List<Integer> duplicatedIndexes = checkNicknames(nicknames);

        return answer;
    }

    private static List<Integer> checkNicknames(List<String> nicknames) {
        List<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < nicknames.size()-1; i++) {
            String checkingNickname = nicknames.get(i);
            List<String> checkingNicknameSlices = devideIntoTwo(checkingNickname);
            List<String> others = new ArrayList<>(nicknames.subList(i+1,nicknames.size()));
            for (String other : others) {
                for (String nowChecking : checkingNicknameSlices) {
                    if (isDuplicated(nowChecking, other)) {
                        if (!indexes.contains(i)) {
                            indexes.add(i);
                        }
                        if (!indexes.contains(nicknames.indexOf(other))){
                            indexes.add(nicknames.indexOf(other));
                        }
                    }
                }
            }
        }
        return indexes;
    }

    private static boolean isDuplicated(String nowChecking, String otherNickname) {
        boolean tf = otherNickname.contains(nowChecking);
        return tf;
    }

    private static List<String> devideIntoTwo(String nickname) {
        List<String> twoLetters = new ArrayList<>();
            for (int i = 0; i < nickname.length() - 1; i++) {
                String slicedStr = nickname.substring(i, i + 1);
                if (!twoLetters.contains(slicedStr)) {
                    twoLetters.add(slicedStr);
                }
            }
        return twoLetters;
    }
}
