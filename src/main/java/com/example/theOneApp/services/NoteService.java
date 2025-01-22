package com.example.theOneApp.services;

import com.example.theOneApp.entity.Note;
import com.example.theOneApp.entity.User;
import com.example.theOneApp.repositories.NoteRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class NoteService {

    @Autowired
    private NoteRepository noteRepository1;

    @Autowired
    private UserService userService1;


//    save note for user.
    public void saveNote(Note note, String userName){
        User user = userService1.findByUserName(userName);
        Note justSaved = noteRepository1.save(note);
        user.getNotes().add(justSaved);
        userService1.saveUser(user);
    }
//    get note by id.
    public Note getById(ObjectId id){
        return noteRepository1.findByid(id);
    }
//    delete note by id.
//    public ResponseEntity<?> deleteById(String userName,ObjectId id){
//        User u = userService1.findByUserName(userName);
//
//        for(Note n:u.getNotes()){
//            if(n.getId() == id){
//                u.getNotes().remove(n);
//                return new ResponseEntity<>(HttpStatus.CONTINUE);
//            }
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//    update note by id.

//
}
