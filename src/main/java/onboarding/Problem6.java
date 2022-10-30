package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Database.validateData(forms);
        Database.setData(forms);
        List<String> answer = getEmailListByCheckNickname();
        return answer;
    }

    static List<String> getEmailListByCheckNickname() {
        List<Integer> duplicatedIndexList = getDuplicatedIndex();
        List<String> duplicatedEmailList = getEmailListByIndexList(duplicatedIndexList);
        List<String> answer = checkEmailList(duplicatedEmailList);
        return answer;
    }
}

class Database {

    static List<String> nameList = new ArrayList<>();
    static List<String> emailList = new ArrayList<>();

    static void setData(List<List<String>> forms) {
        nameList.clear();
        emailList.clear();
        setNameList(forms);
        setEmailList(forms);
    }

    static void setNameList(List<List<String>> forms) {
        forms.stream().forEach(form -> {
            String name = form.get((1));
            nameList.add(name);
        });
    }

    static void setEmailList(List<List<String>> forms) {
        forms.stream().forEach(form -> {
            emailList.add(form.get(0));
        });
    }

    static List<String> getNameList() {
        return nameList;
    }

    static List<String> getEmailList() {
        return emailList;
    }


}