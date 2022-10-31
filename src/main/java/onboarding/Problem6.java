package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {

    // 추출한 두 글자 저장(두글자, 원본 이메일)
    static HashMap<String, String> twoSequence = new HashMap<>();
    // 이메일을 중복 추가 방지용 해시맵(email, boolean), true 면 이미 추가된 이메일
    static HashMap<String, Boolean> emailAlreadyAdded = new HashMap<>();
    public static List<String> solution(List<List<String>> forms) {
        return duplicatedNickName(forms);
    }

    public static List<String> duplicatedNickName(List<List<String>> forms){
        List<String> result = new ArrayList<>();

        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);

            // 이메일 도메인이 email.com 이 아니면 스킵
            if (!isValidEmailDomain(email)){
                continue;
            }

            // 이메일을 중복 추가 방지용 해시맵에 추가
            emailAlreadyAdded.put(email, false);

            for (int i = 0; i < nickname.length(); i++) {
                if (i + 1 < nickname.length()) {
                    String sliced = nickname.substring(i, i + 2);

                    // 중복 확인
                    if (twoSequence.containsKey(sliced)) { // 중복이 있으면,
                        // 이메일 추가
                        result.add(email);
                        emailAlreadyAdded.replace(email, true);

                        String originalEmail = twoSequence.get(sliced);
                        // 원본 이메일이 result 에 추가된 적 없다면(value 가 false), result 에 추가 후 value 를 true 로 바꿈
                        if (!emailAlreadyAdded.get(originalEmail)){
                            result.add(originalEmail);
                            emailAlreadyAdded.replace(originalEmail, true);
                        }
                    } else { // 중복이 없으면,
                        // 잘린 단어를 중복 확인용 해시맵에 추가
                        twoSequence.put(sliced, email);
                    }
                }
            }
        }

        // 중복 제거
        List<String> organizedResult = removeDuplicates(result);
        // 오름차순 정렬
        organizedResult.sort(Comparator.naturalOrder());
        return organizedResult;
    }

    public static List<String> removeDuplicates(List<String> list){
        return list.stream().distinct().collect(Collectors.toList());
    }

    public static boolean isValidEmailDomain(String email){
        String[] emailArr = email.split("@");
        return Objects.equals(emailArr[emailArr.length - 1], "email.com");
    }
}
