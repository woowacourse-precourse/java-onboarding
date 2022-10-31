package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Problem6 {
    // 적합한 이메일 형식인지 판단하는 함수
    public static List<List<String>> email_check(List<List<String>> check) {
        List<List<String>> correct_result = new ArrayList<List<String>>();

        for (int i = 0; i < check.size(); i++) {
            if ((11 <= check.get(i).get(0).length()) && (check.get(i).get(0).length() < 20)) {
                int check_index = check.get(i).get(0).indexOf("@");

                if (check_index != -1 && check.get(i).get(0).substring(check_index + 1, check.get(i).get(0).length()).equals("email.com")) {
                    List<String> temp_list = new ArrayList<String>();
                    temp_list.add(check.get(i).get(0));
                    temp_list.add(check.get(i).get(1));
                    correct_result.add(temp_list);
                }
            }
        }

        return correct_result;
    }

    // 글자 중복을 확인하는 함수
    public static List<List<String>> check_duplicate(List<List<String>> check_forms) {
        List<List<String>> remove_duplicate_forms = new ArrayList<List<String>>();
        List<Integer> duplicate_index = new ArrayList<Integer>();

        for (int i = 0; i < check_forms.size() - 1; i++) {
            String base_str = check_forms.get(i).get(1);
            List<String> base_array = new ArrayList<String>();

            for (int temp_index = 0; temp_index < base_str.length() - 1; temp_index++) {
                base_array.add(base_str.substring(temp_index, temp_index + 2));
            }

            for (int j = i + 1; j < check_forms.size(); j++) {
                String compare_str = check_forms.get(j).get(1);
                for (int k = 0; k < base_array.size(); k++) {
                    if (compare_str.contains(base_array.get(k))) {
                        duplicate_index.add(j);
                    }
                }
            }

            Set<Integer> duplicate_set = new HashSet<Integer>(duplicate_index);
            List<Integer> duplicate_list = new ArrayList<>(duplicate_set);
            Collections.sort(duplicate_list);

            if (!duplicate_list.isEmpty()) {
                remove_duplicate_forms.add(check_forms.get(i));

                for (int index : duplicate_list) {
                    remove_duplicate_forms.add(check_forms.get(index));
                }

                int check_remove = 0;
                for (int index : duplicate_list) {
                    index = index - check_remove;
                    check_forms.remove(index);
                    check_remove += 1;
                }

                duplicate_index.clear();
            }
        }

        return remove_duplicate_forms;
    }

    // 닉네임을 가져와 정렬하는 함수
    public static List<String> get_nickname(List<List<String>> remove_duplicate_forms) {
        List<String> nicknames = new ArrayList<String>();

        for (int i = 0; i < remove_duplicate_forms.size(); i++) {
            nicknames.add(remove_duplicate_forms.get(i).get(0));
        }

        Collections.sort(nicknames);

        return nicknames;
    }

    // 작동 함수
    public static List<String> solution (List<List<String>> forms) {
        List<String> answer = List.of("answer");

        List<List<String>> check_forms = email_check(forms);

        List<List<String>> remove_duplicate_forms = check_duplicate(check_forms);

        List<String> nicknames = get_nickname(remove_duplicate_forms);

        answer = nicknames;

        return answer;
    }
}
