package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        return getDuplicatedCrewName(forms);
    }

    private static List<String> getDuplicatedCrewName(List<List<String>> forms) {

        return null;
    }

    private static List<String> getParseNameList(List<String> crewInfo) {
        String crewName = crewInfo.get(1);
        List<String> parseNameList = new ArrayList<>();
        for (int i = 0; i < crewName.length() -1; i++) {
            parseNameList.add(crewName.substring(i, i + 1));
        }
        return parseNameList;
    }
}
