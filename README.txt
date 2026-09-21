DELISHE JAVA WEBSITE — NETBEANS GUIDE
=====================================

REQUIREMENT
Java 17 or newer and NetBeans.

OPEN THE PROJECT
1. Unzip Delishe-Java-NetBeans.zip.
2. Open NetBeans.
3. Select File > Open Project.
4. Choose the unzipped "delishe-java" folder.
5. Wait for NetBeans to finish opening the Maven project.
6. Open DelisheWebsite.java.
7. Right-click the project and select Run.
8. Open http://localhost:8080 in your browser.
9. Use the red Stop button in NetBeans to stop the website.

ADD YOUR BUSINESS INFORMATION
Open:
src/main/java/com/delishe/DelisheWebsite.java

Near the top, find "EDIT YOUR BUSINESS INFORMATION HERE". Replace the sample
values between quotation marks. Do not delete the semicolon at the end.

Example:
private static final String LOCATION = "Polokwane, Limpopo";

WHATSAPP NUMBER
Use the international number without +, spaces or the first zero.
Example: 071 234 5678 becomes 27712345678.

ADD OR CHANGE A MENU ITEM
Find the three product(...) lines inside showHomePage(). Change the text between
quotation marks.

Example:
product("Chocolate Cake", "Rich chocolate cake with buttercream.", "R350")

To add another product, add a comma after the preceding product and copy the
line. Example:

product("Savoury Platters", "Fresh platters for events.", "Ask for a quote"),
product("Cupcake Box", "Six decorated cupcakes.", "R120")

CHANGE THE LOGO
Replace src/main/resources/logo.png with another PNG image. Keep the filename
logo.png, then run the project again.

MOBILE AND COMPUTER SUPPORT
This is one responsive website. On wide screens, menu cards appear beside each
other. On phones, they automatically stack into one column.

IMPORTANT
http://localhost:8080 works only while the Java program is running and only on
your device. Public Java hosting is a later step.
