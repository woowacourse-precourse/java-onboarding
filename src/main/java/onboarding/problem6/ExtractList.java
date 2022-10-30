package onboarding.problem6;

import java.util.ArrayList;
import java.util.List;

public class ExtractList {
    public static List<String> extractEmail(List<List<String>> forms) {
        List<String> emailList = new ArrayList<>();

        for (List<String> form : forms) {
            emailList.add(form.get(0));
        }

        return emailList;
    }

    public static List<String> extractNickname(List<List<String>> forms) {
        List<String> nicknameList = new ArrayList<>();

        for (List<String> form : forms) {
            nicknameList.add(form.get(1));
        }

        return nicknameList;
    }
}
