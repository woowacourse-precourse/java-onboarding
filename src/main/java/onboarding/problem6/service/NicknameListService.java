package onboarding.problem6.service;

import java.util.ArrayList;

public class NicknameListService {
    public static boolean isNicknameInList(ArrayList<String> nicknameList, String nickname){
        return nicknameList.contains(nickname);
    }
}
