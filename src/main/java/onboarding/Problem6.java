package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> result;
        HashMap<String, HashSet<String>> nicknameMap = new HashMap<>();
        HashSet<String> answer = new HashSet<>();

        for(List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);

            ArrayList<String> nicknames = separate(nickname);
            for(String str : nicknames) {
                HashSet<String> emails;
                if (nicknameMap.containsKey(str)) {
                    emails = nicknameMap.get(str);
                }else {
                    emails = new HashSet<>();
                }
                emails.add(email);
                nicknameMap.put(str, emails);
            }
        }

        List<Map.Entry<String, HashSet<String>>> list = new ArrayList<>(nicknameMap.entrySet());
        list.sort((o1, o2) -> o2.getValue().size() - o1.getValue().size());

        int max = list.get(0).getValue().size();
        for(Map.Entry<String, HashSet<String>> entry : list) {
            if (entry.getValue().size() != max) break;
            answer.addAll(entry.getValue());
        }

        result = new ArrayList<>(answer);
        Collections.sort(result);

        return result;
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
