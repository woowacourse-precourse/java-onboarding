package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    public static ArrayList<String> separate(String nickname) {
        ArrayList<String> nicknames = new ArrayList<>();
        int length = nickname.length();

        for(int nicknameLength=2; nicknameLength<=length; nicknameLength++) {
            for(int index=0; index<length; index++){
                for(int sep=index; sep<length; sep+= nicknameLength) {
                    if (sep + nicknameLength > length) break;
                    nicknames.add(nickname.substring(sep, sep + nicknameLength));
                }
            }
        }
        return nicknames;
    }
}
