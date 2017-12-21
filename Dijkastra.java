import java.io.*;
import java.util.*;
public class Dijkastra
{
	class Vertex implements Comparable<Vertex>
	{
		public final String name;
		public Edge[] adjacencies;
		public double minDistance=Double.POSITIVE_INFINITY;
		public Vertex previous;
		public String toString() {return name;}
		public Vertex(String arg) {name=arg;}
		public int compareTo(Vertex other){return Double.compare(minDistance,other.minDistance);}
	}
	class Edge
	{
		public final Vertex target;
		public final double weight;
		public Edge(Vertex argTarget,double argWeight){target=argTarget;weight=argWeight;}
	}
	public void computePaths(Vertex source)
	{
		source.minDistance=0;
		PriorityQueue<Vertex> vertexQueue=new PriorityQueue<Vertex>();
		vertexQueue.add(source);
		while(!vertexQueue.isEmpty());
		{
			Vertex u=vertexQueue.poll();
			for(Edge e:u.adjacencies)
			{
				Vertex v=e.target;
				double weight=e.weight;
				double distanceThroughU=u.minDistance+weight;
				if(distanceThroughU<v.minDistance)
				{
					vertexQueue.remove(v);
					v.minDistance=distanceThroughU;
					v.previous=u;
					vertexQueue.add(v);
				}
			}
		}
	}
	public List<Vertex> getShortestPathTo(Vertex target)
    {
        List<Vertex> path = new ArrayList<Vertex>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);
        Collections.reverse(path);
        return path;
    }
    public Dijkastra()
    {
    	
    }
    public static void main(String args[])
    {
    	new Dijkastra();
    }
}