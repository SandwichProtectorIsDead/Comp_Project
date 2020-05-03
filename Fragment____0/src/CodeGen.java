
public class CodeGen {
	private String codeGen;
	private int taille;
	
	public CodeGen() {
		this.codeGen = "";
		this.taille = 0;
	}
	
	public String getCodeGen() {
		return codeGen;
	}
	
	public void setCodeGen(String codeGen) {
		this.codeGen = codeGen;
	}
	
	public int getTaille() {
		return taille;
	}
	
	public void setTaille(int taille) {
		this.taille = taille;
	}
	
	public void appendCode(String code) {
		this.codeGen = this.codeGen+code;
	}
	
	public void increaseTaille(int increase) {
		this.taille+=increase;
	}
	
	public void appendCode(String code, int increase) {
		this.appendCode(code);
		this.increaseTaille(increase);
	}
	
	public void printCode() {
		System.out.println(this.codeGen);
	}
	
}
