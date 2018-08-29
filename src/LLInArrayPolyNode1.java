
public class LLInArrayPolyNode1 {
	
	int expon = 0;
	int coff = 0;
	int next = 0;
	
	public LLInArrayPolyNode1(int coff, int expon) {
		this.coff = coff;
		this.expon = expon;
	
	}
	public LLInArrayPolyNode1(int coff, int expon, int next) {
		this.coff = coff;
		this.expon = expon;
		this.next = next;
	}
	public LLInArrayPolyNode1() {
		
	
	}
	public int exp() {
		return expon;
	}

	public int coeff() {
		return coff;
	}
	public void setNext(int index) {
		// TODO Auto-generated method stub
		
	}

}
