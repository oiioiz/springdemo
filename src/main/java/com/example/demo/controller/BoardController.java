package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Board;

import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping("/boards")
public class BoardController {
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<Board>> list(){
		log.info("list");
		
		List<Board> boardList = new ArrayList<>();
		
		Board board = new Board();
		
		board.setBoardNo(1);
		board.setTitle("가");
		board.setContent("가나");
		board.setWriter("가나다1");
		board.setRegDate(new Date());
		
		boardList.add(board);
		
		board = new Board();
		
		board.setBoardNo(1);
		board.setTitle("a");
		board.setContent("ab");
		board.setWriter("abcd");
		board.setRegDate(new Date());
		
		boardList.add(board);
		
		
		ResponseEntity<List<Board>> entity = new ResponseEntity<>(boardList, HttpStatus.OK);
				
		return entity;
	}
	
	@RequestMapping(value="", method = RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody Board board){
		log.info("register");
		
		ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		
		return entity;
	}

}
