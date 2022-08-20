package com.training.streams;

import java.time.Duration;
import java.util.*;

class PhoneCallExercise {

    public Optional<String> findPhoneNumber(List<PhoneCall> phoneCalls) {

       Map<String, Duration> durations = new HashMap<>();

       phoneCalls.forEach(phoneCall -> {
           durations.compute(phoneCall.getPhoneNumber(), (phoneNumber, total) -> {
               return total == null ? phoneCall.getDuration() : total.plus(phoneCall.getDuration());
           });
       });

       Duration max = durations.values().stream().max(Duration::compareTo).orElse(Duration.ZERO);

       return durations.entrySet().stream().filter(entry -> entry.getValue().equals(max))
               .map(Map.Entry::getKey).min(String::compareTo);


    }

    public static void main(String[] args) {
        PhoneCallExercise exercise = new PhoneCallExercise();
        List<PhoneCall> phoneCalls = Arrays.asList(new PhoneCall("+330677", Duration.ofMinutes(5)),
                new PhoneCall("+330678", Duration.ofMinutes(7)), new PhoneCall("+330677", Duration.ofMinutes(5)));
        final Optional<String> phoneNumber = exercise.findPhoneNumber(phoneCalls);
        if(phoneNumber.isPresent()) {
            System.out.println("found phone number : "+phoneNumber.get());
        } else {
            System.out.println("no phone number found");
        }
    }

}
