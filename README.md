Project - KKBlog
================


Project design description:
---------------------------
-Project is developed by using POJI-POJO design pattern to support loose coupling between layers(PL,SL,DAL layers).
-Each layer has Interface and its implementation class with a HAS-A relation to the next layer.
-Used model class to create pojo object to transfer data from UI to DB and DB to UI.
-Spring MVC is used to convert UI Form to java object and vice versa.
-Spring ORM/Hibernate is used to convert java object to DB table row and vice versa.


Resources used in the project:
-----------------------------
-Interfaces:
com.app.service.IAdminService
com.app.service.IBlogService
com.app.dao.IAdminDao
com.app.dao.IBlogDao

-Classes:
com.app.model.AdminDataModel
com.app.model.BlogDataModel
com.app.controller.AdminController
com.app.controller.BlogController
com.app.service.impl.AdminServiceImpl
com.app.service.impl.BlogServiceImpl
com.app.dao.impl.AdminDaoImpl
com.app.dao.impl.BlogDaoImpl

-Configuration files:
web.xml --> for Servlet configuration.
sample-servlet.xml --> for Spring configuration.

-HTML, Jsp files:
Derived *.jsp and *.html files under jsps and Error_Pages folder.
index.jsp as a welcome page.

To get the code:
----------------
-Clone the code repository at: 
	https://github.com/kaykayrao/KayKayRepo.git

Required java Technologies:
--------------------------
-JDK6
-Tomcat6
-Spring3.2.5
-Hibernate3
-Oracle10g
-jstl1.2
-HTML
-JSP


Run the application from Eclipse: 
--------------------------------
-Configure Tomcat-6 server in Eclipse.
-Right click on project (KKBlog) and select Run As -> Run On Server


Access the application from browser:
------------------------------------
-Access the deployed web application at: 
	http://localhost:2017/KKBlog/
