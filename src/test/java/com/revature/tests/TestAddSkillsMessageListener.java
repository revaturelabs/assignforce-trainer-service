package com.revature.tests;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.mockito.Mockito;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.assignforce.beans.SkillIdHolder;
import com.revature.assignforce.messaging.listeners.AddSkillsMessageListener;
import com.revature.assignforce.repos.SkillRepository;


public class TestAddSkillsMessageListener {
	
	@Test
	public void TestAddSkillsMessageListenerConstructure() {
		SkillRepository skillRepository = Mockito.mock(SkillRepository.class);
		
		AddSkillsMessageListener addSkillsMessageListener = new AddSkillsMessageListener(skillRepository);
		
		
		assertNotNull(addSkillsMessageListener);
		//verify(skillRepository, times(2));
		//Warning , the line up above breaks a test called updateTest() in the CertServiceImplTest.java if uncommented.
	}
	
	@Test
	public void TestReceive() throws Exception {
		SkillRepository skillRepository = Mockito.mock(SkillRepository.class);
		
		AddSkillsMessageListener addSkillsMessageListener = new AddSkillsMessageListener(skillRepository);
		
		//String message = "True";
		//The error you will receive if the line above is uncommented
		//"Unrecognized token 'True': was expecting ('true', 'false' or 'null')"
		
		String message = "true";
		
		//String message = Mockito.mock(String.class);
		//MyList listMock = Mockito.mock(MyList.class);
		//when(listMock.add(anyString())).thenReturn(false);
		
		//Map<String, String> messageMap = Mockito.mock(Map.class);
		
		Map<String, String> messageMap =new HashMap<String, String>();
		
		SkillIdHolder skillIdHolder = new SkillIdHolder(1);
		
		//ObjectMapper objectMapper = new ObjectMapper();
		messageMap.put("Message", "hello");
		
		//doNothing().when(new ObjectMapper().readValue(message, Map.class));//.thenReturn(messageMap);
		
		//new ObjectMapper().readValue(message, Map.class);
		
		//Mockito.doNothing().when(trainerRepository).deleteById(44);
		
		addSkillsMessageListener.receive(message);
		
		
		
		
	}

}
