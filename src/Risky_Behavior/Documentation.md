# java-journey

A code journal documenting my Java programming journey through practical examples and projects.

## Table of Contents

- [Music Machine](#music-machine)
- [Exception handling](#exception-handling)
  - [When things might go wrongs](#when-things-might-go-wrongs)
  - [Exception are object](#exception-are-object)
  - [Checked and unchecked exceptions](#checked-and-unchecked-exceptions)
  - [Bullet Points](#bullet-points)
  - [Flow control in try catch block](#flow-control-in-try-catch-block)
  - [Polymorphic exceptions](#polymorphic-exceptions)
  - [Order of multiple catch blocks](#order-of-multiple-catch-blocks)
  - [Handle or declare](#handle-or-declare)
- [Music Machine : Fixing the sequencer code](#music-machine-fixing-the-sequencer-code)

## Music Machine

_JavaSound_ is a collection of classes and interfaces added to Java way back in version 1.3.JavaSound is split into two parts: MIDI and Sampled.MIDI stands for Musical Instrument Digital Interface. it does include the instructions that a MIDI-reading instrument can play back.

## Exception handling

First we need a Sequencer

The sequencer is the object that takes all the MIDI data and sends it to the right instruments.

```
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequencer;

public class MusicTest1 {

    public void play() {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            System.out.println("Successefully got a sequencer");
        }
    }

    public static void main(String[] args) {

        MusicTest1 mt = new MusicTest1();
        mt.play();
    }
}
```

compile error:

![Alt text](../../ressources/Exception_handling1.jpg "Compile error")

**What happens when a method you want to call (probably in a class you didn’t write) is risky?**

1- Let’s say you want to call a method in a class that you didn’t write.

![Alt text](../../ressources/Risky_method1.jpg "Risky method : Step 1")

2- That method does something risky, something that might not work at runtime.

![Alt text](../../ressources/Risky_method2.jpg "Risky method : Step 2")

3- You need to know that the method you’re calling is risky.

![Alt text](../../ressources/Risky_method3.jpg "Risky method : Step 3")

4- You then write code that can handle the failure if it does happen. You need to be prepared, just in case.

![Alt text](../../ressources/Risky_method4.jpg "Risky method : Step 4")

### When things might go wrongs

**Methods in Java use exceptions to tell the calling code,“Something Bad Happened. I failed.”**
Java’s exception-handling mechanism is a clean, well-lighted way to handle “exceptional situations” that pop up at runtime; it lets you put all your error-handling code in one easy-toread place. It’s based on the method you’re calling telling you it’s risky

So, how does a method tell you it might throw an exception? You find a throws clause in the
risky method’s declaration.

The getSequencer() method takes a risk. It can fail at runtime. So it must “declare” the risk you take when you call it.

![Alt text](../../ressources/getSequencer_method_declaration.jpg "getSequencer() Method declaration")
1- The API docs tell you that getSequencer() can throw an exception: MidiUnavailableException. A method has to declare the exceptions it might throw

2- This part tells you WHEN you might get that exception—in this case, because of resource restrictions (which could mean the sequencer is already being used).

_Risky methods that could fail at runtime declare the exceptions that might happen using “throws SomeKindOfException” on their method declaration._

**The compiler needs to know that YOU know you’re calling a risky method**
If you wrap the risky code in something called a try/catch, the compiler will relax. A try/catch block tells the compiler that you know an exceptional thing could happen in the method you’re calling, and that you’re prepared to handle it. That compiler doesn’t care how you handle it; it cares only that you say you’re taking care of it.

```
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;

public class MusicTest2 {

    public void play() {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            System.out.println("Successefully got a sequencer");
        } catch (MidiUnavailableException e) {
            System.out.println("Bummer");
        }
    }

    public static void main(String[] args) {

        MusicTest2 mt = new MusicTest2();
        mt.play();
    }
}
```

Put the risky thing in a “try” block. It's the “risky" getSequencer method that might throw an exception.

Make a “catch” block for what to do if the exceptional situation happens—in other words, a MidiUnavailableException is thrown by the call to getSequencer().

### Exception are object

_An exception is an object... of type Exception_

![Alt text](../../ressources/Exception_objet.jpg "Exception are objet")

Because an Exception is an object, what you catch is an object. In the following code, the catch argument is declared as type Exception, and the parameter reference variable is ex.

![alt text](../../ressources/TryCatchBlock.jpg "Try Catch Block")

**If it’s your code that catches the exception, then whose code throws it?**

### Checked and unchecked exceptions

To Do

### Bullet Points

To Do

### Flow control in try catch block

To Do

### Polymorphic exceptions

To Do

### Order of multiple catch blocks

To Do

### Handle or declare

To Do

## Music Machine : Fixing the sequencer code

To DO

![Alt text](../../ressources/FileWriter.jpg "File Writer Class")
