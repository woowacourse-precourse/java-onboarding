package onboarding;

import java.util.List;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem6 {
    //email 유효성 검사
    public static boolean isValidEmail(String email) {
        String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@email.com";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        if(!m.matches()) { //이메일 형식 + email.com 도메인만 허용
            return false;
        }
        if(email.length() < 11 || email.length() > 19) { //11이상 ~ 20 미만
            return false;
        }
        return true;
    }

    //nickName 유효성 검사
    public static boolean isValidNick(String nickName) {
        String regex = "^[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]*$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(nickName);
        if(!m.matches()) { //한글만 허용
            return false;
        }
        if(nickName.length() < 1 || nickName.length() > 19) { //1이상 ~ 20 미만
            return false;
        }
        return true;
    }

    //유효한 forms 생성
    public static List<List<String>> returnValidForms(List<List<String>> forms){
        List<List<String>> validForms = new ArrayList<>();
        for(List<String> user : forms) {
            if(isValidEmail(user.get(0)) && isValidNick(user.get(1))) {
                validForms.add(user);
            }
        }
        return validForms;
    }

    // 닉네임 중복 체크
    public static boolean findDuplicateNick (List<List<String>> forms, int currentIndex) {
        String currentNick = forms.get(currentIndex).get(1);
        for(int i=0; i < forms.size(); i++) {
            if(i == currentIndex) {
                continue;
            }
            for(int j=0; j<currentNick.length()-1; j++) {
                if(forms.get(i).get(1).contains(currentNick.substring(j, j+2))) { //두 문자가 중복이면 중복
                    return true;
                }
            }
        }
        return false;
    }

    //중복 리스트 반환
    public static List<String> returnDuplicationList(List<List<String>> forms){
        List<String> result = new ArrayList<>();

        for(int i=0; i<forms.size(); i++) {
            if(findDuplicateNick(forms, i)) { //닉네임 중복 체크
                result.add(forms.get(i).get(0)); //리스트에 이메일 추가
            }
        }
        return result;
    }

    //중복 제거, 오름차순 정렬
    public static List<String> removeDuplicationAndSort (List<String> originData) {
        TreeSet<String> distinctData = new TreeSet<String>(originData);
        return new ArrayList<String>(distinctData);
    }

    //솔루션 메소드
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        forms = returnValidForms(forms); //유효한 forms 생성
        answer = returnDuplicationList(forms); //중복 리스트 반환
        answer = removeDuplicationAndSort(answer); //중복 제거, 정렬

        return answer;
    }
}
