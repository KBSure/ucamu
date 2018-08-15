package com.project.ucamu.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter @Setter
public class UserFormDto {
    @NotBlank
    @Size(max = 15, message = "15자 이하로 작성해주세요.")
    String idName;
    @NotBlank
    @Pattern(regexp="([a-zA-Z0-9].*){8,20}"
            ,message="숫자 영문자를 포함한 8 ~ 20자를 입력하세요. ")
    String password;
    @NotBlank
    @Pattern(regexp="([a-zA-Z0-9].*){8,20}"
            ,message="숫자 영문자를 포함한 8 ~ 20자를 입력하세요. ")
    String rePassword;
    @NotBlank
    @Size(max = 8, message = "8자 이하로 작성해주세요.")
    String nickName;
    @NotBlank
    @Size(min= 2, max = 10, message = "2자에서 10자 사이의 값만 가능합니다.")
    String name;
    @NotBlank
    @Size(max = 45, message = "45자 이하로 작성해주세요.")
    String email;
    @NotBlank
    @Pattern(regexp="(^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$)", message = "010-0000-0000형식으로 입력해 주세요.")
    String phone;
}
