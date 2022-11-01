package onboarding;

import java.util.*;

public class Problem6 {
    private static Queue<String> q = new LinkedList<>();
    private static final int EMAIL_MAX = 20;
    private static final int EMAIL_MIN = 11;
    private static final int NICKNAME_MAX = 20;
    private static final int NICKNAME_MIN = 1;
    private static final String NICKNAME_REGEX = ".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*";
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9]+\\@+(email\\.com)";

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        checkValidateFormsLength(forms);

        List<String> emailList = new ArrayList<>();
        List<String> nickNameList = new ArrayList<>();
        separateEmailAndNameToList(forms, emailList, nickNameList);
        checkValidateEmailAndName(emailList, nickNameList);

        while(nickNameList.size() > 1) {
            findDuplicateNameCrew(emailList, nickNameList, answer);
        }

        Collections.sort(answer);

        return answer;
    }

    private static void checkValidateFormsLength(List<List<String>> forms) {
        int len = forms.size();
        if(len > 10000 || len < 1) {
            throw new RuntimeException("크루는 1명 이상 10000명 이하만 입력할 수 있습니다.");
        }
    }

    private static void separateEmailAndNameToList(List<List<String>> forms, List<String> emailList, List<String> nickNameList) {
        for(int i = 0; i < forms.size(); i++) {
            emailList.add(forms.get(i).get(0));
            nickNameList.add(forms.get(i).get(1));
        }
    }

    private static void checkValidateEmailAndName(List<String> emailList, List<String> nickNameList) {
        checkValidateEmail(emailList);
        checkValidateNickName(nickNameList);
    }

    private static void checkValidateEmail(List<String> emailList) {
        for(String email : emailList) {
            checkEmailLength(email);
            checkEmailDomain(email);
        }
    }

    private static void checkEmailLength(String email) {
        int len = email.length();
        if(len > EMAIL_MAX || len < EMAIL_MIN) {
            throw new RuntimeException("입력하신 이메일 길이가 범위(11~20)를 벗어납니다. -> " + email);
        }
    }

    private static void checkEmailDomain(String email) {
        if(!email.matches(EMAIL_REGEX)) {
            throw new RuntimeException("이메일 도메인은 @email.com만 가능합니다.");
        }
    }

    private static void checkValidateNickName(List<String> nickNameList) {
        for(String nickName : nickNameList) {
            checkNameLength(nickName);
            checkNameUseOnlyKorean(nickName);
        }
    }

    private static void checkNameLength(String nickName) {
        int len = nickName.length();
        if(len > NICKNAME_MAX || len < NICKNAME_MIN) {
            throw new RuntimeException("입력하신 이름의 길이가 범위(1~20)를 벗어납니다. -> " + nickName);
        }
    }

    private static void checkNameUseOnlyKorean(String nickName) {
        if(!nickName.matches(NICKNAME_REGEX)) {
            throw new RuntimeException("이름은 한글만 허용됩니다. ");
        }
    }

    private static void findDuplicateNameCrew( List<String> emailList, List<String> nickNameList, List<String> answer) {
        String email = null;
        String nickName = null;
        if(q.isEmpty()) {
            email = emailList.remove(0);
            nickName = nickNameList.remove(0);
            putNewInfo("", nickName);
        }

        String compareWords = q.poll();
        int cnt = 0;
        for(int j = 0; j < nickNameList.size(); j++) {
            if (nickNameList.get(j).indexOf(compareWords) != -1) {
                putNewInfo(compareWords, nickNameList.get(j));
                answer.add(emailList.get(j));
                nickNameList.remove(j);
                emailList.remove(j);
                j--;
                cnt++;
            }
        }
        if(cnt > 0) {
            answer.add(email);
        }
    }

    private static void putNewInfo(String compareWords, String nickName) {
        for(int i = 0; i < nickName.length() - 1; i++) {
            if(!compareWords.equals(nickName.substring(i, i + 2))) {
                q.offer(nickName.substring(i, i + 2));
            }
        }
    }
}
