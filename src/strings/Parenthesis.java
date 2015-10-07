package strings;

public class Parenthesis {

    public String matchParenthesis(String input) {
        StringBuffer first = new StringBuffer();
        StringBuffer second = new StringBuffer();
        if (input == null) {
            return null;
        }
        char[] inputArray = input.toCharArray();
        int count = 0;
        for (int index = 0; index < inputArray.length; index++) {
            if (inputArray[index] == '(') {
                count++;
                first.append(inputArray[index]);
            } else if (inputArray[index] == ')') {
                if (count != 0) {
                    count--;
                    if (count >= 0) {
                        first.append(inputArray[index]);
                    }
                }
            } else {
                first.append(inputArray[index]);
            }
        }
        count = 0;
        char[] secondArray = first.toString().toCharArray();
        for (int index = secondArray.length - 1; index >= 0; index--) {
            if (secondArray[index] == ')') {
                count++;
                second.append(secondArray[index]);
            } else if (secondArray[index] == '(') {
                if (count != 0) {
                    count--;
                    if (count >= 0) {
                        second.append(secondArray[index]);
                    }
                }
            } else {
                second.append(secondArray[index]);
            }
        }
        return second.reverse().toString();
    }

    public static void main(String[] args) {
        Parenthesis par = new Parenthesis();
        String input = "(((a)b(b(c)))(()(";
        System.out.println(par.matchParenthesis(input));

    }

}
