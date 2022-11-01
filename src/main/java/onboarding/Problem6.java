package onboarding;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        //제한사항 체크
        try {
            validate(forms);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }

        // 분리된 닉네임들과 어떤 닉네임에서 사용되었는지를 표시하는 List를 함께 Mapping한다.
        Map<String, List<Integer>> stringToDuplicated = makeDuplicatedMap(forms);

        //answer에 담아서 리턴
        List<String> answer = new ArrayList<>(findDuplicatedNickNamesForEmail(stringToDuplicated, forms));

        //오름차순으로 정렬
        Collections.sort(answer);

        return answer;
    }

    //2개 이상의 단어로 분리한 닉네임들과 각 단어마다 어디서 사용되었는지를 표시하는 List Mapping한 변수를 반환
    public static Map<String, List<Integer>> makeDuplicatedMap(List<List<String>> forms) {
        Map<String, List<Integer>> duplicateCheckList = new HashMap<>();

        //중복을 제거하기 위해 Set 사용
        Set<String> divideNickNameSet = makedivideNickNameSet(forms);

        for (String duplicateNickNameCheck : divideNickNameSet) {
            duplicateCheckList.put(duplicateNickNameCheck, findWhereNickNameUsed(duplicateNickNameCheck, forms));
        }

        return duplicateCheckList;
    }

    //중복을 제거하기 위해 Set 사용
    //하나의 닉네임에서 2단어씩 중복없이 나누어 반환
    public static Set<String> divideNickName(String nickName) {
        Set<String> divideSet = new HashSet<>();

        for (int nickNameStartIdx = 0; nickNameStartIdx < nickName.length() - 1; nickNameStartIdx++) {
            divideSet.add(nickName.substring(nickNameStartIdx, nickNameStartIdx + 2));
        }

        return divideSet;
    }

    // forms에 있는 모든 닉네임들에 대해 2단어씩 중복없이 나누어 반환
    public static Set<String> makedivideNickNameSet(List<List<String>> forms) {
        Set<String> divideNickNameSet = new HashSet<String>();

        for (int formIdx = 0; formIdx < forms.size(); formIdx++) {
            divideNickNameSet.addAll(divideNickName(forms.get(formIdx).get(1)));
        }

        return divideNickNameSet;
    }

    // 분리된 단어가 어디에서 사용되었는지 알려주는 List를 반환
    public static List<Integer> findWhereNickNameUsed(String duplicateNickNameCheck, List<List<String>> forms) {
        List<Integer> checkList = new ArrayList<Integer>();

        for (int formsIndex = 0; formsIndex < forms.size(); formsIndex++) {
            if (forms.get(formsIndex).get(1).contains(duplicateNickNameCheck) == true) {
                checkList.add(1);
            } else {
                checkList.add(0);
            }
        }

        return checkList;
    }

    //중복된 닉네임의 이메일을 반환
    public static Set<String> findDuplicatedNickNamesForEmail(Map<String, List<Integer>> stringToDuplicated, List<List<String>> forms) {
        //3글자 이상 겹치면 중복으로 이메일이 출력되는 현상을 막기위해 Set 사용
        Set<String> duplicatedEmails = new HashSet<>();

        for (String check : stringToDuplicated.keySet()) {
            //중복 값이 2개 이상 있는 경우
            if (Collections.frequency(stringToDuplicated.get(check), 1) > 1) {
                //중복 체크된 닉네임의 이메일 주소를 duplicatedEmails에 저장한다.
                for (int i = 0; i < stringToDuplicated.get(check).size(); i++) {
                    if (stringToDuplicated.get(check).get(i) == 1) {
                        duplicatedEmails.add(forms.get(i).get(0));
                    }
                }
            }
        }

        return duplicatedEmails;
    }

    public static void validate(List<List<String>> forms) {
        if (forms.size() < 1 || forms.size() > 10000) {
            throw new IllegalArgumentException("크루원이 1명 이상 10000명 이하가 아닙니다!");
        }

        for (List<String> user : forms) {
            if (user.get(0).length() < 11 || user.get(0).length() >= 20) {
                throw new IllegalArgumentException(user.get(1) + "의" + user.get(0) + "이메일 길이가 11이상 20미만이 아닙니다!");
            }

            // 이메일의 마지막 9자는 항상 도메인인 eamil.com이 되어야 한다.
            if (user.get(0).substring(user.get(0).length() - 9).equals("email.com") == false) {
                throw new IllegalArgumentException(user.get(1) + "의" + user.get(0) + "이메일의 도메인이 email.com이 아닙니다!");
            }

            if (Pattern.matches("^[ㄱ-ㅎ가-힣]*$", user.get(1)) == false) {
                throw new IllegalArgumentException(user.get(1) + "의 닉네임이 한글로만 이루어져 있지 않습니다!");
            }

            if (user.get(1).length() < 1 || user.get(1).length() >= 20) {
                throw new IllegalArgumentException(user.get(1) + "의 닉네임의 길이가 1글자 이상, 20글자 미만이 아닙니다!");
            }

        }

    }
}