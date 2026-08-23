\# Java Login System



A Java-based login and registration web application deployed on AWS EC2 using Apache Tomcat, with an automated CI/CD pipeline implemented using GitHub Actions.



\## 🚀 Technologies



\- Java

\- JSP

\- Servlets

\- MySQL

\- JDBC

\- BCrypt

\- Apache Tomcat 10

\- AWS EC2

\- GitHub

\- GitHub Actions



\## 🏗️ Architecture



```text

&#x20;                   GitHub

&#x20;                      │

&#x20;                      │ git push

&#x20;                      ▼

&#x20;             ┌─────────────────┐

&#x20;             │ GitHub Actions  │

&#x20;             └────────┬────────┘

&#x20;                      │

&#x20;               Build Java WAR

&#x20;                      │

&#x20;                      ▼

&#x20;             ┌─────────────────┐

&#x20;             │     AWS EC2     │

&#x20;             │                 │

&#x20;             │  Apache Tomcat  │

&#x20;             │       │         │

&#x20;             │   Java WAR      │

&#x20;             └───────┬─────────┘

&#x20;                     │

&#x20;                     ▼

&#x20;                 MySQL DB

