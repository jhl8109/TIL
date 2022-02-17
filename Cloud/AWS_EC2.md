# EC2

### What is Amazon EC2?

Amazon EC2 is a web service that provides, resizable compute capacity in the cloud. 
In order to create an EC2 instance, I need to define:
* Hardware specifications, like CPU, memory, network, and storage.
* Logical confugurations like networking location, firewall rules, authentication, and the operation system of choice.

When launching an EC2 instance, the first setting I configure is which operation system I want by selecting an Amazon MAchine Image(AMI).
AMI is already built that I choose instead of installing an operation system.

### Relation between AMIs and EC2

EC2 instances are live instatiations of what is defined in an AMI, much like a cake is alive instatiation of a cake recipe. It seems like a kind of relationship between a Class and an Object.

Ond advatage of using AMIs is that they are reusable.
If i wanted to create a second EC2 instance with the same configureations, I can create an AMI from my running instance and use this AMI to start a new instance.


