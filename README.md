# SSAS-Project

**Installation:**

1. Clone project. duh.
1. Install Maven: 
  - Mac: 'brew install maven'
  - Win: http://www.mkyong.com/maven/how-to-install-maven-in-windows/
1. Install Maven eclipse plugin: (install new software) source: 
  - http://download.eclipse.org/technology/m2e/releases/ 
1. Navigate to project directory and 'mvn install'
1. Import project into Eclipse and right click, Maven -> Update Project
1. Setup a run configuration: 
  - Project: dk.itu.ssas.project
  - Main class: webapp.runner.launch.Main
  - Arguments -> Program arguments: ./WebContent
1. **Profit**: Should be running on http://localhost:8080


**MySQL Installation:**

2. If you install WAMP or MAMP you get PHPMyAdmin for free:
  - **W**indows **A**pache **M**ySQL **P**HP: www.wampserver.com/en/
  - **M**ac **A**pache **M**ySQL **P**HP: https://www.mamp.info/
2. Through PHPMyAdmin: 
  - create database 'image_site_db'
  - import image_site_db.sql
