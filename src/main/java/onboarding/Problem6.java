package onboarding;

import java.util.*;
import java.util.stream.Collectors;

class validationInfo{// 크루 정보 예외사항 확인
    public static boolean isValidEmail(String email) {
        if ((email.length() < 1) || (email.length() >= 20)) {
            return false;
        }
        if (!email.endsWith("@email.com")) {
            return false;
        }
        return true;
    }

    public static boolean isValidNickName(String nickName) {
        if ((nickName.length() < 1) || (nickName.length() >= 20)) {
            return false;
        }
        if (!nickName.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) {
            return false;
        }
        return true;
    }
}
class Crew{
    private List<List<String>> crewInfo = new ArrayList<>();

    public List<String> findSimilarNickNameEmailList() {
        Map<String, Integer> usingName = new HashMap<>();
        List<String> havaSimilarNameEmails = new ArrayList<>();
        List<String> nickNames = new ArrayList<>();
        nickNames = getNickNames(crewInfo);
        for (String nickName : nickNames) {// hashmap에 분할한 닉네임들 저장
            splitUsingNickName(usingName, nickName);
        }

        List<String> usingNickNames = getUsingNickName(usingName);
        for(String usingNickName : usingNickNames){
            List<String> email = findSimilarNickNameEmail(crewInfo, usingNickName);
            havaSimilarNameEmails.addAll(email);
        }
        return  havaSimilarNameEmails;
    }

    public List<String> findSimilarNickNameEmail(List<List<String>> crewInfo, String similarNickName){
        return crewInfo.stream()
                .filter(info -> info.get(1).contains(similarNickName))
                .map(info-> info.get(0))
                .sorted()
                .collect(Collectors.toList());
    }


    private static void splitUsingNickName(Map<String, Integer> usingName, String nickname) {// 닉네임 2글자씩 자름
        int length = nickname.length();
        int sequence = 0;
        while (sequence < length - 1) {
            String usingNickname = nickname.substring(sequence, sequence + 2);
            saveUsingNickName(usingName, usingNickname);// hash map에 저장
            sequence++;
        }
    }

    private static void saveUsingNickName(Map<String, Integer> usingName, String splitNickname) {
        Set<String> splitNicknames = usingName.keySet();
        int count = 1;
        if (splitNicknames.contains(splitNickname)) {
            count = usingName.get(splitNickname) + 1;
        }
        usingName.put(splitNickname, count);
    }

    private static List<String> getNickNames(List<List<String>> crewInfo) {
        return crewInfo.stream()
                .map(form -> form.get(1))
                .collect(Collectors.toList());
    }

    private static List<String> getUsingNickName(Map<String, Integer> usingNickName) {
        return usingNickName.keySet().stream()
                .filter(key -> usingNickName.get(key) > 1)
                .collect(Collectors.toList());
    }

    public void setCrewInfo(List<List<String>> crewInfo) {
        this.crewInfo = crewInfo;
    }
}
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Crew crew = new Crew();
        crew.setCrewInfo(forms);
        List<String> answer = crew.findSimilarNickNameEmailList();
        return answer;
    }
}
