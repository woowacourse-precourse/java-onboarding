package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = result(forms);
        Collections.sort(answer);
        return answer;
    }

    public static List<String> result(List<List<String>> forms) {
        HashSet<String> result = new HashSet<>();
        int numberOfCrew = forms.size();

        for (int i = 0; i < numberOfCrew - 1; i++) {
            List<String> crew1 = forms.get(i);
            for (int j = i + 1; j < numberOfCrew; j++) {
                List<String> crew2 = forms.get(j);
                if (haveDuplicate(crew1, crew2)) {
                    result.add(crew1.get(0));
                    result.add(crew2.get(0));
                }
            }
        }
        List<String> returnList = new ArrayList<>(result);
        return returnList;
    }

    public static boolean haveDuplicate(List<String> crew1, List<String> crew2) {
        String crew1Nick = crew1.get(1);
        String crew2Nick = crew2.get(1);
        for (int i = 0; i < crew1Nick.length() - 1; i++) {
            for (int j = 0; j < crew2Nick.length() - 1; j++) {
                if (crew1Nick.substring(i, i+2).equals(crew2Nick.substring(j, j+2)))
                    return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        List<List<String>> forms = new ArrayList<>();

        forms.add(List.of(new String[]{"nowm@email.com", "이제엠"}));
        forms.add(List.of(new String[]{"jm@email.com", "제이엠"}));
        forms.add(List.of(new String[]{"jason@email.com", "제이슨"}));
        forms.add(List.of(new String[]{"woniee@email.com", "워니"}));
        forms.add(List.of(new String[]{"mj@email.com", "엠제이"}));

        System.out.println(solution(forms));
    }
}
