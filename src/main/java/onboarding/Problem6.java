package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    static boolean isSimilar(String fir, String sec){
        boolean res = false;
        int idxOfStart = 0;
        int idxOfEnd = 2;
        while(idxOfEnd <= fir.length()){
            String word = fir.substring(idxOfStart, idxOfEnd);
            if(sec.contains(word)){
                res = true;
                break;
            }
            idxOfStart++;
            idxOfEnd++;
        }
        return res;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        // 다른 닉네임과 비슷한 문구가 있는 닉네임들은 isInvalid[i] = true
        List<Boolean> isInvalid = new ArrayList<Boolean>();
        for(int i = 0; i < forms.size(); i++)
            isInvalid.add(false);
        for(int i = 0; i< forms.size(); i++){
            String firName = forms.get(i).get(1);
            if(firName.length() < 2){
                continue;
            }

            for(int j = i+1; j < forms.size(); j++){
                String secName = forms.get(j).get(1);
                boolean similar = isSimilar(firName, secName);
                if(similar){
                    isInvalid.set(i, true);
                    isInvalid.set(j, true);
                }
            }
        }

        // 이메일 모두 answer에 저장
        for(int i = 0; i < forms.size(); i++){
            if(isInvalid.get(i)){
                String email = forms.get(i).get(0);
                answer.add(email);
            }
        }

        // email 오름차순으로 정렬
        Collections.sort(answer);

        return answer;
    }
}
