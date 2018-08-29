import java.util.ArrayList;
import java.util.LinkedList;

public interface PolynomialInterface {

	ArrayList<PairC> getNumArr();

	int[] getNum1();

	public LinkedList<LLPolyNode> getArray();

	PolynomialInterface add(PolynomialInterface other);

	public LLInArrayPolyNode1[] getLLArray();

	public int getArrayBegin();

	public int getArrayEnd();

	PolynomialInterface subtract(PolynomialInterface other);

}
