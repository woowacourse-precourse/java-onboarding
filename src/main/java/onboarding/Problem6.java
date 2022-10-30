package onboarding;

import java.util.*;

public class Problem6 {
    
    /*
    크루 닉네임에서 연속되는 모든 문자열 저장
     */
    static List<List<String>> findContinualChar(List<List<String>> forms){
        List<List<String>> continualCharOfCrew = new ArrayList<>();
        for(int crewIdx = 0; crewIdx < forms.size(); crewIdx++) {
            String nickName = forms.get(crewIdx).get(1);
            List<String> continualChar = new ArrayList<>();
            String divededChar;
            for(int nickNameIdx = 1; nickNameIdx < nickName.length(); nickNameIdx++){
                divededChar = Character.toString(nickName.charAt(nickNameIdx-1)) + Character.toString(nickName.charAt(nickNameIdx));
                continualChar.add(divededChar);
            }
            continualCharOfCrew.add(continualChar);
        }
        return continualCharOfCrew;
    }

    /*
    저장된 연속 문자열 다른 크루 닉네임에 존재하는지 판별
     */
    static List<Integer> findRedundantName(List<List<String>> forms){
        List<List<String>> continualCharOfCrew = findContinualChar(forms);
        Set<Integer> ansNickNameIdxSet = new HashSet<>(); //중복 방지용 set

        for(int crewIdx = 0; crewIdx < forms.size(); crewIdx++){ //비교 대상(베이스)
            String curCrewNickName = forms.get(crewIdx).get(1);
            for(int cmpCrewIdx = 0; cmpCrewIdx < forms.size(); cmpCrewIdx++){ //비교 대상을 제외한 모든 크루들과 대조
                if(cmpCrewIdx == crewIdx) continue; //동일인물일 경우 확인 x
                for(int idx = 0; idx < continualCharOfCrew.get(cmpCrewIdx).size(); idx++){ //비교 당하는 크루의 모든 연속되는 문자열 확인
                    String continualChar = continualCharOfCrew.get(cmpCrewIdx).get(idx);
                    if(curCrewNickName.contains(continualChar)){ //일치할 경우 두명 다 넣음
                        ansNickNameIdxSet.add(crewIdx);
                        ansNickNameIdxSet.add(cmpCrewIdx);
                        break;
                    }
                }
            }
        }

        List<Integer> ansNickNameIdx = new ArrayList<>(ansNickNameIdxSet);
        return ansNickNameIdx;
    }

    /*
    중복된 닉네임 갖는 크루 이메일 저장
     */
    static List<String> findEmail(List<List<String>> forms){
        List<Integer> ansNickNameIdx = findRedundantName(forms);
        Set<String> answerSet = new HashSet<>();
        for(int idx = 0; idx < ansNickNameIdx.size(); idx++){
            int nickNameIdx = ansNickNameIdx.get(idx);
            String email = forms.get(nickNameIdx).get(0);
            answerSet.add(email);
        }

        List<String> answer = new ArrayList<>(answerSet);
        return answer;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        answer = findEmail(forms);
        Collections.sort(answer, String.CASE_INSENSITIVE_ORDER);

        return answer;
    }
}
