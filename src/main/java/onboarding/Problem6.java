package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem6 {
    /*
    1. 예외처리
      - email.com 인가
      - 닉네임이 한글인가
      - 닉네임의 글자가 1~19 인가
      - 이메일의 글자가 11~19 인가
    2. 두글자를 연속적으로 저장
    3. 두글자가 연속적으로 있는 경우 찾기
       - 있을 경우 checkAlreadyIn에 true로 변경
    4. checkAlreadyIn에 true로 변경된 값의 index를 emailInfoMap<index, email> 에서 key값을 통해 email을 가져옴
    5. 오름차순으로 정렬하고 중복 제거 후 출력
     */

    private static final int EMAIL = 0;
    private static final int NICK_NAME = 1;
    private static boolean[] checkAlreadyIn;
    private static HashMap<String, Integer> consecutiveNickName;
    private static HashMap<Integer, String> emailInfoMap;

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        consecutiveNickName = new HashMap<>();
        emailInfoMap = new HashMap<>();
        checkAlreadyIn = new boolean[forms.size()];

        if (isError(forms)) {
            answer.add("에러입니다.");
        } else {
            inputFormInfoToMap(forms);
            getDuplicatedEmailList(forms, answer);
            answer = answer.stream().distinct().sorted().collect(Collectors.toList());
        }

        return answer;
    }

    private static boolean isError(List<List<String>> forms) {
        for (List<String> form : forms) {
            if (hasErrorCondition(form)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasErrorCondition(List<String> person) {
        int emailLength = person.get(0).length();
        String[] userEmailInfo = person.get(0).split("@");
        String fullNickName = person.get(1);
        Pattern pattern = Pattern.compile("^[가-힣]*$");
        Matcher matcher = pattern.matcher(fullNickName);

        if (!userEmailInfo[1].endsWith("email.com")) {
            System.out.println("이메일 주소가 잘못되었습니다. ");
            return true;
        } else if (!matcher.find()) {
            System.out.println("닉네임은 한글만 가능합니다.");
            return true;
        } else if (fullNickName.length() < 1 || fullNickName.length() > 20) {
            System.out.println("닉네임의 전체 길이는 1자 이상 20자 미만 입니다.");
            return true;
        } else if (emailLength < 11 || emailLength > 20) {
            System.out.println("이메일의 전체 길이는 11자 이상 20자 미만 입니다.");
            return true;
        } else {
            return false;
        }
    }

    private static void inputFormInfoToMap(List<List<String>> forms) {
        for (int i = 0; i < forms.size(); i++) {
            consecutiveNickName = saveTwoConsecutiveCharacters(forms.get(i), i);
        }
    }

    private static void getDuplicatedEmailList(List<List<String>> forms, List<String> answer) {
        for (int i = 0; i < forms.size(); i++) {
            findDuplicatedEmailList(answer, i);
        }
    }


    private static HashMap<String, Integer> saveTwoConsecutiveCharacters(List<String> person, int index) {
        int nickNameLength = person.get(NICK_NAME).length();
        emailInfoMap.put(index, person.get(EMAIL));

        for (int nextNameAlphabet = 0; nextNameAlphabet < nickNameLength - 1; nextNameAlphabet++) {
            StringBuilder splitNickName = new StringBuilder();
            String nickName = person.get(NICK_NAME);
            splitNickName.append(nickName.charAt(nextNameAlphabet)).append(nickName.charAt(nextNameAlphabet + 1));
            saveDuplicateNickNameMap(splitNickName, index);
        }
        return consecutiveNickName;
    }

    private static void saveDuplicateNickNameMap(StringBuilder splitNickName, int index) {
        String consecutiveCharacters = splitNickName.toString();
        if (consecutiveNickName.containsKey(consecutiveCharacters)) {
            checkAlreadyIn[consecutiveNickName.get(consecutiveCharacters)] = true;
            checkAlreadyIn[index] = true;
        } else {
            consecutiveNickName.put(consecutiveCharacters, index);
        }
    }

    private static void findDuplicatedEmailList(List<String> duplicateUserList, int index) {
        if (checkAlreadyIn[index]) {
            String email = emailInfoMap.get(index);
            duplicateUserList.add(email);
        }
    }
}
