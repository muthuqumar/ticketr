package com.cloudbees.ticketr.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AllocateRequest {
    private Long userId;
    private Long seatId;
    private Long tariffId;
}
