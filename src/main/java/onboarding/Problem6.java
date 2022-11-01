package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        //
        answer = getDuplicateCruEmailList(forms);

        return answer;
    }

    public static List<String> getDuplicateCruEmailList(List<List<String>> forms) {
        //중복된 이메일을 제거하기 위한 Set , 중복닉네임을 가진 사람들의 이메일을 저장한다.
        Set<String> emailList = new HashSet<>();
        //모든 닉네임에 대한 중복검사를 하기위한 반복문 1
        for (int i = 0; i < forms.size(); i++) {
            String currentNickname = forms.get(i).get(1); //현재 닉네임을 저장한다.
            int currentNicknameLength = currentNickname.length(); // 현재 닉네임의 길이를 저장한 변수
            if (currentNicknameLength == 1) { //길이가 1인 닉네임은 볼 필요없으니 다음 인덱스로 넘어간다.
                continue;
            }
            //닉네임을 2문자씩묶는 반복문
            for (int j = 0; j < currentNicknameLength; j++) {
                if (j != currentNicknameLength - 1) { //인덱스가 닉네임의 끝이 아니라면
                    String partOfNickname = currentNickname.substring(j,
                        j + 2); //닉네임을 2글자씩 나눠서 저장한다.

                    for (int k = 0; k < forms.size(); k++)//전체 리스트를 순회하는 반복문
                    {
                        if (k == i) { //같은 닉네임끼리는 비교하지않고 넘어간다.
                            continue;
                        }
                        if (forms.get(k).get(1)
                            .contains(partOfNickname)) { //닉네임이 다른 닉네임의 부분닉네임을 포함하고있는지
                            //중복 닉네임을 가진 두 크루의 이메일을 Set에 추가한다.
                            emailList.add(forms.get(k).get(0));
                            emailList.add(forms.get(i).get(0));
                        }
                    }


                }
            }
        }
        //set을 List로 변환
        List<String> resultEmailList = new ArrayList<>(emailList);
        //오름차순으로 정렬
        Collections.sort(resultEmailList);

        return resultEmailList;

    }

}


