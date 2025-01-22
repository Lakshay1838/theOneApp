package com.example.theOneApp.repositories;

import com.example.theOneApp.entity.Note;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoteRepository extends MongoRepository<Note, ObjectId> {
    Note findByid(ObjectId id);
}
