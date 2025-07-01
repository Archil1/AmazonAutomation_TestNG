# TestNG Automation Framwork CI/CD Comptalible
This is a demo automation framework built with TestNG for testing the SauceDemo web application.
It covers multiple end-to-end test scenarios including login, product validation, cart operations, and checkout flows.
The framework is integrated with Jenkins and Docker to enable robust Continuous Integration (CI). Jenkins automates test execution on every code push, while Docker ensures consistent, containerized environments for scalable and reliable test runs. This combination significantly improves testing efficiency, portability, and reliability across different environments.

## Prerequisites

- [Jenkins](https://www.jenkins.io/) installed and running.
- Java, Docker, or other dependencies as required by your project.
- (Optional) Jenkins plugins needed (e.g., Pipeline, Git, Docker, etc.)

## Getting Started

## **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/your-repo.git
   cd your-repo
   ```
⚙️ Configure Jenkins for Test Execution
📌 Create a Jenkins Pipeline Job
Open Jenkins and create a new Pipeline job.

Connect it to your GitHub repository via GitHub integration or by directly specifying the repository URL.

Ensure your repository contains a Jenkinsfile. Jenkins will automatically detect and use it to define the pipeline steps.

## 🐳 **Automatic Docker Management**

The framework includes start.bat and stop.bat scripts that:
Start required Docker containers (e.g., Selenium Grid).
Stop and clean up the containers after test execution.
These scripts are called within the Jenkins pipeline, so no manual Docker interaction is needed.

## ▶️ **Trigger Build for Test Execution**
Click Build Now in Jenkins to run the pipeline.
The pipeline will perform the following automated steps:

Start Docker containers via start.bat
Execute TestNG test suite using mvn test
Shut down Docker containers via stop.bat
All activities are logged and visible through the Jenkins web UI for easy monitoring.


## Contributing

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Commit your changes.
4. Push to the branch (`git push origin feature-branch`).
5. Create a pull request.



---
