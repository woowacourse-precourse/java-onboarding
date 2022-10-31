package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
         List<ArrayList<String>> checkform = checkEmail(forms);

        return answer;
    }
    public static List<ArrayList<String>> checkEmail(List<List<String>> check) {
        List<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

        for (int i = 0; i < check.size(); i++) {
            if ((11 <= check.get(i).get(0).length()) && (check.get(i).get(0).length() < 20)) {

                int checkIndex = check.get(i).get(0).indexOf("@");

                if (checkIndex != -1 && check.get(i).get(0).substring(checkIndex + 1, check.get(i).get(0).length()).equals("email.com")) {
                    ArrayList<String> tempList = new ArrayList<String>();
                    tempList.add(check.get(i).get(0));
                    tempList.add(check.get(i).get(1));
                    result.add(tempList);
                }
            }
        }

}
