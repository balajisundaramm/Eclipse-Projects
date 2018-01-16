package java_expert_practise;

import java.util.Comparator;

public class test {

	public static void main(String[] args) {
		
		int[] a=new int[]{10,20,30,40,50};
		int b=500;
		int d =0;
		String str="abcdghju";
		String x="x";
		String s="";
		s=str.replaceAll("xx", "");
		System.out.println("sssssssssssss->   "+s);
		char z='x';
		System.out.println(str.compareTo("efgh"));
		
		//System.out.println(str.endsWith("xy"));
		//System.out.println(str.substring(str.length()-2));

		/*for(int n:a){
			s=s+n+x;
		}*/
		System.out.println("int array -> to String"+s);
		System.out.println(s.indexOf("x30x"));
		System.out.println(s.indexOf("x50x"));
		System.out.println(s.substring(0,s.indexOf("x30x")+1));
		//System.out.println(s.charAt(0));
		
		//System.out.println("int array -> to String"+c);
		/*System.out.println("index of x is "+str.indexOf('x'));
		System.out.println("length of str is "+str.length());
		System.out.println("next x is "+str.indexOf('x', (str.indexOf('x')+1)));
		
		System.out.println("count of x is "+countXX(str));
		System.out.println(str.contains("x"));*/
		
		
		/*System.out.println(Character.getNumericValue(z));
		int c='4'+'4';
		System.out.println(c);
		*/
		
		
		
		
		/*StringBuilder str=new StringBuilder();
		str.insert(str.length()/2, word)
		*/
		//System.out.println(arrayFront9(a));
				
				
				
				
		//System.out.println(countConsonents(str));		
				
		//System.out.println(str.charAt((str.length()-1))+str.substring(1, (str.length()-1))+str.charAt(0));		
		//System.out.println("result is "+searchElement(a,b));
		/*for(int c:a)
		{
			b=b+c;
		}
		System.out.println("Through for each loop RESULT===>"+b);
		for(int i=0;i<(a.length);i++)
		{
			d=d+a[i];
		}
		System.out.println("Through for loop RESULT===>"+d);*/
		
	}
	public static  boolean searchElement(int[] a,int num){
		boolean z=false;
		for(int i=0;i<a.length;i++)
		{
			if(a[i]==num)
			{
				z=true;
			}
			
		}
		return z;
	}
	public static int countConsonents(String s){
		
		s=s.toLowerCase();
		int d=0;
		for(char c:s.toCharArray())
		{
			System.out.println((int)c);
			if(((int)c>96) && (int)c<123)
			{
				System.out.println("c is "+c);
				System.out.println("c & a is "+(c!='a'));
			if((c!='a') & (c!='e') & (c!='i') & (c!='o')& (c!='u'))
			{
				d=d+1;
				System.out.println(" d is "+d);
			}	
			}
		}
		return d;
	}
	/*public static boolean tripleUp(int[] nums) {
		for(int i=0;i<=nums.length-2;i++) {
		if(int[i+1]==(int[i]+1) && int[i+2]==(int[i]+2))
		return true;
		} 
		return false;
		}*/
	public static int countXX(String str)
	{
	
	str=str.toLowerCase();
	int count=0;
	if(str.contains("x"))
	{
	int c=str.indexOf('x');
	for(int i=c;i<(str.length()-1);i++) {
	if(str.charAt(c)==(str.charAt(++c)))
	count=count+1;
	}
	return count;
	}
	return count;
	}
}
class IdCompare implements Comparator<Movies>{

	@Override
	public int compare(Movies o1, Movies o2) {
		
		return o1.getId()-o2.getId();
	}
	
}
class NameCompare implements Comparator<Movies>{

	@Override
	public int compare(Movies o1, Movies o2) {
		
		return o1.getName().compareTo(o2.getName());
	}
	
}
