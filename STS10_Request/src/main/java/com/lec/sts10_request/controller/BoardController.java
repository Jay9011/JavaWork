package com.lec.sts10_request.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

	@RequestMapping(value = "/list")
	public String listBoard() {
		return "board/list_board";
	} // end listBoard()
	
	@RequestMapping(value = "/write")
	public String writeBoard() {
		return "board/write_board";
	} // end writeBoard()
	
	@RequestMapping(value = "/view")
	public String viewBoard() {
		return "board/view_board";
	} // end viewBoard()
	
	@RequestMapping(value = "/update")
	public String updateBoard() {
		return "board/update_board";
	} // end updateBoard()
	
	@RequestMapping(value = "/delete")
	public String deleteBoard() {
		return "board/delete_board";
	} // end deleteBoard()
	
} // end Controller
