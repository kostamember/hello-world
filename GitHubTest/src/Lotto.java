
public class Lotto {
	static int[] lottoNum = new int[6];
	static int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		for(int i=0; i<6; i++) { 
			lottoNum[i] = (int) (Math.random()*45)+1;
			for(int j=0; j<i; j++) {
				if(lottoNum[j] == lottoNum[i]) {
					i--;
				}
			}
		}
		
		bubbleSort();
		
		for(int i=0; i<6; i++) {
			System.out.print(lottoNum[i]+" ");
		}
		
	}

	private static void bubbleSort() {
		// TODO Auto-generated method stub
		for(int i=5; i>0; i--) {
			for(int j=0; j<i; j++) {
				if(lottoNum[j] > lottoNum[j+1]) {
					int temp = lottoNum[j+1];
					lottoNum[j+1] = lottoNum[j];
					lottoNum[j] = temp;		
				}
			}
		}
	}
}