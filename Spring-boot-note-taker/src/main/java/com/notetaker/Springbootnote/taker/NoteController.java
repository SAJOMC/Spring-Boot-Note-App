package com.notetaker.Springbootnote.taker;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Random;

@RestController
@RequestMapping("/api")

public class NoteController {
    private List<Note> notes = new ArrayList<>();

    @GetMapping(value = "/notes")
    public List<Note> getAllNotes() {
        return notes;
    }

    @GetMapping("/note/{id}")
    public Note getById(@PathVariable("id") int id) {
        for (Note note : notes) {
            if (note.getId() == id) {
                return note;
            }
        }
        return null;
    }

    @PostMapping("/note")
    public Note create(@RequestBody NoteRequest request) {
        Note note = new Note();
        Random random = new Random();

        note.setId(Math.abs(random.nextInt()));
        note.setText(request.getText());
        note.setTimestamp(new Date().toString());

        notes.add(note);

        return note;
    }

    @PutMapping("/note")
    public Note update(@RequestBody NoteRequest request) {

        for (int i = 0; i < notes.size(); i++) {
            Note note = notes.get(i);
            if (note.getId() == request.getId()) {
                notes.remove(note);
                note.setTimestamp(new Date().toString());
                note.setText(request.getText());
                note.setId(request.getId());
                notes.add(i, note);
                return note;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        for (Note note : notes) {
            if (note.getId() == id) {
                notes.remove(note);
                return "Success";
            }
        }
        return "NOT FOUND";
    }
}

