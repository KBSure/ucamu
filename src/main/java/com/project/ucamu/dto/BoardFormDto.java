package com.project.ucamu.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter @Setter
public class BoardFormDto {
    @Size(max = 255, message = "255자 이하로 작성해주세요.")
        String who;
    @Size(max = 255, message = "255자 이하로 작성해주세요.")
        String when;
    @Size(max = 255, message = "255자 이하로 작성해주세요.")
        String where;
    @Size(max = 255, message = "255자 이하로 작성해주세요.")
        String what;
    @Size(max = 255, message = "255자 이하로 작성해주세요.")
        String how;
    @Size(max = 255, message = "255자 이하로 작성해주세요.")
        String why;


}
