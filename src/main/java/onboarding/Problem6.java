package onboarding;

import onboarding.exception.InputRangeException;
import onboarding.exception.InputTypeException;

import java.util.*;
import java.util.regex.Pattern;

public class Problem6 {
    // 부분 닉네임 문자열과 이메일 정보를 담은 맵이다.
    static Map<String, String> partNameWithEmail;

    // 결과 이메일을 담는 TreeSet이다.
    static Set<String> answer;

    public static List<String> solution(List<List<String>> forms) {
        partNameWithEmail = new HashMap<>();
        answer = new TreeSet<>();

        // 크루의 인원 수에  대해서 검증한다.
        checkCrewNumRange(forms.size());

        for(List<String> form : forms) {
            // 크루들의 이메일과 닉네임 정보를 각각 추출한다.
            String email = form.get(0);
            // 이메일에 대한 도메인 검증을 진행한다.
            checkEmailCond(email);

            String nickname = form.get(1);
            // 닉네임에 대한 조건을 검증한다.
            checkNicknameCond(nickname);

            // 이메일을 한 글자씩 끊어서 배열로 만든다.
            String[] nameArr = nickname.split("");

            // 2글자씩 끊어서 부분 닉네임을 생성한 뒤 중복을 체크한다.
            createPartNicknameAndCheck(email, nameArr);
        }

        // 결과를 오름차순으로 정렬한다.
        List<String> answerList = new ArrayList<>(answer);
        answerList.sort(String::compareTo);

        return answerList;
    }

    /**
     * 닉네임에 대한 형식을 검증한다.
     *
     * @param nickname 입력받은 닉네임
     */
    private static void checkNicknameCond(String nickname) {
        String regex = "^[ㄱ-ㅎㅏ-ㅣ가-힣]{1,19}$";
        if (!Pattern.matches(regex, nickname)) {
            throw new InputRangeException("닉네임은 한글로만 이루어져야 하며, 길이는 1~19자까지 가능합니다.");
        }
    }

    /**
     * 이메일에 대한 형식을 검증한다.
     *
     * @param email 입력받은 이메일
     */
    private static void checkEmailCond(String email) {

        // 이메일은 @email.com 도메인으로 구성되어 있으며, 전체 길이는 11~20자 미만이다.
        // @email.com이 10자이기 때문에, 앞단의 아이디는 1~9자까지 될 수 있다.
        String regex = "^[a-zA-Z0-9]{1,9}@email[.]com$";

        if (!Pattern.matches(regex, email)) {
            throw new InputTypeException("이메일은 11~20자 사이이며, 도메인은 @email.com로 제한되어 있습니다.");
        }

    }

    /**
     * 크루의 인원수에 대해 검증을 진행한다.
     *
     * @param crewSize 입력으로 들어온 crewSize
     */
    private static void checkCrewNumRange(int crewSize) {
        if (crewSize < 1 || crewSize > 10000) {
            throw new InputRangeException("크루는 1~10000명 사이여야 합니다.");
        }
    }

    /**
     * 닉네임 배열로부터 2글자씩 자르고 중복을 체크한다.
     *
     * @param email 사용자의 이메일
     * @param nameArr 사용자의 닉네임 배열
     */
    private static void createPartNicknameAndCheck(String email, String[] nameArr) {
        for (int i = 0; i < nameArr.length-1; i++) {
            String partNickname = nameArr[i] + nameArr[i+1];
            // 부분 닉네임 문자열에 대한 중복 체크를 진행한다.
            checkDuplicatedAndAddResult(email, partNickname);
            partNameWithEmail.put(partNickname, email);
        }
    }

    /**
     * 부분 닉네임 문자열에 대한 중복 체크를 진행한 뒤 결과 Set에 담는다.
     *
     * @param email 사용자의 이메일
     * @param partNickname 사용자의 부분 닉네임 문자열
     */
    private static void checkDuplicatedAndAddResult(String email, String partNickname) {
        if(partNameWithEmail.containsKey(partNickname)) {
            // 해당 사용자의 이메일을 결과 Set에 추가한다.
            answer.add(email);
            // 중복된 부분 문자열을 가진 사용자의 이메일을 결과 Set에 추가한다.
            answer.add(partNameWithEmail.get(partNickname));
        }
    }
}
