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
import com.sunjoy.trm.master.config.AbstractUnitTestSupport;
import com.sunjoy.trm.master.dao.criteria.CoachCriteria;
import com.sunjoy.trm.master.vo.CoachVo;

public class CoachControllerTest extends AbstractUnitTestSupport{

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
	public void testListCoachByPage() {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			CoachCriteria criteria = new CoachCriteria();
			MvcResult result = mockMvc
					.perform(MockMvcRequestBuilders.get("/Coach/listPage").contentType(MediaType.APPLICATION_JSON)
							.param("params", objectMapper.writeValueAsString(criteria)))
					.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print()).andReturn();
			logger.debug("testListCoachByPage's result:\n{}", result.toString());
		} catch (Exception e) {
			this.handleException(e);
		}
	}

	@Test
	public void testListCoach() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCoach() {
		fail("Not yet implemented");
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testAddCoach() {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			CoachVo coach = JMockData.mock(CoachVo.class, mockConfig);
			mockMvc
					.perform(MockMvcRequestBuilders.post("/Coach/add").contentType(MediaType.APPLICATION_JSON)
							.content(objectMapper.writeValueAsString(coach)))
					.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print()).andReturn();
		} catch (Exception e) {
			this.handleException(e);
		}
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testUpdateCoach() {
		fail("Not yet implemented");
	}
}
