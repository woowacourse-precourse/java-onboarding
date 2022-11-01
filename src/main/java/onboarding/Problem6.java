package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 *
 * Class : Problem 6
 *
 * Date : 2022.10.30
 *
 * Author : kathyleesh
 *
 * <기능 목록>
 *
 * 1. 신청할 수 있는 이메일은 email.com 도메인으로만 제한하고 전체 길이는 11자 이상 20자 미만으로 제한한다.
 * 2. 닉네임은 한글만 가능하고 전체 길이는 1자 이상 20자 미만으로 제한한다.
 * 3. 크루의 실험군과 대조군을 만들어 중복 검사를 시작한다.
 * 4. 실험군의 크루의 닉네임을 2글자씩 쪼개며 대조군에 있는지 검사를 한다.
 * 5. 중복된 닉네임이 있는 크루가 있으면 실험군의 크루와 대조군의 크루의 이메일을 모두 리스트에 저장한다.
 * 6. 같은 글자가 연속적으로 포함 되는 닉네임을 작성한 지원자의 이메일 목록을 오름차순으로 return한다.
 *
 * */

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        List<List<String>> crewList = new ArrayList<>(forms);
        checkException(crewList);

        List<String> doubleNickname = new ArrayList<>();

        // check the nicknames that contain the same characters in succession
        for (int i = 0; i < crewList.size(); i++){
            for (int j = i+1; j < crewList.size(); j++){
                if (checkNickname(crewList.get(i), crewList.get(j))) {
                    if (!doubleNickname.contains(crewList.get(i).get(0))){doubleNickname.add(crewList.get(i).get(0));}
                    if (!doubleNickname.contains(crewList.get(j).get(0))){doubleNickname.add(crewList.get(j).get(0));}
                }
            }
        }

        // sort the list in ascending order
        doubleNickname.sort(Comparator.naturalOrder());
        answer = doubleNickname;
        return answer;
    }

    private static void checkException(List<List<String>> forms){
        for (int i = forms.size() - 1; i >= 0; i--) {
            String regExp = "^[가-힣]*$";
            // verify that the email is 11 to less than 20 and the email format is equal to "email.com"
            if (11 > (forms.get(i).get(0).length()) || (forms.get(i).get(0).length()) >= 20
                    ||!(Arrays.asList(forms.get(i).get(0).split("@")).get(1).equals("email.com"))) {
                //System.out.println(forms.get(i) + " : 이메일은 11자 이상 20자 미만이며, \"email.com\"형식만 가능합니다.");
                forms.remove(i);
            }
            // verify that the nickname is 1 to less than 20 and only available in Korean
            else if (1 > (forms.get(i).get(1).length()) || (forms.get(i).get(1).length()) >= 20
                    || !(forms.get(i).get(1).matches(regExp))){
                //System.out.println(forms.get(i) + " : 닉네임은 1자 이상 20자 미만이며, 한글만 가능합니다.");
                forms.remove(i);
            }
        }
    }

    private static boolean checkNickname(List<String> experimentalList, List<String> controlList){
        String experimentalNickname = experimentalList.get(1);
        String controlNickname = controlList.get(1);
        for (int i = 0; i < experimentalNickname.length() - 1; i++ ){
            if (controlNickname.contains(experimentalNickname.substring(i, i + 2))) {
                return true;
            }
        }
        return false;
    }

}
