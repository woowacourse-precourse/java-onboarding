
package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {

    // 중복된 이름을 찾아내는 메서드
    private static List<String> findDuplicatedNickname(List<List<String>> forms, String word, int index){
        List<String> list = new ArrayList<>();
        for(int i=index+1; i< forms.size(); i++){
            if(forms.get(i).get(1).contains(word))
                list.add(forms.get(i).get(0));
        }
        if(list.size()>0)
            list.add(forms.get(index).get(0));
        return list;
    }

    // 중복된 이메일을 삭제하는 메서드
    private static List<String> removeDuplicatedEmail(List<String> list){
        return list.stream().distinct().collect(Collectors.toList());
    }

    // List의 구성요소를 Sorting하는 메서드
    private static List<String> sortList(List<String> list){
        Collections.sort(list);
        return list;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        for(int i=0; i< forms.size(); i++){
            String nickname = forms.get(i).get(1); // 이름을 뽑는다
            for(int j=0; j < nickname.length()-1; j++){
                String word = nickname.substring(j, j+2); // 두 글자씩 뽑아가면서 비교한다
                answer.addAll(findDuplicatedNickname(forms, word, i)); // 중복된 이름을 answer List에 더한다.
            }
        }
        answer = removeDuplicatedEmail(answer); // answer에서 Duplicated된 Email을 제거한다.
        answer = sortList(answer); // 정렬하고
        return answer; // 반환한다.
    }
}