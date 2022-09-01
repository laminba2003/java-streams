package com.training.streams;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Duration;

@AllArgsConstructor
@Data
class PhoneCall {

    String phoneNumber;
    Duration duration;

}
