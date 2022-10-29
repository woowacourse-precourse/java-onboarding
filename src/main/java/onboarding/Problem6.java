package onboarding;

import onboarding.problem6.NotMatchingCrewSize;
import onboarding.problem6.NotMatchingEmail;
import onboarding.problem6.NotMatchingNickName;
import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        List<String> answer = List.of("answer");

        ArrayList<String> sameNickNameEmail = new ArrayList<>();

        Map<String, Integer> nickNameDivideByTwoLetter = new HashMap<>();

        int crewSize = getCrewSize(forms);

        checkException(forms, crewSize);

        makeNickNameDivideByTwoLetter(forms, nickNameDivideByTwoLetter);

        makeSameNickNameEmail(forms, sameNickNameEmail, nickNameDivideByTwoLetter);

        answer=sameNickNameEmail.stream().sorted().distinct().collect(Collectors.toList());

        return answer;
    }

    private static void makeSameNickNameEmail(List<List<String>> forms, ArrayList<String> sameNickNameEmail, Map<String, Integer> nickNameDivideByTwoLetter) {
        for (List<String> form : forms) {
            String email = form.get(0);
            String nickName = form.get(1);

            for (int i = 0; i < nickName.length()-1; i++) {
                String nickNameDivide = nickName.substring(i,i+2);

                // 3. 크루들 닉네임 확인하면서 두 글자 이상의 문자가 겹치는게 있는지 확인하기
                if(isSameNickName(nickNameDivideByTwoLetter, nickNameDivide)){

                    // 4. 중복 닉네임을 가진 크루 이메일 sameNickNameEmail 에 담기
                    sameNickNameEmail.add(email);
                }
            }
        }
    }

    private static void makeNickNameDivideByTwoLetter(List<List<String>> forms, Map<String, Integer> nickNameDivideByTwoLetter) {
        for (List<String> form : forms) {
            String nickName = form.get(1);
            // 2. 두 글자 이상의 문자가 연속적인 것을 확인하기 위해 교육생의 닉네임을 두 글자씩 끊어서 map 에 넣기
            for (int i = 0; i < nickName.length()-1; i++) {
                String nickNameDivide = nickName.substring(i,i+2);

                if(!isContainNickName(nickNameDivideByTwoLetter,nickNameDivide)){
                    nickNameDivideByTwoLetter.put(nickNameDivide, 1);
                }
                if(isContainNickName(nickNameDivideByTwoLetter, nickNameDivide)){
                    int nickNameCount = nickNameDivideByTwoLetter.get(nickNameDivide);
                    nickNameDivideByTwoLetter.put(nickNameDivide, nickNameCount + 1);
                }

            }
        }
    }

    private static int getCrewSize(List<List<String>> forms) {
        int crewSize=0;
        for (List<String> form : forms) {
            crewSize += form.size();
        }
        return crewSize;
    }

    private static void checkException(List<List<String>> forms, int crewSize) {
        // 예외사항 1-1 크루 인원수 체크
        checkCrewSize(crewSize);

        // 예외사항 1-2,3 이메일 체크 (형식 및 길이)
        checkEmailAndNickName(forms);
    }

    private static void checkEmailAndNickName(List<List<String>> forms) {
        for (List<String> form : forms) {
            String email = form.get(0);
            String nickName = form.get(1);

            if (isNotEmail(email)) {
                throw new NotMatchingEmail("이메일 형식 및 길이가 맞지 않습니다.");
            }
            if (isNotNickName(nickName)) {
                throw new NotMatchingNickName("닉네임이 한글 및 길이가 맞지 않습니다.");
            }

        }
    }

    private static void checkCrewSize(int crewSize) {
        if(isNotMatchingCrewSize(crewSize)){
            throw new NotMatchingCrewSize("크루 인원수가 맞지 않습니다.");
        }
    }

    private static boolean isSameNickName(Map<String, Integer> nickNameDivideByTwoLetter, String nickNameDivide) {
        return nickNameDivideByTwoLetter.get(nickNameDivide) >= 2;
    }

    private static boolean isContainNickName(Map<String, Integer> nickNameDivideByTwoLetter, String nickNameDivide) {
        return nickNameDivideByTwoLetter.containsKey(nickNameDivide);
    }

    private static boolean isNotMatchingCrewSize(int crewSize) {
        return crewSize < 1 || crewSize > 10000;
    }

    // 이메일 형식 체킹 및 전체 길이 체킹
    public static boolean isNotEmail(String email){
        boolean found = true;

        if(StringUtils.isBlank(email)){
            return true;
        }

        String regex = "^[a-zA-Z0-9]{1,9}@email[.]com$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches()) {
            found = false;
        }

        return found;
    }

    // 닉네임 한글 및 길이 체킹
    public static boolean isNotNickName(String name){
        boolean found = true;

        if(StringUtils.isBlank(name)){
            found = true;
        }

        String regex = "^[ㄱ-ㅎㅏ-ㅣ가-힣]{1,19}$";
        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(name);
        if(matcher.matches()){
            found = false;
        }
        return found;
    }
}
