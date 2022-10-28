package onboarding;

import onboarding.problem6.NotMatchingCrewSize;
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

        //



        return answer;
    }

    private static boolean isNotMatchingCrewSize(int crewSize) {
        return crewSize < 1 || crewSize > 10000;
    }


}
