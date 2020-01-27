set projectLocation=C:\Users\TYSS\eclipsewWorkspace\AndroidProject
 
cd %projectLocation%
 
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
 
java org.testng.TestNG %projectLocation%\testng.xml
 
pause
