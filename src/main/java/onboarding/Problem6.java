package onboarding;

import java.util.*;

/*
맨 위에 친구부터 앞 글자씩 다른 친구들의 글자와 같은지 검사
글자 하나가 매칭됐을때 다음 글자가 같은지 검사
같으면 set에 두 사람의 번호를 추가함.
 */
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < forms.size()-1; i++) { // 친구들 돌기
            String[] strs = forms.get(i).get(1).split("");
            target:
            for (int j = i+1; j < forms.size(); j++) { // target생성
                String[] targets = forms.get(j).get(1).split("");
                for (int k = 0; k < strs.length-1; k++){ //strs 분할
                    for (int l = 0; l < targets.length - 1; l++) {
                        if (strs[k].equals(targets[l])) { // 글자가 처음 같을 때
                            if (strs[k + 1].equals(targets[l + 1])) { // 처음 글자가 같고 그 다음도 같을 때
                                set.add(i);
                                set.add(j);
                                break target;
                            }
                        }
                    }
                }
            }
        }

        for(int t : set) {
            answer.add(forms.get(t).get(0));
        }
        Collections.sort(answer);
        return answer;
    }
}
