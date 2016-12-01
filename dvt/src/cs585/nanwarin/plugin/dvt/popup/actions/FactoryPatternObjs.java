package cs585.nanwarin.plugin.dvt.popup.actions;

import java.util.ArrayList;

import org.eclipse.jdt.core.ICompilationUnit;

public class FactoryPatternObjs {
	
	ICompilationUnit interfaceObj;
	ArrayList<ICompilationUnit> implementedObjs = new ArrayList<ICompilationUnit>();
	ICompilationUnit factoryObj;
	ICompilationUnit caller;

}
