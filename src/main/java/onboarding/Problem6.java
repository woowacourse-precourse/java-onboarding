package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String, String> crewInfo = new HashMap<>();
        List<String> answer = new ArrayList<>();

        forms.forEach(form -> {
                    String nickName = form.get(1);
                    String email = form.get(0);
                    checkValidForm(nickName, email);
                    crewInfo.put(nickName, email);
                }
        );

        List<String> nameList = new ArrayList<>(crewInfo.keySet());
        for (String name : nameList) {
            String email = crewInfo.get(name);
            if (!answer.contains(email)) {
                List<String> duplicateNickNameList = getDuplicateNickNames(nameList, name);
                List<String> collect = duplicateNickNameList.stream().map(crewInfo::get).collect(Collectors.toList());
                answer.addAll(collect);
            }
        }
        answer = new ArrayList<>(new HashSet<>(answer));
        Collections.sort(answer);
        return answer;
    }

    private static void checkValidForm(String nickName, String email) {
        if (!nickName.matches("[가-힣]+") || nickName.length() < 1 || nickName.length() >= 20) {
            throw new IllegalArgumentException("닉네임 형식에 부합하지 않습니다");
        }
        if (!email.matches("^[A-Za-z0-9]*@email.com") || email.length() < 11 || email.length() >= 20) {
            throw new IllegalArgumentException("이메일 형식에 부합하지 않습니다");
        }
    }

    private static List<String> getDuplicateNickNames(List<String> nameList, String name) {
        List<String> duplicateNickNameList = getOtherDuplicateNickNames(nameList, name);
        if (!duplicateNickNameList.isEmpty()) {
            duplicateNickNameList.add(name);
        }
        return duplicateNickNameList;
    }

    private static List<String> getOtherDuplicateNickNames(List<String> nameList, String name) {
        int index = 0;
        int count = 2;
        List<String> duplicateNickNameList = new ArrayList<>();
        while (index + count <= name.length()) {
            String subName = name.substring(index, index + count);
            for (String otherName : nameList) {
                if (otherName.equals(name))
                    continue;
                if (otherName.contains(subName))
                    duplicateNickNameList.add(otherName);
            }
            index += 1;
            count += 1;
        }
        return duplicateNickNameList;
    }

}
