package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        try {
            if(!isCorrectInput(forms)) {
                throw new Exception("제한사항에 위배되는 forms형식입니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<String> hasDupNameEmails = findDupNameEmailList(forms);
        List<String> removedDupEmail = removedDupEmail(hasDupNameEmails);
        Collections.sort(removedDupEmail);  //오름차순 정렬
        return removedDupEmail;
    }
    private static boolean isCorrectInput(List<List<String>> forms) {
        if(forms.size()<1||forms.size()>10000) return false;
        for (List<String> form : forms) {
            String email = form.get(0);
            String nickName = form.get(1);

            String[] split = email.split("@");
            if(!split[1].equals("email.com")) return false;
            if(nickName.length()<1||nickName.length()>=20) return false;
            if(email.length()<11||email.length()>=20) return false;
            if (!nickName.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) return false;
        }
        return true;
    }

    private static List<String> findDupNameEmailList(List<List<String>> forms) {
        List<String> hasDupNameEmails = new ArrayList<>();
        for (int student = 0; student < forms.size()-1; student++) {
            String nickName = forms.get(student).get(1);
            for (int comparedStudent = student+1; comparedStudent < forms.size(); comparedStudent++) {
                String comparedNickName = forms.get(comparedStudent).get(1);
                for (int i = 0; i < nickName.length()-1; i++) {
                    for (int j = 0; j < comparedNickName.length()-1; j++) {
                        if(nickName.substring(i,i+2).equals(comparedNickName.substring(j,j+2))){
                            hasDupNameEmails.add(forms.get(student).get(0));
                            hasDupNameEmails.add(forms.get(comparedStudent).get(0));
                        }
                    }
                }
            }
        }
        return hasDupNameEmails;
    }

    private static List<String> removedDupEmail(List<String> emails) {
        HashSet<String> hashSet = new HashSet<>(emails);
        List<String> removedDupEmails = new ArrayList<>(hashSet);
        return removedDupEmails;
    }
}
