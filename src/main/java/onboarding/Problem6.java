package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        // 1. 닉네임 추출
        // 2. 추출된 닉네임을 2글자단위로 나눈뒤
        // 3. 나누어진 단어를 포함하고 있는지 확인
        // 4. 포함하고 있다면 해당 위치를 가져와
        // 5. 메일 추출
        // 6. 오름차순 정렬

        // forms 사이즈의 Name 배열 선언
        String[] Name = new String[forms.size()];

        // Name 배열에 한글 닉네임 추가
        for (int i = 0; i < Name.length; i++) {
            Name[i] = forms.get(i).get(1);
        }

        // 중복된 경우 해당 위치를 담기 위한 배열 선언
        List<Integer> delNumber = new ArrayList<>();

        // 배열안에 한글 닉네임을 가져와 fullName 으로 선언
        for (int i = 0; i < Name.length; i++) {
            String fullName = Name[i];

            // 가져온 한글 닉네임을 두 글자씩 나누어 splitName 으로 선언
            for (int j = 0; j < fullName.length() - 1; j++) {
                String splitName = fullName.substring(j, j + 2);

                // Name 배열안에 splitName 을 포함하고 있는지 확인
                for (int k = i + 1; k < Name.length; k++) {

                    // 포함하고 있다면 해당 닉네임의
                    // 위치에 값을 dupNumber 에 추가
                    if (Name[k].contains(splitName)) {
                        delNumber.add(k);
                        delNumber.add(i);
                    }
                }
            }
        }

        // 위치 값 중복 제거
        Set<Integer> dupNumberDel = new HashSet<>(delNumber);
        List<Integer> dupNumber = new ArrayList<>(dupNumberDel);

        // 중복된 닉네임이 가지고 있는 메일을 담을 배열 선언
        List<String> answerMail = new ArrayList<>();

        // 중복된 닉네임의 위치를 가지고 있는 dupNumber 를
        // 이용해 해당 메일을 배열에 담는다
        for (int i = 0; i < dupNumber.size(); i++) {
            int location = dupNumber.get(i);
            String mail = forms.get(location).get(0);
            if (mail.contains("email.com")) {
                answerMail.add(mail);
            }
        }

        // 중복 메일 제거
        Set<String> set = new HashSet<>(answerMail);
        List<String> result = new ArrayList<>(set);

        // 메일의 오름차순 정렬
        Collections.sort(result);

        return result;
    }
}
