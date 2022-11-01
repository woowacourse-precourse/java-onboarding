package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<Nickname> nicknameList = new ArrayList<>(forms.size());
        for (List<String> form: forms){
            Nickname nickname = new Nickname(form.get(0), form.get(1));
            nicknameList.add(nickname);
        }
        for (int i = 0; i < nicknameList.size(); i++){
            List<String> token1 = nicknameList.get(i).getToken();
            for (String token: token1) {
                for (int j = i+1; j < nicknameList.size(); j++){
                    List<String> token2 = nicknameList.get(j).getToken();
                    if(token2.contains(token)){
                        answer.add(nicknameList.get(i).getEmail());
                        answer.add(nicknameList.get(j).getEmail());
                    }
                }
            }
        }
        Set<String> set = new HashSet<String>(answer);
        List<String> result = new ArrayList<>(set);
        Collections.sort(result);
        return result;
    }

}
