package com.ot.man.admin.data.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class AdminDTO {
	@NonNull
	private String id;
	private String pw;
}
