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
        

        int [][] matrixOne = {
                {3,7,6,6},
                {3,2,8,3},
                {6,5,7,5},
                {4,8,6,9},
                {3,7,5,4},
                {3,2,6,7},
                {6,5,8,9},
                {4,8,9,3},
                {9,6,4,7}
        };
        int [][] matrixTwo = {
                {3,7,2,5},
                {3,2,9,9},
                {3,2,9,3},
                {3,7,2,7}
        };
        
        int n = matrixOne.length;
        int m = matrixOne[0].length;
        int k = matrixTwo[0].length;

        int numOfThreads = n * k;
        
        int [][] matrixThree = new int [n][k];

        Thread [][] threads = new Thread[n][k];

        for (int i = 0; i <= n-1; i++)
        {
            for (int j = 0; j <= k-1; j++)
            {
                threads[i][j]= new threadMatrix(i,j,matrixOne,matrixTwo,matrixThree);
                threads[i][j].start();
            }
        }
        for (int i = 0; i <= n-1; i++)
        {
            for (int j = 0; j <= k-1; j++)
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
