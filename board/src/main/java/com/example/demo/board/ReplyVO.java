package com.example.demo.board;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ReplyVO {
	private Long rno;
	private Long bno;
	
	private String reply;
	private String replyer;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date replyDate;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date updateDate;
}
