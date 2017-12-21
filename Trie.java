public class Trie
{
	Node node;
	
	//structure of node.
	class Node
	{
		int words;
		int prefixes;
		Node edges[]=new Node[26];
	}
	//initializing a node.
	public void initialize(Node node)
	{
		node.words=0;
		node.prefixes=0;
		for(int i=0;i<26;i++)
		{
			node.edges[i]=null;
		}
	}
	//adding a word to trie.
	public void addWord(Node vertex,String word)
	{
		if(word.length()==0) vertex.words++;
		else
		{
			vertex.prefixes++;
			char c=word.charAt(0);
			if(vertex.edges[c-'a']==null)
			{
				vertex.edges[c-'a']=new Node();
				initialize(vertex.edges[c-'a']);
			}
			word=word.substring(1);
			addWord(vertex.edges[c-'a'],word);
		}
	}
	//count no of words on vertex
	public int countWords(Node vertex,String word)
	{
		if(word.length()==0) return vertex.words;
		char k=word.charAt(0);
		if(vertex.edges[k-'a']==null) return 0;
		word=word.substring(1);
		return countWords(vertex.edges[k-'a'],word);
	}
	//count no of prefixes
	public int countPrefixes(Node vertex,String prefix)
	{
		if(prefix.length()==0) return vertex.prefixes;
		char ch=prefix.charAt(0);
		if(vertex.edges[ch-'a']==null) return 0;
		prefix=prefix.substring(1);
		return countPrefixes(vertex.edges[ch-'a'],prefix);
	}
	//constructor.
	public Trie()
	{
		node=new Node();
		initialize(node);
		addWord(node,"apple");
		addWord(node,"all");
		addWord(node,"all");
		addWord(node,"algorithm");
		addWord(node,"trie");
		System.out.println(countWords(node,"all"));
		System.out.println(countPrefixes(node,"a"));
	}
	//main method.
	public static void main(String args[])
	{
		new Trie();
	}
}