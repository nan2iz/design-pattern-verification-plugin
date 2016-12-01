package cs585.nanwarin.plugin.dvt.popup.actions;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.IVariableBinding;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.SimplePropertyDescriptor;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jdt.core.dom.AST;

public class InitialPatternObj {

	FactoryPatternObjs factoryPatternObjs;
	
	public InitialPatternObj(IPackageFragment selectedPackage){
		identifyJavaFileType(selectedPackage);
	}
	
	
	public void verifyCaller(){
		ASTParser parser = ASTParser.newParser(AST.JLS8); 
		CompilationUnit cu; 
		
		parser.setSource(factoryPatternObjs.caller);
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		cu = (CompilationUnit) parser.createAST(null);
		
		//IFile file = new IFile(factoryPatternObjs.caller.getPath());
		
		AST_FactoryPattern ast = new AST_FactoryPattern(factoryPatternObjs, cu, factoryPatternObjs.caller);
		ast.process(cu);
		
		System.out.println("Debug factoryObj " + ast.factoryObj);
		
		/*cu.accept(new ASTVisitor() {
			 
			Set names = new HashSet();
			
 
			public boolean visit(VariableDeclarationFragment node) {
				SimpleName name = node.getName();
				Expression test = node.getInitializer();
				String checkFactoryObj = null;
				
				
	
				this.names.add(name.getIdentifier());
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
				
				
				System.out.println("Declaration of '"+name.getIdentifier()+ " " + test + " expresssion " + "' at line"
						+ cu.getLineNumber(name.getStartPosition()));
				return false; // do not continue 
			}
 
			public boolean visit(SimpleName node) {
				if (this.names.contains(node.getIdentifier())) {
					System.out.println("Usage of '" + node + "' at line "
							+ cu.getLineNumber(node.getStartPosition()));
				}
				return true;
			}
			
			public boolean visit(FieldDeclaration fd){
				Object o = fd.fragments().get(0);
				if(o instanceof VariableDeclarationFragment){
					String s = ((VariableDeclarationFragment) o).getName().toString();
					if(s.toUpperCase().equals(s))
					System.out.println("-------------field: " + s);
				}

				return false;
			}
			
			
			/*@Override
			public boolean visit(VariableDeclarationStatement node) {
				for (Iterator iter = node.fragments().iterator(); iter.hasNext();) {
					VariableDeclarationFragment fragment = (VariableDeclarationFragment) iter
							.next();
					
					System.out.println("Debug: " + fragment.toString());
					

					// VariableDeclarationFragment: is the plain variable declaration
					// part. Example:
					// "int x=0, y=0;" contains two VariableDeclarationFragments, "x=0"
					// and "y=0"

					IVariableBinding binding = fragment.resolveBinding();
				
					// first assignment is the initalizer
				}
				return false; // prevent that SimpleName is interpreted as
				// reference
			}*/
			
		//});
	}
	
	public void identifyJavaFileType(IPackageFragment selectedPackage){
		
		factoryPatternObjs = new FactoryPatternObjs();

		try {
			for(ICompilationUnit javaFile : selectedPackage.getCompilationUnits()){
				
				//ISelection selection;
				IType primaryType = javaFile.findPrimaryType();
				System.out.println("ICompilationUnit: " + javaFile.getElementName() + " is Interface --> " + primaryType.isInterface());	
				System.out.println("Debug:" + javaFile.getPath());
				
				/*
				IWorkspace space = ResourcesPlugin.getWorkspace();	
				IFile input = (IFile)space.getRoot().findMember(javaFile.getPath());
				*/
				String source = javaFile.getSource();
				//String interface_checker = "interface";
				String caller_checker = "public static void main(String[] args)";
				String implemented_checker = "implements";
				
				//boolean interface_obj = source.contains(interface_checker);
				boolean checker_obj = source.contains(caller_checker);
				boolean implemented_obj = source.contains(implemented_checker);
				
				if(primaryType.isInterface() == true){
					factoryPatternObjs.interfaceObj = javaFile;
				}else if(checker_obj == true){
					factoryPatternObjs.caller = javaFile;
				}else if(implemented_obj == true){
					factoryPatternObjs.implementedObjs.add(javaFile);
				}else{
					factoryPatternObjs.factoryObj = javaFile;
				}
				
			}
		} catch (JavaModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("End");
	}
	
}
