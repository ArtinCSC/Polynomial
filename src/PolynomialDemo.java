
public class PolynomialDemo {

	public static void main(String[] args) {
		// example strings constructor must handle
		// String s = "44";
		// String s = "44x";
		// String s = "4x^4+3x^3-3";
		// String s = "4x^3-3x^11";
		// String s = "44x^6-3x^10+4x^4";
		// String s = "25x^5-3x^13+4x^12-78";
		// String s ="34x^15-44x^14-3x^12+4x^31-78";
		// String s1 = "44";
		// String s2 = "44x-78";
		// String s1 = "4x^4+3x^3-3";
		// String s2 = "4x^6-3x^12";
		String s1 = "4x^14-3x^12+4x^4+78";
		String s2 = "-4x^4-3x^12+4x^17-78";
		// String s1 = "4x^4+3x^11+4x^10";
		// String s2 = "5x^14-3x^12+4x^19-78";
		// String s1 = "4x^5+4x^4-3x^12-4x^41-78";
		// String s2 = "-4x^4+3x^12+4x^41+78";
		// Four implementations of the interface
		PolynomialInterface exAsIndex1 = new ArrayWithExponentAsIndexPolynomial(s1);
		PolynomialInterface exAsIndex2 = new ArrayWithExponentAsIndexPolynomial(s2);
		PolynomialInterface exAsIndex3;
		exAsIndex3 = exAsIndex1.add(exAsIndex2);
		System.out.println("First test is with array index as exponent. ");
		// System.out.println("exAsIndex1 string is " + s1);
		System.out.println("exAsIndex1 =                 " + exAsIndex1);
		// System.out.println("exAsIndex2 string is " + s2);
		System.out.println("exAsIndex2 =                 " + exAsIndex2);
		System.out.println("exAsIndex3 = exAsIndex1.add(exAsIndex2)      " + exAsIndex3);
		exAsIndex3 = exAsIndex1.subtract(exAsIndex2);
		// System.out.println("exAsIndex1 string is " + s1);
		// System.out.println("exAsIndex1 = " + exAsIndex1);
		// System.out.println("exAsIndex2 string is " + s2);
		// System.out.println("exAsIndex2 = " + exAsIndex2);
		System.out.println("exAsIndex3 = exAsIndex1.subtract(exAsIndex2) " + exAsIndex3);
		System.out.println();

		PolynomialInterface sortA1 = new ArraySortedPolynomial(s1);
		PolynomialInterface sortA2 = new ArraySortedPolynomial(s2);
		PolynomialInterface sortA3;
		System.out.println("Second test is sorted array of terms.");
		// System.out.println("sortA1 string is " + s1);
		System.out.println("sortA1 =                   " + sortA1);
		// System.out.println("sortA2 string is " + s2);
		System.out.println("sortA2 =                   " + sortA2);
		sortA3 = sortA1.add(sortA2);
		System.out.println("sortA3 = sortA1.add(sortA2)      " + sortA3);
		PolynomialInterface sortA11 = new ArraySortedPolynomial(s1);
		sortA3 = sortA11.subtract(sortA2);
		// System.out.println("sortA1 string is " + s1);
		// System.out.println("sortA1 = " + sortA1);
		// System.out.println("sortA2 string is " + s2);
		// System.out.println("sortA2 = " + sortA2);
		System.out.println("sortA3 = sortA1.subtract(sortA2) " + sortA3);
		System.out.println();

		PolynomialInterface link1 = new LinkListPolynomial(s1);
		PolynomialInterface link2 = new LinkListPolynomial(s2);
		PolynomialInterface link3;
		System.out.println("Third test is linked list of terms.");
		// System.out.println("link1 string is " + s1);
		System.out.println("link1 =               " + link1);
		// System.out.println("link2 string is " + s2);
		System.out.println("link2 =               " + link2);
		link3 = link1.add(link2);
		System.out.println("sum of link1 and link2 = " + link3);
		PolynomialInterface link11 = new LinkListPolynomial(s1);
		// System.out.println("link1 string is " + s1);
		// System.out.println("link1 = " + link1);
		// System.out.println("link2 string is " + s2);
		// System.out.println("link2 = " + link2);
		link3 = link11.subtract(link2);
		System.out.println("link1 minus link2 =      " + link3);

		System.out.println();
		PolynomialInterface linkInArray1 = new LinkedListInArrayPolynomial(s1);
		PolynomialInterface linkInArray2 = new LinkedListInArrayPolynomial(s2);
		PolynomialInterface linkInArray3 = new LinkedListInArrayPolynomial();
		System.out.println("Forth test is linked list of terms in an array.");
		// System.out.println("linkInArray1 string is " + s1);
		System.out.println("linkInArray1 =               " + linkInArray1);
		// System.out.println("linkInArray2 string is " + s2);
		System.out.println("linkInArray2 =               " + linkInArray2);
		linkInArray3 = linkInArray1.add(linkInArray2);
		System.out.println("sum of linkInArray1 and linkInArray2 = " + linkInArray3);
		PolynomialInterface linkInArray11 = new LinkedListInArrayPolynomial(s1);
		linkInArray3 = linkInArray11.subtract(linkInArray2);
		System.out.println("linkInArray1 minus linkInArray2 =      " + linkInArray3);

	}

}
