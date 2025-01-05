package day08.project4;

import java.util.Arrays;
import java.util.List;

public class Parser {
    public Parser() {

    }

    public String parse(String message) {
        String[] inputs = message.split(" ");
        int first = Integer.parseInt(inputs[0]);
        String operator = inputs[1];
        int second = Integer.parseInt(inputs[2]);
        int result = 0;

        switch (operator) {
            case "+" :
                result = first + second;
                break;
            case "-" :
                result = first - second;
                break;
            case "*" :
                result = first * second;
                break;
            case "/" :
                result = first / second;
                break;
            
        }
        
        return String.valueOf(result) + "\n";
    }

    public String checkVaildArguments(String message) {
        String[] inputs = message.split(" ");
        String[] validOperators = {"+","-","*","/"};
        List<String> operators = Arrays.asList(validOperators);
        if (inputs.length < 2){
            return "Invalid number of arguments, please follow the format: number <space> operator <space> number \n";
        } else if (!operators.contains(inputs[1])){
            return "Invalid operator \n";
        } else {
            return message;
        }
    }
}
