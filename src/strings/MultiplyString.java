package strings;

public class MultiplyString {

    public String multiply(String num1, String num2) {

        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();

        int[] output = new int[n1.length() + n2.length()];

        for (int i = 0; i < n1.length(); i++) {
            for (int j = 0; j < n2.length(); j++) {
                output[i + j] += (n1.charAt(i) - '0') * (n2.charAt(j) - '0');
            }
        }

        StringBuffer str = new StringBuffer();

        for (int i = 0; i < output.length; i++) {
            int mod = output[i] % 10;
            int carry = output[i] / 10;
            if (i + 1 < output.length) {
                output[i + 1] += carry;
            }
            str.insert(0, mod);
        }

        while (str.charAt(0) == '0' && str.length() > 1) {
            str.deleteCharAt(0);
        }

        return str.toString();
    }

}
