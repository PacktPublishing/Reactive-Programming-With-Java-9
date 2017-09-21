import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DemoImperative {
	
	public static void main(String[] args) {
		DemoImperative demo=new DemoImperative();
		List<String>names=new ArrayList<>();
		names.add("apple");
		names.add("grapes");
		names.add("apple");
		names.add("mango");
		names.add("chickoo");
		names.add("starwberry");
		int count=demo.matchCount(names,"apple");
		System.out.println("the counter is:-"+count);
		
		count=demo.matchCount_new(names,"apple");
		System.out.println("the counter is:-"+count);
		
	}
//	public int matchCount(List<String>names_input,String name)
//	{
//		int count=0;
//		for(String n:names_input)		{
//			if(n.equals(name))
//			{
//				count++;
//			}
//		}	
//		return count;
//	}

	public int matchCount(List<String>names_input,String name)
	{
		int count=Collections.frequency(names_input,name);
		return count;
	}

	public int matchCount_new(List<String>names_input,String name)	{
		long count=names_input.stream().
            filter(n->n.equals(name)).count();
		return (int)count;
	}

}
