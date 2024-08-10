# Car Service Appointment Booking Application

## Overview

The Car Service Appointment Booking Application is a comprehensive web-based solution developed using Spring Boot. It is designed to manage car service appointments, with features such as appointment booking, updating, deleting, and filtering. The application is backed by AWS RDS for database management and can be deployed both locally and on AWS EC2 instances. This project is designed as an end-to-end DevOps project, demonstrating best practices in software development, containerization, continuous integration, and deployment (CI/CD), load balancing, and DNS management using AWS.

## Features

- **CRUD Operations:** Manage car service appointments (add, view, update, delete).
- **Database Management:** Uses PostgreSQL for local development and AWS RDS for production.
- **Containerization:** Dockerized application for consistent environments across development, testing, and production.
- **CI/CD Pipeline:** Integrated CI/CD pipeline using Docker and AWS services.
- **Load Balancing:** AWS Elastic Load Balancer (ELB) for distributing traffic across multiple instances.
- **DNS Management:** Route 53 for domain and subdomain management, ensuring efficient routing of requests.
- **Local and Cloud Deployment:** Deploy the application on a local machine or AWS EC2 instance.

## Technologies Used

- **Backend:** Spring Boot (Java 17)
- **Database:** PostgreSQL (local) and AWS RDS (production)
- **Containerization:** Docker
- **Deployment:** Apache Tomcat (on EC2), AWS ECR for containerization, AWS ELB for load balancing
- **DNS Management:** AWS Route 53
- **Version Control:** Git

## Prerequisites

- Java 17
- Apache Maven
- PostgreSQL (for local environment)
- AWS account (for cloud deployment)
- Docker
- Git

## Getting Started

### Running the Application Locally

1. **Create Project Directory:**
   ```bash
   mkdir springboot
   cd springboot

2.Clone the Repository:
git clone https://github.com/sandeep-kalasgonda/updated-project.git
cd updated-project

3.Check Java Version:
Ensure Java 17 is installed:
java -version

4.Install Apache Maven:
Install Maven if it's not already installed.

5.Configure the Application:

Open src/main/resources/application.properties.
Configure the database settings for PostgreSQL:
spring.datasource.url=jdbc:postgresql://localhost:5432/car
spring.datasource.username=<your-username>
spring.datasource.password=<your-password>

6.Run the Application:
  mvn clean package
This will create a WAR file in the target/ directory.

7.Start the Application:

Open src/main/java/com/example/CarServiceApplication.java.
Run the main function to start the application.
Access the application at http://localhost:8080.






### Deploying on AWS EC2 with Tomcat
1.Clone the Repository on EC2:
git clone https://github.com/sandeep-kalasgonda/updated-project.git
cd updated-project
2.Install Java 17 on EC2:
Follow the instructions to install Java 17.
3.Install Maven:
Install Maven compatible with Java 17.
4.Install Apache Tomcat 10.1:
sudo apt-get install tomcat10
5.Configure Tomcat:
Edit user.xml:
cd /etc/tomcat10
sudo vi tomcat-users.xml
Add user roles and permissions as required.
Update context.xml:
cd /var/lib/tomcat10/webapps/ROOT/META-INF
sudo vi context.xml
allow the manager dashboard

6.Deploy the Application:
mvn clean package
cp target/project.war /var/lib/tomcat10/webapps/
7.Start Tomcat:
sudo systemctl start tomcat10
8.Access the Application:

Visit http://<ec2-public-ip>:8080/project to access the application.
Ensure the EC2 instance security group allows inbound traffic on port 8080.



### Containerizing the Application with Docker
Dockerize the Application:

1.Create a Dockerfile in the project root:(use project docker file)
2.Build the Docker Image:
docker build -t carservice:latest .
3.Run the Docker Container Locally:
docker run -p 8080:8080 carservice:latest
Access the application at http://localhost:8080.



### Pushing the Docker Image to AWS ECR
1.Create an AWS ECR Repository:

-Create an ECR repository via the AWS Management Console.
3.Configure AWS CLI with IAM User Credentials:
aws configure
Enter the IAM access key, secret key, and region.

4.Tag the Docker Image:
docker tag carservice:latest <aws_account_id>.dkr.ecr.<region>.amazonaws.com/carservice:latest

5.Push the Docker Image to ECR:
docker push <aws_account_id>.dkr.ecr.<region>.amazonaws.com/carservice:latest



### Deploying with AWS Elastic Load Balancer (ELB) and Route 53
Set Up Elastic Load Balancer:

Create a new load balancer in the AWS EC2 console.
Choose an Internet-facing scheme and configure the listener on port 8080.
Assign security groups that allow inbound traffic on port 8080.
Register EC2 instances as targets in a target group.
Configure Route 53 for DNS Management:

Create a hosted zone for your domain in Route 53.
Obtain the NS records and update them in your domain provider’s DNS settings.
Create an A or CNAME record in Route 53, pointing to the ELB DNS name.
Ensure that the DNS propagates correctly.
Test the Deployment:

After DNS propagation, access the application via the subdomain configured in Route 53.


### DevOps End-to-End Project Overview
This project showcases a complete DevOps pipeline from development to deployment, demonstrating the following key areas:

Development: Application development using Spring Boot and Java 17.
Version Control: Git for managing source code and collaborating with team members.
Containerization: Docker for packaging the application into containers for consistent environments across development, testing, and production.
CI/CD: Continuous integration and continuous deployment pipeline using Docker and AWS services.
Infrastructure as Code: AWS ECR for container registry, EC2 for computing resources, ELB for load balancing, and Route 53 for DNS management.
Monitoring & Logging: (Optional) Integrate AWS CloudWatch or other monitoring tools to track application performance and logs.
Security: IAM roles, security groups, and secure access to resources.
Contributing
Feel free to fork the repository and submit pull requests. For significant changes, please open an issue first to discuss what you would like to change.

License
This project is licensed under the MIT License - see the LICENSE file for details.


### Final Notes:

- Ensure that the placeholders like `<your-username>`, `<your-password>`, `<aws_account_id>`, and `<region>` are replaced with actual values relevant to your environment.
- You can add monitoring and logging tools such as AWS CloudWatch to the project to make it even more comprehensive.
- You may want to include screenshots or diagrams to visually explain the architecture and deployment process in the `README.md`.










