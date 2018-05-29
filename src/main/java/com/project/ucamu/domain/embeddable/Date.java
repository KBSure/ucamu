package com.project.ucamu.domain.embeddable;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Embeddable
public class Date implements Serializable {
    @Column(name = "reg_date")
        private LocalDateTime regDate;
    @Column(name = "up_date")
        private LocalDateTime UpDate;
}
