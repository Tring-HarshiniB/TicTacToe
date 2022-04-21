package com.example;

public class TicTacToe {
  public static Evaluation evaluationBoard(String input) {
    // Convert to lowerCase
    String inputFrom = input.toLowerCase();
    // if length is mismatch return invaludInput
    if (inputFrom.length() != 9) {
      return Evaluation.InvalidInput;
    } else {
      int x_count = 0;
      int o_count = 0;
      // get the count of x and o in a string
      for (int i = 0; i < inputFrom.length(); i++) {
        if (inputFrom.charAt(i) == 'x')
          x_count++;
        if (inputFrom.charAt(i) == 'o')
          o_count++;
      }
      // check the state
      if (Math.abs(x_count - o_count) >= 2)
        return Evaluation.UnreachableState;
      boolean x_wins = winner('x', inputFrom);
      boolean o_wins = winner('o', inputFrom);
      if ((x_wins) && (o_wins))
        return Evaluation.UnreachableState;
      else if (o_wins)
        return Evaluation.O_wins;
      else if (x_wins)
        return Evaluation.X_wins;
      else
        return Evaluation.Draw;
    }
  }

  public static boolean winner(char check, String inputs) {
    int j = 0;
    for (int i = 0; i <= 6; i += 3) {
      // row_wise checking
      if (inputs.charAt(i) == check && inputs.charAt(i + 1) == check && inputs.charAt(i + 2) == check)
        return true;
      j++;
      // column_wise checking
      if (inputs.charAt(j) == check && inputs.charAt(j + 3) == check && inputs.charAt(j + 6) == check)
        return true;
    }
    // diagonaly checking
    if (inputs.charAt(0) == check && inputs.charAt(4) == check && inputs.charAt(8) == check)
      return true;
    return (inputs.charAt(2) == check && inputs.charAt(4) == check && inputs.charAt(6) == check);
  }

  public static void main(String arg[]) {
    System.out.println("Result : " + evaluationBoard("XXX...oo."));
    System.out.println("Result : " + evaluationBoard("O...X.X.."));
    System.out.println("Result : " + evaluationBoard("o...o.xxO"));
    System.out.println("Result : " + evaluationBoard("oxooxooxo"));
  }
}
