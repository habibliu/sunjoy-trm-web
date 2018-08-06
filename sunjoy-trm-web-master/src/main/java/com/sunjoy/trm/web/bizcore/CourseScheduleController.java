package com.sunjoy.trm.web.bizcore;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sunjoy.framework.client.dto.Response;
import com.sunjoy.framework.exception.CommonException;
import com.sunjoy.framework.service.controller.WebController;
import com.sunjoy.framework.utils.DateUtils;
import com.sunjoy.framework.utils.RandomUtils;
import com.sunjoy.trm.bizcore.dao.dto.ScheduleDto;
import com.sunjoy.trm.bizcore.dao.dto.ScheduleStudentDto;
import com.sunjoy.trm.bizcore.dao.dto.ShiftDto;
import com.sunjoy.trm.bizcore.dao.dto.ShiftStudentDto;
import com.sunjoy.trm.bizcore.service.IScheduelService;

@RestController
@RequestMapping(value = "/CourseSchedule")
public class CourseScheduleController extends WebController {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private IScheduelService scheduleService;

	@RequestMapping(value = "/batchAdd", method = RequestMethod.POST)
	public Response batchAddSchedule(@RequestBody List<ScheduleDto> schedules) {
		Response response = new Response();
		List<ShiftDto> shifts = new ArrayList<ShiftDto>();
		for (ScheduleDto schedule : schedules) {

			ShiftDto shift = new ShiftDto();
			shift.setCoachId(schedule.getCoachId());
			shift.setCourseId(schedule.getCourseId());
			shift.setVenueId(schedule.getVenueId());
			shift.setTrainDate(schedule.getTrainDate());
			shift.setTrainTime(Arrays.toString(schedule.getTrainTimeSpan()));
			List<ShiftStudentDto> students = createShiftStudents(schedule.getStudents());
			if (!students.isEmpty()) {
				shift.setStudents(students);
			}
			shifts.add(shift);
			
		}
		scheduleService.batchAddShift(shifts);
		return response;
	}

	
	/**
	 * 根据日期date过滤出当天排班的学员
	 * 
	 * @param students
	 * @param date
	 * @return
	 */
	private List<ShiftStudentDto> createShiftStudents(List<ScheduleStudentDto> students) {
		List<ShiftStudentDto> newList = new ArrayList<ShiftStudentDto>();
		for (ScheduleStudentDto dto : students) {
			ShiftStudentDto shiftStudent = new ShiftStudentDto();
			shiftStudent.setId(RandomUtils.createUUID());
			shiftStudent.setStudentId(dto.getId());
			newList.add(shiftStudent);
		}
		return newList;
	}
}
