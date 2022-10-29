package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashMap<String, String> part = new HashMap<>(); //닉네임 중복 체크를 위해 닉네임의 파편들을 이메일주소와 함께 저장
        HashSet<String> emailSet = new HashSet<>(); //중복되지 않도록 이메일을 저장

        for(int i = 0; i < forms.size(); i++){
            String nickname = forms.get(i).get(1);
            String email = forms.get(i).get(0);
            if(nickname.length() == 1){
                continue;
            }
            
            //닉네임 중복 확인
            List<String> duplicatedNicknameOwner = checkNicknameDuplication(nickname, email, part);
            //중복된 이메일 저장
            emailSet = addEmail(emailSet, duplicatedNicknameOwner);

            //중복 닉네임이 될 수 있는 단어들(part)을 추출
            List<String> newPart = extractNicknameParts(nickname);
            //추출한 단어들을 저장
            part = addPart(part, newPart, email);
        }
        //set을 list로 변경하여 같은 글자가 연속적으로 포함되는 닉네임을 작성한 지원자의 메일 목록을 반환하는 기능
        List<String> answer = new ArrayList<>(emailSet); //set -> list
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
            part.put(newPart.get(j), email); //추출한 단어 + 이메일
        }
        return part;
    }
}
