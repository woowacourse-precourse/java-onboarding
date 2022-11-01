package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashMap<String, HashSet<String>> nicknameMap = new HashMap<>();

        for(List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);

            ArrayList<String> nicknames = separate(email, nickname);
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
        HashSet<String> answer = new HashSet<>();

        for(Map.Entry<String, HashSet<String>> entry : nicknameMap.entrySet()){
            if(entry.getValue().size() >= 2) answer.addAll(entry.getValue());
        }

        List<String> result = new ArrayList<>(answer);
        Collections.sort(result);

        return result;
    }

    public static ArrayList<String> separate(String email,String nickname) {
        ArrayList<String> nicknames = new ArrayList<>();

        if (!email.contains("@email.com")) return nicknames;

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
