package org;

import java.util.Collections;
import java.util.Stack;

class Calculator {
    private Stack<String> postfixStack = new Stack<String>();
    private Stack<Character> opStack = new Stack<Character>();
    private final int[] operatPriority = new int[]{2, 0, 0, 0, 0, 2, 1, -1,1,0,2,0,0,0,0,0,0,0,0,0,3};// 运用运算符ASCII码%37做索引的运算符优先级

    public static double conversion(String expression) {
        double result;
        Calculator cal = new Calculator();
        try {
            cal.transform(expression);
            result = cal.calculate();
        } catch (Exception e) {
            e.printStackTrace();
            // 运算错误返回NaN
            return Double.NaN;
        }
        return result;
    }

    //中缀式转换后缀式
    private void transform(String expression) {
        if(expression.charAt(0) == '-'){
            expression = '0' + expression;
        }
        char[] arr = expression.toCharArray();
        int j = 0;
        opStack.push(',');
        for (int i = 0; i < arr.length; i++) {
            if(isOperator(arr[i])) {
                //减号前有运算符是负号
                if(arr[i] == '-' && isOperator(arr[i-1])){
                    postfixStack.push(String.valueOf(arr[i])+arr[i+1]);
                    i++;
                }
                //符号栈中为“，”或符号为“（”直接进栈
                else if (opStack.peek().equals(',') || arr[i] == '(') {
                    opStack.push(arr[i]);
                }
                else if (arr[i] == ')') {
                    while (opStack.peek() != '(') {
                        char op = opStack.pop();
                        postfixStack.push(String.valueOf(op));
                    }
                    opStack.pop();
                }
                else {
                    //根据优先级换栈
                    while (compare(arr[i], opStack.peek())) {
                        char op = opStack.pop();
                        postfixStack.push(String.valueOf(op));
                    }
                    opStack.push(arr[i]);
                }
            }
            else{
                String arrj;

                if(i==j+1 && arr[j] != '(')//连续数字合并为一个数字
                    arrj = postfixStack.pop() + arr[i];
                else
                    arrj = String.valueOf(arr[i]);

                if(arr.length>=i+3){
                    if (arr[i+1] =='.') {//数字后有小数点合并为小数
                        postfixStack.push(arrj +arr[i+1]+arr[i+2]);
                        i+=2;
                    }
                    else{
                        postfixStack.push(arrj);
                    }
                }
                else{
                    postfixStack.push(arrj);
                }
                j=i;
            }
        }
        while (!opStack.peek().equals(',')) { //符号栈出栈
            char op = opStack.pop();
            postfixStack.push(String.valueOf(op));
        }
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')' || c == '%' || c == '^';
    }

    public boolean compare(char cur, char peek) {// 如果是peek优先级高于cur，返回true
        return operatPriority[(peek) % 37] > operatPriority[(cur) % 37];
    }

    public double calculate() {
        Stack<String> resultStack = new Stack<String>();
        Collections.reverse(postfixStack);// 将后缀式栈反转
        String firstValue, secondValue, currentValue;// 参与计算的第一个值，第二个值和算术运算符

        while (!postfixStack.isEmpty()) {
            currentValue = postfixStack.pop();

            if (!isOperator(currentValue.charAt(0)) || currentValue.length() > 1) {// 如果不是运算符则存入操作数栈中
                resultStack.push(currentValue);
            } else {// 如果是运算符则从操作数栈中取两个值和该数值一起参与运算
                secondValue = resultStack.pop();
                firstValue = resultStack.pop();

                String tempResult = calculate(firstValue, secondValue, currentValue.charAt(0));
                resultStack.push(tempResult);
            }
        }
        return Double.parseDouble(resultStack.pop());
    }

    private String calculate(String firstValue, String secondValue, char currentOp) {
        return switch (currentOp) {
            case '+' -> String.valueOf(ArithHelper.add(firstValue, secondValue));
            case '-' -> String.valueOf(ArithHelper.sub(firstValue, secondValue));
            case '*' -> String.valueOf(ArithHelper.mul(firstValue, secondValue));
            case '/' -> String.valueOf(ArithHelper.div(firstValue, secondValue));
            case '%' -> String.valueOf(ArithHelper.mod(firstValue, secondValue));
            case '^' -> String.valueOf(ArithHelper.pow(firstValue, secondValue));
            default -> "";
        };
    }
}