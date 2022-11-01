package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        // 연속된 두 문자가 중복되는 경우 그 이름들을 지우고 true를 return하는 함수 dupCharacter()

        // String을 추가할 수 있는 ArrayList 클래스인 answer 사용
        List<String> answer = new ArrayList<>();

        List<List<String>> forms_list = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
            forms_list.add(List.of(forms.get(i).get(0), forms.get(i).get(1)));
        }

        int length = forms.size();

        for (int i = 0; i < length; i++) {
            String name = forms.get(i).get(1);
            List<String> char_list = new ArrayList<>();

            for (int j = 0; j < name.length() - 1; j++) {
                StringBuffer word = new StringBuffer(Character.toString(name.charAt(j)));
                word.append(Character.toString(name.charAt(j + 1)));
                char_list.add(word.toString());
            }

            for (int j = 0; j < char_list.size(); j++) {
                System.out.println(char_list.get(j));
                if (dupCharacter(i + 1, forms_list, char_list.get(j))) forms_list.remove(i);
            }

            length = forms_list.size();
        }

        return answer;
    }

    public static boolean dupCharacter(int index, List<List<String>> forms, String word) {

        boolean dup = false;
        boolean total_dup = false;

        while (true) {
            if (index >= forms.size()) break;
            String name = forms.get(index).get(1);

            for (int i = 0; i < name.length() - 1; i++) {
                StringBuffer dup_word = new StringBuffer(Character.toString(name.charAt(i)));
                dup_word.append(Character.toString(name.charAt(i + 1)));
                if (word.equals(dup_word.toString())) {
                    forms.remove(index);
                    dup = true;
                    total_dup = true;
                    break;
                }
            }
            if (! dup) index += 1;
            dup = false;
        }

        return total_dup;
    }

}
