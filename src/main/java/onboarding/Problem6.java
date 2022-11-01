package onboarding;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//(2차 리팩토링) 기능 목록
// 리팩토링 이유 : List<List<String>> forms 를 적게 순회 하기 위해 변경함)
//(변경 전) 1. forms돌며,유효한 forms 생성 -> 2.유효forms 돌며, 닉네임마다 dupleSet 생성 -> 3.유효forms돌며, dupleSet과 중복처리
//(변경 후))1. forms돌며,유효한 forms 생성 -> 2.유효forms 돌며, {twochars:이메일} 맵 생성 ->3. 동시에, 중복 처리


public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> answer = new HashSet<>();
        Map<String,String> twoCharMap = new HashMap<>();

        forms.stream()
                .filter(Problem6::isValidForm)
                .forEach(form-> checkDuplicated(form,twoCharMap, answer));

        //3.정렬하기
        List<String> answerList = new ArrayList<>(answer);
        answerList.sort(String::compareTo);
        return answerList;
    }



    //1. 유효한 form만 남기기
    public static boolean isValidForm (List<String> form) {
        if(isValidEmail(form.get(0)) && isValidNickname(form.get(1))) return true;
        return false;
    }

    // 1-1. 이메일 형식체크 : 정규식
    public static boolean isValidEmail(String email) {
        String regex = "^[a-z_0-9]{1,9}(@email.com)$";  //전체 길이 제한, 도메인 형식에 맞게
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        if (m.matches()) return true;
        return false;
    }

    // 1-2. 닉네임 형식체크 :정규식
    public static boolean isValidNickname(String nickname) {
        String regex = "^[ㄱ-ㅎㅏ-ㅣ가-힣]{1,19}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(nickname);
        if (m.matches()) return true;
        return false;
    }




    //2. 닉네임 {두글자:이메일} map만들기 + map에 이미 두글자 있으면, 중복 처리.
    public static void checkDuplicated(List<String>form, Map<String,String>dupleMap,Set<String>answer){
        String email = form.get(0);
        String nickname = form.get(1);

        //닉네임 한번 순회.
        for(int i=0; i< nickname.length()-1 ;i++){
            String twoChars = nickname.substring(i,i+2);
            if(dupleMap.containsKey(twoChars)){
                answer.add(dupleMap.get(twoChars));
                answer.add(email);
                continue;
            }
            dupleMap.put(twoChars, email);
        }
    }




}