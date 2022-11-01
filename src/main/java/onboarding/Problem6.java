package onboarding;

import org.assertj.core.util.Lists;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set emails = new TreeSet();
        HashMap<String, Boolean> nicknameMap = new HashMap<String, Boolean>();

        for (List<String> item:forms) {
            List<String> separated = separateNickname((item.get(1)));
            for (String s:separated) {
                insertHash(s, nicknameMap);
            }
        }

        for (List<String> item:forms) {
            List<String> separated = separateNickname((item.get(1)));
            if (hasDuplicatedNickname(separated, nicknameMap)){
                emails.add(item.get(0));
            }
        }

        List<String> answer = Lists.newArrayList(emails);
        return answer;
    }

    private static boolean hasDuplicatedNickname(List<String> separateNicknames, HashMap<String, Boolean> map){
        for (String s:separateNicknames) {
            if (map.get(s) == Boolean.TRUE) return true;
        }
        return false;
    }

    private static void insertHash(String separateNickname, HashMap<String, Boolean> map){
        if (map.containsKey(separateNickname)){
            map.put(separateNickname, Boolean.TRUE);
            return;
        }
        map.put(separateNickname, Boolean.FALSE);
    }

    private static List<String> separateNickname(String nickname){
        final int length = nickname.length();
        List<String> separatedNicknames = new ArrayList<>();
        if (length < 2) return separatedNicknames;
        if (length == 2){
            separatedNicknames.add(nickname);
            return separatedNicknames;
        }
        for (int i = 0; i < length-1; i++) {
            for (int j = i+1; j < length; j++){
                separatedNicknames.add(nickname.substring(i,j+1));
            }
        }
        return separatedNicknames;
    }
}
