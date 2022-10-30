package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        List<String> nicknameList = new ArrayList<>();
        List<String> emailList = new ArrayList<>();
        List<String> answer = new ArrayList<>();

        List<List<String>> arrayForms = new ArrayList<>(forms);

        // 이메일과 닉네임 분리하여 저장
        for(List<String> form: arrayForms){
            emailList.add(form.get(0));
            nicknameList.add(form.get(1));
        }

        for(int i = 0; i < arrayForms.size(); i++){
            String nickname = nicknameList.get(i);

            for(int j = 0; j < nickname.length() - 1; j++){
                String twoWords = nickname.substring(j, j+2); // 두 글자씩 비교

                for(int k = i + 1; k < nicknameList.size(); k++){
                    String nickname2 = nicknameList.get(k);

                    if(nickname2.contains(twoWords)){
                        answer.add(emailList.get(i));
                        answer.add(emailList.get(k));
                        nicknameList.remove(k);
                        emailList.remove(k);
                        arrayForms.remove(k);
                        k = i;
                    }
                }
            }

            nicknameList.remove(i);
            emailList.remove(i);
            arrayForms.remove(i);
            i = 0;
        }

        // 중복 제거
        Set<String> emailSet = new HashSet<>(answer);
        answer = new ArrayList<>(emailSet);

        // 오름차순 정렬
        Collections.sort(answer);

        return answer;
    }
}
