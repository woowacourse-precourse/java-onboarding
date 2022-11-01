package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class Problem6 {
    static List<String> emails;
    static List<String> names;
    static List<String> answer;
    static int len;
    static boolean[] stringIncluded;
    public static List<String> solution(List<List<String>> forms) {
        answer = new ArrayList<String>();
        names = new ArrayList<String>();
        emails = new ArrayList<String>();

        // implement 1 : 비교를 위한 이메일 배열과 닉네이 배열 설정
        SetNamesAndEmails(forms);

        // implement 2 : 각 닉네임 간 비교 후 중복 닉네임 처리

        // implement 3 : 중복 닉네임 가진 결과 이메일 배열을 정렬

        return answer;
    }

    // 입력으로부터 유효한 이메일 및 닉네임만 비교 위한 배열에 추가
    static void SetNamesAndEmails(List<List<String>> forms)
    {
        len = forms.size();
        boolean valid;
        for(int i = 0; i < len; ++i)
        {
            valid = isEmailValid(forms.get(i).get(0));
            if(valid == true)
                valid = isNameValid(forms.get(i).get(1));
            if(valid == true)
            {
                emails.add(forms.get(i).get(0));
                names.add(forms.get(i).get(1));
            }
        }
        len = emails.size();
        stringIncluded = new boolean[len];
    }
    // 이메일 형식 준수 여부 확인
    static boolean isEmailValid(String email)
    {
        int alpha = email.indexOf('@');

        if(alpha <= 0) return false; // 11자 미만이면 false
        if(alpha > 10) return false; // 20자 이상이면 false

        // email 형식 틀리면 false, 형식 맞으면 true
        String substr = email.substring(alpha, email.length());
        return substr.equals("@email.com");
    }

    // 닉네임 형식 준수 여부 확인
    static boolean isNameValid(String name)
    {
        // 길이 : 1 ~ 20자 내부인지 확인
        int alpha = name.length();
        if(alpha < 1 || alpha >= 20) return false;

        // 닉네임이 한글인지 확인
        return Pattern.matches("^[ㄱ-ㅎ가-힣]*$", name);
    }

    // 각 닉네임을 비교 : 겹치는 두 자 이상의 문자열이 있으면
    // 겹치는 두 닉네임의 이메일들을 결과 리스트에 추가
    static void CheckDuplicatedNames()
    {
        // implement
        // O(n^2)
        for(int i = 0; i < len; ++i)
            for(int j = i + 1; j < len; ++j)
            {

            }
    }

    // 겹치는 두 자 이상의 문자가 있는지 비교 : 있으면 true , 없으면 false
    static boolean areNamesDuplicated(String name1, String name2)
    {
        // implement : 문자열 비교
        // 첫 번째 문자가 겹치지 않으면 넘기기
        // 두 번째 문자가 겹치지 않으면 넘기기
        // 두 글자가 모두 겹치면 바로 true 반환
        return false;
    }

}