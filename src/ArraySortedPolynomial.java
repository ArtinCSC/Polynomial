import java.util.ArrayList;
import java.util.LinkedList;

public class ArraySortedPolynomial implements PolynomialInterface {
	private ArrayList<PairC> num1 = new ArrayList<PairC>();
	private int location;

	public ArraySortedPolynomial(String s) {
		stringToArray(s);
	}

	@Override
	public ArrayList<PairC> getNumArr() {
		// TODO Auto-generated method stub
		return num1;
	}

	@Override
	public PolynomialInterface add(PolynomialInterface other) {
		ArrayWithExponentAsIndexPolynomial answer;
		ArrayList<PairC> num2;
		num2 = other.getNumArr();

		answer = new ArrayWithExponentAsIndexPolynomial(arrayToString(add(num2, num1)));
		return answer;
	}

	private ArrayList<PairC> add(ArrayList<PairC> num2, ArrayList<PairC> num) {
		ArrayList<PairC> result = new ArrayList<PairC>();
		
		for (int i = 0; i < num2.size(); i++) {
			if (find(num2.get(i).exp())) {
				result.add(new PairC(num.get(location).coeff() + num2.get(i).coeff(), num.get(location).exp()));
				num.remove(location);
			} else
				result.add(new PairC(num2.get(i).coeff(), num2.get(i).exp()));
		}
		if (num.size() > 0) {
			for (int i = 0; i < num.size(); i++)
				result.add(new PairC(num.get(i).coeff(), num.get(i).exp()));
		}
		result = mergeSort(0, result.size() - 1, result);

		return result;
	}

	private ArrayList<PairC> subtract(ArrayList<PairC> num2, ArrayList<PairC> num1) {
		ArrayList<PairC> result = new ArrayList<PairC>();
		
		for (int i = 0; i < num2.size(); i++) {
			if (find(num2.get(i).exp())) {
				result.add(new PairC(num1.get(location).coeff() - num2.get(i).coeff(), num1.get(location).exp()));
				num1.remove(location);
			} else
				result.add(new PairC(num2.get(i).coeff() * -1, num2.get(i).exp()));
		}
		if (num1.size() > 0) {
			for (int i = 0; i < num1.size(); i++)
				result.add(new PairC(num1.get(i).coeff(), num1.get(i).exp()));
		}
		result = mergeSort(0, result.size() - 1, result);

		return result;
	}

	@Override
	public PolynomialInterface subtract(PolynomialInterface other) {
		ArrayWithExponentAsIndexPolynomial answer;
		ArrayList<PairC> num2;
		num2 = other.getNumArr();

		answer = new ArrayWithExponentAsIndexPolynomial(arrayToString(subtract(num2, num1)));
		return answer;
	}

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
			num1.add(new PairC(value, powInt));
		}
		// sortArray();
		num1 = mergeSort(0, num1.size() - 1, num1);
	}

	private ArrayList<PairC> mergeSort(int first, int last, ArrayList<PairC> num1)
	// Post: The elements in values are sorted by key
	{
		ArrayList<PairC> tempArr = new ArrayList<PairC>();

		if (first < last) {
			int middle = (first + last) / 2;
			mergeSort(first, middle, num1);
			mergeSort(middle + 1, last, num1);
			tempArr = merge(first, middle, middle + 1, last, num1);
		}
		return tempArr;
	}

	private ArrayList<PairC> merge(int leftFirst, int leftLast, int rightFirst, int rightLast, ArrayList<PairC> num1) {
		ArrayList<PairC> tempArray = new ArrayList<PairC>();
		int index = leftFirst;
		int saveFirst = leftFirst;
		while ((leftFirst <= leftLast) && (rightFirst <= rightLast)) {
			if (num1.get(leftFirst).exp() > num1.get(rightFirst).exp()) {
				tempArray.add(num1.get(leftFirst));

				leftFirst++;
			} else {
				tempArray.add(num1.get(rightFirst));

				rightFirst++;
			}
			index++;
		}
		while (leftFirst <= leftLast)
		// Copy remaining items from left half
		{
			tempArray.add(num1.get(leftFirst));

			leftFirst++;
			index++;
		}
		while (rightFirst <= rightLast)
		// Copy remaining items from right half
		{
			tempArray.add(num1.get(rightFirst));

			rightFirst++;
			index++;
		}
		int i = 0;
		for (index = saveFirst; index <= rightLast; index++) {
			num1.set(index, tempArray.get(i));
			i++;
		}
		return num1;
	}

	private boolean find(int t) {

		for (int i = 0; i < num1.size(); i++) {
			if (num1.get(i).exp() < t)
				return false;
			if (num1.get(i).exp() == t) {
				location = i;
				return true;
			}
		}
		return false;
	}

	// private void sortArray(){
	// for(int i = 0; i < num1.size(); i++){
	// if(num1.get(i).exp() < num1.get(i+1).exp())
	// swap(i);
	// }
	// for(int j = 0; j <num1.size(); j++){
	// if(num1.get(j).exp() < num1.get(j+1).exp())
	// swap(j);
	// }
	// }
	// private void swap(int i){
	// ArrayList<PairC> temp = new ArrayList<PairC>();
	// temp.add(num1.get(i));
	// num1.set(i, num1.get(i+1));
	// num1.set(i+1, temp.get(0));
	// }
	public String toString() {
		String myString = "";
		for (int i = 0; i < num1.size(); i++) {
			if (num1.get(i).coeff() != 0) {
				if (num1.get(i).exp() == 0) {
					if (num1.get(i).coeff() > 0)
						myString += ("+" + num1.get(i).coeff());
					else
						myString += num1.get(i).coeff();
				} else if (num1.get(i).exp() == 1) {
					if (num1.get(i).coeff() > 0)
						myString += ("+" + num1.get(i).coeff() + "x" + " ");
					else
						myString += (num1.get(i).coeff() + "x" + " ");
				} else {
					if (num1.get(i).coeff() > 0)
						myString += ("+" + num1.get(i).coeff() + "x^" + num1.get(i).exp() + " ");
					else
						myString += (num1.get(i).coeff() + "x^" + num1.get(i).exp() + " ");
				}
			}
		}
		return myString;
	}

	private String arrayToString(ArrayList<PairC> arr) {
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
	public int[] getNum1() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList<LLInArrayPolyNode> getArray() {
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
