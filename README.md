# JavaRMI

Some examples about RMI in JAVA

Step1:

Create a remote interface: 

+ Must be public and must extends from the interface named Remote
Declare functions that will be called remotely. 
+ Functions must be throwing a RemoteException

Step2:

Create a remote interface implementation class and main() function

Step3:

Creates stub and skeleton classes using the "mic" command

Step4:

Copy the remote interface and the stub file generated to the client.

Step5:

Initialize the Remote Registry Server using the "start rmiregistry" command

Step6:

Execute!