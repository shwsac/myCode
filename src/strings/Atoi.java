package strings;

public class Atoi {

    public static int myAtoi(String str) {
        if( str == null || str.length() == 0) {
            return 0;
        }
        str = str.trim();
        boolean flagMinus = false;
        int i = 0;
        if(str.charAt(0) == '-') {
            flagMinus = true;
            i++;
        }
        else if(str.charAt(0) == '+') {
            i++;
        }
        double num = 0;
        while (i<str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
             num = num*10 + (str.charAt(i) - '0');   
             i++;
        }
        
        if(flagMinus) {
            num = -num;
        }
        return (int)num;
    }
    public static void main(String[] args) {
        System.out.println(myAtoi(" +1"));

    }

}
