https://quarkus.io/quarkus-workshops/super-heroes/#introduction-presentation

# Quarkus Super-Heroes Workshop

<a id="author"></a>Emmanuel Bernard <a id="author2"></a>Clement Escoffier <a id="author3"></a>Antonio Goncalves <a id="author4"></a>Aurea Munoz Hernandez <a id="author5"></a>Georgios Andrianakis <a id="revnumber"></a>version 2.0, <a id="revdate"></a>2022-08-19 <a id="revremark"></a>Quarkus 2.9.2.Final

Table of Contents

- [Welcome](#_welcome)
    - [Presenting the Workshop](#introduction-presentation)
        - [What Is This Workshop About?](#_what_is_this_workshop_about)
        - [What Will You Be Developing?](#_what_will_you_be_developing)
        - [How Does This Workshop Work?](#_how_does_this_workshop_work)
        - [What Do You Have to Do?](#_what_do_you_have_to_do)
        - [Software Requirements](#_software_requirements)
    - [Installing Software](#introduction-installing)
        - [JDK 11](#introduction-installing-jdk)
        - [Apache Maven 3.8.x](#introduction-installing-maven)
        - [cURL](#introduction-installing-curl)
        - [Docker](#introduction-installing-docker)
        - [Rancher Desktop](#introduction-installing-rancher)
        - [Recap](#_recap)
    - [Preparing for the Workshop](#introduction-preparing)
        - [Download the workshop scaffolding](#_download_the_workshop_scaffolding)
        - [Checking Ports](#introduction-preparing-checking-ports)
        - [Warming up Maven](#_warming_up_maven)
        - [Warming up Docker images](#introduction-preparing-warming-docker)
        - [The completed workshop](#_the_completed_workshop)
        - [Ready?](#_ready)
- [Creating a *classical* REST/HTTP Microservice](#rest)
    - [Villain Microservice](#rest-bootstrapping)
        - [Bootstrapping the Villain REST Endpoint](#_bootstrapping_the_villain_rest_endpoint)
        - [Directory Structure](#_directory_structure)
        - [The Villain Resource](#_the_villain_resource)
        - [Running the Application](#_running_the_application)
        - [Development Mode](#_development_mode)
        - [Testing the Application](#_testing_the_application)
        - [Packaging and Running the Application](#_packaging_and_running_the_application)
    - [Transactions and ORM](#rest-transaction-orm)
        - [Directory Structure](#_directory_structure_2)
        - [Installing the PostgreSQL Dependency, Hibernate with Panache and Hibernate Validator](#_installing_the_postgresql_dependency_hibernate_with_panache_and_hibernate_validator)
        - [Villain Entity](#_villain_entity)
        - [Configuring Hibernate](#_configuring_hibernate)
        - [Villain Service](#_villain_service)
        - [Accessing a database in dev mode](#_accessing_a_database_in_dev_mode)
        - [VillainResource Endpoint](#_villainresource_endpoint)
        - [Dependency Injection](#_dependency_injection)
        - [Adding Data](#_adding_data)
        - [CRUD Tests in VillainResourceTest](#_crud_tests_in_villainresourcetest)
        - [Building production package](#_building_production_package)
    - [Configuring the Villain Microservice](#rest-configuration)
        - [Configuring Logging](#_configuring_logging)
        - [Configuring Quarkus Listening Port](#_configuring_quarkus_listening_port)
        - [Injecting Configuration Value](#_injecting_configuration_value)
        - [Create the Configuration](#_create_the_configuration)
        - [Running and Testing the Application](#_running_and_testing_the_application)
    - [Open API](#rest-openapi)
        - [Directory Structure](#_directory_structure_3)
        - [Installing the OpenAPI extension](#_installing_the_openapi_extension)
        - [Open API](#_open_api)
        - [OpenAPI Tests in VillainResourceTest](#_openapi_tests_in_villainresourcetest)
- [Quarkus](#quarkus)
    - [What’s Quarkus?](#quarkus-definition)
    - [Quarkus Augmentation](#quarkus-augmentation)
    - [Application Lifecycle](#quarkus-lifecycle)
        - [Directory Structure](#_directory_structure_4)
        - [Displaying a Banner](#_displaying_a_banner)
    - [Configuration Profiles](#quarkus-profile)
    - [From Java to Native](#quarkus-native)
        - [Building a Native Executable](#_building_a_native_executable)
    - [From Java to Kubernetes](#quarkus-kubernetes)
        - [Prerequisites](#_prerequisites)
        - [Building a container](#_building_a_container)
        - [Building a container running a native executable](#_building_a_container_running_a_native_executable)
        - [Deploying to Kubernetes](#_deploying_to_kubernetes)
- [Reactive](#reactive)
    - [Why reactive?](#_why_reactive)
    - [Hero Microservice](#_hero_microservice)
        - [Directory Structure](#_directory_structure_5)
        - [The Hero entity](#_the_hero_entity)
        - [Uni API in 2 minutes](#_uni_api_in_2_minutes)
        - [The Hero Resource](#_the_hero_resource)
        - [Configuring the reactive access to the database](#_configuring_the_reactive_access_to_the_database)
        - [Importing heroes](#_importing_heroes)
        - [Testing the heroes](#_testing_the_heroes)
    - [Running, Testing and Packaging the Application](#_running_testing_and_packaging_the_application)
- [From Microservice to Microservices](#microservices)
    - [Fight Microservice](#microservices-fight)
        - [Bootstrapping the Fight REST Endpoint](#_bootstrapping_the_fight_rest_endpoint)
        - [Directory Structure](#_directory_structure_6)
        - [Fight Entity](#_fight_entity)
        - [Fighters Bean](#_fighters_bean)
        - [FightService Transactional Service](#_fightservice_transactional_service)
        - [FightResource Endpoint](#_fightresource_endpoint)
        - [Adding Data](#_adding_data_2)
        - [Configuration](#_configuration)
        - [FightResourceTest Test Class](#_fightresourcetest_test_class)
        - [Running, Testing and Packaging the Application](#_running_testing_and_packaging_the_application_2)
    - [User Interface](#microservices-ui)
        - [The Web Application](#_the_web_application)
        - [Running the Web Application](#_running_the_web_application)
        - [Installing the Web Application on Quarkus (optional)](#_installing_the_web_application_on_quarkus_optional)
    - [CORS](#microservices-cors)
- [HTTP communication & Fault Tolerance](#fault-tolerance)
    - [REST Client](#fault-tolerance-rest-client)
        - [Directory Structure](#_directory_structure_7)
        - [Installing the Reactive REST Client Dependency](#_installing_the_reactive_rest_client_dependency)
        - [FightService Invoking External Microservices](#_fightservice_invoking_external_microservices)
        - [Creating the Interfaces](#_creating_the_interfaces)
        - [Configuring REST Client Invocation](#_configuring_rest_client_invocation)
        - [Updating the Test with Mock Support](#_updating_the_test_with_mock_support)
    - [Fallbacks](#fault-tolerance-fallbacks)
        - [Installing the Fault Tolerance Dependency](#_installing_the_fault_tolerance_dependency)
        - [Adding Fallbacks](#_adding_fallbacks)
        - [Running the Application](#_running_the_application_2)
    - [Timeout](#fault-tolerance-timeout)
        - [Adding Timeouts](#_adding_timeouts)
        - [Running the Application](#_running_the_application_3)
- [Event-driven and Reactive microservices](#messaging)
    - [Sending Messages to Kafka](#_sending_messages_to_kafka)
        - [Directory Structure](#_directory_structure_8)
        - [Adding the Reactive Messaging Dependency](#_adding_the_reactive_messaging_dependency)
        - [Connecting Imperative and Reactive Using an Emitter](#_connecting_imperative_and_reactive_using_an_emitter)
        - [Connecting to Kafka](#_connecting_to_kafka)
    - [Receiving Messages from Kafka](#_receiving_messages_from_kafka)
        - [Directory Structure](#_directory_structure_9)
        - [Bootstrapping the Statistics REST Endpoint](#_bootstrapping_the_statistics_rest_endpoint)
        - [Consuming Fight](#_consuming_fight)
        - [Computing Statistics](#_computing_statistics)
        - [Reading Messages from Kafka](#_reading_messages_from_kafka)
    - [Sending Events on WebSockets](#_sending_events_on_websockets)
        - [The TeamStats WebSocket](#_the_teamstats_websocket)
        - [The TopWinner WebSocket](#_the_topwinner_websocket)
        - [The UI](#_the_ui)
        - [Running the Application](#_running_the_application_4)
    - [Unifying Imperative and Reactive Programming](#messaging-conclusion)
- [Observability](#observability)
    - [Health Check](#observability-healthcheck)
        - [Directory Structure](#_directory_structure_10)
        - [Installing the Health Dependency](#_installing_the_health_dependency)
        - [Running the Default Health Check](#_running_the_default_health_check)
        - [Adding Liveness](#_adding_liveness)
- [Writing a Quarkus Extension](#extension)
    - [The extension framework](#_the_extension_framework)
    - [Structure of an extension](#_structure_of_an_extension)
    - [The version extension](#_the_version_extension)
    - [The runtime module](#_the_runtime_module)
    - [The deployment module](#_the_deployment_module)
    - [Packaging the extension](#_packaging_the_extension)
    - [Using the extension](#_using_the_extension)
    - [Conclusion](#_conclusion)
- [Conclusion](#conclusion)
    - [References](#conclusion-references)

## Welcome

Let’s start from the beginning. Quarkus. What’s Quarkus? That’s a pretty good question and probably a good start. If you go to the [Quarkus web site](https://quarkus.io), you’ll read that Quarkus is "*A Kubernetes Native Java stack tailored for OpenJDK HotSpot & GraalVM, crafted from the best of breed Java libraries and standards*." This description is somewhat unclear but does an outstanding job at using bankable keywords. It’s also written: "*Supersonic Subatomic Java*." Still very foggy. In practice, Quarkus is a stack to develop distributed systems and modern applications in Java, Kotlin, or Scala. Quarkus applications are tailored for the Cloud, containers, and Kubernetes. That does not mean you can’t use Quarkus in other environments, there are no limits, but the principles infused in Quarkus have made containerization of applications more efficient. In this workshop, we will explain what Quarkus is and because the best way to understand Quarkus is to use it, build a set of microservices with it. Again, Quarkus is not limited to microservices, but it’s a generally well-understood type of architecture.

This workshop offers attendees an intro-level, hands-on session with Quarkus, from the first line of code to making services, to consuming them, and finally to assembling everything in a consistent system. But, what are we going to build? Well, it’s going to be a set of microservices:

- Using Quarkus

- Using HTTP and events (with Apache Kafka)

- With some parts of the dark side of microservices (resilience, health, monitoring with Prometheus)

- Answer the ultimate question: are super-heroes stronger than super-villains?


This workshop is a BYOL (*Bring Your Own Laptop*) session, so bring your Windows, OSX, or Linux laptop. You need JDK 11 on your machine, Apache Maven (3.8.x), and Docker. On Mac and Windows, Docker for *x* is recommended instead of the Docker toolbox setup.

What you are going to learn:

- What is Quarkus, and how you can use it

- How to build an HTTP endpoint (REST API) with Quarkus

- How to access a relational database

- How you can use Swagger and OpenAPI

- How you test your microservice

- How to build a reactive microservice, including reactive data access

- How you improve the resilience of your service

- How to build event-driven microservices with Kafka

- How to build native executable

- How to extend Quarkus with extensions

- And much more!


Ready? Here we go!

### Presenting the Workshop

#### What Is This Workshop About?

This workshop should give you a practical introduction to Quarkus. You will practice all the needed tools to develop an entire microservice architecture, mixing classical HTTP, reactive and event-based microservices. You will finish by extending the capabilities of Quarkus and learn more about the ability to create native executables.

The idea is that you leave this workshop with a good understanding of what Quarkus is, what it is not, and how it can help you in your projects. Then, you’ll be prepared to investigate a bit more and, hopefully, contribute.

|     |     |
| --- | --- |
|     | Get this workshop from https://github.com/quarkusio/quarkus-workshops/tree/main/quarkus-workshop-super-heroes. |

#### What Will You Be Developing?

In this workshop, you will develop an application that allows superheroes to fight against supervillains. You will be developing several microservices communicating either synchronously via REST or asynchronously using Kafka:

- *Super Hero UI*: an Angular application to pick up a random superhero, a random supervillain, and makes them fight. The Super Hero UI is exposed via Quarkus and invokes the Fight REST API

- *Villain REST API*: A classical HTTP microservice exposing CRUD operations on Villains, stored in a PostgreSQL database

- *Hero REST API*: A reactive HTTP microservice exposing CRUD operations on Heroes, stored in a Postgres database

- *Fight REST API*: This REST API invokes the Hero and Villain APIs to get a random superhero and supervillain. Each fight is, then, stored in a PostgreSQL database. This microservice can be developed using both the classical (*imperative*) or reactive approach. Invocations to the hero and villain services are protected using resilience patterns (retry, timeout, circuit-breakers)

- *Statistics*: Each fight is asynchronously sent (via Kafka) to the Statistics microservice. It has an HTML + JQuery UI displaying all the statistics.

- *Promotheus* polls metrics from the three microservices Fight, Hero, and Villain.


<img width="1418" height="1411" src=":/919710716c41429b9ffd354397bb0d19"/>

The main UI allows you to pick up one random Hero and Villain by clicking on "New Fighters." Then it’s just a matter of clicking on "Fight!" to get them to fight. The table at the bottom shows the list of the previous fights.

<img width="709" height="629" src=":/7dbe37e89a4b49ee814d737c8a1911e0"/>

#### How Does This Workshop Work?

You have this material in your hands (either electronically or printed), and you can now follow it step by step. The structure of this workshop is as follow :

- *Installing all the needed tools*: in this section, you will install all the tools and code to be able to develop, compile and execute our application

- *Developing with Quarkus*: in this section, you will develop a microservice architecture by creating several Maven projects, write some Java code, add JPA entities, JAX-RS REST endpoints, write some tests, use an Angular web application, and all that on Quarkus

- *Extending Quarkus*: in this section, you will create a Quarkus extension


If you already have the tools installed, skip the *Installing all the needed tools* section and jump to the sections *Developing with Quarkus* and *Extending Quarkus*, and start hacking some code and add-ons. This "à la carte" mode lets you make the most of this 6-hour long hands-on lab.

#### What Do You Have to Do?

This workshop should be as self-explanatory as possible. So your job is to follow the instructions by yourself, do what you are supposed to do, and do not hesitate to ask for any clarification or assistance; that’s why the team is here.

You will download a zip file (`quarkus-super-heroes-workshop.zip`) containing *some* of the code and you will need to complete it. If you are stuck, you can always look at the final code in the GitHub repository, or download another zip file (`quarkus-super-heroes-workshop-complete.zip`) that contains *all* the code of the workshop.

Oh, and be ready to have some fun!

#### Software Requirements

First of all, make sure you have a 64bits computer with admin rights (so you can install all the needed tools) and at least 8Gb of RAM (as some tools need a few resources).

|     |     |
| --- | --- |
|     | If you are using Mac OS X, make sure the version is greater than 10.11.x (Captain). |

This workshop will make use of the following Software, tools, frameworks that you will need to install and now (more or less) how it works:

- Any IDE you feel comfortable with (eg. Intellij IDEA, Eclipse IDE, VS Code..)

- JDK 11

- GraalVM 22.0

- Maven 3.8.x

- Docker

- cURL (or any other command line HTTP client)

- Node JS (optional, only if you are in a *frontend* mood)


The following section focuses on how to install and set up the needed Software. You can skip the next section if you have already installed all the prerequisites.

|     |     |
| --- | --- |
|     | This workshop assumes a bash shell. If you run on Windows, in particular, adjust the commands accordingly. |

### Installing Software

#### JDK 11

Essential for the development and execution of this workshop is the *Java Development Kit* (JDK).<sup>\[<a id="_footnoteref_1"></a>[1](#_footnotedef_1 "View footnote.")\]</sup> The JDK includes several tools such as a compiler (`javac`), a virtual machine, a documentation generator (`JavaDoc), monitoring tools (Visual VM) and so on<sup>\[<a id="_footnoteref_2"></a>[2](#_footnotedef_2 "View footnote.")\]</sup>. The code in this workshop uses JDK 11.

##### Installing the JDK

To install the JDK 11, follows the instructions from https://adoptium.net/installation.html to download and install the JDK for your platform.

There is also an easier way to download and install Java if you are on Mac OS X. You can use Homebrew to install OpenJDK 11 using the following commands.<sup>\[<a id="_footnoteref_3"></a>[3](#_footnotedef_3 "View footnote.")\]</sup>

```
brew install java11
```

For Linux distributions, there are also packaged java installations.

```
# dnf (rpm-based)
dnf install java-11-openjdk
# Debian-based distributions:
$ apt-get install openjdk-11-jdk
```

##### Checking for Java Installation

Once the installation is complete, it is necessary to set the `JAVA_HOME` variable and the `$JAVA_HOME/bin` directory to the `PATH` variable. Check that your system recognizes Java by entering `java -version` and the Java compiler with `javac -version`.

```
$ java -version
openjdk version "11.0.15" 2022-04-19
OpenJDK Runtime Environment Temurin-11.0.15+10 (build 11.0.15+10)
OpenJDK 64-Bit Server VM Temurin-11.0.15+10 (build 11.0.15+10, mixed mode)
 $ javac -version
javac 11.0.15
```

##### GraalVM 22.0

GraalVM extends the *Java Virtual Machine* (JVM) to support more languages and several execution modes.<sup>\[<a id="_footnoteref_4"></a>[4](#_footnotedef_4 "View footnote.")\]</sup> It supports a large set of languages: Java of course, other JVM-based languages (such as Groovy, Kotlin etc.) but also JavaScript, Ruby, Python, R and C/C++. It includes a high-performance Java compiler, which can be used in a *Just-In-Time* (JIT) configuration on the HotSpot VM or in an *Ahead-Of-Time* (AOT) configuration with the GraalVM native compiler. One objective of GraalVM is to improve the performance of Java virtual machine-based languages to match the performance of native languages.

###### Prerequisites for GraalVM

On Linux, you need GCC and the Glibc and zlib headers. Examples for common distributions:

```
# dnf (rpm-based)
sudo dnf install gcc glibc-devel zlib-devel
# Debian-based distributions:
sudo apt-get install build-essential libz-dev zlib1g-dev
```

On macOS X, XCode provides the required dependencies to build native executables:

```
xcode-select --install
```

On Windows, you need the *Developer Command Prompt for Microsoft Visual C++*. Check the [Windows prerequisites page](https://www.graalvm.org/docs/getting-started/windows/#prerequisites-for-using-native-image-on-windows) for details.

###### Installing GraalVM

GraalVM installed from the GraalVM project.<sup>\[<a id="_footnoteref_5"></a>[5](#_footnotedef_5 "View footnote.")\]</sup>.

Version 22.0 is required. Select the 11 version.

Follow the installation instructions:

- Linux - https://www.graalvm.org/docs/getting-started/linux/

- Windows - https://www.graalvm.org/docs/getting-started/windows/

- MacOS - https://www.graalvm.org/docs/getting-started/macos/


Once installed, define the `GRAALVM_HOME` environment variable to point to the directory where GraalVM is installed (eg. on Mac OS X it could be /Library/Java/JavaVirtualMachines/graalvm-ce-22.0/Contents/Home).

The `native-image` tool must be installed. It can be done by running `gu install native-image` from your GraalVM `bin` directory.

|     |     |
| --- | --- |
|     | Mac OS X - Catalina<br><br>On Mac OS X Catalina, the installation of the `native-image` executable may fail. GraalVM binaries are not (yet) notarized for Catalina. To bypass the issue, it is recommended to run the following command instead of disabling macOS Gatekeeper entirely:<br><br>```<br>xattr -r -d com.apple.quarantine ${GRAAL_VM}<br>``` |

###### Checking for GraalVM Installation

Once installed and set up, you should be able to run the following command and get the following output.

```
$ $GRAALVM_HOME/bin/native-image --version
GraalVM 22.0.0.2 Java 11 CE (Java Version 11.0.15+10-jvmci-22.0-b05)
```

#### Apache Maven 3.8.x

All the examples of this workshop are built and tested using Maven.<sup>\[<a id="_footnoteref_6"></a>[6](#_footnotedef_6 "View footnote.")\]</sup> Maven offers a building solution, shared libraries, and a plugin platform for your projects, allowing you to do quality control, documentation, teamwork, and so forth. Based on the "convention over configuration" principle, Maven brings a standard project description and a number of conventions such as a standard directory structure. With an extensible architecture based on plugins, Maven can offer many different services.

##### Installing Maven

The examples of this workshop have been developed with Apache Maven 3.8.x. Once you have installed JDK 11, make sure the `JAVA_HOME` environment variable is set. Then, download Maven from http://maven.apache.org/, unzip the file on your hard drive and add the `apache-maven/bin` directory to your `PATH` variable. More details about the installation process are available on https://maven.apache.org/install.html.

But of course, if you are on Mac OS X and use Homebrew, install Maven with the following command:

```
brew install maven
```

##### Checking for Maven Installation

Once you’ve got Maven installed, open a command line and enter `mvn -version` to validate your installation. Maven should print its version and the JDK version it uses (which is handy as you might have different JDK versions installed on the same machine).

```
$ mvn -version
Apache Maven 3.8.4 (ea98e05a04480131370aa0c110b8c54cf726c06f)
Maven home: /usr/local/Cellar/maven/3.8.4/libexec
Java version: 11.0.15, vendor: AdoptOpenJDK, runtime: /Users/clement/.sdkman/candidates/java/11.0.15.hs-adpt
Default locale: en_FR, platform encoding: UTF-8
OS name: "mac os x", version: "11.5", arch: "x86_64", family: "mac"
```

Be aware that Maven needs Internet access to download plugins and project dependencies from the Maven Central and other remote repositories.<sup>\[<a id="_footnoteref_7"></a>[7](#_footnotedef_7 "View footnote.")\]</sup>

##### Some Maven Commands

Maven is a command-line utility where you can use several parameters and options to build, test, or package your code. To get some help on the commands, you can type, use the following command:

```
$ mvn --help

usage: mvn [options] [<goal(s)>] [<phase(s)>]
```

Here are some commands that you will be using to run the examples in the workshop. Each invokes a different phase of the project life cycle (clean, compile, install, etc.) and use the `pom.xml` to download libraries, customize the compilation, or extend some behaviors with plugins:

- `mvn clean`: Deletes all generated files (compiled classes, generated code, artifacts etc.).

- `mvn compile`: Compiles the main Java classes.

- `mvn test-compile`: Compiles the test classes.

- `mvn test`: Compiles the main Java classes as well as the test classes and executes the tests.

- `mvn package`: Compiles, executes the tests, and packages the code into an archive.

- `mvn install`: Builds and installs the artifacts in your local repository.

- `mvn clean install`: Cleans and installs (note that you can add several commands separated by a space, like `mvn clean compile test`).


#### cURL

To invoke the REST Web Services described in this workshop, we often use cURL.<sup>\[<a id="_footnoteref_8"></a>[8](#_footnotedef_8 "View footnote.")\]</sup> cURL is a command-line tool and library to do reliable data transfers with various protocols, including HTTP. It is free, open-source (available under the MIT Licence), and has been ported to several operating systems.

##### Installing cURL

If you are on Mac OS X and have installed Homebrew, then installing cURL is just a matter of a single command.<sup>\[<a id="_footnoteref_9"></a>[9](#_footnotedef_9 "View footnote.")\]</sup> Open your terminal and install cURL with the following command:

```
brew install curl
```

For Windows, download and install curl from https://curl.se/download.html.

##### Checking for cURL Installation

Once installed, check for cURL by running `curl --version` in the terminal. It should display cURL version:

```
$ curl --version
curl 7.64.1 (x86_64-apple-darwin20.0) libcurl/7.64.1 (SecureTransport) LibreSSL/2.8.3 zlib/1.2.11 nghttp2/1.41.0
Release-Date: 2019-03-27
Protocols: dict file ftp ftps gopher http https imap imaps ldap ldaps pop3 pop3s rtsp smb smbs smtp smtps telnet tftp
Features: AsynchDNS GSS-API HTTP2 HTTPS-proxy IPv6 Kerberos Largefile libz MultiSSL NTLM NTLM_WB SPNEGO SSL UnixSockets
```

##### Some cURL Commands

cURL is a command-line utility where you can use several parameters and options to invoke URLs. You invoke `curl` with zero, one, or several command-line options to accompany the URL (or set of URLs) you want the transfer to be about. cURL supports over two hundred different options, and I would recommend reading the documentation for more help.<sup>\[<a id="_footnoteref_10"></a>[10](#_footnotedef_10 "View footnote.")\]</sup> To get some help on the commands and options, you can type, use the following command:

```
$ curl --help

Usage: curl [options...] <url>
```

You can also opt to use `curl --manual`, which will output the entire man page for cURL plus an appended tutorial for the most common use cases.

Here are some commands you will use to invoke the RESTful web service examples in this workshop.

- `curl http://localhost:8083/api/heroes/hello`: HTTP GET on a given URL.

- `curl -X GET http://localhost:8083/api/heroes/hello`: Same effect as the previous command, an HTTP GET on a given URL.

- `curl -v http://localhost:8083/api/heroes/hello`: HTTP GET on a given URL with verbose mode on.

- `curl -H 'Content-Type: application/json' http://localhost:8083/api/heroes/hello`: HTTP GET on a given URL passing the JSON Content Type in the HTTP Header.

- `curl -X DELETE http://localhost:8083/api/heroes/1`: HTTP DELETE on a given URL.


##### Formatting the cURL JSON Output

Very often, when using cURL to invoke a RESTful web service, we get some JSON payload. cURL does not format this JSON so that you will get a flat String such as:

```
curl http://localhost:8083/api/heroes
[{"id":"1","name":"Chewbacca","level":"14"},{"id":"2","name":"Wonder Woman","level":"15"},{"id":"3","name":"Anakin Skywalker","level":"8"}]
```

But what we want is to format the JSON payload, so it is easier to read. For that, there is a neat utility tool called `jq` that we could use. `jq` is a tool for processing JSON inputs, applying the given filter to its JSON text inputs, and producing the filter’s results as JSON on standard output.<sup>\[<a id="_footnoteref_11"></a>[11](#_footnotedef_11 "View footnote.")\]</sup> You can install it on Mac OSX with a simple `brew install jq`. Once installed, it’s just a matter of piping the cURL output to jq like this:

```
curl http://localhost:8083/api/heroes | jq

[
  {
    "id": "1",
    "name": "Chewbacca",
    "lastName": "14"
  },
  {
    "id": "2",
    "name": "Wonder Woman",
    "lastName": "15"
  },
  {
    "id": "3",
    "name": "Anakin Skywalker",
    "lastName": "8"
  }
]
```

#### Docker

```


Instead of Docker, you can use Rancher Desktop which provide the same capabilities but also lets you run Kubernetes locally.
If you plan to deploy your applications to Kubernetes, we recommend Rancher Desktop.

Instructions to install Rancher Desktop are available in <<introduction-installing-rancher>>.


```

Docker is a set of utilities that use OS-level virtualization to deliver software in packages called containers. Containers are isolated from one another and bundle their software, libraries, and configuration files; they can communicate with each other through well-defined channels.

##### Installing Docker

Our infrastructure will use Docker to ease the installation of the different technical services (database, monitoring…​). So for this, we need to install `docker` and `docker compose` Installation instructions are available on the following page:

- Mac OS X - https://docs.docker.com/docker-for-mac/install/ (version 20+)

- Windows - https://docs.docker.com/docker-for-windows/install/ (version 20+)

- CentOS - https://docs.docker.com/install/linux/docker-ce/centos/

- Debian - https://docs.docker.com/install/linux/docker-ce/debian/

- Fedora - https://docs.docker.com/install/linux/docker-ce/fedora/

- Ubuntu - https://docs.docker.com/install/linux/docker-ce/ubuntu/


On Linux, don’t forget the post-execution steps described on https://docs.docker.com/install/linux/linux-postinstall/.

|     |     |
| --- | --- |
|     | If you are on the latest versions of Fedora, you might prefer `podman` (https://podman.io/) instead of `docker`. To install `podman` and `podman-compose` on Fedora please follow the instructions at https://fedoramagazine.org/manage-containers-with-podman-compose/. You will also need to configure testcontainers library used in Dev Services later in the workshop like mentioned in https://quarkus.io/blog/quarkus-devservices-testcontainers-podman/#tldr. |

##### Checking for Docker Installation

Once installed, check that both `docker` and `docker compose` are available in your `PATH`:

```
$ docker version
Docker version 20.10.8, build 3967b7d
Cloud integration: v1.0.24
Version:           20.10.14
API version:       1.41
 $ docker compose version
Docker Compose version v2.5.0
```

Finally, run your first container as follows:

```
$ docker run hello-world

Hello from Docker!
This message shows that your installation appears to be working correctly.

To generate this message, Docker took the following steps:
1. The Docker client contacted the Docker daemon.
2. The Docker daemon pulled the "hello-world" image from the Docker Hub.
(amd64)
3. The Docker daemon created a new container from that image which runs the
executable that produces the output you are currently reading.
4. The Docker daemon streamed that output to the Docker client, which sent it
to your terminal.

To try something more ambitious, you can run an Ubuntu container with:
$ docker run -it ubuntu bash

Share images, automate workflows, and more with a free Docker ID:
 https://hub.docker.com/

For more examples and ideas, visit:
 https://docs.docker.com/get-started/
```

##### Some Docker Commands

Docker is a command-line utility where you can use several parameters and options to start/stop a container. You invoke `docker` with zero, one, or several command-line options with the container or image ID you want to work with. Docker comes with several options that are described in the documentation if you need more help.<sup>\[<a id="_footnoteref_12"></a>[12](#_footnotedef_12 "View footnote.")\]</sup> To get some help on the commands and options, you can type, use the following command:

```
$ docker help

Usage:  docker [OPTIONS] COMMAND
 $ docker help attach

Usage:  docker attach [OPTIONS] CONTAINER

Attach local standard input, output, and error streams to a running container
```

Here are some commands that you will be using to start/stop containers in this workshop.

- `docker container ls`: Lists containers.

- `docker container start CONTAINER`: Starts one or more stopped containers.

- `docker compose -f docker-compose.yaml up -d`: Starts all containers defined in a Docker Compose file.

- `docker compose -f docker-compose.yaml down`: Stops all containers defined in a Docker Compose file.


#### Rancher Desktop

Listing 1. NOTE

```
You only need Rancher Desktop if you didn't install Docker or if you want to deploy the applications to a local
Kubernetes instance. You can also use https://minikube.sigs.k8s.io/docs/start/[minikube] for the latter.
```

Rancher Desktop runs Kubernetes and container management on your desktop. You can choose the version of Kubernetes you want to run. You can build, push, pull, and run container images using either *containerd* or *Moby (dockerd)*. The container images you build can be run by Kubernetes immediately without the need for a registry.

##### Installing Rancher Desktop

To install Rancher Desktop, follows the [instructions](https://docs.rancherdesktop.io/getting-started/installation). Rancher Desktop is available on MacOS, Windows and various Linux distributions.

##### Checking for Rancher Desktop Installation

Once installed, check that both `docker` and `kubectl` are available in your `PATH`:

```
$ docker version
Docker version 20.10.16, build aa7e414
 $ kubectl version
Client Version: version.Info{Major:"1", Minor:"23", GitVersion:"v1.23.3", GitCommit:"816c97ab8cff8a1c72eccca1026f7820e93e0d25", GitTreeState:"clean", BuildDate:"2022-01-25T21:25:17Z", GoVersion:"go1.17.6", Compiler:"gc", Platform:"darwin/amd64"}
Server Version: version.Info{Major:"1", Minor:"23", GitVersion:"v1.23.3+k3s1", GitCommit:"5fb370e53e0014dc96183b8ecb2c25a61e891e76", GitTreeState:"clean", BuildDate:"2022-01-27T02:12:21Z", GoVersion:"go1.17.5", Compiler:"gc", Platform:"linux/amd64"}
```

|     |     |
| --- | --- |
|     | Rancher Desktop installs its own *docker* CLI too in `~/.rd/bin` |

Finally, run your first container as follows:

```
$ docker run hello-world

Hello from Docker!
This message shows that your installation appears to be working correctly.

To generate this message, Docker took the following steps:
1. The Docker client contacted the Docker daemon.
2. The Docker daemon pulled the "hello-world" image from the Docker Hub.
(amd64)
3. The Docker daemon created a new container from that image which runs the
executable that produces the output you are currently reading.
4. The Docker daemon streamed that output to the Docker client, which sent it
to your terminal.

To try something more ambitious, you can run an Ubuntu container with:
$ docker run -it ubuntu bash

Share images, automate workflows, and more with a free Docker ID:
 https://hub.docker.com/

For more examples and ideas, visit:
 https://docs.docker.com/get-started/
```

##### Some Docker Commands

Docker is a command-line utility where you can use several parameters and options to start/stop a container. You invoke `docker` with zero, one, or several command-line options with the container or image ID you want to work with. Docker comes with several options that are described in the documentation if you need more help <sup>\[<a id="_footnoteref_13"></a>[13](#_footnotedef_13 "View footnote.")\]</sup>.

To get some help on the commands and options, you can type, use the following command:

```
$ docker help

Usage:  docker [OPTIONS] COMMAND
 $ docker help attach

Usage:  docker attach [OPTIONS] CONTAINER

Attach local standard input, output, and error streams to a running container
```

Here are some commands that you will be using to start/stop containers in this workshop.

- `docker container ls`: Lists containers.

- `docker container start CONTAINER`: Starts one or more stopped containers.

- `docker compose -f docker-compose.yaml up -d`: Starts all containers defined in a Docker Compose file.

- `docker compose -f docker-compose.yaml down`: Stops all containers defined in a Docker Compose file.


##### Checking for Rancher Desktop Kubernetes support

|     |     |
| --- | --- |
|     | If you use Kubernetes already, make sure that `kubectl` uses the `rancher-desktop` context. This can be done from the Rancher Desktop UI. |

```
$ kubectl run hello-ngnix --image=nginx:alpine --port=80
$ kubectl port-forward pods/hello-ngnix 8080:80
```

If you open a browser to http://localhost:8080, you should see the "Welcome to nginx!" page.

Stop the port forwarding using `CTRL+C`, and delete the pod:

```
(CTRL+C)
$ kubectl delete pod hello-ngnix
```

#### Recap

Just make sure the following commands work on your machine.

```
$ java -version
$ $GRAALVM_HOME/bin/native-image --version
$ mvn -version
$ curl --version
$ docker version
$ docker compose version
$ kubectl version # If you used Rancher Desktop and plan to use Kubernetes
```

### Preparing for the Workshop

This workshop needs internet access to download all sorts of Maven artifacts, Docker images, and even pictures. Some of these artifacts are large, and because we have to share internet connexions at the workshop, it is better to download them before the workshop. Here are a few commands that you can execute before the workshop.

#### Download the workshop scaffolding

Call to action

First, download the zip file https://raw.githubusercontent.com/quarkusio/quarkus-workshops/main/quarkus-workshop-super-heroes/dist/quarkus-super-heroes-workshop.zip, and unzip it wherever you want. This zip file contains *some* of the code of the workshop, and you will need to complete it.

In this workshop, you will be developing an application dealing with Super Heroes (and Super-Villains 🦹) as well as Quarkus extensions. The code will be separated into two different directories:

![Diagram](:/9c6dc454200147528b33396c5131ac13)

##### Super Heroes Application

Under the `super-heroes` directory you will find the entire Super Hero application spread throughout a set of subdirectories, each one containing a microservice or some tooling. The final structure will be the following:

![Diagram](:/50568816dd4e4b129f70546655987ed5)

Most of these subdirectories are Maven projects and follow the Maven directory structure:

![Diagram](:/a8d8a97994c94a21bbffbf1050acc9bf)

#### Checking Ports

During this workshop, we will use several ports.

Call to action

Just make sure the following ports are free, so you don’t run into any conflicts.

```
lsof -i tcp:8080    # UI
lsof -i tcp:8082    # Fight REST API
lsof -i tcp:8084    # Villain REST API
lsof -i tcp:8083    # Hero REST API
lsof -i tcp:5432    # Postgres
lsof -i tcp:9090    # Prometheus
lsof -i tcp:2181    # Zookeeper
lsof -i tcp:9092    # Kafka
```

#### Warming up Maven

Now that you have the initial structure in place, navigate to the root directory and run:

Call to action

```
mvn clean install
```

By running this command, it downloads all the required dependencies.

#### Warming up Docker images

To warm up your Docker image repository, navigate to the `quarkus-workshop-super-heroes/super-heroes/infrastructure` directory. Here, you will find a `docker-compose.yaml`/`docker-compose-linux.yaml` files which define all the needed Docker images. Notice that there is a `db-init` directory with an `initialize-databases.sql` script which sets up our databases, and a `monitoring` directory (all that will be explained later).

Call to action

Then execute the following command which will download all the Docker images and start the containers:

```
docker compose -f docker-compose.yaml up -d
```

|     |     |
| --- | --- |
|     | Linux Users beware<br><br>If you are on Linux, use `docker-compose-linux.yaml` instead of `docker-compose.yaml`. This Linux specific file will allow Prometheus to fetch metrics from the services running on the host machine. |

|     |     |
| --- | --- |
|     | If you have an issue creating the roles for the database with the `initialize-databases.sql` file, you have to execute the following commands:<br><br>```<br>docker exec -it --user postgres super-database psql -c "CREATE ROLE superman LOGIN PASSWORD 'superman' NOSUPERUSER INHERIT NOCREATEDB NOCREATEROLE NOREPLICATION"<br>docker exec -it --user postgres super-database psql -c "CREATE ROLE superbad LOGIN PASSWORD 'superbad' NOSUPERUSER INHERIT NOCREATEDB NOCREATEROLE NOREPLICATION"<br>docker exec -it --user postgres super-database psql -c "CREATE ROLE superfight LOGIN PASSWORD 'superfight' NOSUPERUSER INHERIT NOCREATEDB NOCREATEROLE NOREPLICATION"<br>``` |

After this, verify the containers are running using the following command:

```
docker compose -f docker-compose.yaml ps
```

The output should resemble something like this:

```
 Name                   Command               State           Ports
--------------------------------------------------------------------------------
kafka            sh -c bin/kafka-server-sta ...   Up      0.0.0.0:9092->9092/tcp
super-database   docker-entrypoint.sh postgres    Up      0.0.0.0:5432->5432/tcp
super-visor      /bin/prometheus --config.f ...   Up      0.0.0.0:9090->9090/tcp
zookeeper        sh -c bin/zookeeper-server ...   Up      0.0.0.0:2181->2181/tcp
```

Once all the containers are up and running, you can shut them down and remove their volumes with the commands:

```
docker compose -f docker-compose.yaml down
docker compose -f docker-compose.yaml rm
```

|     |     |
| --- | --- |
|     | What’s this infra?<br><br>Any microservice system is going to rely on a set of technical services. In our context, we are going to use PostgreSQL as the database, Prometheus as the monitoring tool, and Kafka as the event/message bus. This infrastructure starts all these services, so you don’t have to worry about them.<br><br>This infra will only be used when we run our services in *prod* mode. In *dev* mode, Quarkus will start everything for us. |

#### The completed workshop

You can find the completed code on https://github.com/quarkusio/quarkus-workshops/tree/main/quarkus-workshop-super-heroes. So, if you are stuck, feel free to check the solution.

In addition, you can [download](https://raw.githubusercontent.com/quarkusio/quarkus-workshops/main/quarkus-workshop-super-heroes/dist/quarkus-super-heroes-workshop-complete.zip) the full code of the workshop .

To build the completed workshop, you need to run the following commands from the root project:

```
> mvn clean install -f super-heroes/extension-version
> mvn clean install -Pcomplete
```

#### Ready?

After the prerequisites have been installed and the different components have been warmed up, it’s now time to write some code!

## Creating a *classical* REST/HTTP Microservice

* * *

At the heart of the Super-Hero application comes Villains! You can’t have superheroes without super-villains.

We need to expose a REST API allowing CRUD operations on villains. This microservice is, let’s say, a *classical* REST microservice. It uses HTTP to expose a REST API and internally store data into a database. It’s using the *imperative* development model.

The *fight* microservice will use this service.

<img width="300" height="229" src=":/8763cfb0422d4e26b4db1906b916872d"/>

In the following sections, you learn:

- How to create a new Quarkus application

- How to implement REST API using JAX-RS and the RESTEasy Reactive extension<sup>\[<a id="_footnoteref_14"></a>[14](#_footnotedef_14 "View footnote.")\]</sup>

- How to compose your application using beans

- How to access your database using Hibernate ORM with Panache

- How to use transactions

- How to enable OpenAPI and Swagger-UI


|     |     |
| --- | --- |
|     | This service is exposed on the port 8084. |

But first, let’s describe our service. The Super-Villains microservice manages villains with their names, powers, and so on. The REST API allows adding, removing, listing, and picking a random villain from the stored set. Nothing outstanding but a good first step to discover Quarkus.

### Villain Microservice

First thing first, we need a project. That’s what you are going to see in this section.

#### Bootstrapping the Villain REST Endpoint

The easiest way to create a new Quarkus project is to use the Quarkus Maven plugin. Open a terminal and run the following command:

Call to action

```
cd quarkus-workshop-super-heroes/super-heroes

mvn io.quarkus:quarkus-maven-plugin:2.9.2.Final:create \
    -DprojectGroupId=io.quarkus.workshop.super-heroes \
    -DprojectArtifactId=rest-villains \
    -DclassName="io.quarkus.workshop.superheroes.villain.VillainResource" \
    -Dpath="api/villains" \
    -Dextensions="resteasy-reactive-jackson"
```

The last line selects the extension we want to use. As a start, we only select `resteasy-reactive-jackson`, which will also import `resteasy-reactive`.

If you want your IDE to manage this new Maven project, you can declare it in the parent POM by adding this new module in the `<modules>` section:

```
<module>super-heroes/rest-villains</module>
```

|     |     |
| --- | --- |
|     | Preferring Web UI<br><br>Instead of the Maven command, you can use https://code.quarkus.io and select the `resteasy-reactive-jackson` extension. |

#### Directory Structure

Once you bootstrap the project, you get the following directory structure with a few Java classes and other artifacts :

![Diagram](:/a1c52aeea9ef46499909116912ddf18f)

The Maven archetype generates the following `rest-villains` sub-directory:

- The Maven structure with a `pom.xml`

- An `io.quarkus.workshop.superheroes.villain.VillainResource` resource exposed on `/api/villains`

- An associated unit test `VillainResourceTest`

- The landing page `index.html` that is accessible on http://localhost:8080 after starting the application

- Example `Dockerfile` files for both native and JVM modes in `src/main/docker`

- The `application.properties` configuration file


Once generated, look at the `pom.xml`. You will find the import of the Quarkus BOM, allowing you to omit the version on the different Quarkus dependencies. In addition, you can see the `quarkus-maven-plugin` responsible for the packaging of the application and providing the development mode.

```
<project>
  <!-- ... -->
  <properties>
    <compiler-plugin.version>3.8.1</compiler-plugin.version>
    <maven.compiler.parameters>true</maven.compiler.parameters>
    <maven.compiler.source>11</maven.compiler.source>
    <maven.compiler.target>11</maven.compiler.target>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
    <quarkus.platform.artifact-id>quarkus-bom</quarkus.platform.artifact-id>
    <quarkus.platform.group-id>io.quarkus.platform</quarkus.platform.group-id>
    <quarkus.platform.version>2.9.2.Final</quarkus.platform.version>
    <surefire-plugin.version>3.0.0-M5</surefire-plugin.version>
  </properties>
  <!-- ... -->
  <dependencyManagement>
    <dependencies>
      <dependency>
        <groupId>${quarkus.platform.group-id}</groupId>
        <artifactId>${quarkus.platform.artifact-id}</artifactId>
        <version>${quarkus.platform.version}</version>
        <type>pom</type>
        <scope>import</scope>
      </dependency>
    </dependencies>
  </dependencyManagement>
 <!-- ... -->
 <build>
    <plugins>
      <plugin>
        <groupId>${quarkus.platform.group-id}</groupId>
        <artifactId>quarkus-maven-plugin</artifactId>
        <version>${quarkus.platform.version}</version>
        <extensions>true</extensions>
        <executions>
          <execution>
            <goals>
              <goal>build</goal>
              <goal>generate-code</goal>
              <goal>generate-code-tests</goal>
            </goals>
          </execution>
        </executions>
      </plugin>
     <!-- ... -->
    </plugins>
  </build>
<!-- ... -->
</project>
```

If we focus on the dependencies section, you can see the extensions allowing the development of REST applications (resteasy-reactive and resteasy-reactive-jackson)

```
<dependencies>
    <dependency>
      <groupId>io.quarkus</groupId>
      <artifactId>quarkus-resteasy-reactive-jackson</artifactId>
    </dependency>
    <dependency>
      <groupId>io.quarkus</groupId>
      <artifactId>quarkus-arc</artifactId>
    </dependency>
    <dependency>
      <groupId>io.quarkus</groupId>
      <artifactId>quarkus-resteasy-reactive</artifactId>
    </dependency>
    <!-- ... -->
</dependencies>
```

`quarkus-arc` is the dependency injection framework integrated into Quarkus. It’s designed to perform build-time injections. We will see later why this is essential for Quarkus.

`resteasy-reactive` is the framework we will use to implement our REST API. It uses JAX-RS annotations such as `@Path`, `@GET`…​ `reasteasy-reactive-jackson` adds JSON object mapping capabilities to RESTEasy reactive.

#### The Villain Resource

During the project creation, the `VillainResource.java` file has been created with the following content:

```
package io.quarkus.workshop.superheroes.villain;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/villains")
public class VillainResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy Reactive";
    }
}
```

It’s a very simple REST endpoint returning "Hello RESTEasy Reactive" to requests on `/api/villains`. It uses JAX-RS annotations:

- `@Path` indicates the HTTP path handled by the resource,

- `@GET` indicates that the method should be called when receiving a `GET` request on `/api/villains`.


|     |     |
| --- | --- |
|     | Method can also have their own `@Path` annotation suffixed to the class one (if any). |

#### Running the Application

Call to action

Now we are ready to run our application.

Use: `./mvnw quarkus:dev` in the `rest-villains` directory:

```
$ ./mvnw quarkus:dev
[INFO] Scanning for projects...
[INFO]
[INFO] -----------< io.quarkus.workshop.super-heroes:rest-villains >-----------
[INFO] Building rest-villains 1.0.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- quarkus-maven-plugin:2.9.2.Final:dev (default-cli) @ rest-villains ---
[INFO] Invoking io.quarkus.platform:quarkus-maven-plugin:2.9.2.Final:generate-code @ rest-villains
[INFO] Invoking org.apache.maven.plugins:maven-resources-plugin:2.6:resources @ rest-villains
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 2 resources
[INFO] Invoking org.apache.maven.plugins:maven-compiler-plugin:3.8.1:compile @ rest-villains
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 1 source file to /Users/clement/Downloads/rest-villains/target/classes
[INFO] Invoking org.apache.maven.plugins:maven-resources-plugin:2.6:testResources @ rest-villains
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /Users/clement/Downloads/rest-villains/src/test/resources
[INFO] Invoking org.apache.maven.plugins:maven-compiler-plugin:3.8.1:testCompile @ rest-villains
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 2 source files to /Users/clement/Downloads/rest-villains/target/test-classes
Listening for transport dt_socket at address: 5005
__  ____  __  _____   ___  __ ____  ______
 --/ __ \/ / / / _ | / _ \/ //_/ / / / __/
 -/ /_/ / /_/ / __ |/ , _/ ,< / /_/ /\ \
--\___\_\____/_/ |_/_/|_/_/|_|\____/___/
2021-09-21 13:29:16,328 INFO  [io.quarkus] (Quarkus Main Thread) rest-villains 1.0.0-SNAPSHOT on JVM (powered by Quarkus 2.9.2.Final) started in 1.553s. Listening on: http://localhost:8080
2021-09-21 13:29:16,332 INFO  [io.quarkus] (Quarkus Main Thread) Profile dev activated. Live Coding activated.
2021-09-21 13:29:16,333 INFO  [io.quarkus] (Quarkus Main Thread) Installed features: [cdi, resteasy-reactive, resteasy-reactive-jackson, smallrye-context-propagation]
```

Then check that the endpoint returns `hello` as expected:

```
curl http://localhost:8080/api/villains

Hello RESTEasy Reactive
```

Alternatively, you can open http://localhost:8080/api/villains in your browser.

#### Development Mode

`quarkus:dev` runs Quarkus in development mode. It enables hot deployment with background compilation, which means that when you modify your Java files or your resource files and invoke a REST endpoint (i.e., cURL command or refresh your browser), these changes will automatically take effect. It works too for resource files like the configuration property and HTML files. Refreshing the browser triggers a scan of the workspace, and if any changes are detected, the Java files are recompiled and the application is redeployed; your request is then serviced by the redeployed application. If there are any issues with compilation or deployment an error page will let you know.

The development mode also allows debugging and listens for a debugger on port 5005. If you want to wait for the debugger to attach before running, you can pass `-Dsuspend=true` on the command line. If you don’t want the debugger at all, you can use `-Ddebug=false`.

Alright, time to change some code. Open your favorite IDE and import the project. To check that the hot reload is working, update the `VillainResource.hello()` method by returning the String "Hello Villain Resource".

Now, execute the cURL command again:

Call to action

```
curl http://localhost:8080/api/villains

Hello Villain Resource
```

The output has changed without you having to stop and restart Quarkus!

#### Testing the Application

All right, so far, so good, but wouldn’t it be better with a few tests, just in case.

In the generated `pom.xml` file, you can see two test dependencies:

```
<dependencies>
    <!-- ... -->
    <dependency>
        <groupId>io.quarkus</groupId>
        <artifactId>quarkus-junit5</artifactId>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>io.rest-assured</groupId>
        <artifactId>rest-assured</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

So, we will use Junit 5 combined with RESTAssured, which eases the testing of REST applications.

If you look at the `maven-surefire-plugin` configuration in the `pom.xml`, you will see that we set the `java.util.logging` system property to ensure tests will use the correct method log manager.

```
<plugin>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>${surefire-plugin.version}</version>
    <configuration>
      <systemPropertyVariables>
        <java.util.logging.manager>org.jboss.logmanager.LogManager</java.util.logging.manager>
        <maven.home>${maven.home}</maven.home>
      </systemPropertyVariables>
    </configuration>
</plugin>
```

The generated project contains a simple test in `VillainResourceTest.java`.

```
package io.quarkus.workshop.superheroes.villain;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class VillainResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/api/villains")
          .then()
             .statusCode(200)
             .body(is("Hello RESTEasy Reactive"));
    }

}
```

By using the `QuarkusTest` runner, the `VillainResourceTest` class instructs JUnit to start the application before the tests. Then, the `testHelloEndpoint` method checks the HTTP response status code and content. Notice that these tests use RestAssured, but feel free to use your favorite library.<sup>\[<a id="_footnoteref_15"></a>[15](#_footnotedef_15 "View footnote.")\]</sup>

|     |     |
| --- | --- |
|     | Quarkus provides a RestAssured integration that updates the default port used by RestAssured before the tests are run. So in your RestAssured tests, you don’t have to specify the default test port 8081 used by Quarkus. You can also configure the ports used by tests by configuring the `quarkus.http.test-port` property in the application.properties. |

Call to action

In the terminal running the application in *dev mode*, you should see at the bottom:

```
--
Tests paused
Press [r] to resume testing, [o] Toggle test output, [h] for more options>
```

Hit the `r` key, and watch Quarkus execute your tests automatically and even continuously. Unfortunately, this first run didn’t end well:

```
Running 1/1. Running: io.quarkus.workshop.superheroes.villain.VillainResourceTest#testHelloEndpoint()
Press [o] Toggle test output, [h] for more options>WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by org.codehaus.groovy.vmplugin.v9.Java9 (file:/Users/clement/.m2/repository/org/codehaus/groovy/groovy/3.0.8/groovy-3.0.8.jar) to constructor java.lang.AssertionError(java.lang.String)
2021-09-21 13:39:19,710 ERROR [io.qua.test] (Test runner thread) ==================== TEST REPORT #1 ====================
2021-09-21 13:39:19,711 ERROR [io.qua.test] (Test runner thread) Test VillainResourceTest#testHelloEndpoint() failed
: java.lang.AssertionError: 1 expectation failed.
Response body doesn't match expectation.
Expected: is "Hello RESTEasy Reactive"
  Actual: Hello Villain Resource

   at io.restassured.internal.ValidatableResponseImpl.body(ValidatableResponseImpl.groovy)
   at io.quarkus.workshop.superheroes.villain.VillainResourceTest.testHelloEndpoint(VillainResourceTest.java:18)

2021-09-21 13:39:19,714 ERROR [io.qua.test] (Test runner thread) >>>>>>>>>>>>>>>>>>>> 1 TEST FAILED <<<<<<<<<<<<<<<<<<<<
2021-09-21 13:39:20,030 ERROR [io.qua.test] (Test runner thread) ==================== TEST REPORT #2 ====================
2021-09-21 13:39:20,030 ERROR [io.qua.test] (Test runner thread) Test VillainResourceTest#testHelloEndpoint() failed
: java.lang.AssertionError: 1 expectation failed.
Response body doesn't match expectation.
Expected: is "Hello RESTEasy Reactive"
  Actual: Hello Villain Resource

   at io.restassured.internal.ValidatableResponseImpl.body(ValidatableResponseImpl.groovy)
   at io.quarkus.workshop.superheroes.villain.VillainResourceTest.testHelloEndpoint(VillainResourceTest.java:18)

2021-09-21 13:39:20,031 ERROR [io.qua.test] (Test runner thread) >>>>>>>>>>>>>>>>>>>> 1 TEST FAILED <<<<<<<<<<<<<<<<<<<<
```

It fails! It’s expected, you changed the output of `VillainResource.hello()` earlier. Adjust the test body condition accordingly:

```
package io.quarkus.workshop.superheroes.villain;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class VillainResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/api/villains")
          .then()
             .statusCode(200)
             .body(is("Hello Villain Resource"));
    }

}
```

Save the file, and watch the dev mode automatically rerunning your test:

```
2021-09-21 13:40:32,361 INFO  [io.qua.test] (Test runner thread) All tests are now passing
```

Continuous testing is a big part of Quarkus development. Quarkus detects and runs the tests for you.

You can also run the tests from a terminal using:

```
./mvnw test
```

#### Packaging and Running the Application

Call to action

The application is packaged using the `./mvnw package` command (it also runs the tests). That command generates:

- `target/rest-villains-1.0-SNAPSHOT.jar`: containing just the classes and resources of the projects, it’s the regular artifact produced by the Maven build (it is not an executable jar);

- `target/quarkus-app/` : this directory uses the *fast jar* packaging. It contains an executable jar (`quarkus-run.jar`), and all the dependencies (structured into `app`, `lib` and `quarkus`).


This *fast jar* takes advantage of the build-time principle of Quarkus (we discuss it soon) to improve the application performances and which can be easily transposed to container layers.

Stop the application running in dev mode (by hitting `q` or `CTRL+C`), and run the application using: `java -jar target/quarkus-app/quarkus-run.jar`.

|     |     |
| --- | --- |
|     | Before running the application, don’t forget to stop the hot reload mode (hit CTRL+C), or you will have a port conflict. |

|     |     |
| --- | --- |
|     | Troubleshooting<br><br>You might come across the following error while developing:<br><br>```<br>WARN  [io.qu.ne.ru.NettyRecorder] (Thread-48) Localhost lookup took more than one second; you need to add a /etc/hosts entry to improve Quarkus startup time. See https://thoeni.io/post/macos-sierra-java/ for details.<br>```<br><br>If this is the case, it’s just a matter of adding the node name of your machine to the /etc/hosts. For that, first, get the name of your node with the following command:<br><br>```<br>$ uname -n<br>my-node.local<br>```<br><br>Then `sudo vi /etc/hosts` so you have the right to edit the file and add the following entry:<br><br>```<br>127.0.0.1 localhost my-node.local<br>``` |

In another terminal, check that the application runs using:

```
curl http://localhost:8080/api/villains
Hello Villain Resource
```

### Transactions and ORM

The Villain API’s role is to allow CRUD operations on Super Villains. In this module we will create a Villain entity and persist/update/delete/retrieve it from a PostgreSQL database in a transactional way.

This microservice uses an imperative/classic execution model. Interactions with the database will uses Hibernate ORM and will block until the responses from the database are retrieved.

#### Directory Structure

In this module we will add extra classes to the Villain API project. You will end-up with the following directory structure:

![Diagram](:/b3fda0548cb14ca2adbccc112ee22f75)

#### Installing the PostgreSQL Dependency, Hibernate with Panache and Hibernate Validator

This microservice:

- Interacts with a PostGreSQL database - so it needs a driver

- Uses Hibernate with Panache - needs the extension providing it

- Validates payloads and entities - needs a validator

- Consumes and produces JSON - needs a JSON mapper


Hibernate ORM is the de-facto JPA implementation and offers you the full breadth of an Object Relational Mapper. It makes complex mappings possible, but it does not make simple and common mappings trivial. Hibernate ORM with Panache focuses on making your entities trivial and fun to write in Quarkus.<sup>\[<a id="_footnoteref_16"></a>[16](#_footnotedef_16 "View footnote.")\]</sup>

Because JPA and Bean Validation work well together, we will use Bean Validation to constrain our business model.

To add the required dependencies, just run the following command:

Call to action

```
./mvnw quarkus:add-extension -Dextensions="jdbc-postgresql,hibernate-orm-panache,hibernate-validator"
```

|     |     |
| --- | --- |
|     | No need to add an extension for JSON, we already included `resteasy-reactive-jackson`. |

This will add the following dependencies in the `pom.xml` file:

```
<dependencies>
    <!-- ... -->
    <dependency>
      <groupId>io.quarkus</groupId>
      <artifactId>quarkus-hibernate-orm-panache</artifactId>
    </dependency>
    <dependency>
      <groupId>io.quarkus</groupId>
      <artifactId>quarkus-hibernate-validator</artifactId>
    </dependency>
    <dependency>
      <groupId>io.quarkus</groupId>
      <artifactId>quarkus-jdbc-postgresql</artifactId>
    </dependency>
    <!-- ... -->
</dependencies>
```

From now on, you can choose to either edit your pom directly or use the `quarkus:add-extension` command.

#### Villain Entity

Call to action

To define a Panache entity, simply extend `PanacheEntity`, annotate it with `@Entity` and add your columns as public fields (no need to have getters and setters). The `Villain` entity should look like this:

```
package io.quarkus.workshop.superheroes.villain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Villain extends PanacheEntity {

    @NotNull
    @Size(min = 3, max = 50)
    public String name;

    public String otherName;

    @NotNull
    @Min(1)
    public int level;
    public String picture;

    @Column(columnDefinition = "TEXT")
    public String powers;

    @Override
    public String toString() {
        return "Villain{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", otherName='" + otherName + '\'' +
            ", level=" + level +
            ", picture='" + picture + '\'' +
            ", powers='" + powers + '\'' +
            '}';
    }
}
```

Notice that you can put all your JPA column annotations and Bean Validation constraint annotations on the public fields.

##### Adding Operations

Thanks to Panache, once you have written the `Villain` entity, here are the most common operations you will be able to do:

```
// creating a hero
Villain villain = new Villain();
villain.name = "Lex Luthor";
villain.level = 9;

// persist it
villain.persist();

// getting a list of all Villain entities
List<Villain> villains = Villain.listAll();

// finding a specific villain by ID
villain = Villain.findById(id);

// counting all villains
long countAll = Villain.count();
```

But we are missing a business method: we need to return a random villain.

Call to action

For that it’s just a matter to add the following method to our `Villain.java` entity:

```
public static Villain findRandom() {
    long countVillains = count();
    Random random = new Random();
    int randomVillain = random.nextInt((int) countVillains);
    return findAll().page(randomVillain, 1).firstResult();
}
```

|     |     |
| --- | --- |
|     | You would need to add the following import statement if not done automatically by your IDE `import java.util.Random;` |

Picking a random villain is achieved as follows:

1.  Gets the number of villains stored in the database (`count()`)

2.  Picks a random number between 0 and `count()`

3.  Asks Hibernate with Panache to find all villains in a paginated way and return the random page containing 1 villain.


#### Configuring Hibernate

Quarkus development mode is really useful for applications that mix front end or services and database access. We use `quarkus.hibernate-orm.database.generation=drop-and-create` in conjunction with `import.sql` so every change to your app and in particular to your entities, the database schema will be properly recreated and your data (stored in `import.sql`) will be used to repopulate it from scratch. This is best to perfectly control your environment and works magic with Quarkus live reload mode: your entity changes or any change to your `import.sql` is immediately picked up and the schema updated without restarting the application!

Call to action

For that, make sure to have the following configuration in your `application.properties` (located in `src/main/resources`):

```
# drop and create the database at startup (use `update` to only update the schema)
quarkus.hibernate-orm.database.generation=drop-and-create
```

#### Villain Service

To manipulate the `Villain` entity we will develop a transactional `VillainService` class. The idea is to wrap methods modifying the database (e.g. `entity.persist()`) within a transaction. Marking a CDI bean method `@Transactional` will do that for you and make that method a transaction boundary.

`@Transactional` can be used to control transaction boundaries on any bean at the method level or at the class level to ensure every method is transactional. You can control whether and how the transaction is started with parameters on `@Transactional`:

- `@Transactional(REQUIRED)` (default): starts a transaction if none was started, stays with the existing one otherwise.

- `@Transactional(REQUIRES_NEW)`: starts a transaction if none was started ; if an existing one was started, suspends it and starts a new one for the boundary of that method.

- `@Transactional(MANDATORY)`: fails if no transaction was started ; works within the existing transaction otherwise.

- `@Transactional(SUPPORTS)`: if a transaction was started, joins it ; otherwise works with no transaction.

- `@Transactional(NOT_SUPPORTED)`: if a transaction was started, suspends it and works with no transaction for the boundary of the method ; otherwise works with no transaction.

- `@Transactional(NEVER)`: if a transaction was started, raises an exception ; otherwise works with no transaction.


Call to action

Creates a new `VillainService.java` file in the same package with the following content:

```
package io.quarkus.workshop.superheroes.villain;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

@ApplicationScoped
@Transactional(REQUIRED)
public class VillainService {

    @Transactional(SUPPORTS)
    public List<Villain> findAllVillains() {
        return Villain.listAll();
    }

    @Transactional(SUPPORTS)
    public Villain findVillainById(Long id) {
        return Villain.findById(id);
    }

    @Transactional(SUPPORTS)
    public Villain findRandomVillain() {
        Villain randomVillain = null;
        while (randomVillain == null) {
            randomVillain = Villain.findRandom();
        }
        return randomVillain;
    }

    public Villain persistVillain(@Valid Villain villain) {
        villain.persist();
        return villain;
    }

    public Villain updateVillain(@Valid Villain villain) {
        Villain entity = Villain.findById(villain.id);
        entity.name = villain.name;
        entity.otherName = villain.otherName;
        entity.level = villain.level;
        entity.picture = villain.picture;
        entity.powers = villain.powers;
        return entity;
    }

    public void deleteVillain(Long id) {
        Villain villain = Villain.findById(id);
        villain.delete();
    }
}
```

The `@ApplicationScoped` annotation declares a *bean*. The other component of the application can access this bean. Arc, the dependency injection framework integrated in Quarkus, handles the creation and the access to this class.

Notice that both methods that persist and update a villain, pass a `Villain` object as a parameter. Thanks to the Bean Validation’s `@Valid` annotation, the `Villain` object will be checked to see if it’s valid or not. If it’s not, the transaction will be rolled back.

#### Accessing a database in dev mode

Our project now requires a connection to a PostgreSQL database. In dev mode, no need to start a database or configure anything. Quarkus does that for us.

Call to action

Start the application in dev mode with `./mvnw quarkus:dev`. In the log, you will see the following:

```
2021-09-21 15:58:44,640 INFO  [org.tes.doc.DockerClientProviderStrategy] (build-38) Loaded org.testcontainers.dockerclient.UnixSocketClientProviderStrategy from ~/.testcontainers.properties, will try it first
2021-09-21 15:58:45,068 INFO  [org.tes.doc.DockerClientProviderStrategy] (build-38) Found Docker environment with local Unix socket (unix:///var/run/docker.sock)
2021-09-21 15:58:45,070 INFO  [org.tes.DockerClientFactory] (build-38) Docker host IP address is localhost
2021-09-21 15:58:45,116 INFO  [org.tes.DockerClientFactory] (build-38) Connected to docker:
  Server Version: 20.10.8
  API Version: 1.41
  Operating System: Docker Desktop
  Total Memory: 5943 MB
2021-09-21 15:58:45,118 INFO  [org.tes.uti.ImageNameSubstitutor] (build-38) Image name substitution will be performed by: DefaultImageNameSubstitutor (composite of 'ConfigurationFileImageNameSubstitutor' and 'PrefixingImageNameSubstitutor')
2021-09-21 15:58:45,453 INFO  [org.tes.uti.RegistryAuthLocator] (build-38) Credential helper/store (docker-credential-desktop) does not have credentials for index.docker.io
2021-09-21 15:58:45,957 INFO  [org.tes.DockerClientFactory] (build-38) Ryuk started - will monitor and terminate Testcontainers containers on JVM exit
2021-09-21 15:58:45,958 INFO  [org.tes.DockerClientFactory] (build-38) Checking the system...
2021-09-21 15:58:45,958 INFO  [org.tes.DockerClientFactory] (build-38) ✔︎ Docker server version should be at least 1.6.0
2021-09-21 15:58:46,083 INFO  [org.tes.DockerClientFactory] (build-38) ✔︎ Docker environment should have more than 2GB free disk space
2021-09-21 15:58:46,143 INFO  [🐳 .2]] (build-38) Creating container for image: postgres:13.2
2021-09-21 15:58:46,217 INFO  [🐳 .2]] (build-38) Starting container with ID: a7fd54795185ab17baf487388c1e3280fdfea3f6ef8670c0336d367dba3e1d9e
2021-09-21 15:58:46,545 INFO  [🐳 .2]] (build-38) Container postgres:13.2 is starting: a7fd54795185ab17baf487388c1e3280fdfea3f6ef8670c0336d367dba3e1d9e
2021-09-21 15:58:48,043 INFO  [🐳 .2]] (build-38) Container postgres:13.2 started in PT1.959377S
2021-09-21 15:58:48,044 INFO  [io.qua.dev.pos.dep.PostgresqlDevServicesProcessor] (build-38) Dev Services for PostgreSQL started.
```

Quarkus detects the need for a database and starts one using a Docker container. It automatically configures the application, which means we are good to go and implement our REST API.

|     |     |
| --- | --- |
|     | If the application fails to start properly and the logs contain something like<br><br>```<br>WARN  [or.te.ut.RyukResourceReaper] (testcontainers-ryuk) Can not connect to Ryuk at localhost:49153: java.net.ConnectException: Connection refused (Connection refused)<br>```<br><br>try launching the application again after having the `TESTCONTAINERS_RYUK_DISABLED` environment variable to `true`. This setting will likely also be needed **throughout** the workshop. |

#### VillainResource Endpoint

The `VillainResource` was bootstrapped with only one method `hello()`. We need to add extra methods that will allow CRUD operations on villains.

Call to action

Here are the new methods to add to the `VillainResource` class:

```
package io.quarkus.workshop.superheroes.villain;

import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.RestPath;

import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.util.List;

import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

@Path("/api/villains")
public class VillainResource {

    Logger logger;
    VillainService service;

    public VillainResource(Logger logger, VillainService service) {
        this.service = service;
        this.logger = logger;
    }

    @GET
    @Path("/random")
    public Response getRandomVillain() {
        Villain villain = service.findRandomVillain();
        logger.debug("Found random villain " + villain);
        return Response.ok(villain).build();
    }

    @GET
    public Response getAllVillains() {
        List<Villain> villains = service.findAllVillains();
        logger.debug("Total number of villains " + villains);
        return Response.ok(villains).build();
    }

    @GET
    @Path("/{id}")
    public Response getVillain(@RestPath Long id) {
        Villain villain = service.findVillainById(id);
        if (villain != null) {
            logger.debug("Found villain " + villain);
            return Response.ok(villain).build();
        } else {
            logger.debug("No villain found with id " + id);
            return Response.noContent().build();
        }
    }

    @POST
    public Response createVillain(@Valid Villain villain, @Context UriInfo uriInfo) {
        villain = service.persistVillain(villain);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(Long.toString(villain.id));
        logger.debug("New villain created with URI " + builder.build().toString());
        return Response.created(builder.build()).build();
    }

    @PUT
    public Response updateVillain(@Valid Villain villain) {
        villain = service.updateVillain(villain);
        logger.debug("Villain updated with new valued " + villain);
        return Response.ok(villain).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteVillain(@RestPath Long id) {
        service.deleteVillain(id);
        logger.debug("Villain deleted with " + id);
        return Response.noContent().build();
    }

    @GET
    @Path("/hello")
    @Produces(TEXT_PLAIN)
    public String hello() {
        return "Hello Villain Resource";
    }
}
```

Not that we added `@Path("/hello")` to the `hello` method to not conflict with the `getAllVillains()` method.

#### Dependency Injection

Dependency injection in Quarkus is based on ArC which is a CDI-based dependency injection solution tailored for Quarkus' architecture.<sup>\[<a id="_footnoteref_17"></a>[17](#_footnotedef_17 "View footnote.")\]</sup> You can learn more about it in the Contexts and Dependency Injection guide.<sup>\[<a id="_footnoteref_18"></a>[18](#_footnotedef_18 "View footnote.")\]</sup>

ArC handles injection at build time. You can use field injection and inject the `VillainService` and the logger using:

```
@Inject Logger logger;
@Inject VillainService service;
```

But in your previous class, we used constructor injection. Both the `VillainService` and the `Logger` are injected as constructor parameter:

```
public VillainResource(Logger logger, VillainService service) {
    this.service = service;
    this.logger = logger;
}
```

#### Adding Data

Call to action

To load some SQL statements when Hibernate ORM starts, add the following `import.sql` in the root of the `resources` directory. It contains SQL statements terminated by a semicolon. This is useful to have a data set ready for the tests or demos.

```
INSERT INTO villain(id, name, otherName, picture, powers, level)
VALUES (nextval('hibernate_sequence'), 'Buuccolo', 'Majin Buu', 'https://www.superherodb.com/pictures2/portraits/11/050/15355.jpg', 'Accelerated Healing, Adaptation, Agility, Flight, Immortality, Intelligence, Invulnerability, Reflexes, Self-Sustenance, Size Changing, Spatial Awareness, Stamina, Stealth, Super Breath, Super Speed, Super Strength, Teleportation', 22);
INSERT INTO villain(id, name, otherName, picture, powers, level)
VALUES (nextval('hibernate_sequence'), 'Darth Vader', 'Anakin Skywalker', 'https://www.superherodb.com/pictures2/portraits/10/050/10444.jpg', 'Accelerated Healing, Agility, Astral Projection, Cloaking, Danger Sense, Durability, Electrokinesis, Energy Blasts, Enhanced Hearing, Enhanced Senses, Force Fields, Hypnokinesis, Illusions, Intelligence, Jump, Light Control, Marksmanship, Precognition, Psionic Powers, Reflexes, Stealth, Super Speed, Telekinesis, Telepathy, The Force, Weapons Master', 13);
INSERT INTO villain(id, name, otherName, picture, powers, level)
VALUES (nextval('hibernate_sequence'), 'The Rival (CW)', 'Edward Clariss', 'https://www.superherodb.com/pictures2/portraits/11/050/13846.jpg', 'Accelerated Healing, Agility, Bullet Time, Durability, Electrokinesis, Endurance, Enhanced Senses, Intangibility, Marksmanship, Phasing, Reflexes, Speed Force, Stamina, Super Speed, Super Strength', 10);
```

Ok, but that’s just a few entries. Download the SQL file [import.sql](https://raw.githubusercontent.com/quarkusio/quarkus-workshops/main/quarkus-workshop-super-heroes/super-heroes/rest-villains/src/main/resources/import.sql) and copy it under `src/main/resources`. Now, you have more than 500 villains that will be loaded in the database.

If you didn’t yet, start the application in dev mode:

```
./mvnw quarkus:dev
```

Then, open your browser to http://localhost:8080/api/villains. You should see lots of heroes…​

#### CRUD Tests in VillainResourceTest

To test the `VillainResource` endpoint, we just need to extend the `VillainResourceTest` we already have. No need to configure anything, Quarkus will start a test database for you.

Call to action

In `io.quarkus.workshop.superheroes.villain.VillainResourceTest`, you will add the following test methods to the `VillainResourceTest` class:

- `shouldNotGetUnknownVillain`: giving a random Villain identifier, the `VillainResource` endpoint should return a 204 (No content)

- `shouldGetRandomVillain`: checks that the `VillainResource` endpoint returns a random villain

- `shouldNotAddInvalidItem`: passing an invalid `Villain` should fail when creating it (thanks to the `@Valid` annotation)

- `shouldGetInitialItems`: checks that the `VillainResource` endpoint returns the list of heroes

- `shouldAddAnItem`: checks that the `VillainResource` endpoint creates a valid `Villain`

- `shouldUpdateAnItem`: checks that the `VillainResource` endpoint updates a newly created `Villain`

- `shouldRemoveAnItem`: checks that the `VillainResource` endpoint deletes a villain from the database


The code is as follows:

```
package io.quarkus.workshop.superheroes.villain;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.common.mapper.TypeRef;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.HttpHeaders.ACCEPT;
import static javax.ws.rs.core.HttpHeaders.CONTENT_TYPE;
import static javax.ws.rs.core.Response.Status.*;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class VillainResourceTest {

    private static final String JSON = "application/json;charset=UTF-8";

    private static final String DEFAULT_NAME = "Super Chocolatine";
    private static final String UPDATED_NAME = "Super Chocolatine (updated)";
    private static final String DEFAULT_OTHER_NAME = "Super Chocolatine chocolate in";
    private static final String UPDATED_OTHER_NAME = "Super Chocolatine chocolate in (updated)";
    private static final String DEFAULT_PICTURE = "super_chocolatine.png";
    private static final String UPDATED_PICTURE = "super_chocolatine_updated.png";
    private static final String DEFAULT_POWERS = "does not eat pain au chocolat";
    private static final String UPDATED_POWERS = "does not eat pain au chocolat (updated)";
    private static final int DEFAULT_LEVEL = 42;
    private static final int UPDATED_LEVEL = 43;

    private static final int NB_VILLAINS = 581;
    private static String villainId;

    @Test
    public void testHelloEndpoint() {
        given()
            .when().get("/api/villains/hello")
            .then()
            .statusCode(200)
            .body(is("Hello Villain Resource"));
    }

    @Test
    void shouldNotGetUnknownVillain() {
        Long randomId = new Random().nextLong();
        given()
            .pathParam("id", randomId)
            .when().get("/api/villains/{id}")
            .then()
            .statusCode(NO_CONTENT.getStatusCode());
    }

    @Test
    void shouldGetRandomVillain() {
        given()
            .when().get("/api/villains/random")
            .then()
            .statusCode(OK.getStatusCode())
            .contentType(APPLICATION_JSON);
    }

    @Test
    void shouldNotAddInvalidItem() {
        Villain villain = new Villain();
        villain.name = null;
        villain.otherName = DEFAULT_OTHER_NAME;
        villain.picture = DEFAULT_PICTURE;
        villain.powers = DEFAULT_POWERS;
        villain.level = 0;

        given()
            .body(villain)
            .header(CONTENT_TYPE, JSON)
            .header(ACCEPT, JSON)
            .when()
            .post("/api/villains")
            .then()
            .statusCode(BAD_REQUEST.getStatusCode());
    }

    @Test
    @Order(1)
    void shouldGetInitialItems() {
        List<Villain> villains = get("/api/villains").then()
            .statusCode(OK.getStatusCode())
            .contentType(APPLICATION_JSON)
            .extract().body().as(getVillainTypeRef());
        assertEquals(NB_VILLAINS, villains.size());
    }

    @Test
    @Order(2)
    void shouldAddAnItem() {
        Villain villain = new Villain();
        villain.name = DEFAULT_NAME;
        villain.otherName = DEFAULT_OTHER_NAME;
        villain.picture = DEFAULT_PICTURE;
        villain.powers = DEFAULT_POWERS;
        villain.level = DEFAULT_LEVEL;

        String location = given()
            .body(villain)
            .header(CONTENT_TYPE, JSON)
            .header(ACCEPT, JSON)
            .when()
            .post("/api/villains")
            .then()
            .statusCode(CREATED.getStatusCode())
            .extract().header("Location");
        assertTrue(location.contains("/api/villains"));

        // Stores the id
        String[] segments = location.split("/");
        villainId = segments[segments.length - 1];
        assertNotNull(villainId);

        given()
            .pathParam("id", villainId)
            .when().get("/api/villains/{id}")
            .then()
            .statusCode(OK.getStatusCode())
            .contentType(APPLICATION_JSON)
            .body("name", Is.is(DEFAULT_NAME))
            .body("otherName", Is.is(DEFAULT_OTHER_NAME))
            .body("level", Is.is(DEFAULT_LEVEL))
            .body("picture", Is.is(DEFAULT_PICTURE))
            .body("powers", Is.is(DEFAULT_POWERS));

        List<Villain> villains = get("/api/villains").then()
            .statusCode(OK.getStatusCode())
            .contentType(APPLICATION_JSON)
            .extract().body().as(getVillainTypeRef());
        assertEquals(NB_VILLAINS + 1, villains.size());
    }

    @Test
    @Order(3)
    void testUpdatingAnItem() {
        Villain villain = new Villain();
        villain.id = Long.valueOf(villainId);
        villain.name = UPDATED_NAME;
        villain.otherName = UPDATED_OTHER_NAME;
        villain.picture = UPDATED_PICTURE;
        villain.powers = UPDATED_POWERS;
        villain.level = UPDATED_LEVEL;

        given()
            .body(villain)
            .header(CONTENT_TYPE, JSON)
            .header(ACCEPT, JSON)
            .when()
            .put("/api/villains")
            .then()
            .statusCode(OK.getStatusCode())
            .contentType(APPLICATION_JSON)
            .body("name", Is.is(UPDATED_NAME))
            .body("otherName", Is.is(UPDATED_OTHER_NAME))
            .body("level", Is.is(UPDATED_LEVEL))
            .body("picture", Is.is(UPDATED_PICTURE))
            .body("powers", Is.is(UPDATED_POWERS));

        List<Villain> villains = get("/api/villains").then()
            .statusCode(OK.getStatusCode())
            .contentType(APPLICATION_JSON)
            .extract().body().as(getVillainTypeRef());
        assertEquals(NB_VILLAINS + 1, villains.size());
    }

    @Test
    @Order(4)
    void shouldRemoveAnItem() {
        given()
            .pathParam("id", villainId)
            .when().delete("/api/villains/{id}")
            .then()
            .statusCode(NO_CONTENT.getStatusCode());

        List<Villain> villains = get("/api/villains").then()
            .statusCode(OK.getStatusCode())
            .contentType(APPLICATION_JSON)
            .extract().body().as(getVillainTypeRef());
        assertEquals(NB_VILLAINS, villains.size());
    }

    private TypeRef<List<Villain>> getVillainTypeRef() {
        return new TypeRef<List<Villain>>() {
            // Kept empty on purpose
        };
    }

}
```

The tests and the application runs in the same JVM, meaning that the test can be injected with application *beans*. This feature is very useful to test specific parts of the application. However, in our case, we just execute HTTP requests to check the result.

Call to action

Run the test either in the dev mode or using `./mvnw test`. They should pass.

#### Building production package

Our service is not completely done yet, but let’s run it in *prod* mode.

##### Configuring the application

In *prod* mode, the dev services won’t be used. We need to configure the application to connect to a *real* database.

The main way of obtaining connections to a database is to use a datasource. In Quarkus, the out of the box datasource and connection pooling implementation is Agroal.<sup>\[<a id="_footnoteref_19"></a>[19](#_footnotedef_19 "View footnote.")\]</sup>

So, we need to configure the database access in the `src/main/resources/application.properties` file, but only when the application runs in *prod* mode.

Call to action

Add the following datasource configuration:

```
%prod.quarkus.datasource.username=superbad
%prod.quarkus.datasource.password=superbad
%prod.quarkus.datasource.jdbc.url=jdbc:postgresql://localhost:5432/villains_database
%prod.quarkus.hibernate-orm.sql-load-script=import.sql
```

`%prod` indicates that the property is only used when the application runs with the given profile. We configure the access to the database, and force the data initialization (which would have been disabled by default in *prod* mode).

##### Running the Infrastructure

Before going further, be sure to run the infrastructure. To execute this service, you need a database (and later on we will need Prometheus and Kafka). Let’s use Docker and docker compose to ease the installation of such infrastructure.

You should already have installed the infrastructure into the `infrastructure` directory.

Call to action

Now, just execute `docker compose -f docker-compose.yaml up -d`. You should see a few logs going on and then all the containers get started.

On Linux, use the `docker-compose-linux.yaml`:

Listing 2. On Linux

```
docker compose -f docker-compose-linux.yaml up -d
```

|     |     |
| --- | --- |
|     | During the workshop, just leave all the containers up and running. Then, after the workshop, remember to shut them down using: `docker compose -f docker-compose.yaml down` or `docker compose -f docker-compose-linux.yaml down` on Linux. |

##### Packaging and running the application

Call to action

Stop the dev mode, and run:

```
./mvnw package
```

As previously, you will get your application in `target/quarkus-app`, run it using:

```
java -jar target/quarkus-app/quarkus-run.jar
```

Open your browser to http://localhost:8080/api/villains, and verify it displays the expected content. Once done, stop the application using `CTRL+C`.

### Configuring the Villain Microservice

Hardcoded values in our code are a no go (even if we all did it at some point). In this guide, we learn how to configure our Villain API as well as some parts of Quarkus.

#### Configuring Logging

In the `VillainResource`, we injected a logger. That’s very useful to provide meaningful information about the execution. But you often need to adjust the configuration, such as the log level.

Runtime configuration of logging is done through the normal `application.properties` file:

```
quarkus.log.console.enable=true
quarkus.log.console.format=%d{HH:mm:ss} %-5p [%c{2.}] (%t) %s%e%n
quarkus.log.console.level=INFO
quarkus.log.console.darken=1
```

#### Configuring Quarkus Listening Port

Because we will end-up running several microservices, let’s configure Quarkus so it listens to a different port than 8080: This is quite easy as we just need to add one property in the `application.properties` file:

Call to action

```
## HTTP configuration
quarkus.http.port=8084
```

Changing the port is one of the rare configuration that cannot be done while the application is running.

Call to action

You would need to restart the application to change the port.

Hit `CTRL+C` to stop the application if it still running and restart it with: `./mvnw quarkus:dev`. Then run:

```
curl http://localhost:8084/api/villains | jq
```

#### Injecting Configuration Value

When we persist a new villain, we want to multiply the level by a value that can be configured (to reduce the level, so heroes will win the fights more easily). For this, Quarkus uses MicroProfile Config to inject the configuration in the application.<sup>\[<a id="_footnoteref_20"></a>[20](#_footnotedef_20 "View footnote.")\]</sup> The injection uses the `@ConfigProperty` annotation.

|     |     |
| --- | --- |
|     | When injecting a configured value, you can use `@Inject @ConfigProperty` or just `@ConfigProperty`. The `@Inject` annotation is not necessary for members annotated with `@ConfigProperty`, a behavior which differs from [MicroProfile Config](https://microprofile.io/project/eclipse/microprofile-config). |

Call to action

Edit the `VillainService`, and introduce the following configuration properties:

```
@ConfigProperty(name = "level.multiplier", defaultValue="1.0") double levelMultiplier;
```

|     |     |
| --- | --- |
|     | You may need to add the following import statement if your IDE does not do it automatically: `import org.eclipse.microprofile.config.inject.ConfigProperty;` |

If you do not provide a value for this property, the application startup fails with `javax.enterprise.inject.spi.DeploymentException: No config value of type [int] exists for: level.multiplier`. To avoid having to configure a value, we configure a default one (property `defaultValue`).

Call to action

Now, modify the `VillainService.persistVillain()` method to use the injected properties:

```
public Villain persistVillain(@Valid Villain villain) {
        villain.level = (int) Math.round(villain.level * levelMultiplier);
        villain.persist();
        return villain;
}
```

#### Create the Configuration

By default, Quarkus reads `application.properties`.

Call to action

Edit the `src/main/resources/application.properties` with the following content:

```
level.multiplier=0.5
```

#### Running and Testing the Application

Call to action

If you didn’t already, start the application with `./mvnw quarkus:dev`. Once started, create a new villain with the following cUrl command:

```
curl -X POST -d  '{"level":5, "name":"Super Bad", "powers":"Agility, Longevity"}'  -H "Content-Type: application/json" http://localhost:8084/api/villains -v

< HTTP/1.1 201 Created
< Location: http://localhost:8084/api/villains/582
```

As you can see, we’ve passed a level of 5 to create this new villain. The cURL command returns the location of the newly created villain. Take this URL and do an HTTP GET on it. You will see that the level has been decreased.

```
curl http://localhost:8084/api/villains/582 | jq

{
  "id": 582,
  "level": 3,
  "name": "Super Bad",
  "powers": "Agility, Longevity"
}
```

|     |     |
| --- | --- |
|     | You may not know `jq`. It’s an amazing tool to manipulate JSON in the shell. More info on: https://stedolan.github.io/jq/ |

Hey! Wait a minute! It you enabled continuous testing, Quarkus should have warned you:

```
--
Running 2/8. Running: io.quarkus.workshop.superheroes.villain.VillainResourceTest#shouldAddAnItem()
Press [o] Toggle test output, [h] for more options>WARNING: An illegal reflective access operation has occurred
2021-09-21 21:02:16,067 ERROR [io.qua.test] (Test runner thread) ==================== TEST REPORT #1 ====================
2021-09-21 21:02:16,067 ERROR [io.qua.test] (Test runner thread) Test VillainResourceTest#shouldAddAnItem() failed
: java.lang.AssertionError: 1 expectation failed.
JSON path level doesn't match.
Expected: is <42>
  Actual: <21>

	at io.restassured.internal.ValidatableResponseImpl.body(ValidatableResponseImpl.groovy)
	at io.quarkus.workshop.superheroes.villain.VillainResourceTest.shouldAddAnItem(VillainResourceTest.java:133)

2021-09-21 21:02:16,070 ERROR [io.qua.test] (Test runner thread) >>>>>>>>>>>>>>>>>>>> 1 TEST FAILED <<<<<<<<<<<<<<<<<<<<
```

Tests are failing now! Indeed, they don’t know the multiplier.

|     |     |
| --- | --- |
|     | Press `r` in the dev mode to run the tests. |

Call to action

In the `application.properties` file, add: `%test.level.multiplier=1` which set the multiplier to 1 when running the tests:

```
All 8 tests are passing (0 skipped), 8 tests were run in 1722ms. Tests completed at 21:03:25.
```

### Open API

A Quarkus application can expose its API description through an OpenAPI specification. Quarkus also lets you test it via a user-friendly UI named Swagger UI.

In this section, we will see how to use OpenAPI with Quarkus and introduce the dev console.

#### Directory Structure

In this module we will add extra class (`VillainApplication`) to the Villain API project. You will end-up with the following directory structure:

![Diagram](:/6ac5f9ff85504da3b346e90970fafe7c)

#### Installing the OpenAPI extension

Quarkus proposes a `smallrye-openapi` extension compliant with the MicroProfile OpenAPI specification in order to generate your API OpenAPI v3 specification.<sup>\[<a id="_footnoteref_21"></a>[21](#_footnotedef_21 "View footnote.")\]</sup>

Call to action

To install the OpenAPI dependency, just run the following command:

```
./mvnw quarkus:add-extension -Dextensions="smallrye-openapi"
```

This will add the following dependency in the `pom.xml` file:

```
<dependency>
  <groupId>io.quarkus</groupId>
  <artifactId>quarkus-smallrye-openapi</artifactId>
</dependency>
```

#### Open API

Now, you *curl* `http://localhost:8084/q/openapi` endpoint:

```
curl http://localhost:8084/q/openapi

---
openapi: 3.0.3
info:
  title: rest-villains API
  version: 1.0.0-SNAPSHOT
paths:
  /api/villains:
    get:
      responses:
        "200":
          description: OK
    put:
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/Villain'
      responses:
        "200":
          description: OK
    post:
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/Villain'
      responses:
        "200":
          description: OK
  /api/villains/hello:
    get:
      responses:
        "200":
          description: OK
          content:
            application/json:
              schema:
                type: string
  /api/villains/random:
    get:
      responses:
        "200":
          description: OK
  /api/villains/{id}:
    get:
      parameters:
      - name: id
        in: path
        required: true
        schema:
          format: int64
          type: integer
      responses:
        "200":
          description: OK
    delete:
      parameters:
      - name: id
        in: path
        required: true
        schema:
          format: int64
          type: integer
      responses:
        "200":
          description: OK
components:
  schemas:
    Villain:
      required:
      - level
      - name
      type: object
      properties:
        id:
          format: int64
          type: integer
        level:
          format: int32
          minimum: 1
          type: integer
          nullable: false
        name:
          maxLength: 50
          minLength: 3
          type: string
          nullable: false
        otherName:
          type: string
        picture:
          type: string
        powers:
          type: string
```

This contract lacks of documentation. The Eclipse MicroProfile OpenAPI allows you to customize the methods of your REST endpoint as well as the application.

Call to action

While having the OpenAPI specification is great, it can’t be consumed easily by humans. In your browser, go to http://localhost:8084/q/dev. This is the dev console. It provides all the tools you need to develop your Quarkus application. We will use it several times in this workshop. Note that the dev console is only available in dev mode.

The Dev Console integrates Swagger, a UI to invoke your endpoints from the comfort of your browser. Click on the "*Swagger UI*" button located in the "SmallRye OpenAPI" widget (http://localhost:8084/q/swagger-ui).

You will see all your endpoints listed. Click on the "*GET*" button for the "/api/villains" path, then click on "*Try it out*" and finally on "Execute". You can see the result immediately.

When developing REST APIs, this UI is very convenient. You can test your endpoint and immediately see the outcome. If something does not please you, edit the code, go back to the browser, re-execute, and voilà!

##### Customizing Methods

Call to action

The MicroProfile OpenAPI has a set of annotations to customize each REST endpoint method so the OpenAPI contract is richer and clearer for consumers:

- `@Operation`: Describes a single API operation on a path.

- `@APIResponse`: Corresponds to the OpenAPI Response model object which describes a single response from an API Operation

- `@Parameter`: The name of the parameter.

- `@RequestBody`: A brief description of the request body.


This is what the `VillainResource` endpoint looks like once annotated:

```
package io.quarkus.workshop.superheroes.villain;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.RestPath;

import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import java.net.URI;
import java.util.List;

import static javax.ws.rs.core.MediaType.*;

@Path("/api/villains")
@Tag(name="villains")
public class VillainResource {

    Logger logger;
    VillainService service;

    public VillainResource(Logger logger, VillainService service) {
        this.service = service;
        this.logger = logger;
    }

    @Operation(summary = "Returns a random villain")
    @GET
    @Path("/random")
    @APIResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Villain.class, required = true)))
    public Response getRandomVillain() {
        Villain villain = service.findRandomVillain();
        logger.debug("Found random villain " + villain);
        return Response.ok(villain).build();
    }

    @Operation(summary = "Returns all the villains from the database")
    @GET
    @APIResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Villain.class, type = SchemaType.ARRAY)))
    @APIResponse(responseCode = "204", description = "No villains")
    public Response getAllVillains() {
        List<Villain> villains = service.findAllVillains();
        logger.debug("Total number of villains " + villains);
        return Response.ok(villains).build();
    }

    @Operation(summary = "Returns a villain for a given identifier")
    @GET
    @Path("/{id}")
    @APIResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Villain.class)))
    @APIResponse(responseCode = "204", description = "The villain is not found for a given identifier")
    public Response getVillain(@RestPath Long id) {
        Villain villain = service.findVillainById(id);
        if (villain != null) {
            logger.debug("Found villain " + villain);
            return Response.ok(villain).build();
        } else {
            logger.debug("No villain found with id " + id);
            return Response.noContent().build();
        }
    }

    @Operation(summary = "Creates a valid villain")
    @POST
    @APIResponse(responseCode = "201", description = "The URI of the created villain", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = URI.class)))
    public Response createVillain(@Valid Villain villain, @Context UriInfo uriInfo) {
        villain = service.persistVillain(villain);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(Long.toString(villain.id));
        logger.debug("New villain created with URI " + builder.build().toString());
        return Response.created(builder.build()).build();
    }

    @Operation(summary = "Updates an exiting  villain")
    @PUT
    @APIResponse(responseCode = "200", description = "The updated villain", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Villain.class)))
    public Response updateVillain(@Valid Villain villain) {
        villain = service.updateVillain(villain);
        logger.debug("Villain updated with new valued " + villain);
        return Response.ok(villain).build();
    }

    @Operation(summary = "Deletes an exiting villain")
    @DELETE
    @Path("/{id}")
    @APIResponse(responseCode = "204")
    public Response deleteVillain(@RestPath Long id) {
        service.deleteVillain(id);
        logger.debug("Villain deleted with " + id);
        return Response.noContent().build();
    }

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    @Tag(name="hello")
    public String hello() {
        return "Hello Villain Resource";
    }
}
```

With this new code, go back to the Swagger UI at http://localhost:8084/q/swagger-ui and refresh. Your endpoints are organized by tags, and each annotated endpoint is documented.

Documenting REST API is essential when working with different teams. You can see OpenAPI as the JavaDoc for REST.

##### Customizing the Application

The previous annotations allow you to customize the contract for a given REST Endpoint. But it’s also important to document the entire application.

The Microprofile OpenAPI also has a set of annotation to do so. The difference is that these annotations cannot be used on the endpoint methods, but instead on another Java class configuring the entire application.

Call to action

For this, you need to create the `src/main/java/io/quarkus/workshop/superheroes/villain/VillainApplication` class with the following content:

```
package io.quarkus.workshop.superheroes.villain;

import org.eclipse.microprofile.openapi.annotations.ExternalDocumentation;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.servers.Server;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
@OpenAPIDefinition(
    info = @Info(title = "Villain API",
        description = "This API allows CRUD operations on a villain",
        version = "1.0",
        contact = @Contact(name = "Quarkus", url = "https://github.com/quarkusio")),
    servers = {
        @Server(url = "http://localhost:8084")
    },
    externalDocs = @ExternalDocumentation(url = "https://github.com/quarkusio/quarkus-workshops", description = "All the Quarkus workshops")
)
public class VillainApplication extends Application {
    // Empty body
}
```

Go back to the Swagger UI and refresh again. At the top of the document, you can see the version and the global API documentation.

##### Customized Contract

Call to action

If you go back to the `http://localhost:8084/q/openapi` endpoint you will see the following OpenAPI contract:

```
---
openapi: 3.0.3
info:
  title: Villain API
  description: This API allows CRUD operations on a villain
  contact:
    name: Quarkus
    url: https://github.com/quarkusio
  version: "1.0"
externalDocs:
  description: All the Quarkus workshops
  url: https://github.com/quarkusio/quarkus-workshops
servers:
- url: http://localhost:8084
tags:
- name: hello
- name: villains
paths:
  /api/villains:
    get:
      tags:
      - villains
      summary: Returns all the villains from the database
      responses:
        "200":
          description: OK
          content:
            application/json:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/Villain'
        "204":
          description: No villains
    put:
      tags:
      - villains
      summary: Updates an exiting  villain
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/Villain'
      responses:
        "200":
          description: The updated villain
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Villain'
    post:
      tags:
      - villains
      summary: Creates a valid villain
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/Villain'
      responses:
        "201":
          description: The URI of the created villain
          content:
            application/json:
              schema:
                format: uri
                type: string
  /api/villains/hello:
    get:
      tags:
      - hello
      responses:
        "200":
          description: OK
          content:
            application/json:
              schema:
                type: string
  /api/villains/random:
    get:
      tags:
      - villains
      summary: Returns a random villain
      responses:
        "200":
          description: OK
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Villain'
  /api/villains/{id}:
    get:
      tags:
      - villains
      summary: Returns a villain for a given identifier
      parameters:
      - name: id
        in: path
        required: true
        schema:
          format: int64
          type: integer
      responses:
        "200":
          description: OK
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Villain'
        "204":
          description: The villain is not found for a given identifier
    delete:
      tags:
      - villains
      summary: Deletes an exiting villain
      parameters:
      - name: id
        in: path
        required: true
        schema:
          format: int64
          type: integer
      responses:
        "204": {}
components:
  schemas:
    Villain:
      required:
      - level
      - name
      type: object
      properties:
        id:
          format: int64
          type: integer
        level:
          format: int32
          minimum: 1
          type: integer
          nullable: false
        name:
          maxLength: 50
          minLength: 3
          type: string
          nullable: false
        otherName:
          type: string
        picture:
          type: string
        powers:
          type: string
```

You can expose or exchange this contract to the API consumers, so they now what to expect when using your API.

#### OpenAPI Tests in VillainResourceTest

Call to action

Let’s add an extra test method in `VillainResourceTest` ensuring that the OpenAPI specification is packaged with the application:

```
@Test
void shouldPingOpenAPI() {
    given()
        .header(ACCEPT, JSON)
        .when().get("/q/openapi")
        .then()
        .statusCode(OK.getStatusCode());
}
```

Run the test:

- From the dev mode, or

- By executing the test using `./mvnw test`.


|     |     |
| --- | --- |
|     | If you have any problem with the code, don’t understand or feel you are running, remember to ask for some help. Also, you can get the code of this entire workshop from https://github.com/quarkusio/quarkus-workshops/tree/main/quarkus-workshop-super-heroes. You can also download the completed code from https://raw.githubusercontent.com/quarkusio/quarkus-workshops/main/quarkus-workshop-super-heroes/dist/quarkus-super-heroes-workshop-complete.zip. |

## Quarkus

* * *

In the previous chapter, you had a quick peek at Quarkus and how you can build HTTP / REST-based applications with it. But that was just the beginning; Quarkus can do a lot more, which is the purpose of this chapter. In this chapter, you are going to see:

- What’s Quarkus? and how does it change the Java landscape

- What are the main Quarkus idea, and how it helps in the *cloud native world*

- The Quarkus build process, in other words, the *secret sauce number 1*

- The Quarkus reactive nature, in other words, the *secret sauce number 2*

- Some Quarkus features such as the application lifecycle support

- How you can use Quarkus to generate native executable


### What’s Quarkus?

Java was born more than 25 years ago. The world 25 years ago was quite different. The software industry has gone through several revolutions over these two decades. Java has always been able to reinvent itself to stay relevant.

But a new revolution is happening. While for years, most applications were running on huge machines, with lots of CPU and memory, they are now running on the Cloud, in constrained environments, in containers, where the resources are shared. Density is the new optimization: crank as many mini-apps (or microservices) as possible per node. And scale by adding more instances of an app instead of a more powerful single instance.

The Java ergonomics, designed 20 years ago, do not fit well in this new environment. Java applications were designed to run 24/7 for months, even years. The JIT is optimizing the execution over time; the GC manages the memory efficiently…​ But all these features have a cost, and the memory required to run Java applications and startup times are showstoppers when you deploy 20 or 50 microservices instead of one application. The issue is not the JVM itself; it’s also the Java ecosystem that needs to be reinvented.

That’s where Quarkus, and other projects, enter the game. Quarkus uses a build time principle.<sup>\[<a id="_footnoteref_22"></a>[22](#_footnotedef_22 "View footnote.")\]</sup> During the build of the application, tasks that usually happen at runtime are executed at build time.

<img width="709" height="296" src=":/7f9e33702e2a4d2f91a12b1bba294a9d"/>

Thus, when the application runs, everything has been pre-computed, and all the annotation scanning, XML parsing, and so on won’t be executed anymore. It has two direct benefits: startup time (a lot faster) and memory consumption (a lot lower).

<img width="709" height="208" src=":/3761c3d0b8454f7da2572b49866ac02e"/>

So, as depicted in the figure above, Quarkus does bring an infrastructure for frameworks to embrace build time metadata discovery (like annotations), replace proxies with generated classes, pre-configure most frameworks, and handle dependency injection at build time.

Also, during the build, Quarkus detects which class needs to be accessed by reflection at runtime, boots framework at build time to record the result, and generally offers a lot of GraalVM optimization for free (or cheap at least). Indeed, thanks to all this metadata, Quarkus can configure native compilers such as the GraalVM compiler to generate a native executable for your Java application. Thanks to an aggressive dead-code elimination, the final executable is smaller, faster to start, and uses a ridiculously small amount of memory.

<img width="709" height="267" src=":/e12d0efcbd8a4ad59a06bf6fbc5139d4"/>

Quarkus does not stop there. As you have seen in the previous chapter, it proposes a stellar developer experience. It also unifies reactive and imperative to let you decide how you want to handle I/O. It allows implementing both REST and event-driven applications using a consistent model. To do this, Quarkus is based on a reactive core allowing high concurrency and reducing memory consumption.

Quarkus detects if your method can be called on the I/O thread and follows the reactive execution model; or if your method must be called on a worker thread and follows the imperative execution model.

Ok, but enough talking, time to see this in action.

### Quarkus Augmentation

Let’s demystify all this.

So far, you have developed the super-villains microservice. This microservice is relatively simple. It still has database access, ORM support, transaction, JSON serialization, and deserialization.

Call to action

Let’s now package this application using:

```
./mvnw package
```

In the log, you can see actions happening during what Quarkus calls the *augmentation* phase.

```
[INFO] --- quarkus-maven-plugin:2.9.2.Final:build (default) @ rest-villains ---
[INFO] [org.jboss.threads] JBoss Threads version 3.4.2.Final
[INFO] [org.hibernate.Version] HHH000412: Hibernate ORM core version 5.5.7.Final
[INFO] [io.quarkus.deployment.QuarkusAugmentor] Quarkus augmentation completed in 1932ms
```

In this log, you can observe the *build* principle. Typically, about Hibernate, it saves from having to:

1.  embed an XML parser at runtime,

2.  Do the actual parsing,

3.  Configure Hibernate based on the content of the file.


With Quarkus, at runtime, almost everything is already configured. Only runtime configuration properties are applied at startup (such as database URLs).

Also, during this augmentation, Java classes are generated or extended. Remember the `Villain` Panache entity. The class is extended during the *augmentation*. If you run `javap --class-path target/quarkus-app/quarkus/transformed-bytecode.jar io.quarkus.workshop.superheroes.villain.Villain`, you can see methods prefixed with `$$` added to the class.

Each *extension* can combine build time and run time. The following figure presents some of the extensions you already used, but there are a lot more. We are going to learn more about extensions later in this workshop and even build one. What’s important to understand for now is that the magic is packaged into extension, and every time you add a `quarkus-` dependency to your `pom.xml` file, you enable an extension.

![quarkus extensions](:/ce3936aec7664483922fd9a1f0be68e3)

### Application Lifecycle

Now that you know how Quarkus is structured let’s continue using various extensions. You often need to execute custom actions when the application starts and clean up everything when the application stops. In this module, we will display a banner in the logs once the Villain microservice has started.

#### Directory Structure

In this section, we will add an extra class (`VillainApplicationLifeCycle`) to handle the Villain API lifecycle. You will end up with the following directory structure:

![Diagram](:/7ed7b3d6417f4bfa8dee085e41a0a6b7)

#### Displaying a Banner

When our application starts, the logs are dull and lack a banner (any decent application **must** have a banner nowadays).

Call to action

So the first thing that you need to do is to go to the [following website](http://patorjk.com/software/taag) and pick up your favorite "Villain API" text banner.

Create a new class named `VillainApplicationLifeCycle` (or pick another name, the name does not matter) in the `io.quarkus.workshop.superheroes.villain` package, and copy your banner, so you end up with something like the following:

```
package io.quarkus.workshop.superheroes.villain;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class VillainApplicationLifeCycle {

    private static final Logger LOGGER = Logger.getLogger(VillainApplicationLifeCycle.class);

    void onStart(@Observes StartupEvent ev) {
        LOGGER.info(" __     ___ _ _       _             _    ____ ___ ");
        LOGGER.info(" \\ \\   / (_) | | __ _(_)_ __       / \\  |  _ \\_ _|");
        LOGGER.info("  \\ \\ / /| | | |/ _` | | '_ \\     / _ \\ | |_) | | ");
        LOGGER.info("   \\ V / | | | | (_| | | | | |   / ___ \\|  __/| | ");
        LOGGER.info("    \\_/  |_|_|_|\\__,_|_|_| |_|  /_/   \\_\\_|  |___|");
    }

    void onStop(@Observes ShutdownEvent ev) {
        LOGGER.info("The application VILLAIN is stopping...");
    }
}
```

Thanks to the CDI `@Observes`, the `VillainApplicationLifeCycle` is invoked. On startup with the `StartupEvent` so it can execute code (here, displaying the banner) when the application is starting

Call to action

Run the application with: `./mvnw quarkus:dev`, the banner is printed to the console. When the application is stopped, the second log message is printed.

|     |     |
| --- | --- |
|     | If your application is still running, just send an HTTP request, like go to http://localhost:8084. |

The method is called by ArC, the dependency injection framework used by Quarkus. Arc embraces the build-time principle, meaning that injection happens at build time. In addition, Arc can detect and remove unused beans at runtime, saving memory.

Call to action

With the application running in dev mode, open your browser to http://localhost:8084/q/dev/. In the ArC widget, you can see the number of beans that have been removed ("Removed Beans"), and if you click on the link, see the list. If you click on the "Observers" link, you will see the two methods we added. In the "Fired Events" view, you can see which event has been fired and when.

### Configuration Profiles

Quarkus supports the notion of configuration profiles. These allow you to have multiple configurations in the same file and select between them via a profile name.

Quarkus has three profiles by default, although it is possible to use as many as you like. The default profiles are:

- `dev` \- Activated when in development mode (i.e. `quarkus:dev`)

- `test` \- Activated when running tests

- `prod` \- The default profile when not running in development or test mode


Let’s change the `VillainApplicationLifeCycle` so it displays the current profile.

Call to action

For that, just add a log invoking `ProfileManager.getActiveProfile()` in the `onStart()` method:

```
LOGGER.info("The application VILLAIN is starting with profile " + ProfileManager.getActiveProfile());
```

|     |     |
| --- | --- |
|     | If not already done, you need to add the following import statement: `import io.quarkus.runtime.configuration.ProfileManager;` |

In the `application.properties` file, you can prefix a property with the profile. For example, we did add the `%test.level.multiplier=1` property in the previous chapter. It indicates that the property `level.multiplier` is set to 1 in the `test` profile.

Now, you will get the `dev` profile enabled if you start your application in dev mode with `mvn compile quarkus:dev`. If you start the tests, the `test` profile is enabled (the `multiplier` is set to 1).

You can also create your own profiles, and activate them with the `quarkus.profile` property. For example, to use a profile called `foo`, package your application with `mvn package`, and start it with `java -Dquarkus.profile=foo -jar target/quarkus-app/quarkus-run.jar`. You will see that the `foo` profile is enabled. As not overridden, the `level.multiplier` property has the value 0.5.

Profiles are handy to customize the configuration per environment. We are going to see an example of such customization in the next section.

### From Java to Native

#### Building a Native Executable

Let’s now produce a native executable for our application. As explained in the introduction of this chapter, Quarkus can generate native executables. Just like Go, native executables don’t need a VM to run; they contain the whole application, like an `.exe` file on Windows.

It improves the startup time of the application and produces a minimal disk footprint. The executable would have everything to run the application, including the "JVM" (shrunk to be just enough to run the application), and the application.

|     |     |
| --- | --- |
|     | Choosing JVM execution vs. native executable execution depends on your application needs and environment. |

To do so, you will find in the `pom.xml` the following profile:

```
<profile>
  <id>native</id>
  <activation>
    <property>
      <name>native</name>
    </property>
  </activation>
  <properties>
    <!-- ... -->
  <properties>
    <quarkus.package.type>native</quarkus.package.type>
  </properties>
</profile>
```

Make sure you have the `GRAALVM_HOME` environment variable defined and pointing to where you installed GraalVM.

Call to action

Then create a native executable using: `./mvnw package -Pnative`. In addition to the regular files, the build also produces `target/rest-villains-1.0.0-SNAPSHOT-runner` (notice that there is no `.jar` file extension). You can run it using `./target/rest-villains-1.0.0-SNAPSHOT-runner` and curl the endpoint with `curl http://localhost:8084/api/villains`.

|     |     |
| --- | --- |
|     | Creating a native executable requires a lot of memory and CPU. It also takes a few minutes, even for a simple application like the Villain microservice. Most of the time is spent during the dead code elimination, as it traverses the whole (closed) world. |

### From Java to Kubernetes

```


This section is optional and demonstrates how to ask Quarkus to create a container and deploy it to Kubernetes.
We will need a running Kubernetes.
We will use Rancher Desktop as indicated in the prerequisites.


```

#### Prerequisites

1.  Make sure that Docker Desktop (if installed) is turned off

2.  Make sure Rancher Desktop is started. The container runtime must be *dockerd* (Preferences → Container Runtime → dockerd (moby)).


#### Building a container

Quarkus is able to build a container image automatically. It proposes multiple approaches to do so, but we recommend using [jib](https://github.com/GoogleContainerTools/jib).

The resulting image follows the container good practices such as the usage of layers, avoiding the `root` user…​

Call to action

Add the `quarkus-container-image-jib` extension using the following command:

```
./mvnw quarkus:add-extension -Dextensions="jib"
```

It adds the following dependency to the `pom.xml` file:

```
<dependency>
  <groupId>io.quarkus</groupId>
  <artifactId>quarkus-container-image-jib</artifactId>
</dependency>
```

Then, launch the following command to build the application and create the container image:

```
./mvnw clean package -Dquarkus.container-image.build=true
```

Once done, verify that the container image has been created using:

```
docker images | grep villains
.../rest-villains              1.0.0-SNAPSHOT         1298cad04f5e   About a minute ago   388MB
```

#### Building a container running a native executable

In the previous section, the container embeds the Java application. You can also build and use the native executable. To do this, runs the following command:

```
./mvnw clean package -Dquarkus.container-image.build=true -Pnative -Dquarkus.native.container-build=true
```

`-Dquarkus.native.container-build=true` is indicating that we need a Linux 64bits executable. This option is not required if you use Linux.

#### Deploying to Kubernetes

Quarkus can also run our application in Kubernetes and compute the Kubernetes descriptor. In addition to allow customizing any part of the descriptor, it is possible to configure config maps, secrets…​

```


As mentioned above, we will use Rancher Desktop.
Adapt the instructions for your Kubernetes:

1. Make sure you are logged in
2. Make sure you use the correct namespace


```

Call to action

Edit the `src/main/resources/application.properties` to add the following lines:

```
quarkus.kubernetes.namespace=default # Added
quarkus.kubernetes.image-pull-policy=IfNotPresent # Added

%prod.quarkus.http.port=8080 # Added
%prod.quarkus.datasource.username=superbad
%prod.quarkus.datasource.password=superbad
%prod.quarkus.datasource.jdbc.url=jdbc:postgresql://my-villains-db-postgresql:5432/villains_database # Updated
%prod.quarkus.hibernate-orm.sql-load-script=import.sql
```

Add the `quarkus-kubernetes` extension using the following command:

```
./mvnw quarkus:add-extension -Dextensions="kubernetes"
```

|     |     |
| --- | --- |
|     | If you are behind a proxy, check the [Quarkus Registry](https://quarkus.io/guides/extension-registry-user#how-to-register-as-a-nexus-repository-proxy) proxy documentation. |

Alternatively, you can add the following dependency to the `pom.xml` file directly:

```
<dependency>
  <groupId>io.quarkus</groupId>
  <artifactId>quarkus-kubernetes</artifactId>
</dependency>
```

Rancher Desktop authentication use elliptic algorithms not supported by default in Java. So, we also need to add the following dependency to the project:

```
<dependency>
  <groupId>org.bouncycastle</groupId>
  <artifactId>bcpkix-jdk18on</artifactId>
  <version>1.71</version>
</dependency>
```

Before deploying our application, we need to deploy the database. To achieve this, we are going to use [helm](https://helm.sh/) (installed alongside Rancher Desktop) and the following [postgresql package](https://artifacthub.io/packages/helm/bitnami/postgresql).

Run the following commands:

```
helm repo add bitnami https://charts.bitnami.com/bitnami
helm install my-villains-db \
    --set auth.postgresPassword=superbad \
    --set auth.username=superbad \
    --set auth.password=superbad \
    --set auth.database=villains_database bitnami/postgresql
```

Finally, deploy the application using:

```
./mvnw clean package -Dquarkus.kubernetes.deploy=true -DskipTests
...
kubectl get pods
NAME                             READY   STATUS    RESTARTS   AGE
my-villains-db-postgresql-0      1/1     Running   0          28m
rest-villains-7c7479b959-7fn64   1/1     Running   0          12m
```

Make sure you wait for the `rest-villains` pod to be ready (1/1).

Enable port-forwarding to port 8080 either from the rancher desktop UI (Preferences → Port Forwarding → default / rest-villains / http), or using the following command line:

```
kubectl port-forward pods/rest-villains-7c7479b959-7fn64 8080:8080
```

Now, you can access the application from your browser using: http://localhost:8080/api/villains

## Reactive

* * *

Quarkus combines the build time principle with a reactive core. The combination of these two characteristics improves the application concurrency and makes use of resources more efficiently. In this chapter, we will see the counterpart of the Villain microservice: the Hero microservice! Instead of the imperative approach used for the villains, we will use reactive programming and Hibernate Reactive. The logic of the microservice is the same.

<img width="300" height="244" src=":/105d747430824226ab46872f44a84bc4"/>

In the following sections, you will learn:

- How to create a new reactive Quarkus application

- How to implement REST API using JAX-RS and the RESTEasy Reactive extension using a reactive development model

- How to access your database using Hibernate Reactive with Panache

- How to use transactions the reactive way


|     |     |
| --- | --- |
|     | This service is exposed on the port 8083. |

### Why reactive?

"Reactive" is a set of principles to build *better* distributed systems. By following these principles, you create more elastic and resilient systems.

One of the central aspects of being reactive is about using non-blocking I/O to handle remote interactions efficiently. With a few threads, your application can handle many concurrent I/Os. A consequence of such usage is the need to implement applications that do not block these threads. There are multiple approaches to do so, such as callbacks, co-routings, and reactive programming.

Quarkus encourages users to use Mutiny, an intuitive and event-driven reactive programming library. In this section, we will cover the basics of Mutiny and implement an entirely reactive microservice.

### Hero Microservice

New microservice, new project!

The easiest way to create this new Quarkus project is to use the Quarkus Maven plugin. Open a terminal and run the following command:

Call to action

```
cd quarkus-workshop-super-heroes/super-heroes

mvn io.quarkus:quarkus-maven-plugin:2.9.2.Final:create \
    -DprojectGroupId=io.quarkus.workshop.super-heroes \
    -DprojectArtifactId=rest-heroes \
    -DclassName="io.quarkus.workshop.superheroes.hero.HeroResource" \
    -Dpath="api/heroes" \
    -Dextensions="resteasy-reactive-jackson,quarkus-hibernate-validator,quarkus-smallrye-openapi,quarkus-hibernate-reactive-panache,quarkus-reactive-pg-client"
```

As you can see, we can select multiple extensions during the project creation:

- `resteasy-reactive-jackson` provides RESTEasy Reactive and the ability to map JSON objects,

- `quarkus-hibernate-validator` provides the Hibernate Validator support,

- `quarkus-smallrye-openapi` provides the OpenAPI descriptor support and the Swagger UI in the dev console,

- `quarkus-hibernate-reactive-panache` provides Panache entity supports using Hibernate Reactive, an ORM using reactive database drivers,

- `quarkus-reactive-pg-client` provides the reactive database driver used by Hibernate Reactive to interact with PostGreSQL databases.


If you want your IDE to manage this new Maven project, you can declare it in the parent POM by adding this new module in the `<modules>` section:

```
<module>super-heroes/rest-heroes</module>
```

#### Directory Structure

At the end of this chapter, you will end up with the following directory structure:

![Diagram](:/1227360816744206adbf39f610a399d8)

#### The Hero entity

Let’s start with the `Hero` entity class.

Call to action

Create the `io.quarkus.workshop.superheroes.hero.Hero` class in the created project with the following content:

```
package io.quarkus.workshop.superheroes.hero;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import io.smallrye.mutiny.Uni;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Random;

@Entity
public class Hero extends PanacheEntity {

    @NotNull
    @Size(min = 3, max = 50)
    public String name;

    public String otherName;

    @NotNull
    @Min(1)
    public int level;
    public String picture;

    @Column(columnDefinition = "TEXT")
    public String powers;

    public static Uni<Hero> findRandom() {
        Random random = new Random();
        return count()
            .map(count -> random.nextInt(count.intValue()))
            .chain(randomHero -> findAll().page(randomHero, 1).firstResult());
    }

    @Override
    public String toString() {
        return "Hero{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", otherName='" + otherName + '\'' +
            ", level=" + level +
            ", picture='" + picture + '\'' +
            ", powers='" + powers + '\'' +
            '}';
    }
}
```

First, note that we are extending `io.quarkus.hibernate.reactive.panache.PanacheEntity`. It’s the reactive variant of `import io.quarkus.hibernate.orm.panache.PanacheEntity`. As a consequence, methods are asynchronous, and instead of returning an object, they return asynchronous structure that will let you know when the object is ready to be consumed.

The field part is the same as for the Villain. The `toString` method is also equivalent.

The major difference is the `findRandom` method. Instead of returning a `Hero`, it returns a `Uni<Hero`. A `Uni` represents an asynchronous action. Unlike with the imperative development model, we cannot block the thread waiting for the result. Here, we need to register a *continuation* invoked when the result is available. During that time, the thread is released and can be used to handle another request.

Let’s split the `findRandom` method to better understand what’s going on:

1.  `count()` returns a `Uni<Long>` with the number of heroes stored in the database,

2.  when this count is retrieved from the database, it transforms the result into a random number,

3.  when this is computed, it chains the processing with another asynchronous action which retrieve the hero located at the random index.


As a consequence this method returns a `Uni<Hero>`. The consumer will need to register a continuation to receive the `Hero`.

#### Uni API in 2 minutes

Uni comes from [Mutiny](https://smallrye.io/smallrye-mutiny), an intuitive, event-driven reactive programming library.

There are a few method to understand to use `Uni`:

- `map` : transforms (synchronously) an item when this item becomes available.

- `chain`: transforms an item, when it become available, into another `Uni`. The outcome will be the outcome of the produced `Uni`.

- `replaceWith`: replaces an item with something else.

- `invoke`: invokes the method when the item becomes available. It does not modify the item.


|     |     |
| --- | --- |
|     | `Uni` is lazy. To trigger the computation you need to subscribe to it. However, most of the time, Quarkus handles the subscription for us. |

#### The Hero Resource

Unlike the `VillainResource`, the `HeroResource` uses the reactive development model. It returns asynchronous structures (`Uni`)<sup>\[<a id="_footnoteref_23"></a>[23](#_footnotedef_23 "View footnote.")\]</sup>.

Call to action

Open the `HeroResource` and update the content to be:

```
package io.quarkus.workshop.superheroes.hero;

import io.quarkus.hibernate.reactive.panache.common.runtime.ReactiveTransactional;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.RestPath;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.List;

import static javax.ws.rs.core.MediaType.*;

@Path("/api/heroes")
@Tag(name = "heroes")
public class HeroResource {

    Logger logger;

    public HeroResource(Logger logger) {
        this.logger = logger;
    }

    @Operation(summary = "Returns a random hero")
    @GET
    @Path("/random")
    @APIResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Hero.class, required = true)))
    public Uni<Hero> getRandomHero() {
        return Hero.findRandom()
            .invoke(h -> logger.debugf("Found random hero: %s", h));
    }

    @Operation(summary = "Returns all the heroes from the database")
    @GET
    @APIResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Hero.class, type = SchemaType.ARRAY)))
    @APIResponse(responseCode = "204", description = "No Heroes")
    public Uni<List<Hero>> getAllHeroes() {
        return Hero.listAll();
    }

    @Operation(summary = "Returns a hero for a given identifier")
    @GET
    @Path("/{id}")
    @APIResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Hero.class)))
    @APIResponse(responseCode = "204", description = "The hero is not found for a given identifier")
    public Uni<Response> getHero(@RestPath Long id) {
        return Hero.<Hero>findById(id)
            .map(hero -> {
                if (hero != null) {
                    return Response.ok(hero).build();
                }
                logger.debugf("No Hero found with id %d", id);
                return Response.noContent().build();
            });
    }

    @Operation(summary = "Creates a valid hero")
    @POST
    @APIResponse(responseCode = "201", description = "The URI of the created hero", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = URI.class)))
    @ReactiveTransactional
    public Uni<Response> createHero(@Valid Hero hero, @Context UriInfo uriInfo) {
        return hero.<Hero>persist()
            .map(h -> {
                UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(Long.toString(h.id));
                logger.debug("New Hero created with URI " + builder.build().toString());
                return Response.created(builder.build()).build();
            });
    }

    @Operation(summary = "Updates an exiting hero")
    @PUT
    @APIResponse(responseCode = "200", description = "The updated hero", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Hero.class)))
    @ReactiveTransactional
    public Uni<Response> updateHero(@Valid Hero hero) {
        return Hero.<Hero>findById(hero.id)
            .map(retrieved -> {
                retrieved.name = hero.name;
                retrieved.otherName = hero.otherName;
                retrieved.level = hero.level;
                retrieved.picture = hero.picture;
                retrieved.powers = hero.powers;
                return retrieved;
            })
            .map(h -> {
                logger.debugf("Hero updated with new valued %s", h);
                return Response.ok(h).build();
            });

    }

    @Operation(summary = "Deletes an exiting hero")
    @DELETE
    @Path("/{id}")
    @APIResponse(responseCode = "204")
    @ReactiveTransactional
    public Uni<Response> deleteHero(@RestPath Long id) {
        return Hero.deleteById(id)
            .invoke(() -> logger.debugf("Hero deleted with %d", id))
            .replaceWith(Response.noContent().build());
    }

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    @Tag(name = "hello")
    public String hello() {
        return "Hello Hero Resource";
    }
}
```

The resource implements the same HTTP API as the villain counterpart. It does not use a transactional service, but uses Panache method directly.

As you can see, instead of returning the result directly, it returns `Uni<T>`. Quarkus retrieves the `Uni` and *waits* for the outcome to be available before writing the response. During that time, it can handle other requests.

Notice also the `@ReactiveTransactional`, which is the reactive variant of `@Transactional`.

#### Configuring the reactive access to the database

Configuring the reactive access to the database is relatively similar to configuring the JDBC url.

Call to action

Open the `application.properties` file and add:

```
## HTTP configuration
quarkus.http.port=8083

# drop and create the database at startup (use `update` to only update the schema)
quarkus.hibernate-orm.database.generation=drop-and-create

%prod.quarkus.datasource.username=superman
%prod.quarkus.datasource.password=superman
%prod.quarkus.datasource.reactive.url=postgresql://localhost:5432/heroes_database
%prod.quarkus.hibernate-orm.sql-load-script=import.sql
```

The *prod* profile contains the `%prod.quarkus.datasource.reactive.url` which configure the access to the database.

We also set the port to be 8083.

#### Importing heroes

Call to action

Create the `src/main/resources/import.sql` and copy the content from [import.sql](https://raw.githubusercontent.com/quarkusio/quarkus-workshops/main/quarkus-workshop-super-heroes/super-heroes/rest-heroes/src/main/resources/import.sql).

```
INSERT INTO hero(id, name, otherName, picture, powers, level)
VALUES (nextval('hibernate_sequence'), 'Chewbacca', '', 'https://www.superherodb.com/pictures2/portraits/10/050/10466.jpg', 'Agility, Longevity, Marksmanship, Natural Weapons, Stealth, Super Strength, Weapons Master', 5);
INSERT INTO hero(id, name, otherName, picture, powers, level)
VALUES (nextval('hibernate_sequence'), 'Angel Salvadore', 'Angel Salvadore Bohusk', 'https://www.superherodb.com/pictures2/portraits/10/050/1406.jpg', 'Animal Attributes, Animal Oriented Powers, Flight, Regeneration, Toxin and Disease Control', 4);
INSERT INTO hero(id, name, otherName, picture, powers, level)
VALUES (nextval('hibernate_sequence'), 'Bill Harken', '', 'https://www.superherodb.com/pictures2/portraits/10/050/1527.jpg', 'Super Speed, Super Strength, Toxin and Disease Resistance', 6);
INSERT INTO hero(id, name, otherName, picture, powers, level)
...
```

#### Testing the heroes

Time for some tests! Open the `io.quarkus.workshop.superheroes.hero.HeroResourceTest` class and copy the following content:

Call to action

```
package io.quarkus.workshop.superheroes.hero;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.common.mapper.TypeRef;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.HttpHeaders.ACCEPT;
import static javax.ws.rs.core.HttpHeaders.CONTENT_TYPE;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HeroResourceTest {

    private static final String JSON = "application/json;charset=UTF-8";

    private static final String DEFAULT_NAME = "Super Baguette";
    private static final String UPDATED_NAME = "Super Baguette (updated)";
    private static final String DEFAULT_OTHER_NAME = "Super Baguette Tradition";
    private static final String UPDATED_OTHER_NAME = "Super Baguette Tradition (updated)";
    private static final String DEFAULT_PICTURE = "super_baguette.png";
    private static final String UPDATED_PICTURE = "super_baguette_updated.png";
    private static final String DEFAULT_POWERS = "eats baguette really quickly";
    private static final String UPDATED_POWERS = "eats baguette really quickly (updated)";
    private static final int DEFAULT_LEVEL = 42;
    private static final int UPDATED_LEVEL = 43;

    private static final int NB_HEROES = 951;
    private static String heroId;

    @Test
    void shouldPingOpenAPI() {
        given()
            .header(ACCEPT, APPLICATION_JSON)
            .when().get("/q/openapi")
            .then()
            .statusCode(OK.getStatusCode());
    }

    @Test
    public void testHelloEndpoint() {
        given()
            .when().get("/api/heroes/hello")
            .then()
            .statusCode(200)
            .body(is("Hello Hero Resource"));
    }

    @Test
    void shouldNotGetUnknownHero() {
        Long randomId = new Random().nextLong();
        given()
            .pathParam("id", randomId)
            .when().get("/api/heroes/{id}")
            .then()
            .statusCode(NO_CONTENT.getStatusCode());
    }

    @Test
    void shouldGetRandomHero() {
        given()
            .when().get("/api/heroes/random")
            .then()
            .statusCode(OK.getStatusCode())
            .contentType(APPLICATION_JSON);
    }

    @Test
    void shouldNotAddInvalidItem() {
        Hero hero = new Hero();
        hero.name = null;
        hero.otherName = DEFAULT_OTHER_NAME;
        hero.picture = DEFAULT_PICTURE;
        hero.powers = DEFAULT_POWERS;
        hero.level = 0;

        given()
            .body(hero)
            .header(CONTENT_TYPE, APPLICATION_JSON)
            .header(ACCEPT, APPLICATION_JSON)
            .when()
            .post("/api/heroes")
            .then()
            .statusCode(BAD_REQUEST.getStatusCode());
    }

    @Test
    @Order(1)
    void shouldGetInitialItems() {
        List<Hero> heroes = get("/api/heroes").then()
            .statusCode(OK.getStatusCode())
            .contentType(APPLICATION_JSON)
            .extract().body().as(getHeroTypeRef());
        assertEquals(NB_HEROES, heroes.size());
    }

    @Test
    @Order(2)
    void shouldAddAnItem() {
        Hero hero = new Hero();
        hero.name = DEFAULT_NAME;
        hero.otherName = DEFAULT_OTHER_NAME;
        hero.picture = DEFAULT_PICTURE;
        hero.powers = DEFAULT_POWERS;
        hero.level = DEFAULT_LEVEL;

        String location = given()
            .body(hero)
            .header(CONTENT_TYPE, APPLICATION_JSON)
            .header(ACCEPT, APPLICATION_JSON)
            .when()
            .post("/api/heroes")
            .then()
            .statusCode(CREATED.getStatusCode())
            .extract().header("Location");
        assertTrue(location.contains("/api/heroes"));

        // Stores the id
        String[] segments = location.split("/");
        heroId = segments[segments.length - 1];
        assertNotNull(heroId);

        given()
            .pathParam("id", heroId)
            .when().get("/api/heroes/{id}")
            .then()
            .statusCode(OK.getStatusCode())
            .body("name", Is.is(DEFAULT_NAME))
            .body("otherName", Is.is(DEFAULT_OTHER_NAME))
            .body("level", Is.is(DEFAULT_LEVEL))
            .body("picture", Is.is(DEFAULT_PICTURE))
            .body("powers", Is.is(DEFAULT_POWERS));

        List<Hero> heroes = get("/api/heroes").then()
            .statusCode(OK.getStatusCode())
            .extract().body().as(getHeroTypeRef());
        assertEquals(NB_HEROES + 1, heroes.size());
    }

    @Test
    @Order(3)
    void shouldUpdateAnItem() {
        Hero hero = new Hero();
        hero.id = Long.valueOf(heroId);
        hero.name = UPDATED_NAME;
        hero.otherName = UPDATED_OTHER_NAME;
        hero.picture = UPDATED_PICTURE;
        hero.powers = UPDATED_POWERS;
        hero.level = UPDATED_LEVEL;

        given()
            .body(hero)
            .header(CONTENT_TYPE, APPLICATION_JSON)
            .header(ACCEPT, APPLICATION_JSON)
            .when()
            .put("/api/heroes")
            .then()
            .statusCode(OK.getStatusCode())
            .contentType(APPLICATION_JSON)
            .body("name", Is.is(UPDATED_NAME))
            .body("otherName", Is.is(UPDATED_OTHER_NAME))
            .body("level", Is.is(UPDATED_LEVEL))
            .body("picture", Is.is(UPDATED_PICTURE))
            .body("powers", Is.is(UPDATED_POWERS));

        List<Hero> heroes = get("/api/heroes").then()
            .statusCode(OK.getStatusCode())
            .contentType(APPLICATION_JSON)
            .extract().body().as(getHeroTypeRef());
        assertEquals(NB_HEROES + 1, heroes.size());
    }

    @Test
    @Order(4)
    void shouldRemoveAnItem() {
        given()
            .pathParam("id", heroId)
            .when().delete("/api/heroes/{id}")
            .then()
            .statusCode(NO_CONTENT.getStatusCode());

        List<Hero> heroes = get("/api/heroes").then()
            .statusCode(OK.getStatusCode())
            .contentType(APPLICATION_JSON)
            .extract().body().as(getHeroTypeRef());
        assertEquals(NB_HEROES, heroes.size());
    }

    private TypeRef<List<Hero>> getHeroTypeRef() {
        return new TypeRef<List<Hero>>() {
            // Kept empty on purpose
        };
    }
}
```

The tests are very similar to the ones from the villain service.

### Running, Testing and Packaging the Application

Call to action

First, make sure the tests pass by executing the command `./mvnw test` (or from your IDE).

Now that the tests are green, we are ready to run our application.

Call to action

Use `./mvnw quarkus:dev` to start it. Once the application is started, create a new hero with the following cUrl command:

```
curl -X POST -d  '{"level":2, "name":"Super Frog", "powers":"leaping"}'  -H "Content-Type: application/json" http://localhost:8083/api/heroes -v

< HTTP/1.1 201 Created
< Location: http://localhost:8083/api/heroes/952
```

The cUrl command returns the location of the newly created hero. Take this URL and do an HTTP GET on it.

```
curl http://localhost:8083/api/heroes/952 | jq

{
  "id": 952,
  "name": "Super Frog",
  "otherName": null,
  "level": 2,
  "picture": null,
  "powers": "leaping"
}
```

Remember that you can also check Swagger UI by going to the dev console: http://localhost:8083/q/dev.

Call to action

Then, build the application using: `./mvnw package`, and run the application using `java -jar target/quarkus-app/quarkus-run.jar`

## From Microservice to Microservices

* * *

So far we’ve built two microservices: the villains and heroes microservices. In the following sections you will develop an extra microservice: a *fight* microservice where heroes and villains fight. We will also add an Angular front-end, so we can fight graphically. But as you can notice in the diagram below, these microservices still not communicate with each other. You will have to wait the next chapter for that ;o)

<img width="1418" height="868" src=":/22535b8d7191489b9c293a1591508c53"/>

Each microservice is developed in its own directory.

![Diagram](:/1cb5d1d46d6940ceaceed6d2406f3c4d)

In the following sections, you will:

- Create a new Quarkus application

- Implement REST API using JAX-RS

- Access your database using Hibernate ORM with Panache

- Use transactions


|     |     |
| --- | --- |
|     | This service is exposed on the port 8082. |

### Fight Microservice

Ok, let’s develop another microservice. We have a REST API that returns a random Hero. Another REST API that returns a random Villain…​ we need a new REST API that invokes those two, gets one random hero and one random villain and makes them fight. Let’s call it the Fight API.

|     |     |
| --- | --- |
|     | This microservice uses the imperative development model but use reactive extensions. |

#### Bootstrapping the Fight REST Endpoint

Like for the Hero and Villain API, the easiest way to create this new Quarkus project is to use a Maven archetype. Under the `quarkus-workshop-super-heroes/super-heroes` root directory where you have all your code.

Call to action

Open a terminal and run the following command:

```
mvn io.quarkus:quarkus-maven-plugin:2.9.2.Final:create \
  -DprojectGroupId=io.quarkus.workshop.super-heroes \
  -DprojectArtifactId=rest-fights \
  -DclassName="io.quarkus.workshop.superheroes.fight.FightResource" \
  -Dpath="api/fights" \
  -Dextensions="jdbc-postgresql,hibernate-orm-panache,hibernate-validator,quarkus-resteasy-reactive-jackson,smallrye-openapi,kafka"
```

If you open the `pom.xml` file, you will see that the following extensions have been imported:

- `io.quarkus:quarkus-hibernate-orm-panache`

- `io.quarkus:quarkus-hibernate-validator`

- `io.quarkus:quarkus-smallrye-openapi`

- `io.quarkus:quarkus-smallrye-reactive-messaging-kafka`

- `io.quarkus:quarkus-resteasy-reactive-jackson`

- `io.quarkus:quarkus-jdbc-postgresql`


You can see that beyond the extensions we have used so far, we added the Kafka support which uses Eclipse MicroProfile Reactive Messaging. Stay tuned.

Call to action

The Quarkus Maven plugin has generated some code that we won’t be using. You can delete the Java classes `MyReactiveMessagingApplication` and `MyReactiveMessagingApplicationTest`.

If you want your IDE to manage this new Maven project, you can declare it in the parent POM by adding this new module in the `<modules>` section:

```
<module>super-heroes/rest-fights</module>
```

#### Directory Structure

At the end you should have the following directory structure:

![Diagram](:/1cb895017a1f4435ba518b5bc4554fca)

#### Fight Entity

A fight is between a hero and a villain. Each time there is a fight, there is a winner and a loser. So the `Fight` entity is there to store all these fights.

Call to action

Create the `io.quarkus.workshop.superheroes.fight.Fight` class with the following content:

```
package io.quarkus.workshop.superheroes.fight;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Entity
@Schema(description="Each fight has a winner and a loser")
public class Fight extends PanacheEntity {

    @NotNull
    public Instant fightDate;
    @NotNull
    public String winnerName;
    @NotNull
    public int winnerLevel;
    @NotNull
    public String winnerPicture;
    @NotNull
    public String loserName;
    @NotNull
    public int loserLevel;
    @NotNull
    public String loserPicture;
    @NotNull
    public String winnerTeam;
    @NotNull
    public String loserTeam;

}
```

#### Fighters Bean

Now comes a trick. The Fight REST API will ultimately invoke the Hero and Villain APIs (next sections) to get two random fighters. The `Fighters` class has one `Hero` and one `Villain`. Notice that `Fighters` is not an entity, it is not persisted in the database, just marshalled and unmarshalled to JSon.

Call to action

Create the `io.quarkus.workshop.superheroes.fight.Fighters` class, with the following content:

```
package io.quarkus.workshop.superheroes.fight;

import io.quarkus.workshop.superheroes.fight.client.Hero;
import io.quarkus.workshop.superheroes.fight.client.Villain;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.validation.constraints.NotNull;

@Schema(description="A fight between one hero and one villain")
public class Fighters {

    @NotNull
    public Hero hero;
    @NotNull
    public Villain villain;

}
```

It does not compile because it needs a `Hero` class and a `Villain` class. The Fight REST API is just interested in the hero’s name, level, picture and powers (not the other name as described in the Hero API).

Call to action

So create the `Hero` bean looks like this (notice the `client` subpackage):

```
package io.quarkus.workshop.superheroes.fight.client;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.validation.constraints.NotNull;

@Schema(description="The hero fighting against the villain")
public class Hero {

    @NotNull
    public String name;
    @NotNull
    public int level;
    @NotNull
    public String picture;
    public String powers;

}
```

Also create the `Villain` counterpart (also in the `client` subpackage):

```
package io.quarkus.workshop.superheroes.fight.client;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.validation.constraints.NotNull;

@Schema(description="The villain fighting against the hero")
public class Villain {

    @NotNull
    public String name;
    @NotNull
    public int level;
    @NotNull
    public String picture;
    public String powers;

}
```

So, these classes are just used to map the results from the `Hero` and `Villain` microservices.

#### FightService Transactional Service

Now, let’s create a `FightService` class that orchestrate the fights.

Call to action

Create the `io.quarkus.workshop.superheroes.fight.FightService` class with the following content:

```
package io.quarkus.workshop.superheroes.fight;

import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Random;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

@ApplicationScoped
@Transactional(SUPPORTS)
public class FightService {

    @Inject Logger logger;

    private final Random random = new Random();

    public List<Fight> findAllFights() {
        return Fight.listAll();
    }

    public Fight findFightById(Long id) {
        return Fight.findById(id);
    }

    public Fighters findRandomFighters() {
        // Will be implemented later
        return null;
    }

    @Transactional(REQUIRED)
    public Fight persistFight(Fighters fighters) {
        // Amazingly fancy logic to determine the winner...
        Fight fight;

        int heroAdjust = random.nextInt(20);
        int villainAdjust = random.nextInt(20);

        if ((fighters.hero.level + heroAdjust)
            > (fighters.villain.level + villainAdjust)) {
            fight = heroWon(fighters);
        } else if (fighters.hero.level < fighters.villain.level) {
            fight = villainWon(fighters);
        } else {
            fight = random.nextBoolean() ? heroWon(fighters) : villainWon(fighters);
        }

        fight.fightDate = Instant.now();
        fight.persist();

        return fight;
    }

    private Fight heroWon(Fighters fighters) {
        logger.info("Yes, Hero won :o)");
        Fight fight = new Fight();
        fight.winnerName = fighters.hero.name;
        fight.winnerPicture = fighters.hero.picture;
        fight.winnerLevel = fighters.hero.level;
        fight.loserName = fighters.villain.name;
        fight.loserPicture = fighters.villain.picture;
        fight.loserLevel = fighters.villain.level;
        fight.winnerTeam = "heroes";
        fight.loserTeam = "villains";
        return fight;
    }

    private Fight villainWon(Fighters fighters) {
        logger.info("Gee, Villain won :o(");
        Fight fight = new Fight();
        fight.winnerName = fighters.villain.name;
        fight.winnerPicture = fighters.villain.picture;
        fight.winnerLevel = fighters.villain.level;
        fight.loserName = fighters.hero.name;
        fight.loserPicture = fighters.hero.picture;
        fight.loserLevel = fighters.hero.level;
        fight.winnerTeam = "villains";
        fight.loserTeam = "heroes";
        return fight;
    }

}
```

Notice the `persistFight` method. This method is the one creating a fight between a hero and a villain. As you can see the algorithm to determine the winner is a bit random (even though it uses the levels). If you are not happy about the way the fight operates, choose your own winning algorithm ;o)

|     |     |
| --- | --- |
|     | For now, the `Fighters findRandomFighters()` method returns null. Later, this method will invoke the Hello and Villain API to get a random Hero and random Villain. |

#### FightResource Endpoint

To expose a REST API we also need a `FightResource` (with OpenAPI annotations of course).

Call to action

```
package io.quarkus.workshop.superheroes.fight;

import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import java.util.List;

import static javax.ws.rs.core.MediaType.*;

@Path("/api/fights")
@Produces(APPLICATION_JSON)
public class FightResource {

    @Inject Logger logger;

    @Inject
    FightService service;

    @GET
    @Path("/randomfighters")
    public Response getRandomFighters() {
        Fighters fighters = service.findRandomFighters();
        logger.debug("Get random fighters " + fighters);
        return Response.ok(fighters).build();
    }

    @GET
    public Response getAllFights() {
        List<Fight> fights = service.findAllFights();
        logger.debug("Total number of fights " + fights);
        return Response.ok(fights).build();
    }

    @GET
    @Path("/{id}")
    public Response getFight(Long id) {
        Fight fight = service.findFightById(id);
        if (fight != null) {
            logger.debug("Found fight " + fight);
            return Response.ok(fight).build();
        } else {
            logger.debug("No fight found with id " + id);
            return Response.noContent().build();
        }
    }

    @POST
    public Fight fight(@Valid Fighters fighters, UriInfo uriInfo) {
        return service.persistFight(fighters);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/hello")
    public String hello() {
        return "Hello Fight Resource";
    }
}
```

|     |     |
| --- | --- |
|     | The OpenAPI annotations have been omitted to keep the service focused on the task. Feel free to add them if you want complete OpenAPI descriptors. |

#### Adding Data

Call to action

To load some SQL statements when Hibernate ORM starts, create the `src/main/resources/import.sql` file with the following content:

```
INSERT INTO fight(id, fightDate, winnerName, winnerLevel, winnerPicture, loserName, loserLevel, loserPicture, winnerTeam, loserTeam)
VALUES (nextval('hibernate_sequence'), current_timestamp, 'Chewbacca', 5, 'https://www.superherodb.com/pictures2/portraits/10/050/10466.jpg', 'Buuccolo', 3, 'https://www.superherodb.com/pictures2/portraits/11/050/15355.jpg', 'heroes', 'villains');
INSERT INTO fight(id, fightDate, winnerName, winnerLevel, winnerPicture, loserName, loserLevel, loserPicture, winnerTeam ,loserTeam)
VALUES (nextval('hibernate_sequence'), current_timestamp, 'Galadriel', 10, 'https://www.superherodb.com/pictures2/portraits/11/050/11796.jpg', 'Darth Vader', 8, 'https://www.superherodb.com/pictures2/portraits/10/050/10444.jpg', 'heroes', 'villains');
INSERT INTO fight(id, fightDate, winnerName, winnerLevel, winnerPicture, loserName, loserLevel, loserPicture, winnerTeam ,loserTeam)
VALUES (nextval('hibernate_sequence'), current_timestamp, 'Annihilus', 23, 'https://www.superherodb.com/pictures2/portraits/10/050/1307.jpg', 'Shikamaru', 1, 'https://www.superherodb.com/pictures2/portraits/10/050/11742.jpg', 'villains', 'heroes');
```

#### Configuration

As usual, we need to configure the application.

Call to action

In the `application.properties` file add:

```
## HTTP configuration
quarkus.http.port=8082

# drop and create the database at startup (use `update` to only update the schema)
quarkus.hibernate-orm.database.generation=drop-and-create

## Logging configuration
quarkus.log.console.enable=true
quarkus.log.console.format=%d{HH:mm:ss} %-5p [%c{2.}] (%t) %s%e%n
quarkus.log.console.level=DEBUG

## Production configuration
%prod.quarkus.datasource.jdbc.url=jdbc:postgresql://localhost:5432/fights_database
%prod.quarkus.datasource.db-kind=postgresql
%prod.quarkus.datasource.username=superfight
%prod.quarkus.datasource.password=superfight
%prod.quarkus.hibernate-orm.sql-load-script=import.sql

%prod.quarkus.log.console.level=INFO
%prod.quarkus.hibernate-orm.database.generation=update
```

Note that the fight service uses the port `8082`.

#### FightResourceTest Test Class

We need to test our REST API.

Call to action

For that, copy the following `FightResourceTest` class under the `src/test/java/io/quarkus/workshop/superheroes/fight` directory.

```
package io.quarkus.workshop.superheroes.fight;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.workshop.superheroes.fight.client.Hero;
import io.quarkus.workshop.superheroes.fight.client.Villain;
import io.restassured.common.mapper.TypeRef;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.List;

import java.util.Random;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.HttpHeaders.ACCEPT;
import static javax.ws.rs.core.HttpHeaders.CONTENT_TYPE;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FightResourceTest {

    private static final String DEFAULT_WINNER_NAME = "Super Baguette";
    private static final String DEFAULT_WINNER_PICTURE = "super_baguette.png";
    private static final int DEFAULT_WINNER_LEVEL = 42;
    private static final String DEFAULT_LOSER_NAME = "Super Chocolatine";
    private static final String DEFAULT_LOSER_PICTURE = "super_chocolatine.png";
    private static final int DEFAULT_LOSER_LEVEL = 6;

    private static final int NB_FIGHTS = 3;
    private static String fightId;

    @Test
    void shouldPingOpenAPI() {
        given()
            .header(ACCEPT, APPLICATION_JSON)
            .when().get("/q/openapi")
            .then()
            .statusCode(OK.getStatusCode());
    }

    @Test
    public void testHelloEndpoint() {
        given()
            .when().get("/api/fights/hello")
            .then()
            .statusCode(200)
            .body(is("Hello Fight Resource"));
    }

    @Test
    void shouldNotGetUnknownFight() {
        Long randomId = new Random().nextLong();
        given()
            .pathParam("id", randomId)
            .when().get("/api/fights/{id}")
            .then()
            .statusCode(NO_CONTENT.getStatusCode());
    }

    @Test
    void shouldNotAddInvalidItem() {
        Fighters fighters = new Fighters();
        fighters.hero = null;
        fighters.villain = null;

        given()
            .body(fighters)
            .header(CONTENT_TYPE, APPLICATION_JSON)
            .header(ACCEPT, APPLICATION_JSON)
            .when()
            .post("/api/fights")
            .then()
            .statusCode(BAD_REQUEST.getStatusCode());
    }

    @Test
    @Order(1)
    void shouldGetInitialItems() {
        List<Fight> fights = get("/api/fights").then()
            .statusCode(OK.getStatusCode())
            .extract().body().as(getFightTypeRef());
        assertEquals(NB_FIGHTS, fights.size());
    }

    @Test
    @Order(2)
    void shouldAddAnItem() {
        Hero hero = new Hero();
        hero.name = DEFAULT_WINNER_NAME;
        hero.picture = DEFAULT_WINNER_PICTURE;
        hero.level = DEFAULT_WINNER_LEVEL;
        Villain villain = new Villain();
        villain.name = DEFAULT_LOSER_NAME;
        villain.picture = DEFAULT_LOSER_PICTURE;
        villain.level = DEFAULT_LOSER_LEVEL;
        Fighters fighters = new Fighters();
        fighters.hero = hero;
        fighters.villain = villain;

        fightId = given()
            .body(fighters)
            .header(CONTENT_TYPE, APPLICATION_JSON)
            .header(ACCEPT, APPLICATION_JSON)
            .when()
            .post("/api/fights")
            .then()
            .statusCode(OK.getStatusCode())
            .body(containsString("winner"), containsString("loser"))
            .extract().body().jsonPath().getString("id");

        assertNotNull(fightId);

        given()
            .pathParam("id", fightId)
            .when().get("/api/fights/{id}")
            .then()
            .statusCode(OK.getStatusCode())
            .contentType(APPLICATION_JSON)
            .body("winnerName", Is.is(DEFAULT_WINNER_NAME))
            .body("winnerPicture", Is.is(DEFAULT_WINNER_PICTURE))
            .body("winnerLevel", Is.is(DEFAULT_WINNER_LEVEL))
            .body("loserName", Is.is(DEFAULT_LOSER_NAME))
            .body("loserPicture", Is.is(DEFAULT_LOSER_PICTURE))
            .body("loserLevel", Is.is(DEFAULT_LOSER_LEVEL))
            .body("fightDate", Is.is(notNullValue()));

        List<Fight> fights = get("/api/fights").then()
            .statusCode(OK.getStatusCode())
            .extract().body().as(getFightTypeRef());
        assertEquals(NB_FIGHTS + 1, fights.size());
    }

    private TypeRef<List<Fight>> getFightTypeRef() {
        return new TypeRef<List<Fight>>() {
            // Kept empty on purpose
        };
    }
}
```

Quarkus automatically starts the PostGreSQL database as well as a Kafka broker. Also, delete the generated `FightResourceIT` native test class, as we won’t run native tests.

#### Running, Testing and Packaging the Application

Call to action

First, make sure the tests pass by executing the command `./mvnw test` (or from your IDE).

Now that the tests are green, we are ready to run our application. Use `./mvnw quarkus:dev` to start it (notice that there is no banner yet, it will come later). Once the application is started, just check that it returns the fights from the database with the following cURL command:

```
curl http://localhost:8082/api/fights
```

Remember that you can also check Swagger UI by going to http://localhost:8082/q/swagger-ui.

### User Interface

Now that we have the three main microservices, time to have a decent user interface to start fighting. The purpose of this workshop is not to develop a web interface and learn *yet another web framework*. This time you will just execute another Quarkus instance with an already developed and packaged Angular application. If you want to try to build it yourself, you will have optional steps to follow.

#### The Web Application

Navigate to the `super-heroes/ui-super-heroes` directory. It contains the code of the application. Being an Angular application, you will find a `package.json` file which defines all the needed dependencies. All the Angular code (graphical components, model, services) is located under `src/app`. But what’s really important is the packaged application under `src/main/resources/META-INF/resources`.

Notice that there is a `pom.xml` file. This is just a convenient way to install NodeJS and NPM so we can build the Angular application with Maven (optional). The `pom.xml` also allows us to package the Angular application into Quarkus.

|     |     |
| --- | --- |
|     | This service is exposed on the port 8080. |

#### Running the Web Application

Call to action

As usual, use `mvn quarkus:dev` to start the web application.

Be sure you have the hero, villain and fights microservices running (dev mode is enough).

Once the application is started, go to http://localhost:8080 (8080 is the default Quarkus port as we didn’t change it in the `application.properties` this time). It should display the main web page.

<img width="709" height="629" src=":/7dbe37e89a4b49ee814d737c8a1911e0"/>

Oups, not working yet! Not even the pictures, we must have been forgotten something! Let’s move on to the next section then and make the application work.

#### Installing the Web Application on Quarkus (optional)

If you want to build the Angular application yourself, you can follow these optional steps (otherwise just jump to the next section). Thanks to the `frontend-maven-plugin` plugin declared on the `pom.xml`, we can use a good old Maven command to install and build this Angular application.

Call to action

Execute `mvn install -Pbuild-ui` and Maven will download and install Node JS and NPM and build the application. You should now have a `node_modules` directory with all the Angular dependencies.

To install the Angular application into a Quarkus instance, we just build the app and copy the bundles under the `resources/META-INF/resources` directory.

Call to action

Run:

```
export DEST=src/main/resources/META-INF/resources
./node_modules/.bin/ng build --configuration production --base-href "."
rm -Rf ${DEST}
cp -R dist/* ${DEST}
```

You will see all the Javascript files under `resources/META-INF/resources` directory. We are now ready to go.

|     |     |
| --- | --- |
|     | If the `ng` command does not work because it can’t find `node`, there is a little hack to solve it. Open the file `ui-super-heroes/node_modules/.bin/ng` and change the shebang line from `==!/usr/bin/env node==` to `!/usr/bin/env ./node/node`. This way `ng` knows it has to use NodeJS installed under the `ui-super-heroes/node` directory |

### CORS

Cross-origin resource sharing (CORS) is a mechanism that allows restricted resources on a web page to be requested from another domain outside the domain from which the first resource was served.<sup>\[<a id="_footnoteref_24"></a>[24](#_footnotedef_24 "View footnote.")\]</sup> So when we want our heroes and villains to fight, we actually cross several origins: we go from localhost:8080 (the UI) to localhost:8082 (Fight API) which invokes localhost:8083 (Hero) and localhost:8084 (Villain). If you look at the console of your Browser you should see something similar to this:

<img width="709" height="290" src=":/b8bb2735084a4c4e9e1da683caa2676b"/>

Quarkus comes with a CORS filter which intercepts all incoming HTTP requests. It can be enabled in the Quarkus configuration file:

```
quarkus.http.cors=true
```

If the filter is enabled and an HTTP request is identified as cross-origin, the CORS policy and headers defined using the following properties will be applied before passing the request on to its actual target (servlet, JAX-RS resource, etc.):


| Property | Description |
| --- | --- |
| `quarkus.http.cors.origins` | The comma-separated list of origins allowed for CORS. The filter allows any origin if this is not set. |
| `quarkus.http.cors.methods` | The comma-separated list of HTTP methods allowed for CORS. The filter allows any method if this is not set. |
| `quarkus.http.cors.headers` | The comma-separated list of HTTP headers allowed for CORS. The filter allows any header if this is not set. |
| `quarkus.http.cors.exposed-headers` | The comma-separated list of HTTP headers exposed in CORS. |
| `quarkus.http.cors.access-control-max-age` | The duration indicating how long the results of a pre-flight request can be cached. This value will be returned in a Access-Control-Max-Age response header. |

Call to action

So make sure you set the `quarkus.http.cors` property to `true` on the:

1.  Fight microservice,

2.  Hero microservice,

3.  Villain microservice


But, even with this, the UI is still not working. The CORS errors are gone, so that’s a good step, but we forgot something else:

<img width="1418" height="464" src=":/7279440ff5e5481792f09a5f7e09d5a5"/>

Remember the function to retrieve random fighters. We are currently returning `null`. Let’s move to the next session to see how we can implement this method.

## HTTP communication & Fault Tolerance

* * *

So far we’ve built one Fight microservice which need to invoke the Hero and Villain microservices. In the following sections you will develop this invocation thanks to the MicroProfile REST Client. We will also deal with fault tolerance thanks to timeouts and circuit breaker.

<img width="1418" height="868" src=":/b864800b0ea44a4bb0cb3d5fb4a8ffca"/>

### REST Client

This chapter explains how to use the MicroProfile REST Client in order to interact with REST APIs with very little effort.<sup>\[<a id="_footnoteref_25"></a>[25](#_footnotedef_25 "View footnote.")\]</sup>

#### Directory Structure

Remember the structure of the Fight microservice:

![Diagram](:/188686dab94e4985b4a142076d05cfa1)

We are going to rework the:

- `FightService` class

- `FightResourceTest` class

- `application.properties`


#### Installing the Reactive REST Client Dependency

Call to action

To install the Reactive REST Client dependency, just run the following command in the Fight microservice:

```
./mvnw quarkus:add-extension -Dextensions="io.quarkus:quarkus-rest-client-reactive-jackson"
```

This will add the following dependency in the `pom.xml` file:

```
<dependency>
  <groupId>io.quarkus</groupId>
  <artifactId>quarkus-rest-client-reactive-jackson</artifactId>
</dependency>
```

This dependency imports both the reactive rest client implementation and the JSON mapping support (which uses Jackson).

#### FightService Invoking External Microservices

Remember that in the previous sections we left the `FightService.findRandomFighters()` method returns `null`. We have to fix this. What we actually want is to invoke both the Hero and Villain APIs, asking for a random hero and a random villain.

Call to action

For that, replace the `findRandomFighters` method with the following code to the `FightService` class:

```
@RestClient HeroProxy heroProxy;
@RestClient VillainProxy villainProxy;

// ...

Fighters findRandomFighters() {
    Hero hero = findRandomHero();
    Villain villain = findRandomVillain();
    Fighters fighters = new Fighters();
    fighters.hero = hero;
    fighters.villain = villain;
    return fighters;
}

Villain findRandomVillain() {
    return villainProxy.findRandomVillain();
}

Hero findRandomHero() {
   return heroProxy.findRandomHero();
}
```

Note the Rest client injection. They use the `@RestClient` qualifier, i.e. a bean selector. With Quarkus, when you use a qualifier, you can omit `@Inject`.

|     |     |
| --- | --- |
|     | If not done automatically by your IDE, add the following import statement: `import org.eclipse.microprofile.rest.client.inject.RestClient;` |

#### Creating the Interfaces

Using the MicroProfile REST Client is as simple as creating an interface using the proper JAX-RS and MicroProfile annotations.

Call to action

In our case both interfaces should be created under the `client` subpackage and have the following content:

```
package io.quarkus.workshop.superheroes.fight.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/heroes")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient
public interface HeroProxy {

    @GET
    @Path("/random")
    Hero findRandomHero();
}
```

The `findRandomHero` method gives our code the ability to query a random hero from the Hero REST API. The client will handle all the networking and marshalling leaving our code clean of such technical details.

The purpose of the annotations in the code above is the following:

- `@RegisterRestClient` allows Quarkus to know that this interface is meant to be available for CDI injection as a REST Client

- `@Path` and `@GET` are the standard JAX-RS annotations used to define how to access the service

- `@Produces` defines the expected content-type


The `VillainProxy` is very similar and looks like this:

```
package io.quarkus.workshop.superheroes.fight.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/villains")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient
public interface VillainProxy {

    @GET
    @Path("/random")
    Villain findRandomVillain();
}
```

Call to action

Once created, go back to the `FightService` class and add the following import statements:

```
import io.quarkus.workshop.superheroes.fight.client.HeroProxy;
import io.quarkus.workshop.superheroes.fight.client.VillainProxy;
```

#### Configuring REST Client Invocation

Call to action

In order to determine the base URL to which REST calls will be made, the REST Client uses configuration from `application.properties`. The name of the property needs to follow a certain convention which is best displayed in the following code:

```
io.quarkus.workshop.superheroes.fight.client.HeroProxy/mp-rest/url=http://localhost:8083
io.quarkus.workshop.superheroes.fight.client.HeroProxy/mp-rest/scope=javax.inject.Singleton
io.quarkus.workshop.superheroes.fight.client.VillainProxy/mp-rest/url=http://localhost:8084
io.quarkus.workshop.superheroes.fight.client.VillainProxy/mp-rest/scope=javax.inject.Singleton
```

Having this configuration means that all requests performed using `HeroProxy` will use http://localhost:8083 as the base URL. Using this configuration, calling the `findRandomHero` method of `HeroProxy` would result in an HTTP GET request being made to http://localhost:8083/api/heroes/random.

Having this configuration means that the default scope of `HeroProxy` will be `@Singleton`. Supported scope values are `@Singleton`, `@Dependent`, `@ApplicationScoped` and `@RequestScoped`. The default scope is `@Dependent`. The default scope can also be defined on the interface.

Now, go back in the UI and refresh, you should see some pictures!

#### Updating the Test with Mock Support

But, now we have another problem. To run the tests of the Fight API we need the Hero and Villain REST APIs to be up and running. To avoid this, we need to Mock the `HeroProxy` and `VillainProxy` interfaces.

Quarkus supports the use of mock objects using the CDI `@Alternative` mechanism.<sup>\[<a id="_footnoteref_26"></a>[26](#_footnotedef_26 "View footnote.")\]</sup>

Call to action

To use this simply override the bean you wish to mock with a class in the `src/test/java` directory, and put the `@Alternative` and `@Priority(1)` annotations on the bean. Alternatively, a convenient `io.quarkus.test.Mock` stereotype annotation could be used. This built-in stereotype declares `@Alternative`, `@Priority(1)` and `@Dependent`. So, to mock the `HeroProxy` interface we just need to implement the following `MockHeroProxy` class (under the `client` subpackage):

```
package io.quarkus.workshop.superheroes.fight.client;

import io.quarkus.test.Mock;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;

@Mock
@ApplicationScoped
@RestClient
public class MockHeroProxy implements HeroProxy {

    public static final String DEFAULT_HERO_NAME = "Super Baguette";
    public static final String DEFAULT_HERO_PICTURE = "super_baguette.png";
    public static final String DEFAULT_HERO_POWERS = "eats baguette really quickly";
    public static final int DEFAULT_HERO_LEVEL = 42;

    @Override
    public Hero findRandomHero() {
        Hero hero = new Hero();
        hero.name = DEFAULT_HERO_NAME;
        hero.picture = DEFAULT_HERO_PICTURE;
        hero.powers = DEFAULT_HERO_POWERS;
        hero.level = DEFAULT_HERO_LEVEL;
        return hero;
    }
}
```

Call to action

Do the same for the `MockVillainProxy`:

```
package io.quarkus.workshop.superheroes.fight.client;

import io.quarkus.test.Mock;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;

@Mock
@ApplicationScoped
@RestClient
public class MockVillainProxy implements VillainProxy {

    public static final String DEFAULT_VILLAIN_NAME = "Super Chocolatine";
    public static final String DEFAULT_VILLAIN_PICTURE = "super_chocolatine.png";
    public static final String DEFAULT_VILLAIN_POWERS = "does not eat pain au chocolat";
    public static final int DEFAULT_VILLAIN_LEVEL = 42;

    @Override
    public Villain findRandomVillain() {
        Villain villain = new Villain();
        villain.name = DEFAULT_VILLAIN_NAME;
        villain.picture = DEFAULT_VILLAIN_PICTURE;
        villain.powers = DEFAULT_VILLAIN_POWERS;
        villain.level = DEFAULT_VILLAIN_LEVEL;
        return villain;
    }
}
```

Call to action

Finally, edit the `FightResourceTest` and add the following method:

```
//....
@Test
void shouldGetRandomFighters() {
    given()
        .when().get("/api/fights/randomfighters")
        .then()
        .statusCode(OK.getStatusCode())
        .contentType(APPLICATION_JSON)
        .body("hero.name", Is.is(MockHeroProxy.DEFAULT_HERO_NAME))
        .body("hero.picture", Is.is(MockHeroProxy.DEFAULT_HERO_PICTURE))
        .body("hero.level", Is.is(MockHeroProxy.DEFAULT_HERO_LEVEL))
        .body("villain.name", Is.is(MockVillainProxy.DEFAULT_VILLAIN_NAME))
        .body("villain.picture", Is.is(MockVillainProxy.DEFAULT_VILLAIN_PICTURE))
        .body("villain.level", Is.is(MockVillainProxy.DEFAULT_VILLAIN_LEVEL));
}
```

Now, run the test form the dev mode, or from your IDE. You can shutdown the hero and villain services to verify that the tests still pass.

Don’t forger to restart them before going further.

### Fallbacks

So now you’ve been playing this great Super Heroes Fight for a few hours…​ and you kill the Hero REST API. What happens? Well, the Fight REST API cannot invoke the Hero API anymore and breaks with the following exception:

```
Caused by: io.netty.channel.AbstractChannel$AnnotatedConnectException: Connection refused: localhost/127.0.0.1:8083
Caused by: java.net.ConnectException: Connection refused
	at java.base/sun.nio.ch.SocketChannelImpl.checkConnect(Native Method)
	at java.base/sun.nio.ch.SocketChannelImpl.finishConnect(SocketChannelImpl.java:777)
	at io.netty.channel.socket.nio.NioSocketChannel.doFinishConnect(NioSocketChannel.java:330)
	at io.netty.channel.nio.AbstractNioChannel$AbstractNioUnsafe.finishConnect(AbstractNioChannel.java:334)
	at io.netty.channel.nio.NioEventLoop.processSelectedKey(NioEventLoop.java:707)
	at io.netty.channel.nio.NioEventLoop.processSelectedKeysOptimized(NioEventLoop.java:655)
	at io.netty.channel.nio.NioEventLoop.processSelectedKeys(NioEventLoop.java:581)
	at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:493)
	at io.netty.util.concurrent.SingleThreadEventExecutor$4.run(SingleThreadEventExecutor.java:986)
	at io.netty.util.internal.ThreadExecutorMap$2.run(ThreadExecutorMap.java:74)
	at io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30)
	at java.base/java.lang.Thread.run(Thread.java:829)
```

One of the challenges brought by the distributed nature of microservices is that communication with external systems is inherently unreliable. This increases demand on resiliency of applications. To simplify making more resilient applications, Quarkus contains an implementation of the MicroProfile Fault Tolerance specification.<sup>\[<a id="_footnoteref_27"></a>[27](#_footnotedef_27 "View footnote.")\]</sup>

#### Installing the Fault Tolerance Dependency

To install the MicroProfile Fault Tolerance dependency, just run the following command in the Fight microservice:

Call to action

```
./mvnw quarkus:add-extension -Dextensions="smallrye-fault-tolerance"
```

This will add the following dependency in the `pom.xml` file:

```
<dependency>
  <groupId>io.quarkus</groupId>
  <artifactId>quarkus-smallrye-fault-tolerance</artifactId>
</dependency>
```

#### Adding Fallbacks

Let’s make our find random fighters feature better by providing a fallback way of getting a dummy hero or villain in case of failure.

Call to action

For that, add two fallback methods to the `FightService` and a `@Fallback` annotation to both `findRandomHero` and `findRandomVillain` methods as follows:

```
@Fallback(fallbackMethod = "fallbackRandomHero")
Hero findRandomHero() {
    return heroProxy.findRandomHero();
}

@Fallback(fallbackMethod = "fallbackRandomVillain")
Villain findRandomVillain() {
    return villainProxy.findRandomVillain();
}

public Hero fallbackRandomHero() {
    logger.warn("Falling back on Hero");
    Hero hero = new Hero();
    hero.name = "Fallback hero";
    hero.picture = "https://dummyimage.com/280x380/1e8fff/ffffff&text=Fallback+Hero";
    hero.powers = "Fallback hero powers";
    hero.level = 1;
    return hero;
}

public Villain fallbackRandomVillain() {
    logger.warn("Falling back on Villain");
    Villain villain = new Villain();
    villain.name = "Fallback villain";
    villain.picture = "https://dummyimage.com/280x380/b22222/ffffff&text=Fallback+Villain";
    villain.powers = "Fallback villain powers";
    villain.level = 42;
    return villain;
}
```

|     |     |
| --- | --- |
|     | Also add the `import org.eclipse.microprofile.faulttolerance.Fallback;` statement. |

#### Running the Application

Now we are ready to run our application and test the fallbacks.

Call to action

For that, kill the Hero (and/or the Villain API) and start playing again. You should see the following:

<img width="709" height="581" src=":/827a1bc4bc7541ff91f5a78ad8e53495"/>

Restart the Hero REST API…​ and keep on playing. Super-heroes are back to the fight!

### Timeout

Sometimes invoking a REST API can take a long time. In fact, the more microservices invoke other microservices, the more network latency you can have. And what happens when a HTTP request takes long? Well, it hangs. On your browser you can see the request pending if you turn on the dev tools and look at what’s the network is doing.

<img width="709" height="195" src=":/9b0cafb5648a40fa89bac536aa485f1c"/>

#### Adding Timeouts

Getting random fighters can take longer than expected.

Call to action

To simulate a long-running process, add the following code to the `FightResource`:

```
@ConfigProperty(name = "process.milliseconds", defaultValue = "0")
long tooManyMilliseconds;

private void veryLongProcess() {
    try {
        Thread.sleep(tooManyMilliseconds);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }
}

@GET
@Path("/randomfighters")
@Timeout(500) // <-- Added
public Response getRandomFighters() {
    veryLongProcess(); // <-- Added
    Fighters fighters = service.findRandomFighters();
    logger.debug("Get random fighters " + fighters);
    return Response.ok(fighters).build();
}
```

|     |     |
| --- | --- |
|     | Don’t forget to add the following import: `import org.eclipse.microprofile.config.inject.ConfigProperty;` and `import org.eclipse.microprofile.faulttolerance.Timeout;` |

Let’s say we’ve added some new functionality in the `veryLongProcess` method. When the process is really too long and the system is overloaded, we would rather time out.

Call to action

Note that the timeout was configured to 500 ms, and a `Thread.sleep` was introduced and can be configured in the `application.properties`. If we set the property to a higher value than the timeout, let’s say 10.000, then the request should be interrupted.

```
process.milliseconds=10000
```

#### Running the Application

Now that you have set the number of waiting milliseconds to 10.000, run the application and start fighting again. You should see the following:

```
18:40:48 ERROR [or.jb.re.re.co.co.AbstractResteasyReactiveContext] (executor-thread-0) Request failed: org.eclipse.microprofile.faulttolerance.exceptions.TimeoutException: Timeout[io.quarkus.workshop.superheroes.fight.FightResource#getRandomFighters] timed out
	at io.smallrye.faulttolerance.core.timeout.Timeout.timeoutException(Timeout.java:91)
	at io.smallrye.faulttolerance.core.timeout.Timeout.doApply(Timeout.java:78)
	at io.smallrye.faulttolerance.core.timeout.Timeout.apply(Timeout.java:30)
...
```

Call to action

Before going further, set the `process.milliseconds` to 0.

|     |     |
| --- | --- |
|     | If you have any problem with the code, don’t understand or feel you are running, remember to ask for some help. Also, you can get the code of this entire workshop from https://github.com/quarkusio/quarkus-workshops/tree/main/quarkus-workshop-super-heroes. You can also download the completed code from https://raw.githubusercontent.com/quarkusio/quarkus-workshops/main/quarkus-workshop-super-heroes/dist/quarkus-super-heroes-workshop-complete.zip. |

## Event-driven and Reactive microservices

* * *

So far, we have build 3 microservices, all using HTTP to interact. However, HTTP has significant flaws, such as temporal coupling between the different microservices. If the service is not there or is slow, the caller is directly impacted. Also, it’s hard to guess the capacity of the service you call; maybe you should not call it right now because this service is under heavy load.

Fortunately, event-driven microservices are rising and avoid most of these issues. By using events (wrapped in messages), the different microservices enforce a looser coupling. Depending on the messaging protocol you use, it may handle durability (avoiding the temporal coupling) and back-pressure (avoiding the overload).

In this section, we are going to see how Quarkus let you build event-driven microservices. More specially, you are going to see how to:

- Send messages and process them

- Connect a Quarkus application to Apache Kafka

- Write Kafka records and read them

- Use reactive programming to compute statistics on the fly

- Send messages to the browser using web sockets


Quarkus uses MicroProfile Reactive Messaging to interact with Apache Kafka, and other messaging middleware (such as AMQP).<sup>\[<a id="_footnoteref_28"></a>[28](#_footnotedef_28 "View footnote.")\]</sup>

In this chapter, we are going to use events as a way for microservices to interact. You are going to extend the current system with the `stats` group depicted on the next figure:

<img width="1418" height="1304" src=":/646305d70109410b87684b857aa751f8"/>

When the application persists a new fight, in the *fight* microservice, you are going to send it to a Kafka topic. These messages are read in the *statistics* microservice, processed, and the result is sent to a UI using web sockets.

|     |     |
| --- | --- |
|     | This service is exposed on the port 8085. |

### Sending Messages to Kafka

In this section, you are going to see how you can send messages to a Kafka topic.<sup>\[<a id="_footnoteref_29"></a>[29](#_footnotedef_29 "View footnote.")\]</sup>

#### Directory Structure

In this section we are going to extend the **Fight microservice**. In the following tree, we are going to edit the marked classes

![Diagram](:/e386e56225fc4a379390c6548c6cd22a)

#### Adding the Reactive Messaging Dependency

Call to action

The Kafka extension was already imported during the project creation. In doubt, you can run in the Fight microservice:

```
./mvnw quarkus:add-extension -Dextensions=" io.quarkus:quarkus-smallrye-reactive-messaging-kafka"
```

The previous command adds the following dependency:

```
<dependency>
  <groupId>io.quarkus</groupId>
  <artifactId>quarkus-smallrye-reactive-messaging-kafka</artifactId>
</dependency>
```

If not yet started, start the microservice using `mvn quarkus:dev`.

|     |     |
| --- | --- |
|     | Quarkus starts a Kafka broker automatically. |

#### Connecting Imperative and Reactive Using an Emitter

Call to action

Now edit the `FightService` class. First, add the following field:

```
@Channel("fights") Emitter<Fight> emitter;
```

|     |     |
| --- | --- |
|     | You will also need to add the following imports:<br><br>```<br>import org.eclipse.microprofile.reactive.messaging.Channel;<br>import org.eclipse.microprofile.reactive.messaging.Emitter;<br>``` |

This field is an *emitter*, and lets you send events or messages (here, we are sending fights) to the *channel* specified with the `@Channel` annotation. A *channel* is a *virtual* destination.

In the `persistFight` method, add the following line just before the `return` statement:

```
emitter.send(fight).toCompletableFuture().join();
```

With this in place, every time the application persists a `fight`, it also sends the `fight` to the `fights` *channel*. You may wonder why we need `.toCompletableFuture().join()`. Sending a message to Kafka is an asynchronous operation, and we need to be sure that the fight is not accessed outside the transaction. Thus, we wait until Kafka confirms the reception before returning.

#### Connecting to Kafka

At this point, the serialized fights are sent to the `fights` channel. You need to connect this `channel` to a Kafka topic.

Call to action

For this, edit the `application.properties` file and add the following properties:

```
mp.messaging.outgoing.fights.connector=smallrye-kafka
mp.messaging.outgoing.fights.value.serializer=io.quarkus.kafka.client.serialization.ObjectMapperSerializer
```

These properties are structured as follows:

```
mp.messaging.[incoming|outgoing].channel.attribute=value
```

For example, `mp.messaging.outgoing.fights.connector` configures the connector used for the `outgoing` channel `fights`.

The `mp.messaging.outgoing.fights.value.serializer` configures the serializer used to write the message in Kafka. When omitted, the Kafka topic reuses the channel name (`fights`).

Now, you have connected the fight microservice to Kafka, and you are sending new fights to the Kafka topic. Let’s see how you can read these messages in the `stats` microservice.

### Receiving Messages from Kafka

In this section, you are going to see how you can receive messages from a Kafka topic. For this, you are going to create a new microservice, named `stats`. This microservice computes statistics based on the results of the fights. For example, it determines if villains win more battle than heroes, and who is the superhero or super-villain having won the most fights.

#### Directory Structure

In this section, we are going to develop the following structure:

![Diagram](:/bd230499eb004009b6e4dc4acce7b37f)

#### Bootstrapping the Statistics REST Endpoint

Like for the other microservice, the easiest way to create this new Quarkus project is to use a Maven command. Under the `quarkus-workshop-super-heroes/super-heroes` root directory where you have all your code.

Call to action

Open a terminal and run the following command:

```
mvn io.quarkus:quarkus-maven-plugin:2.9.2.Final:create \
    -DprojectGroupId=io.quarkus.workshop.super-heroes \
    -DprojectArtifactId=event-statistics \
    -DclassName="io.quarkus.workshop.superheroes.statistics.StatisticResource" \
    -Dpath="api/stats" \
    -Dextensions="kafka, resteasy-reactive-jackson, websockets"
```

If you want your IDE to manage this new Maven project, you can declare it in the parent POM by adding this new module in the `<modules>` section:

```
<module>super-heroes/event-statistics</module>
```

Call to action

Delete all the classes under the `io.quarkus.workshop.superheroes.statistics` package as well as the associated test classes. There are just examples.

#### Consuming Fight

Call to action

This service receives the `Fight` from the fight microservice. So, naturally, we need a fight class.

Create the `io.quarkus.workshop.superheroes.statistics.Fight` class with the following content:

```
package io.quarkus.workshop.superheroes.statistics;

import java.time.Instant;

public class Fight {

    public Instant fightDate;
    public String winnerName;
    public int winnerLevel;
    public String winnerPicture;
    public String loserName;
    public int loserLevel;
    public String loserPicture;
    public String winnerTeam;
    public String loserTeam;
}
```

We also need to a deserializer that will receive the Kafka record and create the `Fight` instances. Create the `io.quarkus.workshop.superheroes.statistics.FightDeserializer` class with the following content:

```
package io.quarkus.workshop.superheroes.statistics;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class FightDeserializer extends ObjectMapperDeserializer<Fight> {

    public FightDeserializer() {
        super(Fight.class);
    }
}
```

#### Computing Statistics

Call to action

Now, create the `io.quarkus.workshop.superheroes.statistics.SuperStats` class with the following content. This class contains two methods annotated with `@Incoming` and `@Outgoing`, both consuming the `Fight` coming from Kafka.

The `computeTeamStats` method transforms the fight stream into a stream of ratio indicating the amount of victories for heroes and villains. It calls `onItem().transform` method for each received fight. It sends the computed ratios on the channel `team-stats`.

The `computeTopWinners` method uses more advanced reactive programming constructs such as `group` and `scan`:

```
package io.quarkus.workshop.superheroes.statistics;

import io.smallrye.mutiny.Multi;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class SuperStats {

    @Inject
    Logger logger;

    private final Ranking topWinners = new Ranking(10);
    private final TeamStats stats = new TeamStats();

    @Incoming("fights")
    @Outgoing("team-stats")
    public Multi<Double> computeTeamStats(Multi<Fight> results) {
        return results
            .onItem().transform(stats::add)
            .invoke(() -> logger.info("Fight received. Computed the team statistics"));
    }

    @Incoming("fights")
    @Outgoing("winner-stats")
    public Multi<Iterable<Score>> computeTopWinners(Multi<Fight> results) {
        return results
            .group().by(fight -> fight.winnerName)
            .onItem().transformToMultiAndMerge(group ->
                group
                    .onItem().scan(Score::new, this::incrementScore))
            .onItem().transform(topWinners::onNewScore)
            .invoke(() -> logger.info("Fight received. Computed the top winners"));
    }

    private Score incrementScore(Score score, Fight fight) {
        score.name = fight.winnerName;
        score.score = score.score + 1;
        return score;
    }

}
```

Call to action

In addition, create the `io.quarkus.workshop.superheroes.statistics.Ranking`, `io.quarkus.workshop.superheroes.statistics.Score` and `io.quarkus.workshop.superheroes.statistics.TeamStats` classes with the following contents:

Then, create the `Ranking` class, used to compute a floating top 10, with the following content:

```
package io.quarkus.workshop.superheroes.statistics;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Ranking {

    private final int max;

    private final Comparator<Score> comparator = Comparator.comparingInt(s -> -1 * s.score);

    private final LinkedList<Score> top = new LinkedList<>();

    public Ranking(int size) {
        max = size;
    }

    public Iterable<Score> onNewScore(Score score) {
        // Remove score if already present,
        top.removeIf(s -> s.name.equalsIgnoreCase(score.name));
        // Add the score
        top.add(score);
        // Sort
        top.sort(comparator);

        // Drop on overflow
        if (top.size() > max) {
            top.remove(top.getLast());
        }

        return Collections.unmodifiableList(top);
    }
}
```

The `Score` class is a simple structure storing the name of a hero or villain and its actual score, *i.e.* the number of won battles.

```
package io.quarkus.workshop.superheroes.statistics;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class Score {
    public String name;
    public int score;

    public Score() {
        this.score = 0;
    }
}
```

The `TeamStats` class is an object keeping track of the number of battles won by heroes and villains.

```
package io.quarkus.workshop.superheroes.statistics;

class TeamStats {

    private int villains = 0;
    private int heroes = 0;

    double add(Fight result) {
        if (result.winnerTeam.equalsIgnoreCase("heroes")) {
            heroes = heroes + 1;
        } else {
            villains = villains + 1;
        }
        return ((double) heroes / (heroes + villains));
    }

}
```

|     |     |
| --- | --- |
|     | The `@RegisterForReflection` annotation instructs the native compilation to allow reflection access to the class. Without, the serialization/deserialization would not work when running the native executable. |

#### Reading Messages from Kafka

It’s now time to connect the `fights` channel with the Kafka topic.

Call to action

Edit the `application.properties` file and add the following content:

```
quarkus.http.port=8085

## Kafka configuration
mp.messaging.incoming.fights.connector=smallrye-kafka
mp.messaging.incoming.fights.auto.offset.reset=earliest
mp.messaging.incoming.fights.broadcast=true
```

As for the writing side, it configures the Kafka connector. The `mp.messaging.incoming.fights.auto.offset.reset=earliest` property indicates that the topic is read from the earliest available record. Check the Kafka configuration to see all the available settings.

### Sending Events on WebSockets

At this point, you read the *fights* from Kafka and computes statistics. Actually, even if you start the application, nothing will happen as nobody consumes these statistics.

In this section, we are going to consume these statistics and send them to two WebSockets. For this, we are going to add two classes and a simple presentation page:

- `TeamStatsWebSocket`

- `TopWinnerWebSocket`

- `index.html`


Quarkus uses the [JSR 356](http://jcp.org/en/jsr/detail?id=356) providing an annotation-driven approach to implement WebSockets.

#### The TeamStats WebSocket

Call to action

Create the `io.quarkus.workshop.superheroes.statistics.TeamStatsWebSocket` class with the following content:

```
package io.quarkus.workshop.superheroes.statistics;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.subscription.Cancellable;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.jboss.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@ServerEndpoint("/stats/team")
@ApplicationScoped
public class TeamStatsWebSocket {

    @Channel("team-stats")
    Multi<Double> stream;

    @Inject Logger logger;

    private final List<Session> sessions = new CopyOnWriteArrayList<>();
    private Cancellable cancellable;

    @OnOpen
    public void onOpen(Session session) {
        sessions.add(session);
    }

    @OnClose
    public void onClose(Session session) {
        sessions.remove(session);
    }

    @PostConstruct
    public void subscribe() {
        cancellable = stream.subscribe()
            .with(ratio -> sessions.forEach(session -> write(session, ratio)));
    }

    @PreDestroy
    public void cleanup() {
        cancellable.cancel();
    }

    private void write(Session session, double ratio) {
        session.getAsyncRemote().sendText(Double.toString(ratio), result -> {
            if (result.getException() != null) {
                logger.error("Unable to write message to web socket", result.getException());
            }
        });
    }
}
```

This component is a WebSocket as specified by the `@ServerEndpoint("/stats/team")` annotation. It handles the `/stats/team` WebSocket.

When a client (like a browser) connects to the WebSocket, it keeps track of the session. This session is released when the client disconnects.

The `TeamStatsWebSocket` also injects a `Multi` attached to the `team-stats` channel. After creation, the component subscribes to this stream and broadcasts the fights to the different clients connected to the web socket.

The *subscription* is an essential part of the stream lifecycle. It indicates that someone is interested in the items transiting on the stream, and it triggers the emission. In this case, it triggers the connection to Kafka and starts receiving the messages from Kafka. Without it, items would not be emitted.

#### The TopWinner WebSocket

The `io.quarkus.workshop.superheroes.statistics.TopWinnerWebSocket` follows the same pattern but subscribes to the `winner-stats` channel.

Call to action

Creates the `io.quarkus.workshop.superheroes.statistics.TopWinnerWebSocket` with the following content:

```
package io.quarkus.workshop.superheroes.statistics;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.subscription.Cancellable;
import io.smallrye.mutiny.unchecked.Unchecked;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.jboss.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@ServerEndpoint("/stats/winners")
@ApplicationScoped
public class TopWinnerWebSocket {

    @Inject ObjectMapper mapper;

    @Inject Logger logger;

    @Channel("winner-stats")
    Multi<Iterable<Score>> winners;

    private final List<Session> sessions = new CopyOnWriteArrayList<>();
    private Cancellable cancellable;

    @OnOpen
    public void onOpen(Session session) {
        sessions.add(session);
    }

    @OnClose
    public void onClose(Session session) {
        sessions.remove(session);
    }

    @PostConstruct
    public void subscribe() {
        cancellable = winners
            .map(Unchecked.function(scores -> mapper.writeValueAsString(scores)))
            .subscribe().with(serialized -> sessions.forEach(session -> write(session, serialized)));
    }

    @PreDestroy
    public void cleanup() {
        cancellable.cancel();
    }

    private void write(Session session, String serialized) {
        session.getAsyncRemote().sendText(serialized, result -> {
            if (result.getException() != null) {
                logger.error("Unable to write message to web socket", result.getException());
            }
        });
    }
}
```

Because the items (top 10) need to be serialized, the `TopWinnerWebSocket` also use Jackson to transform the object into a serialized form.

#### The UI

Finally, you need a UI to watch these live statistics.

Call to action

Replace the `META-INF/resources/index.html` file with the following content:

```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Super Battle Stats</title>

    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/patternfly/3.24.0/css/patternfly.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/patternfly/3.24.0/css/patternfly-additions.min.css">

    <style> .page-title {
            font-size: xx-large;
        }

        .progress {
            background-color: firebrick;
        }

        .progress-bar {
            background: dodgerblue;
        } </style>
</head>
<body>
<div class="container">
<div class="row">
    <div class="col"><h1 class="page-title">Super Stats</h1></div>
</div>
</div>
<div class="container container-cards-pf">
    <div class="row row-cards-pf">
        <div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
            <!-- Top winners -->
            <div class="card-pf card-pf-view card-pf-view-select">
                <h2 class="card-pf-title">
                    <i class="fa fa-trophy"></i> Top Winner
                </h2>
                <div class="card-pf-body">
                    <div id="top-winner">

                    </div>
                </div>
            </div>
        </div>

        <div class="col-xs-12 col-sm-8 col-md-6 col-lg-6">
            <!-- Top losers -->
            <div class="card-pf card-pf-view card-pf-view-select">
                <h2 class="card-pf-title">
                    <i class="fa pficon-rebalance"></i> Heroes vs. Villains
                </h2>
                <div class="card-pf-body">
                    <div class="progress-container progress-description-left progress-label-right">
                        <div class="progress-description">
                            Heroes
                        </div>
                        <div class="progress">
                            <div id="balance" class="progress-bar" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width: 50%;">
                                <span>Villains</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/patternfly/3.24.0/js/patternfly.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/c3/0.7.11/c3.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/d3/5.12.0/d3.min.js"></script>

<script> $(document).ready(function() {
        var host = window.location.host;

        var top = new WebSocket("ws://" + host + "/stats/winners");
        top.onmessage = function (event) {
            updateTop(event.data);
        };
        var team = new WebSocket("ws://" + host + "/stats/team");
        team.onmessage = function(event) {
            console.log(event.data);
            updateRatio(event.data);
        };
    });


    function updateTop(scores) {
        $("#top-winner").children("p").remove();
        JSON.parse(scores).forEach(function(score) {
            $("#top-winner").append($("<p>" + score.name + " [" + score.score + "]</p>"))
        });
    }

    function updateRatio(ratio) {
        var percent = ratio * 100;
        $("#balance").attr("aria-valuenow", ratio * 100).attr("style", "width: " + percent + "%;");
    } </script>
</body>
</html>
```

#### Running the Application

You are all set!

Call to action

Time to start the application using:

```
mvn quarkus:dev
```

Then, open `http://localhost:8085` in a new browser window. Trigger some fights, and you should see the live statistics moving.

Quarkus automatically reuse the Kafka broker from the fight service. So, make sure the fight service is started.

|     |     |
| --- | --- |
|     | If you have any problem with the code, don’t understand or feel you are running, remember to ask for some help. Also, you can get the code of this entire workshop from https://github.com/quarkusio/quarkus-workshops/tree/main/quarkus-workshop-super-heroes. You can also download the completed code from https://raw.githubusercontent.com/quarkusio/quarkus-workshops/main/quarkus-workshop-super-heroes/dist/quarkus-super-heroes-workshop-complete.zip. |

### Unifying Imperative and Reactive Programming

So, as seen in this chapter, Quarkus is not limited to HTTP microservices, but fits perfectly in an event-driven architecture. The secret behind this is to use a single reactive engine for both imperative and reactive code:

<img width="1418" height="242" src=":/ee91a3e14dda473eae16799d6a5022c7"/>

This unique architecture allows mixing imperative and reactive, but also use the right *model* for the job. To go further on this, we recommend:

- https://quarkus.io/guides/reactive-routes-guide to use reactive routes

- https://quarkus.io/guides/reactive-sql-clients to access SQL database in a non-blocking fashion

- https://quarkus.io/guides/kafka-guide to integrate with Kafka

- https://quarkus.io/guides/amqp-guide to integrate with AMQP 1.0

- https://quarkus.io/guides/using-vertx to understand how you can use Vert.x directly


## Observability

* * *

Now that we have several microservices, observing them starts to be a bit tricky: we can’t just look at the logs of all the microservices to see if they are up and running or behaving correctly. In the following sections you will add health checks and several metrics to the Fight, Hero and Villain APIs and gather them within Promotheus.

<img width="1418" height="1411" src=":/919710716c41429b9ffd354397bb0d19"/>

In the following sections, you will learn how to:

- Add health checks to our microservices


### Health Check

Quarkus applications can utilize the MicroProfile Health specification through the SmallRye Health extension. The MicroProfile Health allows applications to provide information about their state to external viewers which is typically useful in cloud environments where automated processes must be able to determine whether the application should be discarded or restarted.<sup>\[<a id="_footnoteref_30"></a>[30](#_footnotedef_30 "View footnote.")\]</sup>

#### Directory Structure

In this module we will add an extra subdirectory with two classes to handle the Health Check. You will end-up with the following directory structure:

![Diagram](:/7727360b0cc84af4b6fa92471bcb51b2)

While you could add health checks to all our microservices, we are focusing on the **Hero microservice**. So don’t forget to switch to the Hero microservice code. You can apply the same to the other microservices.

#### Installing the Health Dependency

Call to action

To install the MicroProfile Health dependency, just run the following command:

```
./mvnw quarkus:add-extension -Dextensions="smallrye-health"
```

This will add the following dependency in the `pom.xml` file:

```
<dependency>
  <groupId>io.quarkus</groupId>
  <artifactId>quarkus-smallrye-health</artifactId>
</dependency>
```

#### Running the Default Health Check

Importing the `smallrye-health` extension directly exposes three REST endpoints:

- `/q/health/live` \- The application is up and running.

- `/q/health/ready` \- The application is ready to serve requests.

- `/q/health` \- Accumulating all health check procedures in the application.

- `/q/health-ui` \- Graphical interface of all the checks.


To check that the `smallrye-health` extension is working as expected, access using your browser or cURL:

- http://localhost:8083/q/health/live

- http://localhost:8083/q/health/ready

- http://localhost:8083/q/health


All of the health REST endpoints return a simple JSON object with two fields:

- `status`: the overall result of all the health check procedures

- `checks`: an array of individual checks (each check has a `name`, `status` and optional `data`)


The general `status` of the health check is computed as a logical AND of all the declared health check procedures. The JSON output looks like this:

```
{
  "status": "UP",
  "checks": [
    {
      "name": "SmallRye Reactive Messaging - liveness check",
      "status": "UP",
      "data": {
        "fights": "[OK]"
      }
    },
    {
      "name": "Database connections health check",
      "status": "UP"
    }
  ]
}
```

You can also have a nicer graphical representation by going to `/q/health-ui`. If you check the health of our microservices, you will notice that Quarkus had automatically defined common health checks. But let’s define some specific to our microservices.

#### Adding Liveness

To check that our Hero API application is live, we can check that the `HeroResource.hello()` method works.

Call to action

For that, this is the `PingHeroResourceHealthCheck` class that we can write under the `io.quarkus.workshop.superheroes.hero.health` sub-package:

```
package io.quarkus.workshop.superheroes.hero.health;

import io.quarkus.workshop.superheroes.hero.HeroResource;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

import javax.inject.Inject;

@Liveness
public class PingHeroResourceHealthCheck implements HealthCheck {

    @Inject
    HeroResource heroResource;

    @Override
    public HealthCheckResponse call() {
        String response = heroResource.hello();
        return HealthCheckResponse.named("Ping Hero REST Endpoint").withData("Response", response).up().build();
    }
}
```

As you can see health check procedures are defined as implementations of the `HealthCheck` interface which are defined as CDI beans with the CDI qualifier `@Liveness`. The liveness check accessible at `/q/health/live`. `HealthCheck` is a functional interface whose single method `call` returns a `HealthCheckResponse` object which can be easily constructed by the fluent builder API shown in the example.

Call to action

As we have started our Quarkus application in dev mode simply repeat the request to http://localhost:8083/q/health/live by refreshing your browser window or by using curl http://localhost:8083/q/health/live. Because we defined our health check to be a liveness procedure (with `@Liveness` qualifier) the new health check procedure is now present in the checks array.

```
{
  "status": "UP",
  "checks": [
    {
      "name": "Ping Hero REST Endpoint",
      "status": "UP",
      "data": {
        "Response": "Hello Hero Resource"
      }
    }
  ]
}
```

|     |     |
| --- | --- |
|     | Here we’ve just shown you the health check for the Hero API, but you should do the same for Fight and Villain. Create a `PingVillainResourceHealthCheck` for the Villain microservice (under `io.quarkus.workshop.superheroes.villain.health` sub-package) and a `PingFightResourceHealthCheck` based on the same logic. |

## Writing a Quarkus Extension

* * *

Most of the Quarkus magic happens inside extensions. The goal of an extension is to compute *just enough bytecode* to start the services that the application requires and drop everything else.

So, when writing an extension, you need to distinguish the action that:

- Can be done at build time - following the build time principle of Quarkus

- Must be done at runtime


Because of this distinction, extensions are divided into two parts: a build time augmentation and a runtime. The augmentation part is responsible for all the metadata processing, annotation scanning, XML parsing…​ The output of this augmentation is **recorded bytecode**, which, then, is executed at runtime to instantiate the relevant services.

In this chapter, you are going to implement a *version* extension. It prints the version of the application in the log of the application when this application starts. It is a straightforward application, but it highlights the distinction between build time and runtime. Instead of extracting the version at runtime and printing it, we find the version at build time and record the print instruction to when the application starts it prints the version.

### The extension framework

Quarkus’s mission is to transform your entire application, including the libraries it uses, into an artifact that uses significantly fewer resources than traditional approaches. These can then be used to build JVM applications and native executables using the GraalVM `native-image` compiler.

To do this, you need to analyze and understand the application’s "closed world". Without the full context, the best that can be achieved is partial and limited generic support.

To build an extension, Quarkus provides a framework to:

- Read the configuration from the `application.properties` file and map it to objects,

- Read metadata from classes without having to load them; this includes classpath and annotation scanning,

- Generate bytecode if needed (for proxies, for instance),

- Pass sensible defaults to the application,

- Make the application compatible with GraalVM (resources, reflection, substitutions),

- Implement hot-reload


### Structure of an extension

As stated above, an extension is divided into two parts, called `deployment` (augmentation) and `runtime`.

<img width="1418" height="249" src=":/b5b533ef78c84e98b992935aabfdfbdf"/>

Call to action

From the directory `super-heroes` execute the following commands:

```
mvn io.quarkus.platform:quarkus-maven-plugin:2.9.2.Final:create-extension -N \
    -DwithoutTests \
    -DextensionId=extension-version \
    -DgroupId=io.quarkus.workshop.super-heroes \
    -DpackageName=io.quarkus.workshop.superheroes.version
```

This command creates the structure for the banner extension:

- One parent `pom.xml` importing the `quarkus-bom`

- A module for the runtime

- A module for the deployment, with a dependency on the runtime artifact


The final structure of the extension developed in this section is the following:

![Diagram](:/8c2f1438aa4c40b8ae925bc65bf4b46d)

### The version extension

The goal of this chapter is to implement an extension that displays the application version on startup. For this, what do we need:

1.  A way to extract the version (we’re lucky, Quarkus provided it)

2.  Some code that would print the version when the application starts; so some runtime code,

3.  Some build steps that extracts the version and records the runtime invocations


### The runtime module

The *runtime* part of an extension contains only the classes and resources required at runtime. For the version extension, it would be a single class that prints the version.

Call to action

In the runtime module, create the `src/main/java` directory, and, in this directory, the `io.quarkus.workshop.superheroes.version.runtime.VersionRecorder` class with the following content:

```
package io.quarkus.workshop.superheroes.version.runtime;

import io.quarkus.runtime.annotations.Recorder;
import org.jboss.logging.Logger;

@Recorder
public class VersionRecorder {

    public void printVersion(String version) {
        Logger.getLogger(VersionRecorder.class.getName()).infof("Version: %s", version);
    }

}
```

Simple right? But how does it work? Look at the `@Recorder` annotation. It indicates that this class is a *recorder* used to record actions executed later at runtime. Indeed, these actions are replayed at runtime. We will see how this recorder is used from the *deployment* module.

### The deployment module

This module contains *build steps*, i.e., methods called during the augmentation phase and computing just enough bytecode to serve the services the application requires. The version extension consists of a single build step that extracts the version and uses the `VersionRecorder`.

Call to action

First, let’s create the configuration class that will allow users to dynamically configure whether the version should be printed:

Create new class `io.quarkus.workshop.superheroes.version.deployment.VersionConfig` with the following content:

```
package io.quarkus.workshop.superheroes.version.deployment;

import io.quarkus.runtime.annotations.ConfigItem;
import io.quarkus.runtime.annotations.ConfigRoot;

@ConfigRoot(name = "version")
public class VersionConfig {

    /**
     * Enables or disables the version printing at startup.
     */
    @ConfigItem(defaultValue = "true")
    boolean enabled;
}
```

The `@ConfigRoot` annotation declares `VersionConfig` as a configuration class which configuration properties are prefixed with `quarkus.` prefix.

The `@ConfigItem` is used to declare individual configuration properties. By default, the name of the property is derived from the name of the field. In our case, the user-configured property will be `quarkus.version.enabled`.

Next, open the `ExtensionVersionProcessor` class, and update the content to be:

```
package io.quarkus.workshop.superheroes.version.deployment;

import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.annotations.ExecutionTime;
import io.quarkus.deployment.annotations.Record;
import io.quarkus.deployment.builditem.ApplicationInfoBuildItem;
import io.quarkus.deployment.builditem.FeatureBuildItem;
import io.quarkus.workshop.superheroes.version.runtime.VersionRecorder;

class ExtensionVersionProcessor {

    private static final String FEATURE = "extension-version";

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }

    @BuildStep
    @Record(ExecutionTime.RUNTIME_INIT)
    void recordVersion(ApplicationInfoBuildItem app, VersionConfig versionConfig, VersionRecorder recorder) {
        if (versionConfig.enabled) {
            recorder.printVersion(app.getVersion());
        }
    }
}
```

This class is the core of the extension. It contains a set of methods annotated with `@BuildStep`.

The command generated the first one we used to set up the project. It just produces a `FeatureBuildItem`. When the application starts, Quarkus lists the enabled features. So, when this extension is present, `extension-version` will be printed.

The `recordVersion` method is responsible for recording the actions that will happen at runtime. In addition to the `@BuildStep` annotation, it also has the `@Record` annotation allowing to receive a *recorder* object (`VersionRecorder`) and indicating when the recorded bytecode is replayed. Here we are replaying during the runtime initialization, *i.e.,* equivalent to the `public static void main(String…​ args)` method.

The method also receives the `ApplicationInfoBuildItem`. Quarkus provides many *build items* which can be reused. `ApplicationInfoBuildItem` contains the version.

The last parameter of the `recordVersion` method is the `VersionConfig` which provides access to the user configuration we created in the previous step.

The code is straightforward: if `enabled` is `true`, the code calls the recorder which prints the version.

|     |     |
| --- | --- |
|     | Recorder at deployment time<br><br>At deployment time, proxies of recorders are injected into `@BuildStep` methods that have been annotated with `@Record`. Any invocations made on these proxies will be recorded, and bytecode will be written out to be executed at runtime to make the same sequence of invocations with the same parameters on the actual recorder objects. |

### Packaging the extension

Call to action

From the root directory of the extension, run:

```
mvn clean install
```

### Using the extension

Call to action

Go back to the *villain* microservice, and add the following dependency to the `pom.xml` file:

```
<dependency>
  <groupId>io.quarkus.workshop.super-heroes</groupId>
  <artifactId>extension-version</artifactId>
  <version>1.0.0-SNAPSHOT</version>
</dependency>
```

If not yet started, start the microservice with:

```
./mvnw quarkus:dev
```

And the version will be displayed:

```
10:16:58 INFO  [io.qu.wo.su.ve.ru.VersionRecorder] (Quarkus Main Thread) Version: 1.0.0-SNAPSHOT
...
10:17:00 INFO  [io.quarkus] (Quarkus Main Thread) Installed features: [agroal, cdi, extension-version, hibernate-orm, hibernate-orm-panache, hibernate-validator, jdbc-postgresql, narayana-jta, resteasy-reactive, resteasy-reactive-jackson, smallrye-context-propagation, smallrye-health, smallrye-openapi, swagger-ui, vertx]
```

### Conclusion

In this section, you have seen how to develop a simple extension for Quarkus. Quarkus offers a complete toolbox to implement extensions, from configuration support, tests, bytecode generation…​ The mindset to implement an extension is crucial. The distinction between build time and runtime is what makes Quarkus so efficient. To go further, check https://quarkus.io/guides/extension-authors-guide.

## Conclusion

* * *

This is the end of the Super Hero workshop. We hope you liked it, learnt a few things, and more importantly, will be able to take this knowledge back to your projects.

This workshop started making sure your development environment was ready to develop the entire application. Then, there was some brief terminology to help you in understanding some concepts around Quarkus. If you find it was too short and need more details on Quarkus, Microservices, MicroProfile, Cloud Native, or GraalVM, check the Quarkus website for more references.<sup>\[<a id="_footnoteref_31"></a>[31](#_footnotedef_31 "View footnote.")\]</sup>

Then, we focused on developing several isolated microservices. Some written in pure JAX-RS (such as the Villain) others with Reactive JAX-RS and Reactive Hibernate (such as the Hero). These microservices return data in JSON, validate data thanks to Bean Validation, store and retrieve data from a relational database with the help of JPA, Panache and JTA.

You then installed an already coded Angular application on another instance of Quarkus. At this stage, the Angular application couldn’t access the microservices because of CORS issues that we quickly fixed.

Then, we made the microservices communicate with each other in HTTP thanks to REST Client. But HTTP-related technologies usually use synchronous communication and therefore need to deal with invocation failure. With Fault Tolerance, it was just a matter of using a few annotations and we can get some fallback when the communication fails.

That’s also why we introduced Reactive Messaging with Kafka: so we don’t have a temporal coupling between the microservices.

Remember that you can find all the code for this fascicle at https://github.com/quarkusio/quarkus-workshops/tree/main/quarkus-workshop-super-heroes. If some parts were not clear enough, or if you found something missing, a bug, or you just want to leave a note or suggestion, please use the GitHub issue tracker at https://github.com/quarkusio/quarkus-workshops/issues.

### References

- https://quarkus.io/quarkus-workshops/super-heroes

- https://github.com/cescoffier/quarkus-todo-app

- https://github.com/agoncal/baking-microservice-pie

- https://forge.jboss.org/document/hands-on-lab

- https://bit.ly/forge-hol

- https://quarkus.io

- https://code.quarkus.io

- https://quarkus.io/guides/all-config


* * *

[1](#_footnoteref_1). Java http://www.oracle.com/technetwork/java/javase

[2](#_footnoteref_2). Visual VM https://visualvm.github.io

[3](#_footnoteref_3). Homebrew https://brew.sh

[4](#_footnoteref_4). GraalVM https://www.graalvm.org

[5](#_footnoteref_5). GraalVM Download https://github.com/graalvm/graalvm-ce-builds/releases/tag/vm-22.0

[6](#_footnoteref_6). Maven https://maven.apache.org

[7](#_footnoteref_7). Maven Central https://search.maven.org

[8](#_footnoteref_8). cURL https://curl.haxx.se

[9](#_footnoteref_9). Homebrew https://brew.sh

[10](#_footnoteref_10). cURL commands https://ec.haxx.se/cmdline.html

[11](#_footnoteref_11). jq https://stedolan.github.io/jq

[12](#_footnoteref_12). Docker commands https://docs.docker.com/engine/reference/commandline/cli

[13](#_footnoteref_13). Docker commands https://docs.docker.com/engine/reference/commandline/cli

[14](#_footnoteref_14). RESTEasy Reactive support the reactive and imperative development models.

[15](#_footnoteref_15). RestAssured http://rest-assured.io

[16](#_footnoteref_16). Panache https://quarkus.io/guides/hibernate-orm-panache

[17](#_footnoteref_17). ArC https://github.com/quarkusio/quarkus/tree/master/independent-projects/arc

[18](#_footnoteref_18). Quarkus - Contexts and Dependency Injection https://quarkus.io/guides/cdi-reference.html

[19](#_footnoteref_19). Agroal https://agroal.github.io

[20](#_footnoteref_20). Microprofile Config https://microprofile.io/project/eclipse/microprofile-config

[21](#_footnoteref_21). MicroProfile OpenAPI https://github.com/eclipse/microprofile-open-api

[22](#_footnoteref_22). Also called Ahead-of-Time Compilation https://www.graalvm.org/docs/reference-manual/native-image

[23](#_footnoteref_23). There is another structure `Multi` to represent asynchronous streams of items. We will see `Multi` examples later

[24](#_footnoteref_24). CORS [https://en.wikipedia.org/wiki/Cross-origin\_resource\_sharing](https://en.wikipedia.org/wiki/Cross-origin_resource_sharing)

[25](#_footnoteref_25). MicroProfile REST Client https://github.com/eclipse/microprofile-rest-client

[26](#_footnoteref_26). Alternatives https://docs.jboss.org/weld/reference/latest/en-US/html/beanscdi.html#_alternatives

[27](#_footnoteref_27). MicroProfile Fault Tolerance https://github.com/eclipse/microprofile-fault-tolerance

[28](#_footnoteref_28). MicroProfile Reactive Messaging https://github.com/eclipse/microprofile-reactive-messaging

[29](#_footnoteref_29). Kafka Topic https://kafka.apache.org/intro#intro_topics

[30](#_footnoteref_30). MicroProfile Health https://microprofile.io/project/eclipse/microprofile-health

[31](#_footnoteref_31). Quarkus https://quarkus.io

Version 2.0
Last updated 2022-08-19 06:18:34 UTC