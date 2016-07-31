package arrays;

import java.util.Arrays;

public class CharArrayTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
       char[] charArray = {'H','i'};
       String str = new String(charArray);
       System.out.println(charArray.toString());
       System.out.println(str);
       System.out.println(Arrays.toString(charArray));
    }

}
