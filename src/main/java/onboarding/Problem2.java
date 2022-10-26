package onboarding;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Decoder
{
    private int itemIndex;
    private int emptyIndex;
    Stack<Character>[] stacks;

    public Decoder(String cryptogram)
    {
        stacks = new Stack[]{new Stack<Character>(),  new Stack<Character>()};

        itemIndex = 0;
        emptyIndex = 1;

        for(int i = 0 ; i < cryptogram.length();i++)
        {
            stacks[itemIndex].add(cryptogram.charAt(i));
        }
    }

    public boolean removeDuplicatedCharacter()
    {
        boolean flag = false;

        char c = '\u0000';

        while(!stacks[itemIndex].isEmpty())
        {

            if(stacks[itemIndex].peek().equals(c))
            {
                stacks[itemIndex].pop();
                stacks[emptyIndex].pop();
                flag = true;
            }
            else
            {
                c = stacks[itemIndex].pop();
                stacks[emptyIndex].push(c);
            }

        }

        swapIndex();

        return flag;
    }

    private void swapIndex()
    {
        int tmp = itemIndex;
        itemIndex = emptyIndex;
        emptyIndex = tmp;
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        if(itemIndex == 0)
        {
            for(char c : stacks[itemIndex])
            {
                sb.append(c);
            }
        }
        else
        {
            while(!stacks[itemIndex].isEmpty())
            {
                sb.append(stacks[itemIndex].pop());
            }
        }

        return sb.toString();
    }


}
public class Problem2 {

    public static String solution(String cryptogram) {
        Decoder decodeQueue = new Decoder(cryptogram);
        while(decodeQueue.removeDuplicatedCharacter());
        return decodeQueue.toString();
    }
}
