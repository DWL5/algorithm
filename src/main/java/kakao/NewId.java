package kakao;

public class NewId {
    public String solution(String new_id) {
        StringBuilder answer = new StringBuilder();

        boolean lastDot = false;
        for (char ch : new_id.toCharArray()) {
            if (!isValid(ch)) {
                continue;
            }

            if (ch == '.') {
                if (answer.length() == 0 || lastDot) continue;
                lastDot = true;
            } else {
                lastDot = false;
            }

            ch = Character.toLowerCase(ch);
            answer.append(ch);
        }


        if (answer.length() >= 16) {
            answer.setLength(15);
        }

        if (answer.length() == 0) {
            answer.append('a');
        }

        if (answer.charAt(answer.length() - 1) == '.') {
            answer.deleteCharAt(answer.length() - 1);
        }

        if (answer.length() <=2) {
            char ch = answer.charAt(answer.length() - 1);
            while (answer.length() < 3) {
                answer.append(ch);
            }
        }

        return answer.toString();
    }

    boolean isValid(char c) {
        if (Character.isLetterOrDigit(c)) {
            return true;
        }

        if (c == '-' || c == '_' || c == '.') {
            return true;
        }

        return false;
    }

}
