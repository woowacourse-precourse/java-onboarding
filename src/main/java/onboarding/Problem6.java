package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> email = new ArrayList<>();
        for (List<String> form : forms) {
            email.add(form.get(0));
        }

        List<String> nickName = new ArrayList<>();
        for (List<String> form : forms) {
            nickName.add(form.get(1));
        }

        List<String> redunList = new ArrayList<>();
        List<String> checkList;
        for (int i = 0; i < nickName.size(); i++) {
            checkList = testList(nickName.get(i));
            for (int j = 0; j < nickName.size(); j++) {
                if (i == j) {
                    continue;
                }
                checking(redunList, checkList, nickName.get(j));
            }
        }

        List<String> sendingList = new ArrayList<>();
        for (int i = 0; i < redunList.size(); i++) {
            if (!sendingList.contains(email.get(nickName.indexOf(redunList.get(i))))) {
                sendingList.add(email.get(nickName.indexOf(redunList.get(i))));
            }
        }

        Collections.sort(sendingList);
        List<String> answer = sendingList;
        return answer;

    }

    public static List<String> testList(String nickName) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < nickName.length() - 1; i++) {
            list.add(nickName.substring(i, i + 2));
        }
        return list;
    }

    public static void checking(List<String> redunList, List<String> checklist, String nickName) {
        for (int i = 0; i < checklist.size(); i++) {
            if (nickName.contains(checklist.get(i))) {
                redunList.add(nickName);
            }
        }
    }
}
