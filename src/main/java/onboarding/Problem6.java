package onboarding;

import java.util.*;

public class Problem6 {
    private static HashMap<String, String> chunk_Email = new HashMap<>();
    private static HashSet<String> emails = new HashSet<>();

    public static List<String> solution(List<List<String>> forms){

        for (List<String> form : forms) {
           String email = form.get(0);
           String nickName = form.get(1);
           checkDuplication(email, nickName);
        }

        List<String> answer = new ArrayList<>(emails);
        Collections.sort(answer);
        return answer;
    }

    //같은 글자가 연속된 닉네임을 지은 경우, 이메일 목록에 추가
    private static void checkDuplication(String email, String nickName){
        String chunk;
        //닉네임 길이가 1일 때 중복 확인
        if (nickName.length()==1) {
            chunk = nickName;
            if (chunk_Email.containsKey(chunk)) {
                emails.add(email);
                emails.add(chunk_Email.get(chunk));
            } else {
                chunk_Email.put(chunk, email);
            }
        //닉네임 길이가 2이상 일 때 중복 확인
        } else {
            for (int i=0; i<nickName.length()-1; i++){
                chunk = nickName.substring(i, i+2);
                if (chunk_Email.containsKey(chunk)) {
                    emails.add(email);
                    emails.add(chunk_Email.get(chunk));
                } else {
                    chunk_Email.put(chunk, email);
                }
            }
        }
    }
}
