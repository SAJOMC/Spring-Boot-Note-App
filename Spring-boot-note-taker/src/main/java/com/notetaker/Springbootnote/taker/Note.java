package com.notetaker.Springbootnote.taker;

public class Note {
 private int id;
 private String timestamp;
 private String text;

 public int getId() {return id;}

public void setId(int id) {this.id = id;}

public String getTimestamp() {return timestamp;}

public void setTimestamp(String timestamp) {this.timestamp = timestamp;}

public String getText() {return text;}

public void setText(String text) {this.text = text;}
}