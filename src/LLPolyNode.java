
public class LLPolyNode {
	int expon = 0;
	int coff = 0;
	LLPolyNode next = null;

	public LLPolyNode(int coff, int expon) {
		this.coff = coff;
		this.expon = expon;

	}
	public LLPolyNode(){
		
	}
	public LLPolyNode(LLPolyNode next) {
		this.next = next;
	}

	public LLPolyNode(int coff, int expon, LLPolyNode link) {
		this.coff = coff;
		this.expon = expon;
		this.next = link;
	}

	public int exp() {
		return expon;
	}

	public int coeff() {
		return coff;
	}

}
