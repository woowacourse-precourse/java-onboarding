package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.Comparator;

public class Problem6 {
    /* checkEmail: 이메일형식이 email.com인지 확인하는 함수 */
    public static boolean checkEmail(String email){
        if(email.matches("(.*)@email.com")){
            return true;
        }
        return false;
    }
    /* checkKor: 닉네임이 한글로만 이루어져있는지 확인하는 함수 */
    public static boolean checkKor(String name){
        if(name.matches("[ㄱ-ㅎ가-힣]+")){
            return true;
        }
        return false;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        HashMap<String, String> dict = new HashMap<>(); //닉네임 두글자씩 잘라서 저장

        for(int i=0; i<forms.size(); i++){
            if(!checkEmail(forms.get(i).get(0)) && !checkKor(forms.get(i).get(1))){ //조건 검사
                break;
            }
            String name = forms.get(i).get(1); //닉네임
            String email = forms.get(i).get(0); //이메일
            for(int j=0; j<name.length()-1; j++){
                String subName = name.substring(j, j+2); //닉네임 두글자씩 자르기
                if(dict.containsKey(subName)){ //해당 닉네임이 있다면 해당 닉네임의 이메일과 중복된 닉네임의 이메일 저장
                    answer.add(email);
                    answer.add(dict.get(subName));
                }else{
                    dict.put(subName, email);
                }
            }
        }

        answer = answer.stream().distinct().collect(Collectors.toList()); //중복제거
        answer.sort(Comparator.naturalOrder());//오름차순 정렬

        return answer;
    }
}