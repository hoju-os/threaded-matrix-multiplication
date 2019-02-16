public class MatrixMain {
    public static void main(String[] args) {
        int [][] matrixOne = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int [][] matrixTwo = {
                {9,2,5},
                {12,5,3},
                {60,8,100}
        };

        int numOfThreads = 2;
        int s = matrixOne.length/numOfThreads;
        int n = matrixOne.length;

        MatrixThread one = new MatrixThread(matrixOne,matrixTwo);

        one.printMatrixOne();
        System.out.println();
        one.printMatrixTwo();
        System.out.println();

        one.start();

    }
}
