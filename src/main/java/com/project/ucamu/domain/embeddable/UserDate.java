package com.project.ucamu.domain.embeddable;

import javax.persistence.Column;
import java.time.LocalDateTime;

public class UserDate extends Date{
    @Column(name = "situation_start_date")
        private LocalDateTime situationStartDate;
    @Column(name = "situation_end_date")
        private LocalDateTime situationEndDate;
}
