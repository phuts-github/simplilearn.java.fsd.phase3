package com.springboot.web.crud.journalentry;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.web.crud.journalentry.controller.JournalEntryController;
import com.springboot.web.crud.journalentry.model.JournalEntry;
import com.springboot.web.crud.journalentry.repository.JournalEntryRepository;

@SpringBootTest
class JournalEntryControllerTests {

	@Mock
	JournalEntryRepository journalEntryRepositoryMock;
	
	@InjectMocks
	JournalEntryController journalEntryControllerMock;
	
//	@Test
//	void contextLoads() {
//	}

	@Test
	void testHome() {
		String result = journalEntryControllerMock.home();
		assertEquals("home.jsp", result);
	}
	
	@Test
	void testAddUpdateJournalEntry() {
		JournalEntry journalEntry = new JournalEntry();
		journalEntry.setId(1);
		journalEntry.setTitle("Vacation");
		journalEntry.setCategory("Travel");
		
//		Mockito.doNothing().when(journalEntryRepositoryMock.save(Mockito.any()));
		
		// Test Save2 - if you saved the save object
		Mockito.when(journalEntryRepositoryMock.save(Mockito.any())).thenReturn(journalEntry);
		
		String result = journalEntryControllerMock.addUpdateJournalEntry(journalEntry);
		
		assertEquals("home.jsp", result);
	}
	
	@Test
	void testGetAllEntries() {
		JournalEntry journalEntry = new JournalEntry();
		journalEntry.setId(1);
		journalEntry.setTitle("Vacation");
		journalEntry.setCategory("Travel");
		
		JournalEntry journalEntry1 = new JournalEntry();
		journalEntry1.setId(2);
		journalEntry1.setTitle("Vacationa");
		journalEntry1.setCategory("Travela");
		
		List<JournalEntry> list = new ArrayList<>();
		list.add(journalEntry);
		list.add(journalEntry1);
		Mockito.when(journalEntryRepositoryMock.findAll()).thenReturn(list);
		ModelAndView resultObj = journalEntryControllerMock.getAllJournalEntries();
		
		assertEquals("getAllEntries.jsp", resultObj.getView().toString());
	}
	
}
