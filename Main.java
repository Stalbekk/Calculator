import java.util.Scanner;
public class Main {    
    public static void main(String[] args) {        
        Scanner sc = new Scanner(System.in);        
        int input1;        
        char operation = '0';        
        int input3; 
        String arrayIntegers[] = new String[2];
        char tempOperation;

        System.out.println("Эсептөө үчүн туюнтманы киргизиңиз. Араб жана Рим Сандары менен, +, -, *, / операцияларды аткара алат ");

        String input = sc.nextLine(); 

        //
        String int1 = "";        
        String int2 = "";              
        for (int i = 0; i < input.length(); i++) {
            if(isInvalidInput(input.charAt(i))){
                throw new IllegalArgumentException("Invalid input!!");
            }
            if(isInvalidDigit(input.charAt(i))){
                operation = input.charAt(i);
            }
        }

        tempOperation = operation;
        //System.out.println(operation);
        if(Character.compare(operation, '/') == 0){
            arrayIntegers = input.split("/");
        }
        if(Character.compare(operation, '*') == 0){
            arrayIntegers = input.split("\\*");
        }
        if(Character.compare(operation, '-') == 0){
            arrayIntegers = input.split("-");
        }
        if(Character.compare(operation, '+') == 0){
            arrayIntegers = input.split("\\+");
        }

        if(isNotSame(arrayIntegers[0], arrayIntegers[1])){
            throw new IllegalArgumentException("Inputs have to be same!!!"); 
        }

        if(Character.isDigit(arrayIntegers[0].charAt(0))){
            input1 = Integer.parseInt(arrayIntegers[0]);
            input3 = Integer.parseInt(arrayIntegers[1]);

            switch(tempOperation){
                case '+':
                System.out.println(input1+input3);
                break;
                case '-':
                System.out.println(input1-input3);
                break;
                case '*':
                System.out.println(input1*input3);
                break;
                case '/':
                System.out.println(input1/input3);
                break;
            }
        }

        if(isRomanDigit(arrayIntegers[0].charAt(0))){
            input1 = RomanToNumber.romanToDecimal(arrayIntegers[0]);
            input3 = RomanToNumber.romanToDecimal(arrayIntegers[1]);
            int result =0;
            switch(tempOperation){
                case '+':
                NumberToRoman.printRoman(input1+input3);
                break;
                case '-':
                NumberToRoman.printRoman(input1-input3);
                break;
                case '*':
                NumberToRoman.printRoman(input1*input3);
                break;
                case '/':
                NumberToRoman.printRoman(input1/input3);
                break;
            }
        }
    }     

    public static boolean isInvalidInput(char input){
        if(isOperation(input) || isRomanDigit(input) || Character.isDigit(input)){
            return false;
        }
        return true;
    }

    public static boolean isInvalidDigit(char input){
        if(Character.isDigit(input) || isRomanDigit(input)){
            return false;
        }
        return true;
    }

    public static boolean isOperation(char input){
        switch(input){
            case '/':
            return true;
            case '*':
            return true;
            case '-':
            return true;
            case '+':
            return true;
            default:
            return false;
        }
    }

    public static boolean isRomanDigit(char input){
        switch(input){
            case 'I':
            return true;
            case 'V':
            return true;
            case 'X':
            return true;
            default:
            return false;
        }
    }

    public static boolean isNotSame(String num1, String num2){
        boolean allRoman1 = false;
        boolean allDigit1 = false;
        boolean allRoman2 = false;
        boolean allDigit2 = false;
        int count = 0;

        for(int i = 0; i < num1.length(); i++){
            if(Character.isDigit(num1.charAt(i))){
                count++;
            }
        }

        if(count == num1.length()){
            allDigit1 = true;
        }
        count = 0;

        for(int i = 0; i < num1.length(); i++){
            if(isRomanDigit(num1.charAt(i))){
                count++;
            }
        }

        if(count == num1.length()){
            allRoman1 = true;
        }


        for(int i = 0; i < num2.length(); i++){
            if(Character.isDigit(num2.charAt(i))){
                count++;
            }
        }

        if(count == num2.length()){
            allDigit2 = true;
        }
        count = 0;

        for(int i = 0; i < num2.length(); i++){
            if(isRomanDigit(num2.charAt(i))){
                count++;
            }
        }

        if(count == num2.length()){
            allRoman2 = true;
        }

        return !((allDigit1 && allDigit2) || (allRoman1 && allRoman2));
    }
}
