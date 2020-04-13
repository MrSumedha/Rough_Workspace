package ds.stack;

import java.util.Stack;

public class SimplifyBraces {

  private static String simplify(String str) {
    str = str.replaceAll("//s", "");
    while (str.charAt(0) == '(') {
      str = str.substring(1, str.length() - 1);
    }
    char res[] = new char[str.length()];
    int index = 0, i = 0;
    Stack<Integer> stack = new Stack<>();
    stack.push(0);
    while (i < str.length()) {
      switch (str.charAt(i)) {
        case '+':
          if (stack.peek() == 1) res[index++] = '-';
          if (stack.peek() == 0) res[index++] = '+';
          break;
        case '-':
          if (stack.peek() == 1) res[index++] = '+';
          else if (stack.peek() == 0) res[index++] = '-';
          break;
        case '(':
          if (i > 0) {
            if (str.charAt(i - 1) == '-') {
              stack.push((stack.peek() == 1) ? 0 : 1);
            } else if (str.charAt(i - 1) == '+')
              stack.push(stack.peek());
          }
          break;
        case ')':
          stack.pop();
          break;
        default:
          res[index++] = str.charAt(i);
      }
      i++;
    }
    return new String(res);
  }

  public static void main(String[] args) {
    System.out.println(simplify("(b-c)"));
  }
}
