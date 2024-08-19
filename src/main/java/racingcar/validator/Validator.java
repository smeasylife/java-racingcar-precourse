package racingcar.validator;

public class Validator {
    public void validateNames(String name) {
        checkSeparator(name);
        checkLength(name);
    }

    private void checkSeparator(String name){
        char[] arr = name.toCharArray();
        for(char ch: arr){
            if(!Character.isAlphabetic(ch)){
                throw new IllegalArgumentException();
            }
        }
    }
    private void checkLength(String name){
        if (name.length() > 5){
            throw new IllegalArgumentException();
        }
    }
    public void validateStringIsNum(String str) {
        char[] arr = str.toCharArray();
        for (char ch : arr) {
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException();
            }
        }
    }
}
