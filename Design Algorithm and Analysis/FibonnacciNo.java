import java.util.Scanner;

public class FibonnacciNo {
	//non-recursive approach
	static int fibNum(int num) {
		int prev= 0;
		int curr= 1;
		
		int count= 2;
		
		if(num==0) {
			prev = curr;
		}
		else {
			while(count<=num) {
				int temp = curr;
				curr = curr+prev;
				prev = temp;
				count++;		
			}
		}
		return curr;
	}	
	
	//Recursive Approach
	static int recursiveFib(int num){
		if(num<2)
			return num;
		else		
			return recursiveFib(num-1)+recursiveFib(num-2);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number to obtain fibonnacci number: ");
		int num = sc.nextInt();
		
		System.out.println(fibNum(num));
		System.out.println(recursiveFib(num));
	}

}
