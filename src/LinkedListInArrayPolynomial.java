import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListInArrayPolynomial implements PolynomialInterface, Comparable<Object> {

	private static final int NUL = -1;
	private static int free;
	private static LLInArrayPolyNode1[] nodeArray = new LLInArrayPolyNode1[1000];
	private static boolean nodeArrayIsInitialized = false;
	private String polyString;
	private int polynomial = NUL;
	private int arrayBegin;
	private int arrayEnd;
	private int location = arrayBegin;

	public LinkedListInArrayPolynomial() {
		if (!nodeArrayIsInitialized)
			initializedStaticArray();

	}

	private void initializedStaticArray() {

		// fill array with nodes
		for (int x = 0; x < nodeArray.length; x++) {
			nodeArray[x] = new LLInArrayPolyNode1();
		}
		for (int index = 1; index < nodeArray.length; index++) {
			nodeArray[index - 1].setNext(index);
		}
		nodeArray[nodeArray.length - 1].setNext(NUL);
		free = 0;
		nodeArrayIsInitialized = true;

	}

	public LinkedListInArrayPolynomial(String polyString) {

		if (!nodeArrayIsInitialized)
			initializedStaticArray();
		this.polyString = polyString;
		stringToArray(polyString);
	}

	public LLInArrayPolyNode1[] getLLArray() {
		return nodeArray;
	}

	@Override
	public PolynomialInterface add(PolynomialInterface other) {
		LinkedListInArrayPolynomial answer;
		answer = new LinkedListInArrayPolynomial(arrayToString(add(other.getArrayBegin(), other.getArrayEnd())));
		return answer;
	}

	private int add(int begin, int end) {
		boolean done = true;
		int i = begin;
		int result = free;

		while (done) {
			int compare = compareTo(nodeArray[i]);
			if (i == end || location == arrayEnd)
				done = false;
			if (compare == -1) {
				nodeArray[free] = (new LLInArrayPolyNode1(nodeArray[i].coff, nodeArray[i].expon));
				i++;
				free++;
			} else if (compare == 1) {

				nodeArray[free] = (new LLInArrayPolyNode1(nodeArray[location].coff, nodeArray[location].expon));
				location++;
				free++;
			} else if (compare == 0) {
				nodeArray[free] = (new LLInArrayPolyNode1((nodeArray[location].coff + nodeArray[i].coff),
						nodeArray[location].expon));
				location++;
				i++;
				free++;
			}
		}
		if (i != end) {
			for (int k = 0; k < end - i; k++)
				nodeArray[free] = (new LLInArrayPolyNode1(nodeArray[i].coff, nodeArray[i].expon));
			i++;
			free++;
		} else if (location != arrayEnd) {
			for (int h = 0; h < arrayEnd - location; h++)
				nodeArray[free] = (new LLInArrayPolyNode1(nodeArray[location].coff, nodeArray[location].expon));
			location++;
			free++;
		}
		return result;
	}

	@Override
	public int compareTo(Object arg0) {
		// int a = nodeArray[location].expon;
		// int b = ((LLInArrayPolyNode1) arg0).expon;

		if (nodeArray[location].expon == ((LLInArrayPolyNode1) arg0).expon)
			// if (a == b)
			return 0;
		else if (nodeArray[location].expon < ((LLInArrayPolyNode1) arg0).expon)
			// else if (a < b)
			return -1;
		else
			return 1;
	}

	@Override
	public PolynomialInterface subtract(PolynomialInterface other) {
		LinkedListInArrayPolynomial answer;
		answer = new LinkedListInArrayPolynomial(arrayToString(subtract(other.getArrayBegin(), other.getArrayEnd())));
		return answer;
	}
	private int subtract(int begin, int end) {
		boolean done = true;
		int i = begin;
		int result = free;

		while (done) {
			int compare = compareTo(nodeArray[i]);
			if (i == end || location == arrayEnd)
				done = false;
			if (compare == -1) {
				nodeArray[free] = (new LLInArrayPolyNode1(nodeArray[i].coff, nodeArray[i].expon));
				i++;
				free++;
			} else if (compare == 1) {

				nodeArray[free] = (new LLInArrayPolyNode1(nodeArray[location].coff, nodeArray[location].expon));
				location++;
				free++;
			} else if (compare == 0) {
				nodeArray[free] = (new LLInArrayPolyNode1((nodeArray[location].coff - nodeArray[i].coff),
						nodeArray[location].expon));
				location++;
				i++;
				free++;
			}
		}
		if (i != end) {
			for (int k = 0; k < end - i; k++)
				nodeArray[free] = (new LLInArrayPolyNode1(nodeArray[i].coff, nodeArray[i].expon));
			i++;
			free++;
		} else if (location != arrayEnd) {
			for (int h = 0; h < arrayEnd - location; h++)
				nodeArray[free] = (new LLInArrayPolyNode1(nodeArray[location].coff, nodeArray[location].expon));
			location++;
			free++;
		}
		return result;
	}

	public int getArrayBegin() {
		return arrayBegin;
	}

	public int getArrayEnd() {
		return arrayEnd;
	}

	private void stringToArray(String s1) {
		arrayBegin = free;
		LLInArrayPolyNode1[] tempArray = new LLInArrayPolyNode1[1000];
		LLInArrayPolyNode1[] tempArray1;
		s1 = s1.trim();
		String sPiece = "";
		int signPos = 0, posPow = 0, powInt = 0, value = 0, size = s1.length(), l = 0;

		for (int i = 0; i < size; i++) {
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
			tempArray[l] = new LLInArrayPolyNode1(value, powInt);
			l++;
		}
		tempArray1 = cutter(tempArray);
		tempArray1 = mergeSort(0, tempArray1.length - 1, tempArray1);
		for (int i = 0; i < tempArray1.length; i++) {
			if (i == tempArray1.length - 1) {
				nodeArray[free] = tempArray1[i];
				nodeArray[free].setNext(NUL);
			} else
				nodeArray[free] = tempArray1[i];
			free++;
		}
		arrayEnd = free - 1;
		// if(i == size)
		// tempArray[free] = new LLInArrayPolyNode1(value, powInt, NUL);
		// else
		// tempArray[free] = new LLInArrayPolyNode1(value, powInt);
		// free++;
		// System.out.println(nodeArray[i].coff);

		// nodeArray.get(nodeArray.size() - 1).setNext(NUL);
		// free = 0;
		// sortArray();
		// mergeSort(arrayBegin, free - 1);
		// System.out.println(Arrays.deepToString(nodeArray));
		// System.out.println(Arrays.toString(nodeArray));
		// for (int l = 0; l < nodeArray.size(); l++) {
		// System.out.println(nodeArray.get(l).coff + " " +
		// nodeArray.get(l).expon + " " + nodeArray.get(l).next);
		// }
	}

	private LLInArrayPolyNode1[] mergeSort(int first, int last, LLInArrayPolyNode1[] t)
	// Post: The elements in values are sorted by key
	{
		LLInArrayPolyNode1[] tempArray = new LLInArrayPolyNode1[t.length];
		if (first < last) {
			int middle = (first + last) / 2;
			mergeSort(first, middle, t);
			mergeSort(middle + 1, last, t);
			tempArray = merge(first, middle, middle + 1, last, t);
		}
		return tempArray;
	}

	private LLInArrayPolyNode1[] merge(int leftFirst, int leftLast, int rightFirst, int rightLast,
			LLInArrayPolyNode1[] nodeArray) {
		LLInArrayPolyNode1[] tempArray = new LLInArrayPolyNode1[nodeArray.length];
		int index = leftFirst;
		int saveFirst = leftFirst;
		while ((leftFirst <= leftLast) && (rightFirst <= rightLast)) {
			if (nodeArray[leftFirst].exp() > nodeArray[rightFirst].exp()) {
				tempArray[index] = nodeArray[leftFirst];
				leftFirst++;
			} else {
				tempArray[index] = nodeArray[rightFirst];
				rightFirst++;
			}
			index++;
		}
		while (leftFirst <= leftLast)
		// Copy remaining items from left half
		{
			tempArray[index] = nodeArray[leftFirst];
			leftFirst++;
			index++;
		}
		while (rightFirst <= rightLast)
		// Copy remaining items from right half
		{
			tempArray[index] = nodeArray[rightFirst];
			rightFirst++;
			index++;
		}
		for (index = saveFirst; index <= rightLast; index++) {
			nodeArray[index] = tempArray[index];
		}
		return nodeArray;
	}

	private String arrayToString(int begin) {
		String result = "";
		for (int i = begin; i < free; i++) {
			if (nodeArray[i].coeff() != 0) {
				if (nodeArray[i].exp() == 0) {
					if (nodeArray[i].coeff() > 0)
						result += ("+" + Integer.toString(nodeArray[i].coeff()));
					else
						result += Integer.toString(nodeArray[i].coeff());
				} else if (nodeArray[i].exp() == 1) {
					if (nodeArray[i].coeff() > 0)
						result += ("+" + Integer.toString(nodeArray[i].coeff()) + "x");
					else
						result += (Integer.toString(nodeArray[i].coeff()) + "x");
				} else {
					if (nodeArray[i].coeff() > 0)
						result += ("+" + Integer.toString(nodeArray[i].coeff()) + "x^"
								+ Integer.toString(nodeArray[i].exp()));
					else
						result += (Integer.toString(nodeArray[i].coeff()) + "x^"
								+ Integer.toString(nodeArray[i].exp()));
				}
			}
		}
		return result;
	}

	public String toString() {
		String myString = "";
		for (int i = arrayBegin; i <= arrayEnd; i++) {
			if (nodeArray[i].coeff() != 0) {
				if (nodeArray[i].exp() == 0) {
					if (nodeArray[i].coeff() > 0)
						myString += ("+" + nodeArray[i].coeff() + " ");
					else
						myString += nodeArray[i].coeff();
				} else if (nodeArray[i].exp() == 1) {
					if (nodeArray[i].coeff() > 0)
						myString += ("+" + nodeArray[i].coeff() + "x" + " ");
					else
						myString += (nodeArray[i].coeff() + "x" + " ");
				} else {
					if (nodeArray[i].coeff() > 0)
						myString += ("+" + nodeArray[i].coeff() + "x^" + nodeArray[i].exp() + " ");
					else
						myString += (nodeArray[i].coeff() + "x^" + nodeArray[i].exp() + " ");
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

	private LLInArrayPolyNode1[] cutter(LLInArrayPolyNode1[] a) {
		int size = 0, j = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == null)
				i = a.length - 1;
			else
				size++;
		}
		LLInArrayPolyNode1[] result = new LLInArrayPolyNode1[size];
		while (j != size) {
			result[j] = a[j];
			j++;
		}
		return result;
	}

	@Override
	public ArrayList<PairC> getNumArr() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList<LLInArrayPolyNode> getArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] getNum1() {
		// TODO Auto-generated method stub
		return null;
	}

}
