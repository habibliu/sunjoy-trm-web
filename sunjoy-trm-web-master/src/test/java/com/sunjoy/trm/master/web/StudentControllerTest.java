package com.sunjoy.trm.master.web;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jsonzou.jmockdata.JMockData;
import com.github.jsonzou.jmockdata.MockConfig;
import com.sunjoy.common.utils.RandomUtils;
import com.sunjoy.trm.master.config.AbstractUnitTestSupport;
import com.sunjoy.trm.master.dao.criteria.StudentCriteria;
import com.sunjoy.trm.master.vo.StudentVo;

public class StudentControllerTest extends AbstractUnitTestSupport {

	private MockConfig mockConfig;

	@Before
	@Override
	public void setup() {
		super.setup();
		mockConfig = new MockConfig().byteRange((byte) 0, Byte.MAX_VALUE).shortRange((short) 0, (short) 2)
				.intRange(100, 180).floatRange(0.0f, Float.MAX_EXPONENT).doubleRange(0.0, Double.MAX_VALUE)
				.longRange(0, Long.MAX_VALUE).dateRange("2000-01-01", "2015-12-30").sizeRange(5, 10)
				// .stringSeed("a", "b", "c")
				.charSeed((char) 97, (char) 98);
	}

	@Test
	public void testListStudentByPage() {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			StudentCriteria criteria = new StudentCriteria();
			MvcResult result = mockMvc
					.perform(MockMvcRequestBuilders.get("/Student/listPage").contentType(MediaType.APPLICATION_JSON)
							.param("params", objectMapper.writeValueAsString(criteria)))
					.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print()).andReturn();
			logger.debug("testListStudentByPage's result:\n{}", result.toString());
		} catch (Exception e) {
			this.handleException(e);
		}
	}

	@Test
	public void testListStudent() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetStudent() {
		fail("Not yet implemented");
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testAddStudent() {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			StudentVo student = JMockData.mock(StudentVo.class, mockConfig);
			mockMvc
					.perform(MockMvcRequestBuilders.post("/Student/add").contentType(MediaType.APPLICATION_JSON)
							.content(objectMapper.writeValueAsString(student)))
					.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print()).andReturn();
		} catch (Exception e) {
			this.handleException(e);
		}
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testUpdateStudent() {
		try {
			//step1, add new record
			ObjectMapper objectMapper = new ObjectMapper();
			StudentVo student = JMockData.mock(StudentVo.class, mockConfig);
			student.setId( RandomUtils.createUUID());
			mockMvc
					.perform(MockMvcRequestBuilders.post("/Student/add").contentType(MediaType.APPLICATION_JSON)
							.content(objectMapper.writeValueAsString(student)))
					.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print()).andReturn();
			//step2, update the record
			student.setName("Rober");
			mockMvc
			.perform(MockMvcRequestBuilders.post("/Student/update").contentType(MediaType.APPLICATION_JSON)
					.content(objectMapper.writeValueAsString(student)))
			.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print()).andReturn();
			
			//step3,prove the change effive
			
			StudentCriteria criteria = new StudentCriteria();
			criteria.setId(student.getId());
			MvcResult result = mockMvc
					.perform(MockMvcRequestBuilders.get("/Student/get").contentType(MediaType.APPLICATION_JSON)
							.param("params", objectMapper.writeValueAsString(criteria)))
					.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print()).andReturn();
			String resultString=result.getResponse().getContentAsString();
			assertTrue(resultString.indexOf("Rober")>0);
			logger.debug("testUpdateStudent result:\n{}", resultString.toString());
		} catch (Exception e) {
			this.handleException(e);
		}
	}

}
