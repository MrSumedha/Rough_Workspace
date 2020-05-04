package main;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	static int findInvFromPos(int[] arr, int pos) {
		int inv = 0;
		for (int i = pos; i < arr.length; i++) {
			if (arr[pos] > arr[i]) {
				inv++;
			}
		}
		return (inv > 2)? -1 : inv;
	}

	// Complete the minimumBribes function below.
	static void minimumBribes(int[] q) {
		int chao = 0;
		for (int i = 0; i < q.length; i++) {
			int invPos = (q[i] > (i+1)) ? (q[i] - i - 1) : 0;
			if (invPos > 2) {
				System.out.println("Too chaotic");
				return;
			} else {
				chao += invPos;
			}
		}
		System.out.println(chao);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] q = new int[n];

			String[] qItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int qItem = Integer.parseInt(qItems[i]);
				q[i] = qItem;
			}

			minimumBribes(q);
		}

		scanner.close();
	}
}
