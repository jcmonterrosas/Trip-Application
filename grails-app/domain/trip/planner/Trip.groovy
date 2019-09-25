package trip.planner

class Trip {

    String destino
    String espectativas
    String actividades
    Integer cantidadDias
    Date diaInicio
    Date diaFin   

    static constraints = {
        actividades widget: 'textarea'
        espectativas nullable: true, widget: 'textarea'
        diaInicio nullable: true
        diaFin nullable: true
    }
}
