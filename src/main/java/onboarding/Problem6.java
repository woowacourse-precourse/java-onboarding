package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

// 두 글자 이상의 문자가 연속적으로 순서에 맞추어 포함되어 있는 경우 중복으로 간주한다.
// 크루는 1명 이상 10,000명 이하이다.
// 이메일은 이메일 형식에 부합하며, 전체 길이는 11자 이상 20자 미만이다.
// 신청할 수 있는 이메일은 email.com 도메인으로만 제한한다.
// 닉네임은 한글만 가능하고 전체 길이는 1자 이상 20자 미만이다.
// result는 이메일에 해당하는 부분의 문자열을 오름차순으로 정렬하고 중복은 제거한다.

public class Problem6 {
    static final int EMAIL = 0;
    static final int NAME = 1;

    public static List<String> solution(List<List<String>> forms) {
        List<String> emailResultList = new ArrayList<>();
        if (isExceptionCondition(forms)) {
            return null;
        }

        List<String> targetList = null; // 비교 대상
        List<String> otherList = null; // 다른 비교 대상

        String nameTarget = "";
        String emailTarget = "";

        String nameOtherList = "";
        String emailOtherList = "";


        int endIndexSize = forms.size();
        // targetList을 nameTarget, emailTarget 로 분할하는 for문
        for (int first = 0; first < endIndexSize; first++) {
            targetList = forms.get(first);
            nameTarget = targetList.get(NAME);
            emailTarget = targetList.get(EMAIL);

            // otherList을 nameOtherList, emailOtherList 로 분할하는 for문
            for (int second = first + 1; second < endIndexSize; second++) {
                otherList = forms.get(second);
                nameOtherList = otherList.get(NAME);
                emailOtherList = otherList.get(EMAIL);

                // target과 other의 이메일과 이름이 같이 않는가?
                // 여기서 이메일을 주소를 비교를 하는지 메일안에 있는 글만 비교를 해야하는지 고민을 하였다.
                // 사람마다 이메일을 생성을 한후 저장을 한다.
                // 주소비교를 하면 => 두사람이 문자열을 생성을 하여 철저하게 비교를 하는 것을 말하는 것같다.
                if (!isSameEmailAddress(emailTarget, emailOtherList)) {
                    // target 이름 과 other 이름 비교

                    if (isEqualsNameTargetOtherList(nameTarget, nameOtherList)) {
                        addEmailResultList(emailResultList, emailTarget, emailOtherList);
                    }
                } else {
                    System.out.println("이메일이 같습니다.");
                }
            }
        }
        emailResultList = DeduplicationList(emailResultList);
        Collections.sort(emailResultList);
//        System.out.println(emailResultList);
        return emailResultList;
    }

    //    닉네임은 한글만 가능하고 전체 길이는 1자 이상 20자 미만이다.
    private static boolean isExceptionCondition(List<List<String>> forms) {
        boolean isExceptionCondition = true;
        //    크루는 1명 이상 10,000명 이하이다.
        if (forms.size() <= 10000) {
            //    이메일은 이메일 형식에 부합하며, 전체 길이는 11자 이상 20자 미만이다.
            if (isEmailLengthRight(forms)) {
                //    신청할 수 있는 이메일은 email.com 도메인으로만 제한한다.
                if (isEmailFormat(forms)) {
                    isExceptionCondition = false;
                }
            }
        }
        return isExceptionCondition;
    }

    //    신청할 수 있는 이메일은 email.com 도메인으로만 제한한다.
    private static boolean isEmailFormat(List<List<String>> forms) {
        String email = "";
        String subEmail = "";
        boolean isEmailFormat = false;
        Pattern p = Pattern.compile("email.com");

        for (int index = 0; index < forms.size(); index++) {
            email = forms.get(index).get(EMAIL);
            int indexOf = email.indexOf("@");
            subEmail = email.substring(indexOf + 1, email.length());
            Matcher m = p.matcher(subEmail);
            if (m.find()) {
                isEmailFormat = true;
            } else {
                return false;
            }
        }
        return isEmailFormat;
    }

    //    이메일은 이메일 형식에 부합하며, 전체 길이는 11자 이상 20자 미만이다.
    private static boolean isEmailLengthRight(List<List<String>> forms) {
        String email = "";
        boolean isLength = false;
        for (int index = 0; index < forms.size(); index++) {
            List<String> listAtNow = forms.get(index);
            email = listAtNow.get(EMAIL);
            if (email.length() >= 11 && email.length() < 20) {
                isLength = true;
            } else {
                return false;
            }
        }
        if (isLength) {
            return true;
        } else {
            return false;
        }
    }

    private static List<String> DeduplicationList(List<String> emailResultList) {
        emailResultList = emailResultList.stream().distinct().collect(Collectors.toList());
        return emailResultList;
    }

    private static boolean isSameEmailAddress(String emailTarget, String emailOtherList) {
        if (emailTarget == emailOtherList) {
            return true;
        } else {
            return false;
        }
    }

    private static void addEmailResultList(List<String> emailResultList, String emailTarget, String emailOtherList) {
        emailResultList.add(emailTarget);
        emailResultList.add(emailOtherList);
    }

    private static boolean isEqualsNameTargetOtherList(String nameTarget, String nameOtherList) {
        String subTargetStr = "";
        String subOrtherStr = "";
        for (int targetNameIndex = 0; targetNameIndex < nameTarget.length() - 1; targetNameIndex++) {
            subTargetStr = nameTarget.substring(targetNameIndex, targetNameIndex + 2);
            for (int ortherNameIndex = 0; ortherNameIndex < nameOtherList.length() - 1; ortherNameIndex++) {
                subOrtherStr = nameOtherList.substring(ortherNameIndex, ortherNameIndex + 2);
                if (subTargetStr.equals(subOrtherStr)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<List<String>> forms = List.of(List.of("jm@email.com", "제이엠"), List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"), List.of("mj@email.com", "엠제이"), List.of("nowm@email.com", "이제엠"));

        List result = Problem6.solution(forms);
//        System.out.println(forms.toString());
    }
}