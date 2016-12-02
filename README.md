##Description
This plug-in designed to verify design pattern in Eclipse editor.
This is project for CS585 class, Cal Poly Pomona.

##Briefly Project Workflow
![](https://cloud.githubusercontent.com/assets/17581141/20818085/3ead1650-b7e0-11e6-8bef-54d866b8f6be.png)

##Manipulate Java Source

##The Abstract Syntax Tree (AST)
The AST is the base framework for many powerful tools of the Eclipse IDE.

####To work with AST:

######AST Workflow
![](http://www.eclipse.org/articles/Article-JavaCodeManipulation_AST/images/workflow.png)

Parsing Source:
	Basically we need to translate Java Source code to AST. You can implement your own class by using org.eclipse.jdt.core.dom.ASTParser or you also can download 
free library as well. Since my project will work on plug-in, so I created Parser Class by myself for future extention purpose.

![](http://www.eclipse.org/articles/Article-JavaCodeManipulation_AST/images/java-model-overview.png)

##Start to work with plug-in
######Layered Libraries
![](https://cloud.githubusercontent.com/assets/17581141/20573782/5b54763e-b166-11e6-953f-7735fe6e7d91.gif)
######Architecture of Eclipse based applications
![](https://cloud.githubusercontent.com/assets/17581141/20361079/1a448f56-abeb-11e6-9b4a-1dc697bdad0c.PNG)

##References Pictures
######Factory Design Pattern
![](https://www.tutorialspoint.com/design_pattern/images/factory_pattern_uml_diagram.jpg)
######Interpreter Design Pattern
![](https://www.tutorialspoint.com/design_pattern/images/interpreter_pattern_uml_diagram.jpg)
######Step to apply algorithm by HEDGHOG
![](https://cloud.githubusercontent.com/assets/17581141/20803438/157239fa-b7a4-11e6-97f7-2791dd9e6e52.PNG)

##References
[Eclipse Plugins Exposed](http://www.onjava.com/pub/a/onjava/2005/02/09/eclipse.html) <br />
[Eclipse RCP Tutorial](http://www.vogella.com/tutorials/EclipseRCP/article.html) <br />
[Abstract Syntax Tree](http://www.eclipse.org/articles/article.php?file=Article-JavaCodeManipulation_AST/index.html)<br />
[Create Marker for Plug-in](https://www.ibm.com/developerworks/opensource/tutorials/os-eclipse-plugin-guide/#listing1)<br />
[Design Pattern Tutorial](https://www.tutorialspoint.com/design_pattern/factory_pattern.htm)<br />
[Work with Abstract Syntax Tree](http://www.vogella.com/tutorials/EclipseJDT/article.html)<br />
[Format code by JDT](http://www.programcreek.com/2013/04/how-to-format-java-code-by-using-eclipse-jdt/)<br />
[Work with JavaParser](http://tomassetti.me/getting-started-with-javaparser-analyzing-java-code-programmatically/)<br />
[Plug in developer guide](http://help.eclipse.org/mars/index.jsp?topic=%2Forg.eclipse.platform.doc.isv%2Fguide%2FresAdv_markers.htm)<br />
[Implement with IFile](http://www.programcreek.com/java-api-examples/org.eclipse.core.resources.IFile)

######Research papers related this project:
[HEDGEHOG] (http://www.bandlem.com/Alex/Papers/PhDThesis.pdf)
[Automatic Verify Design Pattern Papers](http://homepages.inf.ed.ac.uk/stark/autvdp.pdf)<br />
