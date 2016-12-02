package cs585.nanwarin.plugin.dvt.popup.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jface.text.Position;

import cs585.nanwarin.plugin.dvt.Activator;

public class AST_FactoryPattern_ImplementedObj extends ASTVisitor{
	
	FactoryPatternObjs factoryPatternObjs;
	String factoryObj;
	CompilationUnit unit;
	static ICompilationUnit iUnit;
	int implementObjCount = 0;
	int count = 0;
	
	
	public AST_FactoryPattern_ImplementedObj(FactoryPatternObjs factoryPatternObjs, CompilationUnit unit, ICompilationUnit iUnit){
		this.factoryPatternObjs = factoryPatternObjs;
		this.factoryObj = null;
		this.unit = unit;
		this.iUnit = iUnit;
		this.implementObjCount = factoryPatternObjs.implementedObjs.size();
		System.out.println("Implement Obj size: " + implementObjCount);
	}
	
	public boolean visit(VariableDeclarationFragment node) {
		SimpleName name = node.getName();
		//Expression expression = node.getInitializer();
		
		return false;
	}
	
	public static void createMarker(String errorMessage, Position pos){
		IWorkspace space = ResourcesPlugin.getWorkspace();	
		IFile input = (IFile)space.getRoot().findMember(iUnit.getPath());
	//	TextSelection selection = MyMarkerFactory.getTextSelection(); // --> Get from active editor
		IMarker marker = new MyMarkerFactory().createMarker(input, pos, errorMessage);
		MyMarkerFactory.addAnnotation(marker, pos, Activator.getEditor());
	}
	
}
