package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Problem6 {
    private static List<String> makeMailList(List<List<String>> forms) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            String email = forms.get(i).get(0);
            list.add(email);
        }
        return list;
    }


    //name을 character로 하나하나 2중배열로 분리.
    private static List<List<String>> makeNameCharList(List<List<String>> forms) {
        List<List<String>> nameCharList = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            String name = forms.get(i).get(1);
            String[] stringArr = name.split("");
            List<String> stringList = List.of(stringArr);
            nameCharList.add(stringList);
        }
        return nameCharList;
    }


    //name을 문자로 분리해서 각각 두개씩 조합해서 리스트에 넣기
    private static List<List<String>> makeCombination(List<List<String>> forms,
                                                      List<List<String>> nameCharList) {
        List<List<String>> combinations = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            List<String> split = nameCharList.get(i);
            List<String> combinationList = new ArrayList<>();
            for (int j = 0; j < split.size() - 1; j++) {
                String combination = split.get(j) + split.get(j + 1);
                combinationList.add(combination);
            }
            combinations.add(combinationList);
        }
        return combinations;
    }

    //해당 유저의 닉네임 조합만 빼고 flatten
    private static List<String> flattenExceptCrew(List<List<String>> forms, int crew,
                                                  List<List<String>> listList) {
        List<String> flatten = new ArrayList<>();
        for (int another = 0; another < forms.size(); another++) {
            if (crew == another)
                continue;
            flatten.addAll(listList.get(another));
        }
        return flatten;
    }

    //닉네임 조합이 다른 유저들의 닉네임 조합에 포함되는지 체크한다.
    private static boolean checkRepeat(List<String> nameCombination, List<String> flatten) {
        boolean repetition = false;
        for (String str : nameCombination) {
            if (flatten.contains(str)) {
                repetition = true;
            }
        }
        return repetition;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        //mail, name 분리해서 각각 리스트에 넣기.
        List<String> mailList = makeMailList(forms);
        List<List<String>> nameCharList = makeNameCharList(forms);

        //name을 문자로 분리해서 각각 두개씩 조합해서 리스트에 넣기
        List<List<String>> CombinationListList = makeCombination(forms, nameCharList);

        //해당 유저가 전체 리스트에서 중복되는 닉네임이 있는지 확인.
        for (int crew = 0; crew < forms.size(); crew++) {
            List<String> nameCombination = CombinationListList.get(crew);
            List<String> flatten = flattenExceptCrew(forms, crew, CombinationListList);
            if (checkRepeat(nameCombination, flatten)) {
                answer.add(mailList.get(crew));
            }
        }

        Collections.sort(answer);
        return answer;
    }
}
