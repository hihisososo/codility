package codility;

import java.util.Stack;

public class Brackets {

  public static void main(String[] args) {
    String S = "{[()()]}";
    System.out.println(new Brackets().solution(S));
  }

  public int solution(String S) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < S.length(); i++) {
      if (S.charAt(i) == '{' || S.charAt(i) == '[' || S.charAt(i) == '(') {
        stack.push(S.charAt(i));
      } else if (S.charAt(i) == ')') {
        if (stack.isEmpty() || stack.pop() != '(') {
          return 0;
        }
      } else if (S.charAt(i) == ']') {
        if (stack.isEmpty() || stack.pop() != '[') {
          return 0;
        }
      } else {
        if (stack.isEmpty() || stack.pop() != '{') {
          return 0;
        }
      }
    }
    if (stack.isEmpty()) {
      return 1;
    }
    return 0;
  }
}
