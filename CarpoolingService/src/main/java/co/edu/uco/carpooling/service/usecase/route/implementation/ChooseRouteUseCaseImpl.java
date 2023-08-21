package co.edu.uco.carpooling.service.usecase.route.implementation;

import co.edu.uco.carpooling.dto.RouteDTO;
import co.edu.uco.carpooling.service.assembler.entity.EntityAssembler;
import co.edu.uco.carpooling.service.domain.RouteDomain;
import co.edu.uco.carpooling.service.usecase.route.ChooseRouteUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChooseRouteUseCaseImpl implements ChooseRouteUseCase {
    
    @Override
    public void execute(RouteDomain domain) { }
}
