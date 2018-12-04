import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/*
 * Requirement:
 * You are required to implement all methods recursively.
 * You receive a zero if there is any occurrence of a loop (e.g., for, while).  
 */
public class RecursiveMethods {
	/**
	 * Return an array storing the first n numbers in a Fibonacci sequence.
	 * The Fibonacci starts with the first two numbers being 1 and 1, then 
	 * starting from the 3rd number, it is the sum of the previous two numbers.  
	 * You can assume that n is positive.
	 * e.g., fibArray(5) returns an array {1, 1, 2, 3, 5}.
	 * @param n the first n Fibonacci numbers 
	 * @return an array representing the first n Fibonacci numbers
	 * 
	 * You are forbidden to use the fibList method below to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while). 
	 */
	public int[] fibArray(int n) {
		/* Your Task. */
		if(n==0){
			int[]seq = {};
			return seq;
			
		}else if(n==1){
			int[]seq = {1};
			return seq;
		}else if(n==2){
			int[]seq = {1,1};
			return seq;
		}else{
            int[] seq = new int[n];
            seq[0] = 1;
            seq[1] = 1;
            fibArrayHelper(2, seq,n);   // fibArrayHelper recursively fills in the rest of seq
            return seq;
		}
		
	} 
	
	void fibArrayHelper(int i, int[]seq,int n){
		if(i < n){
			
			seq[i] = seq[i-1] + seq[i-2];
			fibArrayHelper(i+1,seq,n);
		}
	
	}
	
	/**
	 * Return a list storing the first n numbers in a Fibonacci sequence.
	 * The Fibonacci starts with the first two numbers being 1 and 1, then 
	 * starting from the 3rd number, it is the sum of the previous two numbers.  
	 * You can assume that n is positive.
	 * e.g., fibList(5) returns a list {1, 1, 2, 3, 5}.
	 * @param n the first n Fibonacci numbers 
	 * @return a list representing the first n Fibonacci numbers
	 * 
	 * You are forbidden to use the fibArray method above to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
	 */
	public List<Integer> fibList(int n) {
		/* Your Task. */
		List<Integer>list = new ArrayList<Integer>();
		if(n ==0){
			
			return list;
		}else if(n==1){
			list.add(1);
			return list;
		}else if(n==2){
			list.add(1);
			list.add(1);
			return list;
		}else{
			list.add(1);
			list.add(1);
			fibListHelper(2,list,n);
			return list;
		}
	}
	void fibListHelper(int i, List<Integer>seq,int n){
		if(i < n){
			
			seq.add(seq.get(i-1) + seq.get(i-2));
			fibListHelper(i+1,seq,n);
		}
		
	}
	
	/**
	 * Return whether or not an array represents the first n numbers in a Fibonacci sequence.
	 * The Fibonacci starts with the first two numbers being 1 and 1, then 
	 * starting from the 3rd number, it is the sum of the previous two numbers.  
	 * The array may or may not be empty.
	 * e.g., isFibArray({1, 2}) returns false and isFibArray({1, 1, 2, 3, 5, 8}) returns true.
	 * @param a an array
	 * @return true if input array a (of length n) represents the first n Fibonacci numbers; false otherwise.
	 * 
	 * You are forbidden to use the isFibList method below to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
	 */
	public boolean isFibArray(int[] a) {
		/* Your Task. */
		if(a.length == 1){
			if(a[0] == 1){
				return true;
			}else{
				return false;
			}
		}else if(a.length==2){
			if(a[0]==1 && a[1]==1){
				return true;
			}else{
				return false;
			}
		}else if(a.length >2){
			if
		}
	}
	
	void isFibArrayHelper(int[]a){
		
	}
	
	/**
	 * Return whether or not a list represents the first n numbers in a Fibonacci sequence.
	 * The Fibonacci starts with the first two numbers being 1 and 1, then 
	 * starting from the 3rd number, it is the sum of the previous two numbers.  
	 * The array may or may not be empty.
	 * e.g., isFibList({1, 2}) returns false and isFibList({1, 1, 2, 3, 5, 8}) returns true.
	 * @param a an array
	 * @return true if input list a (of length n) represents the first n Fibonacci numbers; false otherwise.
	 * 
	 * You are forbidden to use the isFibArray method above to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
	 */
	public boolean isFibList(List<Integer> list) {
		/* Your Task. */
		if(list.size() == 1){
			if(list.get(0)==1){
				
			return true;
			}else{
				
				return false;
			}
		}else if(list.size() == 2){
			if(list.get(0)==1 && list.get(1) == 1 ){
				
				return true;
			}else{
				
				return false;
			}
		}else if(list.size()>2){
			
			if(((list.get(list.size()-2) + list.get(list.size()-3))) == list.get(list.size()-1)){
				
				return isFibList(list.subList(0, list.size()-1));
			}else{
				return false;
			}
		}else{
			return false;
		}
		
		
	}
	
	/**
	 * Given a sorted input array a, return a sorted array of size a.length + 1, 
	 * consisting of all elements of array a and integer i.
	 * @param a an array that is sorted in a non-descending order
	 * @param i an integer
	 * @return a sorted array of size a.length + 1, consisting of all elements of array a and integer i.
	 * e.g., insertIntoSortedArray({1, 2, 4, 5}, 3) returns a sorted array {1, 2, 3, 4, 5}.
	 * 
	 * You are forbidden to use the insertIntoSortedList method below to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
	 */
	public int[] insertIntoSortedArray(int[] a, int i) {
		/* Your Task. */
		if(a.length==0){
			int size = a.length+1;
			a = new int[size];
			//fill in array
			insertIntoSortedArrayHelper(a,start);
			a[size] = i;
		}
		
		if(i<a[0]){
			int size = a.length+1;
			a = new int[size];
			//fill in array
			insertIntoSortedArrayHelper(a,start);
			a[0] = i;
		}
		
		int j = a.length-1;
		
		if(i<a[j]){
			if(i>= a[j-1]){
				
			}else{
				insertIntoSortedArray(Arrays.copyOfRange(a, 0, j-1),i);
			}
			
		}else{
			
		}
		
		
		return list;
	}
	
	
	/**
	 * Given a sorted input list, return a sorted list of size list.size() + 1, 
	 * consisting of all elements of the input list and integer i.
	 * @param list a list that is sorted in a non-descending order
	 * @param i an integer
	 * @return a sorted list of size list.size() + 1, consisting of all elements of the input list and integer i.
	 * e.g., insertIntoSortedList({1, 2, 4, 5}, 3) returns a sorted list {1, 2, 3, 4, 5}.
	 * 
	 * You are forbidden to use the insertIntoSortedArray method above to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
	 */
	public List<Integer> insertIntoSortedList(List<Integer> list, int i) {
		/* Your Task. */
		if(list.size()==0){
			list.add(i);
			return list;
		}
		if(i < list.get(0)){
			list.add(0, i);
			return list;
		}
		
		
		
		int j = list.size()-1;  //last index
		
		if(i<list.get(j)){ // compare i with last entry
			if(i>=list.get(j-1)){//compare i with second last index
				list.add(j, i);
				return list;
			}else{
				insertIntoSortedList(list.subList(0, j-1),i);
				
			}
			
		}else{//if i > last entry
			list.add(i);
			return list;
			//return insertIntoSortedList(list.subList(0, list.size()-2),i);
		}
		
		return list;
	}
	
	/**
	 * Given two sorted arrays left and right, 
	 * return a sorted array of size left.length + right.length, 
	 * consisting of all elements of arrays left and right.
	 * @param left a sorted array
	 * @param right a sorted array 
	 * @return a sorted array of size left.length + right.length, consisting of all elements of arrays left and right.
	 * e.g., mergeSortedArrays({1, 3, 5, 7}, {2, 4, 6, 8}) returns a sorted array {1, 2, 3, 4, 5, 6, 7, 8}.
	 * 
	 * You are forbidden to use the mergeSortedLists method below to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
	 */
	public int[] mergeSortedArrays(int[] left, int[] right) {
		/* Your Task. */
		if(left.length == 0){return right;
		
		}
		
		if(right.length ==0){return left;}
		
		int[] result = new int[left.length+right.length];
		
		if(left[0] < right[0]){
			result[]
		}
	}
	
	/**
	 * Given two sorted lists left and right, 
	 * return a sorted list of size left.size() + right.size(), 
	 * consisting of all elements of lists left and right.
	 * @param left a sorted list
	 * @param right a sorted list 
	 * @return a sorted list of size left.size() + right.size(), consisting of all elements of lists left and right.
	 * e.g., mergeSortedLists({1, 3, 5, 7}, {2, 4, 6, 8}) returns a sorted list {1, 2, 3, 4, 5, 6, 7, 8}.
	 * 
	 * You are forbidden to use the mergeSortedArrays method above to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
	 */
	public List<Integer> mergeSortedLists(List<Integer> left, List<Integer> right) {
		  if (right.size() == 0) return left;
		  if (left.size() == 0) return right;

		  List<Integer> result = new ArrayList<Integer>();

		  if (left.get(0) < right.get(0))   
		    result.add(left.remove(0));
		  else
		    result.add(right.remove(0));

		  result.addAll(mergeSortedLists(left, right));

		  return result; 
}
}
