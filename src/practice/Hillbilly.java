package practice;

import java.util.Scanner;

public class Hillbilly {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] mylist;  //声明一个整形数组，不分配空间
		mylist = new int[10];
		/*for(int i=0; i<mylist.length; i++){
			mylist[i] = i;
		}*/
		for(int i=0; i<mylist.length; i++){
			mylist[i] = (int) (Math.random() * 100);
			
		}
		for(int i=0; i<mylist.length; i++){
			System.out.print(mylist[i]+" ");
			
		}
		//String[] name = new String[10];    //动态初始化
		String name[] = {"name3","name4"};
		System.out.print(name[1]);
		
		String user[] = {"name1","name2"};//字符串数组的静态初始化
		System.out.print(user[0]);
		
		char[] info = {'S','h','i','n','y'};
		System.out.print(info);  //字符型数组的话直接放数组名不用索引
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number for sth");
		double sth = input.nextDouble();
		
		double area = sth *sth*3.14;
		System.out.println(area);  //println and print have some differences
		
		
		
		
	}

}
