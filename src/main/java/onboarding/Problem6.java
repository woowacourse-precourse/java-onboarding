package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<ArrayList<String>> check_email(List<List<String>> check) {
        List<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

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

    public static List<String> solution (List<List<String>> forms) {
        List<String> answer = List.of("answer");

        List<ArrayList<String>> checkform = check_email(forms);



        return answer;
    }
}
