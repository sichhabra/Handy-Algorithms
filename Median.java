import java.util.*;
public class Median
{
	private Comparator<Integer> maxHC,minHC;
	private PriorityQueue<Integer> maxHeap,minHeap;
	
	public void addNumber(int number)
	{
		if(maxHeap.size()==minHeap.size())
		{
			if(minHeap.peek()!=null&&number>minHeap.peek())
			{
				maxHeap.offer(minHeap.poll());
				minHeap.offer(number);
			}
			else maxHeap.offer(number);
		}
		else
		{
			if(number<maxHeap.peek())
			{
				minHeap.offer(maxHeap.poll());
				maxHeap.offer(number);
			}
			else minHeap.offer(number);
		}
	}
	public double getMedian()
	{
		if(maxHeap.isEmpty()) return minHeap.peek();
		else if(minHeap.isEmpty()) return maxHeap.peek();
		if(maxHeap.size()==minHeap.size()) return (minHeap.peek()+maxHeap.peek())/2;
		else if(maxHeap.peek()>minHeap.peek()) return maxHeap.peek();
		else return minHeap.peek();
	}
}