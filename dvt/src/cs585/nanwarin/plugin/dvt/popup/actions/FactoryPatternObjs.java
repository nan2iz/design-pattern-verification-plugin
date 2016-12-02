package cs585.nanwarin.plugin.dvt.popup.actions;

import java.util.ArrayList;

import org.eclipse.jdt.core.ICompilationUnit;

public class FactoryPatternObjs {
	
	ICompilationUnit interfaceObj;
	ArrayList<ICompilationUnit> implementedObjs = new ArrayList<ICompilationUnit>();
	ICompilationUnit factoryObj;
	ICompilationUnit caller;
	
	public ICompilationUnit getInterfaceObj(){
		return interfaceObj;
	}
	
	public ICompilationUnit getFactoryObj(){
		return factoryObj;
	}
	
	public ICompilationUnit getCaller(){
		return caller;
	}

	public ArrayList<ICompilationUnit> getImplementedObjs(){
		return implementedObjs;
	}
}
