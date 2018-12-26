import java.util.Scanner;

/**
 * N元一次解法
 * @author ZhangYang
 *
 */
public class aa {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int i, j, m, n, r, k=0, t;
		System.out.print("请输入未知数个数n和方程的个数r:");
		n = input.nextInt();
		r = input.nextInt();
		
		double[][] a = new double[11][20];
		System.out.println("请输入方程组参数:");
		for (j = 0; j < n; j++) {
			for (i = 0; i < r + 1; i++) {
				a[j][i] = input.nextDouble();
			}
		}
		if(r < n) {
			System.out.println("方程有无穷解");
		}
		if(r == n) {
			System.out.println("方程有唯一解");
			for (t = 0;  t< n - 1; t++) {
				for (m = 0;  m < n; m++) {
					for(j = 0; j<n ; j++) {
						if(j != m) {
							double b = a[j][m] / a[m][m];
							for(i = 0;i<n+1;i++) {
								a[j][i] -= a[m][i] * b;
							}
						}
					}
				}
			}
			for (j = 0;  j< n; j++) {
				a[j][n] /=a[j][j];    
                a[j][j] /=a[j][j];
			}
		}
		for (j = 0;  j< r; j++) {
			System.out.printf("x[%d] = %f\n", j, a[j][n]);
		}
	}

}
