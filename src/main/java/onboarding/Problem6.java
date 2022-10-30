package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        List<String> nameList = getName(forms);
        List<List<String>> dubPossibilityName = checkNameDup(nameList);
        Integer[] findIndex = findIndex(dubPossibilityName).toArray(new Integer[0]);

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

    public static HashSet<Integer> findIndex(List<List<String>> dubPossibilityName) {
        HashSet<Integer> set = new HashSet<>();

        System.out.println("dubPossibilityName: " + dubPossibilityName);
        for (int i = 0; i < dubPossibilityName.size(); i++) {
            for (int j = 0; j < dubPossibilityName.get(i).size(); j++) {
                String nick = dubPossibilityName.get(i).get(j);
                System.out.println("지금 이 nick 찾기 : " + nick);
                for (int k = 0; k < dubPossibilityName.size(); k++) {
                    for (String n : dubPossibilityName.get(k)){
                        if (nick.equals(n) && i != k) {
                            System.out.println("n" + n);
                            set.add(i);
                        }
                    }
                }
            }
//            for (int j = 0; j < dubPossibilityName.get(i).size(); j++) {
//                System.out.println("dubPossibilityName.get(j) : "+ dubPossibilityName.get(j));
//                System.out.println("dubPossibilityName.get(i).get(j)): "+ dubPossibilityName.get(i).get(j));
//                if (dubPossibilityName.get(j).contains(dubPossibilityName.get(i).get(j))) {
//                    System.out.println("드렁감 " + dubPossibilityName.get(i).get(j));
//                    set.add(i);
//                }
//            }
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
