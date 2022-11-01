package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class Problem6 {

    // 2. 닉네임 중복 체크
    static boolean getCheckNickName(List<String> basic, List<String> compare) {
        // 기존 문자열 저장
        String word = basic.get(1);

        // 두 글자씩 비교
        for (int strIdx = 0; strIdx < word.length() - 1; strIdx++) {
            String resultSubStr = word.substring(strIdx, strIdx + 2);
            // 두 글자가 비교 문자열에 포함된 경우
            if (compare.get(1).contains(resultSubStr))
                return true;
        }
        return false;
    }

    // 3. 중복 닉네임의 이메일 결과 리스트에 저장하기
    // 4-1 결과 리스트 중복 확인
    static void addResultList(List<String> resultList, String email, String compareEmail) {
        // 리스트 내 중복 확인
        if (!resultList.contains(email))
            resultList.add(email);

        if (!resultList.contains(compareEmail))
            resultList.add(compareEmail);
    }

    // 제한사항 중 넥네임 한글 여부 검사
    static boolean isHangeul(String infoNickName)
    {
        for(int check = 0; check<infoNickName.length(); check++)
        {
            char han = infoNickName.charAt(check);
            if(!(han >= '가' && han <= '힣'))
                return false;
        }
        return true;
    }

    // 5. 제한사항
    static boolean getInfoCheck(List<String> basic) {
        String infoEmail = basic.get(0);
        String infoNickName = basic.get(1);

        // 도메인 형식
        if (!infoEmail.contains("@email.com")) {
            // System.out.println("도메인 형식이 올바르지 않습니다.");
            return false;
        }
        // 이메일 길이 제한
        else if (infoEmail.length() < 11 || infoEmail.length() > 19) {
            // System.out.println("이메일 길이가 올바르지 않습니다.");
            return false;
        }
        // 한글만 가능한 닉네임 형식
        else if(!isHangeul(infoNickName))
        {
            // System.out.println("닉네임이 한글이 아닙니다!");
            return false;
        }
        // 넥네임 길이 제한
        else if(infoNickName.length() < 1 || infoNickName.length() > 19)
        {
            // System.out.println("닉네임 길이가 올바르지 않습니다.");
            return false;
        }

        return true;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        List<String> resultList = new ArrayList<>();

        // 1. 모든 정보 확인
        int totalSize = forms.size();

        for(int idx=0; idx<totalSize; idx++)
        {
            String email = forms.get(idx).get(0);
            String nickName = forms.get(idx).get(1);
            List<String> basic = List.of(email, nickName);

            // 제한사항 확인
            boolean infoCheck = getInfoCheck(basic);

            if(infoCheck == false)
            {
                // System.out.println(email + " , " + nickName + " : 에러");
                return answer;
            }

            for(int value=idx+1; value<totalSize; value++) {
                String compareEmail = forms.get(value).get(0);
                String compareNickName = forms.get(value).get(1);
                List<String> compare = List.of(compareEmail, compareNickName);

                // 제한사항 확인
                infoCheck = getInfoCheck(compare);

                if(infoCheck == false)
                {
                    // System.out.println(compareEmail + " , " + compareNickName + " : 에러");
                    return answer;
                }

                // 닉네임 중복 체크
                boolean resultCompare = getCheckNickName(basic, compare);
                if (resultCompare == true)
                {
                    // 결과 값 결과 리스트에 저장
                    addResultList(resultList, email,compareEmail);
                    break;
                }
            }
        }
        
        // 4-2. 결과 리스트 정렬하기
        resultList.sort(Comparator.naturalOrder());

        answer = resultList;

        return answer;
    }
}

// 기능 요구 사항
// ✔ 1. 모든 정보 확인
// ✔ 2. 닉네임 중복 체크
// ✔ 3. 중복 닉네임의 이메일 결과 리스트에 저장
// ✔ 4. 결과 리스트 내 정렬 & 중복 확인
// ✔ 5. 제한사항

// 프로그래밍 요구 사항
// ✔ 1. JDK 11 버전
// ✔ 2. "build.gradle"을 변경 X, 외부 라이브러리 X
// ✔ 3. 프로그램 종료 시 "System.exit()"를 호출 X
// ✔ 4. 프로그램 구현이 완료되면 "ApplicationTest" 의 모든 테스트 성공하기
// ✔ 5. 프로그래밍 요구 사항에서 달리 명시하지 않은 한 파일, 패키지 이름을 수정하거나 이동 X

// 과제 진행 요구 사항
// ✔ 1. 미션은 "java-onboarding" 저장소를 "Fork & Clone" 해 시작하기
// ✔ 2. 과제 진행 및 제출하기