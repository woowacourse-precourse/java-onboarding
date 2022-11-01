package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    /*
    * 두 글자 이상의 문자가 연속적으로 순서에 맞추어 포함되어 있는 경우 중복으로 간주한다.
    * 크루는 1명 이상 10,000명 이하이다. -
    * 이메일은 이메일 형식에 부합하며, 전체 길이는 11자 이상 20자 미만이다. -
    * 신청할 수 있는 이메일은 email.com 도메인으로만 제한한다. -
    * 닉네임은 한글만 가능하고 전체 길이는 1자 이상 20자 미만이다. -
    * result는 이메일에 해당하는 부분의 문자열을 오름차순으로 정렬하고 중복은 제거한다.
    * */
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        // 가입 조건 체크
        if(0 > forms.size() || forms.size() > 10000) {
            throw new RuntimeException("크루의 인원은 1 ~ 10000명 사이 입니다.");
        }else{
            for (List<String> validation: forms) {
                int idx = validation.get(0).indexOf('@');
                String emailCheck = validation.get(0).substring(idx+1);
                if(!emailCheck.equals("email.com")){
                    throw new RuntimeException("이메일 형식에 맞지 않습니다.");
                }
                if(validation.get(0).length() < 11 || validation.get(0).length() >= 20){
                    throw new RuntimeException("이메일의 길이는 최소 11자 이상 ~ 최대 20자 미만 입니다.");
                }
                if(validation.get(1).length() < 1 || validation.get(1).length() > 20){
                    throw new RuntimeException("닉네임은 최소 1글자 이상 ~ 최대 20자 미만입니다.");
                }
            }
        }

        String target = "";
        List<String> result = new ArrayList<>();
        for (List<String> nickName: forms) {
            for (int i = 0; i < nickName.get(1).length(); i++) {
                if ((nickName.get(1).length() - i) != 1) {
                    target = (Character.toString(nickName.get(1).charAt(i))) + (Character.toString(nickName.get(1).charAt(i + 1)));
                    for (int x=0; x < forms.size(); x++) {
                        if(!nickName.get(1).equals(forms.get(x).get(1))){
                            if(forms.get(x).get(1).contains(target)){
                                result.add(forms.get(x).get(0));
                            }
                        }
                    }
                }
            }
        }

        answer= result.stream().distinct().collect(Collectors.toList());
        Collections.sort(answer);
        return answer;
    }
}
