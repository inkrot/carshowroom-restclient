package com.mera.inkrot.restclient.command;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.net.URI;

@ShellComponent
public class ApplicationCommand {

    @ShellMethod("Send request")
    public String request(@ShellOption String text ) {
        WebClient.RequestHeadersSpec<?> requestSpec2 = WebClient
                .create("http://localhost:8080")
                .post()
                .uri(URI.create("/resource"))
                .body(BodyInserters.fromObject("data"));
        // invoke service
        return "[E]"+text+"[E]";
    }
}
