package Lab8;

import java.util.Scanner;

public class StringExample {
    static String result="";
    static Boolean err=true;

    public static void main(String[] args) {

        // 1st way
        String name = "Rama";

        // 2nd way
        String newname = new String("Gopal");

        // 3rd way
        char[] st = { 'a', 'b', 'c' };
        String str = new String(st);

        Scanner sc = new Scanner(System.in);

        System.out.println("Pick Option\n" +
                "1) Change the case of the string\n" +
                "2) Reverse the string \n" +
                "3) Compare two strings\n" +
                "4) Insert one string into another string\n" +
                "5) Convert the string to upper case and lower case\n" +
                "6) Check whether the character is present in the string and at which position\n" +
                "7) Check whether the string is palindrome or not.\n" +
                "8) Check the number of word, vowel and consonant in the string");

        int i = sc.nextInt();
        System.out.println("Enter String:");
        String s=sc.nextLine();

        switch (i) {
            case 1:
                changeCase(s);
                break;
            case 2:
                revYesFun(s);
                break;
            case 3:
                System.out.println("Enter next String:");
                String s2=sc.nextLine();
                compareString(s,s2);
                break;
            case 4:
                System.out.println("Enter next String:");
                String s2=sc.nextLine();
                joinString(s,s2);
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            default:
                System.out.println("Invalid Choice");
                err=false;
                break;
        }
        if(err) return;
        System.out.println("Result: " + result);
    }

    static void changeCase(String str) {
        String result = str.toUpperCase();
    }

    static void revNoFun(String str) {
        int start = 0;
        int end = str.length();
        int destoffset = 0;

        char buf[] = new char[end - start];
        str.getChars(start, end, buf, destoffset);

        for (int i = buf.length - 1; i >= 0; i--) {
            result += buf[i];
        }
    }

    static void revYesFun(String str) {
        StringBuffer sb = new StringBuffer(str);
        result=sb.reverse().toString();
    }

    static void compareString(String str1, String str2){
        int res = str2.compareTo(str1);
        System.out.println("The difference between ASCII value is: "+res+"\n");
    }

    static void joinString(String s1, String s2){
        String res = "";
        res = s2+" "+s1;
        System.out.println("he string after insertion is: "+res+"\n");
    }
}