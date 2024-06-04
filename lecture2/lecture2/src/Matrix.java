public class Matrix {
    private int[][] matrix;

    public Matrix(int rows, int columns){
        matrix = new int [rows][columns];

    }

    public Matrix(String s){
        String[] rows = s.split("\n");
        int matrix[][] = new int [rows.length][];
        for(int i = 0; i< rows.length;i++){
            String[] elements = s.split(" ");
            matrix[i] = new int[elements.length];
            for(int j = 0; j< elements.length;j++){
                matrix[i][j] = Integer.parseInt(elements[i]);
            }
        }

    }


    private Matrix(int[][] matrix){
        this.matrix = matrix;
    }

}

