import java.util.ArrayList;
import java.util.LinkedList;

public class LinkListPolynomial implements PolynomialInterface, Comparable<Object> {

	private LinkedList<LLPolyNode> nodeArray = new LinkedList<LLPolyNode>();
	//private LLPolyNode next;
	private LLPolyNode previous;
	private LLPolyNode current = null;
	private int location = 0;
	// private Node node;

	public LinkListPolynomial() {

	}

	public LinkListPolynomial(String polyString) {

		stringToArray(polyString);
	}

	public LinkedList<LLPolyNode> getArray() {
		return nodeArray;
	}

	private boolean insert(){
		LLPolyNode newNode = new LLPolyNode();
		
		if(nodeArray == null)
			return false;
		else{
			
		}
		return false;
	}
	@Override
	public PolynomialInterface subtract(PolynomialInterface other) {
		LinkListPolynomial answer;
		LinkedList<LLPolyNode> nodeArray2;
		nodeArray2 = other.getArray();

		answer = new LinkListPolynomial(arrayToString(subtract(nodeArray2, nodeArray)));
		return answer;
	}

	private LinkedList<LLPolyNode> subtract(LinkedList<LLPolyNode> num2, LinkedList<LLPolyNode> num) {
		LinkedList<LLPolyNode> result = new LinkedList<LLPolyNode>();
		int next1 = 0, next2 = 0;
		 LLPolyNode next;
		while (next1 != num.size() || next2 != num2.size()) {
			//while (num.get(next1).next != null || num2.get(next2).next != null) {
				
			int compare = compareTo(num2.get(next2));
			if (compare == -1) {
				result.add(new LLPolyNode(num2.get(next2).coff, num2.get(next2).expon));
				next2++;
				 next = num2.get(next2).next;
				 next = previous;
				 previous = current;
			} else if (compare == 1) {
				// next = num2.get(next2).next;
				result.add(new LLPolyNode(num.get(next1).coff, num.get(next1).expon));
				location++;
				next1++;
			} else if (compare == 0) {
				result.add(new LLPolyNode((num.get(next1).coff - num2.get(next2).coff), num.get(next1).expon));
				location++;
				next1++;
				next2++;
			}
		}

		if (num.size() > next1) {
			for (int i = 0; i < num.size(); i++)
				result.add(new LLPolyNode(num.get(next1).coff, num.get(next1).expon));
			next1++;
		} else if (next2 < num2.size()) {
			for (int i = 0; i < num2.size(); i++)
				result.add(new LLPolyNode(num2.get(next2).coff, num2.get(next2).expon));
			next2++;
		}

		return result;
	}

	
	// private LinkedList<LLPolyNode> subtract(LinkedList<LLPolyNode> num2,
	// LinkedList<LLPolyNode> num) {
	// LinkedList<LLPolyNode> result = new LinkedList<LLPolyNode>();
	// int next1 = 0, next2 = 0;
	// // LLInArrayPolyNode next;
	// while (next1 != num.size() || next2 != num2.size()) {
	// // while (num.get(next1).next != null || num2.get(next2).next !=
	// // null) {
	// int compare = compareTo(num2.get(next2));
	// if (compare == -1) {
	// result.add(new LLPolyNode(num2.get(next2).coff, num2.get(next2).expon));
	// next2++;
	// // next = num2.get(next2).next;
	// } else if (compare == 1) {
	// // next = num2.get(next2).next;
	// result.add(new LLPolyNode(num.get(next1).coff, num.get(next1).expon));
	// location++;
	// next1++;
	// } else if (compare == 0) {
	// result.add(new LLPolyNode((num.get(next1).coff - num2.get(next2).coff),
	// num.get(next1).expon));
	// location++;
	// next1++;
	// next2++;
	// }
	// }
	//
	// if (num.size() > next1) {
	// for (int i = 0; i < num.size(); i++)
	// result.add(new LLPolyNode(num.get(next1).coff, num.get(next1).expon));
	// next1++;
	// } else if (next2 < num2.size()) {
	// for (int i = 0; i < num2.size(); i++)
	// result.add(new LLPolyNode(num2.get(next2).coff, num2.get(next2).expon));
	// next2++;
	// }
	//
	// return result;
	// }

	@Override
	public int compareTo(Object arg0) {
		// int a = nodeArray.get(location).expon;
		// int b = ((LLInArrayPolyNode) arg0).expon;

		if (nodeArray.get(location).expon == ((LLPolyNode) arg0).expon)
			// if (a == b)
			return 0;
		else if (nodeArray.get(location).expon < ((LLPolyNode) arg0).expon)
			// else if (a < b)
			return -1;
		else
			return 1;
	}

	@Override
	public PolynomialInterface add(PolynomialInterface other) {
		LinkListPolynomial answer;
		LinkedList<LLPolyNode> nodeArray2;
		nodeArray2 = other.getArray();

		answer = new LinkListPolynomial(arrayToString(add(nodeArray2, nodeArray)));
		return answer;
	}

	private LinkedList<LLPolyNode> add(LinkedList<LLPolyNode> num2, LinkedList<LLPolyNode> num) {
		LinkedList<LLPolyNode> result = new LinkedList<LLPolyNode>();
		int next1 = 0, next2 = 0;

		// while (hasNext(num) && hasNext(num2)) { //hasNext need to be fixed
		while (next1 != num.size() || next2 != num2.size()) {
			int compare = compareTo(num2.get(next2));
			if (compare == -1) {
				result.add(new LLPolyNode(num2.get(next2).coff, num2.get(next2).expon));
				// num2.remove(0);
				next2++;
			} else if (compare == 1) {
				// result.add(new
				// LLInArrayPolyNode(nodeArray.get(location).coff,
				// nodeArray.get(location).expon));
				result.add(new LLPolyNode(num.get(next1).coff, num.get(next1).expon));
				// num.remove(0);
				// num = remove(num);
				location++;
				next1++;
			} else if (compare == 0) {
				// result.add(new
				// LLInArrayPolyNode((nodeArray.get(location).coff +
				// num2.get(0).coff),
				// nodeArray.get(location).expon));
				result.add(new LLPolyNode((num.get(next1).coff + num2.get(next2).coff), num.get(next1).expon));
				// num2.remove(0);
				// num.remove(0);
				location++;
				next1++;
				next2++;
			}
		}

		if (num.size() > num2.size()) {
			for (int i = 0; i < num.size(); i++)
				result.add(new LLPolyNode(num.get(next1).coff, num.get(next1).expon));
			next1++;
		} else if (num.size() < num2.size()) {
			for (int i = 0; i < num2.size(); i++)
				result.add(new LLPolyNode(num2.get(next2).coff, num2.get(next2).expon));
			next2++;
		}

		return result;
	}

	//
	// private LinkedList<LLInArrayPolyNode>
	// remove(LinkedList<LLInArrayPolyNode> a) {
	// LinkedList<LLInArrayPolyNode> result = new
	// LinkedList<LLInArrayPolyNode>();
	// a.remove();
	// result = a;
	//
	// return result;
	// }

	// private boolean hasNext(LinkedList<LLInArrayPolyNode> a) {
	// if (a.size() == 0)
	// return false;
	// else
	// return true;
	// }

	private void stringToArray(String s1) {
		s1 = s1.trim();
		String sPiece = "";
		int signPos = 0, posPow = 0, powInt = 0, value = 0, size = s1.length();

		for (int i = 0; i <= size; i++) {
			signPos = signFinder(s1.substring(1));
			if (signPos == 0) {
				sPiece = s1.substring(0);
				s1 = "";
				i = size;
			} else {
				sPiece = s1.substring(0, signPos);
				s1 = s1.substring(signPos);
			}
			posPow = sPiece.indexOf('x');
			if (posPow == -1) {
				value = Integer.parseInt(sPiece.substring(0));
				powInt = 0;
			} else {
				value = Integer.parseInt(sPiece.substring(0, posPow));
				if (posPow == (sPiece.length() - 1))
					powInt = 1;
				else
					powInt = Integer.parseInt(sPiece.substring(posPow + 2));
			}
			nodeArray.add(new LLPolyNode(value, powInt));
			// System.out.println(nodeArray[i].coff);
		}
		// nodeArray.get(nodeArray.size() - 1).setNext(NUL);
		// free = 0;
		// sortArray();
		nodeArray = mergeSort(0, nodeArray.size() - 1, nodeArray);
		// System.out.println(Arrays.deepToString(nodeArray));
		// System.out.println(Arrays.toString(nodeArray));
		// for (int l = 0; l < nodeArray.size(); l++) {
		// System.out.println(nodeArray.get(l).coff + " " +
		// nodeArray.get(l).expon + " " + nodeArray.get(l).next);
		// }
		// setNext();
	}

	private LinkedList<LLPolyNode> mergeSort(int first, int last, LinkedList<LLPolyNode> num1)
	// Post: The elements in values are sorted by key
	{
		LinkedList<LLPolyNode> tempArr = new LinkedList<LLPolyNode>();

		if (first < last) {
			int middle = (first + last) / 2;
			mergeSort(first, middle, num1);
			mergeSort(middle + 1, last, num1);
			tempArr = merge(first, middle, middle + 1, last, num1);
		}
		return tempArr;
	}

	private LinkedList<LLPolyNode> merge(int leftFirst, int leftLast, int rightFirst, int rightLast,
			LinkedList<LLPolyNode> num1) {
		LinkedList<LLPolyNode> tempArray = new LinkedList<LLPolyNode>();
		int index = leftFirst;
		int saveFirst = leftFirst;
		// int i = 0;
		while ((leftFirst <= leftLast) && (rightFirst <= rightLast)) {
			if (num1.get(leftFirst).exp() > num1.get(rightFirst).exp()) {
				tempArray.add(num1.get(leftFirst));
				// i++;
				leftFirst++;
			} else {
				tempArray.add(num1.get(rightFirst));
				// i++;
				rightFirst++;
			}
			index++;
		}
		while (leftFirst <= leftLast)
		// Copy remaining items from left half
		{
			tempArray.add(num1.get(leftFirst));
			// i++;
			leftFirst++;
			index++;
		}
		while (rightFirst <= rightLast)
		// Copy remaining items from right half
		{
			tempArray.add(num1.get(rightFirst));
			// i++;
			rightFirst++;
			index++;
		}
		int j = 0;
		for (index = saveFirst; index <= rightLast; index++) {
			num1.set(index, tempArray.get(j));
			j++;
		}
		return num1;
	}

	private String arrayToString(LinkedList<LLPolyNode> arr) {
		String result = "";
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).coeff() != 0) {
				if (arr.get(i).exp() == 0) {
					if (arr.get(i).coeff() > 0)
						result += ("+" + Integer.toString(arr.get(i).coeff()));
					else
						result += Integer.toString(arr.get(i).coeff());
				} else if (arr.get(i).exp() == 1) {
					if (arr.get(i).coeff() > 0)
						result += ("+" + Integer.toString(arr.get(i).coeff()) + "x");
					else
						result += (Integer.toString(arr.get(i).coeff()) + "x");
				} else {
					if (arr.get(i).coeff() > 0)
						result += ("+" + Integer.toString(arr.get(i).coeff()) + "x^"
								+ Integer.toString(arr.get(i).exp()));
					else
						result += (Integer.toString(arr.get(i).coeff()) + "x^" + Integer.toString(arr.get(i).exp()));
				}
			}
		}
		return result;
	}

	public String toString() {
		String myString = "";
		for (int i = 0; i < nodeArray.size(); i++) {
			if (nodeArray.get(i).coeff() != 0) {
				if (nodeArray.get(i).exp() == 0) {
					if (nodeArray.get(i).coeff() > 0)
						myString += ("+" + nodeArray.get(i).coeff());
					else
						myString += nodeArray.get(i).coeff();
				} else if (nodeArray.get(i).exp() == 1) {
					if (nodeArray.get(i).coeff() > 0)
						myString += ("+" + nodeArray.get(i).coeff() + "x" + " ");
					else
						myString += (nodeArray.get(i).coeff() + "x" + " ");
				} else {
					if (nodeArray.get(i).coeff() > 0)
						myString += ("+" + nodeArray.get(i).coeff() + "x^" + nodeArray.get(i).exp() + " ");
					else
						myString += (nodeArray.get(i).coeff() + "x^" + nodeArray.get(i).exp() + " ");
				}
			}
		}
		return myString;
	}

	/**
	 * Precondition: get a peace of string. Postcondition: Return the position
	 * of the fist operator in there.
	 */
	private int signFinder(String s) {
		int pos = 0;
		char oper[] = { '+', '-' };
		for (int i = 0; i < s.length(); i++) { // find position of operators
			char myChar = s.charAt(i);
			for (int j = 0; j < 2; j++) {
				if (myChar == oper[j]) {
					pos = i;
					i = s.length() - 1;
				}
			}
		}
		if (pos == 0)
			return pos;
		return pos + 1;
	}

	@Override
	public ArrayList<PairC> getNumArr() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] getNum1() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LLInArrayPolyNode1[] getLLArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getArrayBegin() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getArrayEnd() {
		// TODO Auto-generated method stub
		return 0;
	}
}
