package tu;

public class MatrixGra {

    private char[] mVexs;       // ���㼯��
    private int[][] mMatrix;    // �ڽӾ���

    public MatrixGra(char[] vexs, char[][] edges) {
        
        // ��ʼ��"������"��"����"
        int vlen = vexs.length;
        int elen = edges.length;

        // ��ʼ��"����"
        mVexs = new char[vlen];
        for (int i = 0; i < vlen; i++)
            mVexs[i] = vexs[i];

        // ��ʼ��"��"
        mMatrix = new int[vlen][vlen];
        for (int i = 0; i < elen; i++) {
            // ��ȡ�ߵ���ʼ����ͽ�������
            int p1 = getPosition(edges[i][0]);
            int p2 = getPosition(edges[i][1]);

            mMatrix[p1][p2] = 1;
            mMatrix[p2][p1] = 1;
        }
    }

    /*
     * ����chλ��
     */
  //������Ϊ�������ַ���ת��Ϊ���֡�ͨ�������ڶ���������е�λ�á�
    int getPosition(char ch) {
        for(int i=0; i< mVexs.length; i++)
            if(mVexs[i]==ch)
                return i;
        return -1;
    }

    /*
     * ��ӡ�������ͼ
     */
    public void print() {
        System.out.printf("Martix Graph:\n");
        for (int i = 0; i < mVexs.length; i++) {
            for (int j = 0; j < mVexs.length; j++)
                System.out.printf("%d ", mMatrix[i][j]);
            System.out.printf("\n");
        }
    }
    
    /*
     * ����k
     */
    public int cal_k(int i){
    	int k1=0;
    	for(int j=0;j<mVexs.length;j++){
    		if(mMatrix[i][j]==1)
    			k1++;
    	}
		return k1;
    }
    
    /*
	 * ����ģ���
	 */
    public void cal_Q(char [][] list){
    	int A=0;
    	int k=0;
    	int M=0;
    	
    	//��ӡList
    	System.out.printf("List:\n");
	    for (int i = 0; i < list.length; i++) {
	 		 for (int j = 0; j < list[i].length; j++)
	 			 System.out.printf("%c ", list[i][j]);
	 		 System.out.printf("\n");
	 		 }
	    
	    //���� M , M=2m
    	for(int i = 0;i<mVexs.length;i++){
    		for(int j=0;j<mVexs.length;j++){
    			if(mMatrix[i][j]==1)
    				M++;
    			}
    		}
    	System.out.printf("%d",M);
    	System.out.printf("\n");
            
    	//��ʼ��"���Ź�ϵ����"			
    	for(int i=0;i<list.length;i++){
    		for(int j1 = 1;j1<list[i].length;j1++){
    			for(int j2 = j1+1;j2<list[i].length;j2++){
    			
    			int p=getPosition(list[i][j1]);
    			int q=getPosition(list[i][j2]);
    			
    			System.out.printf("p=%d ",p);
    			System.out.printf("q=%d ",q);
    			System.out.printf("\n");
    			
    			if(mMatrix[p][q]==1)
    				A=A+2;
    			
    			int k1=cal_k(p);
    			
    			System.out.printf("k1=%d \n",k1);
				int k2=cal_k(q);
				
				System.out.printf("k2=%d \n",k2);
				k += k1*k2;
				
				System.out.printf("k=%d \n",k);
    				}
    			}
    		System.out.printf("\n");
    		}
    	
    	k=2*k;
    	
    	System.out.printf("A=%d \n",A);
    	System.out.printf("k=%d \n",k);
    	
    	float q1=((float)1/M)*A;
    	
    	System.out.printf("q1=%f ",q1);
    	float q2=((float)1/(M*M)) * k;
    	
    	System.out.printf("q2=%f ",q2);
    	float q=q1-q2;
    	
    	System.out.printf("\n");
    	System.out.printf("Q= %f",q);
    	}
    
    }
