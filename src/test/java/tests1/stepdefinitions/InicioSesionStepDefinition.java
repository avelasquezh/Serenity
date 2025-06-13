package tests1.stepdefinitions;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;

public class InicioSesionStepDefinition {
    private static final String DATA_PROPERTIES = "src/main/resources/properties/data.properties";

    @Before
    public void configuracionInicial(){
        OnStage.setTheStage(new OnLineCast());
        OnStage.theActorCalled(PropiedadesUtils,getValorPropiedades(DATA_PROPERTIES, "actor").trim());
    }
    @Dado ("que inicio sesion en la pagina xxxxx con los datos de sesion")
    public void queInicioSesionEnLaPaginaXxxxxConLosDatosDeSesion(){
        theActorInTheSpotlight().wasAbleTo(AbrirPagina.enElNavegador());
        theActorInTheSpotlight().wasAbleTo(IniciarSesion.enXxxxx());
    }
    @Entonces ("^verifico la ventana de (.*($")
    public void verificoLaVentana(String nombreVentana){
        theActorInTheSpotlight().should(seeThat(VerificarLogin.enPaginaPrincipal(nombreVentana)));
}


}
