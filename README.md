##Description
This plug-in designed to verify design pattern in Eclipse editor.
This is project for CS585 class, Cal Poly Pomona.

##Briefly Project Workflow
![](https://cloud.githubusercontent.com/assets/17581141/20818085/3ead1650-b7e0-11e6-8bef-54d866b8f6be.png)

___
##How to run this application [Debugging mode]
- Run as 
- Right click at package area and select DVT option and selection Verify option
![](https://cloud.githubusercontent.com/assets/17581141/20822945/19dbeeae-b804-11e6-90d0-af8848a18e1d.png)

####Example result
Regarding Factory Pattern, we should not call implemented class from interface directly. We should call ShapFactory class in order to use this implemented objects<br />
![](https://cloud.githubusercontent.com/assets/17581141/20852296/f856f4fe-b899-11e6-992d-d5cde3ec6689.png)<br />
After run the plug-in, the plug-in will add mark at the line that code is wrote wrongly, and give recommendation for correct the wrong pattern<br />
![](https://cloud.githubusercontent.com/assets/17581141/20852299/fc288228-b899-11e6-90a8-826250c8a7c6.png)

___
##Manipulate Java Source

####The Abstract Syntax Tree (AST)
The AST is the base framework for many powerful tools of the Eclipse IDE.

####To work with AST:

######AST Workflow
![](http://www.eclipse.org/articles/Article-JavaCodeManipulation_AST/images/workflow.png)<br />
*Figure from* [AST Article](http://www.eclipse.org/articles/article.php?file=Article-JavaCodeManipulation_AST/index.html)

Parsing Source:
	Basically we need to translate Java Source code to AST. You can implement your own class by using org.eclipse.jdt.core.dom.ASTParser or you also can download 
free library as well. Since my project will work on plug-in, so I created Parser Class by myself for future extention purpose. <br />

Below figure shows the Java Model overview. This project first select IPackageFragment in order to pull all Java Classes under same pacakge to identify type of class, if it is interface or else. <br />
And mainly of project will work on ICompilationUnit, in order to manipulate Java Source Code.
![](http://www.eclipse.org/articles/Article-JavaCodeManipulation_AST/images/java-model-overview.png)<br />
*Figure from* [AST Article](http://www.eclipse.org/articles/article.php?file=Article-JavaCodeManipulation_AST/index.html)

<br />
It's really important to understand AST Visitor, because it will help you figure out the way to manipulate the java source code. And if you understand it well, it will help your life more easier'
<br /> 
This is some code example. [Example AST Visitor](http://www.programcreek.com/java-api-examples/index.php?api=org.eclipse.jdt.core.dom.ASTVisitor)

___
##Start to work with plug-in
######Layered Libraries
![](https://cloud.githubusercontent.com/assets/17581141/20573782/5b54763e-b166-11e6-953f-7735fe6e7d91.gif)<br />
*Figure from* [RCP Tutorial](http://www.vogella.com/tutorials/EclipseRCP/article.html)

<br />
Before we start, please download Eclipse Software Development from this link --> [Download](http://download.eclipse.org/eclipse/downloads/). <br />

In this project we create popup menu when we perform right-click at Package under Package Explorer section.
The tutorial is in this link [Create Pop-up Commands](http://www.vogella.com/tutorials/EclipseCommands/article.html)
<br />
The plugin.xml of this project is in this link [plugin.xml](https://github.com/nan2iz/design_pattern_verification_plugin/blob/master/dvt/plugin.xml)


___
##References Pictures
######Factory Design Pattern
![](https://www.tutorialspoint.com/design_pattern/images/factory_pattern_uml_diagram.jpg)<br />
*Figure from* [Design Pattern Tutorial](https://www.tutorialspoint.com/design_pattern/factory_pattern.htm)
######Interpreter Design Pattern
![](https://www.tutorialspoint.com/design_pattern/images/interpreter_pattern_uml_diagram.jpg)<br />
*Figure from* [Design Pattern Tutorial](https://www.tutorialspoint.com/design_pattern/factory_pattern.htm)
######Step to apply algorithm by HEDGHOG
![](https://cloud.githubusercontent.com/assets/17581141/20803438/157239fa-b7a4-11e6-97f7-2791dd9e6e52.PNG)<br />
*Figure from* [Research papers of Alex Blewitt](http://www.bandlem.com/Alex/Papers/PhDThesis.pdf)

___
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
[HEDGEHOG] (http://www.bandlem.com/Alex/Papers/PhDThesis.pdf)<br />
[Automatic Verify Design Pattern Papers](http://homepages.inf.ed.ac.uk/stark/autvdp.pdf)<br />
