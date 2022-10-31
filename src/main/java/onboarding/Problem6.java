package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        // 0. 제한사항의 예외처리
        checkEmail(forms); // email 양식
        checkCrew(forms); // 크루 인원 수
        checkNickname(forms); // 닉네임 양식

        // 1. nickname 만 모아서 String 배열로 반환
        String[] nicknames = returnNickname(forms);

        // 2. 기준이 되는 닉네임을 2글자씩 쪼개서 리스트로 반환한 standard 와
        // 비교 대상이 되는 닉네임을 2글자씩 쪼개서 리스트로 반환한 nickname 을
        // findword 함수로 비교하여 일치한다면 일치하는 두 닉네임의 이메일을 저장
        for(int i = 0; i<nicknames.length; i++) {
            for(int j = i+1; j<nicknames.length; j++) {
                // 기준이 되는 닉네임 쪼개기
                List <String> standard = splitString(nicknames[i]);
                // 비교 대상이 되는 닉네임 쪼개기
                List <String> nickname = splitString(nicknames[j]);
                // standard 와 nickname 을 비교해서 같은 글자가 연속적으로 포함될 경우
                if(findWord(standard, nickname)) {
                    answer.add(forms.get(i).get(0));
                    answer.add(forms.get(j).get(0));
                }
            }
        }

        // 4. 이메일 리스트 중복 항목 제거
        answer = removeDuplication(answer);

        // 5. 이메일 리스트 오름차순 후 리턴
        return sort(answer);
    }

    // nickname 만 모아서 String 배열로 반환하는 함수
    private static String[] returnNickname(List<List<String>> forms) {
        String[] nickname = new String[forms.size()];
        for(int i = 0; i<forms.size(); i++) {
            nickname[i] = forms.get(i).get(1);
        }

        return nickname;
    }

    // 닉네임을 두 글자씩 쪼개서 String 리스트에 저장해서 리턴하는 함수
    /*
    ex) 제이엠 -> 제이, 이엠
     */
    private static List<String> splitString(String nickname) {
        // 글자수 - 1 만큼 사이클 돌면 됨.
        char[] chars = nickname.toCharArray();
        String[] str = new String[chars.length -1];
        for(int i = 0; i<chars.length-1; i++) {
            str[i] = String.valueOf(chars[i]);
            str[i] += chars[i+1];
        }

        return Arrays.asList(str);
    }

    // 닉네임을 두 글자씩 쪼갠 배열(기준)과 비교 대상 닉네임을 두 글자씩 쪼갠 것을 매개변수로 받아서
    // 일치하는 부분이 있는지 비교한 후, 있다면 true 를 리턴함
    private static boolean findWord(List<String> standard, List<String> nickname) {
        for(int i = 0; i< standard.size(); i++) {
            if(nickname.contains(standard.get(i))) {
                return true;
            }
        }
        return false;
    }

    // 이메일 리스트 중복 제거
    private static List<String> removeDuplication(List<String> list) {
        list = list.stream().distinct().collect(Collectors.toList());

        return list;
    }

    // 이메일 리스트 오름차순 정렬
    private static List<String> sort(List<String> input) {
        input.sort(Comparator.naturalOrder());
        return input;
    }

    // 이메일 양식 체크
    private static void checkEmail(List<List<String>> forms) throws IllegalArgumentException {
        for(int i = 0; i<forms.size(); i++) {
            String test = forms.get(i).get(0);
            // 이메일의 길이를 체크하는 것
            boolean length = test.length() >= 11 && test.length() < 20;
            // 이메일의 도메인 제한 체크하는 것
            boolean chars = test.contains("email.com");
            if(!length || !chars) {
                throw new IllegalArgumentException("이메일 양식에 맞추어 입력해주세요.");
            }
        }
    }

    // 크루가 1 명 이상 10,000명 이하인지 체크
    private static void checkCrew(List<List<String>> forms) throws IllegalArgumentException {
        // 등록될 수 있는 크루의 수 예외처리
        if(!(forms.size() >= 1 && forms.size() <= 10000)) {
            throw new IllegalArgumentException("크루 인원을 초과하였습니다.");
        }
    }

    // 닉네임은 한글만 가능하고, 전체 길이는 1자 이상 20자 미만일 경우 예외처리
    private static void checkNickname(List<List<String>> forms) throws IllegalArgumentException {
        // 정규표현식으로 한글만 허용하는 방법
        String kr = "^[가-힣]*$";
        // List 의 닉네임 열을 차례대로 체크하는 것
        for(int i = 0; i<forms.size(); i++) {
            String test = forms.get(i).get(1);
            // 현재 닉네임이 한글로만 되었는지 || 닉네임의 글자수
            // 둘 중 하나라도 false 가 나오면 Exception 발생
            if(!test.matches(kr) || !(test.length() >= 1 && test.length() < 20)) {
                throw new IllegalArgumentException("닉네임은 1자 이상 20자 미만의 한글로만 입력 가능합니다.");
            }
        }
    }
}
