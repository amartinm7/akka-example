package com.amm.akka.basic;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;

public class Main {
    public static void main (String args[]){
        ActorSystem system = ActorSystem.create("actorSystem");
        ActorRef readingActor = system.actorOf(ReadingActor.props("readingActor"), "readingActor");
        readingActor.tell( new ReadingActor.ReadLines(4), ActorRef.noSender() );
        readingActor.tell(ReadingActor.Message.HELLO_WORLD, ActorRef.noSender() );
        system.terminate();
    }
}
