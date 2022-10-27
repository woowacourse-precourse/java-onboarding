package onboarding.problem2;

public class StringStackCalculator implements StackCalculator<StringMainStack, StringSubStack> {

    @Override
    public boolean deleteDuplicatedCharacter(StringMainStack stringMainStack,
        StringSubStack stringSubStack) {
        boolean flag = false;
        while(!stringMainStack.isEmpty()) {
            if(!stringSubStack.isEmpty() && comparePeekCharacter(stringMainStack, stringSubStack)) {
                stringMainStack.popCharacter();
                stringSubStack.popCharacter();
                flag = true;
                continue;
            }
            stringSubStack.pushCharacter(stringMainStack.popCharacter());
        }
        return flag;
    }

    private boolean comparePeekCharacter(StringMainStack stringMainStack,
        StringSubStack stringSubStack) {
        if(isSameCharacterOfPeeks(stringMainStack, stringSubStack)) {
            return true;
        }
        return false;
    }

    private boolean isSameCharacterOfPeeks(StringMainStack stringMainStack, StringSubStack stringSubStack) {
        return stringMainStack.getPeek() == stringSubStack.getPeek();
    }
}
