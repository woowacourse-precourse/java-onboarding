package onboarding;

import java.util.ArrayList;
import java.util.List;

// [이메일, 닉네임]으로 이루어진 리스트를 받음
// 이메일은 이메일 형식에 맞추어, 11자 이상 20자 미만으로 한다.
// 이메일은 email.com 도메인만 가능
// 닉네임은 한글만 가능하며 1자 이상 20자 미만으로 한다.
// 리스트 내부에서의 닉네임에 같은 글자가 연속적으로 포함된다면
// 해당 지원자의 이메일 목록을 반환
// 이메일 목록은 오름차순으로 정렬하고 중복은 제거

// todo
// 1. 하나의 닉네임을 두글자씩 나눠서 각 두글자가 다른 닉네임에도 있는지 검사
// 1-1. 스트링을 돌면서 각 두글자가 있는지 전체 순회, 있다면 answer 리스트에 해당 form과 현재 form 추가
// 1-2. 이미 지나간 form은 검사하지 않음
// 2. answer 리스트에서 중복을 제거



public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>();

        for(int i = 0; i < forms.size(); i++){
            for(int j = 0; j < forms.get(i).get(1).length()-1; j++){
                for(int k = i+1; k < forms.size(); k++){
                    if (forms.get(k).get(1).contains(forms.get(i).get(1).substring(j, j+2)))
                    {
                        answer.add(forms.get(i).get(0));
                        answer.add(forms.get(k).get(0));
                    }
                }
            }
        }

        System.out.println(answer);
        return answer;
    }
}
