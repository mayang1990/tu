package tu;

public class MatrixGra {

    private char[] mVexs;       // 顶点集合
    private int[][] mMatrix;    // 邻接矩阵

    public MatrixGra(char[] vexs, char[][] edges) {
        
        // 初始化"顶点数"和"边数"
        int vlen = vexs.length;
        int elen = edges.length;

        // 初始化"顶点"
        mVexs = new char[vlen];
        for (int i = 0; i < vlen; i++)
            mVexs[i] = vexs[i];

        // 初始化"边"
        mMatrix = new int[vlen][vlen];
        for (int i = 0; i < elen; i++) {
            // 读取边的起始顶点和结束顶点
            int p1 = getPosition(edges[i][0]);
            int p2 = getPosition(edges[i][1]);

            mMatrix[p1][p2] = 1;
            mMatrix[p2][p1] = 1;
        }
    }

    /*
     * 返回ch位置
     */
  //就是因为这样，字符才转变为数字。通过它们在顶点的数组中的位置。
    private int getPosition(char ch) {
        for(int i=0; i< mVexs.length; i++)
            if(mVexs[i]==ch)
                return i;
        return -1;
    }

    /*
     * 打印矩阵队列图
     */
    public void print() {
        System.out.printf("Martix Graph:\n");
        for (int i = 0; i < mVexs.length; i++) {
            for (int j = 0; j < mVexs.length; j++)
                System.out.printf("%d ", mMatrix[i][j]);
            System.out.printf("\n");
        }
    }

    public static void main(String[] args) {
    	//自己输入顶点和边的数组。
        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        char[][] edges = {{'A', 'C'},
        				  {'A', 'D'}, 
        				  {'A', 'F'}, 
        				  {'B', 'C'}, 
        				  {'C', 'D'}, 
        				  {'E', 'G'},
        				  {'F', 'G'}};
       
         MatrixGra pG = new MatrixGra(vexs, edges);

        pG.print();   // 打印图
    }
}
