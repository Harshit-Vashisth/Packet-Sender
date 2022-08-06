#                **Packet-Sender**
![packetfinal1](https://user-images.githubusercontent.com/109802813/183125668-6b5a77db-0e8a-46af-b1c9-b362418466f3.jpg)

Packet Sender is an open source utility to allow sending and receiving UDP, TCP packets and panel generation(In Java).<br>
The mainline branch officially supports Windows and  Desktop Linux (with Qt). Packet Sender comes with a built-in TCP, UDP, on multiple ports a user specifies. This remains running listening for packets while sending other packets. Packet Sender is free It can be used for both commercial and personal use. If you find the app useful, please consider donating/sponsoring so development may continue.

#   **CONTENTS**

## •INTRODUCTION<br >
   1.1 Purpose<br>
   1.2 Objective<br>
   1.3 Definition<br>
   1.4 Theory<br>
   
## •PROJECT DESIGN<br>
 	2.1 Project Perspective<br>
 	2.2 Project Functions<br>
	2.3 Flowchart<br>

## •IMPLEMENTATION<br>
  3.1    Main GUI<br>
       •	  1st box <br>
       •	  2nd box<br>
       •	  3rd box<br>
       •	  4th box<br>
       •	  5th box<br>
	3.2   Intense Traffic Generator (ITG)<br>
	3.3   New Message with ITG<br>
	3.4   Message receive from Chat Bot<br>
<br>
# Introduction<br><br>
###  Purpose:<br>
In today's life, networks are playing a very important role in telecommunication. Without the network, almost all types of communication and service are useless.Hence, this makes the network concept more important for all programmers and network administrators.<br>

To maintain and manage the security of network communication, many times network administrators or network maintainers need to find and control the traffic flowing into the network wire and also find exactly what and which types of data packets are actually flowing in the Networks. For this situation, there are many types of Network analyzing tools available on the internet.  Basically, these types of tools come on the ground to help network administrators.<br>

When any data has to be transmitted over the computer network, it is broken down into smaller units at the sender’s node called data packets and reassembled at the receiver’s node in its original format. It is the smallest unit of communication over a computer network. It is also called a block, a segment, a datagram, or a cell. The main aim is to transfer these data packets from the sender to the receiver in a graphical user interface.<br>
<br>
###   Objective:<br>
Every client interacts with the server through sending and receiving various types of data Packets like TCP, UDP, etc. so, the main objective of our program is going to do the sending and receiving of packets and then analyze and represent those packets in an easy and understandable manner and if some pattern matches with the pattern already defined receiver side will reply back to the sender side.<br>
### 	Definition:<br>
Packet Sender is an open-source utility to allow sending and receiving UDP, TCP, and SSL. The mainline branch officially supports Windows, Mac, and Desktop Linux(with Qt). Some typical applications of Packet Sender include:<br>
•	Video calling feature can be done with the help of UDP .<br>
•	Troubleshooting network devices that use network servers (send a packet and then analyze the response)<br>
•	Troubleshooting network devices that use network clients (devices that "phone home" via UDP, TCP—Packet Sender can capture these requests)<br>
•	Testing and development of new network protocols (send a packet, see if device behaves appropriately)<br>
•	Automation (via Packet Sender's command-line interface or resend feature)<br>
•	Stress-testing a device (using an intense network generator tool)<br>
•	Sharing/Saving/Collaboration using the Packet Sender Cloud service<br>
Packet Sender comes with a built-in TCP, UDP, on multiple ports a user specifies. This remains running listening for packets while sending other packets.<br>
  <br>
 ## 	 Theory: <br>
### OSI Layers: <br>
The Open Systems Interconnection (OSI) model describes seven layers that computer systems use to communicate over a network. The OSI 7-layer model is still widely used, as it helps visualize and communicate how networks operate, and helps isolate and troubleshoot networking problems. <br>
OSI was introduced in 1983 by representatives of the major computer and telecom companies, and was adopted by ISO as an international standard in 1984.
The seven layers of the OSI Model is explained as follows: <br>
1.	Physical Layer <br>
2.	Data Link Layer  <br>
3.	Network Layer <br> 
4.	Transport Layer <br>
5.	Session Layer <br>
6.	Presentation Layer<br>
7.	Application Layer<br><br>
![image](https://user-images.githubusercontent.com/109802813/183260500-d60dddb9-c2fb-42be-b8fb-adb3c90b880a.png)


### TCP/IP Model:<br>
The TCP/IP model is a part of the Internet Protocol Suite. This model acts as a communication protocol for computer networks and connects hosts on the Internet. It is a concise version of the OSI Model and comprises four layers in its structure.<br> 
This protocol is a result of the research and development by the Defence Advanced Research Projects Agency (DARPA) during the 1960s.<br>
The four layers of the TCP/IP Model is explained as follows:<br>
1.	Network Interface Layer<br>
2.	Internet Layer<br>
3.	Transport Layer<br>
4.	Application Layer<br>

 ![image](https://user-images.githubusercontent.com/109802813/183260530-8a10a967-ade5-4f4b-b197-96d2c0ea86a6.png)
 TCP/IP Layers
 <br>
![image](https://user-images.githubusercontent.com/109802813/183260535-15cad8dd-1b62-49fd-b32c-7de811c1c462.png)<br>
# SYSTEM DESIGN<br><br>
### Project Perspective:<br>
Every Client Interact With Server Through Sending and receiving various types of data Packets like TCP, UDP etc. So, our program is going to send and receive these packets and show all the necessary details in the form of a graphical user interface and then analyse some predefined patterns and reply back to the user or the senders site and represent those packets in easy and understandable manner In this Project a packet sender is made using socket programming and this tool helps in sending packets to different IP Addresses and to set speed at which I want to send in micro second .<br>

### Project Functions:<br>
Some typical applications of Packet Sender include:<br>
•	Video calling feature can be done with the help of UDP .<br>
•	Troubleshooting network devices that use network servers (send a packet and then analyze the response)<br>
•	Troubleshooting network devices that use network clients (devices that "phone home" via UDP, TCP—Packet Sender can capture these requests)<br>
•	Testing and development of new network protocols (send a packet, see if device behaves appropriately)<br>
•	Automation (via Packet Sender's command-line interface or resend feature)<br>
•	Stress-testing a device (using an intense network generator tool)<br>
•	Sharing/Saving/Collaboration using the Packet Sender Cloud service<br>
Packet Sender comes with a built-in TCP, UDP, and SSL server on multiple ports a user specifies. This remains running listening for packets while sending other packets.<br>

### Flowchart:<br>
Here is the basic socket programming technique that was used to create this Packet Sender in form of a flowchart. <br>
A flowchart is simply a graphical representation of steps. It shows steps in a sequential order, and is widely used in presenting flow of algorithms, workflow or processes. Typically, flowchart shows the steps as boxes of various kinds, and their order by connecting them with arrows.<br>
This flowchart will work for every method we use to send the packets in this project.<br>
<br>
# GUI <br>
## Main GUI:<br>
 ![image](https://user-images.githubusercontent.com/109802813/183260751-fb62729f-713d-482b-94e5-88053b0d25ff.png)

#### 1st Box:<br>
The first box contain 5 button in which the tool button consist of  Intense traffic Generator .<br>
#### 2nd Box:<br>
In this Panel all the information of the receiver end has to be input like name of packet, the string (message) , ASCII code which will be auto generated as per the string in the input , the IP Address , Resend Delay , No of Thread u need (Higher the Number higher the send rate) , Drop down menu (Preferred UDP) , SEND , SAVE and STOP button .<br>
#### 3rd  Box:<br>
In this Panel the information of the receiver saved will be Displayed here . <br>
#### 4th  Box:<br><br>
In this Panel the Data will the other person will send will be displayed in this Panel.<br>
#### 5th  Box:<br>
In this Pannel the Packet Count (Received) , The UDP port for your application, as well as the TCP and SSL port and the Internet Protocol version.<br>
<br>
## Intense Traffic Generator(ITG):<br>
 
The Intense Traffic Generator is used to send the Data or the Message with an Intense Speed in the Intense Traffic Generator after sending the data we can see the speed at which the data is being transferred , the number of Packets which have being transferred the Data sent will be sent with macros so that we are able to identify the order of the data and there is an time count in second which will show the time elapsed .<br>

<br><br>
## New Message with ITG:<br>
![image](https://user-images.githubusercontent.com/109802813/183260801-13820b18-0dbc-4640-a1f6-5b701fedb49e.png)

 The new message is like a Chat Bot which will send a some Particular Patterns along with the Intense Traffic Generator the other end that is the receiver end recognise some particular and then reply them .<br>
<br><br>
## Message receive from Chat Bot:<br>
 ![image](https://user-images.githubusercontent.com/109802813/183260796-79eb448c-2362-4018-8763-7f70235f0e06.png)
In this Panel the message receive when some particular pattern which are sent by the New Message frame are recognised by the receiver and replied back will be visible to the users. <br>
The Packet Sender is able to make P2P that’s Peer to Peer Communication which means both the user are able to send and receive at the same time .<br>
