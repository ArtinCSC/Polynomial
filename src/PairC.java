
public class PairC {
	 int expon = 0;
	 int coff = 0;

	public PairC(int coff, int expon) {
		this.coff = coff;
		this.expon = expon;
	}

	public PairC(int coff) {
		this.coff = coff;
	}

	public int exp() {
		return expon;
	}

	public int coeff() {
		return coff;
	}

}
