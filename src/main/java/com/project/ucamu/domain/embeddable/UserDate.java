package com.project.ucamu.domain.embeddable;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@Embeddable
public class UserDate implements Serializable {
    @Column(name = "reg_date")
        private LocalDateTime regDate;
    @Column(name = "up_date")
        private LocalDateTime UpDate;
    @Column(name = "situation_start_date")
        private LocalDateTime situationStartDate;
    @Column(name = "situation_end_date")
        private LocalDateTime situationEndDate;
}
