package com.dumbo.springboot.controller;


public class Test {
    public static void main(String[] args) {
        System.out.println(reverse(-483648));

        int i = -2147483648 * -1;
        System.out.println(i);
    }

    public static int reverse(int x) {

        if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) {
            return 0;
        }
        boolean negative = x < 0;
        if(negative) {
            if(x == Integer.MIN_VALUE) {
                return 0;
            }
            x *= -1;
        }

        String input = String.valueOf(x);
        char[] inputStringToCharArray = input.toCharArray();
        int len = inputStringToCharArray.length;
        int startReverseIndex = 0;

        for(int i = startReverseIndex; i< len/2;i++) {
            char carry = inputStringToCharArray[i];
            inputStringToCharArray[i] = inputStringToCharArray[len-i-1];
            inputStringToCharArray[len-i-1] = carry;
        }

        String executeResult = new String(inputStringToCharArray);

        if(Long.valueOf(executeResult) > Long.valueOf(Integer.MAX_VALUE)) {
            return 0;
        }

        int reverse = Integer.parseInt(executeResult);

        if(negative) {
            return reverse*-1;
        }
        return reverse;
    }

    public static int reverse2(int x) {
        if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) {
            return 0;
        }

        int reversed = 0;
        boolean isNegative = x < 0;

        if (isNegative) x *= -1;

        while (x > 0) {
            if (reversed > Integer.MAX_VALUE/10) return 0;

            reversed *= 10;
            reversed += x%10;
            x = x/10;
        }

        if (reversed > Integer.MAX_VALUE) {
            return 0;
        }

        if (isNegative) reversed *= -1;

        return reversed;
    }
}
