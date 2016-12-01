package cs585.nanwarin.plugin.dvt.popup.actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.ICompilationUnit;
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
import org.eclipse.jface.text.Position;

public class AST_FactoryPattern extends ASTVisitor{

	FactoryPatternObjs factoryPatternObjs;
	String factoryObj;
	CompilationUnit unit;
	ICompilationUnit iUnit;
	
	public AST_FactoryPattern(FactoryPatternObjs factoryPatternObjs, CompilationUnit unit, ICompilationUnit iUnit){
		this.factoryPatternObjs = factoryPatternObjs;
		factoryObj = null;
		this.unit = unit;
		this.iUnit = iUnit;
	}
	
	public boolean visit(VariableDeclarationFragment node) {
		SimpleName name = node.getName();
		Expression expression = node.getInitializer();
		String checkFactoryObj = null;
		
		String callerObj;
		
		System.out.println("Debug:Visit: Expression -- > " + expression);
	
		try {
			checkFactoryObj = factoryPatternObjs.factoryObj.getChildren()[1].getElementName();
		} catch (JavaModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(expression.toString().contains(checkFactoryObj)){
			factoryObj = name.getIdentifier();
		}else if(factoryObj == null){
			//Highlight no implement obj;
		}else if(!expression.toString().contains(factoryObj)){
			System.out.println("Wrong pattern applied to --> " + name.getIdentifier() + " This statement is wrong " + expression.toString());
			System.out.println("Line number --> " + unit.getLineNumber(node.getStartPosition()));
			Position newPosition = new Position(node.getStartPosition());
			//	ITextEditor editorArea = (ITextEditor) editorPart;
			IWorkspace space = ResourcesPlugin.getWorkspace();	
			IFile input = (IFile)space.getRoot().findMember(this.iUnit.getPath());
			IMarker marker = new MyMarkerFactory().createMarker(input, newPosition, "Wrong Design Pattern has been applied --> " + expression.toString());
		
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
