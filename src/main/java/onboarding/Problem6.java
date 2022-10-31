package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<String> mailList = new ArrayList<>();
        List<List<String>> nameList = new ArrayList<>();

        //mail, name 분리해서 각각 리스트에 넣기
        for (int i = 0; i < forms.size(); i++) {
            String email = forms.get(i).get(0);
            String name = forms.get(i).get(1);
            mailList.add(email);

            String[] stringArr = name.split("");
            List<String> stringList = List.of(stringArr);
            nameList.add(stringList);
        }

        //name을 문자로 분리해서 각각 두개씩 조합해서 리스트에 넣기
        List<List<String>> CombinationListList = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            List<String> split = nameList.get(i);
            List<String> combinationList = new ArrayList<>();
            for (int j = 0; j < split.size() - 1; j++) {
                String combination = split.get(j) + split.get(j + 1);
                combinationList.add(combination);
            }
            CombinationListList.add(combinationList);
        }

        //해당 유저가 전체 리스트에서 중복되는 닉네임이 있는지 확인.
        //ListList를 해당 유저의 닉네임 조합만 빼고 flatten한다.
        for (int person = 0; person < forms.size(); person++) {
            List<String> flatten = new ArrayList<>();
            List<String> nameCombination = CombinationListList.get(person);
            for (int another = 0; another < forms.size(); another++) {
                if (person == another)
                    continue;
                flatten.addAll(CombinationListList.get(another));
            }
            //닉네임 조합이 다른 유저들의 닉네임 조합에 포함되면 mail을 결과에 포함한다.
            for (String str : nameCombination) {
                if (flatten.contains(str))
                    answer.add(mailList.get(person));
            }
        }

        Collections.sort(answer);
        return answer;
    }
}
