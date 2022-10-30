package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        //Set는 중복 데이터를 알아서 필터링함
        //입력 순서는 고려되지 않음
        Set<String> result = new HashSet<>();

        //이메일, 닉네임 정규표현식
        String emailRegex = "^[0-9a-zA-Z]{1,9}@email.com";
        String nicknameRegex = "^[가-힣]{1,19}";

        //이메일, 닉네임 유효성 검사
        for(int i = 0 ; i < forms.size() ; i++){
            //이메일 유효성
            if(!forms.get(i).get(0).matches(emailRegex)){
                forms.remove(i);
                i--;
                continue;
            }
            //닉네임 유효성
            if(!forms.get(i).get(1).matches(nicknameRegex)){
                forms.remove(i);
                i--;
            }
        }

        //forms의 첫 번째 원소부터 마지막 이전 원소까지 도는 루프
        //마지막 원소는 비교할 대상이 없으므로 제외
        for(int i = 0 ; i < forms.size() - 1 ; i++){
            //닉네임이 외자인 경우 제외
            if(forms.get(i).get(1).length() == 1) continue;
            //forms의 각 원소의 닉네임을 2글자씩 뽑아내는 루프
            for(int j = 0 ; j < forms.get(i).get(1).length() - 1 ; j++){
                String subStr = forms.get(i).get(1).substring(j,j+2);
                //닉네임 2글자와 일치하는 forms의 원소 탐색
                //일치하는 원소의 이메일을 result 세트에 추가
                for(int k = i + 1 ; k < forms.size() ; k++ ){
                    if(forms.get(k).get(1).contains(subStr)) {
                        result.add(forms.get(i).get(0));
                        result.add(forms.get(k).get(0));
                    }
                }
            }
        }

        //Set을 List로 변환
        List<String> answer = new ArrayList<>(result);
        //오름차순 정렬
        Collections.sort(answer);

        return answer;
    }
}
