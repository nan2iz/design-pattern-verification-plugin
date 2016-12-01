package cs585.nanwarin.plugin.dvt.popup.actions;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.SimpleMarkerAnnotation;

public class MyMarkerFactory {

	public static final String MARKER = "cs585.nanwarin.marker";
	public static final String ANNOTATION = "cs585.nanwarin.annotation";
	
	ISelection selection;
	
	public MyMarkerFactory(){
		
	}
	
	public static IMarker createMarker(IResource res, Position pos, String newMessage){
		IMarker marker = null;
		try {
			marker = res.createMarker(MARKER);
			marker.setAttribute(IMarker.MESSAGE, newMessage);
			marker.setAttribute(IMarker.CHAR_START, pos.getOffset());
			return marker;
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return marker;
	}
	
	public static void addAnnotation(IMarker marker, ITextSelection selection, ITextEditor editor){
		IDocumentProvider idp = editor.getDocumentProvider();
		IDocument document = idp.getDocument(editor.getEditorInput());
		IAnnotationModel iamf = idp.getAnnotationModel(editor.getEditorInput());
		SimpleMarkerAnnotation ma = new SimpleMarkerAnnotation(ANNOTATION, marker);
		iamf.connect(document);
		iamf.addAnnotation(ma,new Position(selection.getOffset(),selection.getLength()));
		iamf.disconnect(document);
	}
	
}
