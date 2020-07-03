package com.lec.sts19_rest.board.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.board.beans.BWriteDTO;
import com.lec.sts19_rest.board.beans.EmployeeListVO;
import com.lec.sts19_rest.board.beans.EmployeeVO;
import com.lec.sts19_rest.board.beans.IWriteDAO;

@RestController
@RequestMapping("/MyRest")
public class MyRestController {
	@RequestMapping("/")
	public String helloTEST() {
		return "Hello REST";
	} // end helloTEST()
	
	@RequestMapping("/helloJSON")
	public BWriteDTO helloJSON() {
		BWriteDTO dto = new BWriteDTO(100, "안녕하세요", "윤종섭입니다", "윤종섭", 1, new Timestamp(10000));
		
		return dto;
	} // end helloJSON()
	
	/**
	 * JSON 데이터 <-- 자바 List<>
	 * @return
	 */
	@RequestMapping("/listJSON")
	public List<BWriteDTO> listJSON(){
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		return dao.select();
	} // end listJSON()

	/**
	 * JSON 데이터 <-- 자바 배열
	 * @return
	 */
	@RequestMapping("/arrJSON")
	public BWriteDTO[] arrJSON() {
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		List<BWriteDTO> list = dao.select();
		BWriteDTO[] arr = new BWriteDTO[list.size()];
		return list.toArray(arr);
	} // end arrJSON()
	
	/**
	 * JSON 데이터 <-- 자바 Map<K, V>
	 * @return
	 */
	@RequestMapping("/mapJSON")
	public Map<Integer, BWriteDTO> mapJSON(){
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		List<BWriteDTO> list = dao.select();
		
		Map<Integer, BWriteDTO> map = new HashMap<>();
		
		for (BWriteDTO dto : list) {
			map.put(dto.getUid(), dto);
		}
		
		return map;
	} // end mapJSON()

	/**
	 * XML 데이터 <-- 자바 객체
	 * @return
	 */
	@RequestMapping("/helloXML")
	public EmployeeVO helloXML() {
		return
				new EmployeeVO(100, "윤종섭", 13, new int[] {100, 100, 100}, 300);
	} // end helloXML()
	
	/**
	 * XML 데이터 <-- 자바 List<>
	 * @return
	 */
	@RequestMapping("/listXML")
	public EmployeeListVO listXML() {
		EmployeeListVO employees = new EmployeeListVO();
		
		EmployeeVO emp1 = new EmployeeVO(100, "윤종섭", 13, new int[] {100, 100, 100}, 100.0);
		EmployeeVO emp2 = new EmployeeVO(101, "마유", 10, new int[] {97, 85, 95}, 95.8);
		EmployeeVO emp3 = new EmployeeVO(102, "제이", 8, new int[] {78, 85, 100}, 87.4);
		
		employees.getEmployees().add(emp1);
		employees.getEmployees().add(emp2);
		employees.getEmployees().add(emp3);
		
		return employees;
	} // end listXML()
	
	@RequestMapping("/read/{uid}")
	public ResponseEntity<BWriteDTO> read(@PathVariable("uid") int uid) {
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		BWriteDTO dto = dao.selectByUid(uid);
		
		// 실패 처리
		if(dto == null) return new ResponseEntity<BWriteDTO>(HttpStatus.NOT_FOUND);	// 404
		
		// 성공 처리
		return new ResponseEntity<BWriteDTO>(dto, HttpStatus.OK);	// 200
		
	} // end read()
	
} // end RestController
