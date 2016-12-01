package cs585.nanwarin.plugin.dvt.popup.actions;

import org.eclipse.jdt.core.ICompilationUnit;

public class PatternObj {

	ICompilationUnit itSelf;
	ICompilationUnit pointTo;
	
	public PatternObj(ICompilationUnit itSelf, ICompilationUnit pointTo){
		this.itSelf = itSelf;
		this.pointTo = pointTo;
	}
}
