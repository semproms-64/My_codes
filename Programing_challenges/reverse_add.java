/*
 * Author: Semproms
 * Date:
 * ID: 10018
 * Accepted: Yes
*/

import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

class reverse_add {

	private static long get_reverse(long num) {
		long result = 0;
		long i;
		for (i = num; i != 0; i /= 10) {
			result = result * 10 + i % 10;
		}
		return result;
	}

	private static boolean is_palindrome(long num) {
		long n = num;
		long rev = 0;
		long dig = 0;

		while(num > 0) {
			dig = num % 10;
			rev = rev * 10 + dig;
			num = num/10;
		}

		if (n == rev) {
			return true;
		}
		else
			return false;
	}

	public static void main(String[] args) throws Exception {
		String cad;
		int n;
		long reverse = 0;
		long num = 0;
		int i;
		int cycles;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());

		for (i = 0; i < n; i++) {

			cad = in.readLine();
			StringTokenizer tokens = new StringTokenizer(cad);
			num = Long.parseLong(tokens.nextToken());
			boolean finish = false;
			cycles = 0;

			while (!finish) {
				reverse = get_reverse(num);
				num = num + reverse;
				cycles++;
				if (is_palindrome(num)) {
					finish = true;
				}
			}

			System.out.printf("%d %d\n",cycles, num);
		}
	}
}