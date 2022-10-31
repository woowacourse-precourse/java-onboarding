package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static void catchException(List<List<String>> list) {
        assert (list.size() >= 1);
        assert (list.size() <= 10000);
        for (int i = 0; i < list.size(); i++) {
            assert (list.get(i).get(0).length() >= 11);
            assert (list.get(i).get(0).length() < 20);
            assert list.get(i).get(0).substring(list.get(i).get(0).length() - 9).equals("email.com");
            assert list.get(i).get(1).length() >= 1;
            assert list.get(i).get(1).length() < 20;
            assert list.get(i).get(1).matches("^[가-힣]*$");
        }
    }

    public static List<String> extractNickname(List<List<String>> list) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            result.add(list.get(i).get(1));
        }
        return result;
    }

    public static List<String> splitTwoWord(String name) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < name.length() - 1; i++) {
            result.add(name.substring(i, i + 2));
        }
        return result;
    }

    public static boolean compareDuplication(List<String> comp1, List<String> comp2) {
        for (int i = 0; i < comp1.size(); i++) {
            for (int j = 0; j < comp2.size(); j++) {
                if (comp1.get(i).equals(comp2.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static List<Integer> findSimilarNickname(List<String> list) {
        List<String> comp1, comp2;
        List<Integer> similarIndexList = new ArrayList<>();
        for (int i = 0; i < list.size() - 1; i++) {
            comp1 = splitTwoWord(list.get(i));
            for (int j = i + 1; j < list.size(); j++) {
                comp2 = splitTwoWord(list.get(j));
                if (compareDuplication(comp1, comp2)) {
                    similarIndexList.add(i);
                    similarIndexList.add(j);
                }
            }
        }
        return similarIndexList;
    }

    public static List<String> solution(List<List<String>> forms) {
        catchException(forms);
        List<Integer> answerIndex = findSimilarNickname(extractNickname(forms));
        List<String> answerDup = new ArrayList<>();
        for (int i = 0; i < answerIndex.size(); i++) {
            answerDup.add(forms.get(answerIndex.get(i)).get(0));
        }
        List<String> answer = answerDup.stream().distinct().collect(Collectors.toList());
        answer.sort(Comparator.naturalOrder());
        return answer;
    }
}
