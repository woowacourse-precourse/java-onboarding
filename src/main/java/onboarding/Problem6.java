package onboarding;

import java.util.*;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        // 닉네임을 통해 해당 이메일을 바로 가져오기 위한 HashMap (key : 닉네임 / value : 이메일)
        HashMap<String, String> getEmailByNickname = new HashMap<>();

        // 닉네임 목록 List
        List<String> nicknameList = new ArrayList<>();

        // Initialize getEmailByNickname & nicknameList
        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);
            getEmailByNickname.put(nickname, email);
            nicknameList.add(nickname);
        }

        // 중복 닉네임 목록 (Set)
        HashSet<String> duplicatedNicknames = getDuplicatedNicknames(nicknameList);

        // 중복 닉네임을 가진 크루원들의 이메일 목록 (List)
        List<String> emailList = getEmailList(getEmailByNickname, duplicatedNicknames);
        Collections.sort(emailList); // 이메일 목록을 오름차순으로 정렬

        answer = emailList;
        return answer;
    }

    // 중복 닉네임 목록을 Set으로 반환하는 함수
    // 중복 : 두 글자 이상의 문자가 연속적으로 순서에 맞추어 포함되어 있는 경우 -> 두 글자가 연속되었다면 중복으로 간주하여 Set에 저장
    private static HashSet<String> getDuplicatedNicknames(List<String> nicknameList) {
        HashSet<String> duplicatedNicknames = new HashSet<>(); // 중복 닉네임 목록
        int peopleNum = nicknameList.size(); // 크루원의 수

        // 닉네임 목록에서 닉네임을 2개씩 뽑아서 확인
        for (int i = 0; i < peopleNum; i++) {
            for (int j = 0; j < peopleNum; j++) {

                // 뽑은 닉네임 2개가 같지 않을 때만 확인
                if (i != j) {
                    String nickname1 = nicknameList.get(i);
                    String nickname2 = nicknameList.get(j);

                    boolean check = false; // 중복이 발생했다면 바로 for문을 멈추기 위한 장치
                    // (true : 중복이 발생하였음 -> for문 break / false : 아직 중복이 발생하지 않은 상태 -> for문 계속 진행)

                    // 닉네임에서 각각 2개 글자씩 묶어서 확인
                    for (int k = 0; k < nickname1.length() - 1; k++) {
                        for (int l = 0; l < nickname2.length() - 1; l++) {
                            // 첫번째 글자
                            char nickname1_firstChar = nickname1.toCharArray()[k];
                            char nickname2_firstChar = nickname2.toCharArray()[l];
                            // 두번째 글자
                            char nickname1_secondChar = nickname1.toCharArray()[k + 1];
                            char nickname2_secondChar = nickname2.toCharArray()[l + 1];

                            // 닉네임 2개에서 각각의 첫번째 글자와 두번째 글자가 서로 같다면 중복으로 간주
                            if ((nickname1_firstChar == nickname2_firstChar) && (nickname1_secondChar == nickname2_secondChar)) {
                                duplicatedNicknames.add(nickname1);
                                duplicatedNicknames.add(nickname2);
                                check = true; // 중복이 발생하였음을 표시 -> 안쪽 l에 대한 for문 break
                                break;
                            }
                        }
                        if (!check) { // 중복이 발생하였을 경우 바깥쪽 k에 대한 for문 break
                            break;
                        }
                    }
                }
            }
        }

        return duplicatedNicknames;
    }

    // 중복 닉네임 목록에 들어간 크루원들의 이메일 목록을 List로 반환하는 함수
    private static List<String> getEmailList(HashMap<String, String> getEmailByNickname, HashSet<String> duplicatedNicknames) {
        List<String> emailList = new ArrayList<>(); // 이메일 목록

        for (String duplicatedNickname : duplicatedNicknames) {
            String email = getEmailByNickname.get(duplicatedNickname); // 중복 닉네임을 가진 크루원의 이메일
            emailList.add(email);
        }

        return emailList;
    }

}
