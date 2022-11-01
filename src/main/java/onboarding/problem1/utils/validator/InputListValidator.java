package onboarding.problem1.utils.validator;

import onboarding.problem1.utils.validator.exception.InvalidListException;
import java.util.List;

public class InputListValidator {
    public static void validateArray(List<Integer> list) throws InvalidListException {
        try {
            new ListLengthValidator(list);
            new OddEvenPageValidator(list);
            new PagePairValidator(list);
            new PageRangeValidator(list);
        }catch (Exception e){
            System.out.println(e.getClass().getName());
            throw new InvalidListException("유효하지 않은 리스트");
        }
    }
}

