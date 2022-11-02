package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> findEmails(List<List<String>> forms) {
        List<String> slicedNicknames = new ArrayList<>();
        List<String> nicknames = getNicknames(forms);
        List<String> emails = new ArrayList<>();
        String email = "";
        String nickname = "";

        for (List<String> userInfo : forms) {
            email = userInfo.get(0);
            nickname = userInfo.get(1);
            nicknames.remove(String.valueOf(nickname));
            slicedNicknames = getSlicedNicknames(nicknames);
            for (String slicedNickname : slicedNicknames){
                if (nickname.contains(slicedNickname)) {
                    emails.add(email);
                    break;
                }
            }
            nicknames.add(nickname);
        }

        return emails;
    }

    public static List<String> getSlicedNicknames(List<String> nicknames) {
        List<String> slicedNicknames = new ArrayList<>();
        String slicedNickname = "";

        for (String nickname : nicknames) {
            for (int index = 0; index < nickname.length() - 1; index++) {
                slicedNickname = nickname.substring(index, index + 2);
                if (!slicedNicknames.contains(slicedNickname)) {
                    slicedNicknames.add(slicedNickname);
                }
            }
        }
        return slicedNicknames;
    }

    public static List<String> getNicknames(List<List<String>> forms) {
        List<String> nicknames = new ArrayList<>();
        String nickName = "";

        for (List<String> userInfo : forms) {
            nickName = userInfo.get(1);
            nicknames.add(nickName);
        }
        return nicknames;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        answer = findEmails(forms);
        Collections.sort(answer);

        return answer;
    }
}
