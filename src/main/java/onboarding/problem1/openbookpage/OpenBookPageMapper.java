package onboarding.problem1.openbookpage;

import onboarding.problem1.InputValidator;

import java.util.List;

public class OpenBookPageMapper {
    InputValidator inputValidator = new InputValidator();
    public OpenBookPage map(List<Integer> playerInput) {
        inputValidator.validate(playerInput);
        return new OpenBookPage(playerInput.get(0), playerInput.get(1));
    }
}
