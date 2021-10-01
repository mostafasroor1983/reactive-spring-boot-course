package com.reactive.spring.boot;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class MonoTest {
    @Test
    public void monoTest(){
        Mono<String> springMono = Mono.just("Spring");
        StepVerifier.create(springMono.log())
                .expectNext("Spring")
                .verifyComplete();
    }

    @Test
    public void monoTest_Error(){
        StepVerifier.create(Mono.error(new RuntimeException("Exception Occured")).log())
                .expectError(RuntimeException.class)
                .verify();
    }
}
