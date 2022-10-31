package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    static List<String> answer = new ArrayList<>();

    public static List<String> solution(List<List<String>> forms) {
        try {
            doValidation(forms);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return answer;
        }

        logic(forms);
        return answer;
    }

    /**
     * forms 이메일중 예외가 존재하면 exception을 반환합니다.
     * @param {List<List<String>>} forms
     * @throws Exception
     */
    public static void validateEmails(List<List<String>> forms) throws Exception {
        String reg = "[A-Za-z0-9]+@email.com$";

        for (int i = 0; i < forms.size(); i++) {
            String email = forms.get(i).get(0);
            if(email.length() < 11 || 20 <= email.length()) throw new Exception("이메일의 전체 길이는 11자 이상 20자 미만이여야 합니다.");
            if(!email.matches(reg)) throw new Exception("이메일 형식에 맞지 않습니다.");
        }
    }

    /**
     * forms의 닉네임중 예외가 존재하면 exception을 반환합니다.
     * @param {List<List<String>>} forms
     * @throws Exception
     */
    public static void validateNickNames(List<List<String>> forms) throws Exception {
        String reg = "^[ㄱ-ㅎ가-힣]*$";

        for (int i = 0; i < forms.size(); i++) {
            String nickName = forms.get(i).get(1);
            if(nickName.length() < 1 || 20 <= nickName.length()) throw new Exception("닉네임의 길이는 1자 이상 20자 미만이여야 합니다.");
            if(!nickName.matches(reg)) throw new Exception("닉네임은 한글만 가능합니다.");
        }
    }

    /**
     * 입력받은 forms의 닉네임 글자 수 기준으로 오름차순 정렬합니다.
     * @param {List<List<String>>} forms
     * @return {List<List<String>>} forms
     */
    public static List<List<String>> sortFormByNickName(List<List<String>> forms) {
        forms = new ArrayList<>(forms);
        Collections.sort(forms, Comparator.comparingInt(o -> o.get(1).length()));
        return forms;
    }

    /**
     * forms 안의 닉네임 조합들을 compareNickName()에 넣은 후 참이면 answer 리스트에 넣습니다.
     * @param {List<List<String>>} forms
     */
    public static void findDuplicateNickName(List<List<String>> forms) {
        for (int i = 0; i < forms.size() - 1; i++) {
            for (int j = i+1; j < forms.size(); j++) {
                String first_nickName = forms.get(i).get(1);
                String second_nickName = forms.get(j).get(1);

                String first_email = forms.get(i).get(0);
                String second_email = forms.get(j).get(0);

                if(compareNickName(first_nickName, second_nickName)) {
                    if(!answer.contains(first_email)) answer.add(first_email);
                    if(!answer.contains(second_email)) answer.add(second_email);
                }
            }
        }
    }

    /**
     * second_nickName이 first_nickName의 연속된 두 글자를 가지고 있으면 true를 반환 없다면 false 반환
     * @param {String} first_nickName
     * @param {String} second_nickName
     * @return {boolean}
     */
    public static boolean compareNickName(String first_nickName, String second_nickName) {
        for (int i = 0; i < second_nickName.length()-1; i++) {
            String splitWorld = "";
            splitWorld += second_nickName.charAt(i) +""+second_nickName.charAt(i+1);

            if(first_nickName.contains(splitWorld)) return true;
        }
        return false;
    }

    /**
     * 전역변수 answer를 정렬합니다.
     */
    public static void sort() {
        Collections.sort(answer);
    }

    /**
     * answer의 중복을 제거한 뒤 해당 리스트를 반환합니다.
     * @param
     * @return {List<String>} answer
     */
    public static void removeDuplication() {
        answer.stream().distinct().collect(Collectors.toList());
    }

    /**
     * 예외사항 검사 로직들을 실행합니다.
     * @param {List<List<String>>}forms
     * @throws Exception
     */
    public static void doValidation(List<List<String>> forms) throws Exception {
        validateEmails(forms);
        validateNickNames(forms);
    }

    /**
     * 순서에 맞게 요구 사항 기능들을 수행
     * @param {List<List<String>>}forms
     */
    public static void logic(List<List<String>> forms) {
        List<List<String>> sortedForms = sortFormByNickName(forms);
        findDuplicateNickName(sortedForms);
        sort();
        removeDuplication();
    }
}
