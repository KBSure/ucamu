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
public class NormalDate implements Serializable {

    public NormalDate(){
    }

    public NormalDate(LocalDateTime regDate, LocalDateTime upDate){
        this.regDate = regDate;
        this.upDate = upDate;
    }

    @Column(name = "reg_date")
        private LocalDateTime regDate;
    @Column(name = "up_date")
        private LocalDateTime upDate;
}
