package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        List<String> nameList = getName(forms);
        List<List<String>> dubPossibilityName = checkNameDup(nameList);
        Integer[] findIndex = findIndex(dubPossibilityName, nameList).toArray(new Integer[0]);

        for(Integer i : findIndex) {
            answer.add(forms.get(i).get(0));
        }

        Collections.sort(answer);
        return answer;
    }
    public static List<String> getName(List<List<String>> forms) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            if(forms.get(i).get(1).length() > 1) {
                list.add(forms.get(i).get(1));
            }
        }
        return list;
    }
    public static List<List<String>> checkNameDup(List<String> nameList) {
        List<List<String>> getNameChar = new ArrayList<>();
        for (int i = 0; i < nameList.size(); i++) {
            List<String> temp = new ArrayList<>();
            for (int j = 2; j <= nameList.get(i).length(); j++) {
                temp.add(nameList.get(i).substring(j - 2, j)); // endIndex 불포함
            }
            getNameChar.add(temp);
        }
        return getNameChar;
    }

    public static HashSet<Integer> findIndex(List<List<String>> dubPossibilityName,List<String> nameList) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nameList.size(); i++) {
                String nick = nameList.get(i);
//                System.out.println("지금 이 nick 찾기 : " + nick);
                for (int k = 0; k < dubPossibilityName.size(); k++) {
                    for (String n : dubPossibilityName.get(k)){
                        if (nick.contains(n) && i != k) {
//                            System.out.println("n" + n);
                            set.add(i);
                        }
                    }
            }
        }
        return set;
    }

    public static void main(String[] args) {

        System.out.println(solution(List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        )));
    }
}
