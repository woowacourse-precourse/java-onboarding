package onboarding;

import java.util.*;

public class Problem6 {

    //<twoChar, 처음으로 twoChar를 가진 크루 이메일> 저장
    private static Map<String, String> twoChar = new HashMap<>();

    //answer에 포함되는 크루 이메일 저장
    private static Set<String > duplicatedAnswer = new HashSet<>();

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        if(detectError(forms))
            return answer;

        for(List<String> form: forms){
            isDuplicateOtherNickname(form);
        }

        answer = new ArrayList<>(duplicatedAnswer);

        Collections.sort(answer);

        return answer;
    }

    private static boolean detectError(List<List<String>> forms){
        for(List<String> l: forms){
            if(l.get(0).length()<11||l.get(0).length()>=20)
                return true;
            if(l.get(1).length()>=20)
                return true;

            String email = l.get(0);
            if(!email.substring(email.length()-10,email.length()).equals("@email.com"))
                return true;
        }

        return false;
    }

    private static void isDuplicateOtherNickname(List<String> form){
        String nickname = form.get(1);
        String email = form.get(0);
        for(int i=0;i<nickname.length()-1;i++){
            String twoC = nickname.substring(i, i+2);

            if(twoChar.containsKey(twoC) && !twoChar.get(twoC).equals(email)){
                duplicatedAnswer.add(email);
                duplicatedAnswer.add(twoChar.get(twoC));
            }
            else {
                storeTwoChar(twoC, email);
            }
        }
    }

    private static void storeTwoChar(String str, String email){
        if(!twoChar.containsKey(str)){
            twoChar.put(str, email);
        }
    }
}
