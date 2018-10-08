package com.amm.akka.basic;

import akka.actor.AbstractActor;
import akka.actor.Props;

public class ReadingActor extends AbstractActor {
    private final String text;
    public ReadingActor(String text){
        super();
        this.text = text;
    }
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(ReadLines.class, message -> {
                    System.out.println("readlines... " + message.num);
                }).match(Message.HELLO_WORLD.getClass(), message -> {
                    System.out.println("hello world... " + message.toString());
                    //getSender().tell(AnotherActor.Message.RECIEVE, getSelf());
                }).build();
    }

    public static Props props(String text){
        return Props.create(ReadingActor.class, text);
    }

    public static class ReadLines{
        public final Integer num;
        public ReadLines(Integer num){
           this.num = num;
        }
    }

    public enum Message {
        HELLO_WORLD;
    }

}