package problem6;

import problem6.exceptions.EmailFormatException;
import problem6.exceptions.NameFormatException;
import problem6.exceptions.TotalCountException;

import java.util.List;
import java.util.regex.Pattern;

public class Validation {
    public static void validate(List<List<String>> forms) {
        if(totalCountValidate(forms.size())) throw new TotalCountException("Total crew cannot be above 10'000!");

        forms.forEach(form -> {
            if (!emailValidate(form.get(0))) throw new EmailFormatException("Invalid email address!");
            if (!nameValidate(form.get(1))) throw new NameFormatException("Invalid name!");
        });
    }

    private static boolean totalCountValidate(int totalCount) {
        return !(1 <= totalCount && totalCount <= 10_000);
    }

    private static boolean nameValidate(String name) {
        int nameLength = name.length();

        return nameLength >= 1&& nameLength<20 && Pattern.matches("^[가-힣]*$", name);
    }

    private static boolean emailValidate(String email) {
        int emailLength = email.length();

        return (emailLength >= 11 && emailLength < 20) &&
                email.startsWith("@email.com", emailLength - 10);
    }
}
