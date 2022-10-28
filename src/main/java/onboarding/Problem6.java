package onboarding;

import onboarding.problem6.NotMatchingCrewSize;
import onboarding.problem6.NotMatchingEmail;
import onboarding.problem6.NotMatchingNickName;
import org.junit.platform.commons.util.StringUtils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        int crewSize=0;

        for (List<String> form : forms) {
            crewSize += form.size();
        }

        // 예외사항 1-1 크루 인원수 체크
        if(isNotMatchingCrewSize(crewSize)){
            throw new NotMatchingCrewSize("크루 인원수가 맞지 않습니다.");
        }

        // 예외사항 1-2,3 이메일 체크 (형식 및 길이)
        for (List<String> form : forms) {
            String email = form.get(0);
            String nickName = form.get(1);

            if (isEmail(email)){
                throw new NotMatchingEmail("이메일 형식 및 길이가 맞지 않습니다.");
            }
            if(isNickName(nickName)){
                throw new NotMatchingNickName("닉네임이 한글 및 길이가 맞지 않습니다.");
            }


        }



        return answer;
    }

    private static boolean isNotMatchingCrewSize(int crewSize) {
        return crewSize < 1 || crewSize > 10000;
    }

    // 이메일 형식 체킹 및 전체 길이 체킹
    public static boolean isEmail(String email){
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
    public static boolean isNickName(String name){
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
