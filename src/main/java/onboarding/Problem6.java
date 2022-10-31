package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = answer = new ArrayList<String>();

        if (forms.size()<1 || forms.size()>10000)
            return List.of("answer");

        for(int i = 0; i<forms.size();i++){
            String email = forms.get(i).get(0);
            String nickname = forms.get(i).get(1);

            if (!checkEmailValid(email)){
                return List.of("answer");
            }
            if (!checkNicknameValid(nickname)){
                return List.of("answer");
            }
            for (int k=i+1; k<forms.size();k++){
                answer = getRestrictedUserList(answer,forms.get(i),forms.get(k));
            }
        }
        answer.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        return answer;
    }

    public static boolean checkEmailValid(String email){
        boolean check=true;
        String[] atSplit = email.split("@");
        if (atSplit.length!=2){
            check = false;
            return check;
        }
        if (!atSplit[1].equals("email.com")) {
            check = false;
            return check;
        }
        if (email.length() <11 || email.length()>=20){
            check = false;
            return check;
        }

        return check;
    }

    public static boolean checkNicknameValid(String nickname){
        String regExp = "^[가-힣]*$";
        boolean check=nickname.matches(regExp);

        if (nickname.length()<1 || nickname.length()>=20){
            check = false;
            return check;
        }

        return check;
    }

    public static List<String> getRestrictedUserList(List<String> restritedUsers, List<String> selectedForm,
                                                     List<String> comparedForm) {
        String email = selectedForm.get(0);
        String nickname = selectedForm.get(1);

        for (int j=0;j<selectedForm.get(1).length()-1;j++){
            //만약 이미 중복된 유저 닉네임이라면 다음 닉네임으로 이동
            if (restritedUsers.contains(comparedForm.get(0)))
                break;
            if (comparedForm.get(1).contains(nickname.substring(j,j+2))) {
                //중복될 경우 현재 닉네임과 비교대상 같이 중복자에 추가
                //만약 현재 닉네임 이미 들어가 있다면 비교대상만 추가
                if (!restritedUsers.contains(selectedForm.get(0)))
                    restritedUsers.add(email);
                restritedUsers.add(comparedForm.get(0));
                break;
            }
        }

        return restritedUsers;
    }
}
