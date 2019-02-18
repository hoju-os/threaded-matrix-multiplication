public class MatrixThread extends Thread {
    private int i, j;
    private int [][] matrixOne, matrixTwo, matrixThree;

    MatrixThread(int i, int j, int [][] matrixOne, int [][] matrixTwo, int [][] matrixThree)
    {
        super();
        this.i = i;
        this.j = j;
        this.matrixOne = matrixOne;
        this.matrixTwo = matrixTwo;
        this.matrixThree = matrixThree;
    }

    public void run ()
    {
        matrixThree[i][j] = (matrixOne[i][0] * matrixTwo[0][j])+(matrixOne[i][1] * matrixTwo[1][j]);
    }

    public static void main(String[] args) throws InterruptedException {
        int n = 4;
        int m = 2;
        int k = 3;

        int numOfThreads = n * k;

        int [][] matrixOne = {
                {3,7},
                {3,2},
                {6,5},
                {4,8}
        };
        int [][] matrixTwo = {
                {3,7,2},
                {3,2,9},
        };
        int [][] matrixThree = new int [n][k];

        Thread [][] threadMatrix = new Thread[n][k];

        System.out.println("Matrix A\n");
        for (int i = 0; i < matrixOne.length; i++)
        {
            for(int j = 0; j < matrixOne[0].length; j++)
            {
                System.out.print(matrixOne[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("\n\n");

        System.out.println("Matrix B\n");
        for (int i = 0; i < matrixTwo.length; i++)
        {
            for(int j = 0; j < matrixTwo[0].length; j++)
            {
                System.out.print(matrixTwo[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("\n\n");

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < k; j++)
            {
                threadMatrix[i][j]= new MatrixThread(i,j,matrixOne,matrixTwo,matrixThree);
                threadMatrix[i][j].start();
            }
        }
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < k; j++)
            {
                threadMatrix[i][j].join();
            }
        }

        System.out.println("Matrix C\n");
        for (int i = 0; i < matrixThree.length; i++) {
            for (int j = 0; j < matrixThree[i].length; j++) {
                System.out.print(matrixThree[i][j] + "\t");
            }
            System.out.println();
        }

    }
}
