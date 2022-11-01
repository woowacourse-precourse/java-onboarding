package onboarding;

import onboarding.problem6.SubStringMap;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        SubStringMap subStringMap = new SubStringMap(forms);
        return subStringMap.findDuplicate();
    }
}
