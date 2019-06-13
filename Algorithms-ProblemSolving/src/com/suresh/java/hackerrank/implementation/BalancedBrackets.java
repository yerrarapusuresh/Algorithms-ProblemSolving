/**
 * Suresh Y
 */
package com.suresh.java.hackerrank.implementation;

import java.util.Stack;

/**
 * @author syerrarapu
 *
 */
public class BalancedBrackets {

  static String isBalanced(String s) {
    if (s.length() <= 1) {
      return "No";
    }

    Stack<Character> stack = new Stack<Character>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '{' || c == '[' || c == '(') {
        stack.push(c);
      } else {
        if (stack.isEmpty()) {
          return "No";
        } else {
          char top = stack.pop();
          if (top != '{' && c == '}') {
            return "No";
          } else if (top != '[' && c == ']') {
            return "No";
          } else if (top != '(' && c == ')') {
            return "No";
          }

        }
      }
    }
    if (!stack.isEmpty()) {
      return "No";
    }

    return "Yes";

  }
  
  
  public static void main(String[] args) {
    
    String s = "{}[]()";
    String s1 = "{({})}";
    String s2 = "{]";
    
    System.out.println(isBalanced(s));
    System.out.println(isBalanced(s1));
    System.out.println(isBalanced(s2));
    
    
  }

}
