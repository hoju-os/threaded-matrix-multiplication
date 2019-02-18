public class threadMatrix extends Thread {
    private int i, j;
    private int [][] matrixOne, matrixTwo, matrixThree;

    threadMatrix(int i, int j, int [][] matrixOne, int [][] matrixTwo, int [][] matrixThree)
    {
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

        Thread [][] threads = new Thread[n][k];

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                threads[i][j]= new threadMatrix(i,j,matrixOne,matrixTwo,matrixThree);
                threads[i][j].start();
            }
        }
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                threads[i][j].join();
            }
        }

        for (int i = 0; i < matrixThree.length; i++) {
            for (int j = 0; j < matrixThree[i].length; j++) {
                System.out.print(matrixThree[i][j] + " ");
            }
            System.out.println();
        }

    }
}
