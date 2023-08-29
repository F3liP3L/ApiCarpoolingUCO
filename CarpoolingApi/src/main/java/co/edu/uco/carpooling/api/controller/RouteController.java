package co.edu.uco.carpooling.api.controller;

import co.edu.uco.carpooling.api.response.Response;
import co.edu.uco.carpooling.api.response.dto.Message;
import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.dto.RouteDTO;
import co.edu.uco.carpooling.service.facade.route.RegisterRouteUseCaseFacade;
import co.edu.uco.crosscutting.exception.GeneralException;
import co.edu.uco.crosscutting.util.UtilObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Objects;

@RestController
@RequestMapping("api/v1/carpooling/route")
public class RouteController {
    @Autowired
    private RegisterRouteUseCaseFacade facade;

    @PostMapping()
    public ResponseEntity<Response<RouteDTO>> create(@RequestBody RouteDTO route){
        Response<RouteDTO> response = new Response<>();
        ResponseEntity<Response<RouteDTO>> responseEntity;
        HttpStatus httpStatus = HttpStatus.CREATED;
        response.setData(new ArrayList<>());
        try {
            facade.execute(route);
            response.addData(route);
            response.addMessage(Message.createSuccessMessage("La ruta ha sido registrada con total exito", "registro de ruta exitoso"));
        } catch (CarpoolingCustomException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            if (!UtilObject.getUtilObject().isNull(exception.getTechnicalMessage())
                    && !Objects.equals(exception.getTechnicalMessage(), exception.getUserMessage())) {
                response.addMessage(Message.createErrorMessage(exception.getTechnicalMessage(),"Technical Message"));
            }

        } catch (GeneralException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createFatalMessage(exception.getUserMessage(), ""));

        }
        responseEntity = new ResponseEntity<Response<RouteDTO>>(response, httpStatus);
        return responseEntity;
    }


}
