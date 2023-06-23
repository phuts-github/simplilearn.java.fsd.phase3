package com.springboot.web.crud.journalentry.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.web.crud.journalentry.model.JournalEntry;

//public JournalEntryRepository { 
public interface JournalEntryRepository extends JpaRepository<JournalEntry, Integer> {

}
