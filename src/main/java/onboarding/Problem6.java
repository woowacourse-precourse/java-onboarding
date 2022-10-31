package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<List<String>> neighborNicknameString = new ArrayList<>();
        for (List<String> form : forms) {
            String nickname = form.get(1);
            List<String> neighborNickname = new ArrayList<>();
            for (int i = 0; i < nickname.length() - 1; i++) {
                String nickNameSubset = nickname.substring(i, i + 1);
                neighborNickname.add(nickNameSubset);
            }
            neighborNicknameString.add(neighborNickname);
        }
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < neighborNicknameString.size(); i++) {
            for (int j = 0; j < neighborNicknameString.size(); j++) {
                if (i != j) {
                    for (String neighbor : neighborNicknameString.get(i)) {
                        for (String neighbor2 : neighborNicknameString.get(j)) {
                            if (neighbor.equals(neighbor2)) {
                                indexList.add(i);
                                indexList.add(j);
                            }
                        }
                    }
                }
            }
        }
        System.out.println("indexList = " + indexList);
        System.out.println("neighborNicknameString = " + neighborNicknameString);
        indexList = indexList.stream().distinct().collect(Collectors.toList());

        for (int index : indexList) {
            answer.add(forms.get(index).get(0));
        }
        return answer;
    }

    public static void main(String[] args) {

        List<List<String>> forms = new ArrayList<>();
        forms.add(List.of("jm@email.com", "제이엠"));
        forms.add(List.of("jason@email.com", "제이슨"));
        forms.add(List.of("woniee@email.com", "워니"));
        forms.add(List.of("mj@email.com", "엠제이"));
        forms.add(List.of("nowm@email.com", "이제엠"));

        System.out.println(solution(forms));
    }
}

