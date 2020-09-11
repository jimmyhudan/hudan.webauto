package com.t.webauto.web;

public class LoginPage {

	public static void main(String [] args) {

		//		int x;
		//		x=0;
		//		boolean a=false;
		//		boolean b =false;
		//		boolean c =true;
		//		if(a && (b|| c))
		//		{
		//			x=1;
		//			System.out.print(x);
		//		}
		
		


//		IsLeap(1100);
		whiletest();
	}

	public static int whiletest()
	{
		int sum=0,i=1; //i初始为第一个素数
	    while (i<=100) //循环执行的判断条件
	    {
	        sum+=i;
	        i+=2; //控制变量的增量
	    }
	    System.out.println("sum=%d\n"+sum); 
	    return 0;
	}
	public static int IsLeap(int year)
	{
		int leap;
		if(year%4==0)
		{
			if(year%100==0)
			{
				if(year%400==0)
				{
					leap=1;
				}
				else {
					leap=0;
				}
			}else
			{
				leap=1;
			}
		}else
		{
			leap=0;
		}
		return leap;

	}
}
