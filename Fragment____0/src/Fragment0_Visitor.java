import java.util.Stack;
public class Fragment0_Visitor implements Fragment_0Visitor {
	private int indent = 0;
	Stack<String> GenCodePile = new Stack<>();
	private String GenCode="";
	private String newGenCode="";
	
	
	 private String indentString() {
		    StringBuffer sb = new StringBuffer();
		    for (int i = 0; i < indent; ++i) {
		      sb.append(" ");
		    }
		    return sb.toString();
		  }

	@Override
	public Object visit(SimpleNode node, Object data) {
		System.out.println(indentString() + node +
			       ": acceptor not unimplemented in subclass?");

	                       // I think UNimplemented above is a typo
	    ++indent;
	    data = node.childrenAccept(this, data);
	    --indent;
	    return data;
		
		// TODO Auto-generated method stub
		//return null;
	}

	@Override
	public Object visit(ASTStart node, Object data) {
		    
		    data = node.childrenAccept(this, data);
		   
		    return data;
	}

	@Override
	public Object visit(ASTroot_programm node, Object data) {
		   
		    data = node.childrenAccept(this, data);
		    
		    return data;
	}

	@Override
	public Object visit(ASTcommand node, Object data) {
		 
		   //this.GenCode = node.code + this.GenCode;
		    data = node.childrenAccept(this, data);
		   
		    return data;
	}

	@Override
	public Object visit(ASTexpression node, Object data) {
		
		   
		  //this.GenCode =  "Exp" +"\n"+this.GenCode ;
		    data = node.childrenAccept(this, data);
		    
		   
		    return data;
	}

	@Override
	public Object visit(ASTcond_v node, Object data) {
		int tailleIncrease = 1;
		CodeGen fullCode = (CodeGen)data;
		CodeGen codeVrai = new CodeGen();
		data = node.childrenAccept(this, codeVrai);
		
		String codeConJump = String.format("ConJump %d \n", codeVrai.getTaille()+1);
		fullCode.appendCode(codeConJump);
		fullCode.appendCode(codeVrai.getCodeGen());
		
		
		   fullCode.increaseTaille(tailleIncrease);
		    
		    return data;
	}

	@Override
	public Object visit(ASTcond_f node, Object data) {
		int tailleIncrease = 1;
		
	
			CodeGen fullCode = (CodeGen) data;
			CodeGen codeFaux = new CodeGen();
		    data = node.childrenAccept(this, codeFaux);
		    String codeJump = String.format("Jump %d \n", codeFaux.getTaille());
		    
		    fullCode.appendCode(codeJump);
            fullCode.appendCode(codeFaux.getCodeGen());
            
            fullCode.increaseTaille(tailleIncrease);
            
		    return data;
	}

	@Override
	public Object visit(ASTteste_égalité node, Object data) {
		int taille = 1;
		
		node.childrenAccept(this,data);
		 CodeGen genCode = (CodeGen)data;
		   genCode.appendCode(node.code, taille);
		    
		    return data;
	}

	@Override
	public Object visit(ASTop_add node, Object data) {
		int taille = 1;
		
	     	node.childrenAccept(this, data);
		   CodeGen genCode = (CodeGen)data;
		   genCode.appendCode(node.code, taille);
		   
		    return data;
	}

	@Override
	public Object visit(ASTop_moins node, Object data) {
		int taille = 1;
	
		 node.childrenAccept(this, data);
		   CodeGen genCode = (CodeGen)data;
		   genCode.appendCode(node.code, taille);
		   
		    return data;
	}

	@Override
	public Object visit(ASTop_mult node, Object data) {
		int taille = 1;
		
		node.childrenAccept(this, data);
		   CodeGen genCode = (CodeGen)data;
		   genCode.appendCode(node.code, taille);
		   
		   
		    return data;
	}

	@Override
	public Object visit(ASTop_divi node, Object data) {
		int taille = 1;
		
		
		   node.childrenAccept(this, data);
		   CodeGen genCode = (CodeGen)data;
		   genCode.appendCode(node.code, taille);
		   
		    return data;
	}

	@Override
	public Object visit(ASTop_mod node, Object data) {
	
		 int taille = 1;
		  node.childrenAccept(this, data);
		 CodeGen genCode = (CodeGen)data;
		 genCode.appendCode(node.code, taille);
		    
		    return data;
	}

	@Override
	public Object visit(ASTid node, Object data) {
		int taille= 1;
		
		      node.childrenAccept(this, data);
		     CodeGen genCode = (CodeGen)data;
			   genCode.appendCode(node.code, taille);
		   
		    return data;
	}

	@Override
	public Object visit(ASTnombre node, Object data) {
		   int taille=1;
		
		   
		    
		     node.childrenAccept(this, data);
			   CodeGen genCode = (CodeGen)data;
			   genCode.appendCode(node.code, taille);
		   
		    return data;
	}

	@Override
	public Object visit(ASTneg node, Object data) {
		int taille = 0 ;
	
		  node.childrenAccept(this, data);
		   CodeGen genCode = (CodeGen)data;
		   genCode.appendCode(node.code, taille);
		   
		    return data;
		// TODO Auto-generated method stub
		
	}
	@Override
	public Object visit(ASTassi node, Object data) {
		int taille = 1;
		// TODO Auto-generated method stub
		node.childrenAccept(this, data);
		   CodeGen genCode = (CodeGen)data;
		   genCode.appendCode(node.code, taille);
		   
		    return data;
		
	}

	

}
