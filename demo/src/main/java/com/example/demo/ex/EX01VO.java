package com.example.demo.ex;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@NoArgsConstructor
public class EX01VO {
	private String username;
	private String password;
	private List<String> hobby;
}
