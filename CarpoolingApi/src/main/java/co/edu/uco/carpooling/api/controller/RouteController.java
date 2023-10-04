package co.edu.uco.carpooling.api.controller;

import co.edu.uco.carpooling.api.response.Response;
import co.edu.uco.carpooling.api.response.dto.Message;
import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.dto.RouteDTO;
import co.edu.uco.carpooling.service.assembler.dto.DTOAssembler;
import co.edu.uco.carpooling.service.domain.RouteDomain;
import co.edu.uco.carpooling.service.facade.route.RegisterRouteUseCaseFacade;
import co.edu.uco.carpooling.service.model.Position;
import co.edu.uco.carpooling.service.port.route.ServiceRoutePort;
import co.edu.uco.crosscutting.exception.GeneralException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Objects;

import static co.edu.uco.crosscutting.util.UtilObject.getUtilObject;

@RestController
@RequestMapping("api/v1/carpooling/route")
@Slf4j
public class RouteController {
    @Autowired
    private RegisterRouteUseCaseFacade facade;
    @Autowired
    private ServiceRoutePort routePort;
    @Autowired
    private DTOAssembler<RouteDomain, RouteDTO> dtoAssembler;
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
            log.info(response.toString());
        } catch (CarpoolingCustomException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createErrorMessage(exception.getUserMessage(), "Error Created a Route"));
            if (!getUtilObject().isNull(exception.getTechnicalMessage())
                    && !Objects.equals(exception.getTechnicalMessage(), exception.getUserMessage())) {
                response.addMessage(Message.createErrorMessage(exception.getTechnicalMessage(), "Technical Message"));
            }
            log.warn(response.toString());

        } catch (GeneralException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createFatalMessage(exception.getUserMessage(), "The Unexpected errors "));
            log.warn(response.toString());
        }
        responseEntity = new ResponseEntity<>(response, httpStatus);
        return responseEntity;
    }

    @GetMapping()
    public ResponseEntity<Response<RouteDTO>> getRoutes(){
        Response<RouteDTO> response = new Response<>();
        ResponseEntity<Response<RouteDTO>> responseEntity;
        HttpStatus httpStatus = HttpStatus.CREATED;
        response.setData(new ArrayList<>());
        try {
            RouteDomain route = routePort.buildRoute(new Position("", ""), new Position("", ""));
            response.addData(dtoAssembler.assembleDto(route));
            response.addMessage(Message.createSuccessMessage("La ruta ha sido registrada con total exito", "registro de ruta exitoso"));
            log.info(response.toString());
        } catch (CarpoolingCustomException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createErrorMessage(exception.getUserMessage(), "Error Created a Route"));
            if (!getUtilObject().isNull(exception.getTechnicalMessage())
                    && !Objects.equals(exception.getTechnicalMessage(), exception.getUserMessage())) {
                response.addMessage(Message.createErrorMessage(exception.getTechnicalMessage(), "Technical Message"));
            }
            log.warn(response.toString());
        }
        responseEntity = new ResponseEntity<>(response, httpStatus);
        return responseEntity;
    }


}
