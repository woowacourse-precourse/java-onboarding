package onboarding;

import onboarding.problem6.NicknameDuplicationManage;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        NicknameDuplicationManage nicknameDuplicationManage = new NicknameDuplicationManage(forms);
        List<String> answer = nicknameDuplicationManage.start();
        return answer;
    }
}