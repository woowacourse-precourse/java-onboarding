package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        // 연속된 2자리 문자열들을 담는 배열
        List<String> con_char = new ArrayList<>();

        // 위의 배열에서 중복으로 나타난 문자열들을 담는 배열
        List<String> rep_char = new ArrayList<>();
        // 각 form의 닉네임을 탐색해 연속된 2자리 문자열로 나누어 모든 경우를 con_char에 저장

        for (int i = 0; i < forms.size(); i++){
            String nick = forms.get(i).get(1);
            // 서로 다른 form에서 연속된 문자열 중복을 확인해야 하므로 같은 form에는 중복된 문자열이 없어야 함
            // 이 과정을 거치지 않으면 예를 들어 제이제이라는 닉네임이 1명 있고 다른 사람과 닉네임이 안 겹치는데 "제이"를 중복으로 인식하게 되는 예외가 발생할 수 있음
            HashSet<String> tempSet = new HashSet<>();

            for (int j = 0; j < nick.length() - 1; j++)
                tempSet.add(nick.substring(j, j+2));

            // 하나의 form에서 나온 서로 다른 연속된 2자리 문자열들을 최종적으로 con_char에 담는 과정
            con_char.addAll(tempSet);
        }

        // 정렬하게 되면 같은 문자열끼리 붙어있게 됨
        con_char.sort(null);

        // 비교할 초기값 설정
        String compare = con_char.get(0);
        // flag : 비교 대상이 중복된 문자열로 rep_char에 들어가야 되는 경우 true
        Boolean flag = false;

        // con_char을 탐색하면서 비교 대상과 현재 탐색하는 문자열이 서로 같은지 확인
        for (int k = 1; k < con_char.size(); k++){
            String temp = con_char.get(k);
            if (compare.equals(temp) == true)
                flag = true;
            // 비교 대상과 다른 문자열이 나왔을 경우
            else{
                // 비교 대상을 현재 탐색한 문자열로 교체하기 전에 비교 대상이 rep_char에 들어가야 되는지 확인
                if (flag){
                    rep_char.add(compare);
                    flag = false;
                }
                compare = temp;
            }
        }

        // 최종 수행 후 마지막 비교 대상이 중복된 문자열로 rep_char에 들어가야 되는지 마지막으로 확인
        if (flag)
            rep_char.add(compare);

        // rep_char의 문자열을 하나씩 forms의 각각의 닉네임에 들어가는지 확인하여 answer에 출력해야 할 이메일 주소 추가
        for (int l = 0; l < rep_char.size(); l++){
            for (int m = 0; m < forms.size(); m++){
                if (forms.get(m).get(1).contains(rep_char.get(l)))
                    answer.add(forms.get(m).get(0));
            }
        }
        
        // 중복된 문자열을 여러 개 가지고 있는 닉네임도 존재할 수 있으므로 answer에서 중복된 이메일 주소 제거
        answer = answer.stream().distinct().collect(Collectors.toList());
        // 이메일 주소를 오름차순으로 정렬
        answer.sort(null);
        return answer;
    }
}
