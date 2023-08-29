package co.edu.uco.carpooling.api.controller;

import co.edu.uco.carpooling.dto.StatusDTO;
import co.edu.uco.carpooling.service.usecase.status.FillStatusUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/carpooling/status")
public class StatusController {
    @Autowired
    private FillStatusUseCase fillStatusUseCase;

    @GetMapping()
    public List<StatusDTO> fillStatus(){
        return fillStatusUseCase.execute();
    }
}
