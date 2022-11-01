package onboarding;

import java.util.List;
import java.util.ArrayList;

public class Problem6 {

    private static List<String> splitNickname(String nickname){
        List<String> splitedList = new ArrayList<>();


        return splitedList;
    }


    private static boolean checkDuplicateList(String names, List<String> splitedList){
        boolean isDuplicate = false;

        return isDuplicate;
    }

    private static List<String> checkUnduplicateList(List<List<String>> undupList, List<String> splitedList){
        List<String> duplicated = new ArrayList<>();

        return duplicated;
    }

    private static List<String> sortList(List<String> emailList){

        return emailList;
    }




    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        String dupNames = "";
        List<List<String>> undupList = new ArrayList<>();

        String nickname, email;
        List<String> splitedList = new ArrayList<>();
        List<List<String>> dupList = new ArrayList<>();

        for(List<String> f:forms){
            email = f.get(0);
            nickname = f.get(1);
            splitedList = splitNickname(nickname);
            if(checkDuplicate(names, splitedList){
                answer.add(email);
                dupNames = dupNames + "\n" + nickname;
            }
            else{
                dupList = checkUnduplicateList(undupList, splitedList);
                if(dupList.size()) > 0){
                    for(List<String> d:dupList){
                        answer.add(d.get(0));
                        dupNames = dupNames + "\n" + d.get(1);
                    }
                }
                else undupList.add(f);
            }

            splitedList.clear();
            dupList.clear();
        }


        return answer;
    }
}
