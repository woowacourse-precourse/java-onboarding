package onboarding.problem6;

import java.util.List;

public class NicknameVerification {

    public List<String> verificationCheck(List<List<String>> forms) {

        NicknameCheck nicknameCheck = new NicknameCheck();
        SaveCrew saveCrew = new SaveCrew();

        List<Crew> crewList = saveCrew.crewSet(forms);
        List<String> result = nicknameCheck.DuplicateCrew(crewList);

        return result;
    }
}
