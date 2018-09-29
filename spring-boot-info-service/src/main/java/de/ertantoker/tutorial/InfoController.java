package de.ertantoker.tutorial;

import de.ertantoker.tutorial.response.InfoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/info")
public class InfoController {

    @GetMapping
    public ResponseEntity<InfoResponse> getCustomers() {
        InfoResponse infoResponse = new InfoResponse();
        infoResponse.setInfo("Demo Info");
        return new ResponseEntity<>(infoResponse, HttpStatus.OK);
    }
}
