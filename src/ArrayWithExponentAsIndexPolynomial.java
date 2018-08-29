import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayWithExponentAsIndexPolynomial implements PolynomialInterface {
	private int[] num1 = new int[1000];

	public ArrayWithExponentAsIndexPolynomial(String s1) {
		stringToArray(s1);
	}

//	public ArrayWithExponentAsIndexPolynomial() {
//
//	}

	public int[] getNum1() {
		return num1;
	}

	public ArrayList<PairC> getNumArr() {

		return null;
	}

	public PolynomialInterface add(PolynomialInterface other) {

		ArrayWithExponentAsIndexPolynomial answer;
		int[] num2;
		num2 = other.getNum1();
		answer = new ArrayWithExponentAsIndexPolynomial(arrayToString(add(num2)));
		return answer;

	}

	public String toString() {
		String myString = "";
		for (int i = num1.length - 1; i >= 0; i--) {
			if (num1[i] != 0) {
				if (i == 0) {
					if (num1[i] > 0)
						myString += ("+" + num1[i]);
					else
						myString += num1[i];
				} else if (i == 1) {
					if (num1[i] > 0)
						myString += ("+" + num1[i] + "x" + " ");
					else
						myString += (num1[i] + "x" + " ");
				} else {
					if (num1[i] > 0)
						myString += ("+" + num1[i] + "x^" + i + " ");
					else
						myString += (num1[i] + "x^" + i + " ");
				}
			}
		}
		return myString;
	}

	private int[] add(int[] num) {
		int[] result = new int[1000];
		for (int i = 0; i < num1.length; i++)
			result[i] = num[i] + num1[i];
		return result;
	}

	public PolynomialInterface subtract(PolynomialInterface other) {
		ArrayWithExponentAsIndexPolynomial answer;

		int[] num2;
		num2 = other.getNum1();
		answer = new ArrayWithExponentAsIndexPolynomial(arrayToString(subtract(num2)));
		return answer;
	}

	private int[] subtract(int[] num) {
		int[] result = new int[1000];
		for (int i = 0; i < num1.length; i++)
			result[i] = num1[i] - num[i];
		return result;
	}

	private String arrayToString(int[] arr) {
		String result = "";
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] != 0) {
				if (i == 0) {
					if (arr[i] > 0)
						result += ("+" + Integer.toString(arr[i]));
					else
						result += Integer.toString(arr[i]);
				} else if (i == 1) {
					if (arr[i] > 0)
						result += ("+" + Integer.toString(arr[i]) + "x");
					else
						result += (Integer.toString(arr[i]) + "x");
				} else {
					if (arr[i] > 0)
						result += ("+" + Integer.toString(arr[i]) + "x^" + Integer.toString(i));
					else
						result += (Integer.toString(arr[i]) + "x^" + Integer.toString(i));
				}
			}
		}
		return result;
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
			num1[powInt] = value;
		}
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
