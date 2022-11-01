package onboarding;

import java.util.*;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {

        List<String> nameList = separateNames(forms);
        List<String> reduNameList = reduplicatedNames(nameList);
        List<String> emailList = findEmails(reduNameList, forms);

        return emailList;
    }

    /**
     * 두 글자로 분할한 닉네임이 2개 이상인 닉네임을 가진 크루의 이메일 찾기
     * @param reduNameList
     * @param forms
     * @return List<String>
     */
    private static List<String> findEmails(List<String> reduNameList, List<List<String>> forms) {
        List<String> emailList = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            for(int j=0; j<reduNameList.size(); j++) {
                if (forms.get(i).get(1).contains(reduNameList.get(j))) {
                    emailList.add(forms.get(i).get(0));
                }
            }
        }
        Collections.sort(emailList);
        return emailList;
    }

    /**
     * 두 글자로 분할한 닉네임이 2개 이상인 것을 찾기
     * @param nameList
     * @return List<String>
     */
    private static List<String> reduplicatedNames(List<String> nameList) {
        Set<String> resultSet = new HashSet<>();
        for (int i = 0; i < nameList.size() - 1; i++) {

            for (int j = i + 1; j < nameList.size(); j++) {
                if (nameList.get(i).equals(nameList.get(j))) {
                    resultSet.add(nameList.get(i));
                }
            }
        }
        List<String> reduNameList = new ArrayList<>(resultSet);
        return reduNameList;
    }

    /**
     * 닉네임을 두 글자씩 변환
     * @param forms
     * @return List<String>
     */
    private static List<String> separateNames(List<List<String>> forms) {
        List<String> nameList = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            String name = forms.get(i).get(1);
            for (int j = 0; j < name.length() - 1; j++) {
                nameList.add(name.substring(j, j + 2));
            }
        }
        return nameList;
    }
}
