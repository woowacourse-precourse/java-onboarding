package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashMap<String, String> databaseOfNickname = initDatabaseOfNickname();
        HashMap<String, Boolean> duplicationOfNickname = initDuplicationOfNickname();
        addUsers(databaseOfNickname, duplicationOfNickname, forms);
        List<String> answer = createDuplicationUserList(duplicationOfNickname);
        return answer;
    }

    // 이메일과 닉네임을 저장할 HashMap을 초기화하는 함수
    public static HashMap<String, String> initDatabaseOfNickname() {
        return new HashMap<String, String>();
    }

    // 이메일과 닉네임의 중복 여부를 판단할 HashMap을 초기화하는 함수
    public static HashMap<String, Boolean> initDuplicationOfNickname() {
        return new HashMap<String, Boolean>();
    }

    // 이메일과 닉네임을 HashMap에 추가하는 함수
    public static void addUser(HashMap<String, String> databaseOfNickname, List<String> user) {
        databaseOfNickname.put(user.get(0), user.get(1));
    }

    // 이메일과 닉네임을 추가한 뒤 중복 여부를 판단하는 함수
    public static String checkDuplicationOfNicknames(HashMap<String, String> databaseOfNickname, List<String> newUser) {
        for (String key : databaseOfNickname.keySet()) {
            if (key == newUser.get(0)) continue;
            if (checkDuplicationOfNickname(databaseOfNickname.get(key), newUser.get(1))) return key;
        }
        return "";
    }

    // 유저들 각각에 대해 중복 여부를 판단하는 함수
    public static boolean checkDuplicationOfNickname(String nickname, String newNickname) {
        for (int i = 0; i < newNickname.length() - 1; i++) {
            if (nickname.contains(newNickname.substring(i, i+2))) return true;
        }
        return false;
    }

    // 이메일과 닉네임의 중복이 있으면 이메일에 대한 중복 여부를 체크하는 함수
    public static void checkDuplication(HashMap<String, String> databaseOfNickname, HashMap<String, Boolean> duplicationOfNickname, List<String> user) {
        String key = checkDuplicationOfNicknames(databaseOfNickname, user);
        if (key != "") {
            duplicationOfNickname.put(user.get(0), true);
            duplicationOfNickname.put(key, true);
        }
        else
            duplicationOfNickname.put(user.get(0), false);
    }

    // 중복된 이메일을 리스트에 저장하여 리턴하는 함수
    public static List<String> createDuplicationUserList(HashMap<String, Boolean> duplicationOfNickname) {
        ArrayList<String> duplicationUserList = new ArrayList<String>();
        for (String key : duplicationOfNickname.keySet()) {
            if (duplicationOfNickname.get(key)) duplicationUserList.add(key);
        }
        duplicationUserList.sort(Comparator.naturalOrder());
        return duplicationUserList;
    }

    // 주어진 이메일, 닉네임 리스트를 하나씩 추가하는 함수
    public static void addUsers(HashMap<String, String> databaseOfNickname, HashMap<String, Boolean> duplicationOfNickname, List<List<String>> forms) {
        for (List<String> user: forms) {
            if (checkUserForm(user)) {
                addUser(databaseOfNickname, user);
                checkDuplication(databaseOfNickname, duplicationOfNickname, user);
            }
        }
    }

    // 주어진 이메일이 형식에 맞게 입력됐는지 확인하는 함수
    public static boolean checkEmailForm(String email) {
        return email.split("@")[1].equals("email.com") && email.length() >= 11 && email.length() < 20;

    }

    // 주어진 닉네임이 형식에 맞게 입력됐는지 확인하는 함수
    public static boolean checkNicknameForm(String nickname) {
        return Pattern.matches("^[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]*$", nickname) && nickname.length() >= 1 && nickname.length() < 20;
    }

    // 주어진 유저 정보가 형식에 맞게 입력됐는지 확인하는 함수
    public static boolean checkUserForm(List<String> user) {
        return checkEmailForm(user.get(0)) && checkNicknameForm(user.get(1));
    }
}
