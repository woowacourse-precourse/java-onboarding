package onboarding.problem2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Decoder
{
    private List<Character> cryptogramList;

    public Decoder(String cryptogram)
    {
        cryptogramList= new ArrayList<>();
        cryptogramList.add('\u0000');
        for(int i = 0 ; i < cryptogram.length();i++)
        {
            cryptogramList.add(cryptogram.charAt(i));
        }
        cryptogramList.add('\u0000');
    }

    private boolean isSuccessive(int index)
    {
        return cryptogramList.get(index-1) != cryptogramList.get(index)
                && cryptogramList.get(index) != cryptogramList.get(index+1);
    }

    public Decoder removeDuplicatedCharacter()
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < cryptogramList.size() -1;i++)
        {
            if(isSuccessive(i))
            {
                sb.append(cryptogramList.get(i));
            }
        }
        Decoder newDecoder = new Decoder(sb.toString());
        return newDecoder;
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < cryptogramList.size() -1; i++)
        {
            sb.append(cryptogramList.get(i));
        }


        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Decoder)) return false;
        Decoder decoder = (Decoder) o;
        if(decoder.cryptogramList.size() != cryptogramList.size()) return false;
        for(int i = 1; i < cryptogramList.size() -1; i++)
        {
            if(cryptogramList.get(i) != decoder.cryptogramList.get(i))
            {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cryptogramList);
    }
}