package onboarding.problem2.controller;

import onboarding.problem2.service.DuplicatedCharService;
import onboarding.problem2.service.RemoveCharService;
import onboarding.problem2.utils.validator.InvalidStringValidator;
import onboarding.problem2.utils.validator.exception.InvalidStringException;

import java.util.ArrayList;

public class DecryptorDulipcateCryptedText {

    public String duplicateCryptedText;
    public String decryptedText = "";

    public DecryptorDulipcateCryptedText(String duplicateCryptedText){
        try{
            new InvalidStringValidator(duplicateCryptedText);

            this.duplicateCryptedText = duplicateCryptedText;
            fullyDecryption();

        }catch (InvalidStringException e) {
            e.printStackTrace();
            this.decryptedText = "";
        }
    }

    private void fullyDecryption(){
        String decryptionText = duplicateCryptedText;
        while(DuplicatedCharService.checkDecryption(decryptionText)){
            decryptionText = decryption(decryptionText);
        }

        this.decryptedText = decryptionText;
    }

    public String getDecryptedText(){
        return this.decryptedText;
    }

    private String decryption(String decryptionText){
        ArrayList<int[]> duplicatedCharPositionList = DuplicatedCharService.getDuplicatedCharPositionList(decryptionText);
        decryptionText = RemoveCharService.removeWordFromRange(decryptionText, duplicatedCharPositionList);
        return decryptionText;
    }

}
