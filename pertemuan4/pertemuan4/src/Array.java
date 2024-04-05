public class Array {

    public static void main(String[] args) {
      int[] oneDimArray = {1, 2, 3, 4, 5};
  
      // Initialize two-dimensional array
      int[][] twoDimArray = {
          {1, 2, 3},
          {4, 5, 6},
          {7, 8, 9},
      };
  
      // Print one-dimensional array
      System.out.println("Satu-dimensi array (One-dimensional array)");
      for (int i = 0; i < oneDimArray.length; i++) {
        System.out.print(oneDimArray[i] + " ");
      }
      System.out.println();
  
      // Print two-dimensional array
      System.out.println("Menampilkan dua dimensi array (Displaying two-dimensional array)");
      for (int i = 0; i < twoDimArray.length; i++) {
        for (int j = 0; j < twoDimArray[i].length; j++) {
          System.out.print(twoDimArray[i][j] + " ");
        }
        System.out.println();
      }
    }
  }  