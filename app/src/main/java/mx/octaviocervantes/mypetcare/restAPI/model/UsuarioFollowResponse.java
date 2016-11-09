package mx.octaviocervantes.mypetcare.restAPI.model;

public class UsuarioFollowResponse {

    private String codigoRespuesta;
    private String outgoing_status;
    private String target_user_is_private;
    private String incoming_status;

    public UsuarioFollowResponse() {
    }

    public UsuarioFollowResponse(String codigoRespuesta, String incoming_status, String outgoing_status, String target_user_is_private) {
        this.codigoRespuesta = codigoRespuesta;
        this.incoming_status = incoming_status;
        this.outgoing_status = outgoing_status;
        this.target_user_is_private = target_user_is_private;
    }

    public String getCodigoRespuesta() {
        return codigoRespuesta;
    }

    public void setCodigoRespuesta(String codigoRespuesta) {
        this.codigoRespuesta = codigoRespuesta;
    }

    public String getIncoming_status() {
        return incoming_status;
    }

    public void setIncoming_status(String incoming_status) {
        this.incoming_status = incoming_status;
    }

    public String getOutgoing_status() {
        return outgoing_status;
    }

    public void setOutgoing_status(String outgoing_status) {
        this.outgoing_status = outgoing_status;
    }

    public String getTarget_user_is_private() {
        return target_user_is_private;
    }

    public void setTarget_user_is_private(String target_user_is_private) {
        this.target_user_is_private = target_user_is_private;
    }
}
