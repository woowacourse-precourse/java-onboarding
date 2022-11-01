package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * 1. for loop 두개로 모든 서로 다른 두개의 이름을 비교한다.
 * 2. 하나의 이름의 두개의 연속되 문자를 앞에서부터 순서대로 검새해서 그 문자열이 나머지 이름의 문자열에 포함되어 있는지 검사
 *    있다면, answer에 해당하는 두 이름의 이메일들을 저장
 * 3. treeset으로 이메일 정렬 및 중복 제거
 * 4. list에 treeset 복사 및 list반환
 */
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        // 1. for loop 두개로 모든 서로 다른 두개의 이름을 비교한다.
        for(int i=0;i<forms.size();i++){
            for(int j=i+1;j< forms.size(); j++){
                String nName1 = forms.get(i).get(1);
                String nName2 = forms.get(j).get(1);

                // 2. 하나의 이름의 두개의 연속되 문자를 앞에서부터 순서대로 검새해서 그 문자열이 나머지 이름의 문자열에 포함되어 있는지 검사
                //    포함되어 있다면, answer에 해당하는 두 이름의 이메일들을 저장
                for(int k=0;k<nName1.length();k++){
                    if(k!=nName1.length()-1){
                        if(nName2.contains(
                                String.valueOf(nName1.charAt(k))+(nName1.charAt(k+1)))){
                            answer.add(forms.get(i).get(0));
                            answer.add(forms.get(j).get(0));
                        }
                    }
                }
            }
        }

        // 3. treeset으로 이메일 정렬 및 중복 제거
        TreeSet<String> treeSet = new TreeSet<>();
        for(String item : answer){
            treeSet.add(item);
        }

        // 4. list에 treeset 복사 및 list반환
        answer = List.copyOf(treeSet);

        return answer;
    }
}
