package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        try {
            checkCrewLimit(forms.size());
            return answer;
        }catch (Exception e){
            return answer;
        }
    }

    public static void checkCrewLimit(int crew_count) throws Exception {
        if (crew_count<1||crew_count>10000) throw new Exception("인원 제한 초과");
    }

}
