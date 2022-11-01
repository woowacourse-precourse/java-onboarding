package onboarding.problem6.controller;

import onboarding.problem6.service.DuplicatedCrewService;
import onboarding.problem6.service.NicknameListService;
import onboarding.problem6.utils.validator.InputFormValidator;
import onboarding.problem6.utils.validator.exception.InputFormException;

import java.util.ArrayList;
import java.util.List;

public class DuplicatedNickNameSearch {
    private List<List<String>> forms;
    private ArrayList<Integer> duplicatedCrewsIndex = new ArrayList<>();
    private ArrayList<String> duplicatedCrewsEmail = new ArrayList<>();

    public DuplicatedNickNameSearch setNewForms(List<List<String>> forms){
        try{
            new InputFormValidator(forms);
            this.forms = forms;
        }catch (InputFormException e){
            e.printStackTrace();
            System.out.println("umm?");
        }
        return this;
    }

    public DuplicatedNickNameSearch checkAllCrewForm(){
        for (int currentCrewIndex = 0; currentCrewIndex < forms.size(); currentCrewIndex++) {
            String currentCrewNickname= NicknameListService.getNicknameFromList(forms.get(currentCrewIndex));
            if(!NicknameListService.checkOneWordNickname(currentCrewNickname)){
                checkCrewForm(currentCrewNickname, currentCrewIndex);
            }
        }
        return this;
    }

    private void checkCrewForm(String currentCrewNickname, int crewIndex){
        for(int index = 0; index<currentCrewNickname.length()-1; index++){
            addDuplicatedCrew(DuplicatedCrewService.getSubString(currentCrewNickname, index), crewIndex);
        }
    }

    private void addDuplicatedCrew(String duplicatedWord, int currentCrewIndex){
        for(int checkCrewIndex = currentCrewIndex+1; checkCrewIndex<forms.size(); checkCrewIndex++){
            String checkCrewNickname = NicknameListService.getNicknameFromList(forms.get(checkCrewIndex));
            DuplicatedCrewService.addDuplicatedCrewIndex(duplicatedCrewsIndex, duplicatedWord, checkCrewNickname, checkCrewIndex, currentCrewIndex);
        }
    }

    public ArrayList<String> getDuplicatedNicknameCrewEmail(){
        duplicatedCrewsEmail = NicknameListService.crewIndexToCrewEmail(forms, duplicatedCrewsIndex);
        return duplicatedCrewsEmail;
    }
}
