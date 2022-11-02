package onboarding;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        if(isEmailFormatArgumentException(forms)){
            throw new IllegalArgumentException("이메일 양식을 다시 확인하여 주십시오.");
        }
        if(isNicNameFormatArgumentException(forms)){
            throw new IllegalArgumentException("닉네임 양식을 다시 확인하여 주십시오.");
        }

        Set<String> sendEmailList = new HashSet<>();
        int size = forms.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                String myNicName = forms.get(i).get(1);
                String compareNicName = forms.get(j).get(1);

                if(isDuplicateNicName(myNicName, compareNicName)) {
                    sendEmailList.add(forms.get(i).get(0));
                    sendEmailList.add(forms.get(j).get(0));
                    break;
                }
            }
        }

        return sendEmailList.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private static boolean isNicNameFormatArgumentException(List<List<String>> forms) {
        String nicNameRegex = "^[가-힣]*$"; // 한글만 허용
        Pattern pattern = Pattern.compile(nicNameRegex);
        for (List<String> form : forms) {
            String nicName = form.get(1);
            Matcher checkNicName = pattern.matcher(nicName);
            if(isNotNicNameSize(nicName)){
                return true;
            }
            if(!checkNicName.matches()){
                return true;
            }
        }
        return false;
    }

    private static boolean isNotNicNameSize(String nicName) {
        return nicName.length() < 1 || nicName.length() >= 20;
    }

    private static boolean isEmailFormatArgumentException(List<List<String>> forms) {
        String emailRegex = "^[A-Za-z0-9_.-]+@email.com"; //영문 대소문자 숫자 _.-까지 허용
        Pattern pattern = Pattern.compile(emailRegex);
        for(List<String> form : forms){
            String email = form.get(0);
            Matcher checkEmail = pattern.matcher(email);
            if(isNotEmailSize(email)){
                return true;
            }
            if(!checkEmail.matches()){
                return true;
            }
        }
        return false;
    }

    private static boolean isNotEmailSize(String email) {
        return email.length() < 11 || email.length() >= 20;
    }

    private static boolean isDuplicateNicName(String name, String compare) {
        int nameLen = name.length();
        int compareLen = compare.length();
        for(int m = 1; m < nameLen; m++){
            for(int n = 1; n < compareLen; n++){
                if(name.substring(m-1,m+1).equals(compare.substring(n-1,n+1))){
                    return true;
                }
            }
        }
        return false;
    }
}
