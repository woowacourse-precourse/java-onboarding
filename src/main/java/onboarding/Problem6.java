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

        // implement 1 : 비교를 위한 이메일 배열과 닉네임 배열 설정
        SetNamesAndEmails(forms);

        // implement 2 : 각 닉네임 간 비교 후 중복 닉네임 처리
        CheckDuplicatedNames();

        // implement 3 : 중복 닉네임 가진 결과 이메일 배열을 정렬
        Collections.sort(answer);

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
        for(int i = 0; i < len; ++i)
            for(int j = i + 1; j < len; ++j)
                if(areNamesDuplicated(names.get(i), names.get(j)) == true)
                {
                    if(stringIncluded[i] == false)
                    {
                        answer.add(emails.get(i));
                        stringIncluded[i] = true;
                    }
                    if(stringIncluded[j] == false)
                    {
                        answer.add(emails.get(j));
                        stringIncluded[j] = true;
                    }
                }
    }

    // 겹치는 두 자 이상의 문자가 있는지 비교 : 있으면 true , 없으면 false
    static boolean areNamesDuplicated(String name1, String name2)
    {
        int len1 = name1.length();
        int len2 = name2.length();

        for(int i = 0; i < len1 - 1; ++i)
        {
            for(int j = 0; j < len2 - 1; ++j)
            {
                if(name1.charAt(i) != name2.charAt(j))
                    continue;
                if(name1.charAt(i+1) != name2.charAt(j+1))
                    continue;
                return true;
            }
        }
        return false;
    }
}