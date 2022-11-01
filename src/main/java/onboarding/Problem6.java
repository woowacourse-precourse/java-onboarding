package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
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
