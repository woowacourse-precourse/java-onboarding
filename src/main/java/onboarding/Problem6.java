package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }




    // 닉네임 리스트와 체크리스트를 비교하여 체크리스트 중 중복된 값만 반환하는 메소드
    private static List<String> getDuplicatedWords(List<String> nickNameList, List<String> checkList) {
        List<String> duplicatedWords = new ArrayList<>();
        int[] indexList = new int[checkList.size()];
        Arrays.fill(indexList, 0);
        String duplicatedWord;

        for (String nickName : nickNameList) {

            for (String check : checkList) {
                if (nickName.contains(check)) {
                    int index = checkList.indexOf(check);
                    indexList[index]++;
                }
            }
        }

        for (int i = 0; i < indexList.length; i++) {
            if (indexList[i] > 1) {
                duplicatedWords.add(checkList.get(i));
            }
        }

        return duplicatedWords;
    }


    // 닉네임의 연속된 두 글자를 체크리스트로 반환하는 메소드
    private static List<String> getCheckList(List<List<String>> forms) {
        List<String> nickNameList = getNickNameList(forms);
        Set<String> set = new HashSet<>();

        for (String nickName : nickNameList) {

            for (int i = 0; i < nickName.length() - 1; i++) {
                String needCheck = nickName.substring(i, i+2);
                set.add(needCheck);
            }
        }

        return new ArrayList<>(set);
    }


    // 이메일 리스트를 반환하는 메소드
    private static List<String> getEmailList(List<List<String>> forms) {
        List<String> email = new ArrayList<>();

        for (List<String> form : forms) {
            email.add(form.get(0));
        }

        return email;
    }


    // 닉네임 리스트를 반환하는 메소드
    private static List<String> getNickNameList(List<List<String>> forms) {
        List<String> nickName = new ArrayList<>();

        for (List<String> form : forms) {
            nickName.add(form.get(1));
        }

        return nickName;
    }

}