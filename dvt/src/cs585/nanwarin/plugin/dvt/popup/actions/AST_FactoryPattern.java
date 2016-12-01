package cs585.nanwarin.plugin.dvt.popup.actions;

import java.util.List;

import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

public class AST_FactoryPattern extends ASTVisitor{

	FactoryPatternObjs factoryPatternObjs;
	String factoryObj;
	
	public AST_FactoryPattern(FactoryPatternObjs factoryPatternObjs){
		this.factoryPatternObjs = factoryPatternObjs;
		factoryObj = null;
	}
	
	public boolean visit(VariableDeclarationFragment node) {
		SimpleName name = node.getName();
		Expression test = node.getInitializer();
		String checkFactoryObj = null;
		
		System.out.println("Debug:Visit: " + test);
	
		try {
			checkFactoryObj = factoryPatternObjs.factoryObj.getChildren()[1].getElementName();
		} catch (JavaModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(test.toString().contains(checkFactoryObj)){
			factoryObj = name.getIdentifier();
		}else if(factoryObj == null){
			
		}
		
		return false; // do not continue 
	}
	
	
	/*
	public boolean visit(TypeDeclaration typeNote) {
		
		System.out.println("------------------methods-----------");
		MethodDeclaration[] notes = typeNote.getMethods();
		for(MethodDeclaration note: notes){

			if(note.getModifiers() > 0){
				System.out.println("modifier: "+note.getModifiers()); // 9 = public static,  1=public, 
				System.out.println("name: "+note.getName());
				System.out.println("parameter: " + note.parameters());
				System.out.println("return type: "+note.getReturnType2());

				System.out.println("-------");
			}


		}

		System.out.println("------------------fields-----------");
		FieldDeclaration[] nodes = typeNote.getFields();
		for(FieldDeclaration node: nodes){


			System.out.println(node.getModifiers());//25 = public static final 
			System.out.println(node.fragments());

			for(Object f: node.fragments()){
				System.out.println(f);

				String s = f.toString();
				if(s.contains("=")){
					String[] arr = s.split("=");
					s = arr[0];
				}else{

				}
			}
		}

		return false;
	}	
		*/
	
	

	public void process(CompilationUnit unit) {
		unit.accept(this);
	}
	
}
