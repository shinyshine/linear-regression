package practice;

import java.util.Scanner;

public class Hillbilly {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] mylist;  //����һ���������飬������ռ�
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
		//String[] name = new String[10];    //��̬��ʼ��
		String name[] = {"name3","name4"};
		System.out.print(name[1]);
		
		String user[] = {"name1","name2"};//�ַ�������ľ�̬��ʼ��
		System.out.print(user[0]);
		
		char[] info = {'S','h','i','n','y'};
		System.out.print(info);  //�ַ�������Ļ�ֱ�ӷ���������������
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number for sth");
		double sth = input.nextDouble();
		
		double area = sth *sth*3.14;
		System.out.println(area);  //println and print have some differences
		
		
		
		
	}

}
