# feup-mfes
This repository holds a university project for the course MFES (Formal Methods in Software Engineering), inserted in FEUP's (Faculty of Engineering of the University of Porto) Master in Informatics and Computer Engineering.

## What were you tasked with?
> The goal of this practical work is to develop, test and document an executable formal model of a high integrity software system in VDM++ using the Overture tool or the VDMTools. At the end of the work, students should have acquired the ability of formally modeling software systems in VDM++, and of demonstrating the consistency of the model.  

We were assigned with modelling a **distributed printing service**. These were the main requirements:
* Have a **distributed printing queue** based on the **type of document** (B&W, color, A3, A4);
* Printers are placed in different places/clients *(in our abstraction, universities)*;
* Users *(in our case, students)* pay with **account balance**;
* Users may **report malfunctions** with printers and **employees are sent to fix** them;
* Show **reports** with several metrics (e.g. number of documents printed on each printer).

## Which software did you use?
**[Overture](http://overturetool.org/)**. Not the music notation one, the IDE for developing and analysing VDM models.  
It's based on Eclipse.

## What's with the funny looking extensions?
**.vdmpp** is the file extension for the formal specification language **VDM++**.  
VDM stands for **Vienna Development Method** *(fancy)* and is one of the longest-established formal methods for the development of computer-based systems. The ++ variant is simply an extension which supports **modelling of object-oriented** and concurrent **systems**.

## Why not just do it in Java, dummy?
It aims to **reduce the time coding and fixing bugs in exchange for a more careful planning phase**.  
Naturally, it can be generated to Java whenever ([check the generated folder!](https://github.com/aquelemiguel/feup-mfes/tree/master/generated)).  
> Experience with the method suggests that the effort expended on formal modeling and analysis can be recovered in reduced rework costs arising from design errors.  

*Also this course kinda forced us to use it.*

## I need more deets.
Yay, here's the [**full report**](https://github.com/aquelemiguel/feup-mfes/blob/master/docs/dps-report.pdf)!
