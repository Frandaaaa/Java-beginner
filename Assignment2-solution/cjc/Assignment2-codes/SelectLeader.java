import java.util.*;

public class SelectLeader {
	
	public static void main(String[] args) {
		System.out.println("�����뾺ѡ�鳤����������");
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		
		Boolean[] isLeader = new Boolean[number];
		for(int i = 0; i < isLeader.length; i++) {
			isLeader[i] = true; //��ʼ��ʱ��ÿ���˶�û����̭������Ϊtrue
		}
		
		int j = 0, k = 0; //k��ʾ����̭��������j����������
		for(int i = 0; i < isLeader.length; i++) {
			
			if(k < isLeader.length - 1) {//ֻ����̭��������һ��ʱ���ִ�С�
				if(isLeader[i]) {
					j++;//ֻ��û����̭���˲ű���
				}
				if(j == 4) {
					isLeader[i] = false;
					j = 0;
					k++;
				}
				if(i == (isLeader.length - 1)) {
				    i = -1;
			    }
			}else {
				break;
			}
		}
		for(int i = 0; i < isLeader.length; i++) {
			if(isLeader[i]) {
				System.out.println("�鳤�Ǳ��Ϊ��" + (i + 1) + " ���ˣ������ǹ�ϲ����");
			}
		}
		//System.out.println(Arrays.toString(isLeader));
	}
}
