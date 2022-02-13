package kakao;

import java.util.Stack;

public class ParentalTranslation {
    public String solution(String p) {

        char[] chars = p.toCharArray();
        if (p.length() == 0 || checkValid(chars)) {
            return p;
        }
        return  make(p);
    }


    private String make(String p) {
        if (p.length() == 0) {
            return "";
        }

        String u = makeU(p.toCharArray());
        String v;
        if (u.length() == p.length()) {
            v = "";
        } else {
            v = p.substring(u.length());
        }
        if (checkValid(u.toCharArray())) {
            return u  + make(v);
        } else {
            String temp = "(";
            temp += make(v);
            temp += ")";
            char[] reverse = u.substring(1, u.length() -1).toCharArray();
            for (int i = 0; i < reverse.length; i++) {
                if (reverse[i] == '(') {
                    temp += ')';
                } else {
                    temp += '(';
                }
            }
            return temp;
        }
    }

    private String makeU(char[] chars) {
        int open = 0;
        int close = 0;
        String result = "";
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                open++;
            } else {
                close++;
            }

            result += chars[i];
            if (open == close) {
                return result;
            }
        }

        return result;
    }

    private boolean checkValid(char[] chars) {
        Stack stack = new Stack();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(chars[i]);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        if (!stack.isEmpty()) return false;
        return true;
    }
}
