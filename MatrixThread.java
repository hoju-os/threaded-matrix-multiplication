public class MatrixThread extends Thread{
    private int matrixOne [][];
    private int matrixTwo [][];

    int [][] matrixThree;

    MatrixThread(int [][]matrixOne, int[][] matrixTwo)
    {
       this.matrixOne = matrixOne;
       this.matrixTwo = matrixTwo;
    }

    public void run()
    {
        multiplyMatrix();
        printMatrixThree();
    }

    public void multiplyMatrix()
    {
        matrixThree = new int[matrixOne.length][matrixTwo[0].length];

        for (int i = 0; i < matrixOne.length; i++)
        {
            for (int j = 0; j < matrixTwo[0].length; j++)
            {
                for (int k = 0; k < matrixOne[0].length; k++)
                {
                    matrixThree[i][j] += matrixOne[i][k] * matrixTwo[k][j];
                }
            }
        }
    }

    public void printMatrixOne()
    {
        for (int i = 0; i < matrixOne.length; i++)
        {
            for (int j = 0; j < matrixOne[i].length; j++)
            {
                System.out.print(matrixOne[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printMatrixTwo()
    {
        for (int i = 0; i < matrixTwo.length; i++)
        {
            for (int j = 0; j < matrixTwo[i].length; j++)
            {
                System.out.print(matrixTwo[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printMatrixThree()
    {
        for (int i = 0; i < matrixThree.length; i++)
        {
            for (int j = 0; j < matrixThree[i].length; j++)
            {
                System.out.print(matrixThree[i][j] + " ");
            }
            System.out.println();
        }
    }
}

