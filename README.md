##Description
This plug-in designed to verify design pattern in Eclipse editor.
This is project for CS585 class, Cal Poly Pomona.




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


##References
[Eclipse Plugins Exposed](http://www.onjava.com/pub/a/onjava/2005/02/09/eclipse.html) <br />
[Eclipse RCP Tutorial](http://www.vogella.com/tutorials/EclipseRCP/article.html) <br />
[Abstract Syntax Tree](http://www.eclipse.org/articles/article.php?file=Article-JavaCodeManipulation_AST/index.html)<br />
[Create Marker for Plug-in](https://www.ibm.com/developerworks/opensource/tutorials/os-eclipse-plugin-guide/#listing1)

######Research papers related this project:
[HEDGEHOG] (http://www.bandlem.com/Alex/Papers/PhDThesis.pdf)
[Automatic Verify Design Pattern Papers](http://homepages.inf.ed.ac.uk/stark/autvdp.pdf)<br />