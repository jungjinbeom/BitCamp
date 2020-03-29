package apiTest;
import java.util.Random;
import java.util.Scanner;

public class Lotto {
			start();



		int i =1;
		int lotto[]=new int[7];
		int cnt = 1;
		
		void  getInput() {
			Scanner scan = new Scanner(System.in);
			System.out.print("게임수 =");//게임수 입력 
			int game = scan.nextInt();
			gameRepeat(game);
			}
			
		void  gameRepeat(int game) {
				for (int cnt = 0;cnt<game ;cnt++) {
					lottoNumber();
				}
			}
			
				void lottoNumber() {
					Random ran = new  Random();
					int lotto[]=new int[7];
					
					for (int i= 0;i<lotto.length;i++ ){//0,1,2,3,4,5,6,7
						 lotto[i] = ran.nextInt(45)+1;//번호 생성 1~45
						 
						 redundancyCheck();
								
			
				}
			}
				void redundancyCheck() {
				 //중복검사 
				 for (int j= 0; j<i; j++ ){
					 if (lotto[j] == lotto[i]){
						  i--;
						  bubbleSort();
					 }
				 }
			}
				void bubbleSort(int redundancyCheck) {
					for (int x =0; x<lotto.length-2 ;x++ ){//0,1,2,3,4,5
						for (int idx = 0;idx<lotto.length-2 ;idx++ ){//버블정렬
							//비교후 값교환하기 
							if (lotto[idx] >lotto[idx+1]){
								int temp = lotto[idx];
								lotto[idx]=lotto[idx+1];
								lotto[idx+1] = temp;
								prn(bubbleSort);
						}
				}
			}
		}
		
				

		void prn(int bubbleSort) {
			System.out.print(cnt+"게임=");
			for (int i=0;i<lotto.length-1 ;i++ ){//0,1,2,3,4,5
				System.out.printf("%5d",lotto[i]);
				if(i<5)
					System.out.print(",");
			}
		}
		

				

					
				

		
		
				
			public static void main(String[] args) {
				Lotto lotto = new Lotto();
				}
}

