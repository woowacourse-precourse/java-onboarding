/**
 * 구현 요구 사항:
 * 신청받은 닉네임 중 같은 글자가 연속적으로 포함 되는 닉네임을 작성한 지원자의 이메일 목록을 return 하도록 solution 메서드를 완성
 * <p>
 * 제한사항:
 * 1. 두 글자 이상의 문자가 연속적으로 순서에 맞추어 포함되어 있는 경우 중복으로 간주한다.
 * 2. 크루는 1명 이상 10,000명 이하이다.
 * 3. 이메일은 이메일 형식에 부합하며, 전체 길이는 11자 이상 20자 미만이다.
 * 4. 신청할 수 있는 이메일은 email.com 도메인으로만 제한한다.
 * 5. 닉네임은 한글만 가능하고 전체 길이는 1자 이상 20자 미만이다.
 * 6. result는 이메일에 해당하는 부분의 문자열을 오름차순으로 정렬하고 중복은 제거한다.
 * <p>
 * 기능 목록:
 * 1. 매개변수로 두 개의 String(닉네임)을 받아서 같은 글자가 연속적으로 포함돼있는지 검사하는 메서드
 * 2. 1.의 메서드 결과 글자가 겹친다면 결과값을 저장하는 Set에 글자가 겹치는 지원자의 이메일을 저장하는 메서드
 * 3. 저장된 결과값 Set를 List로 변환하는 메서드
 */

package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = getDuplicatedEmailList(forms);
        return answer;
    }

    /**
     * forms에서 중복되는 닉네임을 가진 지원자들의 이메일을 저장한 List를 생성하고 반환
     *
     * @param forms 이메일과 nickname이 저장된 List들의 List
     * @return 두 글자 이상이 중복되는 닉네임을 가진 지원자들의 이메일이 저장된 List를 반환
     */
    private static List<String> getDuplicatedEmailList(List<List<String>> forms) {
        TreeSet<String> emailSet = new TreeSet<>(); // 중복되는 닉네임을 가진 지원자들의 이메일 저장

        /*
         * 두 개의 별명을 모든 조합으로 비교하기 위한 반복문
         * ex) A, B, C 세 명의 지원자가 있다면 A-B, A-C, B-C 의 조합 순서로 비교가 수행됨
         */
        for (int i = 0; i < forms.size() - 1; i++) {
            for (int j = i + 1; j < forms.size(); j++) {
                /* 별명끼리 비교 */
                if (isDuplicated(forms.get(i).get(1), forms.get(j).get(1))) {
                    storeEmail(emailSet, forms.get(i).get(0));
                    storeEmail(emailSet, forms.get(j).get(0));
                }
            }
        }

        return new ArrayList<>(emailSet); // List 인스턴스로 변환해서 반환
    }

    /**
     * emailList 집합에 emailAdress를 저장
     *
     * @param emailList    이메일이 저장될 집합
     * @param emailAddress 이메일 주소
     */
    private static void storeEmail(TreeSet<String> emailList, String emailAddress) {
        emailList.add(emailAddress);
    }

    /**
     * 두 개의 닉네임을 매개변수로 전달받아 두 닉네임간에 같은 글자가 연속적으로 포함돼있는지 검사
     *
     * @return 중복이 있다면 true, 그렇지 않다면 false를 반환
     */
    private static boolean isDuplicated(String nickname_1, String nickname_2) {
        boolean duplicateCheck = false;
        String subString = ""; // 이 String이 nickname1과 nickname2에 모두 있다면 중복이 있는것으로 판별

        for (int i = 0; i < nickname_1.length() - 1; i++) {
            /* 두 번째 매개변수에 첫 번째 매개변수와 두 글자가 중복된다면 duplicateCheck를 true로 설정*/
            if (nickname_2.contains(nickname_1.substring(i, i + 2))) {
                duplicateCheck = true;
                break;
            }
        }

        return duplicateCheck;
    }

}
