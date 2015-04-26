package practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class regression {
	public static void main(String[] args) throws Exception {
		// 文件写入并赋值

		BufferedReader data = new BufferedReader(new FileReader(new File(
				"D:\\eclipse\\trainingset.txt")));
		String s;
		String[] array = new String[3];
		int i = 0;
		double[] x1 = new double[35];
		double[] x2 = new double[35];
		double[] y = new double[35];

		while ((s = data.readLine()) != null) {
			if (s.trim().isEmpty()) {
				continue;
			}
			array = s.split(",");
			x1[i] = Double.valueOf(array[0]);
			x2[i] = Double.valueOf(array[1]);
			y[i] = Double.valueOf(array[2]);
			i++;
		}

		data.close();
		double[] Ave = new double[3];
		double sum1 = 0, sum2 = 0, sum3 = 0;
		// 求平均值
		for (i = 0; i < 35; i++) {
			sum1 = sum1 + x1[i];
			sum2 = sum2 + x2[i];
			sum3 = sum2 + y[i];
		}
		Ave[0] = sum1 / 35;
		Ave[1] = sum2 / 35;
		Ave[2] = sum3 / 35;

		// 对每个数组进行排序，求最大值和最小值的差值
		// 创建三个数组的副本
		double[] X1 = x1.clone();
		double[] X2 = x2.clone();
		double[] Y = y.clone();

		X1 = order(X1, X1.length);
		X2 = order(X2, X2.length);
		Y = order(Y, Y.length);

		// 原来三个数组的归一化
		x1 = scale(X1, x1, Ave[0]);
		x2 = scale(X2, x2, Ave[1]);
		y = scale(Y, y, Ave[2]);

		// 梯度下降
		double m0 = 1, m1 = 1, m2 = 1;
		double n = 0.01; // 步长

		for (i = 0; i < 7000; i++) {
			double Sum0 = 0, Sum1 = 0, Sum2 = 0;
			for (int j = 0; j < 35; j++) {
				Sum0 = Sum0 + (m0 + m1 * x1[j] + m2 * x2[j] - y[j]);
				Sum1 = Sum1 + (m0 + m1 * x1[j] + m2 * x2[j] - y[j]) * x1[j];
				Sum2 = Sum2 + (m0 + m1 * x1[j] + m2 * x2[j] - y[j]) * x2[j];
			}
			m0 = m0 - n / 35 * Sum0;
			m1 = m1 - n / 35 * Sum1;
			m2 = m2 - n / 35 * Sum2;

			// 计算cost function；
			double plus = 0;
			double cost = 0;
			for (int t = 0; t < 35; t++) {
				plus = plus + (m0 + m1 * x1[t] + m2 * x2[t] - y[t])
						* (m0 + m1 * x1[t] + m2 * x2[t] - y[t]);

			}
			cost = plus / 70;
			System.out.print(m0 + " " + m1 + " " + m2 + " " + cost + "\n");

		}
		double price, area, room;
		@SuppressWarnings("resource")
		Scanner x = new Scanner(System.in);
		System.out.print("请输入房子的面积：");
		area = x.nextDouble();
		area = (area - Ave[0]) / (X1[X1.length - 1] - X1[0]);
		System.out.print("请输入房间个数：");
		room = x.nextDouble();
		room = (room - Ave[1]) / (X2[X2.length - 1] - X2[0]);
		price = m0 + m1 * area + m2 * room;
		price = price * (Y[Y.length - 1] - Y[0]) + Ave[2];
		System.out.print("预测房子的价格为：" + price);
	}

	private static double[] scale(double[] X1, double[] x1, double average) {
		for (int s = 0; s < x1.length; s++) {
			x1[s] = (x1[s] - average) / (X1[X1.length - 1] - X1[0]);
		}
		return x1;
	}

	private static double[] order(double[] a, int n) {
		int j, s, p;
		double t;
		for (j = 0; j < n - 1; j++) {
			p = j;
			for (s = j + 1; s < n; s++) {
				if (a[s] < a[p])
					p = s;
			}
			if (p != j) {
				t = a[p];
				a[p] = a[j];
				a[j] = t;
			}
		}
		return a;

	}

}
