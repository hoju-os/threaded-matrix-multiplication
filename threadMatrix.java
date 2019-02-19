public class threadMatrix extends Thread {
    private int i, j;
    private int [][] matrixOne, matrixTwo, matrixThree;
    int product = 0;

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

        //matrixThree[i][j] = (matrixOne[i][0] * matrixTwo[0][j])+(matrixOne[i][1] * matrixTwo[1][j])+(matrixOne[i][2] * matrixTwo[2][j]);
        for(int k = 0; k <= matrixOne[0].length-1; k++)
        {
            product += (matrixOne[i][k] * matrixTwo[k][j]);
        }
        matrixThree[i][j] = product;

    }

    public static void main(String[] args) throws InterruptedException {


        int [][] matrixOne = {
                {3,7,6,6,6,3,3},
                {3,7,6,6,6,3,3},
                {3,7,6,6,6,3,3}

        };
        int [][] matrixTwo = {
                {3,7,2,5},
                {3,2,9,9},
                {3,2,9,3},
                {3,7,2,7},
                {3,2,9,3},
                {3,7,2,7},
                {3,7,2,7}

        };


        int n = matrixOne.length;
        int m = matrixOne[0].length;
        int k = matrixTwo[0].length;


        int numOfThreads = n * k;

        int [][] matrixThree = new int [n][k];

        Thread [][] threads = new Thread[n][k];

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

        System.out.println("Matrix C\n");
        for (int i = 0; i < matrixThree.length; i++) {
            for (int j = 0; j < matrixThree[i].length; j++) {
                System.out.print(matrixThree[i][j] + "\t");
            }
            System.out.println();
        }



    }
}
