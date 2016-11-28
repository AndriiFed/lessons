import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;

public class ExpressionEvaluationTest {
  @Test
  public void test1() {
    Expression expr = new Expression();
    assertThat(expr.evaluate("(1 + ((2 + 3) * (4 * 5)))"), is(101));
  }

  private class Expression {
    private Stack<Integer> operands = new Stack<>();
    private Stack<Character> operators = new Stack<>();

    int evaluate(String strExpr) {
      for (int i = 0; i < strExpr.length(); i++) {
        char ch = strExpr.charAt(i);
        if ("*/+-".indexOf(ch) != -1) {
          operators.push(ch);
        } else if (Character.isDigit(ch)) {
          operands.push(Character.getNumericValue(ch));
        } else if (ch == ')') {
          int result = operands.pop();
          char operation = operators.pop();
          switch (operation) {
            case '+': result += operands.pop(); break;
            case '-': result -= operands.pop(); break;
            case '*': result *= operands.pop(); break;
            case '/': result /= operands.pop(); break;
          }
          operands.push(result);
        }
      }
      return operands.pop();
    }

    private class Stack<T> {
      private Object[] elements = new Object[10];
      private int size = 0;

      void push(T item) {
        if(isFull()) {
          increaseCapacity();
        }
        elements[size] = item;
        size++;
      }

      private boolean isFull() {
        return elements.length == size;
      }

      private void increaseCapacity() {
        elements = Arrays.copyOf(elements, elements.length * 2);
      }

      @SuppressWarnings("unchecked")
      T pop() {
        size--;
        return (T) elements[size];
      }
    }
  }
}
