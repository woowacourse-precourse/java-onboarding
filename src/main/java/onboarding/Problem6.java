package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class OverlapFilter {
    private List<List<String>> forms;
    private List<String> overlapEmailList = new ArrayList<>();
    private List<String> nameFragList = new ArrayList<>();

    public OverlapFilter(List<List<String>> formsInput){
        this.forms = new ArrayList<>(formsInput);
    }

    public void setOverlapFilterFirst(){
        // overlapEmail 뽑아내기 1트 (중복 단어가 첫번째로 나오는 순간의 email들은 저장이 안됨)

        // 각 크루의 email
        String email;
        // 각 크루의 닉네임을 2개씩 조각내어 나온 String(이하 조각 단어)의 모음 (중복 없음)
        List<String> nameFragList = new ArrayList<>();

        for (int i = 0; i < forms.toArray().length; i++) {
            // 이메일 추출
            email = forms.get(i).get(0);
            for (int j = 0; j < forms.get(i).get(1).length() - 1; j++) {
                // 닉네임을 2글자씩 추출
                String tempString = String.valueOf(forms.get(i).get(1).charAt(j)) + (forms.get(i).get(1).charAt(j + 1));

                // nameFragList에 이미 조각 단어가 있을 경우 해당 조각 단어의 email을 overlapEmailList에 넣기
                if (nameFragList.contains(tempString)) {
                    // 해당 email이 이미 overlapEmailList에 있는 경우 넣지 않음
                    if (!overlapEmailList.contains(email)) {
                        overlapEmailList.add(email);
                    }
                }
                else {
                    nameFragList.add(tempString);
                }
            }
        }
    }

    public void setOverlapFilterSecond(){
        // overlapEmail 뽑아내기 2트 (중복 단어가 첫번째로 나오는 순간의 email들 찾기)

        // 알고리즘은 setOverlapFilterFirst과 동일.
        // 하지만 form을 반대로 한번 더 돌아서 중복 단어가 첫번째로 나오는 순간의 email들을 emailList에 넣어줌
        String email;
        nameFragList = new ArrayList<>();

        for (int i = forms.toArray().length - 1; i >= 0; i--) {
            // 이메일 추출
            email = forms.get(i).get(0);
            for (int j = forms.get(i).get(1).length() - 2; j >= 0; j--) {
                // 닉네임을 2글자씩 추출
                String tempString = String.valueOf(forms.get(i).get(1).charAt(j)) + (forms.get(i).get(1).charAt(j + 1));

                if (nameFragList.contains(tempString)) {
                    if (!overlapEmailList.contains(email)) {
                        overlapEmailList.add(email);
                    }
                }
                else {
                    nameFragList.add(tempString);
                }
            }
        }
    }

    public void sortOverlapEmailList(){
        Collections.sort(overlapEmailList);
    }

    public List<String> getEmailList(){
        // solution 메소드의 answer
        return overlapEmailList;
    }
}

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        OverlapFilter olf = new OverlapFilter(forms);
        // overlapEmail 뽑아내기 1트 (중복 단어가 첫번째로 나오는 순간의 email들은 저장이 안됨)
        olf.setOverlapFilterFirst();
        // overlapEmail 뽑아내기 2트 (중복 단어가 첫번째로 나오는 순간의 email들 찾기)
        olf.setOverlapFilterSecond();
        // overlapEmail 정렬
        olf.sortOverlapEmailList();

        return olf.getEmailList();
    }
}
