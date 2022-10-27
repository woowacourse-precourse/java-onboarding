package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    static void getOverlapNames(List<List<String>> forms) {
        int size = forms.size();
        List<String> nickNameList = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            inputOverlapName(forms, nickNameList, i);
        }
    }

    static void inputOverlapName(List<List<String>> forms, List<String> nickNameList, int idx) {
        int size = forms.size();

        for (int i = 0; i < size; i++) {
            if (i != idx) {

            }
        }
    }

    static boolean isOverlapName(String name1, String name2) {
        for (int i = 0; i < name1.length() -1; i++) {
            String target = name1.substring(i, i+2);
            if (name2.contains(target)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String name1 = "아이엠제이엠";
        String name2 = "유알제이억";
        System.out.println(isOverlapName(name1, name2));
    }
}
