package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashMap<String, String> part = new HashMap<>();
        HashSet<String> emailSet = new HashSet<>();

        for(int i = 0; i < forms.size(); i++){
            String nickname = forms.get(i).get(1);
            String email = forms.get(i).get(0);

            if(nickname.length() == 1){
                continue;
            }

            List<String> duplicatedNicknameOwner = checkNicknameDuplication(nickname, email, part);
            emailSet = addEmail(emailSet, duplicatedNicknameOwner);

            List<String> newPart = extractNicknameParts(nickname);
            part = addPart(part, newPart, email);
        }

        List<String> answer = new ArrayList<>(emailSet);
        Collections.sort(answer);
        return answer;
    }

    private static List<String> checkNicknameDuplication(String nickname, String email, HashMap<String, String> part){
        HashSet<String> duplicatedNicknameOwner = new HashSet<>();
        for (String key : part.keySet()) {
            if(nickname.contains(key)){
                duplicatedNicknameOwner.add(email);
                duplicatedNicknameOwner.add(part.get(key));
            }
        }
        return new ArrayList<>(duplicatedNicknameOwner);
    }

    private static List<String> extractNicknameParts(String nickname){
        HashSet<String> part = new HashSet<>();
        for(int j = 0; j < nickname.length() - 1; j++){
            for(int k = j+1; k < nickname.length(); k++){
                String str = nickname.substring(j, k+1);
                part.add(str);
            }
        }
        return new ArrayList<>(part);
    }

    private static HashSet<String> addEmail(HashSet<String> emailSet, List<String> email){
        for(int j = 0; j < email.size(); j++){
            emailSet.add(email.get(j));
        }
        return emailSet;
    }

    private static HashMap<String, String> addPart(HashMap<String, String> part, List<String> newPart, String email){
        for(int j = 0; j < newPart.size(); j++){
            if(part.containsKey(newPart.get(j))){
                continue;
            }
            part.put(newPart.get(j), email);
        }
        return part;
    }
}
