# Delishé Website

A beginner-friendly Java 17 website for Delishé, created for NetBeans.

## Features

- Responsive burgundy-and-gold design
- Product menu for cookies, pies, samoosas, crunchies and Chevro
- Automatic WhatsApp order builder
- Product, package-size and quantity selection
- Required-date and collection/delivery fields
- Live order summary
- Mobile navigation

## Open in NetBeans

1. Extract the ZIP file.
2. Open NetBeans.
3. Select **File > Open Project**.
4. Select the extracted `DelisheWebsite` folder.
5. Wait for Maven to finish loading.
6. Right-click the project and select **Run**.
7. If NetBeans asks for a main class, choose `com.delishe.DelisheWebsite`.
8. Open `http://localhost:8081` in your browser.

If **Run** does not start the main class, right-click the project, choose **Run Maven > Goals**, enter `exec:java`, and run it.

## Upload to GitHub from NetBeans

1. Open the project in NetBeans.
2. Select **Team > Git > Initialize Repository**.
3. Right-click the project and choose **Git > Commit**.
4. Select the project files, enter a message such as `Update Delishe website`, and commit.
5. Create an empty repository on GitHub. Do not add a README because this project already has one.
6. Copy the GitHub repository URL.
7. In NetBeans, choose **Team > Remote > Push**.
8. Add the GitHub URL, sign in using your GitHub username and personal access token, and push the `main` branch.

## Main files

- `src/main/java/com/delishe/DelisheWebsite.java` - Java server and website
- `src/main/resources/logo.png` - Delishé logo
- `pom.xml` - Maven and Java 17 configuration

## Important

The WhatsApp form prepares a complete message and opens WhatsApp. Delishé still confirms availability, total price and collection or delivery manually.
