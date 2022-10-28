package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> nameByTwo(String compareTarget) {
        List<String> rangeSecondOfNameList = new ArrayList<String>();

        for (int i = 0; i < compareTarget.length() - 1; i++) {
            String rangeSecondOdName = compareTarget.substring(i, i + 2); // (0,2)(1,3)
            rangeSecondOfNameList.add(rangeSecondOdName);
        }
        return rangeSecondOfNameList;
    }

    public static List<String> seperateOfUesrName(List<List<String>> forms){
        List<String> userNameFroms = new ArrayList<>();

        for(int i =0;i< forms.size();i++){
            userNameFroms.add(forms.get(i).get(1));
        }

        return userNameFroms;
    }

    public static boolean[] duplicateJudgiment(List<String> rangeSecondOfNameList, List<String> userNameFroms, boolean[] checkDuplicatedUser, int compareTargetIndex) {


        for(int i =0;i< rangeSecondOfNameList.size();i++){
            String nameOfTwo = rangeSecondOfNameList.get(i);
            checkDuplicatedUser = eachDuplicateJudgiment(nameOfTwo,userNameFroms,checkDuplicatedUser,compareTargetIndex);
        }
            return checkDuplicatedUser;
    }

    public static boolean[] eachDuplicateJudgiment(String nameOfTwo, List<String> userNameFroms, boolean[] checkDuplicatedUser, int compareTargetIndex) {
        for(int i =0;i< userNameFroms.size();i++){
            String userName = userNameFroms.get(i);
            if (userName == null) continue;
            if(userName.contains(nameOfTwo) ==true){
                checkDuplicatedUser[compareTargetIndex] = true;
                checkDuplicatedUser[i] = true;
            }
        }

        return checkDuplicatedUser;
    }

    public static List<String> organizeDuplicateUser(List<String> answer, boolean[] checkDuplicatedUser,List<List<String>> forms){

        for(int i=0;i<checkDuplicatedUser.length;i++){
            String duplicateUserEmail = forms.get(i).get(0);
            if(checkDuplicatedUser[i] == true) answer.add(duplicateUserEmail);
        }

        return answer;
    }
    public static List<String> checkDuplicateEmail(List<String> userEmail){
        Set<String> userEmailSet = new HashSet<>(userEmail);
        List<String> userEmailList = new ArrayList<>(userEmailSet);

        return userEmailList;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<String> userNameFroms = new ArrayList<>();
        boolean[] checkDuplicatedUser = new boolean[forms.size()];
        userNameFroms = seperateOfUesrName(forms);

        for (int i = 0; i < forms.size(); i++) {

            String compareTarget;
            int compareTargetIndex =i;
            userNameFroms.set(i,null);

            List<String> namesByTwoList = new ArrayList<>();
            compareTarget = forms.get(i).get(1);
            namesByTwoList = nameByTwo(compareTarget);

            if(checkDuplicatedUser[i]) continue;

            checkDuplicatedUser = duplicateJudgiment(namesByTwoList,userNameFroms,checkDuplicatedUser,compareTargetIndex);
        }

        organizeDuplicateUser(answer,checkDuplicatedUser,forms);

        answer.sort(Comparator.naturalOrder());
        return answer;
    }
}
