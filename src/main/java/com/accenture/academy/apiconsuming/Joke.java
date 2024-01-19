package com.accenture.academy.apiconsuming;

import lombok.Data;

@Data
class Joke {
    String type;
    String setup;
    String punchline;
    Long id;
}
