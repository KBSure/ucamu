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
public class MiniDate implements Serializable {
    @Column(name = "reg_date")
        private LocalDateTime regDate;
}
