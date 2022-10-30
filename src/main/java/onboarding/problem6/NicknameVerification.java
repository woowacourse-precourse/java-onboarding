package onboarding.problem6;

import java.util.List;

public class NicknameVerification {

    public List<String> verificationCheck(List<List<String>> forms) {

        NicknameCheck nicknameCheck = new NicknameCheck();
        SaveCrewMember saveCrewMember = new SaveCrewMember();

        List<CrewMember> crewMembers = saveCrewMember.crewMeberSet(forms);
        List<String> result = nicknameCheck.DuplicateCrewMember(crewMembers);

        return result;
    }

}
