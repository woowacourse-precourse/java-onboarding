package onboarding;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        // 검사 대상 닉네임 문자열 중 이웃한 두 문자만 추출 해 리스트를 만든다
        // 검사 대상 닉네임이 한글자인 경우 한글자 닉네임끼리 비교
        // 추출한 리스트의 문자열을 전체 리스트를 순환하며 검사
        // 중복되는 닉네임이 있을 경우 정답 리스트에 이메일만 추가, forms 리스트에서 삭제
        // 정답 리스트 중복없이 오름차순 정렬, 리턴
        List<String> splitList = new ArrayList<>();
        List<String> emailList = new ArrayList<>();
        List<String> answer = new ArrayList<>();
        for(int i = 0; i < forms.size(); i++) {
            splitList = nickNameSplit(i, forms);
            emailList = chkNicks(splitList, forms);
        }
        Collections.sort(answer); // 제출 전 오름차순 정렬, 대소문자 구분?
        return answer;
    }

    // 검사 대상 닉네임을 이웃한 두글자씩 추출 한 경우의 수를 담은 리스트
    // 닉네임이 한글자 또는 두글자인경우 하나의 경우의수만 리턴
    // 리턴할 리스트의 첫 인덱스는 풀닉네임
    // 리턴값 : splitList
    private static List<String> nickNameSplit(int i, List<List<String>> forms) {

        List<String> splitList = new ArrayList<>(forms.size());
        String nickName = forms.get(i).get(1);
        int length = nickName.length();

        splitList.add(nickName);

        if(length > 1) {
            for(int j = 0; j + 1 < length; j++) {
                splitList.add(nickName.substring(j, j + 2));
            }

            return splitList;
        }

        splitList.add(nickName);

        return splitList;
    }

    // 두글자씩 분리한 닉네임을 forms 리스트에 닉네임들과 비교
    // splitList 의 요소가 forms 요소에 포함되면 해당 이메일을 리턴 해줄 리스트에 추가
    private static List<String> chkNicks(List<String> splitList, List<List<String>> forms) {
        List<String> emailList = new ArrayList<>();
        String ID = splitList.get(0);

        for(int i = 1; i < splitList.size(); i++) {
            for(int j = 0; j < forms.size(); j++) {

                if(forms.get(j).get(1).equals(splitList.get(0))) {
                    continue;
                }

                if(forms.get(j).get(1).contains(splitList.get(i))) {
                    emailList.add(forms.get(j).get(0));
                }
            }
        }

        return emailList;
    }
}
