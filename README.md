<div id="top"></div>

<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://www.rbi.com/English/corporate-profile/default.aspx">
    <img src="images/inPowered_Logo.jpg" alt="Logo" width="600" height="295">
  </a>

<h3 align="center">inPowered AI - Address Book Reader</h3>

  <p align="center">
    inPowered AI - Address Book Reader Java Application
    <br />
    <a href="https://inpowered.ai/about"><strong>About InPowered AI»</strong></a>
    <br />
    <br />
    <a href="https://inpowered.ai/contact/?topic=request-a-demo">Request a Demo</a>
    ·
    <a href="https://inpowered.ai/blog">Blog</a>
    ·
    <a href="https://inpowered.ai/press">Press</a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
        <li><a href="#testing">Unit Tests</a></li>
      </ul>
    </li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

This is a Simple Java application that reads a txt file and returns some pre-determined intel:
1. How many males are in the address book?
2. Who is the oldest person in the address book?
3. How many days older is Bill than Paul?

<p align="right">(<a href="#top">back to top</a>)</p>


### Built With

Currently, Address Book Reader uses the following stack:

* [Java 11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
* [Maven](https://maven.apache.org/)
* [jUnit](https://junit.org/junit5/)
* [Gitmoji :)](https://gitmoji.dev/)

<p align="right">(<a href="#top">back to top</a>)</p>


<!-- GETTING STARTED -->
## Getting Started

To get a local copy up and running follow these simple example steps.

### Prerequisites

* Git
* Java 11 SDK
* Maven

### Installation

_Please, make sure to follow these steps._

<details><summary><b>Show instructions</b></summary>

1. Clone the Project:
```sh
$ git clone https://github.com/filypsdias/address-book-reading.git
$ cd address-book-reading
```

2. Install the Maven dependencies:

```sh
$ mvn clean install
```
</details>

### Testing

Run full unit tests with the following command
```sh
$ mvn clean test
```

### Running

It's possible to run the project with the following command:
```sh
$ mvn clean install # you can also use mvn clean package
```

* Go to Project -> Target
* Right Click on inPowered-1.0.0-SNAPSHOT.jar and Run 
* It's also possible to run in the Terminal using the command
```sh
$ java -jar inPowered-1.0.0-SNAPSHOT.jar
```
