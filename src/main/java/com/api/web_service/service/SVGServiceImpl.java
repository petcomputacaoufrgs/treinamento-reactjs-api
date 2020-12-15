package com.api.web_service.service;

import com.api.web_service.enumerable.SvgEnum;
import com.api.web_service.model.SvgResponseModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

public class SVGServiceImpl {

    public static ResponseEntity<SvgResponseModel> getSVG() {
        return new ResponseEntity<>(new SvgResponseModel(SvgEnum.ORCA.getId(), SvgEnum.ORCA.getValue()), HttpStatus.OK);
    }

    public static ResponseEntity<ArrayList<SvgResponseModel>> getSVGAll() {

        ArrayList<SvgResponseModel> response = new ArrayList<>();

        for (SvgEnum enumerable : SvgEnum.values() ) {
            response.add(new SvgResponseModel(enumerable.getId(), enumerable.getValue()));
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /*
    public static ResponseEntity<String> getSVG() {
        String svg = SvgEnum.ORCA.getValue();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf("image/enumerable+xml"));
        return new ResponseEntity<>(svg, headers, HttpStatus.OK);
    }


    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public @ResponseBody Greeting greeting() throws IOException {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
    */
}
