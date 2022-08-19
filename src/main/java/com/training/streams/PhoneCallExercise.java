package com.training.streams;

import java.time.Duration;
import java.util.*;

class PhoneCallExercise {

    public Optional<String> solution(List<PhoneCall> phoneCalls) {

       Map<String, Duration> durations = new HashMap<>();

       phoneCalls.forEach(phoneCall -> {
           durations.compute(phoneCall.getPhoneNumber(), (phoneNumber, total) -> {
               return total == null ? phoneCall.getDuration() : total.plus(phoneCall.getDuration());
           });
       });

       Duration max = durations.values().stream().max(Duration::compareTo).get();

       return durations.entrySet().stream().filter(entry -> entry.getValue().equals(max))
               .map(Map.Entry::getKey).min(String::compareTo);


    }

    public static void main(String[] args) {
        PhoneCallExercise exercise = new PhoneCallExercise();
        List<PhoneCall> phoneCalls = Arrays.asList(new PhoneCall("+330677", Duration.ofMinutes(5)),
                new PhoneCall("+330678", Duration.ofMinutes(7)), new PhoneCall("+330677", Duration.ofMinutes(5)));
        System.out.println(exercise.solution(phoneCalls).get());
    }

}
