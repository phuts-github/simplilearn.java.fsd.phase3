package com.springboot.web.crud.journalentry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.web.crud.journalentry.model.JournalEntry;
import com.springboot.web.crud.journalentry.repository.JournalEntryRepository;

@Controller
public class JournalEntryController {
	
	@Autowired
	private JournalEntryRepository journalEntryRepository;
	
	@RequestMapping("/home") // request mapping path aka url
	public String home() {
		return "home.jsp";
	}
	
	// Basic CRUD Operations
	
	// Create and Update
	@RequestMapping("/addEntry")
	public String addUpdateJournalEntry (JournalEntry journalEntry) {
		
		// save JournalEntry on to the DB. We need the Repository class (i.e. package and class/interface)
		// repository is used to persist data into the DB (perform CRUD operations)
		// Repository already has implementation of the various CRUD operations
//		journalEntryRepository.save(journalEntry);
		
		// Junit Test Save2 - if you saved the save object
		JournalEntry entry = journalEntryRepository.save(journalEntry);
		return "home.jsp";
	}
	
	// Get all journal entries list from DB
	// no parameters requires since we are getting all entries
	@RequestMapping("/getAllEntries")
	public ModelAndView getAllJournalEntries() {
		ModelAndView mv = new ModelAndView();
		
		// Get all entries list from DB
		List<JournalEntry> entries = journalEntryRepository.findAll();
		
		// set the ${entries} on the jsp pages
		mv.addObject("entries", entries);
		mv.setViewName("getAllEntries.jsp");
		return mv;
	}
	
	// Get single journal entry by ID from DB
	// no parameters requires since we are getting all entries
	@RequestMapping("/getEntry")
	public ModelAndView getJournalEntry(@RequestParam int id) {
		ModelAndView mv = new ModelAndView();
		
		// Get all entries list from DB
		JournalEntry entry = journalEntryRepository.findById(id).orElse(new JournalEntry());
				
		// set the ${entry} on the jsp pages
		mv.addObject("entry", entry);
		mv.setViewName("getEntry.jsp");
		return mv;
	}	
	
	// Get single journal entry by ID from DB
	// no parameters requires since we are getting all entries
	@RequestMapping("/delEntry")
	public String delJournalEntry(@RequestParam int id) {
		// Delete entry by id from DB
		//JournalEntry entry = journalEntryRepository.deleteById(id).orElse(new JournalEntry());
		journalEntryRepository.deleteById(id);
				
		return "home.jsp";
	}	
	
}
