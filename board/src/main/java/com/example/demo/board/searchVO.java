package com.example.demo.board;

import lombok.Data;

@Data
public class searchVO {
	int start = 1;
	int end = 10;
	
	int[] boardNos;
}
