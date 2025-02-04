Task Scheduler with AI Debugging Support 

Overview

This project is a Task Scheduler with AI-powered debugging capabilities. It allows users to create and manage tasks efficiently while also integrating an AI debugging assistant using OpenAI’s API. The AI helper can analyze issues in the code and suggest potential fixes, streamlining software development workflows.

Features

✅ Task Scheduling – Prioritize and manage tasks effectively
✅ AI Debugging Support – Uses OpenAI’s API to analyze and suggest code fixes
✅ Real-time Error Tracking – Identifies and provides feedback on errors
✅ Automated Task Prioritization – Helps users determine which tasks to focus on
✅ User-friendly Interface – Developed using Java with a simple command-line UI

Tech Stack
	•	Java – Core programming language
	•	OpenAI API – For AI-powered debugging
	•	JSON – Data formatting and communication
	•	VS Code – Primary IDE for development


Installation & Setup
	1.	Clone the repository:
 git clone https://github.com/andreay99/Task-Scheduler-AI-Debugger.git
cd Task-Scheduler-AI-Debugger

 2.	Set up dependencies:
	•	Ensure you have Java installed (java -version).
	•	Download the required JSON library:
mkdir lib
curl -o lib/json.jar https://repo1.maven.org/maven2/org/json/json/20210307/json-20210307.jar

	3.	Set up API Key:
	•	Create a config.properties file in the root directory:
OPENAI_API_KEY=your-api-key-here

	4.	Compile the project:
    javac -cp "lib/json.jar:bin" -d bin src/*.java

 5.	Run the program:
    java -cp "lib/json.jar:bin" AIHelper

    
Usage
	•	Run the program and input a task list.
	•	The AI assistant provides task prioritization and debugging suggestions.
	•	Use the AI debugger to analyze code errors and improve productivity.
 
 Project Structure
 /Task-Scheduler-AI-Debugger
│── src/
│   ├── Main.java            # Entry point for Task Scheduler
│   ├── Task.java            # Task model class
│   ├── TaskScheduler.java   # Core task scheduling logic
│   ├── AIHelper.java        # AI Debugging logic using OpenAI API
│   ├── ConfigLoader.java    # Loads API key from config.properties
│── bin/                     # Compiled Java classes
│── lib/                     # External libraries (JSON, HTTP)
│── config.properties        # API key storage
│── README.md                # Project documentation


