import java.util.ArrayList;

public class Pract {
	private static ArrayList<Integer> num1 = new ArrayList<Integer>();
	private static ArrayList<Integer> result = new ArrayList<Integer>();

	public static void main(String[] args) {
		String s1 = "-4x^12+84x^2+4x^45-4x^3+3x-5x+4+54-54x";
		s1 = s1.trim();
		String sPiece = "";
		int signPos = 0;
		int posPow = 0;
		int powInt = 0;
		int value = 0;
		int size = s1.length();
		String power = "";
		arrayMaker(s1);
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
			System.out.println(value);
			System.out.println(powInt);

			num1.add(value, powInt);

		}
		num1 = reduceZero(num1);
	}

	private static void arrayMaker(String s) {
		for (int i = 0; i < s.length() / 2; i++) {
			num1.add(0);
		}
	}

	/**
	 * Precondition: input is an arrarList integer. Postcondition: Return the
	 * reduced zeros.
	 */
	private static ArrayList<Integer> reduceZero(ArrayList<Integer> a) {
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) == 0)
				a.remove(i);
			else if (a.get(i) > 0)
				i = a.size() - 1;
		}
		if (a.size() == 0)
			a.add(0);
		return a;
	}

	private static ArrayList<Integer> add(ArrayList<Integer> num) {
		ArrayList<Integer> num1Rev = new ArrayList<Integer>();
		int size = 0;

		// num = reverser(num);
		// num1Rev = reverser(num1);
		if (num.size() > num1Rev.size()) {
			size = num.size();
			num1Rev = sizeMaker(num, num1Rev);
		} else {
			size = num1Rev.size();
			num = sizeMaker(num1Rev, num);
		}

		for (int i = 0; i < size; i++)
			result.add(num.get(i) + num1Rev.get(i), i);
		return result;
	}

	private static ArrayList<Integer> subtract(ArrayList<Integer> num) {
		ArrayList<Integer> num1Rev = new ArrayList<Integer>();
		int size = 0;

		// num = reverser(num);
		// num1Rev = reverser(num1);
		if (num.size() > num1Rev.size()) {
			size = num.size();
			num1Rev = sizeMaker(num, num1Rev);
		} else {
			size = num1Rev.size();
			num = sizeMaker(num1Rev, num);
		}
		for (int i = 0; i < size; i++)
			result.add(num1Rev.get(i) - num.get(i), i);

		return result;
	}

	/**
	 * Precondition: input is an arrarList integer. Postcondition: Return the
	 * reverse order.
	 */
	private static ArrayList<Integer> reverser(ArrayList<Integer> u) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = (u.size() - 1); i >= 0; i--) {
			result.add(u.get(i));
		}
		return result;
	}

	/**
	 * Precondition: input is the two arrarList integer with different size.
	 * Postcondition: Return the equal size arrayList integer.
	 */
	private static ArrayList<Integer> sizeMaker(ArrayList<Integer> a, ArrayList<Integer> b) {
		int o = (a.size() - b.size());
		for (int i = 0; i < o; i++)
			b.add(0);
		return b;
	}

	public String toString() {
		String myString = "";
		result = reverser(result);
		for (int i = 0; i < result.size(); i++) {
			myString += (result.get(i) + "x^" + i);
			if (i == result.size() - 1)
				myString += (result.get(i));
			else if (i == result.size() - 2)
				myString += (result.get(i) + "x");
		}

		return myString;
	}

	/**
	 * Precondition: get a peace of string. Postcondition: Return the position
	 * of the fist operator in there.
	 */
	public static int signFinder(String s) {
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
}
