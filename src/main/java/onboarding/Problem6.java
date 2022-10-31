package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        Set<String> set = new HashSet<String>();
        execCheckDup(forms,set);
        answer = new ArrayList<String>(set);
        Collections.sort(answer);

        return answer;
    }
    //닉네임 중복 확인 함수 실행 함수
    private static void execCheckDup(List<List<String>> forms, Set<String> set ){
        for(int i=0; i<forms.size()-1; i++)
            for(int j=i+1; j<forms.size();j++)
                checkDup(forms.get(i), forms.get(j),set);
    }
    //email주소 확인
    private static void checkEmail(List<String> list,Set<String> set ){
        int idx = list.get(0).indexOf("@");
        String email = list.get(0).substring(idx+1);
        if(email.equals("email.com")&& list.get(0).length()>=11 && list.get(0).length()<20){
            set.add(list.get(0));
        }
    }
    //닉네임 중복 확인 함수
    private static boolean checkDup(List<String> first,List<String> second,Set<String> set ){
        String firstName = first.get(1);
        String secondName = second.get(1);
        for(int i=0; i<firstName.length()-1; i++){
            String subFirstName = firstName.substring(i,i+2);
            for(int j=0; j<secondName.length()-1; j++){
                String subSecondName = secondName.substring(j,j+2);
                if(subFirstName.equals(subSecondName)){

                    checkEmail(first,set);
                    checkEmail(second,set);
                }
            }
        }
        return true;
    }
}
