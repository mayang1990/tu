package tu;

public class tu {
    public static void main(String[] args) {
    	//�Լ����붥��ͱߵ����顣
        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        char[][] edges = {{'A', 'C'},
        				  {'A', 'D'}, 
        				  {'A', 'F'}, 
        				  {'B', 'C'}, 
        				  {'C', 'D'}, 
        				  {'E', 'G'},
        				  {'F', 'G'}};
       char [][] list={{'M','A','B','C','D'},{'N','E','F','G'}};

         MatrixGra pG = new MatrixGra(vexs, edges);
         
        pG.print();   // ��ӡͼ
        pG.cal_Q(list);//���ģ���
    }
}
