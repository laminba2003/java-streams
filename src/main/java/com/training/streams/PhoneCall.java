package com.training.streams;

import java.time.Duration;

class PhoneCall {

    private String phoneNumber;
    private Duration duration;

    public PhoneCall(String phoneNumber, Duration duration) {
        this.phoneNumber = phoneNumber;
        this.duration = duration;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Duration getDuration() {
        return duration;
    }
}
