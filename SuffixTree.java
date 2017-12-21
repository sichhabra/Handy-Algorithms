import java.util.*;
public class SuffixTree
{
	class SuffixTreeNode
	{
		HashMap<Character,SuffixTreeNode> children=new HashMap<Character,SuffixTreeNode>();
		char value;
		ArrayList<Integer> indexes=new ArrayList<Integer>();
		
		public SuffixTreeNode(){}
		
		public void insert(String s,int index)
		{
			indexes.add(index);
			if(s!=null&&s.length()>0)
			{
				value=s.charAt(0);
				SuffixTreeNode child=null;
				if(children.containsKey(value)) child=children.get(value);
				else
				{
					child=new SuffixTreeNode();
					children.put(value,child);
				}
				String remainder=s.substring(1);
				child.insert(remainder,index);
			}
		}
		public ArrayList<Integer> getIndexes(String s)
		{
			if(s==null||s.length()<=0) return indexes;
			else
			{
				char first=s.charAt(0);
				if(children.containsKey(first))
				{
					String remainder=s.substring(1);
					return children.get(first).getIndexes(remainder);
				}
			}
			return null;
		}
	}
	
	SuffixTreeNode root=new SuffixTreeNode();
    public SuffixTree(String s)
    {
    	for(int i=0;i<s.length();i++) root.insert(s.substring(i),i);
    }
    public ArrayList<Integer> getIndexes(String s)
    {
    	return root.getIndexes(s);
    }
 	public static void main(String args[])
 	{
 		String test="mississippi";
 		String list[]={"i"};
 		SuffixTree tree=new SuffixTree(test);
 		for(String s:list)
 		{
 			ArrayList<Integer> ans=tree.getIndexes(s);
 			if(ans!=null) System.out.println(s+":"+ans.toString());
 		}
 	}
}