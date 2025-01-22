package com.example.theOneApp.controllers;

import com.example.theOneApp.entity.Note;
import com.example.theOneApp.entity.User;
import com.example.theOneApp.services.NoteService;
import com.example.theOneApp.services.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/noteController")
public class NoteController {
//    noteService:
    @Autowired
    private NoteService noteService1;
    @Autowired
    private UserService userService1;

//    save note for a user.
    @PostMapping("/{userName}")
    public ResponseEntity<Note> createNote(@RequestBody Note note, @PathVariable String userName){
        User u = userService1.findByUserName(userName);
        if(note != null && u!=null){
            noteService1.saveNote(note,userName);
            return new ResponseEntity<>(note, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

//    get by id
    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable ObjectId id){
        Note n = noteService1.getById(id);
//        System.out.println(n.getClass().getName());
        if(n != null){
            return new ResponseEntity<>(n,HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //    delete note by id.
//    @DeleteMapping("/{userName}/{id}")
//    public ResponseEntity<?> deleteNoteById(@PathVariable String userName,@PathVariable ObjectId id){
//        return noteService1.deleteById(userName,id);
//    }

    //    update note by id.
}
