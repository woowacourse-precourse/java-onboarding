package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Problem6 {
    public static ArrayList<ArrayList<String>> check_email(List<List<String>> check) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

        for (int i = 0; i < check.size(); i++) {
            if ((11 <= check.get(i).get(0).length()) && (check.get(i).get(0).length() < 20)) {

                int check_index = check.get(i).get(0).indexOf("@");

                if (check_index != -1 && check.get(i).get(0).substring(check_index + 1, check.get(i).get(0).length()).equals("email.com")) {
                    ArrayList<String> temp_list = new ArrayList<String>();
                    temp_list.add(check.get(i).get(0));
                    temp_list.add(check.get(i).get(1));
                    result.add(temp_list);
                }
            }
        }

        return result;
    }

    public static ArrayList<ArrayList<String>> check_duplicate(ArrayList<ArrayList<String>> check) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ArrayList<Integer> compare_index = new ArrayList<Integer>();

        for (int i = 0; i < check.size() - 1; i++) {
            String base_str = check.get(i).get(1);
            ArrayList<String> base_array = new ArrayList<String>();

            for (int temp_index = 0; temp_index < base_str.length() - 1; temp_index++) {
                base_array.add(base_str.substring(temp_index, temp_index + 2));
            }

            for (int j = i + 1; j < check.size(); j++) {
                String compare_str = check.get(j).get(1);
                for (int k = 0; k < base_array.size(); k++) {
                    if (compare_str.contains(base_array.get(k))) {
                        compare_index.add(j);
                    }
                }
            }

            if (!compare_index.isEmpty()) {
                result.add(check.get(i));

                for (int index : compare_index) {
                    result.add(check.get(index));
                }

                for (int index : compare_index) {
                    check.remove(index);
                }
            }

            compare_index.clear();
        }

        return result;
    }

    public static List<String> get_nickname(ArrayList<ArrayList<String>> check) {
        List<String> result = new ArrayList<String>();

        for (int i = 0; i < check.size(); i++) {
            result.add(check.get(i).get(0));
        }

        Collections.sort(result);

        return result;
    }

    public static List<String> solution (List<List<String>> forms) {
        List<String> answer = List.of("answer");

        ArrayList<ArrayList<String>> checkform = check_email(forms);

        ArrayList<ArrayList<String>> duplicate = check_duplicate(checkform);

        List<String> temp_answer = get_nickname(duplicate);

        answer = temp_answer;

        return answer;
    }
}
